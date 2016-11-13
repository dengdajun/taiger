package support.core;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.tiger.entity.SysUser;
import support.controller.ExtJSBaseController;
import support.support.ExtJSBaseParameter;

import javax.servlet.http.HttpServletRequest;

public abstract class JavaEEFrameworkBaseController<E extends ExtJSBaseParameter> extends ExtJSBaseController<E> implements Constant {

	public SysUser getCurrentSysUser() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return (SysUser) request.getSession().getAttribute(SESSION_SYS_USER);
	}

}
