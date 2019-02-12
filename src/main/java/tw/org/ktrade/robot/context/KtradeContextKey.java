package tw.org.ktrade.robot.context;

import org.apache.commons.lang3.ObjectUtils;

public class KtradeContextKey {

    /** 币种列表 */
    public static final String COIN_LIST = ObjectUtils.CONST("COIN_LIST");

    /** 币种名称列表 */
    public static final String COIN_NAME_LIST = ObjectUtils.CONST("COIN_NAME_LIST");

    /** 基础币列表 */
    public static final String BASE_COIN_LIST = ObjectUtils.CONST("BASE_COIN_LIST");

    /** 交易对列表 */
    public static final String MARKET_LIST = ObjectUtils.CONST("MARKET_LIST");

    /** 24小时最高 */
    public static final String KTRADE_HIGH_MAP = ObjectUtils.CONST("KTRADE_HIGH_MAP");

    /** 24小时最低 */
    public static final String KTRADE_LOW_MAP = ObjectUtils.CONST("KTRADE_LOW_MAP");

    /** 24小时涨跌 */
    public static final String KTRADE_CHANGE_MAP = ObjectUtils.CONST("KTRADE_CHANGE_MAP");

    /** 最新成交价 */
    public static final String KTRADE_PRICE_MAP = ObjectUtils.CONST("KTRADE_PRICE_MAP");

    /** 24小时成交量 */
    public static final String KTRADE_COUNT_MAP = ObjectUtils.CONST("KTRADE_COUNT_MAP");
}
