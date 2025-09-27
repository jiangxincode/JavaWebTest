package edu.jiangxin.replace;

public class ConfigAS {
	
	
	public static String getVariableAfterReplaced(String value) {
		
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int end = 0;
		
		for(int i=0;i<value.length();i++) {
			if(value.charAt(i) == '$') {
				i++;
				if((i < value.length()) && (value.charAt(i) != '{')) {
					i--;
					sb.append(value.charAt(i));
					continue;
				}
				if(value.charAt(i) == '{') {
					i++;
					start = i;
					while(i < value.length()) {
						if((value.charAt(i) == '{') || (value.charAt(i) == '$')) {
							return value;
						}
						if(value.charAt(i) == '}') {
							end = i;
							String properties = getProperty(value.substring(start, end));
							if(properties == null) { //此时应该返回value还是null还是${properties}
								sb.append("${").append(value.substring(start, end)).append("}");
							} else {
								sb.append(properties);
							}
							break;
						} else {
							i++;
						}
					}
					if(i == value.length()) {
						return value;
					}
				}
			} else {
				sb.append(value.charAt(i));
			}
		}
		return sb.toString();
	}
	
	public static String getProperty(String value) {
		if((value == null) || (value.isEmpty())) {
			return null;
		} else {
		return System.getProperty(value);
		}
	}

}
