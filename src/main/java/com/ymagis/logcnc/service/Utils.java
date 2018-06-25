package com.ymagis.logcnc.service;

public abstract class Utils {
	
	public static String HEADER = "id; rel_devices_screen_id; cpl_id; cpl_content_title; cpl_content_kind; cpl_duration_s; start_datetime; stop_datetime; duration_s; created; modified; theater_id; theater_code; country; screen_id; show_id; title";

	public static String rightPadding(String s, int n, char c) {
		return padding(s, n, c, false);
	}
	
	public static String leftPadding(String s, int n, char c) {
		return padding(s, n, c, true);
	}

	private static String padding(String s, int n, char c, boolean paddingLeft) {
		StringBuffer sb = new StringBuffer(s);
		int sbLength = sb.length();
		if (n > 0 && n > sbLength) {
			for (int i = 0; i < (n - sbLength); i++) {
				if (paddingLeft) {
					sb.insert(0, c);
				} else {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}
}
