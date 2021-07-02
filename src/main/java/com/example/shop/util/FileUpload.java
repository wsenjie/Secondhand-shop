package com.example.shop.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 自定义图片文件上传类
 * @author sen
 */
@Component
public class FileUpload {
    //图片文件存储的路径 /upload/
    @Value("${fileUpload.dir}")
    private String saveDir;
    //图片文件最小的大小
    @Value("${fileUpload.minSize}")
    private int minSize;
    //图片文件最大的大小
    @Value("${fileUpload.maxSize}")
    private int maxSize;
    //图片文件允许的后缀  jpg\png
    @Value("${fileUpload.allowSuffix}")
    private List<String> allowSuffix;
    //图片文件存储的真实路径 /src/main/resources/public
    @Value("${fileUpload.path}")
    private String path;

    /**
     * 保存图片文件
     * @param file
     * @return
     */
    public String save(MultipartFile file) {
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取图片的后缀
        String suffix = fileName.substring(fileName.lastIndexOf(46) + 1);
        //判断文件类型是否被允许
        if (allowSuffix.size() != 0 && allowSuffix.indexOf(suffix) == -1) {
            throw new RuntimeException("文件类型不被允许");
        } else if (file.getSize() >= (long)minSize && file.getSize() <= (long)maxSize) {
            File f;
            do {
                //获取项目的路径 + 图片文件存储的真实路径
                String savePath = System.getProperty("user.dir") + path;

                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd/HH/");
                saveDir = saveDir + simpleDateFormat.format(date);

                //以时间格式来创建文件夹
                f = new File(savePath + saveDir);
                if (!f.exists()) {
                    f.mkdirs();
                }
                //添加上传文件的后缀
                saveDir = saveDir + date.getTime() + "." + suffix;
                savePath = savePath + saveDir;
                System.out.println(savePath);
                f = new File(savePath);
            } while (f.exists());

            try {
                //使用此方法保存必须要绝对路径且文件夹必须已存在,否则报错
                //把f这个文件路径所指向的文件 上传到对应的目录下。
                file.transferTo(f);
            } catch (IOException e) {
                return null;
            }
            return saveDir;
        } else {
            throw new RuntimeException("文件大小不在允许范围内");
        }
    }
}
