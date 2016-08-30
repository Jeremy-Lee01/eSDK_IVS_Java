package com.huawei.esdk.platform.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;

public abstract class OSUtils
{
    private static String os = null;

    private static String ipAddr = null;
    
    public static String getOSName()
    {
        if (os == null)
        {
            os = System.getProperty("os.name");
        }
        return os;
    }

    public static boolean isWindows()
    {
        return (getOSName().toLowerCase(Locale.getDefault()).indexOf("win") > -1);
    }

    public static boolean isMac()
    {
        return (getOSName().toLowerCase(Locale.getDefault()).indexOf("mac") > -1);
    }

    public static boolean isUnix()
    {
        return (getOSName().toLowerCase(Locale.getDefault()).indexOf("nix") > -1
                || getOSName().indexOf("nux") > -1 || getOSName()
                .indexOf("aix") > -1);
    }

    public static boolean isSolaris()
    {
        return (getOSName().toLowerCase(Locale.getDefault()).indexOf("sunos") > -1);
    }

    public static String getOSLineSepartor()
    {
        return System.getProperty("line.separator");
    }

    public static String getOsBit()
    {
        String realArch;
        String arch = System.getProperty("os.arch");
        realArch = arch.endsWith("64") ? "64" : "32";

        if (!"64".equals(realArch) && isWindows())
        {
            arch = System.getenv("PROCESSOR_ARCHITECTURE");
            String wow64Arch = System.getenv("PROCESSOR_ARCHITEW6432");
            realArch = arch.endsWith("64") || wow64Arch != null
                    && wow64Arch.endsWith("64") ? "64" : "32";
        }

        return realArch;
    }

    public static boolean isOS64Bit()
    {
        return "64".equals(getOsBit());
    }
    
    public static void setLocalIP(String ip)
    {
        if (null == ipAddr)
        {
            ipAddr = ip;
        }
    }
    
    public static String getLocalIP()
    {
        if (null == ipAddr)
        {
            try
            {
                return InetAddress.getLocalHost().getHostAddress();
            }
            catch (UnknownHostException e)
            {
                return "";
            }
        }
        else
        {
            return ipAddr;
        }
    }
}
