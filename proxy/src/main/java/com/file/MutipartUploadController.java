package com.file;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
public class MutipartUploadController {

    @ResponseBody
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") List<MultipartFile> files, String testKey) throws IOException, InterruptedException {
//        files.forEach(file -> {
//            try {
//                uploadAll(file);
//            } catch (IOException | InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        uploadAll(file);
        System.out.println(testKey);
        return "success";
//        String fileName = file.getOriginalFilename();
//        if(fileName.indexOf("\\") != -1){
//            fileName = fileName.substring(fileName.lastIndexOf("\\"));
//        }
//        String filePath = "D:\\迅雷下载\\";
//        File targetFile = new File(filePath);
//        if(!targetFile.exists()){
//            targetFile.mkdirs();
//        }
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream(filePath+fileName);
//            out.write(file.getBytes());
//            out.flush();
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "上传失败";
//        }
//        return "上传成功!";
    }

    public void uploadAll(MultipartFile file) throws IOException, InterruptedException {
        Thread.sleep(5000);
        ObjectMetadata metadata = new ObjectMetadata();
        PutObjectRequest putRequest = new PutObjectRequest("asiainfo-bucket-2020-1130", file.getOriginalFilename(), file.getInputStream(), metadata);
        System.out.println("putRequest:" + JSONObject.toJSONString(putRequest));
        PutObjectResult putResult = null;
        try {
            putResult = client.putObject(putRequest);
        } catch (AmazonServiceException ase) {
            System.out.println(ase);
        }
        listObjectFromBucket();
    }

    private static String akey = "IA1AS2FFE5G1H0AH83AA";
    private static String skey = "4FCcuOyNiLt6WjrUs74GRc7351zlXKC27sPlBIZo";
    private static String serverUrl = "10.130.1.2:7480";
    private AmazonS3 client = getS3Client();

    private AmazonS3 getS3Client() {

        AWSCredentials credentials = null;
        String value = "S3SignerType";

        try {
            credentials = new BasicAWSCredentials(akey, skey);
        } catch (Exception e) {
            throw new AmazonClientException(
                    "AmazonClientException : ", e);
        }
        //初始化S3 configure 的实例
        //设置连接时的参数
        ClientConfiguration config = new ClientConfiguration();
        //设置连接方式为HTTP，可选参数为HTTP和HTTPS
        config.setProtocol(Protocol.HTTP);

        //设置use expect continue标志位
//        config.setConnectionTimeout(30000);
        config.setUseExpectContinue(false);
        //设置v2版本
        config.setSignerOverride(value);

        //设置Endpoint
        AwsClientBuilder.EndpointConfiguration end_point = null;
        end_point = new AwsClientBuilder.EndpointConfiguration(serverUrl, "");

        //创建连接,替换原AmazonS3Client接口
        AmazonS3 client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withClientConfiguration(config)
                .withEndpointConfiguration(end_point)
                .withPathStyleAccessEnabled(true)
                .build();
        return client;
    }

    private void listObjectFromBucket() {
        try {
            ListObjectsV2Result objects = client.listObjectsV2("asiainfo-bucket-2020-1130");
            System.out.println(JSONObject.toJSONString(objects));
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @ResponseBody
    @RequestMapping(value = "/upload", produces = "application/json;charset=utf-8")
    public String upload(@RequestParam("file") List<MultipartFile> files, HttpServletRequest request, HttpServletResponse response) {
        boolean result = false;
        String filePath = "D:\\迅雷下载\\";
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                result = true;
            } catch (IOException e) {
                log.error(e.toString(), e);
            }
        }
        return result ? "上传成功" : "上传失败！";
    }

    @ResponseBody
    @RequestMapping(value = "/download")
    public ResponseEntity download(HttpServletResponse response) {
        try {
            response.setHeader("Content-Disposition", "attachment; filename=private_key.pem");
            response.getOutputStream().write("dsuilhkjsncjklndjlksncjklzsdnjklfcnfd".getBytes());
        } catch (Throwable e) {
            log.error("private key download error.{}", e);
            try {
                response.sendError(400, "request time out");
            } catch (IOException ex) {
                log.error("response send error", e);
            }
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
