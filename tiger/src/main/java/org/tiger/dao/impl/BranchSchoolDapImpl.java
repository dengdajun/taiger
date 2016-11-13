package org.tiger.dao.impl;

import org.springframework.stereotype.Repository;
import org.tiger.dao.BranchSchoolDao;
import org.tiger.entity.BranchSchool;
import support.dao.BaseDao;

/**
 * Created by YoungMan on 2016/11/10.
 */
@Repository
public class BranchSchoolDapImpl extends BaseDao<BranchSchool> implements BranchSchoolDao {
    public BranchSchoolDapImpl() {
        super(BranchSchool.class);
    }
}
