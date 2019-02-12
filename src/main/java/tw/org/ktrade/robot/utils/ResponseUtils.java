package tw.org.ktrade.robot.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import tw.org.ktrade.robot.common.IcoUtils;
import tw.org.ktrade.robot.po.IcoCoin;
import tw.org.ktrade.robot.po.KtrIcoInfo;
import tw.org.ktrade.robot.po.KtrUser;

@Component
public class ResponseUtils {

	@Resource
	IcoUtils icoUtils;
	@Resource
	DateUtil dateUtil;

	/**
	 * RegisterICO Api 回傳 Data
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> returnRegisterICO(KtrUser user) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", icoUtils.enCode(Integer.toString(user.getId())));

		return map;
	}

	/**
	 * LoginICO Api 回傳 Data
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> returnLoginICO(KtrUser user) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		map.put("fristLogin", user.getFirstLogin().toString());
		map.put("useOTP", user.getUseotp().toString());
		map.put("userId", icoUtils.enCode(user.getId().toString()));
		map.put("username", user.getUsername());

		return map;
	}

	/**
	 * LoginICO Api 回傳 Data
	 * 
	 * @param user
	 * @param currency
	 * @param secret
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> returnGetICOGoogleKey(KtrUser user, String currency, String secret) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		map.put("username", user.getUsername());
		map.put("fristLogin", user.getFirstLogin().toString());
		map.put("key", secret);
		map.put("title", "&issuer=" + currency);
		map.put("userId", icoUtils.enCode(user.getId().toString()));
		return map;

	}

	/**
	 * veryfyEmail Api 回傳 Data
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> returnVeryfyEmail(String userId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", "success");
		return map;
	}

	/**
	 * GetICOAddrByCoinName Api 回傳 Data
	 * 
	 * @param map
	 * @param userId
	 * @return
	 */
	public Object returnGetICOGoogleKey(HashMap<Object, Object> map, String userId) {
		map.put("status", "success");
		map.put("userId", userId);
		return map;
	}

	

	/**
	 * CheckICOGoogleValidate Api 回傳 Data
	 * 
	 * @param userId
	 * @return
	 */
	public Object returnCheckICOGoogleValidate(String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", "success");
		map.put("userId", userId);
		return map;
	}

	/**
	 * ForgetPasswordBySendEmail Api 回傳 Data
	 * 
	 * @param userId
	 * @return
	 */
	public Object returnForgetPasswordBySendEmail(String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", "success");
		map.put("userId", userId);
		return map;
	}

	/**
	 * ForgetPasswordVerifyEmail Api 回傳 Data
	 * 
	 * @param userId
	 * @return
	 */
	public Object returnForgetPasswordVerifyEmail(String userId, String status) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", status);
		map.put("userId", userId);
		return map;
	}

	/**
	 * InsertUserData Api 回傳 Data
	 * 
	 * @param userId
	 * @return
	 */
	public Object returnInsertUserData(String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		return map;
	}

	/**
	 * GetHistory Api 回傳 Data
	 * 
	 * @param userId
	 * @param icoCoin
	 * @return
	 */
	public Object returnGetHistory(String userId, List<IcoCoin> icoCoin) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("userId", userId);
		map.put("List", icoCoin);
		map.put("result", "SUCCESS");
		return map;
	}

	/**
	 * UpdateForgetPwd Api 回傳 Data
	 * 
	 * @param userId
	 * @return
	 */
	public Object returnUpdateForgetPwd(String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("result", "SUCCESS");
		return map;
	}

	/**
	 * ProgressBar Api 回傳 Data
	 * 
	 * @param ktrIcoInfo
	 * @return
	 */
	public Object returnProgressBar(KtrIcoInfo ktrIcoInfo) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("icoType", ktrIcoInfo.getIcoType());
		map.put("expectSoftValue", ktrIcoInfo.getExpectSoftValue());
		map.put("expectHardValue", ktrIcoInfo.getExpectHardValue());
		map.put("privateValue", ktrIcoInfo.getPrivateValue());
		map.put("publicValue", ktrIcoInfo.getPublicValue());
		map.put("result", "SUCCESS");
		return map;
	}

	/**
	 * ResetOTPVerifyEmail Api 回傳 Data
	 * 
	 * @param userId
	 * @return
	 */
	public Object resetOTPVerifyEmail(String userId, String status) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", status);
		map.put("userId", userId);
		return map;
	}

	/**
	 * ResetSendKtradeEmail Api 回傳 Data
	 * 
	 * @param userId
	 * @return
	 */
	public Object ResetSendKtradeEmail() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "SUCCESS");
		return map;
	}

	/**
	 * ResetSendKtradeEmail Api 回傳 Data
	 * 
	 * @param userId
	 * @return
	 */
	public Object returnBonusDate(Map<String, String> map) {
		map.put("result", "SUCCESS");
		return map;
	}

	/**
	 * ReturnQueryUserWeekHistory Api 回傳 Data
	 * 
	 * @param map
	 * @return
	 */
	public Object returnQueryUserWeekHistory(List<Map<String, Object>> mapList) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Map> returnInnerMap = new HashMap<String, Map>();
		Map<String, Object> bonusMap = new HashMap<String, Object>();
		List bonusList = new ArrayList<>();
		for (int x = 0; x < mapList.size(); x++) {
			bonusMap = new HashMap<String, Object>();
			for (Object key : mapList.get(x).keySet()) {
				bonusMap.put((String) key, mapList.get(x).get(key));
			}
			bonusList.add(bonusMap);
		}
		returnMap.put("userBonus", bonusList);
		returnMap.put("result", "SUCCESS");
		return returnMap;

	}
	
	/**
	 * ReturnAllEveyCoinBonusShares Api 回傳 Data
	 * 
	 * @param map
	 * @return
	 */
	public Object returnAllEveyCoinBonusShares(List<Map<String, Object>> mapList) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> bonusMap = new HashMap<String, Object>();
		List bonusList = new ArrayList<>();
		//Map<String, Map> returnInnerMap = new HashMap<String, Map>();
		for (int x = 0; x < mapList.size(); x++) {
			bonusMap = new HashMap<String, Object>();
			for (Object key : mapList.get(x).keySet()) {
				bonusMap.put((String) key, mapList.get(x).get(key));
			}
			bonusList.add(bonusMap);
			//returnInnerMap.put((String) userBonusName().get(x), bonusMap);
		}
		returnMap.put("userBonus", bonusList);
		returnMap.put("result", "SUCCESS");
		return returnMap;

	}
	
	

	/**
	 * ReturnQueryBonusFromWeek Api 回傳 Data
	 * 
	 * @param userId
	 * @return
	 */
	public Object returnQueryBonusFromWeek(Map<String, String> map) {
		map.put("result", "SUCCESS");
		return map;
	}

	

	/**
	 * 取使用者紅利名稱
	 * 
	 * @return
	 */
	public List userBonusName() {

		List UserBonusNameList = new ArrayList<>();
		UserBonusNameList.add("lastUserBonus");
		UserBonusNameList.add("thisUserBonus");
		return UserBonusNameList;

	}
	
	/**
	 * ReturnAllBonus Api 回傳 Data
	 * @return result
	 */
	public Object returnAllBonus() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "SUCCESS");
		return map;
	}
	
	/**
	 * ReturnUserBonus Api 回傳 Data
	 * @return result
	 */
	public Object returnUserBonus() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "SUCCESS");
		return map;
	}
	
}
