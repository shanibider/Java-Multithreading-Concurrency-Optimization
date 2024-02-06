package test;

import java.util.concurrent.RecursiveTask;

public class Par extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;
	
	BinTree root;
	
	public Par(BinTree root) {
		this.root=root;
	}

	@Override
	protected Integer compute() {
		if(root.getLeft()!=null && root.getRight()!=null) {
			Par left=new Par(root.getLeft());
			left.fork();
			Par right=new Par(root.getRight());
			return root.get()+right.compute()+left.join();
		}
		else
			return root.get();
	}	

}
