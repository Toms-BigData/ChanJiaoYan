package com.lyx.teach.Utils.Util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileUtil {
    /**
     * MultipartFile文件转换成File文件
     * @param multipartFile
     * @return
     */
    public static File MultipartFile2File(MultipartFile multipartFile){
        //文件上传前的名称
        String fileName = multipartFile.getOriginalFilename();
        File file = new File(fileName);
        OutputStream out = null;
        try{
            //获取文件流，以文件流的方式输出到新文件
            out = new FileOutputStream(file);
            byte[] ss = multipartFile.getBytes();
            for(int i = 0; i < ss.length; i++){
                out.write(ss[i]);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }
}
