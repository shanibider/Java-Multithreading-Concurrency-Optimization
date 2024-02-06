package test;


public class Q4 {

    // good code...
    public static int[][] cacheFriendlyMatrixMul(int[][] A, int[][] B) {
        int n = A.length;           //row number
        int m = B[0].length;          //column number
        int[][] C = new int[n][m];

        for (int i = 0; i < n; i++) {           //row number
            for (int j = 0; j < m; j++) {       //column number
                int sum = 0;
                for (int k = 0; k < B.length; k++)
                    sum += A[i][k] * B[k][j];
                C[i][j] = sum;
            }
        }
        return C;
    }
}

