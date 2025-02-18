package net.diaowen.dwsurvey.service;

import net.diaowen.common.service.BaseService;
import net.diaowen.dwsurvey.entity.Question;
import net.diaowen.dwsurvey.entity.AnAnswer;

/**
 * 答卷业务
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 */

public interface AnAnswerManager extends BaseService<AnAnswer, String> {
	public AnAnswer findAnswer(String belongAnswerId, String quId);

	public void findGroupStats(Question question);
}
