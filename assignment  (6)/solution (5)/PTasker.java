package test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BinaryOperator;

public class PTasker {

	ExecutorService es=Executors.newSingleThreadExecutor();
	
	public  <V> Future<V> apply(List<V> buff, V identity, BinaryOperator<V> bo){		
		return es.submit(()->buff.stream().reduce(identity,bo));
	}
	
	public void close(){
		es.shutdown();
	}
}
