package test;

import java.util.HashMap;
import java.util.Iterator;

public class GoodCode {
	
	
	public static double expSum(double[] vec){
		double sum=0;
		for(int i=0;i<vec.length;i++)
			sum+= exp(vec[i]);
		return sum;
	}
	
	public static double exp(double z){
		return Math.exp(z);
	}
	
	static HashMap<Double, Double> map=new HashMap<>();
	public static double[] softmaxOpt(double[] vec){
		int vecLen = vec.length;
		double[] prop=new double[vecLen];
		double sum = 0;
		double res0, res1;
		for(int i=0;i<vecLen;i+=2) {
			res0 = Math.exp(vec[i]);
			res1 = Math.exp(vec[i+1]);
			
			sum+= res0;
			sum+= res1;
			
			map.put(vec[i],res0);
			map.put(vec[i+1],res1);
			
		}
		
		for(int i=0;i<vecLen;i+=2) {
			prop[i]=map.get(vec[i])/sum;
			prop[i+1]=map.get(vec[i+1])/sum;
		}
		return prop;		
	}
	 
}
