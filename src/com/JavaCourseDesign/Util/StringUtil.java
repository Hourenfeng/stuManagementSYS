package com.JavaCourseDesign.Util;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if("".equals(str) || str == null) {   //���ж��Ƿ�Ϊ�������׳���ָ���쳣
			return true;
		}
		return false;
	} 
}
