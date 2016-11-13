package org.tiger.dao;

import org.tiger.entity.Information;
import support.dao.Dao;

import java.util.List;

/**
 * 信息发布的数据持久层的接口
 */
public interface InformationDao extends Dao<Information> {

	// 生成信息的索引
	void indexingInformation();

	// 全文检索信息
	List<Information> queryByInformationName(String name);

}
