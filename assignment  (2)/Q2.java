package test;

public class Q2 {

    // the original code:
	public static double avg(double[] x){
		double sum=0;
		for(int i=0;i<x.length;i++)
			sum+=x[i];
		return sum/x.length;
	}
	
	public static double pearson(double[] x,double[] y){
		if(x.length==y.length){
			double sumXY=0, sumX=0, sumY=0;
			for(int i=0;i<x.length;i++){
				sumXY+=(x[i]-avg(x))*(y[i]-avg(y));
				sumX+=Math.pow((x[i]-avg(x)),2);
				sumY+=Math.pow((y[i]-avg(y)),2);
			}
			return sumXY/Math.sqrt(sumX*sumY);
		}
		return 0;
	}
	

	
	public static void warmup(){
	}

}
