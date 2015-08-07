package com.ctc.credit.lakala.util;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class SignConfig {
	
	//MD5签名
	public static String MD5="MD5";
	
	//RSA签名
	public static String RSA="0001";
	
	// 签名方式，选择项：0001(RSA)、MD5
	public static String SIGNTYPE = "0001";
	
	/**
	 * MD5 key
	 */
	public static String KEY = "";

	public static String PRIVATE_KEY = "";

	public static String LKL_PUBLIC_KEY = "";


	
	public static String ALGORITHM="RSA";
	
	public static PrivateKey pkey ;
	
	public static PublicKey pubkey ;
	
    /**
	* 得到私钥对象
	* @param key 密钥字符串（经过base64编码的秘钥字节）
	* @throws Exception
	*/
	public static PrivateKey getPrivateKey(String privateKey)  {
		try {
		byte[] keyBytes;
		
		keyBytes = Base64.decode(privateKey);
		
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		
		PrivateKey privatekey = keyFactory.generatePrivate(keySpec);
		
		return privatekey;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	 
    /**
	* 获取公钥对象
	* @param key 密钥字符串（经过base64编码秘钥字节）
	* @throws Exception
	*/
	public static PublicKey getPublicKey(String publicKey) {

		try {
			
			byte[] keyBytes;
			
			keyBytes = Base64.decode(publicKey);
			
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
			
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			
			PublicKey publickey = keyFactory.generatePublic(keySpec);
			
			return publickey;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
}
