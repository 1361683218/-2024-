package com.example.musicwebsite.controller;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.InputStream;

/**
 * MinioController类是一个Spring MVC控制器，用于处理与音乐相关的请求。
 * 该控制器提供了从MinIO获取音频文件、歌手图片和歌单图片的接口。
 */
@Controller // 声明该类为控制器
public class MinioController {

    // 从配置文件中读取存储桶名称
    @Value("${minio.bucket-name}")
    private String bucketName;

    // 自动注入MinioClient实例，用于与MinIO服务进行交互
    @Autowired
    private MinioClient minioClient;

    /**
     * 获取音乐文件。
     *
     * @param fileName 文件名
     * @return 包含音乐文件内容的响应实体
     */
    @GetMapping("/user01/{fileName:.+}") // 映射HTTP GET请求到此方法，支持文件名包含点（.）
    public ResponseEntity<byte[]> getMusic(@PathVariable String fileName) {
        try {
            // 创建GetObjectArgs对象，指定存储桶和对象（文件）名称
            GetObjectArgs args = GetObjectArgs.builder()
                    .bucket(bucketName)
                    .object(fileName)
                    .build();

            // 从MinIO获取指定的对象
            InputStream inputStream = minioClient.getObject(args);

            // 将文件内容读取为字节数组
            byte[] bytes = IOUtils.toByteArray(inputStream);

            // 设置响应头，指示浏览器如何处理响应内容
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); // 设置内容类型为二进制流
            headers.setContentDispositionFormData("attachment", fileName); // 设置为附件下载

            // 返回字节数组作为响应
            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常信息
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 返回500错误
        }
    }

    /**
     * 获取歌手图片。
     *
     * @param fileName 图片文件名
     * @return 包含歌手图片内容的响应实体
     * @throws Exception 任何异常
     */
    @GetMapping("/user01/singer/img/{fileName:.+}") // 处理获取歌手图片的请求
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) throws Exception {
        // 从MinIO获取指定的图片对象
        InputStream stream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(bucketName)
                        .object("singer/img/" + fileName) // 指定图片路径
                        .build()
        );

        byte[] bytes = IOUtils.toByteArray(stream); // 将输入流转换为字节数组

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // 设置响应内容类型为JPEG图片

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK); // 返回图片字节数组
    }

    /**
     * 获取歌单图片。
     *
     * @param fileName 图片文件名
     * @return 包含歌单图片内容的响应实体
     * @throws Exception 任何异常
     */
    @GetMapping("/user01/songlist/{fileName:.+}") // 处理获取歌单图片的请求
    public ResponseEntity<byte[]> getImage1(@PathVariable String fileName) throws Exception {
        // 从MinIO获取指定的歌单图片对象
        InputStream stream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(bucketName)
                        .object("songlist/" + fileName) // 指定歌单图片路径
                        .build()
        );

        byte[] bytes = IOUtils.toByteArray(stream); // 将输入流转换为字节数组

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // 设置响应内容类型为JPEG图片

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK); // 返回图片字节数组
    }

    /**
     * 获取歌曲的图片。
     *
     * @param fileName 图片文件名
     * @return 包含歌曲图片内容的响应实体
     * @throws Exception 任何异常
     */
    @GetMapping("/user01/singer/song/{fileName:.+}") // 处理获取歌曲图片的请求
    public ResponseEntity<byte[]> getImage2(@PathVariable String fileName) throws Exception {
        // 从MinIO获取指定的歌曲图片对象
        InputStream stream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(bucketName)
                        .object("singer/song/" + fileName) // 指定歌曲图片路径
                        .build()
        );

        byte[] bytes = IOUtils.toByteArray(stream); // 将输入流转换为字节数组

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // 设置响应内容类型为JPEG图片

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK); // 返回图片字节数组
    }

}