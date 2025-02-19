package net.diaowen.common.dao;

import java.io.Serializable;


/**
 * @author ymx
 *
 *
 */
public interface BaseDao<T,ID extends Serializable> extends IHibernateDao<T, ID>{
	
}
