package tw.org.ktrade.robot.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import tw.org.ktrade.robot.po.TradeLog;

/**
 * @author ：zhanghua
 * 時間：2017/12/5.
 * 項目名稱 ：ktrade
 * 包名 ：com.etchain.service.api.mongodb
 * 功能描述 ：${DESCRIPTION}
 */
public interface TradeLogRepository<T,ID> extends MongoRepository<TradeLog,Integer> {

    TradeLog findBySerialNumber(Long serialNumber);

    TradeLog findById(long serialNumber);

    List<TradeLog> findByMarket(String market);
}
