package org.tiger.controller;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContext;
import org.tiger.constant.ApiConstant;
import org.tiger.entity.Attachment;
import org.tiger.entity.News;
import org.tiger.entity.SysUser;
import org.tiger.service.AttachmentService;
import org.tiger.service.NewsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import support.core.Constant;
import support.support.JqGridPageView;
import support.support.QueryResult;
import support.util.JavaEEFrameworkUtils;
import support.util.MultiFileUpload;
import support.util.response.ResponseClientUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2016/10/19 0019.
 */
@Controller
@RequestMapping("/taige/news")
public class NewsController extends BaseController implements ApiConstant,Constant {

    @Resource
    private NewsService newsService;
    @Resource
    AttachmentService attachmentService;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    @RequestMapping(value = "/getBattlefield", method = { RequestMethod.POST, RequestMethod.GET })
    public void getBattlefield(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer page = Integer.valueOf(request.getParameter("page"));
        Integer resultCount = Integer.valueOf(request.getParameter("rows"));
        String sortedObject = request.getParameter("sidx"); //排序条件
        String sortedValue = request.getParameter("sord"); //升序/降序
        LinkedHashMap<String, String> sortedCondition = new LinkedHashMap<String, String>();
        sortedCondition.put(sortedObject, sortedValue);
        StringBuilder stringBuilder = new StringBuilder();
        List<Object> params = new ArrayList<>();
        String filters = request.getParameter("filters");
        if (StringUtils.isNotBlank(filters)) {
            JSONObject jsonObject = JSONObject.fromObject(filters);
            JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject result = (JSONObject) jsonArray.get(i);
                String field = result.getString("field");
                String data = result.getString("data");
                if (field.equals("id")) {
                    stringBuilder.append("and o.id = ? ");
                    params.add(Integer.parseInt(data));
                    continue;
                }
                if (field.equals("title")) {
                    stringBuilder.append("and o.title like ? ");
                    params.add("%" + data + "%");
                    continue;
                }
                if (field.equals("content")) {
                    stringBuilder.append("and o.content like ? ");
                    params.add("%" + data + "%");
                    continue;
                }
            }
        }
        stringBuilder.append("and o.ntype = ? ");
        params.add("1");
        QueryResult<News> queryResult = newsService.getDataList(((page - 1) * resultCount), resultCount, stringBuilder.toString(), params, sortedCondition);
        JqGridPageView<News> typeListView = new JqGridPageView<News>();
        typeListView.setMaxResults(resultCount);
        typeListView.setRows(queryResult.getResultList());
        typeListView.setRecords(queryResult.getTotalCount());
        ResponseClientUtil.writeJSON(response, typeListView);

    }
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @RequestMapping(value = "/editNews", method = {RequestMethod.POST,RequestMethod.GET})
    public void editData(HttpServletRequest request, HttpServletResponse response
                         ) throws Exception{
        JSONObject json = new JSONObject();
//        if (!file.isEmpty()) {
//            if (file.getSize() > 2097152) {
//                json.put("message", requestContext.getMessage("文件超出大小"));
//            } else {
//                try {
//                    String originalFilename = file.getOriginalFilename();
//                    String fileName = sdf.format(new Date()) + JavaEEFrameworkUtils.getRandomString(3) + originalFilename.substring(originalFilename.lastIndexOf("."));
//                    File filePath = new File(getClass().getClassLoader().getResource("/").getPath().replace("/WEB-INF/classes/", "/static/upload/img/" + DateFormatUtils.format(new Date(), "yyyyMM")));
//                    System.out.println(filePath.getAbsolutePath());
//                    if (!filePath.exists()) {
//                        filePath.mkdirs();
//                    }
//                    String belongTo = request.getParameter("belongTo");
//                    Attachment attachment = new Attachment();
//
//                    file.transferTo(new File(filePath.getAbsolutePath(), fileName));
//                    Long sysUserId;
//                    String destinationFilePath = "/static/upload/img/" + DateFormatUtils.format(new Date(), "yyyyMM") + "/" + fileName;
//                    if (StringUtils.isBlank(belongTo)) {
//                        sysUserId = ((SysUser) request.getSession().getAttribute(SESSION_SYS_USER)).getId();
//                        attachmentService.deleteByProperties(new String[]{"type", "typeId"}, new Object[]{(short) 1, sysUserId});
//                    } else {
//
//                        sysUserId = -1L;
//                        attachment.setBelongToId(belongTo);
//                    }
//                    attachment.setFileName(originalFilename);
//                    attachment.setFilePath(destinationFilePath);
//                    attachment.setType((short) 1);
//                    attachment.setTypeId(sysUserId);
//                    attachmentService.persist(attachment);
//                    json.put("status", "OK");
//
//                    json.put("url", request.getContextPath() + destinationFilePath);
//                    json.put("message", requestContext.getMessage("g_uploadSuccess"));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    json.put("message", requestContext.getMessage("g_uploadFailure"));
//                }
//            }
//        } else {
//            json.put("message", requestContext.getMessage("g_uploadNotExists"));
//        }
        String id=request.getParameter("id");
        String title=request.getParameter("title");
        String date=request.getParameter("date");
        String content=request.getParameter("content");
        String ntype=request.getParameter("ntype");
        String oper = request.getParameter("oper");
        String idss = request.getParameter("id");//对象属性没有定义为id 则id值默认为列标
        Map<String, Object> result = new HashMap<String, Object>();
        String url = MultiFileUpload.multiFileUpload(request,
                FileConstant.NEWS_IMG_FILEPATH,
                FileURLConstant.NEWS_IMG_URL, System.currentTimeMillis() + "");
        url = url.replaceAll(";", "");
        if (oper.equals("add")) {
            News entity=new News();
            entity.setTitle(title);
            entity.setContent(content);
            entity.setNtype(ntype);
            entity.setDate(dateFormat.parse(date));
            newsService.persist(entity);
        } else if (oper.equals("del")) {
            String[] ids = idss.split(",");
            boolean flag = newsService.deleteByPK(((Integer[]) ConvertUtils.convert(ids, Integer.class)));
            if (flag) {
                ResponseClientUtil.writeJSON(response, Message.SUCCESS);
            } else {
                ResponseClientUtil.writeJSON(response, Message.FAIL);
            }
        } else if (oper.equals("edit")) {
            News news=newsService.getByProerties("id", id);
            news.setTitle(title);
//            news.setDate(date);
            news.setContent(content);
            news.setPhoto(url);
            newsService.update(news);
           /* response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
            result.put("message", "heheheheh");
            ResponseClientUtil .writeJSON(response, result);*/

        } else if (oper.equals("excel")) {
            response.setContentType("application/msexcel;charset=UTF-8");
            try {
                response.addHeader("Content-Disposition", "attachment;filename=excel_file.xls");
                OutputStream out = response.getOutputStream();
                out.write(URLDecoder.decode(request.getParameter("csvBuffer"), "UTF-8").getBytes());
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
