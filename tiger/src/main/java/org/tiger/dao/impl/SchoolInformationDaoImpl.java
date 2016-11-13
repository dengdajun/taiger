package org.tiger.dao.impl;

import org.tiger.dao.SchoolInformationDao;
import org.tiger.entity.SchoolInformation;
import org.springframework.stereotype.Repository;
import support.dao.BaseDao;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Repository
public class SchoolInformationDaoImpl extends BaseDao<SchoolInformation> implements SchoolInformationDao {
    public SchoolInformationDaoImpl(){super(SchoolInformation.class);}
}
