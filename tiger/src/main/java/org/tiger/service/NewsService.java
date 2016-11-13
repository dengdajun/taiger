package org.tiger.service;

import org.tiger.entity.News;
import support.service.Service;
import support.support.QueryResult;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public interface NewsService extends Service<News>{
    List<News> getNextNews(int nid, int ntype);
    List<News> getUpNews(int nid,int ntype);
    QueryResult<News> getDataList(int page, int resultCount, String hql, List params, LinkedHashMap<String, String> sortCondition);
}
