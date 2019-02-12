package tw.org.ktrade.robot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import tw.org.ktrade.robot.po.RobotTrade;

/**
 * @author ：zhanghua
 * 時間：2017/12/7.
 * 項目名稱 ：ktrade
 * 包名 ：com.etchain.service.api.mongodb
 * 功能描述 ：${DESCRIPTION}
 */
public interface RobotTradeDao {
    
	
    int getMyTradeCountByStatus(@Param("trade") RobotTrade trade,@Param("map") Map<String, Object> map);

    <T> void updateTradeNum(T trade);
}
