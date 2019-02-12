package tw.org.ktrade.robot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.ktrade.robot.dao.MarketDao;
import tw.org.ktrade.robot.po.Market;
import tw.org.ktrade.robot.service.MarketService;

@Service
public class MarketServiceImpl implements MarketService{
    
	@Autowired MarketDao marketDao;
	
	
	@Override
	public List<Market> queryListByNameLike(String coinName) {
		return marketDao.queryListByNameLike(coinName);
	}

}
