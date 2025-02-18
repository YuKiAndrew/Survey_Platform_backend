package net.diaowen.dwsurvey.dao;

import net.diaowen.common.dao.BaseDao;
import net.diaowen.dwsurvey.entity.Question;

/**
 * 题基础 interface
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 *
 */
public interface QuestionDao extends BaseDao<Question, String>{
	
	public void update(Question entity);
	public void quOrderByIdDel1(String belongId, Integer orderById);
}
