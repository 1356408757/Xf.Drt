package com.trust.xfyl.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * 皮肤检测工具类
 *
 * @Description 实现对图片中皮肤的检测
 * @author Bay-max
 * @date 2024/4/22 15:39
 **/
public class SkinDetection {

    private static final Logger logger = LoggerFactory.getLogger(SkinDetection.class);

    private static final double[][] SOBEL_X = {
            {-1, 0, 1},
            {-2, 0, 2},
            {-1, 0, 1}
    };
    private static final double[][] SOBEL_Y = {
            {1, 2, 1},
            {0, 0, 0},
            {-1, -2, -1}
    };
    private static final double[][] GAUSSIAN_KERNEL = {
            {1.0 / 16, 2.0 / 16, 1.0 / 16},
            {2.0 / 16, 4.0 / 16, 2.0 / 16},
            {1.0 / 16, 2.0 / 16, 1.0 / 16}
    };

    private int compressedWidth = 0;
    private int compressedHeight = 0;
    private double colorThreshold = 0;
    private double textureThreshold = 0;

    /**
     * 对指定图片进行皮肤检测
     *
     * @param imagePath 图片路径
     * @return 检测结果，true表示图片中存在皮肤，false表示不存在或处理失败
     */
    public static boolean skinDetection(String imagePath) {
        SkinDetection skinDetection = new SkinDetection();
        // 设置参数
        skinDetection.setParameters(50, 50, 0.1, 50);
        // 处理图片
        boolean result = skinDetection.detectSkin(imagePath);
        logger.info("处理结果：{}", result ? "true" : "false");
        return result;
    }

    /**
     * 设置检测参数
     *
     * @param width        压缩后图片宽度
     * @param height       压缩后图片高度
     * @param colorThreshold  颜色阈值
     * @param textureThreshold 纹理阈值
     */
    public void setParameters(int width, int height, double colorThreshold, double textureThreshold) {
        this.compressedWidth = width;
        this.compressedHeight = height;
        this.colorThreshold = colorThreshold;
        this.textureThreshold = textureThreshold;
    }

    /**
     * 检测图片中是否存在皮肤
     *
     * @param imagePath 图片路径
     * @return 检测结果，true表示图片中存在皮肤，false表示不存在或处理失败
     */
    public boolean detectSkin(String imagePath) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            if (originalImage == null) {
                logger.error("无法读取图片：{}", imagePath);
                return false;
            }

            BufferedImage compressedImage = compressImage(originalImage);
            if (compressedImage == null) {
                logger.error("压缩图片失败");
                return false;
            }

            return isHumanBody(compressedImage);
        } catch (IOException e) {
            logger.error("处理图片时出现异常：{}", e.getMessage());
            return false;
        }
    }

    /**
     * 压缩图片
     *
     * @param image 原始图片
     * @return 压缩后的图片
     */
    private BufferedImage compressImage(BufferedImage image) {
        BufferedImage compressedImage = new BufferedImage(compressedWidth, compressedHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = compressedImage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(image, 0, 0, compressedWidth, compressedHeight, null);
        g.dispose();
        return compressedImage;
    }

    /**
     * 判断给定RGB颜色是否为皮肤颜色
     *
     * @param red  红色分量
     * @param green  绿色分量
     * @param blue  蓝色分量
     * @return 判断结果，true表示是皮肤颜色，false表示不是
     */
    private boolean isSkinColor(int red, int green, int blue) {
        return (red > 95 && green > 40 && blue > 20 && (Math.max(red, Math.max(green, blue)) - Math.min(red, Math.min(green, blue))) > 15 && Math.abs(red - green) > 15 && red > green && red > blue);
    }

    /**
     * 判断图像中指定点是否具有皮肤纹理
     *
     * @param image  图像
     * @param x  点的x坐标
     * @param y  点的y坐标
     * @return 判断结果，true表示具有皮肤纹理，false表示不具有
     */
    private boolean hasSkinTexture(BufferedImage image, int x, int y) {
        double magnitude = calculateGradientMagnitude(image, x, y);
        double smoothedMagnitude = applyGaussianFilter(magnitude);
        return smoothedMagnitude > textureThreshold;
    }

    /**
     * 计算图像中指定点的梯度模
     *
     * @param image  图像
     * @param x  点的x坐标
     * @param y  点的y坐标
     * @return 梯度模
     */
    private double calculateGradientMagnitude(BufferedImage image, int x, int y) {
        double sumX = calculateGradientSum(image, x, y, SOBEL_X);
        double sumY = calculateGradientSum(image, x, y, SOBEL_Y);
        return Math.sqrt(sumX * sumX + sumY * sumY);
    }

    /**
     * 计算图像中指定点在给定核下的梯度和
     *
     * @param image  图像
     * @param x  点的x坐标
     * @param y  点的y坐标
     * @param kernel 梯度核
     * @return 梯度和
     */
    private double calculateGradientSum(BufferedImage image, int x, int y, double[][] kernel) {
        double sum = 0;
        int width = image.getWidth();
        int height = image.getHeight();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = Math.min(Math.max(x + i, 0), width - 1);
                int newY = Math.min(Math.max(y + j, 0), height - 1);
                int pixel = image.getRGB(newX, newY);
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = pixel & 0xFF;
                double gray = 0.2989 * red + 0.5870 * green + 0.1140 * blue;
                sum += kernel[i + 1][j + 1] * gray;
            }
        }

        return sum;
    }

    /**
     * 对给定值应用高斯滤波
     *
     * @param value  待滤波的值
     * @return 滤波后的值
     */
    private double applyGaussianFilter(double value) {
        double smoothedValue = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                double weight = GAUSSIAN_KERNEL[i + 1][j + 1];
                smoothedValue += weight * value;
            }
        }

        return smoothedValue;
    }

    /**
     * 判断图片中是否包含人体
     *
     * @param image  图像
     * @return 判断结果，true表示包含人体，false表示不包含
     */
    private boolean isHumanBody(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        int skinPixelCount = 0;
        int totalPixelCount = width * height;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                if (isSkinColor(red, green, blue) && hasSkinTexture(image, x, y)) {
                    skinPixelCount++;
                }
            }
        }

        double skinPixelRatio = (double) skinPixelCount / totalPixelCount;
        return skinPixelRatio > colorThreshold;
    }

}
