
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ptzPresetInfoList" type="{esdk_ivs_professional_server}PTZPresetInfoList" minOccurs="0"/>
 *         &lt;element name="ptzPresetNum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resultCode",
    "ptzPresetInfoList",
    "ptzPresetNum"
})
@XmlRootElement(name = "getPTZPresetListResponse")
public class GetPTZPresetListResponse {

    protected int resultCode;
    protected PTZPresetInfoList ptzPresetInfoList;
    protected Integer ptzPresetNum;

    /**
     * Gets the value of the resultCode property.
     * 
     */
    public int getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     */
    public void setResultCode(int value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the ptzPresetInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link PTZPresetInfoList }
     *     
     */
    public PTZPresetInfoList getPtzPresetInfoList() {
        return ptzPresetInfoList;
    }

    /**
     * Sets the value of the ptzPresetInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PTZPresetInfoList }
     *     
     */
    public void setPtzPresetInfoList(PTZPresetInfoList value) {
        this.ptzPresetInfoList = value;
    }

    /**
     * Gets the value of the ptzPresetNum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPtzPresetNum() {
        return ptzPresetNum;
    }

    /**
     * Sets the value of the ptzPresetNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPtzPresetNum(Integer value) {
        this.ptzPresetNum = value;
    }

}
