package com.linjia.tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class NetRequest {

	public static JSONObject requestPost(String urlstr, JSONObject body, String Authorization) {
		JSONObject result = null;
		try {
			URL url = new URL(urlstr);
			URLConnection conn = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) conn;
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setRequestProperty("accept", "application/json");
			httpUrlConnection.setRequestProperty("content-type", "application/json");
			//增加http basic authenticate认证
			if (!Tools.isEmpty(Authorization)) {
				String encoding = Base64.encode(Authorization.getBytes("UTF-8"));
				httpUrlConnection.setRequestProperty("Authorization", String.format("Basic %s", encoding));
			}
			httpUrlConnection.setDoInput(true);
			if (body != null) {
//				System.out.println("body:" + body.toString());
				httpUrlConnection.setDoOutput(true);
				OutputStream os = httpUrlConnection.getOutputStream();
				IOUtils.write(body.toString(), os, "utf-8");
				os.flush();
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(),"utf-8"));
			String str = "";
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				str += inputLine;
			}
			in.close();
//			System.out.println("str：" + str);
			result = new JSONObject(str);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public static JSONObject request(String urlstr, String body, String nouse) {
		JSONObject result = null;
		try {
			URL url = new URL(urlstr);
			URLConnection conn = url.openConnection();
			conn.setDoInput(true);
			if (body != null) {
				conn.setDoOutput(true);
				OutputStream os = conn.getOutputStream();
				IOUtils.write(body.toString(), os, "utf-8");
				os.flush();
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String str = "";
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				str += inputLine;
			}
			in.close();

			result = new JSONObject(str);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public static JSONObject requestGet(String urlstr, JSONObject body, String Authorization) {
		JSONObject result = null;
		try {
			URL url = new URL(urlstr);
			URLConnection conn = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) conn;
			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.setRequestProperty("accept", "application/json");
			httpUrlConnection.setRequestProperty("content-type", "application/json");

			//增加http basic authenticate认证
			if (!Tools.isEmpty(Authorization)) {
				String encoding = Base64.encode(Authorization.getBytes("UTF-8"));
				httpUrlConnection.setRequestProperty("Authorization", String.format("Basic %s", encoding));
			}
			httpUrlConnection.setDoInput(true);
			if (body != null) {
				httpUrlConnection.setDoOutput(true);
				OutputStream os = httpUrlConnection.getOutputStream();
				IOUtils.write(body.toString(), os, "utf-8");
				os.flush();
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(), "utf-8"));
			String str = "";
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				str += inputLine;
			}
			in.close();
			System.out.println("str：" + str);
			result = new JSONObject(str);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
	
	public static JSONObject requestPut(String urlstr, JSONObject body, String Authorization) {
		JSONObject result = null;
		try {
			URL url = new URL(urlstr);
			URLConnection conn = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) conn;
			httpUrlConnection.setRequestMethod("PUT");
			httpUrlConnection.setRequestProperty("accept", "application/json");
			httpUrlConnection.setRequestProperty("content-type", "application/json");
			
			//增加http basic authenticate认证
			if (!Tools.isEmpty(Authorization)) {
				String encoding = Base64.encode(Authorization.getBytes("UTF-8"));
				httpUrlConnection.setRequestProperty("Authorization", String.format("Basic %s", encoding));
			}
			httpUrlConnection.setDoInput(true);
			if (body != null) {
				httpUrlConnection.setDoOutput(true);
				OutputStream os = httpUrlConnection.getOutputStream();
				IOUtils.write(body.toString(), os, "utf-8");
				os.flush();
			}
			
			BufferedReader in = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(), "utf-8"));
			String str = "";
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				str += inputLine;
			}
			in.close();
			System.out.println("str：" + str);
			result = new JSONObject(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

}
