package com.tuenti.challenge11.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class AES {

	public static String encrypt(String text, String key) {
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");

			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return cipher.doFinal(text.getBytes()).toString();
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String text, String key) {
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/ECB/NOPADDING");
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);

					
			
			//rellenamos para que sea
			Integer whites = 16- text.length()%16;
			for(int z=0;z<whites;z++){
				text+=" ";
			}
			
			return new String(cipher.doFinal(text.getBytes()));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
}
