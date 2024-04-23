package com.trust.xfyl.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trust.xfyl.entity.TrustFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;

/**
 * 上传文件的工具类
 *
 * @author Bay-max
 * @date 2024/4/22 15:39
 **/
@Component
public class FileUtil {

    private static String uploadImgUrl;

    public static Map<String, Object> photoUpload(List<MultipartFile> files, List<TrustFile> trustFiles, Map<String, Object> returnMap) throws IllegalStateException, IOException, NoSuchFieldException {
        String trueFileName = null;
        List<String> fileNameList = new ArrayList<>();

        for (MultipartFile file : files) {
            if (file != null) {
                // 文件路径
                String path = null;
                // 文件类型
                String type = null;
                // 文件原名称 fhl
                String fileName = file.getOriginalFilename();

                // 判断文件类型
                type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
                // 判断文件类型是否为空
                if (type != null) {
                    if (file.isEmpty()) {
                        returnMap.put("status", "-3");
                        returnMap.put("msg", "文件为空");
                        returnMap.put("data", new ObjectMapper());
                    }
                    //获取文件名
                    fileName = file.getOriginalFilename();
                    fileNameList.add(fileName);
                    //设置文件存储路径
                    String picExt = fileName.substring(fileName.lastIndexOf("."));
                    String uuid = UUID.randomUUID().toString();
                    trueFileName = uuid + picExt;
                    // 设置存放图片文件的路径
                    path = uploadImgUrl + trueFileName;
                    String contentType = file.getContentType();
                    File dest = new File(path);
                    //检测是否存在该目录
                    if (!dest.getParentFile().exists()) {
                        dest.getParentFile().mkdirs();
                    }
                    //写入文件
                    file.transferTo(dest);
                    TrustFile trustFile = new TrustFile();
                    trustFile.setIsDelete(0);
                    trustFile.setCreateTime(new Date());
                    trustFile.setFileName(trueFileName);
                    trustFile.setFileOriginName(fileName);
                    trustFile.setFileUrl(path);
                    trustFiles.add(trustFile);
                } else {
                    returnMap.put("status", "-3");
                    returnMap.put("msg", "文件类型为空");
                    returnMap.put("data", new ObjectMapper());
                }
            } else {
                returnMap.put("status", "-4");
                returnMap.put("msg", "没有找到相对应的文件");
                returnMap.put("data", new ObjectMapper());
            }
        }
        returnMap.put("fileNameList", fileNameList);
        returnMap.put("trustFiles", trustFiles);
        returnMap.put("status", "0");
        returnMap.put("msg", "success");
        return returnMap;
    }

    /**
     * 获取文件大小 返回 KB 保留3位小数  没有文件时返回0
     *
     * @param filepath 文件完整路径，包括文件名
     * @return
     */
    public static Double getFilesize(String filepath) {
        File backupath = new File(filepath);
        return Double.valueOf(backupath.length()) / 1000.000;
    }

    /**
     * 创建目录
     *
     * @return
     */
    public static Boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        //判断有没有父路径，就是判断文件整个路径是否存在
        if (!dir.getParentFile().exists()) {
            //不存在就全部创建
            return dir.getParentFile().mkdirs();
        }
        return false;
    }

    /**
     * 删除文件
     *
     * @param filePathAndName String 文件路径及名称 如c:/fqf.txt
     * @return boolean
     */
    public static void delFile(String filePathAndName) {
        try {
            String filePath = filePathAndName;
            filePath = filePath;
            File myDelFile = new File(filePath);
            myDelFile.delete();
        } catch (Exception e) {
            System.out.println("删除文件操作出错");
            e.printStackTrace();
        }
    }

    /**
     * 读取到字节数组0
     *
     * @param filePath //路径
     * @throws IOException
     */
    public static byte[] getContent(String filePath) throws IOException {
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int) fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length
                && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
            offset += numRead;
        }
        // 确保所有数据均被读取
        if (offset != buffer.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }
        fi.close();
        return buffer;
    }

    /**
     * 读取到字节数组1
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray(String filePath) throws IOException {

        File f = new File(filePath);
        if (!f.exists()) {
            throw new FileNotFoundException(filePath);
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }

    /**
     * 读取到字节数组2
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray2(String filePath) throws IOException {
        File f = new File(filePath);
        if (!f.exists()) {
            throw new FileNotFoundException(filePath);
        }
        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(f);
            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(byteBuffer)) > 0) {
            }
            return byteBuffer.array();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Mapped File way MappedByteBuffer 可以在处理大文件时，提升性能
     *
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray3(String filePath) throws IOException {

        FileChannel fc = null;
        RandomAccessFile rf = null;
        try {
            rf = new RandomAccessFile(filePath, "r");
            fc = rf.getChannel();
            MappedByteBuffer byteBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0,
                    fc.size()).load();
            byte[] result = new byte[(int) fc.size()];
            if (byteBuffer.remaining() > 0) {
                byteBuffer.get(result, 0, byteBuffer.remaining());
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                rf.close();
                fc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Value("${imageurl.uploadImgUrl}")
    public void setUploadImgUrl(String uploadImgUrl) {
        FileUtil.uploadImgUrl = uploadImgUrl;
    }

}