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
package com.huawei.esdk.ivs.domain.model.bean;

public class PwdConsist
{
    private int capital;
    
    private int lowercase;
    
    private int figure;
    
    private int specialChar;
    
    private String reserve;
    
    public int getCapital()
    {
        return capital;
    }
    
    public void setCapital(int capital)
    {
        this.capital = capital;
    }
    
    public int getLowercase()
    {
        return lowercase;
    }
    
    public void setLowercase(int lowercase)
    {
        this.lowercase = lowercase;
    }
    
    public int getFigure()
    {
        return figure;
    }
    
    public void setFigure(int figure)
    {
        this.figure = figure;
    }
    
    public int getSpecialChar()
    {
        return specialChar;
    }
    
    public void setSpecialChar(int specialChar)
    {
        this.specialChar = specialChar;
    }
    
    public String getReserve()
    {
        return reserve;
    }
    
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }
    
}
