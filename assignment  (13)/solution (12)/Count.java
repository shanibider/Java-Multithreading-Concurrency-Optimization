package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Count {
	//int[] countArr;
	//AtomicIntegerArray atomCountArr;
	ArrayList<AtomicInteger> arrAtomInt = new ArrayList<>();;
	
	public Count(int size) {
		//countArr= new int[size];
		//Arrays.fill(countArr, 0);
		//atomCountArr = new AtomicIntegerArray(countArr);	
		 
		for (int i = 0; i < size; i++) 
			arrAtomInt.add(new AtomicInteger(0));		
	}
	
	public  void inc() {
		for (int i = 0; i < arrAtomInt.size(); i++) 
			arrAtomInt.get(i).incrementAndGet();
			//countArr[i]++;
			//atomCountArr.incrementAndGet(i);	
	}
	
	public  void dec() {
		for (int i = 0; i < arrAtomInt.size(); i++) 
			arrAtomInt.get(i).decrementAndGet();
			//countArr[i]--;	
			//atomCountArr.decrementAndGet(i);			
	}
	
	public int get(int index) {
		return arrAtomInt.get(index).get();		
		//return countArr[index];
		//return atomCountArr.get(index);
	}
}
