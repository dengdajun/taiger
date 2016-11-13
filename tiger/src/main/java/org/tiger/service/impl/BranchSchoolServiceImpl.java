package org.tiger.service.impl;

import org.springframework.stereotype.Service;
import org.tiger.dao.BranchSchoolDao;
import org.tiger.entity.BranchSchool;
import org.tiger.service.BranchSchoolService;
import support.service.BaseService;

import javax.annotation.Resource;

/**
 * Created by YoungMan on 2016/11/10.
 */
@Service
public class BranchSchoolServiceImpl extends BaseService<BranchSchool> implements BranchSchoolService {
    private BranchSchoolDao branchSchoolDao;

    @Resource
    public void setBranchSchoolDao(BranchSchoolDao branchSchoolDao) {
        this.branchSchoolDao = branchSchoolDao;
        this.dao = branchSchoolDao;
    }
}
