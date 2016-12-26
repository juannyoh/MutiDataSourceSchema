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
//import org.hibernate.classic.Session;
//import org.hibernate.engine.FilterDefinition;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;

public class DynamicSessionFactoryImpl_bak implements DynamicSessionFactoryInf {

private static final long serialVersionUID = 5384069312247414885L;
    
    private Map<Object, SessionFactory> targetSessionFactorys;  
    private SessionFactory defaultTargetSessionFactory; 
    
    /**
     * @see com.hoo.framework.spring.support.core.DynamicSessionFactory#getHibernateSessionFactory()
     * <b>function:</b> 重写这个方法，这里最关键
     * @author hoojo
     * @createDate 2013-10-18 上午10:45:25
     */
    @Override
    public SessionFactory getHibernateSessionFactory() {
        SessionFactory targetSessionFactory = targetSessionFactorys.get(ThreadLocalUtil.getSessionFacotyName());  
        if (targetSessionFactory != null) {  
            return targetSessionFactory;  
        } else if (defaultTargetSessionFactory != null) {  
            return defaultTargetSessionFactory;  
        }  
        return null;
    }
 
 
    @Override
    public void close() throws HibernateException {
        this.getHibernateSessionFactory().close();
    }
 
    @Override
    public boolean containsFetchProfileDefinition(String s) {
        return this.getHibernateSessionFactory().containsFetchProfileDefinition(s);
    }
 
    @Override
    public void evict(Class clazz) throws HibernateException {
        this.getHibernateSessionFactory().evict(clazz);
    }
 
    @Override
    public void evict(Class clazz, Serializable serializable) throws HibernateException {
        this.getHibernateSessionFactory().evict(clazz, serializable);
    }
 
    @Override
    public void evictCollection(String s) throws HibernateException {
        this.getHibernateSessionFactory().evictCollection(s);
    }
 
    @Override
    public void evictCollection(String s, Serializable serializable) throws HibernateException {
        this.getHibernateSessionFactory().evictCollection(s, serializable);
    }
 
    @Override
    public void evictEntity(String entity) throws HibernateException {
        this.getHibernateSessionFactory().evictEntity(entity);
    }
 
    @Override
    public void evictEntity(String entity, Serializable serializable) throws HibernateException {
        this.getHibernateSessionFactory().evictEntity(entity, serializable);
    }
 
    @Override
    public void evictQueries() throws HibernateException {
        this.getHibernateSessionFactory().evictQueries();        
    }
 
    @Override
    public void evictQueries(String queries) throws HibernateException {
        this.getHibernateSessionFactory().evictQueries(queries);        
    }
 
    @Override
    public Map<String, ClassMetadata> getAllClassMetadata() {
        return this.getHibernateSessionFactory().getAllClassMetadata();
    }
 
    @Override
    public Map getAllCollectionMetadata() {
        return this.getHibernateSessionFactory().getAllClassMetadata();
    }
 
    @Override
    public Cache getCache() {
        return this.getHibernateSessionFactory().getCache();
    }
 
    @Override
    public ClassMetadata getClassMetadata(Class clazz) {
        return this.getHibernateSessionFactory().getClassMetadata(clazz);
    }
 
    @Override
    public ClassMetadata getClassMetadata(String classMetadata) {
        return this.getHibernateSessionFactory().getClassMetadata(classMetadata);
    }
 
    @Override
    public CollectionMetadata getCollectionMetadata(String collectionMetadata) {
        return this.getHibernateSessionFactory().getCollectionMetadata(collectionMetadata);
    }
 
    @Override
    public Session getCurrentSession() throws HibernateException {
        return this.getHibernateSessionFactory().getCurrentSession();
    }
 
    @Override
    public Set getDefinedFilterNames() {
        return this.getHibernateSessionFactory().getDefinedFilterNames();
    }
 
    @Override
    public FilterDefinition getFilterDefinition(String definition) throws HibernateException {
        return this.getHibernateSessionFactory().getFilterDefinition(definition);
    }
 
    @Override
    public Statistics getStatistics() {
        return this.getHibernateSessionFactory().getStatistics();
    }
 
    @Override
    public TypeHelper getTypeHelper() {
        return this.getHibernateSessionFactory().getTypeHelper();
    }
 
    @Override
    public boolean isClosed() {
        return this.getHibernateSessionFactory().isClosed();
    }
 
    @Override
    public Session openSession() throws HibernateException {
        return this.getHibernateSessionFactory().openSession();
    }
 
//    @Override
//    public Session openSession(Interceptor interceptor) throws HibernateException {
//        return this.getHibernateSessionFactory().openSession(interceptor);
//    }
 
//    @Override
//    public Session openSession(Connection connection) {
//        return this.getHibernateSessionFactory().openSession(connection);
//    }
 
//    @Override
//    public Session openSession(Connection connection, Interceptor interceptor) {
//        return this.getHibernateSessionFactory().openSession(connection, interceptor);
//    }
 
    @Override
    public StatelessSession openStatelessSession() {
        return this.getHibernateSessionFactory().openStatelessSession();
    }
 
    @Override
    public StatelessSession openStatelessSession(Connection connection) {
        return this.getHibernateSessionFactory().openStatelessSession(connection);
    }
 
    @Override
    public Reference getReference() throws NamingException {
        return this.getHibernateSessionFactory().getReference();
    }
 
    public void setTargetSessionFactorys(Map<Object, SessionFactory> targetSessionFactorys) {
        this.targetSessionFactorys = targetSessionFactorys;
    }
 
    public void setDefaultTargetSessionFactory(SessionFactory defaultTargetSessionFactory) {
        this.defaultTargetSessionFactory = defaultTargetSessionFactory;
    }


	@Override
	public SessionFactoryOptions getSessionFactoryOptions() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public SessionBuilder withOptions() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public StatelessSessionBuilder withStatelessOptions() {
		// TODO Auto-generated method stub
		return null;
	}

}
