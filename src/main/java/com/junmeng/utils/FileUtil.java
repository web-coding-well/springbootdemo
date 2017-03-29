package com.junmeng.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by HWJ on 2017/3/29.
 */
public class FileUtil {

    /**
     * 写文件
     * @param fullPathName  完整路径名，比如“./log/2017.log”
     * @param content       内容
     * @param maxLength    文件最大空间，单位Byte，超过则重新覆盖
     */
    public static void write(String fullPathName,String content,int maxLength){
        try {
            //创建输出异常log日志
            File file = new File(fullPathName);
            //if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            boolean isAppend=true;
            if(file!=null&&file.length()>maxLength){
                isAppend=false;
            }
            FileOutputStream out = new FileOutputStream(file, isAppend); //如果追加方式用true
            out.write(content.getBytes("utf-8"));//注意需要转换对应的字符集
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
