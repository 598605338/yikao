package com.linjia.web.poi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author xiangsy Create By 2015年3月26日 下午14:20:58 内置库cvs文件导入处理类 每行字段分别格式:
 *         area_code,ip_start, ip_end,memo
 */
public class CsvParserUtil {
	private static Logger LOG = LoggerFactory.getLogger(CsvParserUtil.class);
	private InputStreamReader fr = null;
	private BufferedReader br = null;
	
	public CsvParserUtil(String file) {
		try {
			File f = new File(file);
			FileInputStream fis = new FileInputStream(f);
			// 这里如果csv文件编码格式是GBK,改成GBK即可
			fr = new InputStreamReader(fis, "GBK");
		} catch (FileNotFoundException e) {
			LOG.error(e.getMessage());
			LOG.debug("csv上传文件未找到", e);
		} catch (UnsupportedEncodingException e) {
			LOG.error(e.getMessage());
			LOG.debug("csv文件编码错误!", e);
		}
	}

	/**
	 * 解析csv文件 到一个list中 每个单元个为一个String类型记录
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<List<String>> readCSVFile() {
		br = new BufferedReader(fr);
		String strLine = null;// 一行
		List<List<String>> FileText = new ArrayList<List<String>>();
		try {
			while ((strLine = br.readLine()) != null) {
				String[] fields = strLine.split("\\s*,\\s*");
				//StringUtils会将两个","之间的空格数据截取去掉影响数据顺序,导致后面的按顺序取值出错
//				String[] fields = StringUtils.split(strLine, "\\s*,\\s*");
				FileText.add(Arrays.asList(fields));
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.debug("csv文件读取异常!", e);
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				LOG.error(e.getMessage());
				LOG.debug("csv文件输入流关闭异常!", e);
			}
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				LOG.error(e.getMessage());
				LOG.debug("csv文件流关闭异常!", e);
			}
		}
		return FileText;
	}

	/**
	 * 将解析出来的CSV文件list转换成IPLocation的java对象数组
	 * @return
	 * @throws IOException
	 */
	public List<?> listToIpObj(List<List<String>> FileText) {
//		List<IPLocation> listIP = new ArrayList<IPLocation>();
		try {
			//i==1,跳过文件头
			for (int i=1;i<FileText.size();i++) {
				List<String> textLine=FileText.get(i);
				if (textLine.size() > 0) {
					String areaCode=null;
					String startIp=null;
					String endIp=null;
					String memo=null;
					Boolean ifStartIp=false;
					Boolean ifEndIp=false;
					//至少有两个字段有值才是有效数据
					if(textLine.size() < 2) {
						continue;
					}
					areaCode= textLine.get(0).trim();
//					IPLocation ipo = new IPLocation();
//					ipo.setAreaCode(areaCode);
//					ipo.setStartIp(startIp);
//					ipo.setEndIp(endIp);
//					ipo.setMemo(memo);
//					listIP.add(ipo);
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.debug("csv文件行转换java对象异常!", e);
		}
		return null;
	}
	
}