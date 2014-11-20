package com.ciklum.booking.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

	@SuppressWarnings("unchecked")
	public static List<Integer> parseNumbersInString(String input) {
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(input);
		List<Integer> l = new ArrayList<Integer>();
		while (m.find()) {
			l.add(Integer.parseInt(m.group()));
		}
		return l.isEmpty() ? Collections.EMPTY_LIST : l;
	}
	
	public static void sleep(int sec, String reason) {
		try {
			System.out.println(String.format("*** Waiting %s: %d sec", reason, sec));
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
