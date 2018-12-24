package com.worriesconsult.service;

import com.worriesconsult.bean.DownloadFile;

public interface DownloadFileService {

    int insert(DownloadFile downloadFile);

    int deleteByFileUrl(String fileUrl);

    DownloadFile selectById(Long id);

    DownloadFile selectByFileUrl(String fileUrl);
}
