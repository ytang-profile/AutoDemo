package com.sdlc.automation.pageObjects;

import java.util.Random;

public class Test {

	public static String getStringBack(String s) {
		if(s == null) {
			return s;
		}
		String result = s.replaceAll(" ","").replaceAll("-", "");
		if(result.length()<=3) {
			return result;
		}
		
		StringBuilder builder = new StringBuilder();
		int times = result.length()/3;
		int last = result.length()%3;
		String tail = "";
		if(last == 1) {
			times = times - 1;
		}
		if(times!=0) {
			tail = tail + "-";
		}
		
		
		int i = 0;
		for(int t = 0; t < times; t++) {
			String period = result.substring(i,i+3);
			//System.out.print(i);
			if(i != 0) {
				period = "-" + period;
			}
			builder.append(period);
			i = i + 3;
		}
		
		if(last == 1) {
			tail = tail + result.substring(i,i+2)+"-"+result.substring(result.length()-2);
		} else if(last == 2) {
			tail = tail + result.substring(result.length()-2);
		}
		builder.append(tail);
		
		
		return builder.toString();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "1--3 5 3   3  54";
		String result = getStringBack(input);
		System.out.print(result);
	}

}
