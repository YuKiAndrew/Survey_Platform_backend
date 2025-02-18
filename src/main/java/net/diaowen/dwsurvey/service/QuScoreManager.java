package net.diaowen.dwsurvey.service;

import java.util.List;

import net.diaowen.common.service.BaseService;
import net.diaowen.dwsurvey.entity.QuScore;

/**
 * 评分题
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 */
public interface QuScoreManager extends BaseService<QuScore, String>{

	public List<QuScore> findByQuId(String id);
	
	public QuScore upOptionName(String quId, String quItemId, String optionName);

	public List<QuScore> saveManyOptions(String quId, List<QuScore> quScores);

	public void ajaxDelete(String quItemId);

	public void saveAttr(String quItemId);
}
