package com.linjia.tools;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;



/** 
 * 图片处理(压缩)
 * @author  lixinling: 
 * @date 2016年11月9日 下午5:16:54 
 * @version 1.0 
*/
public class ImageUtils {
	
	/** 
     * 采用指定宽度、高度或压缩比例 的方式对图片进行压缩 
     * @param imgsrc 源图片地址 
     * @param imgdist 目标图片地址 
     * @param widthdist 压缩后图片宽度（当rate==null时，必传） 
     * @param heightdist 压缩后图片高度（当rate==null时，必传） 
     * @param rate 压缩比例  
     */  
	public static void reduceImage(String imgsrc, String imgdist, int widthdist, int heightdist, Float rate) {
		File srcFile = new File(imgsrc);
		//检查文件是否存在
		if(!srcFile.exists())
			return ;
		
		// 如果rate不为空说明是按比例压缩  
		if(rate != null && rate>0){
			int[] result = getImgWidth(srcFile);
			if(result == null || result[0] ==0 || result[1] == 0){
				return;
			}else{
				widthdist = (int)(result[0]*rate);
				heightdist = (int)(result[1]*rate);
			}
		}
		
		//开始读取文件并进行压缩
		try {
			Image src = ImageIO.read(srcFile);
			BufferedImage tag = new BufferedImage(widthdist,heightdist,BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, Image.SCALE_SMOOTH),0,0,null);
			
			FileOutputStream out = new FileOutputStream(imgdist);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(tag);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取图片的宽高
	 * lixinling 
	 * 2016年11月9日 下午5:46:38
	 * @param file
	 * @return
	 */
	public static int[] getImgWidth(File file){
		InputStream is = null;
		BufferedImage src = null;
		int result[] = {0,0};
		try {
			is = new FileInputStream(file);
			src = ImageIO.read(is);
			result[0] = src.getWidth();
			result[1] = src.getHeight();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		String imgsrc = "E:/lxl/a.jpg"; String imgdist="E:/lxl/b.jpg"; int widthdist =0; int heightdist=0; Float rate=0.5f;
		File imgsrcF = new File(imgsrc);
		System.out.println("压缩前大小：" + imgsrcF.length());
		reduceImage(imgsrc,imgdist,widthdist,heightdist,rate);
		File imgdistF = new File(imgdist);
		System.out.println("压缩后大小：" + imgdistF.length());
	}
}
