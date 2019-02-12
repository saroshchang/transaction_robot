package tw.org.ktrade.robot.constant;

/**
 * 常量類
 * 
 * @author liuxing
 * @time 2017-9-5 10:34:59
 *
 */
public class Constant {
    
    /** Session中存取用戶ID鍵常量 */
    public static final String SESSION_USER_ID = "SESSION_USER_ID";

    /** Session中存取IP id鍵常量 */
    public static final String SESSION_IP_ID = "SESSION_IP_ID";

    /** Session中存取PROJECT id鍵常量 */
    public static final String SESSION_PROJECT_ID = "SESSION_PROJECT_ID";

    /** Session中存取短信驗證信息鍵常量 */
    public static final String SESSION_PHONE_VALIDATE = "SESSION_PHONE_VALIDATE";
    
    /** Session中存取添加手機短信驗證信息鍵常量 */
    public static final String SESSION_ADD_PHONE_VALIDATE = "SESSION_ADD_PHONE_VALIDATE";
    
    /** Session中存取短信驗證信息手機號鍵常量 */
    public static final String SESSION_PHONE = "SESSION_PHONE";
    
    /** Session存取圖形驗證碼鍵常量 */
    public static final String SESSION_VALIDATE = "SESSION_VALIDATE";

    /** Session郵箱常量 */
    public static final String SESSION_EMAIL = "SESSION_EMAIL";
    
    /** Session郵箱註冊驗證碼 */
    public static final String SESSION_EMAIL_REGIST_CODE = "SESSION_EMAIL_REGIST_CODE";
    
    /** Session存取綁定郵箱短信驗證碼常量 */
    public static final String SESSION_BINDEMAIL_CODE = "SESSION_BINDEMAIL_CODE";

    /** Session註冊短信驗證碼常量 */
    public static final String SESSION_REGISTER_CODE = "SESSION_REGISTER_CODE";
    /** Session註冊手機號常量 */
    public static final String SESSION_REGISTER_PHONE = "SESSION_REGISTER_PHONE";

    /** Session註冊短信驗證碼常量 */
    public static final String SESSION_UPDATE_CODE = "SESSION_UPDATE_CODE";
    /**
     *
     */
    public static final String SESSION_UPDATE_CODE1= "SESSION_UPDATE_CODE1";

    /** Session存取提現短信驗證碼常量 */
    public static final String SESSION_WITHDRAW_CODE= "SESSION_WITHDRAW_CODE";

    /** Session存取修改登錄密碼短信驗證碼 */
    public static final String SESSION_UPDATE_LOGINPWD_CODE = "SESSION_UPDATE_LOGINPWD_CODE";
    
    /** Session存取重置登錄密碼短信驗證碼 */
    public static final String SESSION_RESET_LOGINPWD_CODE = "SESSION_RESET_LOGINPWD_CODE";
    
    /** Session存取重置登錄密碼手機號 */
    public static final String SESSION_RESET_LOGINPWD_PHONE = "SESSION_RESET_LOGINPWD_PHONE";

    /** Session存取修改交易密碼短信驗證碼 */
    public static final String SESSION_UPDATE_TRAPWD_CODE = "SESSION_UPDATE_TRAPWD_CODE";
    
    /** Session存取重置交易密碼短信驗證碼 */
    public static final String SESSION_RESET_TRAPWD_CODE = "SESSION_RESET_TRAPWD_CODE";
    
    /** Session存取修改手機短信驗證碼,舊手機 */
    public static final String SESSION_RESET_TRAPWD_OLDCODE = "SESSION_RESET_TRAPWD_OLDCODE";
    
    /** Session存取修改手機短信驗證碼 ,新手機*/
    public static final String SESSION_UPDATE_PHONE_NEWCODE = "SESSION_UPDATE_PHONE_NEWCODE";
    
    /** Session存取修改手機手機號*/
    public static final String SESSION_UPDATE_PHONE_NEWPHONE = "SESSION_UPDATE_PHONE_NEWPHONE";
    
    /** Session存取修改手機舊手機驗證標記*/
    public static final String SESSION_UPDATE_PHONE_OLDFLAG = "SESSION_UPDATE_PHONE_OLDFLAG";

    /** Session存取發送郵件驗證碼常量*/
    public static final String SESSION_SEND_MAIL_CODE = "SESSION_SEND_MAIL_CODE";

    /** Session存取交易密碼輸入設置類型（1、2、3）常量*/
    public static final String SESSION_TRADE_BOTH_PROTECT = "SESSION_TRADE_BOTH_PROTECT";

    /** Session存取轉幣郵箱驗證碼常量*/
    public static final String SESSION_TRANSFER_MAIL_CODE = "SESSION_TRANSFER_MAIL_CODE";
    
    /** Session存取google校驗的key*/
    public static final String SESSION_GOOGLE_KEY = "SESSION_GOOGLE_KEY";
    /** Session存取邀請人的userid */
    public static final String SESSION_INVIT_USER_ID = "SESSION_INVIT_USER_ID";
    
    /** ktradeContext中存儲公告的鍵 */
    public static final String CONTEXT_ARTICLE_KEY = "CONTEXT_ARTICLE_KEY";
    /** ktradeContext中存儲比特幣人民幣價值的鍵 */
    public static final String BTC_CNY = "BTC_CNY";
    /** ktradeContext中存儲比特幣臺幣價值的鍵 */
    public static final String BTC_TWD = "BTC_TWD";

//    /** 幣種名稱常量 */
//    public static final String[] COINNAMES = new String[CoinNameEnum.values().length];
//    static {
//        CoinNameEnum[] coinNameEnums = CoinNameEnum.values();
//        for (int i = 0; i < coinNameEnums.length; i++) {
//            COINNAMES[i] = coinNameEnums[i].toString();
//        }
//    }
    
    /** 交易頁掛單簿，顯示掛單條數 */
    public static final int NEW_TRADE_SHOW_COUNT = 10;
    /**
     * 操作信息
     *
     * @author huanggaoren
     *
     */
    public class Message {
        /**
         * 保存成功
         */
        public static final String SUCCESS_SAVE = "global.success.save";

        /**
         * 保存失敗
         */
        public static final String FAILED_SAVE = "global.failed.save";

        /**
         * 更新成功
         */
        public static final String SUCCESS_UPDATE = "global.success.update";

        /**
         * 更新失敗
         */
        public static final String FAILED_UPDATE = "global.failed.update";


        /**
         * 激活成功
         */
        public static final String SUCCESS_ACTIVATE = "global.success.activate";

        /**
         * 激活失敗
         */
        public static final String FAILED_ACTIVATE = "global.failed.activate";



        /**
         * 刪除成功
         */
        public static final String SUCCESS_DELETE = "global.success.delete";

        /**
         * 刪除失敗
         */
        public static final String FAILED_DELETE = "global.failed.delete";
    }
    public class GoogleMessge{

        public static final String SITE_SECRET = "6LdCvj0UAAAAAChf_gJgymL_N_Y2IPlL7bIfEUVK";
        public static final String SECRET_PARAM = "secret";
        public static final String RESPONSE_PARAM = "response";
        public static final String G_RECAPTCHA_RESPONSE = "g-recaptcha-response";
        public static final String SITE_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";
        public static final String SITE_KEY = "6LesAz4UAAAAAA7NMRdAVJHurhQ30XNsMYPAwqRK";

    }

    /**
     * 邏輯
     *
     * @author huanggaoren
     *
     */
    public class State {
        /**
         * FALSE
         */
        public static final boolean FALSE = false;

        /**
         * TRUE
         */
        public static final  boolean TRUE = true;
    }
}
