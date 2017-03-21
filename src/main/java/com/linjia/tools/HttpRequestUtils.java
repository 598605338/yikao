package com.linjia.tools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.org.apache.xml.internal.security.utils.Base64;

/** 
 * @author  lixinling: 
 * @date 2016年11月30日 上午10:12:21 
 * @version 1.0 
*/
public class HttpRequestUtils {
	protected final Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class); // 日志记录

	// 表示请求器是否已经做了初始化工作
	private static boolean hasInit = false;

	// 连接超时时间，默认10秒
	private static int socketTimeout = 10000;

	// 传输超时时间，默认30秒
	private static int connectTimeout = 30000;

	// 请求器的配置
	private static RequestConfig requestConfig;

	public static void init() {
		if (!hasInit) {
			requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
		}
	}

	public static JSONObject httpPost(String url, JSONObject param, String Authorization) {
		init();

		// post请求返回结果
		CloseableHttpClient httpClient = HttpClients.createDefault();
		JSONObject result = null;
		HttpPost httpPost = new HttpPost(url);
		if (param != null) {
			// 解决中文乱码问题
			StringEntity entity = new StringEntity(param.toString(), "UTF-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPost.setEntity(entity);

		}
		// 增加http basic authenticate认证
		if (!Tools.isEmpty(Authorization)) {
			String encoding;
			try {
				encoding = Base64.encode(Authorization.getBytes("UTF-8"));
				httpPost.setHeader("Authorization", String.format("Basic %s", encoding));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		// 设置请求器的配置
		httpPost.setConfig(requestConfig);

		try {
			HttpResponse response = httpClient.execute(httpPost);

			// 请求发送成功，得到响应
			int responseCode = response.getStatusLine().getStatusCode();
			if (response.getStatusLine().getStatusCode() == 200) {
				String str = EntityUtils.toString(response.getEntity(),"UTF-8");
				try {
					result = new JSONObject(str);
					result.put("responseCode", responseCode);
				} catch (org.json.JSONException e) {
					result = new JSONObject();
					result.put("str", str);
					result.put("responseCode", responseCode);
				}
			} else {
				result = new JSONObject();
				result.put("responseCode", responseCode);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpPost.releaseConnection();
				httpPost.abort();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static JSONObject httpGet(String url, String Authorization) {
		init();

		// get请求返回结果
		JSONObject result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// 发送get请求
		HttpGet httpGet = new HttpGet(url);
		// 增加http basic authenticate认证
		if (!Tools.isEmpty(Authorization)) {
			String encoding;
			try {
				encoding = Base64.encode(Authorization.getBytes("UTF-8"));
				httpGet.setHeader("Authorization", String.format("Basic %s", encoding));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		// 设置请求器的配置
		httpGet.setConfig(requestConfig);
		try {
			HttpResponse response = httpClient.execute(httpGet);
			// 请求发送成功，得到响应
			int responseCode = response.getStatusLine().getStatusCode();
//			if (responseCode == 200) {
				String str = EntityUtils.toString(response.getEntity(),"UTF-8");
				try {
					result = new JSONObject(str);
				} catch (org.json.JSONException e) {
					result = new JSONObject();
					result.put("responseCode", responseCode);
				}
//			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
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

		return result;
	}
}
