package edu.jiangxin.test;

public class StringProcess {
	
	public String parser(String input) {
		
		if(!checkValid(input)) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int end = 0;
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i) == '$') {
				i += 2;
				start = i;
				while(input.charAt(i) != '}') {
					i++;
				}
				end = i;
				String subStr = input.substring(start,end);
				sb.append(PropertyProcess.getProperty(System.class, subStr));
				//sb.append(System.getProperty(subStr));
			} else {
				sb.append(input.charAt(i));
			}
		}
		return sb.toString();
	}
	
	public boolean checkValid(String input) {
		if(input == null) {
			return false;
		}
		else if(input.matches("((\\p{Alpha}+|(\\$\\{\\p{Alnum}+\\})):?/?)+")) {
			return true;
		} else {
			return false;
		}
	}

}
