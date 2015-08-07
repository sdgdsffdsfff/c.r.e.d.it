/**
 * 
 */
package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.SpecialListDto;
import com.ctc.credit.bairong.model.CreareBrSpeciallistInfo;
import com.ctc.credit.kernel.base.GenericService;

/**
 * @author Chengang
 * 2015年8月3日 下午2:48:58 
 */
public interface CreareBrSpeciallistService extends GenericService<CreareBrSpeciallistInfo, String> {

	void saveSpeciallistInfo(SpecialListDto dto);
}
