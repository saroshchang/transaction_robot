package tw.org.ktrade.robot.dao;

import tw.org.ktrade.robot.po.XnbMarket;

public interface XnbMarketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XnbMarket record);

    int insertSelective(XnbMarket record);

    XnbMarket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XnbMarket record);

    int updateByPrimaryKey(XnbMarket record);
}