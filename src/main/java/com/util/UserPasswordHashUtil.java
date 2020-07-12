package com.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class UserPasswordHashUtil {
	
	public static String getSHA512(String plainText) {
		
		String shaString = null;
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-512");
		    digest.reset();
		    digest.update(plainText.getBytes("utf8"));
		    shaString = String.format("%0128x", new BigInteger(1, digest.digest()));
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return shaString;
		
	}
	 
	/*
	 *  sha512 is match 
	 *  
	 *  param : s1 : ����ڷκ��� �Է¹��� pwd
	 *          s2 : �⺻ sha512 ��ȣȭ�� pwd
	 */
	public static boolean isMatch(String s1, String s2) {
		return s2.equals(getSHA512(s1));
	}
	
}
