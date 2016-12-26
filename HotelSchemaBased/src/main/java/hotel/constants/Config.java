package hotel.constants;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {
	
	@Value("#{configParam['specialServiceList_path']}")
	private  String specialServicelistPath;
	
	
	public String getSpecialServicelistPath() {
		return specialServicelistPath;
	}

	public void setSpecialServicelistPath(String specialServicelistPath) {
		this.specialServicelistPath = specialServicelistPath;
	}
	
	
	
}
