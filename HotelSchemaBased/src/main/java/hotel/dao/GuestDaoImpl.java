package hotel.dao;

import hotel.model.Guest;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component("guestDao")
public class GuestDaoImpl implements GuestDao {
	
//	@Resource
//	private SessionFactory sessionfactory;
	
	@Resource
    private HibernateTemplate template;
	
//	protected Session getSession() {
//		return sessionfactory.getCurrentSession();
//	}
	
	@Override
	public void addGuest(Guest guest) {
//		getSession().persist(guest);
		template.save(guest);
	}

	@Override
	public List<Guest> getGuests() {
//		List<Guest> list=getSession().createCriteria(Guest.class).list();
		List<Guest> list=template.loadAll(Guest.class);
		return list;
	}

}
