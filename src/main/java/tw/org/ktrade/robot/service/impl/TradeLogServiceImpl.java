
package tw.org.ktrade.robot.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tw.org.ktrade.robot.dao.TradeLogRepository;
import tw.org.ktrade.robot.po.TradeLog;
import tw.org.ktrade.robot.service.TradeLogService;

@Service
public class TradeLogServiceImpl implements TradeLogService {
    @Resource
    private TradeLogRepository repository;

    /**
     * 刪除所有的客戶
     */
    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * 保存客戶
     * @param customer 客戶
     */
    public void save(TradeLog tradeLog) {
    	
    	repository.save(tradeLog);
    }
    
    /**
     * 保存客戶
     * @param customer 客戶
     */
    public void insert(TradeLog tradeLog) {
        repository.insert(tradeLog);
    }

    /**
     * 查詢所有客戶列表
     * @return 客戶列表
     */
    public Iterable<TradeLog> findAll() {
        return repository.findAll();
    }


}
