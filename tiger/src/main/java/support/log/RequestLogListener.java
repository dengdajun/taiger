package support.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2015/1/27 0027.
 */
public class RequestLogListener implements ServletRequestListener {

    // 记录访问日志
    final Log log = LogFactory.getLog("REQUEST");

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

        try {
            servletRequestEvent.getServletRequest().setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println(234345);
        }

        HttpServletRequest request = (HttpServletRequest)servletRequestEvent.getServletRequest();

        Map<String,String[]> map = request.getParameterMap();
        JSONObject json = new JSONObject();
        Set<String> keySet = map.keySet();
        for(String key:keySet)
        {
            json.put(key, map.get(key));
        }

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+" 来访者IP："+request.getRemoteHost()+",访问的URI："+request.getRequestURI()+",请求参数："+json);
        log.error("请求时间： "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                + " 请求IP： " + request.getRemoteHost() + ",访问的URI： "
                + request.getRequestURI() + ",请求参数：" + json);

    }
}
