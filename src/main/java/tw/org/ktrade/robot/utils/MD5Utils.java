package tw.org.ktrade.robot.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具類
 * 
 * @author liuxing
 * @time 2017-9-5 10:05:51
 */
public class MD5Utils {
    
	
	/**
	 * 使用md5進行文本加密
	 * @param plainText
	 * @return
	 */
	public static String md5(String plainText) {
	    if(plainText == null) {
	        return null;
	    }
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
		}
		String md5code = new BigInteger(1, secretBytes).toString(16); //16進制數字
		// 如果生成數字未滿32位，前面補0
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}
	
	/**
     * 使用md5的算法對比加密前後是否相同
     * @param before 加密前
     * @param later 加密後
     * @return
     */
	public static boolean equals(String before, String later) {
	    if(before == null || later == null) {
	        return false;
	    }
	    return StringUtils.equals(md5(before), later);
	}

	public static String getReplace(String phone){
		phone = phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
		return phone;
	}
	public static String getIDNumberReplace(String idCard){
		idCard =idCard.replaceAll("(\\d{4})\\d{10}(\\d{4})","$1****$2");
		return idCard;
	}
}