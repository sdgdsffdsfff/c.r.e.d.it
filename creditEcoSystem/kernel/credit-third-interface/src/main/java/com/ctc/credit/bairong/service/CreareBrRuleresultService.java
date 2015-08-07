/**
 * 
 */
package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.RuleResultDto;
import com.ctc.credit.bairong.model.CreareBrRuleresultInfo;
import com.ctc.credit.kernel.base.GenericService;

/**
 * @author Chengang
 * 2015年8月3日 下午3:53:54 
 */
public interface CreareBrRuleresultService extends GenericService<CreareBrRuleresultInfo, String> {
	void saveRuleresultInfo(RuleResultDto dto);
}
