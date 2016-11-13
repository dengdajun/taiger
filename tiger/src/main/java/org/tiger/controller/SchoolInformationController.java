package org.tiger.controller;

/**
 * Created by YoungMan on 2016/11/10.
 */

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;
import org.tiger.entity.Attachment;
import org.tiger.entity.QQAdvertisement;
import org.tiger.entity.SchoolInformation;
import org.tiger.service.AttachmentService;
import org.tiger.service.QQAdvertisementService;
import org.tiger.service.SchoolInformationService;
import support.core.Constant;
import support.core.JavaEEFrameworkBaseController;
import support.support.QueryResult;
import support.util.JavaEEFrameworkUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学校信息
 */
@Controller
@RequestMapping("/taige/schoolInformation")
public class SchoolInformationController extends JavaEEFrameworkBaseController<SchoolInformation> implements Constant{
    @Resource
    private SchoolInformationService schoolInformationService;
    @Resource
    AttachmentService attachmentService;
    @Resource
    QQAdvertisementService qqAdvertisement;




    // 查询校区的表格，包括分页、搜索和排序
    @RequestMapping(value = "/getInformations", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView getSchool(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<SchoolInformation> queryResult = schoolInformationService.doQueryAll();
        Attachment query=new Attachment();
        query.set$like_belongToId("banner");
        QueryResult<Attachment> result=attachmentService.doPaginationQuery(query);
        ModelMap modelMap=new ModelMap();
        modelMap.addAttribute("information", queryResult.get(0));
        for(Attachment entity:result.getResultList()){
            modelMap.addAttribute(entity.getBelongToId(),entity);
        }
        for(QQAdvertisement entity:qqAdvertisement.doQueryAll()){
            modelMap.addAttribute("qqAdvertisement",entity);
        }
         return new ModelAndView("back/taigemange/schoolInformation",modelMap);
    }


    // 只用更新，扩展
    @RequestMapping(value = "/operateSchool", method = {RequestMethod.POST, RequestMethod.GET})
    public void operateSchool(HttpServletRequest request, HttpServletResponse response) throws Exception {
          String oper = request.getParameter("oper");
         String id = request.getParameter("id");
            Map<String, Object> result = new HashMap<String, Object>();
            String QQ = request.getParameter("qq");
            String mobile = request.getParameter("mobile");
            String QQgroup = request.getParameter("qqgroup");
            String tel = request.getParameter("tel");
            String address = request.getParameter("address");
            String introduce = request.getParameter("introduce");
            String environment = request.getParameter("environment");
            String route = request.getParameter("route");
            String routedetails = request.getParameter("routedetails");
            SchoolInformation schoolInformation = null;
            if (oper.equals("edit")) {
                schoolInformation = schoolInformationService.get(Integer.valueOf(id));
            }
            if (StringUtils.isBlank(QQ) ) {
                response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
                result.put("message", "请填写QQ");
                writeJSON(response, result);
                return ;
            }
            if (StringUtils.isBlank(mobile) ) {
                response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
                result.put("message", "请填写手机");
                writeJSON(response, result);
                return ;
            } if (StringUtils.isBlank(QQgroup) ) {
                response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
                result.put("message", "请填写qq群");
                writeJSON(response, result);
                 return ;
            } if (StringUtils.isBlank(tel) ) {
                response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
                result.put("message", "请填写联系电话");
                writeJSON(response, result);
                return ;
            } if (StringUtils.isBlank(address) ) {
                response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
                result.put("message", "请填写地址");
                writeJSON(response, result);
                   return ;
            }
            if (StringUtils.isBlank(environment) ) {
                response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
                result.put("message", "请填写环境");
                writeJSON(response, result);
                return ;
            }
            if (StringUtils.isBlank(routedetails) ) {
                response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
                result.put("message", "请填写路线详情");
                writeJSON(response, result);
                return ;
            } if (StringUtils.isBlank(route) ) {
                response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
                result.put("message", "请填写路线");
                writeJSON(response, result);
                return ;
            }
             else {
                if (oper.equals("edit")) {
                    schoolInformation.setMobile(mobile);
                    schoolInformation.setAddress(address);
                    schoolInformation.setEnvironment(environment);
                    schoolInformation.setIntroduce(introduce);
                    schoolInformation.setQQ(QQ);
                    schoolInformation.setQQgroup(QQgroup);
                    schoolInformation.setRoute(route);
                    schoolInformation.setRoutedetails(routedetails);

                try{

                    schoolInformation.setTel(Long.valueOf(tel));
                }
                     catch (NumberFormatException e){
                         result.put("message", "电话必须是数字");
                         writeJSON(response, result);
                         return ;
                    }
                    schoolInformation.setCmd("edit");
                    doSave(schoolInformation, request, response);
                }
            }
    }
    // 保存用户的实体Bean 没用
    @RequestMapping(value = "/saveBranchSchool", method = {RequestMethod.POST, RequestMethod.GET})
    public void doSave(SchoolInformation entity, HttpServletRequest request, HttpServletResponse response) throws IOException {
        SchoolInformation parameter = entity;
        if (CMD_EDIT.equals(parameter.getCmd())) {
            schoolInformationService.merge(entity);
        } else if (CMD_NEW.equals(parameter.getCmd())) {
            // entity.setPassword(MD51.crypt("123456")); // 初始化密码为123456
            schoolInformationService.persist(entity);
        }
        parameter.setSuccess(true);
        writeJSON(response, parameter);
    }
    // 删除学校
    @RequestMapping("/deleteSchool")
    public void deleteSchool(HttpServletRequest request, HttpServletResponse response, @RequestParam("ids") Integer[] ids) throws IOException {
            boolean flag = schoolInformationService.deleteByPK(ids);
            if (flag) {
                writeJSON(response, "{success:true}");
            } else {
                writeJSON(response, "{success:false}");
            }
    }
    // 即时更新个人资料的字段
    @RequestMapping(value = "/updateInformationField", method = {RequestMethod.POST, RequestMethod.GET})
    public void updateInformationField(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String value = request.getParameter("value");
        Integer id = Integer.valueOf(request.getParameter("pk"));
        if (name.equals("mobile")) {
            schoolInformationService.updateByProperties("id", id, "mobile", value);
        } else if (name.equals("QQ")) {
            schoolInformationService.updateByProperties("id", id, "QQ",value);
        } else if (name.equals("QQgroup")) {
            schoolInformationService.updateByProperties("id", id, "QQgroup", value);
        } else if (name.equals("tel")) {
            schoolInformationService.updateByProperties("id", id, "tel", value);
        }
        else if (name.equals("address")) {
            schoolInformationService.updateByProperties("id", id, "address", value);
        }
        else if (name.equals("introduce")) {
            schoolInformationService.updateByProperties("id", id, "introduce", value);
        }else if (name.equals("route")) {
            schoolInformationService.updateByProperties("id", id, "route", value);
        }else if (name.equals("routedetails")) {
            schoolInformationService.updateByProperties("id", id, "routedetails", value);
        }else if (name.equals("environment")) {
           schoolInformationService.updateByProperties("id", id, "environment", value);
        }

    }


    // 即时更新个人资料的字段
    @RequestMapping(value = "/updateqqField", method = {RequestMethod.POST, RequestMethod.GET})
    public void updateqqField(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String value = request.getParameter("value");
        Integer id = Integer.valueOf(request.getParameter("pk"));
        if (name.equals("talk")) {
            qqAdvertisement.updateByProperties("id", id, "talk", value);
        } else if (name.equals("message")) {
            qqAdvertisement.updateByProperties("id", id, "message", value);
        } else if (name.equals("time")) {
            qqAdvertisement.updateByProperties("id", id, "time", value);
        }
    }


    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    @RequestMapping(value = "/uploadAttachement1", method = RequestMethod.POST)
    public void uploadAttachement1(@RequestParam(value = "avatar", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
            this.uploadAttachement(file,"banner1",request,response);
    }
    @RequestMapping(value = "/uploadAttachement2", method = RequestMethod.POST)
    public void uploadAttachement2(@RequestParam(value = "avatar", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
             this.uploadAttachement(file,"banner2",request,response);
    }
    @RequestMapping(value = "/uploadAttachement3", method = RequestMethod.POST)
    public void uploadAttachement3(@RequestParam(value = "avatar", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
            this.uploadAttachement(file,"banner3",request,response);
    }
    public void uploadAttachement(MultipartFile file,String belongTo, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
                    if (!filePath.exists()) {
                        filePath.mkdirs();
                    }
                    Attachment attachment = new Attachment();
                    file.transferTo(new File(filePath.getAbsolutePath(), fileName));
                    String destinationFilePath = "/static/upload/img/" + DateFormatUtils.format(new Date(), "yyyyMM") + "/" + fileName;
                    attachment.setFileName(originalFilename);
                    attachment.setFilePath(destinationFilePath);
                    attachment.setType((short) ATT_Carousel);
                    attachment.setTypeId(new Long(ATT_Carousel));
                    attachment.setBelongToId(belongTo);
                    attachmentService.deleteByProperties("belongToId",belongTo);
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

    @RequestMapping(value = "/uploadAttachement4", method = RequestMethod.POST)
    public void uploadAttachement4(@RequestParam(value = "avatar", required = false)MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestContext requestContext = new RequestContext(request);
        JSONObject json = new JSONObject();
        if (!file.isEmpty()) {
            if (file.getSize() > 2097152) {
                json.put("message", requestContext.getMessage("g_fileTooLarge"));
            } else {
                try {
                    String originalFilename = file.getOriginalFilename();
                    String fileName = sdf.format(new Date()) + JavaEEFrameworkUtils.getRandomString(3) + originalFilename.substring(originalFilename.lastIndexOf("."));
                    File filePath = new File(getClass().getClassLoader().getResource("/").getPath().replace("/WEB-INF/classes/", "/static/upload/video/" + DateFormatUtils.format(new Date(), "yyyyMM")));
                    if (!filePath.exists()) {
                        filePath.mkdirs();
                    }
                    Attachment attachment = new Attachment();
                    file.transferTo(new File(filePath.getAbsolutePath(), fileName));
                    String destinationFilePath = "/static/upload/video/" + DateFormatUtils.format(new Date(), "yyyyMM") + "/" + fileName;
                    attachment.setFileName(originalFilename);
                    attachment.setFilePath(destinationFilePath);
                    attachment.setType((short) ATT_Carousel);
                    attachment.setTypeId(new Long(ATT_Carousel));
                    Attachment queryLike=new  Attachment();
                    QueryResult<Attachment> queryResult= attachmentService.doPaginationQuery(queryLike);
                    for(Attachment video:queryResult.getResultList()){
                        attachmentService.delete(video);
                    }
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
}
