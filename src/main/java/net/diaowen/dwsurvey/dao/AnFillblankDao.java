package net.diaowen.dwsurvey.dao;

import net.diaowen.common.dao.BaseDao;
import net.diaowen.dwsurvey.entity.AnFillblank;
import net.diaowen.dwsurvey.entity.Question;

/**
 * 填空题 interface
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 *
 */
public interface AnFillblankDao extends BaseDao<AnFillblank, String>{

	public void findGroupStats(Question question);

}
