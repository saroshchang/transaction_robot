
import java.util.Base64;

public class enCoder {

	public static void main(String[] args) throws Exception {

		String enCode = enCode("393");
		System.out.println("加密 = " + enCode);

		String decoder = decoder("bW00NTc=");
		System.out.println("解密 = " + decoder);
	}

	/**
	 * 加密
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public static String enCode(String userId) throws Exception {
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
	public static String decoder(String userId) throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		return (new String(decoder.decode(userId), "UTF-8")).substring(2);
	}

}
