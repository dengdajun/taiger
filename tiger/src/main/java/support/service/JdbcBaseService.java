package support.service;

import org.springframework.transaction.annotation.Transactional;
import support.dao.JdbcBaseDao;

import javax.annotation.Resource;


@Transactional
public class JdbcBaseService {

	@Resource
	protected JdbcBaseDao jdbcBaseDao;

}
