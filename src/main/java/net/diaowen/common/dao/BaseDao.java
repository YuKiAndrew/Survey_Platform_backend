package net.diaowen.common.dao;

import java.io.Serializable;


/**
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 */
public interface BaseDao<T,ID extends Serializable> extends IHibernateDao<T, ID>{
	
}
