package test;

import java.util.concurrent.ConcurrentHashMap;

public class Singleton {
	

	static ConcurrentHashMap<String, Object> map=new ConcurrentHashMap<>();
	
	public static <V> V getInstance(Class<V> c) throws Exception{
		if(!map.containsKey(c.getName())){
			synchronized (map) {
				if(!map.containsKey(c.getName())){
					map.put(c.getName(), c.newInstance());
				}
			}			
		}
		return (V)map.get(c.getName());
	}
}
