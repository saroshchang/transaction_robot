package tw.org.ktrade.robot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tw.org.ktrade.robot.po.Market;

/**
 * Created by WNLTW on 2017/12/1.
 */
@Service
public interface MarketService{

    List<Market> queryListByNameLike(String coinName);
}
