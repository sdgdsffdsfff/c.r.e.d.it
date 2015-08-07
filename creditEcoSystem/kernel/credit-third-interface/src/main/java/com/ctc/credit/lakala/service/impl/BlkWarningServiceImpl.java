package com.ctc.credit.lakala.service.impl;

import java.io.UnsupportedEncodingException;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.lakala.dto.BlkWarningRequestParam;
import com.ctc.credit.lakala.dto.BlkWarningResponseParam;
import com.ctc.credit.lakala.dto.ResponseHead;
import com.ctc.credit.lakala.service.LakalaServiceAbstract;
import com.ctc.credit.lakala.util.DES;
import com.ctc.credit.lakala.util.RSA;

@Service
@Transactional
public class BlkWarningServiceImpl extends LakalaServiceAbstract {

	@Override
	public String doChain(String response, String tipPubKey) throws UnsupportedEncodingException, Exception{
		// TODO Auto-generated method stub
		ResponseHead  rh = (ResponseHead)JSONObject.toBean(JSONObject.fromObject(response),ResponseHead.class);
		
		if(RSA.verify(rh.getRetData(), rh.getSign(), this.tipPubKey)){
			DES des = new DES(key); 
			return des.decrypt(rh.getRetData());
		}
		
		return null;
		
	}

	
	public static void main(String[] args) throws Exception{
		LakalaServiceAbstract lsa = new BlkWarningServiceImpl();
		BlkWarningRequestParam brp = new BlkWarningRequestParam();
		brp.setGmsfhm("442501197004054057");
//		brp.setXm("张三");
		BlkWarningResponseParam bwrp  = lsa.doRequest(brp);
		System.out.println(JSONObject.fromObject(bwrp).toString());
	}
}

