package org.tiger.dao.impl;

import org.springframework.stereotype.Repository;
import org.tiger.dao.OpenClassDao;
import org.tiger.dao.QQDao;
import org.tiger.entity.OpenClass;
import org.tiger.entity.QQAdvertisement;
import support.dao.BaseDao;

/**
 * 角色的数据持久层的实现类
 */
@Repository
public class QQDaoImpl extends BaseDao<QQAdvertisement> implements QQDao {

	public QQDaoImpl() {
		super(QQAdvertisement.class);
	}


}
