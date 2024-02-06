package test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Count {
	int[] countArr;
	
	
	public Count(int size) {
		countArr= new int[size];
		Arrays.fill(countArr, 0);		
	}
	
	public  void inc(){
		for (int i = 0; i < countArr.length; i++) 
			countArr[i]++;		
	}
	
	public  void dec() {
		for (int i = 0; i < countArr.length; i++) 
			countArr[i]--;		
	}
	
	public int get(int index) {	
		return countArr[index];
	}
}
