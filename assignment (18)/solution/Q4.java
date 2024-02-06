package test;

import java.util.ArrayList;

public class Q4 {

	// good code...
    public static int goodCode(int[] arr,int val){
        ArrayList<Integer> al=new ArrayList<>(arr.length);
        for(int a : arr)    // O(N)
            al.add(a);
        
        al.sort((x,y)->x-y); // O(NlogN)
 
        return Math.abs(val - al.get(al.size()/2));
    }

}
