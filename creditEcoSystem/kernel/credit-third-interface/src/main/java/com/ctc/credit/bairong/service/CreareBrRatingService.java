/**
 * 
 */
package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.RatingDto;
import com.ctc.credit.bairong.model.CreareBrRatingInfo;
import com.ctc.credit.kernel.base.GenericService;

/**
 * @author Chengang
 * 2015年8月3日 下午3:39:40 
 */
public interface CreareBrRatingService extends GenericService<CreareBrRatingInfo, String> {
	
	void saveRaingInfo(RatingDto dto);
}
