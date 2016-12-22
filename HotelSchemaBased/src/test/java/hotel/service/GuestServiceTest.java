package hotel.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import hotel.Login;
import hotel.model.Guest;

import javax.annotation.Resource;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class GuestServiceTest {
	
	@Resource
	private GuestService guestService;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Test
	public void testSaveGuest() {
		Login.setTenantId("egisp_dev");
		Guest guest=new Guest();
		guest.setAddress("zzzz");
		guest.setCreattime(sdf.format(new Date()));
		guest.setEmail("zzz@supermap.cloud");
		guest.setName("namezz");
		guest.setTelephone("13605124512");
		this.guestService.saveGuest(guest);
	}

	@Test
	public void testQueryAll() {
		String egispdevs[]={"egisp_dev","egisp_dev1","egisp_dev2"};
		for(int k=0;k<10;k++){
			String egispdev=egispdevs[RandomUtils.nextInt(3)];
			Login.setTenantId(egispdev);
			List<Guest> guestlist=this.guestService.queryAll();
			for(int i=0;i<guestlist.size();i++){
				System.out.println("****第"+(k+1)+"次*****读取："+egispdev+"******"+guestlist.get(i).toString());
			}
		}
	}

}
