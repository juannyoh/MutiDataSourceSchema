package hotel.sessionfactory;

import hotel.util.ThreadLocalUtil;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
//import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.TypeHelper;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DynamicSessionFactory implements DynamicSessionFactoryInf,
		ApplicationContextAware {

	private static final long serialVersionUID = 1L;

	private ApplicationContext applicationContext;

	private SessionFactory defaultTargetSessionFactory;

	private Map<Object, SessionFactory> targetSessionFactorys;

	public Map<Object, SessionFactory> getTargetSessionFactorys() {
		return targetSessionFactorys;
	}

	public void setTargetSessionFactorys(
			Map<Object, SessionFactory> targetSessionFactorys) {
		this.targetSessionFactorys = targetSessionFactorys;
	}

	public SessionFactory getDefaultTargetSessionFactory() {
		return defaultTargetSessionFactory;
	}

	public void setDefaultTargetSessionFactory(
			SessionFactory defaultTargetSessionFactory) {
		this.defaultTargetSessionFactory = defaultTargetSessionFactory;
	}

	// 动态调用SessionFactory
	private SessionFactory getHibernateSessionFactory(String name) {
		SessionFactory targetSessionFactory = targetSessionFactorys
				.get(ThreadLocalUtil.getSessionFacotyName());
		if (targetSessionFactory != null) {
			return targetSessionFactory;
		} else if (defaultTargetSessionFactory != null) {
			return defaultTargetSessionFactory;
		}
		return null;
		// return (SessionFactory) applicationContext.getBean(name);
	}

	// 实现DynamicSessionFactoryInf 接口的方法
	public SessionFactory getHibernateSessionFactory() {
//		return getHibernateSessionFactory(ThreadLocalUtil.getSessionFacotyName());
		SessionFactory targetSessionFactory = targetSessionFactorys
				.get(ThreadLocalUtil.getSessionFacotyName());
		if (targetSessionFactory != null) {
			return targetSessionFactory;
		} else if (defaultTargetSessionFactory != null) {
			return defaultTargetSessionFactory;
		}
		return null;
	}

	// 以下是实现SessionFactory接口的方法，并对当前的SessionFactory实体进行代理
	public Reference getReference() throws NamingException {
		return getHibernateSessionFactory().getReference();
	}

	public Session openSession() throws HibernateException {
		return getHibernateSessionFactory().openSession();
	}

	public Session getCurrentSession() throws HibernateException {
		return getHibernateSessionFactory().getCurrentSession();
	}

	public StatelessSession openStatelessSession() {
		return getHibernateSessionFactory().openStatelessSession();
	}

	public StatelessSession openStatelessSession(Connection connection) {
		return getHibernateSessionFactory().openStatelessSession(connection);
	}

	public ClassMetadata getClassMetadata(Class entityClass) {
		return getHibernateSessionFactory().getClassMetadata(entityClass);
	}

	public ClassMetadata getClassMetadata(String entityName) {
		return getHibernateSessionFactory().getClassMetadata(entityName);
	}

	public CollectionMetadata getCollectionMetadata(String roleName) {
		return getHibernateSessionFactory().getCollectionMetadata(roleName);
	}

	public Map getAllClassMetadata() {
		return getHibernateSessionFactory().getAllClassMetadata();
	}

	public Map getAllCollectionMetadata() {
		return getHibernateSessionFactory().getAllCollectionMetadata();
	}

	public Statistics getStatistics() {
		return getHibernateSessionFactory().getStatistics();
	}

	public void close() throws HibernateException {
		getHibernateSessionFactory().close();
	}

	public boolean isClosed() {
		return getHibernateSessionFactory().isClosed();
	}

	public Cache getCache() {
		return getHibernateSessionFactory().getCache();
	}

	public void evict(Class persistentClass) throws HibernateException {
		getHibernateSessionFactory().evict(persistentClass);
	}

	public void evict(Class persistentClass, Serializable id)
			throws HibernateException {
		getHibernateSessionFactory().evict(persistentClass, id);
	}

	public void evictEntity(String entityName) throws HibernateException {
		getHibernateSessionFactory().evictEntity(entityName);
	}

	public void evictEntity(String entityName, Serializable id)
			throws HibernateException {
		getHibernateSessionFactory().evictEntity(entityName, id);
	}

	public void evictCollection(String roleName) throws HibernateException {
		getHibernateSessionFactory().evictCollection(roleName);
	}

	public void evictCollection(String roleName, Serializable id)
			throws HibernateException {
		getHibernateSessionFactory().evictCollection(roleName, id);
	}

	public void evictQueries(String cacheRegion) throws HibernateException {
		getHibernateSessionFactory().evictQueries(cacheRegion);
	}

	public void evictQueries() throws HibernateException {
		getHibernateSessionFactory().evictQueries();
	}

	public Set getDefinedFilterNames() {
		return getHibernateSessionFactory().getDefinedFilterNames();
	}

	public FilterDefinition getFilterDefinition(String filterName)
			throws HibernateException {
		return getHibernateSessionFactory().getFilterDefinition(filterName);
	}

	public boolean containsFetchProfileDefinition(String name) {
		return getHibernateSessionFactory()
				.containsFetchProfileDefinition(name);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public SessionFactoryOptions getSessionFactoryOptions() {
		return getHibernateSessionFactory().getSessionFactoryOptions();
	}

	@Override
	public TypeHelper getTypeHelper() {
		return getHibernateSessionFactory().getTypeHelper();
	}

	@Override
	public SessionBuilder withOptions() {
		return getHibernateSessionFactory().withOptions();
	}

	@Override
	public StatelessSessionBuilder withStatelessOptions() {
		return getHibernateSessionFactory().withStatelessOptions();
	}

	// public Session openSession(Interceptor interceptor)
	// throws HibernateException {
	// return getHibernateSessionFactory().openSession(interceptor);
	// }
	//
	// public Session openSession(Connection connection) {
	// return getHibernateSessionFactory().openSession(connection);
	// }
	//
	// public Session openSession(Connection connection, Interceptor
	// interceptor) {
	// return getHibernateSessionFactory().openSession(connection,interceptor);
	// }
}
