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
package com.huawei.esdk.ivs.device.v100r001c10.businessmanager;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.common.constants.IVSConstant;
import com.huawei.esdk.ivs.device.BaseCability;
import com.huawei.esdk.ivs.device.v100r001c10.businessmanager.convert.BusinessMgrCabilityConvert;
import com.huawei.esdk.ivs.device.vcn3000.businessmanager.IBusinessMgrCability;
import com.huawei.esdk.ivs.domain.model.Business;
import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.huawei.esdk.ivs.domain.model.bean.MediaAddress;
import com.huawei.esdk.ivs.domain.model.bean.MediaURLParam;
import com.huawei.esdk.ivs.domain.model.bean.PTZControlInfo;
import com.huawei.esdk.ivs.domain.model.bean.PTZPresetInfo;
import com.huawei.esdk.ivs.domain.model.bean.PTZPresetInfoList;
import com.huawei.esdk.ivs.domain.model.bean.PlaybackParam;
import com.huawei.esdk.ivs.domain.model.bean.QuerySnapshotParam;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RealPlay;
import com.huawei.esdk.ivs.domain.model.bean.SnapshotInfoList;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.MediaAddressSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.MediaURLParamSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.OperationLogListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.PTZControlInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.PTZPresetInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.PTZPresetInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.PlayBackParamSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.QuerySnapshotParamSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.QueryUnifiedFormatSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.RealplayParamSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.SnapshotInfoListSouth;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.utils.BytesUtils;
import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;

/**
 * 业务管理能力类
 * <p>
 * 
 * @author cWX191990
 * @see [相关类/方法]
 * @since [eSDK IVS V100R003C00]
 */
public class BusinessMgrCability extends BaseCability implements IBusinessMgrCability {
	/**
	 * 日志对象
	 */
	private static final Logger LOGGER = Logger.getLogger(BusinessMgrCability.class);

	/**
	 * 南向数据转换类
	 */
	private BusinessMgrCabilityConvert businessMgrCabilityConvert = new BusinessMgrCabilityConvert();

	/**
	 * 增加指定摄像机预置位
	 * 
	 * @param cameraCode
	 *            摄像机编码
	 * @param presetName
	 *            预置位名字
	 * @return SDKResult<Integer> 领域层封装的返回码对象
	 * @see [类、类#方法、类#成员]
	 * @since [eSDK IVS V100R003C00]
	 */
	@Override
	public SDKResult<Integer> addPTZPreset(String cameraCode, String presetName) {
		int sessionId = super.getIVSSessionId();

		ByReference presetIndex = new IntByReference(-1);

		// modify by cWX191990, IVS
		// Bug:该接口的presetName不支持传String，且转成byte后还要固定长度84
		// 长度实际为20个字节，为防止溢出，定义长度为84
		int resultCode = super.getBaseCablilityJNA().IVS_SDK_AddPTZPreset(sessionId, cameraCode,
				BytesUtils.stringToBytesForIVS(presetName, CommonConstant.BusinessModule.IVS_PRESET_NAME_LEN),
				presetIndex);

		// 转换成领域层的bean
		SDKResult<Integer> result = new SDKResult<Integer>();

		if (0 == resultCode) {
			result.setResult(((IntByReference) presetIndex).getValue());
		}

		result.setErrCode(resultCode);
		return result;
	}

	/**
	 * 删除指定摄像机预置位
	 * 
	 * @param cameraCode
	 *            摄像机编码
	 * @param presetIndex
	 *            预置位
	 * @return SDKErrorCode 领域层封装的返回码对象
	 * @see [类、类#方法、类#成员]
	 * @since [eSDK IVS V100R003C00]
	 */
	@Override
	public SDKErrorCode deletePTZPreset(String cameraCode, int presetIndex) {

		int sessionId = super.getIVSSessionId();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_DelPTZPreset(sessionId, cameraCode, presetIndex);

		// 转换成领域层的bean
		SDKErrorCode result = new SDKErrorCode();

		result.setErrCode(resultCode);

		return result;
	}

	/**
	 * 修改指定摄像机预置位
	 * 
	 * @param cameraCode
	 *            摄像机编码
	 * @param ptzPresetInfo
	 *            预置信息
	 * @return SDKErrorCode 领域层封装的返回码对象
	 * @see [类、类#方法、类#成员]
	 * @since [eSDK IVS V100R003C00]
	 */
	@Override
	public SDKErrorCode modifyPTZPreset(String cameraCode, PTZPresetInfo ptzPresetInfo) {
		// 转换成南向的预置位信息对象
		PTZPresetInfoSouth ptzPresetInfoSouth = businessMgrCabilityConvert.modifyPTZPresetModel2South(ptzPresetInfo);
		int sessionId = super.getIVSSessionId();

		int resultCode = 0;
		try {
			resultCode = super.getBaseCablilityJNA().IVS_SDK_ModPTZPreset(sessionId,
					cameraCode.getBytes(System.getProperty("file.encoding")), ptzPresetInfoSouth);
		} catch (UnsupportedEncodingException e) {
			resultCode = ErrInfo.DATA_ERRORCODE;
		}

		SDKErrorCode result = new SDKErrorCode();
		result.setErrCode(resultCode);

		return result;
	}

	/**
	 * 开始实况浏览
	 * 
	 * @param cameraCode
	 *            摄像机编码
	 * @param realPlay
	 *            实况浏览信息
	 * @return SDKResult<RealPlay> 领域层封装的返回码对象
	 * @see [类、类#方法、类#成员]
	 * @since [eSDK IVS V100R003C00]
	 */
	@Override
	public SDKResult<RealPlay> startRealPlayByIPEx(String cameraCode, RealPlay realPlay) {
		RealplayParamSouth realplayParamSouth = businessMgrCabilityConvert.getRealplayParamModel2South(realPlay);

		MediaAddressSouth mediaAddressSouth = businessMgrCabilityConvert
				.getMediaAddressSouthModel2South(realPlay.getMediaAddress());
		int sessionId = super.getIVSSessionId();

		LongByReference handle = new LongByReference();

		MediaAddressSouth mediaAddrSrc = new MediaAddressSouth();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_StartRealPlayByIPEx(sessionId, realplayParamSouth,
				BytesUtils.stringToBytesForIVS(cameraCode, CommonConstant.ClusterModule.IVS_DEV_CODE_LEN),
				mediaAddressSouth, mediaAddrSrc.getPointer(), handle);

		mediaAddrSrc.read();
		SDKResult<RealPlay> result = new SDKResult<RealPlay>();
		result.setErrCode(resultCode);
		if (0 == resultCode) {
			RealPlay realPlayModel = businessMgrCabilityConvert.startRealPlayByIPExSouth2Model(mediaAddrSrc);
			realPlayModel.setHandle(handle.getValue());
			result.setResult(realPlayModel);
		}

		return result;
	}

	/**
	 * 停止实况浏览
	 * 
	 * @param handle
	 *            播放句柄
	 * @return SDKErrorCode 领域层封装的返回码对象
	 * @see [类、类#方法、类#成员]
	 * @since [eSDK IVS V100R003C00]
	 */
	@Override
	public SDKErrorCode stopRealPlayByIPEx(long handle) {
		SDKErrorCode result = new SDKErrorCode();

		if (!checkHandle(handle)) {
			result.setErrCode(ErrInfo.IVS_HANDLE_INVALID_ERROR);
			return result;
		}

		int sessionId = super.getIVSSessionId();

		NativeLong nativaLong = new NativeLong(handle);

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_StopRealPlayByIPEx(sessionId, nativaLong);

		result.setErrCode(resultCode);
		return result;
	}

	/**
	 * 云镜控制命令 此接口用于操作摄像机云台和设置摄像机镜头
	 * 
	 * @param cameraCode
	 *            摄像机编码
	 * @param controlCode
	 *            云镜控制码
	 * @param controlPara1
	 *            云镜控制参数1
	 * @param controlPara2
	 *            云镜控制参数2
	 * @return SDKResult<Integer> 云台是否锁定
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKResult<Integer> ptzControl(String cameraCode, int controlCode, String controlPara1, String controlPara2) {
		LOGGER.info("ptzControl method start--->>>");
		SDKResult<Integer> result = new SDKResult<Integer>();

		int sessionId = super.getIVSSessionId();
		IntByReference lockStatus = new IntByReference(-1);
		int resultCode = super.getBaseCablilityJNA().IVS_SDK_PtzControl(sessionId, cameraCode, controlCode,
				controlPara1, controlPara2, lockStatus);

		result.setErrCode(resultCode);
		result.setResult(lockStatus.getValue());

		LOGGER.info("ptzControl method result code:" + resultCode);
		LOGGER.info("ptzControl method end--->>>");

		return result;
	}

	/**
	 * 查询摄像机预置位列表
	 * 
	 * @param cameraCode
	 *            摄像机编码
	 * @return SDKResult<PTZPresetInfoList> 封装的摄像机预置位列表对象
	 * @see [类、类#方法、类#成员]
	 * @since [eSDK IVS V100R003C00]
	 */
	@Override
	public SDKResult<PTZPresetInfoList> getPTZPresetList(String cameraCode) {
		PTZPresetInfoListSouth presetInfoListSouth = new PTZPresetInfoListSouth(
				CommonConstant.BusinessModule.IVS_PRESET_LIST_LEN);
		int sessionId = super.getIVSSessionId();
		IntByReference ptzPresetNum = new IntByReference();

		int resultCode = 0;
		try {
			resultCode = super.getBaseCablilityJNA().IVS_SDK_GetPTZPresetList(sessionId,
					cameraCode.getBytes(System.getProperty("file.encoding")), presetInfoListSouth.getPointer(),
					presetInfoListSouth.size(), ptzPresetNum);
		} catch (UnsupportedEncodingException e) {
			resultCode = ErrInfo.DATA_ERRORCODE;
		}
		presetInfoListSouth.read();

		SDKResult<PTZPresetInfoList> result = new SDKResult<PTZPresetInfoList>();
		result.setErrCode(resultCode);

		if (0 == resultCode) {
			PTZPresetInfoList infoList = new PTZPresetInfoList();
			infoList.setPtzPresetNum(ptzPresetNum.getValue());
			infoList.setPresetInfos(businessMgrCabilityConvert
					.getPTZPresetListSouth2Model(presetInfoListSouth.ptzPresetInfoSouths, ptzPresetNum.getValue()));
			result.setResult(infoList);
		}

		return result;
	}

	/**
	 * 云镜控制命令 此接口用于操作摄像机云台和设置摄像机镜头
	 * 
	 * @param cameraCode
	 *            摄像机编码
	 * @param controlCode
	 *            云镜控制码
	 * @param controlPara1
	 *            云镜控制参数1
	 * @param controlPara2
	 *            云镜控制参数2
	 * @return SDKResult<PTZControlInfo> 详细的锁定用户信息
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKResult<PTZControlInfo> ptzControlWithLockerInfo(String cameraCode, int controlCode, String controlPara1,
			String controlPara2) {
		LOGGER.info("ptzControlWithLockerInfo method start--->>>");

		SDKResult<PTZControlInfo> result = new SDKResult<PTZControlInfo>();

		int sessionId = super.getIVSSessionId();
		PTZControlInfoSouth ptzControlInfoSouth = new PTZControlInfoSouth();
		int resultCode = super.getBaseCablilityJNA().IVS_SDK_PtzControlWithLockerInfo(sessionId, cameraCode,
				controlCode, controlPara1, controlPara2, ptzControlInfoSouth.getPointer());
		ptzControlInfoSouth.read();
		result.setErrCode(resultCode);
		PTZControlInfo domain = businessMgrCabilityConvert.getPTZControlInfoSouth2Model(ptzControlInfoSouth);
		result.setResult(domain);

		LOGGER.info("ptzControlWithLockerInfo method result code:" + resultCode);
		LOGGER.info("ptzControlWithLockerInfo method end--->>>");

		return result;
	}

	/**
	 * 停止平台录像播放
	 *
	 * @param handle
	 *            播放句柄
	 * @return SDKErrorCode 封装领域层的SDKErrorCode对象
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKErrorCode stopPlatformPlayBackByIP(long handle) {
		SDKErrorCode result = new SDKErrorCode();
		if (!checkHandle(handle)) {
			result.setErrCode(ErrInfo.IVS_HANDLE_INVALID_ERROR);
			return result;
		}

		int sessionId = super.getIVSSessionId();

		NativeLong nativaLong = new NativeLong(handle);

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_StopPlatformPlayBackByIP(sessionId, nativaLong);

		result.setErrCode(resultCode);

		return result;
	}

	/**
	 * 开始平台录像播放
	 *
	 * @param cameraCode
	 *            摄像机编码
	 * @param mediaAddrSrc
	 *            媒体流目标地址
	 * @param playbackParam
	 *            录像播放媒体参数
	 * @return SDKResult<Business> 封装领域层的SDKResult<Business>对象
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKResult<Business> startPlatformPlayBackByIP(String cameraCode, MediaAddress mediaAddrSrc,
			PlaybackParam playbackParam) {

		int sessionId = super.getIVSSessionId();

		MediaAddressSouth mediaAddressSouthIn = businessMgrCabilityConvert.getMediaAddressModel2South(mediaAddrSrc);
		PlayBackParamSouth playBackParamSouthIn = businessMgrCabilityConvert.getPlayBackParamModel2South(playbackParam);

		LongByReference handle = new LongByReference();
		MediaAddressSouth mediaAddressSouthOut = new MediaAddressSouth();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_StartPlatformPlayBackByIP(sessionId, cameraCode,
				playBackParamSouthIn, mediaAddressSouthIn, mediaAddressSouthOut.getPointer(), handle);

		mediaAddressSouthOut.read();

		SDKResult<Business> result = new SDKResult<Business>();
		result.setErrCode(resultCode);

		if (0 == resultCode) {
			Business business = new Business();
			business.setHandle(handle.getValue());
			business.setMediaAddrSrc(businessMgrCabilityConvert.getMediaAddressSouth2Model(mediaAddressSouthOut));
			result.setResult(business);
		}

		return result;
	}

	/**
	 * 开始平台录像
	 *
	 * @param cameraCode
	 *            摄像机编码
	 * @param recordTime
	 *            录像时间
	 * @return SDKErrorCode 封装领域层的SDKErrorCode对象
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKErrorCode startPlatformRecord(String cameraCode, int recordTime) {
		int sessionId = super.getIVSSessionId();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_StartPlatformRecord(sessionId, cameraCode, recordTime);

		SDKErrorCode result = new SDKErrorCode();
		result.setErrCode(resultCode);

		return result;
	}

	/**
	 * 停止平台录像
	 *
	 * @param cameraCode
	 *            摄像机编码
	 * @return SDKErrorCode 封装领域层的SDKErrorCode对象
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKErrorCode stopPlatformRecord(String cameraCode) {
		int sessionId = super.getIVSSessionId();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_StopPlatformRecord(sessionId, cameraCode);

		SDKErrorCode result = new SDKErrorCode();
		result.setErrCode(resultCode);

		return result;
	}

	/**
	 * 查询操作日志
	 * 
	 * @param unifiedQuery
	 * @return
	 * @see [类、类#方法、类#成员] since eSDK IVS V100R003C10B002
	 */
	@Override
	public SDKResult<Business> getOperationLog(QueryUnifiedFormat unifiedQuery) {
		int sessionId = getIVSSessionId();

		SDKResult<Business> response = new SDKResult<Business>();

		QueryUnifiedFormatSouth pUnifiedQuery = businessMgrCabilityConvert
				.getQueryUnifiedFormatSoap2Model(unifiedQuery);

		int fromIndex = unifiedQuery.getIndex().getFromIndex();
		int toIndex = unifiedQuery.getIndex().getToIndex();

		int resultArraySize = toIndex - fromIndex + 1;

		if (1 > resultArraySize) {
			resultArraySize = 1;
		}
		OperationLogListSouth pOperationLogList = new OperationLogListSouth(resultArraySize);
		int bufferSize = pOperationLogList.size();
		Pointer operationLogListSouthPoint = pOperationLogList.getPointer();

		int errCode = super.getBaseCablilityJNA().IVS_SDK_GetOperationLog(sessionId, pUnifiedQuery,
				operationLogListSouthPoint, bufferSize);
		response.setErrCode(errCode);

		pOperationLogList.read();

		if (0 == errCode) {
			response.setResult(businessMgrCabilityConvert.getOperationLogListSoap2Modal(pOperationLogList));
		}

		return response;
	}

	@Override
	public SDKErrorCode platformPlayBackPauseByIP(long playHandle) {
		LOGGER.debug("platformPlayBackPauseByIP method start--->>>");
		SDKErrorCode result = new SDKErrorCode();
		if (!checkHandle(playHandle)) {
			result.setErrCode(ErrInfo.IVS_HANDLE_INVALID_ERROR);
			return result;
		}

		NativeLong nativaLong = new NativeLong(playHandle);

		int sessionId = super.getIVSSessionId();
		int resultCode = super.getBaseCablilityJNA().IVS_SDK_PlatformPlayBackPauseByIP(sessionId, nativaLong);

		result.setErrCode(resultCode);

		LOGGER.debug("platformPlayBackPauseByIP method result code:" + resultCode);
		LOGGER.debug("platformPlayBackPauseByIP method end--->>>");

		return result;
	}

	@Override
	public SDKErrorCode platformPlayBackResumeByIP(long playHandle) {
		LOGGER.debug("platformPlayBackResumeByIP method start--->>>");
		SDKErrorCode result = new SDKErrorCode();
		if (!checkHandle(playHandle)) {
			result.setErrCode(ErrInfo.IVS_HANDLE_INVALID_ERROR);
			return result;
		}

		NativeLong nativaLong = new NativeLong(playHandle);
		int sessionId = super.getIVSSessionId();
		int resultCode = super.getBaseCablilityJNA().IVS_SDK_PlatformPlayBackResumeByIP(sessionId, nativaLong);

		result.setErrCode(resultCode);

		LOGGER.debug("platformPlayBackResumeByIP method result code:" + resultCode);
		LOGGER.debug("platformPlayBackResumeByIP method end--->>>");

		return result;
	}

	/**
	 * 设置平台录像码流回放时间
	 * 
	 * @param playHandle
	 *            播放句柄
	 * @param time
	 *            回放时间
	 * @return SDKErrorCode 领域层封装的返回码对象
	 * @see
	 * @since eSDK IVS V100R003C30SPC100
	 */
	@Override
	public SDKErrorCode setPlayBackTimeByIP(long playHandle, int time) {
		LOGGER.debug("setPlayBackTimeByIP method start--->>>");

		SDKErrorCode result = new SDKErrorCode();

		if (!checkHandle(playHandle)) {
			result.setErrCode(ErrInfo.IVS_HANDLE_INVALID_ERROR);
			return result;
		}

		NativeLong nativaLong = new NativeLong(playHandle);
		int sessionId = super.getIVSSessionId();
		int resultCode = super.getBaseCablilityJNA().IVS_SDK_SetPlayBackTimeByIP(sessionId, nativaLong, time);

		result.setErrCode(resultCode);

		LOGGER.debug("setPlayBackTimeByIP method result code:" + resultCode);
		LOGGER.debug("setPlayBackTimeByIP method end--->>>");

		return result;
	}

	/**
	 * 设置平台录像码流回放速度
	 * 
	 * @param playHandle
	 *            播放句柄
	 * @param speed
	 *            播放速度
	 * @return SDKErrorCode 领域层封装的返回码对象
	 * @see
	 * @since eSDK IVS V100R003C30SPC100
	 */
	@Override
	public SDKErrorCode setPlayBackSpeedByIP(long playHandle, float speed) {
		LOGGER.debug("setPlayBackSpeedByIP method start--->>>");

		SDKErrorCode result = new SDKErrorCode();

		if (!checkHandle(playHandle)) {
			result.setErrCode(ErrInfo.IVS_HANDLE_INVALID_ERROR);
			return result;
		}

		NativeLong nativaLong = new NativeLong(playHandle);
		int sessionId = super.getIVSSessionId();
		int resultCode = super.getBaseCablilityJNA().IVS_SDK_SetPlayBackSpeedByIP(sessionId, nativaLong, speed);

		result.setErrCode(resultCode);

		LOGGER.debug("setPlayBackSpeedByIP method result code:" + resultCode);
		LOGGER.debug("setPlayBackSpeedByIP method end--->>>");

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SDKResult<SnapshotInfoList> getSnapshotList(String cameraCode, QuerySnapshotParam param) {
		LOGGER.debug("Enter south method getSnapshotList");
		int sessionId = super.getIVSSessionId();

		int total = param.getIndexRange().getToIndex() - param.getIndexRange().getFromIndex() + 1;
		if (1 > total)
			total = 1;

		QuerySnapshotParamSouth querySnapshotParamIn = businessMgrCabilityConvert
				.getQuerySnapshotParamModel2South(param);

		SnapshotInfoListSouth snapshotInfoListSouthOut = new SnapshotInfoListSouth(total);

		LOGGER.debug("Start excute DLL method IVS_SDK_GetSnapshotList");

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_GetSnapshotList(sessionId, cameraCode,
				querySnapshotParamIn, snapshotInfoListSouthOut.getPointer(), total * 896 + 12);

		snapshotInfoListSouthOut.read();

		LOGGER.debug("Finish excute DLL method IVS_SDK_GetSnapshotList with resultCode:" + resultCode);

		SDKResult<SnapshotInfoList> result = new SDKResult<SnapshotInfoList>();
		result.setErrCode(resultCode);

		if (0 == resultCode) {
			result.setResult(businessMgrCabilityConvert.getSnapshotInfoListSoap2Modal(snapshotInfoListSouthOut));
		}

		LOGGER.debug("Leave south method getSnapshotList");
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SDKErrorCode platformSnapshot(String cameraCode) {
		LOGGER.debug("South platformSnapshot method start--->>>");
		SDKErrorCode result = new SDKErrorCode();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_PlatformSnapshot(super.getIVSSessionId(), cameraCode);

		LOGGER.debug("South platformSnapshot method result code:" + resultCode);
		LOGGER.debug("South platformSnapshot method end--->>>");

		result.setErrCode(resultCode);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SDKErrorCode deleteSnapshot(String cameraCode, int pictureID) {
		LOGGER.debug("South deleteSnapshot method start--->>>");
		SDKErrorCode result = new SDKErrorCode();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_DeleteSnapshot(super.getIVSSessionId(), cameraCode,
				pictureID);

		LOGGER.debug("South deleteSnapshot method result code:" + resultCode);
		LOGGER.debug("South deleteSnapshot method end--->>>");

		result.setErrCode(resultCode);
		return result;
	}

	@Override
	public SDKResult<String> getRtspURL(String cameraCode, MediaURLParam mediaURLParam) {
		LOGGER.debug("South getRtspURL method start--->>>");
		SDKResult<String> result = new SDKResult<String>();

		int sessionId = super.getIVSSessionId();

		MediaURLParamSouth mediaURLParamSouthIn = businessMgrCabilityConvert.getMediaURLParamModel2South(mediaURLParam);

		Pointer rtspURL = new Memory(1024);

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_GetRtspURL(sessionId, cameraCode, mediaURLParamSouthIn,
				rtspURL, 1024);

		result.setErrCode(resultCode);
		if (0 == resultCode) {
			byte[] rtspURLArray = rtspURL.getByteArray(0, 1024);
			result.setResult(new String(businessMgrCabilityConvert.trimByteArray(rtspURLArray)));
		}

		LOGGER.debug("South getRtspURL method result code:" + resultCode);
		LOGGER.debug("South getRtspURL method end--->>>");

		result.setErrCode(resultCode);
		return result;
	}

	private boolean checkHandle(long playHandle) {
		if (IVSConstant.IVS_OS_32 == NativeLong.SIZE) {
			if (IVSConstant.IVS_INT_MAX < playHandle || IVSConstant.IVS_INT_MIN > playHandle) {
				return false;
			}
		}
		return true;
	}

}
