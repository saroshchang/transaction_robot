package tw.org.ktrade.robot.utils;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class HttpRequestUtils {
	private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class); // 日志記錄

	/**
	 * httpPost
	 *
	 * @param url 路徑
	 * @param jsonParam 參數
	 * @return
	 */
	public static JSONObject httpPost(String url, JSONObject jsonParam) {
		return httpPost(url, jsonParam, false);
	}

	/**
	 * post請求
	 *
	 * @param url
	 *            url地址
	 * @param jsonParam
	 *            參數
	 * @param noNeedResponse
	 *            不需要返回結果
	 * @return
	 */
	public static JSONObject httpPost(String url, JSONObject jsonParam, boolean noNeedResponse) {
		// post請求返回結果
		// DefaultHttpClient httpClient = new DefaultHttpClient();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		JSONObject jsonResult = null;
		HttpPost method = new HttpPost(url);
		try {
			if (null != jsonParam) {
				// 解決中文亂碼問題
				StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				method.setEntity(entity);

			}
			CloseableHttpResponse result = httpClient.execute(method);

			url = URLDecoder.decode(url, "UTF-8");
			/** 請求發送成功，並得到響應 **/
			if (result.getStatusLine().getStatusCode() == 200) {
				String str = "";
				try {
					/** 讀取服務器返回過來的json字符串數據 **/
					str = EntityUtils.toString(result.getEntity());
					if (noNeedResponse) {
						return null;
					}
					/** 把json字符串轉換成json對象 **/
					jsonResult = JSONObject.fromObject(str);
				} catch (Exception e) {
					logger.error("post請求提交失敗:" + url, e);
				}
			}
		} catch (IOException e) {
			logger.error("post請求提交失敗:" + url, e);
		}
		return jsonResult;
	}

	/**
	 * @param url
	 * @param jsonParam
	 * @param noNeedResponse
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JSONObject doPost(String url, JSONObject jsonParam, boolean noNeedResponse) {
		// 創建Httpclient對象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		// String resultString = "";
		JSONObject jsonResult = null;
		try {
			// 創建Http Post請求
			HttpPost httpPost = new HttpPost(url);
			// 創建參數列表
			if (jsonParam != null) {
				ArrayList paramList = new ArrayList();
				// for (String key : param.keySet()) {
				paramList.add(new BasicNameValuePair("addr", (String) jsonParam.get("addr")));
				// }
				// 模擬表單
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				httpPost.setEntity(entity);
			}
			// 執行http請求
			response = httpClient.execute(httpPost);

			if (response.getStatusLine().getStatusCode() == 200) {
				String str = "";
				try {
					/** 讀取服務器返回過來的json字符串數據 **/
					str = EntityUtils.toString(response.getEntity());
					if (noNeedResponse) {
						return null;
					}
					/** 把json字符串轉換成json對象 **/
					jsonResult = JSONObject.fromObject(str);
				} catch (Exception e) {
					logger.error("post請求提交失敗:" + url, e);
				}
			}
			// resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("post請求提交失敗:" + url, e);
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("post請求提交失敗:" + url, e);
			}
		}

		return jsonResult;
	}

	

	public static CookieStore setCookieStore(HttpResponse httpResponse) {

		CookieStore cookieStore = new BasicCookieStore();
		if (httpResponse.getFirstHeader("Set-Cookie") == null) {
			return null;
		}
		// Set-Cookie由服務器發送，它包含在響應請求的頭部中。它用於在客戶端創建一個Cookie
		// JSESSIONID
		String setCookie = httpResponse.getFirstHeader("Set-Cookie").getValue();
		String JSESSIONID = setCookie.substring("JSESSIONID=".length(), setCookie.indexOf(";"));
		// System.out.println("JSESSIONID:" + JSESSIONID);
		// 新建一個Cookie
		BasicClientCookie cookie = new BasicClientCookie("JSESSIONID", JSESSIONID);
		cookie.setVersion(0);
		cookie.setDomain("https://chain.api.btc.com");
		cookie.setPath("/");

		cookieStore.addCookie(cookie);

		return cookieStore;
	}

	/**
	 * 發送get請求
	 *
	 * @param url
	 *            路徑
	 * @return
	 */

	private static CookieStore cookieStore;

	public static JSONObject httpGet(String url) {
		return httpGet(url, 0, 0);
	}

	public static JSONObject httpGet(String url, int waitMin, int waitMax) {
		if (waitMax > 0) {
			try {
				int number = new Random().nextInt(waitMax - waitMin) + waitMin;
				// System.out.println("Random number = " + number);
				Thread.sleep(number);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// get請求返回結果
		JSONObject jsonResult = null;
		try {
			// DefaultHttpClient client = new DefaultHttpClient();
			// CloseableHttpClient client = HttpClients.createDefault();
			HttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

			// 發送get請求
			HttpGet httpGet = new HttpGet(url);

			httpGet.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36"); // 設置請求頭消息User-Agent
			httpGet.setHeader("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"); // 設置請求頭消息User-Agent
			httpGet.setHeader("Accept-Encoding", "gzip, deflate, br"); // 設置請求頭消息User-Agent
			httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9"); // 設置請求頭消息User-Agent
			httpGet.setHeader("cache-control", "max-age=0"); // 設置請求頭消息User-Agent
			httpGet.setHeader("upgrade-insecure-requests", "1"); // 設置請求頭消息User-Agent
			httpGet.setHeader("Connection", "keep-alive");
			// httpGet.setHeader("cookie", "_ga=GA1.2.352291941.1505216094;
			// _gid=GA1.2.417361201.1515119656; _globalGA=GA1.2.352291941.1505216094;
			// _globalGA_gid=GA1.2.417361201.1515119656;
			// Hm_lvt_02d6fe6e6e4acce5c8d372b5b6e4ef18=1515119655,1515222863,1515222934,1515225361;
			// Hm_lpvt_02d6fe6e6e4acce5c8d372b5b6e4ef18=1515246442");

			HttpResponse response = client.execute(httpGet);
			cookieStore = setCookieStore(response);

			/** 請求發送成功，並得到響應 **/
			if (response.getStatusLine().getStatusCode() == 200) {
				/** 讀取服務器返回過來的json字符串數據 **/
				String strResult = EntityUtils.toString(response.getEntity());
				// String cookie=response.getFirstHeader("Set-Cookie").getValue();
				/** 把json字符串轉換成json對象 **/
				jsonResult = JSONObject.fromObject(strResult);
				url = URLDecoder.decode(url, "UTF-8");
			} else {
				logger.error("get請求提交失敗:" + url);
			}
		} catch (IOException e) {
			logger.error("get請求提交失敗:" + url, e);
		}
		return jsonResult;
	}

	public static JSONObject httpGetFixInvalidCookie(String url) {
		return httpGetFixInvalidCookie(url, 0, 0);
	}

	public static JSONObject httpGetFixInvalidCookie(String url, int waitMin, int waitMax) {
		if (waitMax > 0) {
			try {
				int number = new Random().nextInt(waitMax - waitMin) + waitMin;
				// System.out.println("Random number = " + number);
				Thread.sleep(number);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// get請求返回結果
		JSONObject jsonResult = null;
		try {
			HttpClient client = HttpClients.custom()
					.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build())
					.build();
			;

			// 發送get請求
			HttpGet httpGet = new HttpGet(url);

			httpGet.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36"); // 設置請求頭消息User-Agent
			httpGet.setHeader("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"); // 設置請求頭消息User-Agent
			// httpGet.setHeader("Accept-Encoding", "gzip, deflate, br"); //
			// 設置請求頭消息User-Agent
			httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9"); // 設置請求頭消息User-Agent
			httpGet.setHeader("cache-control", "max-age=0"); // 設置請求頭消息User-Agent
			httpGet.setHeader("upgrade-insecure-requests", "1"); // 設置請求頭消息User-Agent
			httpGet.setHeader("Connection", "keep-alive");
			// httpGet.setHeader("cookie", "_ga=GA1.2.352291941.1505216094;
			// _gid=GA1.2.417361201.1515119656; _globalGA=GA1.2.352291941.1505216094;
			// _globalGA_gid=GA1.2.417361201.1515119656;
			// Hm_lvt_02d6fe6e6e4acce5c8d372b5b6e4ef18=1515119655,1515222863,1515222934,1515225361;
			// Hm_lpvt_02d6fe6e6e4acce5c8d372b5b6e4ef18=1515246442");

			HttpResponse response = client.execute(httpGet);
			cookieStore = setCookieStore(response);

			/** 請求發送成功，並得到響應 **/
			if (response.getStatusLine().getStatusCode() == 200) {
				/** 讀取服務器返回過來的json字符串數據 **/
				String strResult = EntityUtils.toString(response.getEntity());
				// String cookie=response.getFirstHeader("Set-Cookie").getValue();
				/** 把json字符串轉換成json對象 **/
				jsonResult = JSONObject.fromObject(strResult);
				url = URLDecoder.decode(url, "UTF-8");
			} else {
				logger.error("get請求提交失敗:" + url);
			}
		} catch (IOException e) {
			logger.error("get請求提交失敗:" + url, e);
		}
		return jsonResult;
	}

}