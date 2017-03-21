package com.linjia.tools;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


/** 
 * 上传图片
 * @author  lixinling: 
 * @date 2016年10月13日 下午5:38:50 
 * @version 1.0 
*/
public class UploadImage {
	
	/**
	 * 上传商品图片
	 * 
	 * lixinling 
	 * 2016年8月2日 下午4:59:45
	 * @param f
	 * @param userId
	 * @return
	 */
	public static String uploadProductImage(String realPath, MultipartFile f) {
		String fileName = f.getOriginalFilename();
		if(Tools.isEmpty(fileName))
			return null;
		String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		String folder = DateComFunc.formatDate(new Date(), "yyyyMMdd");
		String newFileName = folder + RandUtils.getRandomNum(11) + ext;
		String filePath = "/source/photo/" + folder + "/" + newFileName;

//		System.out.println("name:" + fileName + " fileName :" + fileName + " ext:" + ext);

		// 将文件上传到指定的位置
		File file = null;

		file = new File(new File(realPath).getParent() + "/source/photo/" + folder + "/");
		if (file.exists() == false) {
			file.mkdirs();
		}
		file = new File(file, newFileName);
		try {
			// 保存上传的文件
			f.transferTo(file);
			System.out.println("文件保存成功:" );
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		return filePath;
	}
	
	/**
	 * 上传商品图片
	 * 
	 * lixinling 
	 * 2016年8月2日 下午4:59:45
	 * @param f
	 * @param userId
	 * @return
	 */
	public static String uploadProductImage(String realPath, File f) {
		String fileName = f.getName();
		if(Tools.isEmpty(fileName))
			return null;
		String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		String folder = DateComFunc.formatDate(new Date(), "yyyyMMdd");
		String newFileName = folder + RandUtils.getRandomNum(11) + ext;
		String filePath = "/source/photo/" + folder + "/" + newFileName;

//		System.out.println("name:" + fileName + " fileName :" + fileName + " ext:" + ext);

		// 将文件上传到指定的位置
		File file = null;

		file = new File(new File(realPath).getParent() + "/source/photo/" + folder + "/");
		if (file.exists() == false) {
			file.mkdirs();
		}
		file = new File(file, newFileName);
		try {
			// 保存上传的文件
			//f.(file); TODO
			System.out.println("文件保存成功:" );
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return filePath;
	}
}
