package com.huawei.esdk.platform.business.professional.key;

import java.security.interfaces.RSAPublicKey;

import com.huawei.esdk.platform.cipher.itf.CipherMgr;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.common.utils.Base64Utils;
import com.huawei.esdk.platform.common.utils.BytesUtils;
import com.huawei.esdk.platform.common.utils.RSA2048Utils;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.platform.constants.InfoKeys;
import com.huawei.esdk.platform.session.itf.ISessionMgr;

/**
 * 录像管理模块
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class KeyService
{
    
    private static KeyService instance = new KeyService();
    
    private CipherMgr cipherMgr = ApplicationContextUtil.getBean("cipherMgr");
    
    private ISessionMgr sessionMgr = ApplicationContextUtil.getBean("sessionMgrC50");
    
    private KeyService()
    {
    }
    
    public static KeyService getInstance()
    {
        return instance;
    }
    
    public void updateSystemKey()
        throws Exception
    {
        cipherMgr.updateSystemKey();
    }
    
    public void updatePrivateKey()
        throws Exception
    {
        cipherMgr.updatePrivateKey();
    }
    
    public String getPublicKey()
    {
        RSAPublicKey publicKey = cipherMgr.getPublicKey();
        if (null != publicKey)
        {
            return Base64Utils.encode(publicKey.getEncoded());
        }
        else
        {
            return null;
        }
    }
    
    public SDKErrorCode setSecretKey(String secretType, String secretKey, String iv)
    {
        SDKErrorCode result = new SDKErrorCode();
        if (StringUtils.isEmpty(secretType) || ESDKConstant.AES128.equals(secretType))
        {
            if (!StringUtils.isEmpty(secretKey) && !StringUtils.isEmpty(iv))
            {
                secretKey = RSA2048Utils.decodeFromBase64(secretKey);
                iv = RSA2048Utils.decodeFromBase64(iv);
                if (StringUtils.isEmpty(secretKey) || StringUtils.isEmpty(iv))
                {
                    result.setErrCode(ESDKErrorCodeConstant.SECRETKEY_DECODE_ERRORCODE);
                    return result;
                }
                
                if (ESDKConstant.AES128_KEY_LENGTH == secretKey.length()
                    && ESDKConstant.AES128_IV_LENGTH == iv.length())
                {
                    MessageContext mc = ThreadLocalHolder.get();
                    String sdkSession = (String)mc.getEntities().get(InfoKeys.SDK_SESSION_ID.toString());
                    sessionMgr.saveSecretKey(sdkSession,
                        BytesUtils.hexStringToBytes(secretKey),
                        BytesUtils.hexStringToBytes(iv));
                }
                else
                {
                    result.setErrCode(ESDKErrorCodeConstant.SDK_DATA_INVALID_ERROR);
                }
            }
            else
            {
                result.setErrCode(ESDKErrorCodeConstant.SDK_DATA_INVALID_ERROR);
            }
        }
        else
        {
            result.setErrCode(ESDKErrorCodeConstant.NO_SUCH_ALGORITHM_ERRORCODE);
        }
        return result;
    }
}
