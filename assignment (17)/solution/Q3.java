package test;

public class Q3 {
    

    public static int[] goodSumCols(int[][] matrix){
		
        int[] vec=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<vec.length;j++){
                int x=matrix[i][j];
                vec[j]+=(x>0?x:-x);
            }
        }
        return vec;
		
		
    }

}
