package com.huawei.esdk.platform.exception;

import com.huawei.esdk.platform.common.exception.SDKException;

public class ProtocolAdapterException extends SDKException
{
    /**
     * UUID
     */
    private static final long serialVersionUID = 1L;

    private Integer errorCode;
    
    /**
     * Constructs a new exception with <code>null</code> as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public ProtocolAdapterException()
    {
        super("");
    }

    /**
     * Constructs a new exception with the specified detail message. The cause
     * is not initialized, and may subsequently be initialized by a call to
     * {@link #initCause}.
     * 
     * @param message the detail message. The detail message is saved for later
     *        retrieval by the {@link #getMessage()} method.
     */
    public ProtocolAdapterException(String message, Integer errorCode)
    {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * <p>
     * Note that the detail message associated with <code>cause</code> is
     * <i>not</i> automatically incorporated in this exception's detail message.
     * 
     * @param message the detail message (which is saved for later retrieval by
     *        the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method). (A <tt>null</tt> value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @param errorCode
     */
    public ProtocolAdapterException(String message, Throwable cause, Integer errorCode)
    {
        super(message, cause);
        this.errorCode = errorCode;
    }

    /**
     * Constructs a new exception with the specified cause and a detail message
     * of <tt>(cause==null ? null : cause.toString())</tt> (which typically
     * contains the class and detail message of <tt>cause</tt>). This
     * constructor is useful for exceptions that are little more than wrappers
     * for other throwables (for example,
     * {@link java.security.PrivilegedActionException}).
     * 
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method). (A <tt>null</tt> value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     */
    public ProtocolAdapterException(Throwable cause)
    {
        super(cause);
    }

    public Integer getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode)
    {
        this.errorCode = errorCode;
    }
}
