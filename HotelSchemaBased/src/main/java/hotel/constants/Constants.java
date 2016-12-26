package hotel.constants;

import java.util.Properties;

import com.supermap.utils.AppPropertiesUtil;

public class Constants {
	
	private static Properties prop = AppPropertiesUtil.readPropertiesFile("config.properties",
			Constants.class);

	public static final String SPECIAL_SERVICELIST_PATH = prop.getProperty("specialServiceList_path");
}
