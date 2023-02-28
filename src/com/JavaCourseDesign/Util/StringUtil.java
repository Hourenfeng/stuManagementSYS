package com.JavaCourseDesign.Util;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if("".equals(str) || str == null) {   //不判断是否为空容易抛出空指针异常
			return true;
		}
		return false;
	} 
}
