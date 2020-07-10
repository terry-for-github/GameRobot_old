/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Administrator
 */
public class ImageUtils {

    /**
     * @param fileUrl 文件绝对路径或相对路径
     * @return 读取到的缓存图像
     * @throws IOException 路径错误或者不存在该文件时抛出IO异常
     */
    public static BufferedImage getBufferedImage(String fileUrl)
            throws IOException {
        File f = new File(fileUrl);
        return ImageIO.read(f);
    }

    /**
     * 远程图片转BufferedImage
     *
     * @param destUrl 远程图片地址
     * @return
     */
    public static BufferedImage getBufferedImageDestUrl(String destUrl) {
        HttpURLConnection conn = null;
        BufferedImage image = null;
        try {
            URL url = new URL(destUrl);
            conn = (HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() == 200) {
                image = ImageIO.read(conn.getInputStream());
                return image;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return image;
    }

    public static void generateSaveFile(BufferedImage buffImg, String savePath) {
        int temp = savePath.lastIndexOf(".") + 1;
        try {
            File outFile = new File(savePath);
            if (!outFile.exists()) {
                outFile.createNewFile();
            }
            ImageIO.write(buffImg, savePath.substring(temp), outFile);
            System.out.println("ImageIO write...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage overlyingImage(BufferedImage buffImg, BufferedImage waterImg, int x, int y, float alpha) throws IOException {

        // 创建Graphics2D对象，用在底图对象上绘图
        Graphics2D g2d = buffImg.createGraphics();
//        g2d.setStroke();

        int waterImgWidth = waterImg.getWidth();// 获取层图的宽度

        int waterImgHeight = waterImg.getHeight();// 获取层图的高度
        // 在图形和图像中实现混合和透明效果

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        // 绘制
        g2d.drawImage(waterImg, x, y, waterImgWidth, waterImgHeight, null);

        g2d.dispose();// 释放图形上下文使用的系统资源

        return buffImg;
    }

   /**
	 * 图片覆盖（覆盖图压缩到width*height大小，覆盖到底图上）
	 * 
	 * @param baseBufferedImage 底图
	 * @param coverBufferedImage 覆盖图
	 * @param x 起始x轴
	 * @param y 起始y轴
	 * @param width 覆盖宽度
	 * @param height 覆盖长度度
	 * @return
	 * @throws Exception
	 */
	public static BufferedImage coverImage(BufferedImage baseBufferedImage, BufferedImage coverBufferedImage, int x, int y, int width, int height) throws Exception{
		
		// 创建Graphics2D对象，用在底图对象上绘图
		Graphics2D g2d = baseBufferedImage.createGraphics();
		
		// 绘制
		g2d.drawImage(coverBufferedImage, x, y, 300, 300, null);
		g2d.dispose();// 释放图形上下文使用的系统资源
		
		return baseBufferedImage;
	}


    /**
     * 待合并的两张图必须满足这样的前提，如果水平方向合并，则高度必须相等；如果是垂直方向合并，宽度必须相等。
     * mergeImage方法不做判断，自己判断。
     *
     * @param img1 待合并的第一张图
     * @param img2 带合并的第二张图
     * @param isHorizontal 为true时表示水平方向合并，为false时表示垂直方向合并
     * @return 返回合并后的BufferedImage对象
     * @throws IOException
     */
    public static BufferedImage mergeImage(BufferedImage img1, BufferedImage img2, boolean isHorizontal) throws IOException {

        int w1 = img1.getWidth();
        int h1 = img1.getHeight();
        int w2 = img2.getWidth();
        int h2 = img2.getHeight();

        // 从图片中读取RGB
        int[] ImageArrayOne = new int[w1 * h1];

        ImageArrayOne = img1.getRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 逐行扫描图像中各个像素的RGB到数组中

        int[] ImageArrayTwo = new int[w2 * h2];

        ImageArrayTwo = img2.getRGB(0, 0, w2, h2, ImageArrayTwo, 0, w2);

        // 生成新图片
        BufferedImage DestImage = null;
        if (isHorizontal) { // 水平方向合并
            DestImage = new BufferedImage(w1 + w2, h1, BufferedImage.TYPE_INT_RGB);
            DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            DestImage.setRGB(w1, 0, w2, h2, ImageArrayTwo, 0, w2);
        } else { // 垂直方向合并
            DestImage = new BufferedImage(w1, h1 + h2, BufferedImage.TYPE_INT_RGB);
            DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            DestImage.setRGB(0, h1, w2, h2, ImageArrayTwo, 0, w2); // 设置下半部分的RGB
        }
        return DestImage;
    }

    /**
     * Java 测试图片叠加方法
     */
    public static void overlyingImageTest() {

        String sourceFilePath = "C:\\Users\\Administrator\\Desktop\\Test\\1.jpg";
        String waterFilePath = "C:\\Users\\Administrator\\Desktop\\Test\\2.jpg";
        String saveFilePath = "C:\\Users\\Administrator\\Desktop\\Test\\overlyingImageNew.jpg";
        try {
            BufferedImage bufferImage1 = getBufferedImage(sourceFilePath);
            BufferedImage bufferImage2 = getBufferedImage(waterFilePath);

            // 构建叠加层
            BufferedImage buffImg = overlyingImage(bufferImage1, bufferImage2, 0, 0, 1.0f);
            // 输出水印图片
            generateSaveFile(buffImg, saveFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Java 测试图片合并方法
     */
    public static void imageMargeTest() {
        // 读取待合并的文件
        BufferedImage bi1 = null;
        BufferedImage bi2 = null;
        // 调用mergeImage方法获得合并后的图像
        BufferedImage destImg = null;
        System.out.println("下面是垂直合并的情况：");
        String saveFilePath = "C:\\Users\\Administrator\\Desktop\\Test\\1.jpg";
        String divingPath = "C:\\Users\\Administrator\\Desktop\\Test\\2.jpg";
        String margeImagePath = "C:\\Users\\Administrator\\Desktop\\Test\\overlyingImageNew.jpg";

        try {
            bi1 = getBufferedImage(saveFilePath);
            bi2 = getBufferedImage(divingPath);
            // 调用mergeImage方法获得合并后的图像
            destImg = mergeImage(bi1, bi2, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 保存图像
        generateSaveFile(destImg, margeImagePath);
        System.out.println("垂直合并完毕!");
    }

    public static BufferedImage CreateLine() throws FileNotFoundException {
        // 得到图片缓冲区
        int width = 501;
        int height = 501;
        int imageType = BufferedImage.TYPE_INT_BGR;
        BufferedImage myImage = new BufferedImage(width, height, imageType);

        // 得到画笔
        Graphics2D pen = (Graphics2D) myImage.getGraphics();

        // 设置笔的颜色,即背景色
        pen.setColor(Color.WHITE);

        // 画出一个矩形
        // 坐标x 坐标y 宽度100 长度50
        pen.fillRect(0, 0, 510, 510);

        // 字的颜色 和 背景的颜色 要不同的
        pen.setColor(Color.blue);

        // 划线
        // 点动成线，线动成面，面动成体
        // 两点确定一条直线
        int xStart = 0;
        int yStart = 0;
        int xEnd = 501;
        int yEnd = 501;

        // 设置线的宽度
        float lineWidth = 0.1F;

        pen.setStroke(new BasicStroke(lineWidth));

        for (int i = 0; i <= 10; i++) {
            pen.drawLine(xStart + i * 50, yStart, i * 50, yEnd);
        }
        for (int j = 0; j <= 10; j++) {
            pen.drawLine(xStart, yStart + j * 50, xEnd, j * 50);
        }

        try {
            ImageIO.write(myImage, "JPEG", new FileOutputStream("line" + ".jpg"));

        } catch (IOException ex) {
            Logger.getLogger(ImageUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        generateSaveFile(myImage, "C:\\Users\\Administrator\\Desktop\\Test\\3.jpg");
        return myImage;
    }

}
