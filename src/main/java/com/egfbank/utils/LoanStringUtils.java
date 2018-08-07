package com.egfbank.utils;

import org.apache.commons.lang3.StringUtils;

/**
 ** @author lijunshi
 ** @date 2018年4月13日
 **/
public class LoanStringUtils extends StringUtils {

	public static boolean isNotEmpty(String str) {
		if (null == str || str.trim().length() == 0) {
			return false;
		}
		return true;
	}

	public static boolean isEmpty(String str) {
		return !isNotEmpty(str);
	}

}
