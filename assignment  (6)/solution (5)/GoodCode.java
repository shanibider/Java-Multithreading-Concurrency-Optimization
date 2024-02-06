package test;

public class GoodCode {

	private static double average(int[] array){

		int sum=0; // sum the values
		for(int i=0;i<array.length;i++){
			sum+=array[i];		
		}
		
		return (double)(sum)/(array.length); // average 
	}
	
	// returns the squared distance of each value from the average 
	public static double[] dists(int[] array){
		double[] r=new double[array.length];
		double avg=average(array);
		for(int i=0;i<r.length;i++)
			r[i]=(array[i]-avg)*(array[i]-avg);
		return r;
	}
}
