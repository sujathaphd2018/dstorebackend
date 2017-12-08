package com.drugstore.drugstore.controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

public class Helper {
	
	public static String getPasswordSalted(String password) throws NoSuchAlgorithmException {
		String salt = "imsujathaimdoingmyphd";
		MessageDigest messageDigest = MessageDigest.getInstance("SHA");
		messageDigest.update((password+salt).getBytes());
		String encrytedPassword =  (new BigInteger(messageDigest.digest())).toString(16);
		return encrytedPassword;
	}
}
