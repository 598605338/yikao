package com.linjia.web.poi;

/**
 * @author xiangsy
 * @created 2016-09-28
 */
public class Common {

    public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
    public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";
    public static final String EMPTY = "";
    public static final String POINT = ".";
    public static final String NOT_EXCEL_FILE = ":这不是一个excel文件!";
    public static final String LEAD_OUT_PATH = "E://a.xls";
    
    //获取要导入的xls文件路径
    public String getClass2003Path(){
    	String path = this.getClass().getResource("/").getFile()+"student_info" + POINT + OFFICE_EXCEL_2003_POSTFIX;
    	if(path.startsWith("/")){
    		path=path.substring(1);
    	}
    	return path;
    }
    
    //获取要导入的xlsx文件路径
    public String getClass2010Path(){
    	String path = this.getClass().getResource("/").getFile()+"student_info" + POINT + OFFICE_EXCEL_2010_POSTFIX;
    	if(path.startsWith("/")){
    		path=path.substring(1);
    	}
    	return path;
    }

    public static void main(String[] args) {
    	System.out.println(new Common().getClass2003Path());
	}
    
    /**
     * 根据路径path获取文件类型(后缀)
     */
    public static String getPostfix(String path) {
        if (path == null || Common.EMPTY.equals(path.trim())) {
            return Common.EMPTY;
        }
        if (path.contains(Common.POINT)) {
            return path.substring(path.lastIndexOf(Common.POINT) + 1, path.length());
        }
        return Common.EMPTY;
    }
}
