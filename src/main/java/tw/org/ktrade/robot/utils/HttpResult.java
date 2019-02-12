package tw.org.ktrade.robot.utils;

/**
 * Http響應結果集
 * @author jinlin
 * @email jinlin@geotmt.com
 * @date 2017/11/13 13:54
 */
public class HttpResult {

    // 響應的狀態碼
    private int code;
    // 響應的響應體
    private String body;

    public HttpResult(int code, String body) {
        this.code = code;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
