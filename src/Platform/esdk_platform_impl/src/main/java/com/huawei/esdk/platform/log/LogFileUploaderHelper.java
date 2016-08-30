package com.huawei.esdk.platform.log;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.NumberUtils;
import com.huawei.esdk.platform.common.utils.StringUtils;

public abstract class LogFileUploaderHelper
{
    private static final Logger LOGGER = Logger.getLogger(LogFileUploaderHelper.class);
    
    private static final String log_backup_run = "/backup/run";
    private static final String log_backup_interface = "/backup/interface";
    private static final String log_backup_operation = "/backup/operation";
    
    private static String loggerPath;
    
    static
    {
        String file = "";
        @SuppressWarnings("unchecked")
        Enumeration<Appender> appenders = Logger.getRootLogger().getAllAppenders();
        while (appenders.hasMoreElements())
        {
            Appender app = appenders.nextElement();
            if (app instanceof FileAppender)
            {
                file = ((FileAppender)app).getFile();
                break;
            }
        }
        
        if (StringUtils.isNotEmpty(file))
        {
            File logFile = new File(file);
            if (logFile.isFile())
            {
                file = logFile.getParent();
            }
        }
        
        loggerPath = file;
        
        String[] dirNames = new String[] {log_backup_run, log_backup_interface, log_backup_operation};
        File dir;
        for (String dirName : dirNames)
        {
            dir = new File(loggerPath + dirName);
            if (!dir.exists())
            {
                dir.mkdirs();
            }
        }
    }
    
    public static void setLoggerLevel(String packageName, String levelName)
    {
        LOGGER.debug("packageName=" + packageName + ", levelName=" + levelName);
        Level level = Level.toLevel(levelName);
        if ("".equals(packageName))
        {
            Logger logger = LogManager.getRootLogger();
            logger.setLevel(level);
        }
        Logger logger = LogManager.getLogger(packageName);
        if (null != logger)
        {
            logger.setLevel(level);
        }
    }
    
    public static String getLogPath(String logType)
    {
        String file = loggerPath;
        if ("interface".equalsIgnoreCase(logType))
        {
            file = loggerPath + File.separator + "interface_log";
        }
        else if ("operation".equalsIgnoreCase(logType))
        {
            file = loggerPath + File.separator + "operation_log";
        }
        
        return file;
    }
    
    public static String getOldestLogFile(String logType)
    {
        List<String> list = getLogFiles(new File(getLogPath(logType)));
        if (list.size() > 0)
        {
            return list.get(0);
        }
        
        return null;
    }
    
    public static List<String> getLogFiles(File dir)
    {
        List<String> result = new ArrayList<String>();
        File[] files = null;
        if (null != dir)
        {
            files = dir.listFiles();
        }
        
        if (null != files)
        {
            Arrays.sort(files, new Comparator<File>()
            {
                public int compare(File f1, File f2)
                {
                    return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
                }
            });
            
            for (File file : files)
            {
                if (!file.isDirectory())
                {
                    LOGGER.debug("file name=" + file.getName());
                    if (file.getName().startsWith("eSDK-Server"))
                    {
                        
                        result.add(file.getPath());
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void deleteLogFile(String fileNameWithPath)
    {
        File file = new File(fileNameWithPath);
        if (file.exists() && !file.delete())
        {
            LOGGER.warn(fileNameWithPath + " deleted failed");
        }
    }
    
    public static boolean isBackLogFile(String fileNameWithPath)
    {
        if (fileNameWithPath.contains(".log."))
        {
            return true;
        }
        return false;
    }

    public static void backup(String logFile, String logType)
    {
        File src = new File(logFile);
        
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
        String fileName = src.getName() + "." + sf.format(new Date()) + ".bak";
        
        
        File dest;
        
        if ("interface".equalsIgnoreCase(logType))
        {
            dest = new File(loggerPath + log_backup_interface + File.separator + fileName);
        }
        else if ("operation".equalsIgnoreCase(logType))
        {
            dest = new File(loggerPath + log_backup_operation + File.separator + fileName);
        }
        else
        {
            dest = new File(loggerPath + log_backup_run + File.separator + fileName);
        }
        
        try
        {
            FileUtils.moveFile(src, dest);
        }
        catch (IOException e)
        {
            LOGGER.error("", e);
            LOGGER.info("back file " + src.getName() + " failed");
        }
    }
    
    public static void deleteBackupFile()
    {
        int remainDays = NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("platform.backup.log.file.delete", "90"));
        String[] dirNames = new String[] {log_backup_run, log_backup_interface, log_backup_operation};
        final Long remainTime = new Date().getTime() - remainDays * 24 * 60 * 60 * 1000L;
        
        File dir;
        File[] files;
        for (String dirName : dirNames)
        {
            dir = new File(loggerPath + dirName);
            if (dir.exists())
            {
                files = dir.listFiles(new FileFilter()
                {
                    @Override
                    public boolean accept(File file)
                    {
                        if (file.lastModified() < remainTime)
                        {
                            return true;
                        }
                        return false;
                    }
                    
                });
                
                if (null != files)
                {
                    for (File file : files)
                    {
                        if (file.delete())
                        {
                            LOGGER.info("The backup file " + file.getName() + " was deleted successed!");
                        }
                        else
                        {
                            LOGGER.info("The backup file " + file.getName() + " was deleted failed!");
                        }
                    }
                }
            }
        }
    }
}
