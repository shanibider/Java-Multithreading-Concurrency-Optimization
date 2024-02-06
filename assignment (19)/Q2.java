package test;

import java.util.concurrent.RecursiveTask;
//data=[1,2,3,4,5,6]
//left=[1,2,3]  right=[4,5,6]

//calculate min value in data array
public class Q2 extends RecursiveTask<Integer> {
    int[] data;

    public Q2(int[] data) {
        this.data = data;
    }

    @Override
    protected Integer compute() {

        if (data.length == 1)
            return data[0];

        if (data.length == 2)
            return Math.max(data[0], data[1]);


        int midSize = data.length / 2;        //3

        int[] left = new int[midSize];
        for (int i = 0; i < midSize; i++) {
            left[i] = data[i];
        }

        int[] right = new int[midSize];
        for (int i = 0; i < midSize; i++) {
            right[i] = data[i + midSize];
        }

        Q2 qleft = new Q2(left);
        Q2 qright = new Q2(right);

        qright.fork();

        return Math.max(qleft.compute(), qright.join());

    }
}
