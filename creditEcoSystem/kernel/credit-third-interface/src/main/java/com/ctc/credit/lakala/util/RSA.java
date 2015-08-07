package com.ctc.credit.lakala.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RSA {

	public static String ALGORITHM = "RSA";

	public static String SIGN_ALGORITHMS = "SHA1WithRSA";// 摘要加密算饭

	private static String log = "RSAUtil";

	public static String CHAR_SET = "UTF-8";

	/**
	 * 数据签名
	 * 
	 * @param content
	 *            签名内容
	 * @param privateKey
	 *            私钥
	 * @return 返回签名数据
	 */
	public static String sign(String content, String privateKey) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
					Base64.decode(privateKey));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);

			java.security.Signature signature = java.security.Signature
					.getInstance(SIGN_ALGORITHMS);

			signature.initSign(priKey);
			signature.update(content.getBytes(CHAR_SET));

			byte[] signed = signature.sign();

			return Base64.encode(signed);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 签名验证
	 * 
	 * @param content
	 * @param sign
	 * @param lakala_public_key
	 * @return
	 */
	public static boolean verify(String content, String sign,
			String lakala_public_key) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			byte[] encodedKey = Base64.decode(lakala_public_key);
			PublicKey pubKey = keyFactory
					.generatePublic(new X509EncodedKeySpec(encodedKey));

			java.security.Signature signature = java.security.Signature
					.getInstance(SIGN_ALGORITHMS);

			signature.initVerify(pubKey);
			signature.update(content.getBytes(CHAR_SET));

			boolean bverify = signature.verify(Base64.decode(sign));
			return bverify;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 通过公钥解密
	 * 
	 * @param content待解密数据
	 * @param pk公钥
	 * @return 返回 解密后的数据
	 */
	protected static byte[] decryptByPublicKey(String content, PublicKey pk) {

		try {
			Cipher ch = Cipher.getInstance(ALGORITHM);
			ch.init(Cipher.DECRYPT_MODE, pk);
			InputStream ins = new ByteArrayInputStream(Base64.decode(content));
			ByteArrayOutputStream writer = new ByteArrayOutputStream();
			// rsa解密的字节大小最多是128，将需要解密的内容，按128位拆开解密
			byte[] buf = new byte[128];
			int bufl;
			while ((bufl = ins.read(buf)) != -1) {
				byte[] block = null;

				if (buf.length == bufl) {
					block = buf;
				} else {
					block = new byte[bufl];
					for (int i = 0; i < bufl; i++) {
						block[i] = buf[i];
					}
				}

				writer.write(ch.doFinal(block));
			}

			return writer.toByteArray();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 通过私钥加密
	 * 
	 * @param content
	 * @param pk
	 * @return,加密数据，未进行base64进行加密
	 */
	protected static byte[] encryptByPrivateKey(String content, PrivateKey pk) {

		try {
			Cipher ch = Cipher.getInstance(ALGORITHM);
			ch.init(Cipher.ENCRYPT_MODE, pk);
			return ch.doFinal(content.getBytes(CHAR_SET));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("通过私钥加密出错");
		}
		return null;

	}

	/**
	 * 解密数据，接收端接收到数据直接解密
	 * 
	 * @param content
	 * @param key
	 * @return
	 */
	public static String decrypt(String content, String key) {
		System.out.println(log + "：decrypt方法中key=" + key);
		if (null == key || "".equals(key)) {
			System.out.println(log + "：decrypt方法中key=" + key);
			return null;
		}
		PublicKey pk = SignConfig.getPublicKey(key);
		byte[] data = decryptByPublicKey(content, pk);
		String res = null;
		try {
			res = new String(data, CHAR_SET);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 对内容进行加密
	 * 
	 * @param content
	 * @param key私钥
	 * @return
	 */
	public static String encrypt(String content, String key) {
		PrivateKey pk = SignConfig.getPrivateKey(key);
		byte[] data = encryptByPrivateKey(content, pk);
		String res = null;
		try {
			res = Base64.encode(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;

	}

	public static void main(String[] args) {
//		String str = "X3H6pVkXTHUhe4ayNr2lfD4xijZnyfewOjPG/pKOPkqoRo55WsD8+sXVsYi0m/+wENtQBXZ5PxrBfOXogot9ygpnylvU379H87MK0S5tX2zYqObT95zhAc0VLb7VKJPP";//Base64.encode("{\"gmsfhm\":\"110101198001012526\",\"email\":\"\",\"xm\":\"张三\",\"sjhm\":\"\",\"yhkh\":\"\",\"ip\":\"\",\"gddh\":\"\"}".getBytes());
//		System.out.println("Base64加密-->" + str);
//		String aaa = sign(
//				str,
//				"MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDFG4eG8wdXdr98zWVPPR6qUTmPVfkncSn8V2Fvtw2/new/5uNf804M8hUQB2RJlPOQMQXoItLPYwpDV+Tx3/fjNDVxpxfwuqlv9Ih/xZGQ6fpZqueCfhj4OsZxAcP/j/VTP+M/8p/HVWUgqtlBrb8i6VdbzGCtbR5LpvCc8QFX/N89gnlMRo2r7+ZrORShbUv/5j/svsy34uVxPEzGeazgfnF6WJhJiyEiivy+Ev681CqUHrMBG5/gy72VpyBoh4xtW3JDDdsu5AhoelB9HloqeK6xFuo2TAMHmITXWM2Ik5XAGhFiJotMqUn45tW9GKpyO/jOEERpCVpCZEoaScdjAgMBAAECggEBALLPN5Jf1DAvRKV2O0q3+qKtjtcOOjniuiD2MClFWc6T+Cc8UNbRhOPPlPX2jq8F1jLflikxtiZ3BW90Q/h8oodV7InO+LPk0iMDJfUriNN6vycrGFxUAljmEPGhlWm48ef01DZF51bQjC4nb3HaqcOFBT/811Nc4xfkOPFW3U4wO8fl/zOFU68yGAGp+lZX8aKiJkRcSixwxn2yc6cFP9shD5x7BpB2WEttU5hDb+0eLGnr3lPVqOFgrG+NVYzaUDziH46e3/34p7J0fyb7k/Ck7QZVM93ujFHvDpbQDpPAQTITn/glrl58Xqf6SsN25HaCJb/ouxIslF0te35UfEkCgYEA44UPJ0u1PDO4wE+A0io0in+uYOK3REuz7S4kx9VSJUPbXIKSLYjfTNHFsKY/OxK7bHUH9xJrJrL/sNS5FDksSYk9jnKFOz8bIsZleNAIz8uzCbIHhe95cfUnaQ90olxgmWTp9QLtC0jhgdt8e1zeMq9nejwpEhcPvpmzV7s2CQ8CgYEA3cfmrPDp0SWET2PkMn96sDBFZ7p+Cccowsw21s3eKEgLEjAvKIrrt6XNJrGPuKf2/Hq56iHEKUhHyR1/5J8R5qGswRNUYNwgHE8riDZqAX0ADS1QOIckgd68FLuLHb5JczK/WxJNAgo8cQJHnSy6C0NUPczNP8kFuhXsq9vBVG0CgYBTZ97jP+zDkg5jaYHHCbPTJfVuDQ60GbBu/WB8ZWZExPhwlGk0Ch4aEjiPhpJdfIN6wfhWickAGdSEJadnk4H5vzbytmbDDmJLQEHIpTLlwj3zCvGZFu4FaaK17/WI46aB9S2TJSxy25fXu/eJXcUS/ZxIgi9oM04RSFUnjzjC3wKBgHnJ7bXosi3FEWxbaZQFh0U7rNFyiwYplQusAy1gbe/m6BV72lnEN/9okEkAVvFLY4lwh6m4EzWsWKdriLDuXXEuNWTtjXeHSibhnwE1CG96yk1yJcx1AipDOzuTZajWtxUIuCZ13U4SevCAFP2N8zh+J8OsNMYjSP7QTWBu1DLdAoGATNB5Tii6nbbX0Gx1sgeMaJruzW5DByY4WIoEe6JMxXV2chJ5JHmMBlmvE+7xipcXGcfGPii2Nvb+jaSHZx9zMG2Y4Rt2ZHOZyCwXWberqvvRd84Z5iWKyU3QWuE61WH73ugB28NemI4UDsNc7XTEPjBpz3NvOF8IYMneLzTe2GY=");
//		System.out.println("加签-->" + aaa);
		System.out
				.println("验签-->"
						+ verify(
								"X3H6pVkXTHUhe4ayNr2lfD4xijZnyfewOjPG/pKOPkqoRo55WsD8+sXVsYi0m/+wENtQBXZ5PxrBfOXogot9ygpnylvU379H87MK0S5tX2zYqObT95zhAc0VLb7VKJPP",
								"hehpZcT/bz0eJJZQIKBpkcCSeRg4oRma7UtiBtaob7qz2Yis8KPxL9lWxaUQfEEQiKVCDZKzMheV82tWNPCiciLQBWL+5MEYUKhZA6/lyxO7nD9JJbLmUbobmKwVOQ/GoNWUhSJryRAAtBTqbE7nBYAY64LFtoVV+leb4ltAjykKtHnJavVq67exifWiVqghERBV7moKQuBvDO2ovhEvYDNGhibHcz22Ii1ReBQK9+qKMgXc7GPU183jrhodSzjDIytCiRWcVRuHfPpVEvHs7Day9DV38qZvnhY5sLDuFUXhorvHwIk0Q7EPFqMR7pKYwvlP0SnqeEBn92u0Rmg2YQ==",
								"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxRuHhvMHV3a/fM1lTz0eqlE5j1X5J3Ep/Fdhb7cNv53sP+bjX/NODPIVEAdkSZTzkDEF6CLSz2MKQ1fk8d/34zQ1cacX8Lqpb/SIf8WRkOn6Warngn4Y+DrGcQHD/4/1Uz/jP/Kfx1VlIKrZQa2/IulXW8xgrW0eS6bwnPEBV/zfPYJ5TEaNq+/mazkUoW1L/+Y/7L7Mt+LlcTxMxnms4H5xeliYSYshIor8vhL+vNQqlB6zARuf4Mu9lacgaIeMbVtyQw3bLuQIaHpQfR5aKniusRbqNkwDB5iE11jNiJOVwBoRYiaLTKlJ+ObVvRiqcjv4zhBEaQlaQmRKGknHYwIDAQAB"));
//		System.out.println("原文-->" + new String(Base64.decode(str)));
	}

}
