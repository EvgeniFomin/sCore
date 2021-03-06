package EvgeniFomin.sCore.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class HandlerList {
	private static List<Listener> Handlers = new ArrayList<Listener>();

	public static <T> T callEvent(T e) {
	    Method[] methods;
	    for (Object o : Handlers) {
	        methods = o.getClass().getMethods();
	        for (Method m : methods) {
	            if (m.getAnnotation(EventHandler.class) != null) {
	                try {
	                    if (m.getParameterTypes()[0].isAssignableFrom(e.getClass())) {
	                        m.invoke(o, e);
	                    }
	                } catch (IllegalAccessException ex) {
	                	ex.printStackTrace();
	                } catch (IllegalArgumentException ex) {
	                	ex.printStackTrace();
	                } catch (InvocationTargetException ex) {
	                	ex.printStackTrace();
	                }
	            }
	        }
	    }
		return (T) e;
	}

	public static void registerEvent(Listener o) {
		Handlers.add(o);
	}

	public static void unregisterEvent(Listener o) {
		Handlers.remove(o);
	}
}