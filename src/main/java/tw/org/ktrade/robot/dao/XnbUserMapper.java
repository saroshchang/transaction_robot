package tw.org.ktrade.robot.dao;

import java.util.List;

import tw.org.ktrade.robot.po.XnbUser;

public interface XnbUserMapper {
    int insert(XnbUser record);

    int insertSelective(XnbUser record);
    
    List<XnbUser> getAllUserList();
}