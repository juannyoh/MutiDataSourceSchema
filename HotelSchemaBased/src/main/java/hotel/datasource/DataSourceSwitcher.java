package hotel.datasource;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.util.Assert;  

public class DataSourceSwitcher {  
    @SuppressWarnings("rawtypes")  
    private static final ThreadLocal contextHolder = new ThreadLocal();  
  
    @SuppressWarnings("unchecked")  
    public static void setDataSource(String dataSource) {  
        Assert.notNull(dataSource, "dataSource cannot be null");  
        contextHolder.set(dataSource);  
    }  
  
    public static void setMaster(){  
        clearDataSource();  
    }  
      
    public static void setSlave() {  
    	String slaves="slave"+(RandomUtils.nextInt(2)+1);
    	System.out.println("切换读库："+slaves);
        setDataSource(slaves);  
    }  
      
    public static String getDataSource() {  
        return (String) contextHolder.get();  
    }  
  
    public static void clearDataSource() {  
        contextHolder.remove();  
    }  
}  
