package hotel.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import hotel.Login;
import hotel.model.Guest;
import hotel.util.ThreadLocalUtil;

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
		String sessionfactorys[]={"s1_sessionFactory","s2_sessionFactory"};
		String egispdevs[]={"egisp_dev1","egisp_dev2"};
		for(int i=0;i<10000;i++){
			String sessionfactoryname=sessionfactorys[RandomUtils.nextInt(2)];
			String egispdev=egispdevs[RandomUtils.nextInt(2)];
			Login.setTenantId(egispdev);
//			ThreadLocalUtil.setSessionFacotyName(sessionfactoryname);
			Guest guest=new Guest();
			guest.setAddress("addr--"+(i+1)+"--");
			guest.setCreattime(sdf.format(new Date()));
			guest.setEmail("session@supermap.cloud");
			guest.setName("name:"+egispdev);
			guest.setTelephone("13605124512");
			this.guestService.saveGuest(guest);
			Login.setTenantId(egispdev);
			System.out.println("#####"+"####"+guest);
		}
	}

//	@Test
	public void testQueryAll() {
		ThreadLocalUtil.setSessionFacotyName(ThreadLocalUtil.SESSION_FACTORY_S1);
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

//	@Test
	public void testSpecial(){
		Login.setTenantId("egisp_dev");
		guestService.updateMethod();
	}
	
}
