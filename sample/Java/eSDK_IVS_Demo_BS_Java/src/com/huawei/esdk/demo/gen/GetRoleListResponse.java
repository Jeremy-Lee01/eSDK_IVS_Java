
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
 *         &lt;element name="roleInfos" type="{esdk_ivs_professional_server}RoleInfos" minOccurs="0"/>
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
    "roleInfos"
})
@XmlRootElement(name = "getRoleListResponse")
public class GetRoleListResponse {

    protected int resultCode;
    protected RoleInfos roleInfos;

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
     * Gets the value of the roleInfos property.
     * 
     * @return
     *     possible object is
     *     {@link RoleInfos }
     *     
     */
    public RoleInfos getRoleInfos() {
        return roleInfos;
    }

    /**
     * Sets the value of the roleInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoleInfos }
     *     
     */
    public void setRoleInfos(RoleInfos value) {
        this.roleInfos = value;
    }

}
