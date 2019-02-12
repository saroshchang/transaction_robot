import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class dateFormat {

	public static void main(String[] args) {
		
		int year = 2018;  
		int week = 48;  
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		
		System.out.println("getFirstDayOfWeek = " + sdf.format(getFirstDayOfWeek(year, week-1))); 
		//System.out.println(" time : " + getLastDayOfWeek(2018,48));
		
		String pattern2 = "yyyy-MM-dd HH:mm:ss";

		SimpleDateFormat sdf2 = new SimpleDateFormat(pattern2);

		Integer time = 1510373610;

		//System.out.print(" time : " + time + " = " + sdf2.format(time * 1000L));

	}
	
	// 获取某年的第几周的开始日期  
	 public static Date getFirstDayOfWeek(int year, int week) {  
	  Calendar c = new GregorianCalendar();  
	  c.set(Calendar.YEAR, year);  
	  c.set(Calendar.MONTH, Calendar.JANUARY);  
	  c.set(Calendar.DATE, 1);  
	  
	  Calendar cal = (GregorianCalendar) c.clone();  
	  cal.add(Calendar.DATE, week * 7);  
	  
	  return getFirstDayOfWeek(cal.getTime());  
	 }  
	 
	// 获取当前时间所在周的开始日期  
	 public static Date getFirstDayOfWeek(Date date) {  
	  Calendar c = new GregorianCalendar();  
	  c.setFirstDayOfWeek(Calendar.MONDAY);  
	  c.setTime(date);  
	  c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday  
	  return c.getTime();  
	 }  
}
