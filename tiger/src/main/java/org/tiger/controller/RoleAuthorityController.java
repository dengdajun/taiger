package org.tiger.controller;

import org.tiger.service.RoleAuthorityService;
import support.core.JavaEEFrameworkBaseController;
import org.tiger.entity.RoleAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 角色权限的控制层
 */
@Controller
@RequestMapping("/sys/roleauthority")
public class RoleAuthorityController extends JavaEEFrameworkBaseController<RoleAuthority> {

	@Resource
	private RoleAuthorityService roleAuthorityService;

	// 保存角色权限
	@RequestMapping(value = "/saveRoleAuthority")
	public void saveRoleAuthority(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String roleKey = request.getParameter("roleKey");
		String menuCode = request.getParameter("menuCode");
		roleAuthorityService.deleteByProperties("roleKey", roleKey);
		String[] menuCodesValue = menuCode.split(",");
		for (int i = 0; i < menuCodesValue.length; i++) {
			RoleAuthority roleAuthority = new RoleAuthority();
			roleAuthority.setRoleKey(roleKey);
			roleAuthority.setMenuCode(menuCodesValue[i]);
			roleAuthorityService.persist(roleAuthority);
		}
		writeJSON(response, "{success:true}");
	}

}
