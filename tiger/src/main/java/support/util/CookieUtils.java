package support.util;

import com.alibaba.fastjson.JSON;
import org.tiger.constant.Constants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Matrix on 2016/06/05.
 */
public class CookieUtils {



    public static String getValue(String key, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies == null) return null;
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(key)) {
                String value = null;
                try {
                    String temp=cookie.getValue();
                    if(temp!=null) {
                        value = URLDecoder.decode(temp, "utf-8");
                        value = value.replaceAll("\"", "");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return value;
            }
        }
        return null;
    }

    public static void setCookie(String key, Object value, HttpServletResponse response, HttpServletRequest request) {
        try {
            Cookie cookie = new Cookie(key, URLEncoder.encode(JSON.toJSONString(value), "utf-8"));
            cookie.setMaxAge(Constants.COOKIE_TIME);
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isCookieExists(Object value, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies == null) return false;
        for(Cookie cookie : request.getCookies()){
            if(cookie.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static void delCookies(String[] keys, HttpServletRequest request, HttpServletResponse response) {
        for(Cookie cookie : request.getCookies()){
            for(String key : keys) {
                if(cookie.getName().equals(key)) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    cookie.setPath(request.getContextPath());
                    response.addCookie(cookie);
                }
            }
        }
    }

    /**
     * 将openId保存到Cookie中
     */
    public static void setOpenidToCookie(HttpServletResponse response, String openId) {
        Cookie saveCookie;
        saveCookie = new Cookie(Constants.MOBILE_OPENID, openId);
        //设置Cookie失效时间  单位是秒 如果为负数为临时Cookie关闭浏览器失效
        //如果为0表示删除该Cookie 默认为-1
        saveCookie.setMaxAge(2592000);
        response.addCookie(saveCookie);
        System.out.println("Cookie保存openId成功!");
    }

}
