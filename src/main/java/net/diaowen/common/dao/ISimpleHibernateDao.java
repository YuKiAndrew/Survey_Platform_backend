package net.diaowen.common.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

public interface ISimpleHibernateDao<T, ID extends Serializable> {

	/**
	 * Obtain SessionFactory
	 */
	public abstract SessionFactory getSessionFactory();

	/**
	 * Utilize @Autowire to implement the session factory
	 */
	@Autowired
	public abstract void setSessionFactory(final SessionFactory sessionFactory);

	public abstract Session getSession();

	/**
	 * save the entity
	 */
	public abstract void save(final T entity);

	/**
	 * 删除对象.
	 *
	 * @param entity object must be session object or entity contains session object.
	 */
	public abstract void delete(final T entity);

	/**
	 * delete object by using ID.
	 */
	public abstract void delete(final ID id);

	/**
	 * Obtain object by ID.
	 */
	public abstract T get(final ID id);

	/**
	 * Obtain objects uses multiple ID.
	 */
	public abstract List<T> get(final Collection<ID> ids);

	/**
	 *	getALL objects.
	 */
	public abstract List<T> getAll();

	/**
	 *	getAll objects.
	 */
	public abstract List<T> getAll(String orderByProperty, boolean isAsc);

	/**
	 * find entities based on the conditions
	 */
	public abstract List<T> findBy(final String propertyName, final Object value);

	/**
	 * find entity based on the conditions
	 */
	public abstract T findUniqueBy(final String propertyName, final Object value);

	/**
	 * HQL search
	 *
	 * @param values
	 */
	public abstract <X> List<X> find(final String hql, final Object... values);

	/**
	 * HQL search.
	 *
	 * @param values bind with the value
	 */
	public abstract <X> List<X> find(final String hql,
                                     final Map<String, ?> values);

	/**
	 * HQL search
	 *
	 * @param values bind with order
	 */
	public abstract <X> X findUnique(final String hql, final Object... values);

	/**
	 * HQL search
	 *
	 * @param values bind with name
	 */
	public abstract <X> X findUnique(final String hql,
                                     final Map<String, ?> values);

	/**
	 * HQL to add and remove
	 *
	 * @param values bind with order
	 * @return the number of records
	 */
	public abstract int batchExecute(final String hql, final Object... values);

	/**
	 * HQL to batch remove and delete
	 *
	 * @param values bind with name
	 * @return the number of records has been altered
	 */
	public abstract int batchExecute(final String hql,
                                     final Map<String, ?> values);

	/**
	 * HQL to create a query
	 * can combine with find() method
	 *
	 * @param values bind with order
	 */
	public abstract Query createQuery(final String queryString,
                                      final Object... values);

	/**
	 * HQL to create a query
	 * can combine with find() method
	 *
	 * @param values bind with name.
	 */
	public abstract Query createQuery(final String queryString,
                                      final Map<String, ?> values);

	/**
	 * Query the object list based on criteria.
	 *
	 */
	public abstract List<T> find(final Criterion... criterions);

	/**
	 * Query a unique object based on criteria.
	 *
	 */
	public abstract T findUnique(final Criterion... criterions);

	/**
	 * Create Criteria based on Criterion conditions.
	 * Enables more flexible operations with the find() function.
	 *
	 */
	public abstract Criteria createCriteria(final Criterion... criterions);

	/**
	 * @param criterions
	 * @return
	 */
	public Criteria createCriteria(List<Criterion> criterions);

	/**
	 * Initialize the object.
	 * The object obtained using the load() method is only a proxy. It needs to be initialized before being passed to the View layer.
	 * If an entity is passed in, only its direct attributes will be initialized, while lazily loaded associated collections and attributes will not be initialized.
	 * To initialize associated attributes, execute:
	 * Hibernate.initialize(user.getRoles()) – Initializes the direct attributes of User and its associated collection.
	 * Hibernate.initialize(user.getDescription()) – Initializes the direct attributes of User and the lazily loaded Description attribute.
	 */
	public abstract void initProxyObject(Object proxy);

	/**
	 * Flush Session.
	 */
	public abstract void flush();

	/**
	 * Add a distinct transformer to the Query.
	 * Preloading associated objects in HQL can cause duplication of the primary object, requiring distinct processing.
	 */
	public abstract Query distinct(Query query);

	/**
	 * Add a distinct transformer to the Criteria.
	 * Preloading associated objects in HQL can cause duplication of the primary object, requiring distinct processing.
	 */
	public abstract Criteria distinct(Criteria criteria);

	/**
	 * get id .
	 */
	public abstract String getIdName();

	/**
	 * Check whether the attribute value of the object is unique in the database.

	 * In the case of modifying an object, if the newly modified value (value) is equal to the original attribute value (orgValue), no comparison is performed.
	 */
	public abstract boolean isPropertyUnique(final String propertyName,
                                             final Object newValue, final Object oldValue);

}
