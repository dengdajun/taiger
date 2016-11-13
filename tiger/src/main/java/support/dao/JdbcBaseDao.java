package support.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.Resource;
import javax.sql.DataSource;


public class JdbcBaseDao extends JdbcDaoSupport {

	@Resource(name = "dataSource")
	public void setDS(DataSource dataSource) {
		setDataSource(dataSource);
	}

}
