package net.diaowen.common.dao;

import java.io.Serializable;

/**
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 */
public class BaseDaoImpl<T,ID extends Serializable> extends HibernateDao<T, ID> implements BaseDao<T, ID>{

	
}
