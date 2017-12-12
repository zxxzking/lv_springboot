package com.zxxz.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class TestController {

    private static String targetUrl = "http://mertest.chinapnr.com/muser/publicRequests";


    public String testDoPost(HttpServletRequest request, HttpServletResponse response){


        return null;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file){
        if(!file.isEmpty()){
            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
                File localFile = new File("D:/resource/"+file.getOriginalFilename());
                if(!localFile.exists()){
                    localFile.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(localFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "上传成功";
        }
        return null;
    }

    @RequestMapping(value = "/download",method = RequestMethod.POST)
    @ResponseBody
    public String download(HttpServletRequest request,HttpServletResponse response){
        String fileName = "新jenkins.txt";
        String filePath = "D:/resource/";
        File file = new File(filePath+fileName);
        System.getProperties();
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        byte[] buffer = new byte[1024];
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        OutputStream os = null;
        String resp = "success";
        try {
            os = response.getOutputStream();
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            int i = bufferedInputStream.read(buffer);
            while (i!=-1){
                os.write(buffer);
                i=bufferedInputStream.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
            resp = "exception";
        }finally {
            try {
                bufferedInputStream.close();
                fileInputStream.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
                resp = "exception";
            }
        }

        return resp;
    }
}
