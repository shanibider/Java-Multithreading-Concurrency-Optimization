package test;
import java.util.Random;

//[1,5,5,5,3,4]
public class MainTrain3 {

    //most common frequency in array
    // bad code...
    public static int badMostFreq(int[] arr) {
        int max = 0;
        int r = 0;

        for (int a : arr) {
            int aFreq = 0;
            for (int b : arr) {
                if (a == b) {
                    aFreq++;        //=2
                }
            }
            if (max < aFreq) {
                max = aFreq;        //max=2
                r = a;              //r=5
            }
        }
        return r;
    }









    public static void main(String[] args) {
        Random r = new Random();
        int N = 10000;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = r.nextInt(100);
        }


        long t0 = System.nanoTime();
        int s = badMostFreq(arr);
        long db = System.nanoTime() - t0;

        t0 = System.nanoTime();
        int sq3 = Q3.mostFreq(arr);
        long dg = System.nanoTime() - t0;

        if (sq3 != s) {
            System.out.println("your code didn't get the desired result (-25)");
            System.out.println("done");
            return;
        }

        System.out.println("~bad time:\t" + db);
        System.out.println("~good time:\t" + dg);
        double ratio = (double) db / (double) dg;
        System.out.println("~ratio: " + ratio);

        if (ratio < 20) {
            int grade = (int) Math.round(25 * ratio / 20.0);
            if (grade < 25)
                System.out.println("you can write a faster code (-" + (25 - grade) + ")");
        }


        System.out.println("done");
    }

}