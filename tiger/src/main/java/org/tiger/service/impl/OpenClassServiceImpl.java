package org.tiger.service.impl;

import org.springframework.stereotype.Service;
import org.tiger.dao.OpenClassDao;
import org.tiger.entity.OpenClass;
import org.tiger.service.OpenClassService;
import support.service.BaseService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Service
public class OpenClassServiceImpl extends BaseService<OpenClass> implements OpenClassService {
    private OpenClassDao openClassDao;
    @Resource

    public void setOpenClassDao(OpenClassDao openClassDao) {
        this.openClassDao = openClassDao;
        this.dao=openClassDao;
    }




}
