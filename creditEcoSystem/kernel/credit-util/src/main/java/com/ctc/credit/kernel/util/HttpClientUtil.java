package com.ctc.credit.kernel.util;

import java.io.File;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;

public class HttpClientUtil {
	
	/**
	 * 获取线程安全的httpclient
	 * @param truststorePath
	 * @param storePwd
	 * @return
	 */
	public static CloseableHttpClient getHttpClient(String truststorePath,String storePwd) {
		SSLContext sslcontext = null;
		try {
			sslcontext = SSLContexts
					.custom()
					.loadTrustMaterial(
							new File(truststorePath),
							storePwd.toCharArray(),
							new TrustSelfSignedStrategy()).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.getDefaultHostnameVerifier());
		CloseableHttpClient httpclient = HttpClients.custom()
				.setSSLSocketFactory(sslsf).build();
		return httpclient;
	}
	
	/**
	 * 信任所有证书的 httpclient
	 * @throws KeyStoreException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	
	public static CloseableHttpClient getHttpClient() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException{
		SSLContext sslContext = new SSLContexts().custom().loadTrustMaterial(null, new TrustStrategy() {
			//信任所有
			public boolean isTrusted(X509Certificate[] chain,
			        String authType) throws CertificateException {
			return true;
			}

			@Override
			public boolean isTrusted(java.security.cert.X509Certificate[] arg0,
					String arg1) throws java.security.cert.CertificateException {
				// TODO Auto-generated method stub
				return true;
			}
			
			}).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        return httpclient;
	}
}
