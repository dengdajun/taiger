package org.tiger.controller;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Source;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tiger.entity.OpenClass;
import org.tiger.service.OpenClassService;
import support.core.Constant;
import support.core.JavaEEFrameworkBaseController;
import support.support.ExtJSBaseParameter;
import support.support.JqGridPageView;
import support.support.QueryResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YoungMan on 2016/11/13.
 */
@Controller
@RequestMapping("/taige/openclsss")
public class OpenClsssController extends JavaEEFrameworkBaseController<OpenClass> implements Constant {
    @Source
    private OpenClassService service;

    // 查询校区的表格，包括分页、搜索和排序
    @RequestMapping(value = "/getclass", method = {RequestMethod.POST, RequestMethod.GET})
    public void getBranchs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer firstResult = Integer.valueOf(request.getParameter("page"));
        Integer maxResults = Integer.valueOf(request.getParameter("rows"));
        String sortedObject = request.getParameter("sidx");
        String sortedValue = request.getParameter("sord");
        OpenClass openClass = new OpenClass();
        openClass.setFirstResult((firstResult - 1) * maxResults);
        openClass.setMaxResults(maxResults);
        Map<String, String> sortedCondition = new HashMap<String, String>();
        sortedCondition.put(sortedObject, sortedValue);
        openClass.setSortedConditions(sortedCondition);
        QueryResult<OpenClass> queryResult = service.doPaginationQuery(openClass);
        JqGridPageView<OpenClass> branchSchoolListView = new JqGridPageView<OpenClass>();
        branchSchoolListView.setMaxResults(maxResults);
        branchSchoolListView.setRows(queryResult.getResultList());
        branchSchoolListView.setRecords(queryResult.getTotalCount());
        writeJSON(response, branchSchoolListView);
    }


    // 校区的删除、导出Excel、字段判断和保存
    @RequestMapping(value = "/operateClass", method = {RequestMethod.POST, RequestMethod.GET})
    public void operateBranch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String oper = request.getParameter("oper");
        String id = request.getParameter("id");
        if (oper.equals("del")) {
            String[] ids = id.split(",");
            deleteBranch(request, response, (Integer[]) ConvertUtils.convert(ids, Integer.class));
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
            String content = request.getParameter("content");
            String  time= request.getParameter("time");
            OpenClass openClass = null;
            if (oper.equals("edit")) {
                openClass = service.get(Integer.valueOf(id));
                if(!StringUtils.isBlank(content)){
                    openClass.setContent(content);
                }
                if(!StringUtils.isBlank(time)){
                    openClass.setTime(time);
                }
                openClass.setCmd("edit");
                doSave( openClass , request, response);
            }else if (oper.equals("add")) {
                openClass.setCmd("new");
                openClass.setContent(content);
                openClass.setTime(time);
                doSave(openClass, request, response);
             }
        }
    }
    // 保存校区的实体Bean
    @RequestMapping(value = "/saveclass", method = {RequestMethod.POST, RequestMethod.GET})
    public void doSave(OpenClass entity, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ExtJSBaseParameter parameter = entity;
        if (CMD_EDIT.equals(parameter.getCmd())) {
            service.merge(entity);
        } else if (CMD_NEW.equals(parameter.getCmd())) {
            // entity.setPassword(MD51.crypt("123456")); // 初始化密码为123456
            service.persist(entity);
        }
        parameter.setSuccess(true);
        writeJSON(response, parameter);
    }
    // 删除校区
    @RequestMapping("/deleteclass")
    public void deleteBranch(HttpServletRequest request, HttpServletResponse response, @RequestParam("ids") Integer[] ids) throws IOException {
        boolean flag = service.deleteByPK(ids);
        if (flag) {
            writeJSON(response, "{success:true}");
        } else {
            writeJSON(response, "{success:false}");
        }
    }



}
