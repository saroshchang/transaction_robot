package tw.org.ktrade.robot.constant;

/**
 * 錯誤狀態碼Enum
 */
public enum ResponseErrorCode {

	// 公共
	/** 請求參數錯誤 1000 */
	REQUEST_PARAM_ERROR(1000),

	// ip相關
	/** 當前用戶不是IP */
	IP_NOTIP(1001),
	/** 守護自己 */
	IP_FOLLOWSELF_ERROR(1002),
	/** 沒有查詢到ip信息 */
	IP_GET_NULL(1003),
	/** 沒有實名認證 1004 */
	USER_NOT_CONFIRM(1004),
	/** 取錢包地址失敗 1997 */
	GET_WALLET_ADDR_ERR(1997),
	// 用戶相關
	/** 用戶未登錄 2000 */
	USER_NOT_LOGIN(2000),
	/** 綁定郵箱已存在 */
	USER_EMAIL_EXISTS(2001),
	/** 註冊失敗 */
	USER_REGISETERED_FAIL(2002),
	/** 登錄密碼錯誤 2003 */
	USER_LOGINPWD_ERR(2003),
	/** 使用者驗證錯誤 2004 */
	USER_VERIFY_ERR(2004),
	/** Google 儲存私鑰失敗 2006 */
	STORE_GOOGLE_KEY_ERR(2006),
	/** 該用戶未註冊 2005 */
	USER_NOT_REGISETERED(2005),
	/** 存使用者資料錯誤 */
	STORE_USER_DATA_ERR(2007),
	/** EMail尚未驗證 */
	EMAIL_NOT_VERIFY(2008),
	/** 此帳號一個以上用戶 2010 */
	THE_SAME_USER(2010),
	/** 郵箱發送失敗 */
	USER_EMAIL_SENDFAIL(2014),
	/** 綁定郵箱激活地址無效 */
	USER_BANGDINGEMAIL_FAIL(2015),
	/** 用戶沒有充值 */
	USER_ASSETS_EMPTY(2016),
	/** 交易密碼錯誤 2017 */
	USER_TRANPWD_ERR(2017),
	/** 交易時間不充足 */
	USER_TRANPWD_TIME_NOTENNOUGH(2018),
	/** QQ錯誤 */
	USER_QQ_ERR(2019),
	/** 沒有實名認證 */
	USER_CERTIFICATION_NULL(2020),
	/** 交易密碼六位數字 */
	USER_TRANPWD_6ERR(2021),
	/** 用戶名或密碼錯誤 2022 */
	USER_LOGIN_ERROR(2022),
	/** 手機號已註冊 2023 */
	USER_PHONE_EXISTS(2023),
	/** 綁定銀行卡持卡人姓名與實名認證姓名不同 2024 */
	BINDBANK_NAME_ERROR(2024),
	/** 綁定銀行卡持卡人身份證號與實名認證身份證號不同2025 */
	BINDBANK_ID_ERROR(2025),
	/** 身份證號碼 被占用 2026 */
	USER_IDNUMBER_USED(2026),
	/** 手機號碼錯誤 2027 */
	USER_PHONE_ERR(2027),
	/** 密碼和確認密碼不相同 2028 */
	USER_CONFIRM_PWD_ERR(2028),
	/** 交易密碼已經存在 2029 */
	PAY_PWD_EXIST_ERR(2029),
	/** 郵箱驗證碼錯誤 2030 */
	EMAIL_VALIDATE_ERR(2030),
	/** 請設置交易密碼 */
	PAY_PWD_IS_NULL(2031),
	/** 登錄密碼錯誤 2032 */
	LOGIN_PWD_ERROR(2032),
	/** 已經進行了Google驗證 2033 */
	GOOGLE_CHECK_EXISTS(2033),
	/** Google驗證失敗 2034 */
	GOOGLE_CHECK_ERROR(2034),
	/** 沒有進行Google驗證設置 2035 */
	GOOGLE_CHECK_NULL(2035),
	/** 邀請碼不存在 2036 */
	USER_INVIT_ERROR(2036),
	/** 郵箱與郵箱校驗碼不匹配 2037 */
	VALIDATE_CONFIRM_EMAIL_ERROR(2037),
	/** 系統錯誤 2038 */
	SYSTEM_ERROR(2038),

	// 資產相關
	/** 提現額度不足 3001 */
	ASSETS_LIMIT_LESS(3001),
	/** 賬戶余額不足 3002 */
	ASSETS_BALANCE_LESS(3002),
	/** C級用戶提幣資金不能大於等值1個BTC的價格 */
	ASSETS_BALANCE_LESS_OUT_FEE(3003),

	// 短信相關
	/** 錯誤的手機號碼格式 */
	SEND_MESSAGE_BADPHONENUNBWE(4001),
	/** 驗證碼為空 4002 */
	SEND_MESSAGE_NULL(4002),
	/** 短信驗證碼錯誤 4003 */
	SEND_MESSAGE_ERR(4003),
	/** 短信發送失敗 4004 */
	SEND_MESSAGE_FAIL(4004),

	// 圖形驗證碼相關
	/** 圖形驗證碼錯誤 5001 */
	VALIDATE_ERR(5001),
	/** 驗證碼為空 */
	VALIDATE_NULL(5002),

	// 圖片相關上傳錯誤
	/** 圖片為空 */
	IMG_NULL(6001),
	/** 圖片錯誤 */
	IMG_ERR(6002),
	/** 圖片上傳錯誤 */
	PIC_UPLOAD_ERROR(6003),
	/** 上傳文件空 */
	FILE_NULL_ERROR(6004),

	// 商品相關錯誤
	/** 商品數量不能小於3 */
	GOODS_NUM_ERR(7001),
	/** 商品時間大於7200000 */
	GOODS_TIME_ERR(7002),
	/** 商品圖片空 */
	GOODS_PIC_ERROR(7003),
	/** 商品庫存數量非法 * */
	GOODS_NUM_ERROR(7004),
	/** 商品訂單信息異常 7005 */
	GOODS_ORDER_ERROR(7005),
	/** 商品兌換碼異常 */
	GOODS_CODE_ERROR(7006),
	/** 商品兌換碼異常 */
	GOODS_NAME_ERROR(7007),
	/** 商品訂單超時 */
	GOODS_ORDER_TIMEOUT(7008),
	/** 商品訂單已支付 */
	GOODS_ORDER_PAYED(7009),
	/** 商品為空 */
	GOODS_NULL_ERR(7010),
	/** 暫時沒有人購買商品 */
	GOODS_ORDER_EMPTY(7011),

	// 項目相關錯誤
	/** 項目為空 */
	PROJECT_EMPTY(8001),
	/** 獲取項目為空 */
	PROJECT_ERR(8002),
	/** 每個用戶在單個項目的持有時間總量不得超過36萬秒,很抱歉您已經超過了,請重新填寫購買數量 */
	PROJECT_36_ERR(8003),
	/** 項目圖片錯誤 */
	PROJECT_IMG_ERR(8004),
	/** 項目詳情錯誤 */
	PROJECT_DISC_ERR(8005),
	/** 項目勞動時間單價錯誤 */
	PROJECT_PRICE_ERR(8006),
	/** 項目名稱錯誤 */
	PROJECT_NAME_ERR(8007),
	/** 項目失敗錯誤 */
	PROJECT_FAILREASON_EMPTY(8008),
	/** 項目已結束 */
	PROJECT_EDN_ERR(8009),
	/** 項目已成功 */
	PROJECT_SUCCESS_ERR(8010),
	/** 項目已發佈 */
	PROJECT_ALREADY_PRE(8011),

	// 媒體類型錯誤
	/** 媒體類型錯誤 */
	ISSUANCE_TYPE_ERROR(9000),

	// 小店相關
	/** 小店為空 */
	STORE_NULL_ERROR(10001),

	// ipt相關
	/** ipt余額不足 */
	IPTIME_BALANCE_LESS(11001),

	/** 用戶可用時間不足 */
	USER_TIME_NUM_ERROR(12001),

	/** 市場信息錯誤 */
	MARKET_INFO_ERROR(13001),
	/** 買賣交易價格不合理 */
	TRADE_PRICE_ERROR(13002),
	/** 買賣交易數量不合理 */
	TRADE_NUM_ERROR(13003),

	/** 用戶資產異常 */
	USER_COIN_ERROR(14001),
	/** 用戶資產不足 */
	USER_COIN_LESS(14002),
	/** 用戶地址異常 */
	USER_COIN_ADDR_ERR(14003),

	/** 該用戶不允許交易 */
	USER_CANT_TRADE(15001),
	/** 該用戶不允許轉入 */
	USER_CANT_TURN_INTO(15002),
	/** 該用戶不允許轉出 */
	USER_CANT_TURN_OUT(15003);

	private Integer code;

	private ResponseErrorCode(int code) {
		this.code = code;
	}

	public Integer getCode() {
		return this.code;
	}

}
