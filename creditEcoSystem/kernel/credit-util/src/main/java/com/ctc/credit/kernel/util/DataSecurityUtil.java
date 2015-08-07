package com.ctc.credit.kernel.util;

import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

public class DataSecurityUtil {

	private static Logger logger = Logger.getLogger(DataSecurityUtil.class);
	
	private static final String Algorithm = "DESede"; // 定义 加密算法,可用
														// DES,DESede,Blowfish

	/**
	 * 对数据进行加密
	 * 
	 * @param keybyte
	 *            为加密密钥，长度为24字节
	 * @param src
	 *            为被加密的数据缓冲区（源）
	 * @return
	 */
	public static byte[] encryptMode(byte[] keybyte, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// 加密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	/**
	 * 对数据进行解密
	 * 
	 * @param keybyte
	 *            为加密密钥，长度为24字节
	 * @param src
	 *            为加密后的缓冲区
	 * @return
	 */
	public static byte[] decryptMode(byte[] keybyte, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// 解密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	/**
	 * 转换成十六进制字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";

		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			if (n < b.length - 1)
				hs = hs + ":";
		}
		return hs.toUpperCase();
	}

	/**
	 * 
	 * @param bytes
	 * @return
	 */
	public static byte[] decodeBase64(final byte[] bytes) {
		return Base64.decodeBase64(bytes);
	}

	/**
	 * 解码base64 字符串
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] decodeBase64(String str) {
		if (null == str)
			throw new IllegalArgumentException("str can not be null!");
		return Base64.decodeBase64(str.getBytes());
	}

	/**
	 * 二进制数据编码为BASE64字符串
	 * 
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public static String encodeBase64(final byte[] bytes) {
		return new String(Base64.encodeBase64(bytes));
	}

	/**
	 * SHA1 计算摘要并转为16进制字符串
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodePwd(String data) throws Exception {
		MessageDigest alga = MessageDigest.getInstance("SHA1");
		// 添加要进行计算摘要的信息
		alga.update(data.getBytes("utf-8"));
		byte[] digesta = alga.digest();
		try {
			String b = bytes2Hex(digesta);
			return b;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	/**
	 * 通过私钥签名
	 * 
	 * @param data
	 * @param prikey
	 * @return
	 * @throws Exception
	 */
	public static String signData(String data, PrivateKey prikey)
			throws Exception {
		try {
			Signature sig = Signature.getInstance("SHA1WithRSA");
			sig.initSign(prikey);
			sig.update(data.getBytes("utf-8"));
			byte[] sigBytes = sig.sign();
			return encodeBase64(sigBytes);
		} catch (Exception e) {
			throw new RuntimeException("签名失败", e);
		}
	}

	/**
	 * 数据验签
	 * 
	 * @param data
	 * @param pubkey
	 * @param signValue
	 * @return
	 */
	public static Boolean verifyData(String data, PublicKey pubkey,
			String signValue){
		Boolean verifyFlag = false;
		try {
			Signature sig = Signature.getInstance("SHA1WithRSA");
			sig.initVerify(pubkey);
			sig.update(data.getBytes("utf-8"));
			byte[] signValueByte = decodeBase64(signValue);
			if (sig.verify(signValueByte)) {
				verifyFlag =  true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return verifyFlag;
	}

	public static String bytes2Hex(byte[] inbuf) {
		int i;
		String byteStr;
		StringBuffer strBuf = new StringBuffer();
		for (i = 0; i < inbuf.length; i++) {
			byteStr = Integer.toHexString(inbuf[i] & 0x00ff);
			if (byteStr.length() != 2) {
				strBuf.append('0').append(byteStr);
			} else {
				strBuf.append(byteStr);
			}
		}
		return new String(strBuf);
	}

	public static void main(String[] args) {
		// // 添加新安全算法,如果用JCE就要把它添加进去
		// Security.addProvider(new com.sun.crypto.provider.SunJCE());
		//
		// final byte[] keyBytes = { 0x11, 0x22, 0x4F, 0x58, (byte) 0x88, 0x10,
		// 0x40, 0x38, 0x28, 0x25, 0x79, 0x51, (byte) 0xCB, (byte) 0xDD,
		// 0x55, 0x66, 0x77, 0x29, 0x74, (byte) 0x98, 0x30, 0x40, 0x36,
		// (byte) 0xE2 }; // 24字节的密钥
		// String szSrc = "This is a 3DES test. 测试";
		//
		// System.out.println("加密前的字符串:" + szSrc);
		//
		// byte[] encoded = encryptMode(keyBytes, szSrc.getBytes());
		// System.out.println("加密后的字符串:" + new String(encoded));
		//
		// byte[] srcBytes = decryptMode(keyBytes, encoded);
		// System.out.println("解密后的字符串:" + (new String(srcBytes)));
		byte[] b = "zxcvbnuytrewqghjkaslA!@".getBytes();
		System.out.println(byte2hex(b));
	}

}