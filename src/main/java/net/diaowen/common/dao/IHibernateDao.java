package net.diaowen.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.diaowen.common.plugs.page.Page;
import net.diaowen.common.plugs.page.PageRequest;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

public interface IHibernateDao<T, ID extends Serializable> extends ISimpleHibernateDao<T, ID> {

	public static final String DEFAULT_ALIAS = "x";

	/**
	 * Get all entities.
	 */
	public abstract Page<T> getAll(final PageRequest pageRequest);

	/**
	 * Paginated query using HQL.
	 *
	 */
	public abstract Page<T> findPage(final PageRequest pageRequest, String hql,
                                     final Object... values);

	/**
	 * Paginated query using HQL.
	 */
	public abstract Page<T> findPage(final PageRequest pageRequest, String hql);

	/**
	 * Paginated query using HQL.
	 *
	 */
	public abstract Page<T> findPage(final PageRequest pageRequest, String hql,
                                     final Map<String, ?> values);

	/**
	 * Criteria query
	 *
	 */
	public abstract Page<T> findPage(final PageRequest pageRequest,
                                     final Criterion... criterions);

	public abstract Page<T> findPageList(final PageRequest pageRequest,
                                         final List<Criterion> criterions);

	public Page<T> findPageCriteria(PageRequest pageRequest, Criteria c);

	/**
	 * Get model by getting ID
	 * @param id
	 * @return
	 */
	public T getModel(ID id);

	/**
	 * find entity by order
	 */
	public  List<T>  findByOrder(String orderByProperty, boolean isAsc, Criterion... criterions);

	public  T  findFirst(Criterion... criterions);
	public  T  findFirst(List<Criterion> criterions);
	public  T  findFirst(String orderByProperty, boolean isAsc, Criterion... criterions);
	public  T  findFirst(String orderByProperty, boolean isAsc, List<Criterion> criterions);

	public Object findUniObjs(String hql, Object... values);

	public List<Object[]> findList(String hql, Object... values);

	public Page<T> findPageByCri(Page<T> page, List<Criterion> criterions);

	public List<T> findAll(CriteriaQuery criteriaQuery);

	public Page<T> findPageOderBy(Page<T> pageRequest,String orderByProperty, boolean isAsc, List<Criterion> criterions);
	public Page<T> findPageOderBy(Page<T> pageRequest,String orderByProperty, boolean isAsc, Criterion... criterions);


}
