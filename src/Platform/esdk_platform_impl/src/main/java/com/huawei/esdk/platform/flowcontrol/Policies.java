package com.huawei.esdk.platform.flowcontrol;

import com.huawei.esdk.platform.flowcontrol.itf.IPolicies;

public class Policies implements IPolicies
{
    @Override
    public int loadEvaluate(long visitCount)
    {
        return 0;
    }
}
