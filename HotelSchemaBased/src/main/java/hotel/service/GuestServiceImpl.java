package hotel.service;

import hotel.dao.GuestDao;
import hotel.model.Guest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("guestService")
@Transactional(rollbackFor=Exception.class)
public class GuestServiceImpl implements GuestService {
	
	@Resource
    public	GuestDao guestDao;

	@Override
	public void saveGuest(Guest guest) {
		this.guestDao.addGuest(guest);
	}

	@Override
	public List<Guest> queryAll() {
		return this.guestDao.getGuests();
	}

	@Override
	public void updateMethod() {
		System.out.println("----special-----");
		
	}

}
