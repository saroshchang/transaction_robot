package tw.org.ktrade.robot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tw.org.ktrade.robot.po.Market;

/**
 * Created by WNLTW on 2017/12/4.
 */
public interface MarketDao{

    List<Market> getInfoByParameter(Market market);

    List<Market> queryListByNameLike(@Param("coinName")String coinName);
    
    List<Market> queryMarketList();
    
}
