package net.diaowen.dwsurvey.service;

import net.diaowen.common.service.BaseService;
import net.diaowen.dwsurvey.entity.SurveyDetail;

/**
 * 问卷评情
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 */
public interface SurveyDetailManager extends BaseService<SurveyDetail, String>{

	public SurveyDetail getBySurveyId(String surveyId);

	public void saveBaseUp(SurveyDetail t);
}
