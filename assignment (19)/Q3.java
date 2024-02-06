package test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//most common frequency in array
public class Q3 {
    //arr=[2,5,5,5]
//freqArr=[0,0,1,0,0,3]
/*
[2,1]
[5,3]
*/
    public static int mostFreq(int[] arr) {
        int max = 0;
        int r = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            //check if already checked value (optimized)
            if (!map.containsKey(arr[i])) {
                count = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;        //=2
                    }

                }
                map.put(arr[i], count);
            }


            if (max < count) {
                max = count;        //max=2
                r = arr[i];              //r=5
            }
        }
        return r;
    }
}

