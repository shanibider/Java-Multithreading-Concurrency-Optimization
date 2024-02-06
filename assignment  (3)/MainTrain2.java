import java.util.Arrays;
import java.util.List;

public class MainTrain2 {
	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		ThreadCounter tc=new ThreadCounter();
		tc.start();
		int count = Q2.parallelCountIf(list, x->x%2==0, 2);
		int numOfThreadsOpened=tc.stopAndGet();
		if(numOfThreadsOpened!=3) // main + 2 threads
			System.out.println("wrong number of open threads (-20)");
		
		if(count!=5)
			System.out.println("wrong number of elements counted (-20)");
		
		
		System.out.println("done");
	}

}
