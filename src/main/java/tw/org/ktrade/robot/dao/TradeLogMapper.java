package tw.org.ktrade.robot.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import tw.org.ktrade.robot.po.TradeLog;

/**
 * @auth ：Sarosh
 * 時間：2018/10/26.
 * 項目名稱 ：ktrade
 * 包名 ：tw.org.ktrade.robot.dao
 * 功能描述 ：紅利
 */
public interface TradeLogMapper{

    List<TradeLog> getTradeLogList(@Param("tradeLog") TradeLog tradeLog);

    int getTradeLogCount(@Param("tradeLog") TradeLog tradeLog);

    BigDecimal getSumdByUserIdAndTradeId(@Param("userId") Integer userId,@Param("tradeId") Integer tradeId);

    List<TradeLog> getMyTradeLogList(@Param("tradeLog") TradeLog tradeLog);
    
    BigDecimal getLastPrice(@Param("market") String market);
    
    BigDecimal getAllFee(@Param("market") String market);
    
    BigDecimal getSingleFee(@Param("market") String market);
    
    BigDecimal getDaySingleFee(@Param("market") String market);
    
}
