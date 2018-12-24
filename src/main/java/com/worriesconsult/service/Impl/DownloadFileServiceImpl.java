package com.worriesconsult.service.Impl;


import com.worriesconsult.bean.DownloadFile;
import com.worriesconsult.dao.DownloadFileDao;
import com.worriesconsult.service.DownloadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownloadFileServiceImpl implements DownloadFileService {

    @Autowired
    DownloadFileDao downloadFileDao;

    @Override
    public int insert(DownloadFile downloadFile) {
        return downloadFileDao.insert(downloadFile);
    }

    @Override
    public int deleteByFileUrl(String fileUrl) {
        return downloadFileDao.deleteByFileUrl(fileUrl);
    }

    @Override
    public DownloadFile selectById(Long id) {
        return downloadFileDao.selectById(id);
    }

    @Override
    public DownloadFile selectByFileUrl(String fileUrl) {
        return downloadFileDao.selectByFileUrl(fileUrl);
    }
}
