package tw.org.ktrade.robot.common;

/**
 * 頁面返回結果
 */
public class ResponseResult {

	/**
	 * 返回狀態, 0:異常; 1:正常
	 */
	private Integer status = 1;

	/**
	 * 返回數據
	 */
	private Object data;

	/**
	 * 錯誤碼
	 * 
	 * @see ResponseErrorCode
	 */
	private Integer errorCode = 0;
	
	/**
	 * 訊息內容
	 */
	private String ResponseErrorMsg;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getResponseErrorMsg() {
		return ResponseErrorMsg;
	}

	public void setResponseErrorMsg(String responseErrorMsg) {
		ResponseErrorMsg = responseErrorMsg;
	}
	
}
