package org.tiger.service.impl;

import org.tiger.dao.SchoolInformationDao;
import org.tiger.entity.SchoolInformation;
import org.tiger.service.SchoolInformationService;
import org.springframework.stereotype.Service;
import support.service.BaseService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Service
public class SchoolInformationServiceImpl extends BaseService<SchoolInformation> implements SchoolInformationService {
    private SchoolInformationDao schoolInformationDao;
    @Resource

    public void setSchoolInformationDao(SchoolInformationDao schoolInformationDao) {
        this.schoolInformationDao = schoolInformationDao;
        this.dao=schoolInformationDao;
    }
}
