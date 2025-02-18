package net.diaowen.dwsurvey.dao;

import net.diaowen.common.dao.BaseDao;
import net.diaowen.dwsurvey.entity.AnScore;
import net.diaowen.dwsurvey.entity.Question;

/**
 * 评分题 interface
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 *
 */
public interface AnScoreDao extends BaseDao<AnScore, String>{

	public void findGroupStats(Question question);
	
}
