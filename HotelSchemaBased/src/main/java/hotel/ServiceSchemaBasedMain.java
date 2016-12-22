package hotel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import hotel.model.Guest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ServiceSchemaBasedMain {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		try {
			Configuration configuration = new Configuration().configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Session session = null;
		Guest guest =null;
		List<Guest> list = null;
		Transaction tx = null;

		System.out.println("======== 租户 egisp_dev ========");
		Login.setTenantId("egisp_dev1");
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		guest = new Guest();
		guest.setName("张三");
		guest.setTelephone("56785678");
		guest.setAddress("上海市张扬路88号");
		guest.setEmail("zhangsan@gmail.com");
		guest.setCreattime(sdf.format(new Date()));
		session.saveOrUpdate(guest);
		list = session.createCriteria(Guest.class).list();
		for (Guest gue : list) {
			System.out.println(gue.toString());
		}
		tx.commit();
		session.close();
		

		System.out.println("======== 租户 egisp_dev2 ========");
		Login.setTenantId("egisp_dev2");
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		guest = new Guest();
		guest.setName("李四");
		guest.setTelephone("23452345");
		guest.setAddress("上海市南京路100号");
		guest.setEmail("lisi@gmail.com");
		guest.setCreattime(sdf.format(new Date()));
		session.saveOrUpdate(guest);
		list = session.createCriteria(Guest.class).list();
		for (Guest gue : list) {
			System.out.println(gue.toString());
		}
		tx.commit();
		session.close();
	}

}
