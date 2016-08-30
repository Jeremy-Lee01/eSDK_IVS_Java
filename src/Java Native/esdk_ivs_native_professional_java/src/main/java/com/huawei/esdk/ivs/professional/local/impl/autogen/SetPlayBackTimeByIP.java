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
package com.huawei.esdk.ivs.professional.local.impl.autogen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="playHandle" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "playHandle",
    "time"
})
@XmlRootElement(name = "setPlayBackTimeByIP")
public class SetPlayBackTimeByIP {

    @XmlSchemaType(name = "unsignedInt")
    protected long playHandle;
    protected int time;

    /**
     * 获取playHandle属性的值。
     * 
     */
    public long getPlayHandle() {
        return playHandle;
    }

    /**
     * 设置playHandle属性的值。
     * 
     */
    public void setPlayHandle(long value) {
        this.playHandle = value;
    }

    /**
     * 获取time属性的值。
     * 
     */
    public int getTime() {
        return time;
    }

    /**
     * 设置time属性的值。
     * 
     */
    public void setTime(int value) {
        this.time = value;
    }

}
