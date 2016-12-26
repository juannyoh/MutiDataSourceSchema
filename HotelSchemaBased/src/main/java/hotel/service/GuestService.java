package hotel.service;

import java.util.List;

import hotel.model.Guest;

public interface GuestService {
	
	public void saveGuest(Guest guest);
	
	public List<Guest> queryAll();
	
	
	public void updateMethod();

}
