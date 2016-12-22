package hotel.service;

import hotel.dao.GuestDao;
import hotel.model.Guest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("guestService")
public class GuestServiceImpl implements GuestService {
	
	@Resource
    public	GuestDao guestDao;

	@Override
	@Transactional
	public void saveGuest(Guest guest) {
		this.guestDao.addGuest(guest);
	}

	@Override
	@Transactional
	public List<Guest> queryAll() {
		return this.guestDao.getGuests();
	}

}
