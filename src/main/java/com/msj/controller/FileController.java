package com.msj.controller;

import com.msj.util.ImgLoadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/16 10:42
 */
@Controller
@RequestMapping("/file")
public class FileController {

/*    @PostMapping("/upLoad")
    public String upload(HttpServletRequest request, MultipartFile img) throws IOException {
        String src = ImgLoadUtils.upLoad(request, img);
        request.setAttribute("src", src);
        System.out.println(src);
        return "upLoad";
    }*/
}
