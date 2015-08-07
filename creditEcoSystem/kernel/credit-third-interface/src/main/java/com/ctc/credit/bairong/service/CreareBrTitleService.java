/**
 * 
 */
package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.TitleDto;
import com.ctc.credit.bairong.model.CreareBrTitleInfo;
import com.ctc.credit.kernel.base.GenericService;

/**
 * @author Chengang
 * 2015年8月3日 下午4:04:08 
 */
public interface CreareBrTitleService extends GenericService<CreareBrTitleInfo, String> {
	void saveTitleInfo(TitleDto dto);
}
