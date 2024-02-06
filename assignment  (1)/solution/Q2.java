package test;

import java.util.HashMap;

public class Q2 {
	
	static HashMap<Double, Double> map=new HashMap<>();
	public static double px(double x, double[] vec){
		if(map.containsKey(x))
			return map.get(x);
		int count=0;
		for(int i=0;i<vec.length;i++)
			if(x==vec[i])
				count++;
		
		double res=(double)count/vec.length;
		map.put(x,res);
		
		return res;
	}
	
	static double log102=Math.log10(2);
	public static double log2(double x){
		return Math.log10(x)/log102;
	}
	

	public static double OPT_Hx(double[] vec){
		double sum0=0,sum1=0;
		for(int i=0;i<vec.length/2;i++) {
			double p0=px(vec[i],vec);
			double p1=px(vec[i+vec.length/2],vec);
			sum0+=p0*log2(p0);
			sum1+=p1*log2(p1);
		}
		
		return -sum0-sum1;		
	}
}
