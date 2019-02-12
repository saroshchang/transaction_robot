package tw.org.ktrade.robot.dao;


import org.joda.time.DateTime;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.etchain.model.infoormation.MarketInfoDay;
import com.etchain.model.infoormation.MarketInfoMinutes;

import java.util.List;

/**
 * @author ：zhanghua
 * 時間：2017/12/7.
 * 項目名稱 ：ktrade
 * 包名 ：com.etchain.service.api.mongodb
 * 功能描述 ：${DESCRIPTION}
 */
public interface MarketInfoDayRepository<T,ID> extends MongoRepository<MarketInfoDay,Integer> {
    List<MarketInfoDay> findByTypeAndCreateTimeBetween(String type,DateTime beginTime, DateTime endTime);
}
