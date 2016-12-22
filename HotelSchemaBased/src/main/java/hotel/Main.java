package hotel;

import java.text.SimpleDateFormat;
import java.util.Date;

import hotel.model.Guest;
import hotel.service.GuestService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 * @Author Juannyoh
	 * 2016-12-13下午5:26:44
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		context.start();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GuestService guestService=(GuestService) context.getBean("guestService");
		
		Guest guest = new Guest();
		guest.setName("张三");
		guest.setTelephone("56785678");
		guest.setAddress("上海市张扬路88号");
		guest.setEmail("zhangsan@gmail.com");
		guest.setCreattime(sdf.format(new Date()));
		
		
//		guestService.saveGuest(guest);
		
//		guestService.queryAll();

	}

}
