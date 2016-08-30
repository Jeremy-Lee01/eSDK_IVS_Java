
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VideoHideAlarm complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VideoHideAlarm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enableVideoHide" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sensitivity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="autoClearAlarmTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="guardTimeNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="guardTimeList" type="{esdk_ivs_professional_server}TimeSpanList"/>
 *         &lt;element name="areaNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rectAreaList" type="{esdk_ivs_professional_server}RectInfoList"/>
 *         &lt;element name="reserve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VideoHideAlarm", propOrder = {
    "enableVideoHide",
    "sensitivity",
    "autoClearAlarmTime",
    "guardTimeNum",
    "guardTimeList",
    "areaNum",
    "rectAreaList",
    "reserve"
})
public class VideoHideAlarm {

    protected int enableVideoHide;
    protected int sensitivity;
    protected int autoClearAlarmTime;
    protected int guardTimeNum;
    @XmlElement(required = true)
    protected TimeSpanList guardTimeList;
    protected int areaNum;
    @XmlElement(required = true)
    protected RectInfoList rectAreaList;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the enableVideoHide property.
     * 
     */
    public int getEnableVideoHide() {
        return enableVideoHide;
    }

    /**
     * Sets the value of the enableVideoHide property.
     * 
     */
    public void setEnableVideoHide(int value) {
        this.enableVideoHide = value;
    }

    /**
     * Gets the value of the sensitivity property.
     * 
     */
    public int getSensitivity() {
        return sensitivity;
    }

    /**
     * Sets the value of the sensitivity property.
     * 
     */
    public void setSensitivity(int value) {
        this.sensitivity = value;
    }

    /**
     * Gets the value of the autoClearAlarmTime property.
     * 
     */
    public int getAutoClearAlarmTime() {
        return autoClearAlarmTime;
    }

    /**
     * Sets the value of the autoClearAlarmTime property.
     * 
     */
    public void setAutoClearAlarmTime(int value) {
        this.autoClearAlarmTime = value;
    }

    /**
     * Gets the value of the guardTimeNum property.
     * 
     */
    public int getGuardTimeNum() {
        return guardTimeNum;
    }

    /**
     * Sets the value of the guardTimeNum property.
     * 
     */
    public void setGuardTimeNum(int value) {
        this.guardTimeNum = value;
    }

    /**
     * Gets the value of the guardTimeList property.
     * 
     * @return
     *     possible object is
     *     {@link TimeSpanList }
     *     
     */
    public TimeSpanList getGuardTimeList() {
        return guardTimeList;
    }

    /**
     * Sets the value of the guardTimeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeSpanList }
     *     
     */
    public void setGuardTimeList(TimeSpanList value) {
        this.guardTimeList = value;
    }

    /**
     * Gets the value of the areaNum property.
     * 
     */
    public int getAreaNum() {
        return areaNum;
    }

    /**
     * Sets the value of the areaNum property.
     * 
     */
    public void setAreaNum(int value) {
        this.areaNum = value;
    }

    /**
     * Gets the value of the rectAreaList property.
     * 
     * @return
     *     possible object is
     *     {@link RectInfoList }
     *     
     */
    public RectInfoList getRectAreaList() {
        return rectAreaList;
    }

    /**
     * Sets the value of the rectAreaList property.
     * 
     * @param value
     *     allowed object is
     *     {@link RectInfoList }
     *     
     */
    public void setRectAreaList(RectInfoList value) {
        this.rectAreaList = value;
    }

    /**
     * Gets the value of the reserve property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserve() {
        return reserve;
    }

    /**
     * Sets the value of the reserve property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserve(String value) {
        this.reserve = value;
    }

}
