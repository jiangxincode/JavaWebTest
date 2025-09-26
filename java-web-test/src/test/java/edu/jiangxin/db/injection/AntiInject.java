package edu.jiangxin.db.injection;

import java.util.regex.Pattern;

public class AntiInject {

	/**
	 * 过滤 ‘ 过滤 ORACLE注释 关键字过滤 update ,delete
	 */
	static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
			+ "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";

	static Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);

	/**
	 * 参数校验.
	 *
	 * @param param
	 */
	public static boolean isValid(String param) {

		if (sqlPattern.matcher(param).find()) {

			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValid("3 and 1=1"));
	}

}
