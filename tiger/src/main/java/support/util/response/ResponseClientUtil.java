package support.util.response;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import support.message.NetMessage;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2014/8/24.
 */
public class ResponseClientUtil {
   /* private static Gson gson =  new GsonBuilder().
            setDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
            .create();*/
   private static Gson gson =  new GsonBuilder().
           setDateFormat("yyyy-MM-dd")
           .create();
    private static final String RESPONSE_CHARSET ="UTF-8";
    protected static JsonFactory factory;
    protected static ObjectMapper mapper = new ObjectMapper();

    static {
        factory = mapper.getJsonFactory();
    }

    public static void response(HttpServletResponse response,NetMessage message){
        Log log = LogFactory.getLog("BUSINESS");
        //打印相应消息
       System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString()+ " 响应消息:"+gson.toJson(message.getDatas()));
        log.error("响应时间： "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString()+ " 响应消息:"+gson.toJson(message.getDatas()));

        //response.setHeader("Access-Control-Allow-Origin","*");//资源交叉访问问题,会出现session问题
        //response.setHeader("P3P","CP='IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT'");
        try {
            response.setContentType("text/html;charset="+RESPONSE_CHARSET);
            PrintWriter writer = response.getWriter();
            writer.write(gson.toJson(message.getDatas()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeJSON(HttpServletResponse response, String json)  {
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeJSON(HttpServletResponse response, Object obj)  {
        response.setContentType("text/html;charset=utf-8");
        JsonGenerator responseJsonGenerator = null;
        try {
            Log log = LogFactory.getLog("BUSINESS");
            //打印相应消息
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString()+ " 响应消息:"+gson.toJson(obj));
            log.error("响应时间： "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString()+ " 响应消息:"+gson.toJson(obj));
            response.getWriter().write( gson.toJson(obj));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
