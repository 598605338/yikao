package com.linjia.tools;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import com.linjia.constants.Application;

/**
 * Created by pocket on 16/7/6.
 */
public class HttpRequestUtil {
//	private static Map<String, String> headers = new HashMap<String, String>();

	// 设置连接超时时间
	private int timeout = 10000;

	// 重试次数
	private int reqNums = 5;

	private RequestConfig requestConfig;

	private static final HttpRequestUtil httpsRequest = new HttpRequestUtil();

	private HttpRequestUtil() {
		requestConfig = RequestConfig.custom().setSocketTimeout(timeout)
				.setConnectionRequestTimeout(timeout).build();
	}

	public static HttpRequestUtil getHttpsRequestSingleton() {
		return httpsRequest;
	}

	/**
	 * 发送get请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public JSONObject sendGet(String url, Map<String, Object> params) {
		String getUrl = url;
		JSONObject jsonObject = null;
		CloseableHttpClient httpClient = null;
		HttpGet httpGet = null;
		try {
			if (params != null) {
				Iterator<Map.Entry<String, Object>> iter = params.entrySet()
						.iterator();
				StringBuffer urlParamsBuffer = new StringBuffer();
				while (iter.hasNext()) {
					Map.Entry<String, Object> entry = iter.next();
					urlParamsBuffer.append(entry.getKey() + "="
							+ entry.getValue() + "&");
				}
				if (urlParamsBuffer.length() > 0) {
					urlParamsBuffer.deleteCharAt(urlParamsBuffer.length() - 1);
					getUrl += '?' + urlParamsBuffer.toString();
				}
			}
			httpClient = HttpClients.createDefault();
			System.out.println("httpUrl:" + getUrl);
			httpGet = new HttpGet(getUrl);
			httpGet.setConfig(requestConfig);
			// //请求重试
			// int i=0;
			// while (true) {
			// 	CloseableHttpResponse response =null;
			// try{
			// 	response = httpClient.execute(httpGet);
			// }catch(Exception e){
			// if(i>reqNums){
			// 	break;
			// }
			// i++;
			// }
			// if (response!= null ) {
			// 	break;
			// }
			// }
			CloseableHttpResponse response = httpClient.execute(httpGet);
			// 获取返回结果http状态code
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				return null;
			} else {
				HttpEntity entity = response.getEntity();
				if (null != entity) {
					InputStream instreams = entity.getContent();
					String responseContent = convertStreamToString(instreams);
					jsonObject = new JSONObject(responseContent);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpGet.releaseConnection();
				httpGet.abort();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jsonObject;
	}

	/**
	 * 发送post请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public JSONObject sendPost(String url, Map<String, String> params) {
		JSONObject jsonObject = null;
		CloseableHttpClient httpClient = null;
		HttpPost httpost = null;
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			if (params != null) {
				Iterator<Map.Entry<String, String>> iter = params.entrySet()
						.iterator();
				while (iter.hasNext()) {
					Map.Entry<String, String> entry = iter.next();
					nameValuePairs.add(new BasicNameValuePair(entry.getKey(),
							entry.getValue()));
				}
			}
			httpClient = HttpClients.createDefault();
			System.out.println("****httpUrl****:" + url);
			httpost = new HttpPost(url);
			// 请求重试
			// //请求重试
			// int i=0;
			// while (true) {
			// 	CloseableHttpResponse response =null;
			// try{
			// 	response = httpClient.execute(httpost);
			// }catch(Exception e){
			// if(i>reqNums){
			// 	break;
			// }
			// 	i++;
			// }
			// if (response!= null ) {
			// 	break;
			// }
			// }
			httpost.setConfig(requestConfig);
			httpost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
			CloseableHttpResponse response = httpClient.execute(httpost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				return null;
			} else {
				HttpEntity entity = response.getEntity();
				if (null != entity) {
					InputStream instreams = entity.getContent();
					String responseContent = convertStreamToString(instreams);
					jsonObject = new JSONObject(responseContent);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpost.releaseConnection();
				httpost.abort();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jsonObject;
	}

	public JSONObject getJsonReq(String reqUrl, String reqJson) {
		JSONObject respJson = null;
		BufferedReader reader = null;
		HttpURLConnection connection = null;
		try {
			URL url = new URL(reqUrl);
			connection = (HttpURLConnection) url.openConnection();
			// 设置输入流采用字节流
			connection.setDoInput(true);
			// 设置输出流采用字节流
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			// 设置缓存
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			// 设置编码
			connection.setRequestProperty("Charset", "utf-8");
			connection.connect();
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());
			out.writeBytes(reqJson);
			out.flush();
			out.close();

			reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), Application.CHARSET));
			String lines;
			StringBuffer sbf = new StringBuffer();
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sbf.append(lines);
			}
			System.out.println(sbf);
			respJson = (JSONObject) JSONObject.stringToValue(sbf.toString());
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 断开连接
			connection.disconnect();
		}
		return respJson;
	}

	//处理返回数据乱码
	public static String convertStreamToString(InputStream is) {
		StringBuilder sb1 = new StringBuilder();
		byte[] bytes = new byte[4096];
		int size = 0;

		try {
			while ((size = is.read(bytes)) > 0) {
				String str = new String(bytes, 0, size, "UTF-8");
				sb1.append(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb1.toString();
	}
	
	/**
	 * 发送get请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public String sendMapGet(String url, Map<String, Object> params) {
		String getUrl = url;
		String jsonObject = null;
		CloseableHttpClient httpClient = null;
		HttpGet httpGet = null;
		try {
			if (params != null) {
				Iterator<Map.Entry<String, Object>> iter = params.entrySet()
						.iterator();
				StringBuffer urlParamsBuffer = new StringBuffer();
				while (iter.hasNext()) {
					Map.Entry<String, Object> entry = iter.next();
					urlParamsBuffer.append(entry.getKey() + "="
							+ entry.getValue() + "&");
				}
				if (urlParamsBuffer.length() > 0) {
					urlParamsBuffer.deleteCharAt(urlParamsBuffer.length() - 1);
					getUrl += '?' + urlParamsBuffer.toString();
				}
			}
			httpClient = HttpClients.createDefault();
			System.out.println("httpUrl:" + getUrl);
			httpGet = new HttpGet(getUrl);
			httpGet.setConfig(requestConfig);
			CloseableHttpResponse response = httpClient.execute(httpGet);
			// 获取返回结果http状态code
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				return null;
			} else {
				HttpEntity entity = response.getEntity();
				if (null != entity) {
					InputStream instreams = entity.getContent();
					jsonObject = convertStreamToString(instreams);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpGet.releaseConnection();
				httpGet.abort();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jsonObject;
	}
}
