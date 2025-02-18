package net.diaowen.dwsurvey.service;

import net.diaowen.common.plugs.page.Page;
import net.diaowen.common.service.BaseService;
import net.diaowen.dwsurvey.entity.AnFillblank;
import net.diaowen.dwsurvey.entity.Question;

/**
 * 填空题
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 */
public interface AnFillblankManager extends BaseService<AnFillblank, String>{
	public AnFillblank findAnswer(String belongAnswerId, String quId);

	public void findGroupStats(Question question);

	Page<AnFillblank> findPage(Page<AnFillblank> page, String quId);
}
