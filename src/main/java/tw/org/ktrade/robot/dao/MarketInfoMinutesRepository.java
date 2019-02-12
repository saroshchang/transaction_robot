package tw.org.ktrade.robot.dao;


import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.etchain.model.infoormation.MarketInfoMinutes;



/**
 * @author ：zhanghua
 * 時間：2017/12/7.
 * 項目名稱 ：ktrade
 * 包名 ：com.etchain.service.api.mongodb
 * 功能描述 ：${DESCRIPTION}
 */
public interface MarketInfoMinutesRepository<T,ID> extends MongoRepository<MarketInfoMinutes,Integer> {
    List<MarketInfoMinutes> findByTypeAndCreateTimeBetween(String type,DateTime beginTime, DateTime endTime);
}
