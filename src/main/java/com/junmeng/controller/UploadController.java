package com.junmeng.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 文件上传例子
 * Created by HWJ on 2017/4/4.
 */
@RestController
@RequestMapping("/upload")
public class UploadController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 单文件上传
     * @param filename
     * @param file
     * @return
     */
    @PostMapping("/file")
    @ResponseBody
    public String uploadFile(@RequestParam("filename") String filename,
                             @RequestParam("file") MultipartFile file) {
        logger.info("上传的文件名为：" + filename);
        if (file.isEmpty()) {
            return "文件为空";
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);

        // 文件上传路径
        String filePath = "E:/upload/";

        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;

        File dest = new File(filePath + fileName);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }


    /**
     * 多文件上传
     * @param request
     * @return
     */
    @PostMapping("/files")
    @ResponseBody
    public String uploadFiles(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        if(files==null||files.isEmpty()){
            return "没有上传文件或者文件的名称不是为“file”";
        }
        int count=0;
        for(MultipartFile file:files){
            if (!file.isEmpty()) {
                // 获取文件名
                String fileName = file.getOriginalFilename();
                logger.info("上传的文件名为：" + fileName);

                // 获取文件的后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                logger.info("上传的后缀名为：" + suffixName);

                // 文件上传路径
                String filePath = "E:/upload/";

                // 解决中文问题，liunx下中文路径，图片显示问题
                // fileName = UUID.randomUUID() + suffixName;

                File dest = new File(filePath + fileName);

                // 检测是否存在目录
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }

                try {
                    file.transferTo(dest);
                    count++;
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       return "success upload "+count+" files.";
    }

}
