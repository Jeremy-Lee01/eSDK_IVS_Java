package com.huawei.esdk.platform.config.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.huawei.esdk.platform.config.service.itf.IFileService;

public final class FileService implements IFileService
{
    private static final Logger LOGGER = Logger.getLogger(FileService.class);

    private static IFileService instance = new FileService();
    
    private FileService()
    {
    }
    
    public static IFileService getInstance()
    {
        return instance;
    }
    
    /**
     * * @see
     * com.huawei.esdk.platform.tool.service.impl.IFileService#synFile(java
     * .lang.String, java.lang.String)
     */
    @Override
    public boolean synFile(String destDir, String filePath)
    {
        return syncFileBySharingFolder(filePath, destDir);
    }
    
    private boolean syncFileBySharingFolder(String filePath, String destDir)
    {
        try
        {
            File srcFile = new File(filePath);
            FileUtils.copyFileToDirectory(srcFile, new File(destDir));
            return true;
        }
        catch (IOException e)
        {
            LOGGER.error("", e);
        }
        
        return false;
    }
}
