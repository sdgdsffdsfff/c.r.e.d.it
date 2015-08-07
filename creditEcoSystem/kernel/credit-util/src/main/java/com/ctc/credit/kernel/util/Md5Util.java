package com.ctc.credit.kernel.util;

import java.security.MessageDigest;

public class Md5Util {
	public static String md5Code(String str) {
		try {
			byte[] res = str.getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5".toUpperCase());
			byte[] result = md.digest(res);
			for (int i = 0; i < result.length; i++) {
				md.update(result[i]);
			}
			byte[] hash = md.digest();
			StringBuffer d = new StringBuffer("");
			for (int i = 0; i < hash.length; i++) {
				int v = hash[i] & 0xFF;
				if (v < 16)
					d.append("0");
				d.append(Integer.toString(v, 16).toUpperCase() + "");
			}
			return d.toString();
		} catch (Exception e) {
			return "";
		}

	}
}
