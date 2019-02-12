package tw.org.ktrade.robot.utils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {
    /**
     * 獲取起止日期
     * @param sdf 需要顯示的日期格式
     * @param date 需要參照的日期
     * @param n 最近n周
     * @param option 0 開始日期；1 結束日期
     * @param k 0 包含本周 1 不包含本周
     * @return
     */
    public static String getFromToDate(SimpleDateFormat sdf, Date date, int n, int option, int k) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int offset = 0 == option ? 1 - dayOfWeek : 7 - dayOfWeek;
        int amount = 0 == option ? offset - (n - 1  + k) * 7 : offset - k * 7;
        calendar.add(Calendar.DATE, amount);
        return sdf.format(calendar.getTime());
    }
 
    /**
     * 根據當前日期獲得最近n周的日期區間（包含本周）
     * @param n
     * @param sdf
     * @return
     */
    public static String getThisBeginDate(int n, SimpleDateFormat sdf) {
        String beginDate = getFromToDate(sdf, new Date(), n, 0, 0);
        return beginDate;
    }
    
    /**
     * 根據當前日期獲得最近n周的日期區間（包含本周）
     * @param n
     * @param sdf
     * @return
     */
    public static String getThisEndDate(int n, SimpleDateFormat sdf) {
        String endDate = getFromToDate(sdf, new Date(), n, 1, 0);
        return endDate;
    }
 
    /**
     * 獲取這周開始時間
     * @param n
     * @param sdf
     * @return
     */
    public static String getNextBeginDate(int n, SimpleDateFormat sdf) {
        String beginDate = getFromToDate(sdf, new Date(), n, 0, -1);
        return beginDate;
    }
    
    /**
     * 獲取這周結束時間
     * @param n
     * @param sdf
     * @return
     */
    public static String getNextEndDate(int n, SimpleDateFormat sdf) {
        String endDate = getFromToDate(sdf, new Date(), n, 1, -1);
        return endDate;
    }
 
    /**
     * 根據當前日期獲得本周的日期區間（本周周一和周日日期）
     * @param sdf
     * @return
     */
    public static String getThisBeginDate(SimpleDateFormat sdf) {
        return getThisBeginDate(1, sdf);
    }
    
    /**
     * 根據當前日期獲得本周的日期區間（本周周一和周日日期）
     * @param sdf
     * @return
     */
    public static String getThisEndDate(SimpleDateFormat sdf) {
        return getThisEndDate(1, sdf);
    }
 
    /**
     * 根據當前日期獲得上周的日期區間（上周周一和周日日期）
     * @param sdf
     * @return
     */
    public static String getNextBeginDate(SimpleDateFormat sdf) {
        return getNextBeginDate(1, sdf);
    }
    
    /**
     * 根據當前日期獲得上周的日期區間（上周周一和周日日期）
     * @param sdf
     * @return
     */
    public static String getNextEndDate(SimpleDateFormat sdf) {
        return getNextEndDate(1, sdf);
    }
 
    public static void main(String[] args) {
        System.out.println(getThisBeginDate(new SimpleDateFormat("yyyy-MM-dd 00:00:00"))+
				" ~ "+getThisEndDate(new SimpleDateFormat("yyyy-MM-dd 23:59:59"))); // 獲得本周的日期區間
        System.out.println(getNextBeginDate(new SimpleDateFormat("yyyy-MM-dd 00:00:00"))+
				" ~ "+getNextEndDate(new SimpleDateFormat("yyyy-MM-dd 23:59:59"))); // 獲得本周的日期區間
    }

 // 獲取某年的第幾周的開始日期  
  	 public static Date getFirstDayOfWeek(int year, int week) {  
  	  Calendar c = new GregorianCalendar();  
  	  c.set(Calendar.YEAR, year);  
  	  c.set(Calendar.MONTH, Calendar.JANUARY);  
  	  c.set(Calendar.DATE, 1);  
  	  
  	  Calendar cal = (GregorianCalendar) c.clone();  
  	  cal.add(Calendar.DATE, week * 7);  
  	  
  	  return getFirstDayOfWeek(cal.getTime());  
  	 }  
  	 
  	// 獲取當前時間所在周的開始日期  
  	 public static Date getFirstDayOfWeek(Date date) {  
  	  Calendar c = new GregorianCalendar();  
  	  c.setFirstDayOfWeek(Calendar.MONDAY);  
  	  c.setTime(date);  
  	  c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday  
  	  return c.getTime();  
  	 } 
}
