package com.example.musicwebsite.service.impl;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

// 声明该类为服务类
@Service
public class MinioUploadServiceimpl {

    // MinIO客户端和桶名称的静态变量
    private static MinioClient minioClient;
    private static String bucketName;

    // 初始化方法，加载 MinIO 的配置信息
    public static void init() {
        Properties properties = new Properties();
        try {
            // 使用类加载器获取资源文件的输入流
            InputStream inputStream = MinioUploadServiceimpl.class.getClassLoader().getResourceAsStream("application-dev.properties");
            if (inputStream != null) {
                // 加载 MinIO 配置
                properties.load(inputStream);
                String minioEndpoint = properties.getProperty("minio.endpoint");
                String minioAccessKey = properties.getProperty("minio.access-key");
                String minioSecretKey = properties.getProperty("minio.secret-key");
                String minioBucketName = properties.getProperty("minio.bucket-name");
                bucketName = minioBucketName;
                // 创建 MinIO 客户端
                minioClient = MinioClient.builder()
                        .endpoint(minioEndpoint)
                        .credentials(minioAccessKey, minioSecretKey)
                        .build();
            }
        } catch (Exception e) {
            // 捕获并打印异常
            System.out.println(e);
        }
    }

    // 上传文件到 MinIO 的通用方法
    public static String uploadFile(MultipartFile file) {
        try {
            init(); // 确保 MinIO 客户端已初始化
            InputStream inputStream = file.getInputStream();
            // 上传文件到指定桶
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(file.getOriginalFilename())
                            .stream(inputStream, inputStream.available(), -1)
                            .contentType(file.getContentType())
                            .build()
            );
            return "File uploaded successfully!"; // 返回上传成功信息
        } catch (MinioException | IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            return "Error uploading file to MinIO: " + e.getMessage(); // 返回错误信息
        } catch (Exception e) {
            throw new RuntimeException(e); // 处理其他异常
        }
    }

    // 上传图片文件到 MinIO 指定的图片目录
    public static String uploadImgFile(MultipartFile file) {
        try {
            init(); // 确保 MinIO 客户端已初始化
            InputStream inputStream = file.getInputStream();
            // 上传文件到指定的图片目录
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object("/singer/img/" + file.getOriginalFilename())
                            .stream(inputStream, inputStream.available(), -1)
                            .contentType(file.getContentType())
                            .build()
            );
            return "File uploaded successfully!";
        } catch (MinioException | IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            return "Error uploading file to MinIO: " + e.getMessage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 上传歌单图片文件到 MinIO 的歌单目录
    public static String uploadSonglistImgFile(MultipartFile file) {
        try {
            init(); // 确保 MinIO 客户端已初始化
            InputStream inputStream = file.getInputStream();
            // 上传文件到歌单目录
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object("/songlist/" + file.getOriginalFilename())
                            .stream(inputStream, inputStream.available(), -1)
                            .contentType(file.getContentType())
                            .build()
            );
            return "File uploaded successfully!";
        } catch (ServerException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        }
    }
}
