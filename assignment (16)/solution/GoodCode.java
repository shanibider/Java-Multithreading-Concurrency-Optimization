
package test;

import java.util.List;

public class GoodCode {

	private static double dist2(Point2D a, Point2D b) {
		return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
	}
	

	public static double getMaxDist(List<Point2D> ps) {
		double max=0;
		
		for(int i=0;i<ps.size();i++) {
			for(int j=i+1;j<ps.size();j++) {
				double d = dist2(ps.get(i),ps.get(j));
				if(max<d)
					max=d;
			}
		}
		
		return Math.sqrt(max);
		
	}
	


}
