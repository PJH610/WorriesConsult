package com.worriesconsult.dao;

import com.worriesconsult.bean.DownloadFile;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadFileDao {

    int insert(DownloadFile downloadFile);

    int deleteByFileUrl(String fileUrl);

    DownloadFile selectById(Long id);

    DownloadFile selectByFileUrl(String fileUrl);

}
