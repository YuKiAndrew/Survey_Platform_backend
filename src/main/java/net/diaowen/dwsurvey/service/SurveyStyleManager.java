package net.diaowen.dwsurvey.service;

import net.diaowen.dwsurvey.entity.SurveyStyle;

/**
 * 问卷样式
 * @author ymx
 *
 *
 * http://dwsurvey.net
 */
public interface SurveyStyleManager  {

	public SurveyStyle get(String id) ;
	
	public SurveyStyle getBySurveyId(String surveyId) ;
	
	public void save(SurveyStyle surveyStyle) ;
}
