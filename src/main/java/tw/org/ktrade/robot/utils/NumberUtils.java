package tw.org.ktrade.robot.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class NumberUtils {

	/**
	 * 獲取指定長度的long型字符串,高位截取,不足補0
	 * 
	 * @param src
	 *            原數
	 * @param length
	 *            長度
	 * @return
	 */
	public static String getLengthLong(long src, int length) {
		String s = new Long(src).toString();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append("0");
		}
		return sb.append(s).substring(sb.length() - length, sb.length());
	}

	public static boolean isNumeric00(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("異常：\"" + str + "\"不是數字/整數...");
			return false;
		}
	}

	/**
	 * 產生n位隨機數
	 * 
	 * @return
	 */
	public static long generateRandomNumber(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("隨機數位數必須大於0");
		}
		return (long) (Math.random() * 9 * Math.pow(10, n - 1)) + (long) Math.pow(10, n - 1);
	}

	public static String getRandomString(int length) { // length表示生成字符串的長度
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

}
