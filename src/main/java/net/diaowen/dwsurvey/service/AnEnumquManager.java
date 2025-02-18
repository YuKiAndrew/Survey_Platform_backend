package net.diaowen.dwsurvey.service;

import java.util.List;

import net.diaowen.common.service.BaseService;
import net.diaowen.dwsurvey.entity.Question;
import net.diaowen.dwsurvey.entity.AnEnumqu;

/**
 * 枚举题
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 */
public interface AnEnumquManager extends BaseService<AnEnumqu, String> {
	public  List<AnEnumqu> findAnswer(String belongAnswerId, String quId);

	public void findGroupStats(Question question);
}
