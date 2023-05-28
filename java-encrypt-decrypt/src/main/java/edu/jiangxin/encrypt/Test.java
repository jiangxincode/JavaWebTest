package edu.jiangxin.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

public class Test {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {

		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

		secureRandom.setSeed("BMEIMPL@YYYYMMDD".getBytes());
		keyGenerator.init(secureRandom);
		Key key = keyGenerator.generateKey();

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);

		byte[] outByte = cipher.doFinal("Abc1234%".getBytes("UTF-8"));
		String strResult = Base64.getEncoder().encodeToString(outByte);
		System.out.println(strResult.trim());

		cipher.init(Cipher.DECRYPT_MODE, key);

		outByte = cipher.doFinal(Base64.getDecoder().decode("hPFcKKIwKMokvS25dWalvw=="));
		strResult = new String(outByte, "UTF-8");

		System.out.println(strResult);
	}

}
