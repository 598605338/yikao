package com.linjia.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

import com.alibaba.druid.pool.DruidDataSource;
import com.linjia.web.dao.ProductMapper;


/** 
 * @author  lixinling: 
 * @date 2016年11月30日 下午2:22:52 
 * @version 1.0 
*/
public class ImportProductImage {


	@Test
	public void importProductImage(){
		String path="D:\\600x450";
		File file = new File(path);
		File[] fileList = file.listFiles();
		if(fileList != null && fileList.length > 0){
			System.out.println("该目录下共:"+fileList.length+"个文件。");
			for(int i=0;i<fileList.length;i++){
				File tmpFile = fileList[i];
				String fileName = tmpFile.getName();
				//System.out.println(fileName);
				String pCode = fileName.replace(".jpg", "").split("_")[0];
				if(checkExist(pCode)){
					String filePath = uploadImage(tmpFile,fileName);
					updateImagePath(filePath,pCode);
				}
			}
		}else{
			System.out.println("该目录下没有文件。");
		}
	}
	
	public Connection getConn(){
		Connection conn = null;
		try {
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/linjia";
			String username = "root";
			String password = "123456";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public boolean checkExist(String pCode){
		boolean flag =false;
		String sql = "SELECT p_code FROM `b_product` where p_code = ?";
		PreparedStatement pstmt;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, pCode);
			ResultSet rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()){
					if(!Tools.isEmpty(rs.getString("p_code"))){
						flag = true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateImagePath(String imagePath,String pCode){
		boolean flag =false;
		String sql = "update b_product SET image_path=? where p_code = ?";
		PreparedStatement pstmt;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, imagePath);
			pstmt.setString(2, pCode);
			int row = pstmt.executeUpdate();
			if(row ==1){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public String uploadImage(File tmpFile, String fileName){
		String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		String folder = DateComFunc.formatDate(new Date(), "yyyyMMdd");
		String newFileName = folder + RandUtils.getRandomNum(11) + ext;
		String filePath = "/source/photo/" + folder + "/" + newFileName;
		
		File file = new File("E:/source/photo/" + folder + "/");
		if (file.exists() == false) {
			file.mkdirs();
		}
		file = new File(file, newFileName);
		byte[] buffer = new byte[1024*8];
		int b = 0;
		InputStream in = null;
		OutputStream os = null;
		try {
			in = new FileInputStream(tmpFile);
			os = new FileOutputStream(file);
			while((b = in.read(buffer)) != -1){
				os.write(buffer, 0, b);
			}
			os.flush();
			os.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				os.flush();
				os.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return filePath;
	}
}
