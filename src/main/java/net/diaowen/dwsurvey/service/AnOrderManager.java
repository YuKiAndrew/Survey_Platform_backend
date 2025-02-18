package net.diaowen.dwsurvey.service;

import java.util.List;

import net.diaowen.common.service.BaseService;
import net.diaowen.dwsurvey.entity.Question;
import net.diaowen.dwsurvey.entity.AnOrder;

/**
 * 排序题
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 */
public interface AnOrderManager extends BaseService<AnOrder, String>{
	public List<AnOrder>  findAnswer(String belongAnswerId, String quId);

	public void findGroupStats(Question question);
}
