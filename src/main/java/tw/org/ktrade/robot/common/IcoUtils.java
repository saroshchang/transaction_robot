package tw.org.ktrade.robot.common;

import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class IcoUtils {

	/**
	 * 加密
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public String enCode(String userId) throws Exception {
		Base64.Encoder encoder = Base64.getEncoder();
		String text = "mm" + userId;
		byte[] textByte = text.getBytes("UTF-8");
		return encoder.encodeToString(textByte);
	}

	/**
	 * 解密
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public String decoder(String userId) throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		return (new String(decoder.decode(userId), "UTF-8")).substring(2);
	}
}
