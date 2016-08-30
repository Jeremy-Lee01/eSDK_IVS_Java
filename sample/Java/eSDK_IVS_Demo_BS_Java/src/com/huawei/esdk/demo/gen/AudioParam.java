
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AudioParam complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AudioParam">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pitch" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="volume" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="inputType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dataFormat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sampleRate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="channel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gain" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sampleBits" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "AudioParam", propOrder = {
    "pitch",
    "volume",
    "inputType",
    "dataFormat",
    "sampleRate",
    "channel",
    "gain",
    "sampleBits",
    "reserve"
})
public class AudioParam {

    protected int pitch;
    protected int volume;
    protected int inputType;
    protected int dataFormat;
    protected int sampleRate;
    protected int channel;
    protected int gain;
    protected int sampleBits;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the pitch property.
     * 
     */
    public int getPitch() {
        return pitch;
    }

    /**
     * Sets the value of the pitch property.
     * 
     */
    public void setPitch(int value) {
        this.pitch = value;
    }

    /**
     * Gets the value of the volume property.
     * 
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     */
    public void setVolume(int value) {
        this.volume = value;
    }

    /**
     * Gets the value of the inputType property.
     * 
     */
    public int getInputType() {
        return inputType;
    }

    /**
     * Sets the value of the inputType property.
     * 
     */
    public void setInputType(int value) {
        this.inputType = value;
    }

    /**
     * Gets the value of the dataFormat property.
     * 
     */
    public int getDataFormat() {
        return dataFormat;
    }

    /**
     * Sets the value of the dataFormat property.
     * 
     */
    public void setDataFormat(int value) {
        this.dataFormat = value;
    }

    /**
     * Gets the value of the sampleRate property.
     * 
     */
    public int getSampleRate() {
        return sampleRate;
    }

    /**
     * Sets the value of the sampleRate property.
     * 
     */
    public void setSampleRate(int value) {
        this.sampleRate = value;
    }

    /**
     * Gets the value of the channel property.
     * 
     */
    public int getChannel() {
        return channel;
    }

    /**
     * Sets the value of the channel property.
     * 
     */
    public void setChannel(int value) {
        this.channel = value;
    }

    /**
     * Gets the value of the gain property.
     * 
     */
    public int getGain() {
        return gain;
    }

    /**
     * Sets the value of the gain property.
     * 
     */
    public void setGain(int value) {
        this.gain = value;
    }

    /**
     * Gets the value of the sampleBits property.
     * 
     */
    public int getSampleBits() {
        return sampleBits;
    }

    /**
     * Sets the value of the sampleBits property.
     * 
     */
    public void setSampleBits(int value) {
        this.sampleBits = value;
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
