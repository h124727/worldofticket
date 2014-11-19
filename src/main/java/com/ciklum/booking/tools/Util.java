package com.ciklum.booking.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

	public static List<Integer> parseNumbersInString(String input) {
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(input);
		List<Integer> l = new ArrayList<Integer>();
		while (m.find()) {
			l.add(Integer.parseInt(m.group()));
		}
		return l.isEmpty() ? Collections.EMPTY_LIST : l;
	}

}
