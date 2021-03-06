package org.tiger.controller;

import org.tiger.entity.Attachment;
import org.tiger.constant.Constants;
import org.tiger.entity.Authority;
import org.tiger.entity.Role;
import org.tiger.entity.SysUser;
import org.tiger.service.AttachmentService;
import org.tiger.service.AuthorityService;
import org.tiger.service.RoleService;
import support.core.Constant;
import support.core.JavaEEFrameworkBaseController;
import org.tiger.service.SysUserService;
import support.support.ExtJSBaseParameter;
import support.support.JqGridPageView;
import support.support.QueryResult;
import support.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.SimpleEmail;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 用户的控制层
 */
@Controller
@RequestMapping("/sys/sysuser")
public class SysUserController extends JavaEEFrameworkBaseController<SysUser> implements Constant {

    private static final Log log = LogFactory.getLog(SysUserController.class);
    @Resource
    private SysUserService sysUserService;
    @Resource
    private AuthorityService authorityService;
    @Resource
    private RoleService roleService;
    @Resource
    AttachmentService attachmentService;


    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // 登录
    @RequestMapping("/login")
    public void login(SysUser sysUserModel, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> result = new HashMap<String, Object>();
        String code = request.getParameter("code");
        SysUser sysUser = sysUserService.getByProerties("phone", sysUserModel.getPhone());

        Session session1=SecurityUtils.getSubject().getSession();
        String sessionCode = (String) session1.getAttribute(Constants.SESSION_SECURITY_CODE);        //获取session中的验证码
        if (code.equals(sessionCode)) {

            if (sysUser == null || sysUser.getStatus() == true) { // 用户名有误或已被禁用
                result.put("result", -1);
                writeJSON(response, result);
                return;
            }
            if (!sysUser.getPassword().equals(new Sha256Hash(sysUserModel.getPassword()).toHex())) { // 密码错误
                result.put("result", -2);
                writeJSON(response, result);
                return;
            }
            session1.removeAttribute(Constants.SESSION_SECURITY_CODE);    //清除登录验证码的session
            sysUser.setLastLoginTime(new Date());
            sysUserService.merge(sysUser);
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(sysUserModel.getPhone(), sysUserModel.getPassword(), sysUserModel.isRememberMe()));
            Session session = subject.getSession();
            session.setAttribute(SESSION_SYS_USER, sysUser);
            session.setAttribute("ROLE_KEY", sysUser.getRoles().iterator().next().getRoleKey());
            result.put("result", 1);

        } else {
            result.put("result", 2);
        }
        writeJSON(response, result);
    }


    // 跳转到主页，获取菜单并授权
    @RequestMapping("/home")
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        if (session.getAttribute(SESSION_SYS_USER) == null) {
            return new ModelAndView();
        } else {
            SysUser sysUser = (SysUser) session.getAttribute(SESSION_SYS_USER);
            String globalRoleKey = sysUser.getRoles().iterator().next().getRoleKey();
            try {
                List<Authority> allMenuList = authorityService.queryAllMenuList(globalRoleKey);
                return new ModelAndView("back/index", "authorityList", allMenuList);
            } catch (Exception e) {
                log.error(e.toString());
                return new ModelAndView();
            }
        }
    }

    // 注册
    @RequestMapping("/register")
    public void register(SysUser sysUserModel, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUser emailSysUser = sysUserService.getByProerties("email", sysUserModel.getEmail());
        if (emailSysUser != null) {
            result.put("result", -1);
            writeJSON(response, result);
            return;
        }
        SysUser sysUser = new SysUser();
        sysUser.setUserName(sysUserModel.getUserName());
        sysUser.setSex(sysUserModel.getSex());
        sysUser.setEmail(sysUserModel.getEmail());
        sysUser.setPhone(sysUserModel.getPhone());
        sysUser.setBirthday(sysUserModel.getBirthday());
        // sysUser.setPassword(MD51.crypt(sysUserModel.getPassword()));
        sysUser.setPassword(new Sha256Hash(sysUserModel.getPassword()).toHex());
        sysUser.setStatus(false);
        sysUser.setLastLoginTime(new Date());

        Set<Role> roles = new HashSet<Role>();
        Role role = roleService.getByProerties("roleKey", "ROLE_USER");
        roles.add(role);
        sysUser.setRoles(roles);

        sysUserService.persist(sysUser);
        // sysUserService.saveSysuserAndRole(sysUser.getId(), 3);

        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(sysUserModel.getEmail(), sysUserModel.getPassword()));
        Session session = subject.getSession();
        session.setAttribute(SESSION_SYS_USER, sysUser);
        session.setAttribute("ROLE_KEY", sysUser.getRoles().iterator().next().getRoleKey());

        result.put("result", 1);
        writeJSON(response, result);
    }


    // 获取个人资料信息
    @RequestMapping("/sysuserprofile")
    public ModelAndView sysuserprofile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SysUser sysuser = sysUserService.get(((SysUser) request.getSession().getAttribute(SESSION_SYS_USER)).getId());
        SysUser sysUserWithAvatar = sysUserService.getSysUserWithAvatar(sysuser);
        return new ModelAndView("back/sysuserprofile", "sysuser", sysUserWithAvatar);
    }

    // 登出
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SecurityUtils.getSubject().logout();
        response.sendRedirect("/guardian_angel/login.jsp");
    }

    // 发送邮件找回密码
    @RequestMapping("/retrievePassword")
    public void retrievePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> result = new HashMap<String, Object>();
        String email = request.getParameter("email");
        SysUser sysUser = sysUserService.getByProerties("email", email);
        if (sysUser == null || sysUser.getStatus() == true) { // 用户名有误或已被禁用
            result.put("result", -1);
            writeJSON(response, result);
            return;
        }
        SimpleEmail emailUtil = new SimpleEmail();
        emailUtil.setCharset("utf-8");
        emailUtil.setHostName("smtp.163.com");
        try {
            emailUtil.addTo(email, sysUser.getUserName());
            emailUtil.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.put("result", 1);
        writeJSON(response, result);
    }

    // 更改密码
    @RequestMapping("/resetPassword")
    public void resetPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String password = request.getParameter("password");
        Long id = ((SysUser) request.getSession().getAttribute(SESSION_SYS_USER)).getId();
        // sysUserService.updateByProperties("id", id, "password", MD51.crypt(password));
        sysUserService.updateByProperties("id", id, "password", new Sha256Hash(password).toHex());
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        writeJSON(response, result);
    }

    // 查询用户的表格，包括分页、搜索和排序
    @RequestMapping(value = "/getSysUser", method = {RequestMethod.POST, RequestMethod.GET})
    public void getSysUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer firstResult = Integer.valueOf(request.getParameter("page"));
        Integer maxResults = Integer.valueOf(request.getParameter("rows"));
        String sortedObject = request.getParameter("sidx");
        String sortedValue = request.getParameter("sord");
        String filters = request.getParameter("filters");
        SysUser sysUser = new SysUser();
        if (StringUtils.isNotBlank(filters)) {
            JSONObject jsonObject = JSONObject.fromObject(filters);
            JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject result = (JSONObject) jsonArray.get(i);
                if (result.getString("field").equals("email") && result.getString("op").equals("eq")) {
                    sysUser.set$eq_email(result.getString("data"));
                }
                if (result.getString("field").equals("userName") && result.getString("op").equals("cn")) {
                    sysUser.set$like_userName(result.getString("data"));
                }
            }
            if (((String) jsonObject.get("groupOp")).equalsIgnoreCase("OR")) {
                sysUser.setFlag("OR");
            } else {
                sysUser.setFlag("AND");
            }
        }
        sysUser.setFirstResult((firstResult - 1) * maxResults);
        sysUser.setMaxResults(maxResults);
        Map<String, String> sortedCondition = new HashMap<String, String>();
        sortedCondition.put(sortedObject, sortedValue);
        sysUser.setSortedConditions(sortedCondition);
        QueryResult<SysUser> queryResult = sysUserService.doPaginationQuery(sysUser);
        JqGridPageView<SysUser> sysUserListView = new JqGridPageView<SysUser>();
        sysUserListView.setMaxResults(maxResults);
        List<SysUser> sysUserCnList = sysUserService.querySysUserCnList(queryResult.getResultList());
        sysUserListView.setRows(sysUserCnList);
        sysUserListView.setRecords(queryResult.getTotalCount());
        writeJSON(response, sysUserListView);
    }

    // 保存用户的实体Bean
    @RequestMapping(value = "/saveSysUser", method = {RequestMethod.POST, RequestMethod.GET})
    public void doSave(SysUser entity, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ExtJSBaseParameter parameter = entity;
        if (CMD_EDIT.equals(parameter.getCmd())) {
            SysUser sysUser = sysUserService.get(entity.getId());
            entity.setPassword(sysUser.getPassword());
            entity.setLastLoginTime(sysUser.getLastLoginTime());
            sysUserService.merge(entity);
        } else if (CMD_NEW.equals(parameter.getCmd())) {
            // entity.setPassword(MD51.crypt("123456")); // 初始化密码为123456
            entity.setPassword(new Sha256Hash("123456").toHex()); // 初始化密码为123456
            sysUserService.persist(entity);
        }
        parameter.setSuccess(true);
        writeJSON(response, parameter);
    }

    // 操作用户的删除、导出Excel、字段判断和保存
    @RequestMapping(value = "/operateSysUser", method = {RequestMethod.POST, RequestMethod.GET})
    public void operateSysUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String oper = request.getParameter("oper");
        String id = request.getParameter("id");
        if (oper.equals("del")) {
            String[] ids = id.split(",");
            deleteSysUser(request, response, (Long[]) ConvertUtils.convert(ids, Long.class));
        } else if (oper.equals("excel")) {
            response.setContentType("application/msexcel;charset=UTF-8");
            try {
                response.addHeader("Content-Disposition", "attachment;filename=file.xls");
                OutputStream out = response.getOutputStream();
                out.write(URLDecoder.decode(request.getParameter("csvBuffer"), "UTF-8").getBytes());
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Map<String, Object> result = new HashMap<String, Object>();
            String userName = request.getParameter("userName");
            String email = request.getParameter("email");
            SysUser sysUser = null;
            if (oper.equals("edit")) {
                sysUser = sysUserService.get(Long.valueOf(id));
            }
            SysUser emailSysUser = sysUserService.getByProerties("email", email);
            if (StringUtils.isBlank(userName) || StringUtils.isBlank(email)) {
                response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
                result.put("message", "请填写姓名和邮箱");
                writeJSON(response, result);
            } else if (null != emailSysUser && oper.equals("add")) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                result.put("message", "此邮箱已存在，请重新输入");
                writeJSON(response, result);
            } else if (null != emailSysUser && !sysUser.getEmail().equalsIgnoreCase(email) && oper.equals("edit")) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                result.put("message", "此邮箱已存在，请重新输入");
                writeJSON(response, result);
            } else {
                SysUser entity = new SysUser();
                entity.setUserName(userName);
                entity.setSex(Short.valueOf(request.getParameter("sexCn")));
                entity.setEmail(email);
                entity.setPhone(request.getParameter("phone"));
                if (StringUtils.isNotBlank(request.getParameter("birthday"))) {
                    entity.setBirthday(dateFormat.parse(request.getParameter("birthday")));
                }
                entity.setDepartmentKey(request.getParameter("departmentValue"));
                entity.setStatusCn(request.getParameter("statusCn"));
                if (entity.getStatusCn().equals("是")) {
                    entity.setStatus(true);
                } else {
                    entity.setStatus(false);
                }

                Set<Role> roles = new HashSet<Role>();
                Role role = roleService.getByProerties("roleKey", request.getParameter("roleCn"));
                roles.add(role);
                entity.setRoles(roles);

                if (oper.equals("edit")) {
                    entity.setId(Long.valueOf(id));
                    entity.setCmd("edit");
                    doSave(entity, request, response);
                } else if (oper.equals("add")) {
                    entity.setCmd("new");
                    doSave(entity, request, response);
                }
            }
        }
    }

    // 保存个人资料
    @RequestMapping(value = "/saveSysUserProfile", method = {RequestMethod.POST, RequestMethod.GET})
    public void saveSysUserProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Long sysUserId = ((SysUser) request.getSession().getAttribute(SESSION_SYS_USER)).getId();
        SysUser sysUser = sysUserService.get(sysUserId);
        SysUser entity = new SysUser();
        entity.setId(sysUserId);
        entity.setUserName(request.getParameter("userName"));
        entity.setSex(Short.valueOf(request.getParameter("sex")));
        entity.setEmail(request.getParameter("email"));
        entity.setPhone(request.getParameter("phone"));
        if (null != request.getParameter("birthday")) {
            entity.setBirthday(dateFormat.parse(request.getParameter("birthday")));
        }
        entity.setStatus(sysUser.getStatus());
        entity.setPassword(sysUser.getPassword());
        entity.setLastLoginTime(sysUser.getLastLoginTime());
        entity.setDepartmentKey(sysUser.getDepartmentKey());
        entity.setRoles(sysUser.getRoles());
        sysUserService.merge(entity);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        writeJSON(response, result);
    }

    // 删除用户
    @RequestMapping("/deleteSysUser")
    public void deleteSysUser(HttpServletRequest request, HttpServletResponse response, @RequestParam("ids") Long[] ids) throws IOException {
        if (Arrays.asList(ids).contains(Long.valueOf("1"))) {
            writeJSON(response, "{success:false,message:'删除项包含超级管理员，超级管理员不能删除！'}");
        } else {
            boolean flag = sysUserService.deleteByPK(ids);
            if (flag) {
                writeJSON(response, "{success:true}");
            } else {
                writeJSON(response, "{success:false}");
            }
        }
    }

    // 即时更新个人资料的字段
    @RequestMapping(value = "/updateSysUserField", method = {RequestMethod.POST, RequestMethod.GET})
    public void updateSysUserField(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Long id = Long.valueOf(request.getParameter("pk"));
        String name = request.getParameter("name");
        String value = request.getParameter("value");
        if (name.equals("userName")) {
            sysUserService.updateByProperties("id", id, "userName", value);
        } else if (name.equals("sex")) {
            sysUserService.updateByProperties("id", id, "sex", Short.valueOf(value));
        } else if (name.equals("email")) {
            sysUserService.updateByProperties("id", id, "email", value);
        } else if (name.equals("phone")) {
            sysUserService.updateByProperties("id", id, "phone", value);
        } else if (name.equals("birthday")) {
            if (null != value) {
                sysUserService.updateByProperties("id", id, "birthday", dateFormat.parse(value));
            }
        }
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    // 上传个人资料的头像
    @RequestMapping(value = "/uploadAttachement", method = RequestMethod.POST)
    public void uploadAttachement(@RequestParam(value = "avatar", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestContext requestContext = new RequestContext(request);
        JSONObject json = new JSONObject();
        if (!file.isEmpty()) {
            if (file.getSize() > 2097152) {
                json.put("message", requestContext.getMessage("g_fileTooLarge"));
            } else {
                try {
                    String originalFilename = file.getOriginalFilename();
                    String fileName = sdf.format(new Date()) + JavaEEFrameworkUtils.getRandomString(3) + originalFilename.substring(originalFilename.lastIndexOf("."));
                    File filePath = new File(getClass().getClassLoader().getResource("/").getPath().replace("/WEB-INF/classes/", "/static/upload/img/" + DateFormatUtils.format(new Date(), "yyyyMM")));
                    System.out.println(filePath.getAbsolutePath());
                    if (!filePath.exists()) {
                        filePath.mkdirs();
                    }
                    String belongTo = request.getParameter("belongTo");
                    Attachment attachment = new Attachment();

                    file.transferTo(new File(filePath.getAbsolutePath(), fileName));
                    Long sysUserId;
                    String destinationFilePath = "/static/upload/img/" + DateFormatUtils.format(new Date(), "yyyyMM") + "/" + fileName;
                    if (StringUtils.isBlank(belongTo)) {
                        sysUserId = ((SysUser) request.getSession().getAttribute(SESSION_SYS_USER)).getId();
                        attachmentService.deleteByProperties(new String[]{"type", "typeId"}, new Object[]{(short) 1, sysUserId});
                    } else {

                        sysUserId = -1L;
                        attachment.setBelongToId(belongTo);
                    }
                    attachment.setFileName(originalFilename);
                    attachment.setFilePath(destinationFilePath);
                    attachment.setType((short) 1);
                    attachment.setTypeId(sysUserId);
                    attachmentService.persist(attachment);
                    json.put("status", "OK");

                    json.put("url", request.getContextPath() + destinationFilePath);
                    json.put("message", requestContext.getMessage("g_uploadSuccess"));
                } catch (Exception e) {
                    e.printStackTrace();
                    json.put("message", requestContext.getMessage("g_uploadFailure"));
                }
            }
        } else {
            json.put("message", requestContext.getMessage("g_uploadNotExists"));
        }
        writeJSON(response, json.toString());
    }

    /**
     * 以下方法是根据路径跳转到页面
     **/

    @RequestMapping("/sysuser")
    public String sysuser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "back/systemmanage/sysuser";
    }

    @RequestMapping("/homepage")
    public String homepage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "back/homepage";
    }

    @RequestMapping("/dict")
    public String dict(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "back/systemmanage/dict";
    }


    @RequestMapping("/user")
    public String user(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "back/systemmanage/user";
    }


    @RequestMapping("/role")
    public String role(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "back/systemmanage/role";
    }

    @RequestMapping("/department")
    public String department(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "back/systemmanage/department";
    }


    @RequestMapping("/information")
    public String information(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "back/infomanage/information";
    }

    @RequestMapping("/authority")
    public String authority(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "back/systemmanage/authority";
    }

    @RequestMapping("/callError404")
    @ResponseBody
    public String callError404(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "404";
    }

    @RequestMapping("/error404")
    @ResponseBody
    public String error404(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "404";
    }

    @RequestMapping("/callError500")
    public String callError500(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "500-" + "";
    }

    @RequestMapping("/error500")
    public String error500(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "back/error500";
    }

    @RequestMapping("/callUnauthorized")
    public String callUnauthorized(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "redirect:/sys/sysuser/unauthorized";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "back/unauthorized";
    }

    @RequestMapping("/druid")
    public String druid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "back/druid";
    }
//    太阁部分
    @RequestMapping("/branch")
    public String school(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "back/taigemange/branch";
    }
    @RequestMapping("/schoolInformation")
    public String schoolInformation(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return "redirect:/taige/schoolInformation/getInformations";
    }
    @RequestMapping("/news")
    public String news(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "back/taigemange/news";
    }
    @RequestMapping("/openclass")
    public String openclass(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "back/taigemange/openclass";
    }

}
