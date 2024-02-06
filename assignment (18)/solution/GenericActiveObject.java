package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GenericActiveObject {
    Object o;
    HashMap<String,ParamRunnable> map;
    ExecutorService es;
    public GenericActiveObject(Object o){
        this.o = o;
        map=new HashMap<>();
        for(Method m : o.getClass().getMethods()){
            map.put(m.getName(), args->{            
            try {
                m.invoke(o, args);
            } catch (IllegalAccessException | InvocationTargetException e) {}
            });
        }
        es=Executors.newSingleThreadExecutor();
    }

    public void execute(String name, Object...args){
        es.execute(()->map.get(name).run(args));
    }

    public void shutdown(){
        es.shutdown();
    }


}
