package support.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPostUtil {


    public static String getSubUrl(String urlPath) {
        StringBuilder stringBuilder= new StringBuilder();
        String method = "POST";
        URL url;
        try {
            url = new URL(urlPath);
            //返回一个 URLConnection 对象，它表示到 URL 所引用的远程对象的连接。
            HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
            urlconn.setConnectTimeout(3000);
            urlconn.setReadTimeout(50000);
            urlconn.setRequestMethod(method);//设置请求的方式
            urlconn.setDoOutput(true);//设置doOutput请求头字段的值。
            urlconn.setDoInput(true);//设置doInput请求头字段的值。
            urlconn.setUseCaches(false);//设置useCaches请求头字段的值。
            urlconn.setAllowUserInteraction(false);//设置allowUserInteraction请求头字段的值。
            urlconn.setRequestProperty("content-type","text/html");//设置求头字段的值

            if("POST".equals(method)){
                OutputStream outs = urlconn.getOutputStream();
                Writer writer = new OutputStreamWriter(outs, "UTF-8");
                writer.close();
                outs.close();
            }
            String responseSessionId = urlconn.getHeaderField("Set-Cookie");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlconn.getInputStream(),"UTF-8"));
            String line;
            //将读取到的数据装载到line当中
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }

            bufferedReader.close();
            urlconn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
