package org.tiger.service;

import org.tiger.entity.Dict;
import support.service.Service;

import java.util.List;

/**
 * 字典的业务逻辑层的接口
 */
public interface DictService extends Service<Dict> {

	List<Dict> queryDictWithSubList(List<Dict> resultList);

}
