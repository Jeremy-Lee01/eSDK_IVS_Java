package com.huawei.esdk.platform.debugging;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.debugging.itf.IRemoteDebugging;

public class DebuggingManager extends UnicastRemoteObject
    implements IRemoteDebugging
{
    /**
     * UID
     */
    private static final long serialVersionUID = -3677283869364699282L;

    private static final Logger LOGGER = Logger.getLogger(DebuggingManager.class);
    
    private static String port = ConfigManager.getInstance().getValue("debugging.port");
    
    
    static class DebuggingRMIClientSocketFactory implements RMIClientSocketFactory, Serializable
    {

        /**
         * UID
         */
        private static final long serialVersionUID = -8250629157365306228L;

        @Override
        public Socket createSocket(String host, int port)
            throws IOException
        {
            return new Socket(host, port);
        }
        
    }
    
    static class DebuggingRMIServerSocketFactory implements RMIServerSocketFactory, Serializable
    {

        /**
         * UID
         */
        private static final long serialVersionUID = 3341818630198298082L;

        @Override
        public ServerSocket createServerSocket(int port)
            throws IOException
        {
            return new ServerSocket(port, 0, InetAddress.getLoopbackAddress());
        }
        
    }
    
    public DebuggingManager() throws RemoteException
    {
        super(Integer.parseInt(port), new DebuggingRMIClientSocketFactory(), new DebuggingRMIServerSocketFactory());
    }

    public boolean setLoggerLevel(String packageName, String levelName)
    {
        LOGGER.debug("packageName=" + packageName + ", levelName="+ levelName);
        Level level = Level.toLevel(levelName);
        if ("".equals(packageName))
        {
            Logger logger = LogManager.getRootLogger();
            logger.setLevel(level);
            if (logger.getLevel().toString().equalsIgnoreCase(levelName))
            {
                return true;
            }
            return false;
        }
        Logger logger = LogManager.getLogger(packageName);
        if (null != logger)
        {
            logger.setLevel(level);
            Level le = logger.getLevel();
            if (null != le && le.toString().equalsIgnoreCase(levelName))
            {
                return true;
            }
        }
        return false;
    }
    
    public void destroy()
    {
        try
        {
            UnicastRemoteObject.unexportObject(this, true);
        }
        catch (NoSuchObjectException e)
        {
            LOGGER.error("", e);
        }
    }
}
