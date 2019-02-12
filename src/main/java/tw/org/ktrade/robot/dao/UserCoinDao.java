package tw.org.ktrade.robot.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import tw.org.ktrade.robot.po.UserCoin;

/**
 * Created by WNLTW on 2017/12/4.
 */
/**
 * @author user
 *
 */
public interface UserCoinDao {

	/**
	 *
	 * @param userAccountName
	 *            交易货币字段名
	 * @param userThawAmount
	 *            交易货币解冻金额
	 * @param userDeductTheAmount
	 *            交易货币扣减金额
	 * @param peerAccountName
	 *            商品货币的字段名
	 * @param peerThawAmount
	 *            商品货币的解冻金额
	 * @param peerDeductTheAmount
	 *            商品货币的金额
	 */
	void updateUserCoinAccount(@Param("userid") Integer userid, @Param("userAccountName") String userAccountName,
			@Param("userThawAmount") BigDecimal userThawAmount,
			@Param("userDeductTheAmount") BigDecimal userDeductTheAmount,
			@Param("peerAccountName") String peerAccountName, @Param("peerThawAmount") BigDecimal peerThawAmount,
			@Param("peerDeductTheAmount") BigDecimal peerDeductTheAmount);

	/**
	 * 挂单时，更新个人资产
	 * 
	 * @param userId
	 * @param coinName
	 * @param freeze
	 */
	void updateUserCoinToTrade(@Param("userId") Integer userId, @Param("coinName") String coinName,
			@Param("freeze") BigDecimal freeze);

	void updatePoundageAccount(@Param("userId") Integer userId, @Param("coinName") String coinName,
			@Param("poundage") BigDecimal poundage);

	/**
	 * 使用kcoin支付手续费的方式
	 * 
	 * @param freeze
	 * @param feeType
	 * @param fee
	 */
	void updateUserCoinToTrade2(@Param("userId") Integer userId, @Param("coinName") String coinName,
			@Param("freeze") BigDecimal freeze, @Param("feeType") String feeType, @Param("fee") BigDecimal fee);

	void updateEntityToTurnIn(@Param("name") String name, @Param("addr") String addr, @Param("num") BigDecimal num);

	void updateEntityToTurnInForPaymentId(@Param("name") String name, @Param("addr") String addr,
			@Param("num") BigDecimal num);

	/**
	 * 通过用户id修改用户coin数量
	 * 
	 * @param userId
	 *            用户id
	 * @param coinName
	 *            币种
	 * @param num
	 *            修改后的数量
	 */
	void updateUserCoinAccountByUserId(@Param("userId") int userId, @Param("coinName") String coinName,
			@Param("num") double num);

	/**
	 * 通过用户id查询指定币数量
	 * 
	 * @return
	 */
	Double getCoinNumByUserId(@Param("userId") int userId, @Param("coinName") String coinName);

	List<UserCoin> getAllUserCoin();

	void addUserKtCoin(@Param("coin") BigDecimal coin,	@Param("userId") int userId);
	
	void addUserBtcCoin(@Param("coin") BigDecimal coin,	@Param("userId") int userId);
	
	void addUserEthCoin(@Param("coin") BigDecimal coin,	@Param("userId") int userId);
	
	void addUserUsdtCoin(@Param("coin") BigDecimal coin,	@Param("userId") int userId);
	
	void addUserTwdtCoin(@Param("coin") BigDecimal coin,	@Param("userId") int userId);
	
}
