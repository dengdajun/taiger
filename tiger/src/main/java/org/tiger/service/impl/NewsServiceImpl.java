package org.tiger.service.impl;

import org.tiger.dao.DBCommonOperateDao;
import org.tiger.dao.NewsDao;
import org.tiger.entity.News;
import org.tiger.service.NewsService;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import support.service.BaseService;
import support.support.QueryResult;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Service
public class NewsServiceImpl extends BaseService<News> implements NewsService {
    private NewsDao newsDao;
    @Resource
    public void setNewsDao(NewsDao newsDao) {
        this.newsDao = newsDao;
        this.dao=newsDao;
    }
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    DBCommonOperateDao dbCommonOperateDao;
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<News> getNextNews(int nid,int ntype) {
        String sql = "select * from news where nid>"+nid+" and ntype="+ntype+" order by date desc limit 0,1 ";
        List<News> list = sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(
                CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<News> getUpNews(int nid,int ntype) {
        String sql = "select * from news where nid<"+nid+" and ntype="+ntype+" order by date desc limit 0,1 ";
        List<News> list = sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(
                CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public QueryResult<News> getDataList(int page, int resultCount, String hql, List params, LinkedHashMap<String, String> sortCondition) {
        if (hql.length() == 0) {
            return dbCommonOperateDao.getScrollData(News.class, page, resultCount, sortCondition);
        } else {
            hql = hql.substring(3);
            return dbCommonOperateDao.getScrollData(News.class, page, resultCount, hql, params.toArray(), sortCondition);

        }
    }
}
