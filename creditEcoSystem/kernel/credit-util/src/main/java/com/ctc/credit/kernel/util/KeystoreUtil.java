package com.ctc.credit.kernel.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * keystore 处理类
 * 
 * @author sunny
 * 
 */
public class KeystoreUtil {

	/**
	 * 获取keystore
	 * 
	 * @param keyStorePath
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public static KeyStore getKeyStore(String keyStorePath, String pwd)
			throws Exception {
		KeyStore ks = KeyStore.getInstance("JKS");
		if (null == keyStorePath)
			throw new Exception("keyStorePath 不能为空！");
		if (null == pwd)
			throw new Exception("pwd 不能为空！");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(keyStorePath));
			ks.load(fis, pwd.toCharArray());
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
		return ks;
	}

	/**
	 * 实例化公钥
	 * 
	 * @return
	 */
	public static PublicKey getPubKey(String keyStorePath, String pwd,
			String alia) {
		KeyStore keyStore = null;
		PublicKey publicKey = null;
		try {
			keyStore = getKeyStore(keyStorePath, pwd);
			Certificate certificate = keyStore.getCertificate(alia);
			publicKey = certificate.getPublicKey();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return publicKey;
	}

	// 获取字符串公钥
	// try {
	// // 自己的公钥(测试)
	// String pubKey =
	// "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVRiDkEKXy/KBTe+UmkA+feq1zGWIgBxkgbz7aBJGb5+eMKKoiDRoEHzlGndwFKm4mQWNftuMOfNcogzYpGKSEfC7sqfBPDHsGPZixMWzL3J10zkMTWo6MDIXKKqMG1Pgeq1wENfJjcYSU/enYSZkg3rFTOaBSFId+rrPjPo7Y4wIDAQAB";
	// java.security.spec.X509EncodedKeySpec bobPubKeySpec = new
	// java.security.spec.X509EncodedKeySpec(
	// DataSecurityUtil.decodeBase64(pubKey));
	// // RSA对称加密算法
	// java.security.KeyFactory keyFactory;
	// keyFactory = java.security.KeyFactory.getInstance("RSA");
	// // 取公钥匙对象
	// publicKey = keyFactory.generatePublic(bobPubKeySpec);
	// } catch (NoSuchAlgorithmException e) {
	// e.printStackTrace();
	// } catch (InvalidKeySpecException e) {
	// e.printStackTrace();
	// }

	/**
	 * 实例化私钥
	 * 
	 * @return
	 */
	public static PrivateKey getPrivateKey(String priKey) {
		PrivateKey privateKey = null;
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec;
		try {
			pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
					DataSecurityUtil.decodeBase64(priKey));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			privateKey = keyf.generatePrivate(pkcs8EncodedKeySpec);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return privateKey;
	}

	/**
	 * 实例化私钥,从文件读取
	 * 
	 * @param keyPath
	 * @return
	 * @throws Exception
	 */
	public static PrivateKey getPrivateKeyFromFile(String keyPath)
			throws Exception {
		if (null == keyPath)
			throw new RuntimeException("keyPath 不能为空！");
		PrivateKey privateKey = null;
		File file = new File(keyPath);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			if ((tempString = reader.readLine()) != null) {
				privateKey = getPrivateKey(tempString);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					throw new RuntimeException(e1);
				}
			}
		}
		return privateKey;
	}
	
	public static String getKeyContents(String keyPath){
		File file = new File(keyPath);
		BufferedReader reader = null;
		StringBuffer contents = new StringBuffer();
		String tempString = null;
		String endString = null;
		
		try {
			int i = 1;
			reader = new BufferedReader(new FileReader(file));
			while ((tempString = reader.readLine()) != null) {
				if(i == 1){
					i = 2;
					continue;
				}
				endString = tempString;
				contents.append(tempString);
				
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					throw new RuntimeException(e1);
				}
			}
		}
		
		return contents.toString().replace(endString, "");
	}
}
