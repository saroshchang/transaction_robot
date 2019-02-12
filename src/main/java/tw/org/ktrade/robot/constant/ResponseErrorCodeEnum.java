package tw.org.ktrade.robot.constant;

/***
 * 用户是否存在
 * 
 * @author zhufei
 *
 */
public enum ResponseErrorCodeEnum {

	/** 请求参数错误 1000 */
	REQUEST_PARAM_ERROR(1000, "请求参数错误"),

	// ip相关
	/** 当前用户不是IP */
	IP_NOTIP(1001, "当前用户不是IP"),
	/** 守护自己 */
	IP_FOLLOWSELF_ERROR(1002, "守护自己"),
	/** 没有查询到ip信息 */
	IP_GET_NULL(1003, "没有查询到ip信息"),
	/** 没有实名认证 1004 */
	USER_NOT_CONFIRM(1004, "没有实名认证"),

	// 用户相关
	/** 用户未登录 2000 */
	USER_NOT_LOGIN(2000, "用户未登录"),
	/** 绑定邮箱已存在 */
	USER_EMAIL_EXISTS(2001, "绑定邮箱已存在"),
	/** 注册失败 */
	USER_REGISETERED_FAIL(2002, "注册失败"),
	/** 登录密码错误 2003 */
	USER_LOGINPWD_ERR(2003, "登录密码错误"),
	/** 该用户未注册 2005 */
	USER_NOT_REGISETERED(2005, "该用户未注册"),
	/** 邮箱发送失败 */
	USER_EMAIL_SENDFAIL(2014, "邮箱发送失败"),
	/** 绑定邮箱激活地址无效 */
	USER_BANGDINGEMAIL_FAIL(2015, "绑定邮箱激活地址无效"),
	/** 用户没有充值 */
	USER_ASSETS_EMPTY(2016, "用户没有充值"),
	/** 交易密码错误 2017 */
	USER_TRANPWD_ERR(2017, "交易密码错误"),
	/** 交易时间不充足 */
	USER_TRANPWD_TIME_NOTENNOUGH(2018, "交易时间不充足"),
	/** QQ错误 */
	USER_QQ_ERR(2019, "QQ错误"),
	/** 没有实名认证 */
	USER_CERTIFICATION_NULL(2020, "没有实名认证"),
	/** 交易密码六位数字 */
	USER_TRANPWD_6ERR(2021, "交易密码六位数字"),
	/** 用户名或密码错误 2022 */
	USER_LOGIN_ERROR(2022, "用户名或密码错误"),
	/** 手机号已注册 2023 */
	USER_PHONE_EXISTS(2023, "手机号已注册"),
	/** 绑定银行卡持卡人姓名与实名认证姓名不同 2024 */
	BINDBANK_NAME_ERROR(2024, "绑定银行卡持卡人姓名与实名认证姓名不同 "),
	/** 绑定银行卡持卡人身份证号与实名认证身份证号不同2025 */
	BINDBANK_ID_ERROR(2025, "绑定银行卡持卡人身份证号与实名认证身份证号不同"),
	/** 身份证号码 被占用 2026 */
	USER_IDNUMBER_USED(2026, "身份证号码 被占用 "),
	/** 手机号码错误 2027 */
	USER_PHONE_ERR(2027, "手机号码错误"),
	/** 密码和确认密码不相同 2028 */
	USER_CONFIRM_PWD_ERR(2028, "密码和确认密码不相同"),
	/** 交易密码已经存在 2029 */
	PAY_PWD_EXIST_ERR(2029, "交易密码已经存在"),
	/** 邮箱验证码错误 2030 */
	EMAIL_VALIDATE_ERR(2030, "邮箱验证码错误"),
	/** 请设置交易密码 */
	PAY_PWD_IS_NULL(2031, "请设置交易密码"),
	/** 登录密码错误 2032 */
	LOGIN_PWD_ERROR(2032, "登录密码错误"),
	/** 已经进行了Google验证 2033 */
	GOOGLE_CHECK_EXISTS(2033, "已经进行了Google验证"),
	/** Google验证失败 2034 */
	GOOGLE_CHECK_ERROR(2034, "Google验证失败"),
	/** 没有进行Google验证设置 2035 */
	GOOGLE_CHECK_NULL(2035, "没有进行Google验证设置"),
	/** 邀请码不存在 2036 */
	USER_INVIT_ERROR(2036, "邀请码不存在"),

	// 资产相关
	/** 提现额度不足 3001 */
	ASSETS_LIMIT_LESS(3001, "提现额度不足"),
	/** 账户余额不足 3002 */
	ASSETS_BALANCE_LESS(3002, "账户余额不足"),

	// 短信相关
	/** 错误的手机号码格式 */
	SEND_MESSAGE_BADPHONENUNBWE(4001, "错误的手机号码格式"),
	/** 验证码为空 4002 */
	SEND_MESSAGE_NULL(4002, "验证码为空"),
	/** 短信验证码错误 4003 */
	SEND_MESSAGE_ERR(4003, "短信验证码错误"),
	/** 短信发送失败 4004 */
	SEND_MESSAGE_FAIL(4004, "短信发送失败"),

	// 图形验证码相关
	/** 图形验证码错误 5001 */
	VALIDATE_ERR(5001, "图形验证码错误"),
	/** 验证码为空 */
	VALIDATE_NULL(5002, "验证码为空"),

	// 图片相关上传错误
	/** 图片为空 */
	IMG_NULL(6001, "图片为空"),
	/** 图片错误 */
	IMG_ERR(6002, "图片错误"),
	/** 图片上传错误 */
	PIC_UPLOAD_ERROR(6003, "图片上传错误"),
	/** 上传文件空 */
	FILE_NULL_ERROR(6004, "上传文件空"),

	// 商品相关错误
	/** 商品数量不能小于3 */
	GOODS_NUM_ERR(7001, "商品数量不能小于3"),
	/** 商品时间大于7200000 */
	GOODS_TIME_ERR(7002, " 商品时间大于"),
	/** 商品图片空 */
	GOODS_PIC_ERROR(7003, "商品图片空"),
	/** 商品库存数量非法 * */
	GOODS_NUM_ERROR(7004, "商品库存数量非法"),
	/** 商品订单信息异常 7005 */
	GOODS_ORDER_ERROR(7005, "商品订单信息异常"),
	/** 商品兑换码异常 */
	GOODS_CODE_ERROR(7006, "商品兑换码异常"),
	/** 商品兑换码异常 */
	GOODS_NAME_ERROR(7007, "商品兑换码异常"),
	/** 商品订单超时 */
	GOODS_ORDER_TIMEOUT(7008, "商品订单超时"),
	/** 商品订单已支付 */
	GOODS_ORDER_PAYED(7009, "商品订单已支付"),
	/** 商品为空 */
	GOODS_NULL_ERR(7010, "商品为空"),
	/** 暂时没有人购买商品 */
	GOODS_ORDER_EMPTY(7011, "暂时没有人购买商品"),

	// 项目相关错误
	/** 项目为空 */
	PROJECT_EMPTY(8001, "项目为空"),
	/** 获取项目为空 */
	PROJECT_ERR(8002, "获取项目为空"),
	/** 每个用户在单个项目的持有时间总量不得超过36万秒,很抱歉您已经超过了,请重新填写购买数量 */
	PROJECT_36_ERR(8003, "每个用户在单个项目的持有时间总量不得超过36万秒,很抱歉您已经超过了,请重新填写购买数量"),
	/** 项目图片错误 */
	PROJECT_IMG_ERR(8004, "项目图片错误"),
	/** 项目详情错误 */
	PROJECT_DISC_ERR(8005, "项目详情错误"),
	/** 项目劳动时间单价错误 */
	PROJECT_PRICE_ERR(8006, "项目劳动时间单价错误"),
	/** 项目名称错误 */
	PROJECT_NAME_ERR(8007, "项目名称错误"),
	/** 项目失败错误 */
	PROJECT_FAILREASON_EMPTY(8008, "项目失败错误"),
	/** 项目已结束 */
	PROJECT_EDN_ERR(8009, "项目已结束"),
	/** 项目已成功 */
	PROJECT_SUCCESS_ERR(8010, "项目已成功"),
	/** 项目已發佈 */
	PROJECT_ALREADY_PRE(8011, "项目已發佈"),

	// 媒体类型错误
	/** 媒体类型错误 */
	ISSUANCE_TYPE_ERROR(9000, "媒体类型错误"),

	// 小店相关
	/** 小店为空 */
	STORE_NULL_ERROR(10001, "小店为空"),

	// ipt相关
	/** ipt余额不足 */
	IPTIME_BALANCE_LESS(11001, "ipt余额不足"),

	/** 用户可用时间不足 */
	USER_TIME_NUM_ERROR(12001, "用户可用时间不足"),

	/** 市场信息错误 */
	MARKET_INFO_ERROR(13001, "市场信息错误"),
	/** 买卖交易价格不合理 */
	TRADE_PRICE_ERROR(13002, "买卖交易价格不合理"),
	/** 买卖交易数量不合理 */
	TRADE_NUM_ERROR(13003, "买卖交易数量不合理"),

	/** 用户资产异常 */
	USER_COIN_ERROR(14001, "用户资产异常"),
	/** 用户资产不足 */
	USER_COIN_LESS(14002, "用户资产不足"),
	/** 用户地址异常 */
	USER_COIN_ADDR_ERR(14003, "用户地址异常"),

	/** 该用户不允许交易 */
	USER_CANT_TRADE(15001, "该用户不允许交易"),
	/** 该用户不允许转入 */
	USER_CANT_TURN_INTO(15002, "该用户不允许转入"),
	/** 该用户不允许转出 */
	USER_CANT_TURN_OUT(15003, "该用户不允许转出");

	/** 状态代码 */
	private final Integer code;
	/** 状态代码含义描述 */
	private final String desc;

	private ResponseErrorCodeEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static ResponseErrorCodeEnum of(Integer code) {
		ResponseErrorCodeEnum status[] = ResponseErrorCodeEnum.values();
		for (ResponseErrorCodeEnum statu : status) {
			if (statu.code.equals(code)) {
				return statu;
			}
		}
		return null;
	}
}
