package com.zlin.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Resource
    HttpServletRequest request;

    public String RelPath() {
        String path = request.getContextPath();
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    }

    public String RealPath() {
        return request.getSession().getServletContext().getRealPath("/");
    }

    @RequestMapping(value = "uploadFile", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String uploadFile(@RequestParam(value = "file") MultipartFile file) {

        String sourceName = file.getOriginalFilename(); // 原始文件名
        String fileType = sourceName.substring(sourceName.lastIndexOf("."));   // 文件类型
        if (file.isEmpty() || StringUtils.isBlank(fileType)) {     // 文件为空
            return "文件不能为空";
        }
        if (!".txt".equals(fileType.toLowerCase()) && !".csv".equals(fileType.toLowerCase())) {
            return "文件暂时只支持txt,csv格式";
        }

        // 存放文件临时路径
        String base = request.getSession().getServletContext().getRealPath("/upload//");  //获取文件上传的路径，在webapp下的upload中
        File fileTemp = new File(base);
        if (!fileTemp.exists()) {   // upload文件夹不存在，则创建文件夹
            fileTemp.mkdirs();
        }

        // 将文件上传到临时目录
        String path = base + File.separator + sourceName;
        File upload = new File(path);
        try {
            file.transferTo(upload);  // 创建file
        } catch (IOException e) {
            return "文件上传失败，请联系管理员";
        }

        // 解析文件
        BufferedReader br = null;
        FileReader reader = null;
        ArrayList<Long> arrayList = new ArrayList<Long>();
        try {
            reader = new FileReader(upload);
            br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null) {
                Long i = Long.valueOf(line.trim());
                arrayList.add(i);
                System.out.println(i);
            }
        } catch (Exception e) {
            return "读取文件失败，请联系管理员";
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    reader = null;
                }
                if (br != null) {
                    br.close();
                    br = null;
                }
            } catch (Exception e) {
                return "关闭流失败，请联系管理员";
            }
            // 删除临时文件
            if (upload.isFile()) {
                upload.delete();
            }
        }
        return "上传文件并读取文件内容成功";
    }
}
