package com.huawei.esdk.platform.northcommu.cxf.professional;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.business.professional.key.KeyService;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.platform.northcommu.cxf.professional.gen.GetPublicKey;
import com.huawei.esdk.platform.northcommu.cxf.professional.gen.GetPublicKeyResponse;
import com.huawei.esdk.platform.northcommu.cxf.professional.gen.PlatformKeyMgr;
import com.huawei.esdk.platform.northcommu.cxf.professional.gen.SetSecretKey;
import com.huawei.esdk.platform.northcommu.cxf.professional.gen.SetSecretKeyResponse;

/**
 * 登陆访问
 * <p>
 * @author  sWX198756
 * @see  com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IVSProfessionalCommon
 * @since  eSDK IVS V100R003C00
 */
public class PlatformKeyMgrImpl implements PlatformKeyMgr
{
    
    private static final Logger LOGGER = Logger.getLogger(PlatformKeyMgrImpl.class);
    
    private KeyService keyService = KeyService.getInstance();
    
    /**
     *  获取公钥
     */
    @Override
    public GetPublicKeyResponse getPublicKey(GetPublicKey parameters)
    {
        GetPublicKeyResponse response = new GetPublicKeyResponse();
        try
        {
            if (null == parameters || StringUtils.isEmpty(parameters.getSecretType())
                || ESDKConstant.RSA2048.equals(parameters.getSecretType()))
            {
                String result = keyService.getPublicKey();
                
                if (null != result)
                {
                    response.setResultCode(0);
                    response.setPublicKey(result);
                }
            }
            else
            {
                response.setResultCode(ESDKErrorCodeConstant.NO_SUCH_ALGORITHM_ERRORCODE);
            }
        }
        catch (Exception e)
        {
            LOGGER.error("getPublicKey method error", e);
            response.setResultCode(ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
        
        return response;
    }
    
    @Override
    public SetSecretKeyResponse setSecretKey(SetSecretKey parameters)
    {
        SetSecretKeyResponse response = new SetSecretKeyResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getSecretKey()))
        {
            response.setResultCode(ESDKErrorCodeConstant.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        
        try
        {
            SDKErrorCode result = keyService.setSecretKey(parameters.getSecretType(), parameters.getSecretKey(), parameters.getIv());
            response.setResultCode((int)result.getErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("setSecretKey method error", e);
            response.setResultCode(ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
        
        return response;
    }
    
}
