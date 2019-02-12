package tw.org.ktrade.robot.service;

import org.springframework.stereotype.Service;

import tw.org.ktrade.robot.po.TradeLog;

@Service
public interface TradeLogService {
   

    /**
     * 刪除所有的客戶
     */
    public void deleteAll();

    /**
     * 保存客戶
     * @param customer 客戶
     */
    public void save(TradeLog tradeLog);
    
    /**
     * 保存客戶
     * @param customer 客戶
     */
    public void insert(TradeLog tradeLog);

    /**
     * 查詢所有客戶列表
     * @return 客戶列表
     */
    public Iterable<TradeLog> findAll() ;

}
