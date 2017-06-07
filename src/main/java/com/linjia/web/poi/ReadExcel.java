package com.linjia.web.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linjia.web.model.MallProductStore;
import com.linjia.web.service.MallMasterService;
import com.linjia.web.service.ShopUserService;

/**
 * @author xiangsy
 * @created 2016-09-28
 */
@Service
public class ReadExcel {
	
	@Autowired
	private MallMasterService mallMasterService;
	@Autowired
	private ShopUserService shopUserService;
	
	
    /**
     * 根据excel路径读取excel，不同后缀格式的excel选择不同的解析方法
     */
    public List<?> readExcel(String path,int type){
    	try{
	        if (path == null || Common.EMPTY.equals(path)) {
	            return null;
	        } else {
	            String postfix = Common.getPostfix(path);
	            if (!Common.EMPTY.equals(postfix)) {
	                if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
	                	if(type==1){
	                		return leadInShopProducts(path);
	                	}if(type==2){
	                		return setShopProducts(path);
	                	}else{
	                		return readXls(path);
	                	}
	                } else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
	                   if(type==1){
	                	   return readXlsx(path);
	                   }else{
	                	   return readXlsx(path);
	                   }
	                }
	            } else {
	                System.out.println(path + Common.NOT_EXCEL_FILE);
	            }
	        }
    	}catch(Exception e){
    		System.out.println("读取excel文件异常,路径为:"+path + Common.NOT_EXCEL_FILE);
    		e.printStackTrace();
    	}
        return null;
    }

    /**
     * 读取Excel 2010文件
     */
    public static List<Student> readXlsx(String path){
    	Student student = null;
    	List<Student> list = new ArrayList<Student>();
        System.out.println(path);
        try{
	        InputStream is = new FileInputStream(path);
	        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
	        //读取Sheet
	        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
	            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
	            if (xssfSheet == null) {
	                continue;
	            }
	            //读取 Row
	            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
	                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
	                if (xssfRow != null) {
	                    student = new Student();
	                    XSSFCell no = xssfRow.getCell(0);
	                    XSSFCell name = xssfRow.getCell(1);
	                    XSSFCell age = xssfRow.getCell(2);
	                    XSSFCell score = xssfRow.getCell(3);
	                    //往对象设置值
	                    student.setNo((String)getValue(no));
	                    student.setName((String)getValue(name));
	                    Integer ageInt=((Double)getValue(age)).intValue();
	                    student.setAge(ageInt);
	                    Integer scoreInt=((Double)getValue(score)).intValue();
	                    student.setScore(scoreInt);
	                    list.add(student);
	                }
	            }
	        }
        }catch(NumberFormatException e){
    		System.out.println("格式转换异常");
    		e.printStackTrace();
    	}catch(FileNotFoundException e){
    		System.out.println("读取xlsx文件异常,路径为:"+path);
    		e.printStackTrace();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return list;
    }

    /**
     * 读取Excel 2003-2007
     */
    public static List<Student> readXls(String path){
        System.out.println(path);
        List<Student> list = new ArrayList<Student>();
        try{
        	InputStream is = new FileInputStream(path);
	        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
	        // 读取Sheet
	        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
	            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
	            if (hssfSheet == null) {
	                continue;
	            }
	            //读取Row
	            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
	                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
	                if (hssfRow != null) {
	                	Student student = new Student();
	                    HSSFCell no = hssfRow.getCell(0);
	                    HSSFCell name = hssfRow.getCell(1);
	                    HSSFCell age = hssfRow.getCell(2);
	                    HSSFCell score = hssfRow.getCell(3);
	                    //往对象设置值
	                    student.setNo((String)getValue(no));
	                    student.setName((String)getValue(name));
	                    int ageInt=((Double)getValue(age)).intValue();
	                    student.setScore(((Double)getValue(score)).floatValue());
	                    list.add(student);
	                }
	            }
	        }
        }catch(IOException e){
    		System.out.println("读取xls文件异常,路径为:"+path);
    		e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取xls行的值
     * @param xssfRow
     * @return
     */
    @SuppressWarnings("static-access")
    private static Object getValue(XSSFCell xssfRow) {
    	Object cellValue=null;
    	if (null != xssfRow) {     
            switch (xssfRow.getCellType()) {     
            case XSSFCell.CELL_TYPE_NUMERIC: // 数字     
            	cellValue=xssfRow.getNumericCellValue();  
                break;     
            case XSSFCell.CELL_TYPE_STRING: // 字符串     
            	cellValue=xssfRow.getStringCellValue().trim();     
                break;     
            case XSSFCell.CELL_TYPE_BOOLEAN: // Boolean     
            	cellValue=xssfRow.getBooleanCellValue();     
                break;     
            case XSSFCell.CELL_TYPE_FORMULA: // 公式     
            	cellValue=xssfRow.getCellFormula();  
                break;
            default:     
            	cellValue=null;    
                break;     
            }     
        }
    	return cellValue;
    }
        

    /**
     * 获取xlsx行的值
     * @param xssfRow
     * @return
     */
    @SuppressWarnings("static-access")
    public static Object getValue(HSSFCell hssfCell) {
    	Object cellValue=null;
    	if (null != hssfCell) {     
            switch (hssfCell.getCellType()) {     
            case HSSFCell.CELL_TYPE_NUMERIC: // 数字     
            	cellValue=hssfCell.getNumericCellValue();
                break;     
            case HSSFCell.CELL_TYPE_STRING: // 字符串     
            	cellValue=hssfCell.getStringCellValue().trim();     
                break;     
            case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean     
            	cellValue=hssfCell.getBooleanCellValue();     
                break;     
            case HSSFCell.CELL_TYPE_FORMULA: // 公式     
            	cellValue=hssfCell.getCellFormula();  
                break;
            default:     
            	cellValue=null;    
                break;     
            }     
        }
    	return cellValue;
    }
    
    /**
     * 读取Excel 2003-2007 导入门店商品信息
     */
    public List<MallProductStore> leadInShopProducts(String path){
        System.out.println(path);
        List<MallProductStore> list = new ArrayList<MallProductStore>();
        try{
        	InputStream is = new FileInputStream(path);
	        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
	        // 读取Sheet
	        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
	            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
	            if (hssfSheet == null) {
	                continue;
	            }
	            //读取Row
	            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
	                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
	                if (hssfRow != null) {
	                		HSSFCell ifaddAllMalls = hssfRow.getCell(0);
		                    HSSFCell mallCode = hssfRow.getCell(1);
		                    HSSFCell pCode = hssfRow.getCell(2);
		                    HSSFCell salePrice = hssfRow.getCell(3);
		                    HSSFCell stock = hssfRow.getCell(4);
		                    HSSFCell online = hssfRow.getCell(5);
		                    //往对象设置值
		                    String ifAll=(String) getValue(ifaddAllMalls);
		                    String mallSet=(String)getValue(mallCode);
		                    String codeSet=(String)getValue(pCode);
		                    BigDecimal salePriceBig=new BigDecimal(((Double)getValue(salePrice)));
		                    boolean onlineSet=false;
		                    int stockSet=((Double)getValue(stock)).intValue();
		                    String onlineStr=((String)getValue(online));
		                    if(null!=onlineStr){
		                    	if("上架".equals(onlineStr)){
		                    		onlineSet=true;
		                    	}
		                    }
		                if("是".equals(ifAll)){
		                	//查询所有的门店编码
		                	List<String> mallCodes=mallMasterService.selectMallCodes();
		                	for (String mcodes : mallCodes) {
		                		MallProductStore mallpro = new MallProductStore();
		                		mallpro.setSafeQuantity(stockSet);
		                		mallpro.setpCode(codeSet);
		                		mallpro.setMallCode(mcodes);
		                		mallpro.setSalePrice(salePriceBig);
		                		mallpro.setOnline(onlineSet);
		                		list.add(mallpro);
							}
	                    }else{
	                    	MallProductStore mallpro = new MallProductStore();
			                mallpro.setMallCode(mallSet);
			                mallpro.setpCode(codeSet);
			                mallpro.setSalePrice(salePriceBig);
			                mallpro.setSafeQuantity(stockSet);
			                mallpro.setOnline(onlineSet);
			                list.add(mallpro);
	                    }
	                }
	            }
	        }
        }catch(IOException e){
    		System.out.println("读取xls文件异常,路径为:"+path);
    		e.printStackTrace();
        }
        return list;
    }
    
    /**
     * 读取Excel 2003-2007 设置门店商品信息
     */
    public List<MallProductStore> setShopProducts(String path){
        System.out.println(path);
        List<MallProductStore> list = new ArrayList<MallProductStore>();
        try{
        	InputStream is = new FileInputStream(path);
	        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
	        // 读取Sheet
	        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
	            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
	            if (hssfSheet == null) { 
	                continue;
	            }
	            //读取Row
	            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
	                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
	                if (hssfRow != null) {
		                    HSSFCell mallCode = hssfRow.getCell(1);
		                    HSSFCell pCode = hssfRow.getCell(5);
		                    HSSFCell marketPrice = hssfRow.getCell(6);
		                    HSSFCell salePrice = hssfRow.getCell(7);
		                    HSSFCell stock = hssfRow.getCell(8);
		                    HSSFCell safeQuantity=hssfRow.getCell(9);
		                    HSSFCell online = hssfRow.getCell(10);
		                    //往对象设置值
		                    String mallSet=(String)getValue(mallCode);
		                    String codeSet=(String)getValue(pCode);
		                    BigDecimal marketPriceBig=new BigDecimal(((Double)getValue(marketPrice))).setScale(2,BigDecimal.ROUND_HALF_UP);
		                    BigDecimal salePriceBig=new BigDecimal(((Double)getValue(salePrice))).setScale(2,BigDecimal.ROUND_HALF_UP);
		                    int stockSet=((Double)getValue(stock)).intValue();
		                    int safeStockSet=((Double)getValue(safeQuantity)).intValue();
		                    boolean onlineSet=false;
		                    int onlineInt=((Double)getValue(online)).intValue();
		                    if(onlineInt==1){
		                    	onlineSet=true;
		                    }

	                    	MallProductStore mallpro = new MallProductStore();
			                mallpro.setMallCode(mallSet);
			                mallpro.setpCode(codeSet);
			                mallpro.setSafeQuantity(safeStockSet);
			                mallpro.setSalePrice(salePriceBig);
			                mallpro.setMarketPrice(marketPriceBig);
			                mallpro.setQuantity(stockSet);
			                mallpro.setOnline(onlineSet);
			                list.add(mallpro);
	                }
	            }
	        }
        }catch(IOException e){
    		System.out.println("读取xls文件异常,路径为:"+path);
    		e.printStackTrace();
        }
        return list;
    }
}
