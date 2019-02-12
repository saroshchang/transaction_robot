package tw.org.ktrade.robot.service;

import org.springframework.stereotype.Service;

@Service
public interface RobotService {
	
	
	/**
	 * 未來幣 對 以太幣
	 */
	void runFtoEth();
	
	/**
	 * 未來幣 對 太達幣
	 */
	void runFtoUsdt();
	
	/**
	 * 未來幣 對 比特幣
	 */
	void runFtoBtc();
	
	/**
	 * nuls幣 對 以太幣
	 */
	void runNulsEth();
	
	/**
	 * nuls幣 對 比特幣
	 */
	void runNulsBtc();
	
	/**
	 * nuls幣 對 以太幣
	 */
	void runNulsUsdt();

	void runXrpTwdt();

	void runNulsTwdt();

	void runHlcTwdt();

	void runBtcTwdt();

	void runEthTwdt();

	void runDashTwdt();

	void runXmrTwdt();

	void runXrpUsdt();

	void runHlcUsdt();

	void runBtcUsdt();

	void runEthUsdt();

	void runDashUsdt();

	void runXmrUsdt();

	/****************************2019/01/19*********************************************************************************************************/
	
	void runXrpBtc();
	
	void runXrpEth();

	void runHlcEth();

	void runHlcBtc();

	void runFtoTwdt();

	void runDashBtc();

	void runDashEth();

	void runXmrBtc();

	void runXmrEth();

	void runEthBtc();

	Object getMarket(String type);
	
	
}
