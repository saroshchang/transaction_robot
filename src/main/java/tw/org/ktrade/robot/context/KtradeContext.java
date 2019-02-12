package tw.org.ktrade.robot.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KtradeContext {
	
	private static Map<String, Object> map = new ConcurrentHashMap<>();

	public static Object getAttribute(String key) {
		return map.get(key);
	}
	
	public static void setAttribute(String key, Object value) {
		if(value == null) {
			map.remove(key);
		}else {
			map.put(key, value);
		}
	}
}
