package support.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Matrix on 2016/3/29.
 */
public class MultiFileUpload {

    /**
     * 处理多文件上传
     * @param request 传入请求
     * @param filePath 传入相对路径，根据相对路径在项目目录下创建文件
     * @param fileUrl 传入URL地址
     * @param prefix 传入文件名前缀
     * @return 返回文件的URL地址，多地址用“;”分割，若没有在请求中找到文件，则返回空字符串
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String multiFileUpload(HttpServletRequest request,
                                        String filePath,
                                        String fileUrl,
                                        String prefix)
            throws IllegalStateException, IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        List<String> urls = new ArrayList<>();
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            int index = 1;
            while (iter.hasNext()) {
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (!"".equals(myFileName.trim())) {
                        //重命名上传后的文件名
                        String root = request.getServletContext().getRealPath("/");
                        String fileStr = file.getOriginalFilename();
                        String fileName = prefix + "_" + index++ + fileStr.substring(fileStr.lastIndexOf("."));
                        //定义上传路径
                        String rPath = root + filePath;
                        File rFile = new File(rPath);
                        if(!rFile.exists()) {
                            rFile.mkdirs();
                        }
                        String path = root + filePath + fileName;
                        File localFile = new File(path);
                        file.transferTo(localFile);
                        String webUrl = fileUrl + fileName + ";";
                        urls.add(webUrl);
                    }
                }
            }
            String data = "";
            for(String url : urls) {
                data += url;
            }
            return data;
        } else {
            return "";
        }
    }

}
