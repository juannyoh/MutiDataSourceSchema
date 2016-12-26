package hotel.constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class SpecialServiceConfig {
	
	
	public static Map<String,String> specialServiceMap=new HashMap<String,String>();
	
	public static  void getSpecialServices(){
		List<String> infos = null;
		try{
			File f = new File(Constants.SPECIAL_SERVICELIST_PATH);
			if(null != f && f.exists()){
				infos = Files.readLines(f, Charsets.UTF_8);
			}else{
				InputStream inStream = SpecialServiceConfig.class.getClassLoader().getResourceAsStream(Constants.SPECIAL_SERVICELIST_PATH);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inStream,"utf-8"));
				String buffer = null;
				infos = new ArrayList<String>();
				while((buffer = reader.readLine()) != null){
					infos.add(new String(buffer));
				}
				inStream.close();
				reader.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(infos!=null&&infos.size()>0){
			for(String sp:infos){
				String s[]=sp.split("=");
				specialServiceMap.put(s[0], s[1]);
			}
		}
	}
	
	static{
		getSpecialServices();
	}

	public static Map<String, String> getSpecialServiceMap() {
		return specialServiceMap;
	}

	public static void setSpecialServiceMap(Map<String, String> specialServiceMap) {
		SpecialServiceConfig.specialServiceMap = specialServiceMap;
	}
	

}
