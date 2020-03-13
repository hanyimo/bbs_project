package com.bbs.test;

import org.apache.commons.codec.digest.DigestUtils;

public class MyTest {
	public static void main(String[] args) {
		String password = DigestUtils.md5Hex("admin");
		System.out.println(password);
	}
}
