/**
 * 
 */
package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.ScoreDto;
import com.ctc.credit.bairong.model.CreareBrScoreInfo;
import com.ctc.credit.kernel.base.GenericService;

/**
 * @author Chengang
 * 2015年8月3日 下午3:17:57 
 */
public interface CreareBrScoreService extends GenericService<CreareBrScoreInfo, String> {

	void saveScoreInfo(ScoreDto dto);
}
