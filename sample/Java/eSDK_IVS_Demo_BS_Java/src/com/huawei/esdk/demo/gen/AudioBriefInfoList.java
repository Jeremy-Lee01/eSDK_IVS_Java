
package com.huawei.esdk.demo.gen;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AudioBriefInfoList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AudioBriefInfoList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="audioBriefInfo" type="{esdk_ivs_professional_server}AudioBriefInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AudioBriefInfoList", propOrder = {
    "audioBriefInfo"
})
public class AudioBriefInfoList {

    @XmlElement(required = true)
    protected List<AudioBriefInfo> audioBriefInfo;

    /**
     * Gets the value of the audioBriefInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the audioBriefInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAudioBriefInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AudioBriefInfo }
     * 
     * 
     */
    public List<AudioBriefInfo> getAudioBriefInfo() {
        if (audioBriefInfo == null) {
            audioBriefInfo = new ArrayList<AudioBriefInfo>();
        }
        return this.audioBriefInfo;
    }

}
