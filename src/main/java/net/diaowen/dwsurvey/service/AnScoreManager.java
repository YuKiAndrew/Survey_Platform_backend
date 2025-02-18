package net.diaowen.dwsurvey.service;

import java.util.List;

import net.diaowen.common.service.BaseService;
import net.diaowen.dwsurvey.entity.AnScore;
import net.diaowen.dwsurvey.entity.Question;

/**
 * 评分题
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 */
public interface AnScoreManager extends BaseService<AnScore, String>{
	public List<AnScore>  findAnswer(String belongAnswerId, String quId);

	public void findGroupStats(Question question);
}
