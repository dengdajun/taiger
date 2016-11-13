package org.tiger.controller;

/**
 * Created by YoungMan on 2016/11/10.
 */

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tiger.entity.BranchSchool;
import org.tiger.service.BranchSchoolService;
import support.core.Constant;
import support.core.JavaEEFrameworkBaseController;
import support.support.ExtJSBaseParameter;
import support.support.JqGridPageView;
import support.support.QueryResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 校区管理
 */
@Controller
@RequestMapping("/taige/barnch")
public class BranchSchoolController  extends JavaEEFrameworkBaseController<BranchSchool> implements Constant{
    @Resource
    private BranchSchoolService branchSchoolService;




    // 查询校区的表格，包括分页、搜索和排序
    @RequestMapping(value = "/getBranchs", method = {RequestMethod.POST, RequestMethod.GET})
    public void getBranchs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer firstResult = Integer.valueOf(request.getParameter("page"));
        Integer maxResults = Integer.valueOf(request.getParameter("rows"));
        String sortedObject = request.getParameter("sidx");
        String sortedValue = request.getParameter("sord");
        String filters = request.getParameter("filters");
        BranchSchool school = new BranchSchool();
        if (StringUtils.isNotBlank(filters)) {
            JSONObject jsonObject = JSONObject.fromObject(filters);
            JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject result = (JSONObject) jsonArray.get(i);
                if (result.getString("field").equals("name") && result.getString("op").equals("eq")) {
                    school.setName(result.getString("data"));
                }
            }
            if (((String) jsonObject.get("groupOp")).equalsIgnoreCase("OR")) {
                school.setFlag("OR");
            } else {
                school.setFlag("AND");
            }
        }
        school.setFirstResult((firstResult - 1) * maxResults);
        school.setMaxResults(maxResults);
        Map<String, String> sortedCondition = new HashMap<String, String>();
        sortedCondition.put(sortedObject, sortedValue);
        school.setSortedConditions(sortedCondition);
        QueryResult<BranchSchool> queryResult = branchSchoolService.doPaginationQuery(school);
        JqGridPageView<BranchSchool> branchSchoolListView = new JqGridPageView<BranchSchool>();
        branchSchoolListView.setMaxResults(maxResults);
        branchSchoolListView.setRows(queryResult.getResultList());
        branchSchoolListView.setRecords(queryResult.getTotalCount());
        writeJSON(response, branchSchoolListView);
    }


    // 校区的删除、导出Excel、字段判断和保存
    @RequestMapping(value = "/operateBranch", method = {RequestMethod.POST, RequestMethod.GET})
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
            String name = request.getParameter("name");
            String content = request.getParameter("content");
            BranchSchool branchSchool = null;
            if (oper.equals("edit")) {
                branchSchool = branchSchoolService.get(Integer.valueOf(id));
            }
            BranchSchool nameBranchSchool = branchSchoolService.getByProerties("name", name);
            if (StringUtils.isBlank(name) || StringUtils.isBlank(content)) {
                response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
                result.put("message", "请填写名字和内容");
                writeJSON(response, result);
            } else if (null != nameBranchSchool && oper.equals("add")) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                result.put("message", "校区已存在");
                writeJSON(response, result);
            } else if (null != nameBranchSchool && !nameBranchSchool.getName().equalsIgnoreCase(name) && oper.equals("edit")) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                result.put("message", "此校区已存在");
                writeJSON(response, result);
            } else {
                branchSchool=new BranchSchool();
                branchSchool.setName(name);
                branchSchool.setContent(content);
                branchSchool.setUpdateTime(new Date());
                if (oper.equals("edit")) {
                    branchSchool.setId(Integer.valueOf(id));
                    branchSchool.setCmd("edit");
                    doSave(branchSchool, request, response);
                } else if (oper.equals("add")) {
                    branchSchool.setCmd("new");
                    doSave(branchSchool, request, response);
                }
            }
        }
    }
    // 保存校区的实体Bean
    @RequestMapping(value = "/saveBranch", method = {RequestMethod.POST, RequestMethod.GET})
    public void doSave(BranchSchool entity, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ExtJSBaseParameter parameter = entity;
        if (CMD_EDIT.equals(parameter.getCmd())) {
            branchSchoolService.merge(entity);
        } else if (CMD_NEW.equals(parameter.getCmd())) {
            // entity.setPassword(MD51.crypt("123456")); // 初始化密码为123456
            branchSchoolService.persist(entity);
        }
        parameter.setSuccess(true);
        writeJSON(response, parameter);
    }
    // 删除校区
    @RequestMapping("/deleteBranch")
    public void deleteBranch(HttpServletRequest request, HttpServletResponse response, @RequestParam("ids") Integer[] ids) throws IOException {
            boolean flag = branchSchoolService.deleteByPK(ids);
            if (flag) {
                writeJSON(response, "{success:true}");
            } else {
                writeJSON(response, "{success:false}");
            }
    }


}
