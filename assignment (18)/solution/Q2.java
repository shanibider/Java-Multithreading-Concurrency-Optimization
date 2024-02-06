package test;

import java.util.concurrent.RecursiveTask;

public class Q2 extends RecursiveTask<Integer>{
    int[] data;
    public Q2(int[] data){
        this.data=data;
    }

    @Override
    protected Integer compute() {
        if(data.length==2){
            return Math.max(data[0], data[1]);
        }
        if(data.length==1)
            return data[0];
        
        int mid=data.length/2;
        int[] left=new int[mid];
        for(int i=0;i<mid;left[i]=data[i],i++);
        int[] right=new int[mid];
        for(int i=mid;i<data.length;right[i-mid]=data[i],i++);
        Q2 ql=new Q2(left);
        Q2 qr=new Q2(right);
        qr.fork();
        return Math.max(ql.compute(),qr.join());
    }
    
}
