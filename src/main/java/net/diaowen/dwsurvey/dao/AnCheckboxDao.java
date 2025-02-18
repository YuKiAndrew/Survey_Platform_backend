package net.diaowen.dwsurvey.dao;

import java.util.List;

import net.diaowen.common.dao.BaseDao;
import net.diaowen.dwsurvey.entity.AnCheckbox;
import net.diaowen.dwsurvey.entity.Question;
import net.diaowen.dwsurvey.entity.DataCross;


/**
 * 多选题数据 interface
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 *
 */
public interface AnCheckboxDao extends BaseDao<AnCheckbox, String>{

	public void findGroupStats(Question question);

	public List<DataCross> findStatsDataCross(Question rowQuestion,
                                              Question colQuestion);

	public List<DataCross> findStatsDataChart(Question question);

}
