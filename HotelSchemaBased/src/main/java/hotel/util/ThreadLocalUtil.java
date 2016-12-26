package hotel.util;

public class ThreadLocalUtil {

	/*private final static ThreadLocal<ThreadVariables> THREAD_VARIABLES = new ThreadLocal<ThreadVariables>() {
		*//**
		 * @see java.lang.ThreadLocal#initialValue()
		 *//*
		@Override
		protected ThreadVariables initialValue() {
			return new ThreadVariables();
		}
	};

	public static Object getThreadVariable(String name) {
		return THREAD_VARIABLES.get().get(name);
	}

	public static Object getThreadVariable(String name,
			InitialValue initialValue) {
		Object o = THREAD_VARIABLES.get().get(name);
		if (o == null) {
			THREAD_VARIABLES.get().put(name, initialValue.create());
			return getThreadVariable(name);
		} else {
			return o;
		}
	}

	public static void setThreadVariable(String name, Object value) {
		THREAD_VARIABLES.get().put(name, value);
	}

	public static void destroy() {
		THREAD_VARIABLES.remove();
	}*/
	
	public final static String SESSION_FACTORY_S1 = "s1_sessionFactory";
    public final static String SESSION_FACTORY_S2 = "s2_sessionFactory";
    
    
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
    
    public static void setSessionFacotyName(String sessionFacotyName) {  
        contextHolder.set(sessionFacotyName);  
    }  
      
    public static String getSessionFacotyName() {  
        return contextHolder.get();  
    }  
      
    public static void clearSessionFacotyName() {  
        contextHolder.remove();  
    }  
}
