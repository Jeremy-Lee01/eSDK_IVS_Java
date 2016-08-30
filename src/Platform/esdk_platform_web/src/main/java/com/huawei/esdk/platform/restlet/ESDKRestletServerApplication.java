package com.huawei.esdk.platform.restlet;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Application;

import org.apache.commons.digester3.Digester;
import org.apache.log4j.Logger;
import org.restlet.Context;
import org.restlet.data.ChallengeScheme;
import org.restlet.ext.crypto.DigestAuthenticator;
import org.restlet.ext.jaxrs.JaxRsApplication;
import org.restlet.security.Authenticator;
import org.restlet.security.ChallengeAuthenticator;
import org.restlet.security.MapVerifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.xml.sax.SAXException;

import com.huawei.esdk.platform.common.bean.config.UserConfig;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.usermgr.itf.IUserManager;

public class ESDKRestletServerApplication extends JaxRsApplication
{
    private static final Logger LOGGER = Logger.getLogger(ESDKRestletServerApplication.class);
    
    private static final String AUTH_METHOD_BASIC = "Basic";
    
    private static final String AUTH_METHOD_DIGEST = "Digest";
    
    private IUserManager userManager = ApplicationContextUtil.getBean("userManager");
    
    @SuppressWarnings("unchecked")
    public ESDKRestletServerApplication(Context context)
    {
        super(context);
        
        Class<Application> clazz;
        Constructor<Application> constructor;
        for (ApplicationBean item : getApplicationClasses())
        {
            try
            {
            	LOGGER.debug("Now loading class " + item.getApplicationClass());
                clazz = (Class<Application>)Class.forName(item.getApplicationClass());
                constructor = clazz.getConstructor();
                
                add(constructor.newInstance());
            }
            catch (ClassNotFoundException e)
            {
                LOGGER.error("", e);
            }
            catch (NoSuchMethodException e)
            {
                LOGGER.error("", e);
            }
            catch (SecurityException e)
            {
                LOGGER.error("", e);
            }
            catch (IllegalArgumentException e)
            {
                LOGGER.error("", e);
            }
            catch (InstantiationException e)
            {
                LOGGER.error("", e);
            }
            catch (IllegalAccessException e)
            {
                LOGGER.error("", e);
            }
            catch (InvocationTargetException e)
            {
                LOGGER.error("", e);
            }
        }
        
        //Set Authenticator
        Authenticator auth = createAuthenticator();
        if (null != auth)
        {
            setAuthenticator(auth);
        }
    }
    
    @SuppressWarnings("unchecked")
    private List<ApplicationBean> getApplicationClasses()
    {
        List<ApplicationBean> result = new ArrayList<ApplicationBean>();
        try
        {
            Digester digest = new Digester();
            digest.setValidating(false);
            digest.addObjectCreate("applications", ArrayList.class);
            digest.addObjectCreate("applications/application", ApplicationBean.class);
            digest.addBeanPropertySetter("applications/application", "applicationClass");
            digest.addSetNext("applications/application", "add");
            
            //Read configuration file
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath*:META-INF/rest_app*.xml");
            LOGGER.info("##############application count:" + resources.length);
            for (Resource resource : resources)
            {
                LOGGER.debug(resource.getFilename());
                result.addAll((List<ApplicationBean>)digest.parse(resource.getURL()));
            }
        }
        catch (IOException e)
        {
            LOGGER.error("Load Rest Application failed.", e);
        }
        catch (SAXException e)
        {
            LOGGER.error("Load Rest Application failed.", e);
        }
        
        return result;
    }
    
    private Authenticator createAuthenticator()
    {
        MapVerifier verifier = new MapVerifier();
        //TODO zhili how to refresh user
        for (UserConfig item : userManager.getUserList())
        {
            verifier.getLocalSecrets().put(item.getUserId(), item.getPassword().toCharArray());
        }
        
        String authMethod = ConfigManager.getInstance().getValue("authentication.method.rest");
        
        if (AUTH_METHOD_BASIC.equalsIgnoreCase(authMethod))
        {
            ChallengeAuthenticator authenticator =
                new ChallengeAuthenticator(getContext(), ChallengeScheme.HTTP_BASIC, "Huawei eSDK Realm");
            authenticator.setVerifier(verifier);
            return authenticator;
        }
        else if (AUTH_METHOD_DIGEST.equalsIgnoreCase(authMethod))
        {
            DigestAuthenticator authenticator =
                new DigestAuthenticator(getContext(), "Huawei eSDK Realm", "eSDK Server Key");
            authenticator.setWrappedVerifier(verifier);
            return authenticator;
        }
        else
        {
            LOGGER.warn("Authentication method " + authMethod + " is invalid");
            return null;
        }
    }
}
