package com.junmeng.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by HWJ on 2017/3/29.
 */
public class DateUtil {
    /**
     * 获得当前日期的前后n那天
     * @param n n为正表示后|n|天，负表示前|n|天
     * @return
     */
    public static Date getDate(int n) // //获取前后日期 i为正数 向后推迟i天，负数时向前提前i天
    {
        Date date = null;
        Calendar cd = Calendar.getInstance();
        cd.add(Calendar.DATE, n);
        date = cd.getTime();
        //SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Timestamp date = Timestamp.valueOf(dformat.format(dat));
        return date;
    }

}
