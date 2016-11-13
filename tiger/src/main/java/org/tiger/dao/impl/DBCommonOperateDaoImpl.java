package org.tiger.dao.impl;

import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Entity;

import org.tiger.dao.DBCommonOperateDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import support.support.QueryResult;


/**
 * @author 亦菲女神 数据库公共操作实现类
 */
@Repository
public class DBCommonOperateDaoImpl implements DBCommonOperateDao {
	@Autowired
	protected HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 添加一条记录
	 * 
	 * @param entityClass
	 * @param entity
	 * @param <T>
	 */

	@Override
	public <T> void add(Class<T> entityClass, Object entity) {
		hibernateTemplate.save(getEntityName(entityClass), entity);
	}

	/**
	 * 删除一个记录
	 * 
	 * @param entity
	 */

	@Override
	public void delete(Object entity) {
		hibernateTemplate.delete(entity);
	}

	/**
	 * 更新数据
	 * 
	 * @param entityClass
	 * @param entity
	 * @param <T>
	 */
	@Override
	public <T> void update(Class<T> entityClass, Object entity) {
		hibernateTemplate.update(getEntityName(entityClass), entity);
	}

	/**
	 * 查询单个记录
	 * 
	 * @param entityClass
	 * @param entityId
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T find(Class<T> entityClass, Object entityId) {
		List<T> list = (List<T>) hibernateTemplate.find("from "
				+ getEntityName(entityClass) + " o where o.id=?", entityId);
		if (list.size() > 0)
			return list.get(0);
		return null;
	}

	/**
	 * 查询方法(不排序)
	 * 
	 * @param entityClass
	 * @param whereHQL
	 * @param params
	 * @param <T>
	 * @return
	 */

	@Override
	public <T> List<T> find(Class<T> entityClass, String whereHQL,
			Object[] params) {
		return find(entityClass, whereHQL, params, null);
	}

	/**
	 * 查询方法,根据提供的key排序
	 * 
	 * @param entityClass
	 * @param whereHQL
	 * @param params
	 * @param order
	 * @param <T>
	 * @return
	 */

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> find(final Class<T> entityClass, final String whereHQL,
			final Object[] params, final LinkedHashMap<String, String> order) {
		return (List<T>) hibernateTemplate
				.executeWithNativeSession(new HibernateCallback<Object>() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery("from "
								+ getEntityName(entityClass) + " o "
								+ (whereHQL == null ? "" : "where " + whereHQL)
								+ " " + buildOrderBy(order));
						setQueryParams(query, params);
						query.setCacheable(true);
						return query.list();
					}
				});
	}

	/**
	 * 查询分页数据
	 * 
	 * @param entityClass
	 * @param startIndex
	 *            开始索引
	 * @param resultCount
	 *            符合条件的最大结果数
	 * @param <T>
	 * @return
	 */

	@Override
	public <T> QueryResult<T> getScrollData(Class<T> entityClass,
											int startIndex, int resultCount) {
		return getScrollData(entityClass, startIndex, resultCount, null, null,
				null);
	}

	/**
	 * 查询分页数据
	 * 
	 * @param entityClass
	 * @param startIndex
	 * @param resultCount
	 * @param <T>
	 * @return
	 */

	@Override
	public <T> QueryResult<T> getScrollData(Class<T> entityClass,
			int startIndex, int resultCount, String whereHQL, Object[] params) {
		return getScrollData(entityClass, startIndex, resultCount, whereHQL,
				params, null);
	}

	/**
	 * 查询分页数据 ，有条件
	 * 
	 * @param entityClass
	 * @param startIndex
	 * @param resultCount
	 * @param <T>
	 * @return
	 */

	@Override
	public <T> QueryResult<T> getScrollData(Class<T> entityClass,
			int startIndex, int resultCount, LinkedHashMap<String, String> order) {
		return getScrollData(entityClass, startIndex, resultCount, null, null,
				order);
	}

	/**
	 * 查询分页数据，要排序
	 * 
	 * @param entityClass
	 * @param startIndex
	 * @param resultCount
	 * @param order
	 * @param <T>
	 * @return
	 */
	@Override
	public <T> QueryResult<T> getScrollData(final Class<T> entityClass,
			final int startIndex, final int resultCount, final String whereHQL,
			final Object[] params, final LinkedHashMap<String, String> order) {
		@SuppressWarnings("unchecked")
		final QueryResult<T> queryResult = (QueryResult<T>) hibernateTemplate
				.executeWithNativeSession(new HibernateCallback<Object>() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException {
						QueryResult<T> queryResult = new QueryResult<T>();

						Query query = session.createQuery("from "
								+ getEntityName(entityClass) + " o "
								+ (whereHQL == null ? "" : "where " + whereHQL)
								+ " " + buildOrderBy(order));
						setQueryParams(query, params);
						if (startIndex >= 0) {
							query.setFirstResult(startIndex);
							query.setMaxResults(resultCount);
						}
						query.setCacheable(true);
						queryResult.setResultList(query.list());
						return queryResult;
					}
				});

		hibernateTemplate
				.executeWithNativeSession(new HibernateCallback<Object>() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query qr = session
								.createQuery("select count(o) from "
										+ getEntityName(entityClass)
										+ " o "
										+ (whereHQL == null ? "" : "where "
												+ whereHQL));
						setQueryParams(qr, params);
						qr.setCacheable(true);
						queryResult.setTotalCount((Long) qr.uniqueResult());
						return queryResult;
					}
				});

		return queryResult;
	}

	protected void setQueryParams(Query query, Object[] params) {
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
	}

	protected String buildOrderBy(LinkedHashMap<String, String> order) {
		if (order == null || order.size() == 0) {
			return "";
		}
		StringBuilder orderHQL = new StringBuilder();
		orderHQL.append(" order by ");
		for (String key : order.keySet()) {
			orderHQL.append(key).append(" ").append(order.get(key)).append(",");
		}
		orderHQL.deleteCharAt(orderHQL.length() - 1);
		return orderHQL.toString();
	}

	protected <T> String getEntityName(Class<T> entityClass) {
		String entityName = entityClass.getSimpleName();
		Entity entity = entityClass.getAnnotation(Entity.class);
		if (entity.name() != null && !"".equals(entity.name())) {
			entityName = entity.name();
		}
		return entityName;
	}

	// public <T> QueryResult<T> getScrollData(final int startIndex, final int
	// resultCount, final String hql, final Object[]params) {
	// final QueryResult<T> queryResult = (QueryResult<T>)
	// hibernateTemplate.executeWithNativeSession(new
	// HibernateCallback<Object>() {
	// @Override
	// public Object doInHibernate(Session session) throws HibernateException {
	// QueryResult<T> queryResult = new QueryResult<T>();
	// Query query = session.createQuery(hql);
	// setQueryParams(query, params);
	// if (startIndex >= 0) {
	// query.setFirstResult(startIndex);
	// query.setMaxResults(resultCount);
	// }
	// //query.setCacheable(true);
	// queryResult.setList(query.list());
	// return queryResult;
	// }
	// });
	// hibernateTemplate.executeWithNativeSession(new
	// HibernateCallback<Object>() {
	// @Override
	// public Object doInHibernate(Session session) throws HibernateException {
	// Query qr = session.createQuery("select count(o) "+hql);
	// setQueryParams(qr, params);
	// //qr.setCacheable(true);
	// queryResult.setTotalRecord((Long) qr.uniqueResult());
	// return queryResult;
	// }
	// });
	//
	// return queryResult;
	// }
}
