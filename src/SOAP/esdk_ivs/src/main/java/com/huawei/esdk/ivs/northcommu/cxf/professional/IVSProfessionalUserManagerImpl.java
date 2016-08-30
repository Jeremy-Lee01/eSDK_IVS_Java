/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.ivs.northcommu.cxf.professional;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.business.professional.usermgr.UserMgrService;
import com.huawei.esdk.ivs.common.CipherUtils;
import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.User;
import com.huawei.esdk.ivs.domain.model.UserGroup;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RoleInfos;
import com.huawei.esdk.ivs.domain.util.IVSUtil;
import com.huawei.esdk.ivs.northcommu.cxf.professional.convert.IVSProfessionalUserManagerConvert;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AddUser;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AddUserResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ChangePassword;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ChangePasswordResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeleteUser;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeleteUserResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetRoleList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetRoleListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetUserGroupList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetUserGroupListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetUserId;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetUserIdResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetUserInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetUserInfoResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetUserList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetUserListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IVSProfessionalUserManager;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ModifyUser;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ModifyUserResponse;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 用户管理接口实现类
 * <p>
 * @author  gWX169839
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class IVSProfessionalUserManagerImpl implements IVSProfessionalUserManager
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(IVSProfessionalUserManagerImpl.class);
    
    /**
     * 用户管理service层
     */
    private UserMgrService userMgrService;
    
    /**
     * 北向与领域层之前的转换类
     */
    private IVSProfessionalUserManagerConvert ivsProfessionalUserManagerConvert;
    
    /** 
     * 修改用户密码
     *
     * @param parameters 修改用户密码入参，包含旧密码和新密码
     * @return ChangePasswordResponse 响应信息，包含错误码
     * @since eSDK IVS V100R003C00
     */
    @Override
    public ChangePasswordResponse changePassword(ChangePassword parameters)
    {
        //定义返回对象
        ChangePasswordResponse response = new ChangePasswordResponse();
        if (null == parameters || null == parameters.getNewPassword() || null == parameters.getOldPassword())
        {
            LOGGER.error("The input parameter of changePassword method is null");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        
        String tempOldPwd = null;
        String tempNewPwd = null;
        try
        {
            tempOldPwd = CipherUtils.decodeFromBase64(parameters.getOldPassword());
            tempNewPwd = CipherUtils.decodeFromBase64(parameters.getNewPassword());
        }
        catch (SDKException e1)
        {
            LOGGER.error("decode password failed", e1);
            response.setResultCode((int)e1.getSdkErrCode());
            return response;
        }
        
        if (StringUtils.isEmpty(tempOldPwd) || StringUtils.isEmpty(tempNewPwd))
        {
            response.setResultCode(ErrInfo.PWD_ERRORCODE);
            return response;
        }
        
        SDKErrorCode result = new SDKErrorCode();
        
        try
        {
            //调用service层方法
            result = userMgrService.changePassword(tempOldPwd, tempNewPwd);
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException ex)
        {
            LOGGER.error("changePassword failed", ex);
            response.setResultCode((int)ex.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("changePassword failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
        
    }
    
    /** 
     * 获取用户Id
     *
     * @param parameters 获取用户Id入参
     * @return GetUserIdResponse 响应信息，包含错误码和用户Id
     * @since eSDK IVS V100R003C00
     */
    @Override
    public GetUserIdResponse getUserId(GetUserId parameters)
    {
        SDKResult<Integer> result = new SDKResult<Integer>();
        //定义返回对象
        GetUserIdResponse response = new GetUserIdResponse();
        
        try
        {
            if (null == parameters)
            {
                LOGGER.error("The input parameter of getUserId method is null");
                response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
                return response;
            }
            //调用service层方法
            result = userMgrService.getUserId();
            response.setResultCode((int)result.getErrCode());
            if (0 == result.getErrCode())
            {
                response.setUserId(result.getResult());
            }
        }
        catch (SDKException ex)
        {
            response.setResultCode((int)ex.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("getUserId failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /** 
     * 获取用户信息
     *
     * @param parameters 获取用户信息入参，包含用户Id和deMainCode
     * @return GetUserInfoResponse 响应信息，包含错误码和用户信息
     * @since eSDK IVS V100R003C00
     */
    @Override
    public GetUserInfoResponse getUserInfo(GetUserInfo parameters)
    {
        SDKResult<com.huawei.esdk.ivs.domain.model.bean.UserInfo> result =
            new SDKResult<com.huawei.esdk.ivs.domain.model.bean.UserInfo>();
        //定义返回对象
        GetUserInfoResponse response = new GetUserInfoResponse();
        
        try
        {
            if (null == parameters)
            {
                LOGGER.error("The input parameter of getUserInfo method is null");
                response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
                return response;
            }
            
            if (null == parameters.getDomainCode())
            {
                LOGGER.error("The input parameter of getUserInfo method is null");
                response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
                return response;
            }
            
            //调用service层方法
            result = userMgrService.getUserInfo(parameters.getUserId(), parameters.getDomainCode());
            
            response = ivsProfessionalUserManagerConvert.getUserInfoResponseModal2Soap(result);
            
        }
        catch (SDKException ex)
        {
            response.setResultCode((int)ex.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("getUserInfo failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /** 
     * 删除用户
     *
     * @param parameters 删除用户入参，包含用户Id
     * @return DeleteUserResponse 响应信息，包含错误码
     * @since eSDK IVS V100R003C00
     */
    @Override
    public DeleteUserResponse deleteUser(DeleteUser parameters)
    {
        SDKErrorCode result = new SDKErrorCode();
        //定义返回对象
        DeleteUserResponse response = new DeleteUserResponse();
        
        try
        {
            if (null == parameters)
            {
                LOGGER.error("The input parameter of deleteUser method is null");
                response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
                return response;
            }
            if (null == parameters.getDomainCode())
            {
                LOGGER.error("The input parameter of deleteUser method is null");
                response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
                return response;
            }
            
            //调用service层方法
            result = userMgrService.deleteUser(parameters.getUserId(), parameters.getDomainCode());
            response.setResultCode((int)result.getErrCode());
            
        }
        catch (SDKException ex)
        {
            response.setResultCode((int)ex.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("deleteUser failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /** 
     * 修改用户信息
     *
     * @param parameters 修改用户信息入参，包含要修改的用户信息
     * @return ModifyUserResponse 响应信息，包含错误码
     * @since eSDK IVS V100R003C00
     */
    @Override
    public ModifyUserResponse modifyUser(ModifyUser parameters)
    {
        SDKErrorCode result = new SDKErrorCode();
        //定义返回对象
        ModifyUserResponse response = new ModifyUserResponse();
        if (null == parameters)
        {
            LOGGER.error("The input parameter of modifyUser method is null");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        
        try
        {
            //调用service层方法
            com.huawei.esdk.ivs.domain.model.bean.UserInfo user =
                ivsProfessionalUserManagerConvert.getUserInfoSoap2Modal(parameters.getUserInfo());
            
            if ( null != user && !StringUtils.isEmpty(parameters.getUserInfo().getPassword()))
            {
                if (StringUtils.isEmpty(user.getPassword()))
                {
                    response.setResultCode(ErrInfo.PWD_ERRORCODE);
                    return response;
                }
            }
            
            result = userMgrService.modifyUser(user);
            response.setResultCode((int)result.getErrCode());
            
        }
        catch (SDKException ex)
        {
            response.setResultCode((int)ex.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("modifyUser failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /** 
     * 获取用户列表信息
     *
     * @param parameters 获取用户列表信息入参，包含查询条件
     * @return GetUserListResponse 响应信息，包含错误码和用户列表信息
     * @since eSDK IVS V100R003C00
     */
    @Override
    public GetUserListResponse getUserList(GetUserList parameters)
    {
        SDKResult<User> result = new SDKResult<User>();
        //定义返回对象
        GetUserListResponse response = new GetUserListResponse();
        
        if (null == parameters || null == parameters.getUnifiedQuery()
            || null == parameters.getUnifiedQuery().getQueryFieldList())
        {
            LOGGER.error("The input parameter of getUserList method is null");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        if (null == parameters.getDomainCode())
        {
            LOGGER.error("The input parameter of getUserList method is null");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryUnifiedFormat fiedQuery = parameters.getUnifiedQuery();
        
        //分页条件判断
        if (!IVSUtil.validateIndexRange(fiedQuery.getIndex().getFromIndex(), fiedQuery.getIndex().getToIndex()))
        {
            LOGGER.error("The indexRange is error");
            response.setResultCode(ErrInfo.IVS_SMU_XML_UNIFIEDQUERY_INDEX_ERROR);
            return response;
        }
        
        //判断fieldNum的大小是否和QueryFieldList中查询条件个数相同
        if (fiedQuery.getFieldNum() != fiedQuery.getQueryFieldList().getQueryField().size())
        {
            response.setResultCode(ErrInfo.IVS_XML_INVALID_ERROR);
            return response;
        }
        
        try
        {
            //调用service层方法
            QueryUnifiedFormat queryUnfied =
                ivsProfessionalUserManagerConvert.getQueryUnfiedSoap2Modal(parameters.getUnifiedQuery());
            
            result = userMgrService.getUserList(parameters.getDomainCode(), queryUnfied);
            
            response = ivsProfessionalUserManagerConvert.getUserListResponseModal2Soap(result);
        }
        catch (SDKException ex)
        {
            response.setResultCode((int)ex.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("getUserList failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /** 
     * 增加用户
     *
     * @param parameters 增加用户入参，包含用户信息
     * @return AddUserResponse 响应信息，包含错误码
     * @since eSDK IVS V100R003C00
     */
    @Override
    public AddUserResponse addUser(AddUser parameters)
    {
        SDKResult<Integer> result = new SDKResult<Integer>();
        //定义返回对象
        AddUserResponse response = new AddUserResponse();
        if (null == parameters)
        {
            LOGGER.error("The input parameter of addUser method is null");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        
        try
        {
            //调用service层方法
            com.huawei.esdk.ivs.domain.model.bean.UserInfo user =
                ivsProfessionalUserManagerConvert.getUserInfoSoap2Modal(parameters.getUserInfo());
            if ( null != user && StringUtils.isEmpty(user.getPassword()))
            {
                response.setResultCode(ErrInfo.PWD_ERRORCODE);
                return response;
            }
            
            result = userMgrService.addUser(user);
            
            response.setResultCode((int)result.getErrCode());
            if (0 == result.getErrCode())
            {
                response.setUserId(result.getResult());
            }
        }
        catch (SDKException ex)
        {
            LOGGER.error("addUser failed", ex);
            response.setResultCode((int)ex.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("addUser failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    public UserMgrService getUserMgrService()
    {
        return userMgrService;
    }
    
    public void setUserMgrService(UserMgrService userMgrService)
    {
        this.userMgrService = userMgrService;
    }
    
    public IVSProfessionalUserManagerConvert getIvsProfessionalUserManagerConvert()
    {
        return ivsProfessionalUserManagerConvert;
    }
    
    public void setIvsProfessionalUserManagerConvert(IVSProfessionalUserManagerConvert ivsProfessionalUserManagerConvert)
    {
        this.ivsProfessionalUserManagerConvert = ivsProfessionalUserManagerConvert;
    }

    @Override
    public GetUserGroupListResponse getUserGroupList(GetUserGroupList parameters)
    {
        SDKResult<UserGroup> result = new SDKResult<UserGroup>();
        //定义返回对象
        GetUserGroupListResponse response = new GetUserGroupListResponse();
        
        if (null == parameters || null == parameters.getDomainCode()
            || null == parameters.getIndexRange())
        {
            LOGGER.error("The input parameter of getUserGroupList method is null");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange indexRange = parameters.getIndexRange();
        
        //分页条件判断
        if (!IVSUtil.validateIndexRange(indexRange.getFromIndex(), indexRange.getToIndex()))
        {
            LOGGER.error("The indexRange is error");
            response.setResultCode(ErrInfo.IVS_SMU_XML_UNIFIEDQUERY_INDEX_ERROR);
            return response;
        }
        
        try
        {
            IndexRange indexRangeModel =
                ivsProfessionalUserManagerConvert.getIndexRangeSoap2Model(parameters.getIndexRange());
            
            //调用service层方法
            result = userMgrService.getUserGroupList(parameters.getDomainCode(), indexRangeModel);
            
            if(0 == result.getErrCode())
            {
                //领域转换到soap
                response = ivsProfessionalUserManagerConvert.getUserGroupListResponseModel2Soap(result);
            }
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("getUserGroupList sdk exception", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("getUserGroupList failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }

    /** 
     * 查询角色列表
     *
     * @param parameters 查询角色列表入参，包含区域码
     * @return GetRoleListResponse 响应信息，包含错误码和角色列表信息
     * @since eSDK IVS V100R003C00
     */
    @Override
    public GetRoleListResponse getRoleList(GetRoleList parameters)
    {
        SDKResult<RoleInfos> result = new SDKResult<RoleInfos>();
        //定义返回对象
        GetRoleListResponse response = new GetRoleListResponse();
        if (null == parameters)
        {
            LOGGER.error("The input parameter of getRoleList method is null");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        
        try
        {
            //调用service层方法
            result = userMgrService.getRoleList(parameters.getDomainCode());
            
            response.setResultCode((int)result.getErrCode());
            if (0 == result.getErrCode())
            {
                response.setRoleInfos(ivsProfessionalUserManagerConvert.getRoleListModal2Soap(result.getResult()));
            }
        }
        catch (SDKException ex)
        {
            LOGGER.error("getRoleList failed", ex);
            response.setResultCode((int)ex.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("getRoleList failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
}
