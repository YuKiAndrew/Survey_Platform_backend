package net.diaowen.dwsurvey.service;

import java.util.List;

import net.diaowen.dwsurvey.entity.QuestionLogic;

/**
 * 题逻辑
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 */
public interface QuestionLogicManager {

	List<QuestionLogic> findByCkQuId(String quId);

}
