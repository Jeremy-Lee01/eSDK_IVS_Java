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
package com.huawei.esdk.ivs.professional.local.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfigItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfigItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deviceConfig" type="{esdk_ivs_professional_server}DeviceConfig" minOccurs="0"/>
 *         &lt;element name="deviceNetConfig" type="{esdk_ivs_professional_server}DeviceNetConfig" minOccurs="0"/>
 *         &lt;element name="deviceTimeConfig" type="{esdk_ivs_professional_server}DeviceTimeConfig" minOccurs="0"/>
 *         &lt;element name="cameraConfig" type="{esdk_ivs_professional_server}CameraConfig" minOccurs="0"/>
 *         &lt;element name="cameraStreamConfig" type="{esdk_ivs_professional_server}CameraStreamConfig" minOccurs="0"/>
 *         &lt;element name="cameraDisplayConfig" type="{esdk_ivs_professional_server}CameraDisplayConfig" minOccurs="0"/>
 *         &lt;element name="cameraImagingConfig" type="{esdk_ivs_professional_server}CameraImagingConfig" minOccurs="0"/>
 *         &lt;element name="cameraOSDConfig" type="{esdk_ivs_professional_server}CameraOSDConfig" minOccurs="0"/>
 *         &lt;element name="motionDetection" type="{esdk_ivs_professional_server}MotionDetection" minOccurs="0"/>
 *         &lt;element name="videoHideAlarm" type="{esdk_ivs_professional_server}VideoHideAlarm" minOccurs="0"/>
 *         &lt;element name="videoMask" type="{esdk_ivs_professional_server}VideoMask" minOccurs="0"/>
 *         &lt;element name="audioConfig" type="{esdk_ivs_professional_server}AudioConfig" minOccurs="0"/>
 *         &lt;element name="serialChannelConfig" type="{esdk_ivs_professional_server}SerialChannelConfig" minOccurs="0"/>
 *         &lt;element name="alarmInConfig" type="{esdk_ivs_professional_server}AlarmInConfig" minOccurs="0"/>
 *         &lt;element name="alarmOutConfig" type="{esdk_ivs_professional_server}AlarmOutConfig" minOccurs="0"/>
 *         &lt;element name="ptzConfig" type="{esdk_ivs_professional_server}PTZConfig" minOccurs="0"/>
 *         &lt;element name="cameraExtendConfig" type="{esdk_ivs_professional_server}CameraExtendConfig" minOccurs="0"/>
 *         &lt;element name="cameraSnapShotConfig" type="{esdk_ivs_professional_server}CameraSnapShotConfig" minOccurs="0"/>
 *         &lt;element name="cameraRecordStreamConfig" type="{esdk_ivs_professional_server}CameraRecordStreamConfig" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfigItem", propOrder = {
    "deviceConfig",
    "deviceNetConfig",
    "deviceTimeConfig",
    "cameraConfig",
    "cameraStreamConfig",
    "cameraDisplayConfig",
    "cameraImagingConfig",
    "cameraOSDConfig",
    "motionDetection",
    "videoHideAlarm",
    "videoMask",
    "audioConfig",
    "serialChannelConfig",
    "alarmInConfig",
    "alarmOutConfig",
    "ptzConfig",
    "cameraExtendConfig",
    "cameraSnapShotConfig",
    "cameraRecordStreamConfig"
})
public class ConfigItem {

    protected DeviceConfig deviceConfig;
    protected DeviceNetConfig deviceNetConfig;
    protected DeviceTimeConfig deviceTimeConfig;
    protected CameraConfig cameraConfig;
    protected CameraStreamConfig cameraStreamConfig;
    protected CameraDisplayConfig cameraDisplayConfig;
    protected CameraImagingConfig cameraImagingConfig;
    protected CameraOSDConfig cameraOSDConfig;
    protected MotionDetection motionDetection;
    protected VideoHideAlarm videoHideAlarm;
    protected VideoMask videoMask;
    protected AudioConfig audioConfig;
    protected SerialChannelConfig serialChannelConfig;
    protected AlarmInConfig alarmInConfig;
    protected AlarmOutConfig alarmOutConfig;
    protected PTZConfig ptzConfig;
    protected CameraExtendConfig cameraExtendConfig;
    protected CameraSnapShotConfig cameraSnapShotConfig;
    protected CameraRecordStreamConfig cameraRecordStreamConfig;

    /**
     * Gets the value of the deviceConfig property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceConfig }
     *     
     */
    public DeviceConfig getDeviceConfig() {
        return deviceConfig;
    }

    /**
     * Sets the value of the deviceConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceConfig }
     *     
     */
    public void setDeviceConfig(DeviceConfig value) {
        this.deviceConfig = value;
    }

    /**
     * Gets the value of the deviceNetConfig property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceNetConfig }
     *     
     */
    public DeviceNetConfig getDeviceNetConfig() {
        return deviceNetConfig;
    }

    /**
     * Sets the value of the deviceNetConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceNetConfig }
     *     
     */
    public void setDeviceNetConfig(DeviceNetConfig value) {
        this.deviceNetConfig = value;
    }

    /**
     * Gets the value of the deviceTimeConfig property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceTimeConfig }
     *     
     */
    public DeviceTimeConfig getDeviceTimeConfig() {
        return deviceTimeConfig;
    }

    /**
     * Sets the value of the deviceTimeConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceTimeConfig }
     *     
     */
    public void setDeviceTimeConfig(DeviceTimeConfig value) {
        this.deviceTimeConfig = value;
    }

    /**
     * Gets the value of the cameraConfig property.
     * 
     * @return
     *     possible object is
     *     {@link CameraConfig }
     *     
     */
    public CameraConfig getCameraConfig() {
        return cameraConfig;
    }

    /**
     * Sets the value of the cameraConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link CameraConfig }
     *     
     */
    public void setCameraConfig(CameraConfig value) {
        this.cameraConfig = value;
    }

    /**
     * Gets the value of the cameraStreamConfig property.
     * 
     * @return
     *     possible object is
     *     {@link CameraStreamConfig }
     *     
     */
    public CameraStreamConfig getCameraStreamConfig() {
        return cameraStreamConfig;
    }

    /**
     * Sets the value of the cameraStreamConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link CameraStreamConfig }
     *     
     */
    public void setCameraStreamConfig(CameraStreamConfig value) {
        this.cameraStreamConfig = value;
    }

    /**
     * Gets the value of the cameraDisplayConfig property.
     * 
     * @return
     *     possible object is
     *     {@link CameraDisplayConfig }
     *     
     */
    public CameraDisplayConfig getCameraDisplayConfig() {
        return cameraDisplayConfig;
    }

    /**
     * Sets the value of the cameraDisplayConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link CameraDisplayConfig }
     *     
     */
    public void setCameraDisplayConfig(CameraDisplayConfig value) {
        this.cameraDisplayConfig = value;
    }

    /**
     * Gets the value of the cameraImagingConfig property.
     * 
     * @return
     *     possible object is
     *     {@link CameraImagingConfig }
     *     
     */
    public CameraImagingConfig getCameraImagingConfig() {
        return cameraImagingConfig;
    }

    /**
     * Sets the value of the cameraImagingConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link CameraImagingConfig }
     *     
     */
    public void setCameraImagingConfig(CameraImagingConfig value) {
        this.cameraImagingConfig = value;
    }

    /**
     * Gets the value of the cameraOSDConfig property.
     * 
     * @return
     *     possible object is
     *     {@link CameraOSDConfig }
     *     
     */
    public CameraOSDConfig getCameraOSDConfig() {
        return cameraOSDConfig;
    }

    /**
     * Sets the value of the cameraOSDConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link CameraOSDConfig }
     *     
     */
    public void setCameraOSDConfig(CameraOSDConfig value) {
        this.cameraOSDConfig = value;
    }

    /**
     * Gets the value of the motionDetection property.
     * 
     * @return
     *     possible object is
     *     {@link MotionDetection }
     *     
     */
    public MotionDetection getMotionDetection() {
        return motionDetection;
    }

    /**
     * Sets the value of the motionDetection property.
     * 
     * @param value
     *     allowed object is
     *     {@link MotionDetection }
     *     
     */
    public void setMotionDetection(MotionDetection value) {
        this.motionDetection = value;
    }

    /**
     * Gets the value of the videoHideAlarm property.
     * 
     * @return
     *     possible object is
     *     {@link VideoHideAlarm }
     *     
     */
    public VideoHideAlarm getVideoHideAlarm() {
        return videoHideAlarm;
    }

    /**
     * Sets the value of the videoHideAlarm property.
     * 
     * @param value
     *     allowed object is
     *     {@link VideoHideAlarm }
     *     
     */
    public void setVideoHideAlarm(VideoHideAlarm value) {
        this.videoHideAlarm = value;
    }

    /**
     * Gets the value of the videoMask property.
     * 
     * @return
     *     possible object is
     *     {@link VideoMask }
     *     
     */
    public VideoMask getVideoMask() {
        return videoMask;
    }

    /**
     * Sets the value of the videoMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link VideoMask }
     *     
     */
    public void setVideoMask(VideoMask value) {
        this.videoMask = value;
    }

    /**
     * Gets the value of the audioConfig property.
     * 
     * @return
     *     possible object is
     *     {@link AudioConfig }
     *     
     */
    public AudioConfig getAudioConfig() {
        return audioConfig;
    }

    /**
     * Sets the value of the audioConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link AudioConfig }
     *     
     */
    public void setAudioConfig(AudioConfig value) {
        this.audioConfig = value;
    }

    /**
     * Gets the value of the serialChannelConfig property.
     * 
     * @return
     *     possible object is
     *     {@link SerialChannelConfig }
     *     
     */
    public SerialChannelConfig getSerialChannelConfig() {
        return serialChannelConfig;
    }

    /**
     * Sets the value of the serialChannelConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link SerialChannelConfig }
     *     
     */
    public void setSerialChannelConfig(SerialChannelConfig value) {
        this.serialChannelConfig = value;
    }

    /**
     * Gets the value of the alarmInConfig property.
     * 
     * @return
     *     possible object is
     *     {@link AlarmInConfig }
     *     
     */
    public AlarmInConfig getAlarmInConfig() {
        return alarmInConfig;
    }

    /**
     * Sets the value of the alarmInConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmInConfig }
     *     
     */
    public void setAlarmInConfig(AlarmInConfig value) {
        this.alarmInConfig = value;
    }

    /**
     * Gets the value of the alarmOutConfig property.
     * 
     * @return
     *     possible object is
     *     {@link AlarmOutConfig }
     *     
     */
    public AlarmOutConfig getAlarmOutConfig() {
        return alarmOutConfig;
    }

    /**
     * Sets the value of the alarmOutConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmOutConfig }
     *     
     */
    public void setAlarmOutConfig(AlarmOutConfig value) {
        this.alarmOutConfig = value;
    }

    /**
     * Gets the value of the ptzConfig property.
     * 
     * @return
     *     possible object is
     *     {@link PTZConfig }
     *     
     */
    public PTZConfig getPtzConfig() {
        return ptzConfig;
    }

    /**
     * Sets the value of the ptzConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link PTZConfig }
     *     
     */
    public void setPtzConfig(PTZConfig value) {
        this.ptzConfig = value;
    }

    /**
     * Gets the value of the cameraExtendConfig property.
     * 
     * @return
     *     possible object is
     *     {@link CameraExtendConfig }
     *     
     */
    public CameraExtendConfig getCameraExtendConfig() {
        return cameraExtendConfig;
    }

    /**
     * Sets the value of the cameraExtendConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link CameraExtendConfig }
     *     
     */
    public void setCameraExtendConfig(CameraExtendConfig value) {
        this.cameraExtendConfig = value;
    }

    /**
     * Gets the value of the cameraSnapShotConfig property.
     * 
     * @return
     *     possible object is
     *     {@link CameraSnapShotConfig }
     *     
     */
    public CameraSnapShotConfig getCameraSnapShotConfig() {
        return cameraSnapShotConfig;
    }

    /**
     * Sets the value of the cameraSnapShotConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link CameraSnapShotConfig }
     *     
     */
    public void setCameraSnapShotConfig(CameraSnapShotConfig value) {
        this.cameraSnapShotConfig = value;
    }

    /**
     * Gets the value of the cameraRecordStreamConfig property.
     * 
     * @return
     *     possible object is
     *     {@link CameraRecordStreamConfig }
     *     
     */
    public CameraRecordStreamConfig getCameraRecordStreamConfig() {
        return cameraRecordStreamConfig;
    }

    /**
     * Sets the value of the cameraRecordStreamConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link CameraRecordStreamConfig }
     *     
     */
    public void setCameraRecordStreamConfig(CameraRecordStreamConfig value) {
        this.cameraRecordStreamConfig = value;
    }

}
