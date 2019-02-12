package tw.org.ktrade.robot.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 封裝HttpClient工具方法
 * @author jinlin
 * @email jinlin@geotmt.com
 * @date 2017/11/13 13:55
 */
public class HttpClientUtil {
    private CloseableHttpClient httpClient;

    public HttpClientUtil() {
        // 1 創建HttpClinet，相當於打開瀏覽器
        this.httpClient = HttpClients.createDefault();
    }

    /**
     * 帶參數的get請求
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public HttpResult doGet(String url, Map<String, Object> map) throws Exception {

        // 聲明URIBuilder
        URIBuilder uriBuilder = new URIBuilder(url);

        // 判斷參數map是否為非空
        if (map != null) {
            // 遍歷參數
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                // 設置參數
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        // 2 創建httpGet對象，相當於設置url請求地址
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        // 3 使用HttpClient執行httpGet，相當於按回車，發起請求
        CloseableHttpResponse response = this.httpClient.execute(httpGet);

        // 4 解析結果，封裝返回對象httpResult，相當於顯示相應的結果
        // 狀態碼
        // response.getStatusLine().getStatusCode();
        // 響應體，字符串，如果response.getEntity()為空，下面這個代碼會報錯,所以解析之前要做非空的判斷
        // EntityUtils.toString(response.getEntity(), "UTF-8");
        HttpResult httpResult = null;
        // 解析數據封裝HttpResult
        if (response.getEntity() != null) {
            httpResult = new HttpResult(response.getStatusLine().getStatusCode(),
                    EntityUtils.toString(response.getEntity(), "UTF-8"));
        } else {
            httpResult = new HttpResult(response.getStatusLine().getStatusCode(), "");
        }

        // 返回
        return httpResult;
    }

    /**
     * 不帶參數的get請求
     * @param url
     * @return
     * @throws Exception
     */
    public HttpResult doGet(String url) throws Exception {
        HttpResult httpResult = this.doGet(url, null);
        return httpResult;
    }

    /**
     * 帶參數的post請求
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public HttpResult doPost(String url, Map<String, Object> map) throws Exception {
        // 聲明httpPost請求
        HttpPost httpPost = new HttpPost(url);

        // 判斷map不為空
        if (map != null) {
            // 聲明存放參數的List集合
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            // 遍歷map，設置參數到list中
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }

            // 創建form表單對象
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "UTF-8");

            // 把表單對象設置到httpPost中
            httpPost.setEntity(formEntity);
        }

        // 使用HttpClient發起請求，返回response
        CloseableHttpResponse response = this.httpClient.execute(httpPost);

        // 解析response封裝返回對象httpResult
        HttpResult httpResult = null;
        if (response.getEntity() != null) {
            httpResult = new HttpResult(response.getStatusLine().getStatusCode(),
                    EntityUtils.toString(response.getEntity(), "UTF-8"));
        } else {
            httpResult = new HttpResult(response.getStatusLine().getStatusCode(), "");
        }

        // 返回結果
        return httpResult;
    }

    /**
     * 不帶參數的post請求
     * @param url
     * @return
     * @throws Exception
     */
    public HttpResult doPost(String url) throws Exception {
        HttpResult httpResult = this.doPost(url, null);
        return httpResult;
    }

    /**
     * 帶參數的Put請求
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public HttpResult doPut(String url, Map<String, Object> map) throws Exception {
        // 聲明httpPost請求
        HttpPut httpPut = new HttpPut(url);

        // 判斷map不為空
        if (map != null) {
            // 聲明存放參數的List集合
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            // 遍歷map，設置參數到list中
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }

            // 創建form表單對象
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "UTF-8");

            // 把表單對象設置到httpPost中
            httpPut.setEntity(formEntity);
        }

        // 使用HttpClient發起請求，返回response
        CloseableHttpResponse response = this.httpClient.execute(httpPut);

        // 解析response封裝返回對象httpResult
        HttpResult httpResult = null;
        if (response.getEntity() != null) {
            httpResult = new HttpResult(response.getStatusLine().getStatusCode(),
                    EntityUtils.toString(response.getEntity(), "UTF-8"));
        } else {
            httpResult = new HttpResult(response.getStatusLine().getStatusCode(), "");
        }

        // 返回結果
        return httpResult;
    }

    /**
     * 帶參數的Delete請求
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public HttpResult doDelete(String url, Map<String, Object> map) throws Exception {

        // 聲明URIBuilder
        URIBuilder uriBuilder = new URIBuilder(url);

        // 判斷參數map是否為非空
        if (map != null) {
            // 遍歷參數
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                // 設置參數
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        // 2 創建httpGet對象，相當於設置url請求地址
        HttpDelete httpDelete = new HttpDelete(uriBuilder.build());

        // 3 使用HttpClient執行httpGet，相當於按回車，發起請求
        CloseableHttpResponse response = this.httpClient.execute(httpDelete);

        // 4 解析結果，封裝返回對象httpResult，相當於顯示相應的結果
        // 狀態碼
        // response.getStatusLine().getStatusCode();
        // 響應體，字符串，如果response.getEntity()為空，下面這個代碼會報錯,所以解析之前要做非空的判斷
        // EntityUtils.toString(response.getEntity(), "UTF-8");
        HttpResult httpResult = null;
        // 解析數據封裝HttpResult
        if (response.getEntity() != null) {
            httpResult = new HttpResult(response.getStatusLine().getStatusCode(),
                    EntityUtils.toString(response.getEntity(), "UTF-8"));
        } else {
            httpResult = new HttpResult(response.getStatusLine().getStatusCode(), "");
        }

        // 返回
        return httpResult;
    }

    public static void main(String[] args) throws Exception {
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", 1219);
        map.put("coin", "kcoin");
        HttpResult result=httpClientUtil.doPost("http://13.112.156.235:81/Api/api/getWalletAddress",map);
//        HttpResult result=httpClientUtil.doPost("http://192.168.0.107/Api/api/getWalletAddress",map);
        System.out.println(result.getBody());
        
//        String url = PropertiesFactory.getPropertiesBean().getBiUrl() + "/api/cost/countWeekOfYear";
//        Map<String, Object> map = new HashMap<>();
//        map.put("customerCodes","360_e7b24");
//        map.put("dataType","P1");
//        HttpResult httpResult = httpClientUtil.doPost(url, map);
//        String body = httpResult.getBody();
//        Map reultMap = JSONUtil.jsonToMap(body);
//        System.out.println(reultMap);
//        System.out.println(reultMap.get("data"));
    }
}
