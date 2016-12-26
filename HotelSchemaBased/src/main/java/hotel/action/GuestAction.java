package hotel.action;

import hotel.Login;
import hotel.model.Guest;
import hotel.service.GuestService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("guest")
public class GuestAction {

	@Resource
	private GuestService guestService;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@RequestMapping("save")
	@ResponseBody
	public Map<String,Object> save(String tenantId){
		Login.setTenantId(tenantId);
		Map<String,Object> map=new HashMap<String,Object>();
		Guest guest=new Guest();
		guest.setAddress("addder");
		guest.setCreattime(sdf.format(new Date()));
		guest.setEmail("emails--");
		guest.setName("namer:"+Login.getTenantId());
		guest.setTelephone("13520033252");
		this.guestService.saveGuest(guest);
		map.put("success", true);
		map.put("result", "添加");
		return map;
	}
	
	@RequestMapping("query")
	@ResponseBody
	public Map<String,Object> query(String tenantId){
		Map<String,Object> map=new HashMap<String,Object>();
		Login.setTenantId(tenantId);
		List<Guest> list=this.guestService.queryAll();
		map.put("success", true);
		map.put("result", list);
		return map;
	}
	
	
	@RequestMapping("update")
	@ResponseBody
	public Map<String,Object> update(String tenantId){
		Login.setTenantId(tenantId);
		Map<String,Object> map=new HashMap<String,Object>();
		this.guestService.updateMethod();
		map.put("success", true);
		map.put("result", "修改");
		return map;
	}
}
