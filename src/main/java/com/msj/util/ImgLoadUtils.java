package com.msj.util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/16 11:37
 */

public class ImgLoadUtils {
    /**
     * @param img
     * @return
     * @throws IOException
     * @desc 保存上传图片 并返回图片的src地址
     */
    public static String upLoad(HttpServletRequest request, MultipartFile img) throws IOException {
        String src = null;
        if (!img.isEmpty()) {
//            String originalPath= request.
            System.out.println("request.getRequestURI()=" + request.getRequestURI());
            System.out.println("request.getContextPath()=" + request.getServletContext().getRealPath("img"));
            /*随机生成UUID*/
            String uuid = UUID.randomUUID().toString().trim();
            /*获取源文件名*/
            String fileN = img.getOriginalFilename();
            /*截取源文件名(文件名.文件类型) 并拼接新文件名*/
            int index = fileN.indexOf(".");

            String fileName = uuid + fileN.substring(index);
            String cachePath = request.getServletContext().getRealPath("img");
            File cacheFile = new File(cachePath, fileName);
            if (!cacheFile.exists()) {
                cacheFile.mkdirs();
            }
            img.transferTo(cacheFile);

            String realPath = request.getServletContext().getRealPath("upload");
            File file = new File(realPath, fileName);
            System.out.println("file.getPath()=" + file.getPath());
            FileOutputStream fileOutputStream = new FileOutputStream(file.getPath());
            fileOutputStream.write(FileUtils.readFileToByteArray(cacheFile));
            fileOutputStream.flush();
            fileOutputStream.close();
            src = ("../upload/" + fileName).trim();
            return src;
        }
        return src;
    }

}
