package test;

import java.util.Random;


public class MainTrain4 {
    // bad code...
    public static int[][] naiveMatrixMul(int[][] A, int[][] B) {
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










    public static void main(String[] args) {
        Random r = new Random();
        int N = 1000;
        int M = 1001;
        int[][] a = new int[N][M];
        int[][] b = new int[M][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                a[i][j] = -50 + r.nextInt(101);
                b[j][i] = -50 + r.nextInt(101);
            }


        long t0 = System.nanoTime();
        int[][] C = naiveMatrixMul(a, b);
        long db = System.nanoTime() - t0;

        t0 = System.nanoTime();
        int[][] C2 = Q4.cacheFriendlyMatrixMul(a, b);
        long dg = System.nanoTime() - t0;

        if (C2 == null || C2.length != C.length || C2[0].length != C[0].length) {
            System.out.println("your code didn't get the desired result (-25)");
            System.out.println("done");
            return;
        }

        boolean eq = true;
        out:
        for (int i = 0; i < C.length; i++)
            for (int j = 0; j < C[0].length; j++)
                if (C[i][j] != C2[i][j]) {
                    eq = false;
                    break out;
                }

        if (!eq) {
            System.out.println("your code didn't get the desired result (-25)");
            System.out.println("done");
            return;
        }

        System.out.println("~bad time:\t" + db);
        System.out.println("~good time:\t" + dg);
        double ratio = (double) db / (double) dg;
        System.out.println("~ratio: " + ratio);

        if (ratio < 2) {
            int grade = (int) Math.round(25 * ratio / 2.0);
            if (grade < 25)
                System.out.println("you can write a faster code (-" + (25 - grade) + ")");
        }


        System.out.println("done");
    }

}