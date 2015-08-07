package com.ctc.credit.kernel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctc.credit.kernel.model.pengyuan.CisArtificialPersonInfo;
import com.ctc.credit.kernel.service.pengyuan.CisArtificialPersonInfoService;

@Controller
public class Test {
	
	@Autowired
	private CisArtificialPersonInfoService cisArtificialPersonInfoService;
	
	@ResponseBody
	@RequestMapping(value="/getAll.action",method=RequestMethod.GET) 
	public List<CisArtificialPersonInfo> t(){
		return cisArtificialPersonInfoService.getAll();
	}
	
	@ResponseBody
	@RequestMapping(value="/insert.action",method=RequestMethod.GET) 
	public String insert(){
		CisArtificialPersonInfo cpi = new CisArtificialPersonInfo();
		cpi.setApplyNo("3213123");
		cpi.setArtificialName("adsfadsf");
		cisArtificialPersonInfoService.save(cpi);
		return "OK";
	}
}
