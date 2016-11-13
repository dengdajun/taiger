package org.tiger.controller;


import org.springframework.web.servlet.ModelAndView;
import org.tiger.constant.ApiConstant;
import org.tiger.constant.Constants;
import support.util.CookieUtils;
import support.util.PageData;
import support.util.ResponseMessage;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class BaseController {


    protected Logger logger = Logger.getLogger(this.getClass());

    private static final long serialVersionUID = 6357869213649815390L;

    /**
     * new PageData对象
     *
     * @return
     */
    public PageData getPageData() {
        return new PageData(this.getRequest());
    }

    /**
     * 得到ModelAndView
     *
     * @return
     */
    public ModelAndView getModelAndView() {
        return new ModelAndView();
    }

    /**
     * 获取Request对象
     *
     * @return Request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 空值检查
     *
     * @param objects 传入要检查的对象数组
     * @param message 传入消息实例
     * @return 若有一项值为空，则返回true，全不为空则返回false
     */
    public static boolean checkParams(Object[] objects, ResponseMessage message) {
        for (Object obj : objects) {
            if (obj == null || "".equals(obj)) {
                message.setStatus(ApiConstant.Status.PARAM_NOT_ENOUGH);
                message.setMessage(ApiConstant.Message.PARAM_NOT_ENOUGH);
                return true;
            }
        }
        return false;
    }


    /**
     * 保存信息到cookie和session中
     * @param key
     * @param value
     * @param request
     * @param response
     */
    public static void setCookieSession(String key, Object value, HttpServletRequest request, HttpServletResponse response) {

        CookieUtils.setCookie(key, value, response, request);
        request.getSession().setAttribute(key,value);
    }

    /**
     * 获取cookie和session中的信息
     * @param key
     * @param value
     * @param request
     * @param response
     */
   /* public static Object getCookieSession(String key, Object value, HttpServletRequest request, HttpServletResponse response) {
        Object object=null;
     object=CookieUtils.getValue(key, request);
         request.getSession().getAttribute(key);
    }*/

    /**
     * 时间字符串转换
     */
    public static Timestamp getTime(String str) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat(ApiConstant.DateFormat.DATE_1);
        SimpleDateFormat sdf2 = new SimpleDateFormat(ApiConstant.DateFormat.DATE_2);
        Date result = null;
        if (str.matches("(\\d){4}-(\\d){1,2}-(\\d){1,2} (\\d){1,2}:(\\d){1,2}")) {
            result = sdf1.parse(str);
        } else if (str.matches("(\\d){4}/(\\d){1,2}/(\\d){1,2} (\\d){1,2}:(\\d){1,2}")) {
            result = sdf2.parse(str);
        } else {
            return null;
        }
        return new Timestamp(result.getTime());
    }

    /**
     * 检查资源
     */
    public static boolean checkResource(Object obj, ResponseMessage message) {
        if (obj == null) {
            message.setStatus(ApiConstant.Status.RESOURCE_NOT_EXISTS)
                    .setMessage(ApiConstant.Message.RESOURCE_NOT_EXISTS);
            return true;
        }
        return false;
    }

    /**
     * 处理页码
     */
    public static int getPageSize(int page) {
        if (page < ApiConstant.Page.DEFAULT_START_PAGE) {
            return ApiConstant.Page.DEFAULT_START_PAGE;
        }
        return (page - 1) * ApiConstant.Page.MAX_PAGESIZE;
    }

    /**
     * 获取系统当前时间戳
     *
     * @return
     */
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取请求的IP地址
     *
     * @param request
     * @return
     */
    public String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
