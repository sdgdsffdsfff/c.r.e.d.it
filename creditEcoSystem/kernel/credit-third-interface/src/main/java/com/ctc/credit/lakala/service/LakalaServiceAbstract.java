package com.ctc.credit.lakala.service;

import java.io.IOException;
import java.io.InputStream;
import java.security.PrivateKey;
import java.util.Properties;

import net.sf.json.JSONObject;

import com.ctc.credit.constant.ConfigsContant;
import com.ctc.credit.kernel.util.DataSecurityUtil;
import com.ctc.credit.kernel.util.JsonUtil;
import com.ctc.credit.kernel.util.KeystoreUtil;
import com.ctc.credit.lakala.constant.LakalaContant;
import com.ctc.credit.lakala.dto.BlkWarningRequestParam;
import com.ctc.credit.lakala.dto.BlkWarningResponseParam;
import com.ctc.credit.lakala.dto.RequestHead;
import com.ctc.credit.lakala.util.DES;
import com.ctc.credit.lakala.util.RSA;

public abstract class LakalaServiceAbstract implements LakalaServiceInterface<BlkWarningResponseParam,BlkWarningRequestParam>{
	
	public final String key = "j9txd49j";
	private final String cpzbm = "payblackQuery";
	private final String cpbm = "payblackwarningstatistics";
	private final String priKey;
	public final String tipPubKey;
	
	public LakalaServiceAbstract(){
		this.priKey = KeystoreUtil.getKeyContents(LakalaServiceAbstract.class.getResource("/tip_public_key/pkcs8_ctcf_key.pem").getPath());
		this.tipPubKey = KeystoreUtil.getKeyContents(LakalaServiceAbstract.class.getResource("/tip_public_key/kaola_public_key.pem").getPath());
	}

	
	@Override
	public BlkWarningResponseParam doRequest(BlkWarningRequestParam requestParam) throws Exception {
		// TODO Auto-generated method stub
		//1.将参数转化成为 JSON 内容
		//1.1 将requestParam 转化成为 JSON
		JSONObject jo = new JSONObject();
		String requestString = JsonUtil.toString(requestParam);//jo.fromObject(requestParam).toString();
		//1.2 将字符串进行DES加密
		DES crypt = new DES(key);
		String encryInfo = crypt.encrypt(requestString);
		//1.3 生成签名内容
		String sign = RSA.sign(encryInfo, priKey);
		//1.4组装报文头
		RequestHead rh = new RequestHead(encryInfo,LakalaContant.LAKALA_CUSTOMERID,cpzbm,cpbm,sign);
		String postJson = jo.fromObject(rh).toString();
		//2.进行请求
		String response = null;
		JsonRequestHttpClient jhc = new JsonRequestHttpClient();
		response = jhc.doPostRequest(LakalaContant.LAKALA_URL, postJson);
		//3.对返回内容进行验证.
		String result = doChain(response,tipPubKey);
		return (BlkWarningResponseParam)JSONObject.toBean(jo.fromObject(result),BlkWarningResponseParam.class);
	}
	
	public abstract String doChain(String response,String tipPubKey)  throws Exception ;
	
	public static void main(String[] args) throws Exception{
		String prikeyContent = KeystoreUtil.getKeyContents(LakalaServiceAbstract.class.getResource("/tip_public_key/pkcs8_ctcf_key.pem").getPath());
		RSA.sign("test", prikeyContent);
	}

}
