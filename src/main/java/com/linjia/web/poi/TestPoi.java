package com.linjia.web.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author xiangsy
 * @created 2016-09-28
 */
public class TestPoi {
	
	public static void testLeadOut(){
		// 测试导入学生
		try{
			ExportExcel<Student> ex = new ExportExcel<Student>();
			String[] headers = { "学号", "姓名", "年龄", "性别","分数","是否毕业","出生日期" };
			List<Student> dataset = new ArrayList<Student>();
			dataset.add(new Student("10000001", "张三", 20, 1,65.5f,true,new Date()));
			dataset.add(new Student("20000002", "李四", 24, 1,65.5f,false,new Date()));
			dataset.add(new Student("30000003", "王五", 22, 1,65.5f,false,new Date()));
			
			OutputStream out = new FileOutputStream(Common.LEAD_OUT_PATH);
			ex.exportExcel(headers, dataset, out);
			out.close();
			JOptionPane.showMessageDialog(null, "导出成功!");
			System.out.println("excel导出成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void testLeadIn(){
    	Common com=new Common();
        String excel2003_2007 = com.getClass2003Path();
        List<Student> list = (List<Student>) new ReadExcel().readExcel(excel2003_2007,999);
        if (list != null) {
            for (Student student : list) {
                System.out.println("No. : " + student.getNo() + ", name : " + student.getName() + ", age : " + student.getAge() + ", score : " + student.getScore());
            }
        }
        System.out.println("======================================");
	}

    public static void main(String[] args){
    	testLeadIn();
    	testLeadOut();
    }
}
