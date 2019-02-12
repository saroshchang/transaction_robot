package tw.org.ktrade.robot.dao;

import java.util.List;

import tw.org.ktrade.robot.po.User;



/**
 * Created by WNLTW on 2017/12/1.
 */
public interface UserDao{

    /**
     * 註冊
     * @param user
     */
    void register(User user);

    /**
     * 根據用戶條件查詢用戶信息
     * @param user
     * @return
     */
    List<User> getInfoByParameter(User user);

    /**
     * 更具手機號查詢用戶
     * @param phone
     */
    List<User> findfByPhone(String phone);
    
    /**
     * 根據查詢用戶
     * @param token
     */
    List<User> findfByToken(String token);
    
    
}
