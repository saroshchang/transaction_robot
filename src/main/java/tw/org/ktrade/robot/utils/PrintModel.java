package tw.org.ktrade.robot.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

@Component
public class PrintModel {

	/**
	 * 輸出整個model所有參數
	 * 
	 * @param model
	 */
	public static void print(Object model) {
		Class cls = model.getClass();
		Field[] fields = cls.getDeclaredFields();
		System.out.println("###################### " + model.getClass().getName() + " ####################");
		for (Field field : fields) {
			char[] buffer = field.getName().toCharArray();
			buffer[0] = Character.toUpperCase(buffer[0]);
			String mothodName = "get" + new String(buffer);
			try {
				Method method = cls.getDeclaredMethod(mothodName);
				Object resutl = method.invoke(model, null);
				System.out.println(field.getName() + ": " + resutl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("###################### End ####################");
	}

}
