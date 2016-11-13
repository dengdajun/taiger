package org.tiger.dao.impl;

import org.tiger.dao.NewsDao;
import org.tiger.entity.News;
import org.springframework.stereotype.Repository;
import support.dao.BaseDao;

/**
 * 角色的数据持久层的实现类
 */
@Repository
public class NewsDaoImpl extends BaseDao<News> implements NewsDao {

	public NewsDaoImpl() {
		super(News.class);
	}


}
