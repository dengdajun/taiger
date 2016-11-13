package org.tiger.service.impl;

import org.springframework.stereotype.Service;
import org.tiger.dao.QQDao;
import org.tiger.entity.QQAdvertisement;
import org.tiger.service.QQAdvertisementService;
import support.service.BaseService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Service
public class QQAdvertisementImpl extends BaseService<QQAdvertisement> implements QQAdvertisementService {
    private QQDao qqDao;
    @Resource
    public void setNewsDao(QQDao qqDao) {
        this.qqDao = qqDao;
        this.dao=qqDao;
    }

}
