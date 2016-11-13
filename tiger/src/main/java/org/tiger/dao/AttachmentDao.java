package org.tiger.dao;

import org.tiger.entity.Attachment;
import support.dao.Dao;

import java.util.List;

/**
 * 附件的数据持久层的接口
 */
public interface AttachmentDao extends Dao<Attachment> {

	List<Object[]> queryFlowerList(String epcId);

	void deleteAttachmentByForestryTypeId(Long umTypeId);

	List<Object[]> querySensorList();

}
