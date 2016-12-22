package hotel.dao;

import java.util.List;

import hotel.model.Guest;

public interface GuestDao {
	
	public void addGuest(Guest guest);
	
	public List<Guest> getGuests();
}
