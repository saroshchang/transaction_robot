package com.etchain.model.infoormation;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：zhanghua
 * 時間：2017/12/5.
 * 項目名稱 ：ktrade
 * 包名 ：com.etchain.utils
 * 功能描述 ：${DESCRIPTION}
 */
public class MarketInfoUtils {
    /**
     * 獲取行情時間
     * @param type
     * @param date
     * @return
     */
    public static String getMarketInfoTime(Integer type, Date date){
        String verifyTimeSdf = null;
        switch (type){
            case 1:
                verifyTimeSdf = "yyyyMMddHHmmss";
                break;
            case 2:
                verifyTimeSdf = "yyyyMMddHHmm";
                break;
            case 3:
                verifyTimeSdf = "yyyyMMddHH";
                break;
            case 4:
                verifyTimeSdf = "yyyyMMdd";
                break;
            case 5:
                verifyTimeSdf = "yyyyMM";
                break;
            case 6:
                verifyTimeSdf = "yyyy";
                break;
            default:
                verifyTimeSdf = "yyyyMMddHHmmss";
                break;
        }
        return new SimpleDateFormat(verifyTimeSdf).format(date);
    }

}
