package org.tiger.service.impl;

import org.tiger.dao.DictDao;
import org.tiger.entity.Dict;
import org.tiger.service.DictService;
import org.springframework.stereotype.Service;
import support.service.BaseService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 字典的业务逻辑层的实现
 */
@Service
public class DictServiceImpl extends BaseService<Dict> implements DictService {

	private DictDao dictDao;

	@Resource
	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
		this.dao = dictDao;
	}

	public List<Dict> queryDictWithSubList(List<Dict> resultList) {
		List<Dict> dictList = new ArrayList<Dict>();
		for (Dict entity : resultList) {
			Dict dict = new Dict();
			dict.setId(entity.getId());
			dict.setDictKey(entity.getDictKey());
			dict.setDictValue(entity.getDictValue());
			dict.setSequence(entity.getSequence());
			dict.setParentDictkey(entity.getParentDictkey());
			dictList.add(dict);
		}
		return dictList;
	}

}
