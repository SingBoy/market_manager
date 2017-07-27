package com.sigal.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {

	public static final String FORMAT_DATETIME = "yyyy-MM-dd HH";
	
	public static final String FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static final String FORMAT_DATETIME_YYYY_MM_DD = "yyyy-MM-dd";
	
	public static SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATETIME);
	
	public static SimpleDateFormat sdf1 = new SimpleDateFormat(FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS);
	
	public static final String FORMAT_DATE = "yyyyMMdd";
	
	public static SimpleDateFormat sdf2 = new SimpleDateFormat(FORMAT_DATE);

	public static SimpleDateFormat sdf3 = new SimpleDateFormat(FORMAT_DATETIME_YYYY_MM_DD);
	
	public static Date parseDateTime(String str) {
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static Date parseDateTime1(String str) {
		Date date = null;
		try {
			date = sdf1.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date parseStringToDate(String str) {
		Date date = null;
		try {
			date = sdf3.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String formatDateTime(Date date) {
		return sdf.format(date);
	}
	public static String formatDate(Date date) {
		return sdf2.format(date);
	}
	public static String formatDateToString(Date date) {
		return sdf3.format(date);
	}
	public static String formatDateTimeAll(Date date) {
		return sdf1.format(date);
	}
	
	public static boolean compareCurrentDate(Date on, Date off) {
		SimpleDateFormat sdfint = new SimpleDateFormat("yyyyMMddHH");
		int current = Integer.parseInt(sdfint.format(new Date()));
		int online = Integer.parseInt(sdfint.format(on));
		int offline = Integer.parseInt(sdfint.format(off));
		if (current >= online && current <= offline) {
			return true;
		}
		return false;
	}
	
	public static int getHour(Date date) {
		SimpleDateFormat sdfhour = new SimpleDateFormat("HH");
		return Integer.parseInt(sdfhour.format(date));
	}
	
	public static Date getYesterday() {
		Calendar cal = Calendar.getInstance();
		cal.add(5, -1);
		Date time = null;
		try {
			time = sdf3.parse(sdf3.format(cal.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}
	public static Date getYesterdayByDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(5, -1);
		Date time = null;
		try {
			time = sdf3.parse(sdf3.format(cal.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	 /** 
     * 两个时间相差距离多少天多少小时多少分多少秒 
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00 
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00 
     * @return long[] 返回值为：{天, 时, 分, 秒} 
     */  
    public static Map<String,Long> getDistanceTimes(Date one,Date two) {  
       /* DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date one;  
        Date two; */ 
    	Map<String,Long> map = new HashMap<String,Long>();
        long day = 0;  
        long hour = 0;  
        long min = 0;  
        long sec = 0;  
        try {  
          /*  one = df.parse(str1);  
            two = df.parse(str2);*/  
            long time1 = one.getTime();  
            long time2 = two.getTime();  
            long diff ;  
            if(time1<time2) {  
                diff = time2 - time1;  
            } else {  
                diff = time1 - time2;  
            }  
            day = diff / (24 * 60 * 60 * 1000);  
            hour = (diff / (60 * 60 * 1000) - day * 24);  
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);  
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        map.put("day", day);
        map.put("hour", hour);
        map.put("min", min);
        map.put("sec", sec);
        //long[] times = {day, hour, min, sec};  
        return map;  
    } 
    /**
     * json带T的日期转为正常日期
     * yyyy-MM-ddTHH:mm:ss.xxx ----yyyy-MM-dd HH:mm:ss
     * @param dateStr
     * @return
     */
    public static Date jsonDateToDate(String dateStr){
    	Date date = null;
    	if(!StringUtils.isEmpty(dateStr)){
    		String day = dateStr.substring(0,10);
    		String time = dateStr.substring(11,19);
    		String dayTime = day+" "+time;
        	try {
				date= sdf1.parse(dayTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	return date;
    }

	public static String getUTCTimeStr() {
		StringBuffer UTCTimeBuffer = new StringBuffer();
		// 1、取得本地时间：
		Calendar cal = Calendar.getInstance() ;
		// 2、取得时间偏移量：
		int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		// 3、取得夏令时差：
		int dstOffset = cal.get(Calendar.DST_OFFSET);
		// 4、从本地时间里扣除这些差量，即可以取得UTC时间：
		cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		/*int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);*/
		UTCTimeBuffer.append(year).append("-").append(month).append("-").append(day) ;
		//UTCTimeBuffer.append(" ").append(hour).append(":").append(minute) ;
		try{
			sdf3.parse(UTCTimeBuffer.toString()) ;
			return UTCTimeBuffer.toString() ;
		}catch(ParseException e)
		{
			e.printStackTrace() ;
		}
		return null ;
	}
	/**
	 * 获取更改时区后的日期
	 * @param date 日期
	 * @param oldZone 旧时区对象
	 * @param newZone 新时区对象
	 * @return 日期
	 */
	public static String changeTimeZone(Date date, TimeZone oldZone, TimeZone newZone) {
		Date dateTmp = null;
		String strTimezoneTime = "";
		if (date != null) {
			int timeOffset = oldZone.getRawOffset() - newZone.getRawOffset();
			dateTmp = new Date(date.getTime() - timeOffset);
			strTimezoneTime = formatDateTimeAll(dateTmp);
		}
		return strTimezoneTime;
	}

	public static String dateAddOne(String strDate){
		Date date = null;
		Calendar   calendar   =   new   GregorianCalendar();
		calendar.setTime(DateUtils.parseDateTime1(strDate));
		calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
		date=calendar.getTime();   //这个时间就是日期往后推一天的结果
		return DateUtils.formatDateTimeAll(date);
	}

	public static Date dateSubtracOneHour(Date strDate){
		Date date = null;
		long curren = System.currentTimeMillis();
		curren -= 60 * 60 * 1000;
		Date da = new Date(curren);
		return da;
	}


	public static Date CTStoDate(Date ctsTime){
		Date date = null;
		if(ctsTime!=null){
			SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				String datestr = sf2.format(ctsTime);
				date = java.sql.Date.valueOf(datestr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	public static void main(String[] args) {
		Date date = null;
		long curren = System.currentTimeMillis();
		curren -= 60 * 60 * 1000;
		Date da = new Date(curren);
	}
}
