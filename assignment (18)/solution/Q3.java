package test;

public class Q3 {

    public static int goodContains(int[] arr,int val){
        int r=-1;
        for(int i=0;i<arr.length;i++)
            if(Math.abs(val-arr[i])==0)
                r=i;
        return r;
    }
    
}
