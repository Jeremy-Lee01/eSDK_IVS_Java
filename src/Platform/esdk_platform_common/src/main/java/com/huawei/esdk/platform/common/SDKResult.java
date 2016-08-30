package com.huawei.esdk.platform.common;

public class SDKResult<T> extends SDKErrorCode
{
    /**
     * UID
     */
    private static final long serialVersionUID = 1L;

    private T result;

    public T getResult()
    {
        return result;
    }

    public void setResult(T result)
    {
        this.result = result;
    }
}
