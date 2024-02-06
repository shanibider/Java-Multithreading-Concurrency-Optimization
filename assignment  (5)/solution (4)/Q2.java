package test;

import java.util.Collections;
import java.util.List;

public class Q2 {
		
	
	public static int H(char[] a, char[] b,int min){
		int sum=Math.abs(a.length - b.length);

		final int minLen=Math.min(a.length,b.length); // code motion
		
		for(int i=0;i<minLen && sum<min;i++){ // if sum>=min no need to continue
			if(a[i]!=b[i])
				sum++;
		}
		
		return sum;
	}
	
	
	public static int findMinH(List<String> list){
		
		// pre-calculation
		char[][] carray=new char[list.size()][];
		for(int i=0;i<list.size();i++)
			carray[i]=list.get(i).toCharArray();
		
		int min=Integer.MAX_VALUE;		
		for(int i=0;i<carray.length;i++)
			for(int j=i+1;j<carray.length;j++){ // start from i+1 - symmetry				
				// cut useless calculations
				if(list.get(i).equals(list.get(j))) // intern uses memory and hash code calculation
					return 0; // this is the minimum possible result

				final char[] a=carray[i];
				final char[] b=carray[j];
				int sum=Math.abs(a.length - b.length);
				
				// cut useless calculations
				if(sum>min)
					continue;				
				
				// inline the H function
				int minLen=Math.min(a.length,b.length); // code motion
				
				for(int ii=0;ii<minLen && sum<min;ii++){ // if sum>=min no need to continue the calculation
					if(a[ii]!=b[ii])
						sum++;
				}
				//---- end of inline
				
				min=sum;
			}
		return min;		
	}
}
