package hotel.sessionfactory;

import org.hibernate.SessionFactory;

public interface DynamicSessionFactoryInf extends SessionFactory {  
	  
    public SessionFactory getHibernateSessionFactory();  
}  