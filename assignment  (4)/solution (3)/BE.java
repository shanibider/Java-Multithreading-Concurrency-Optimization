package test;

public class BE extends MyRecursiveTask<Double> implements Expression{
	
	private static final long serialVersionUID = 1L;		
	
	protected Expression left,right;
	
	char operator;
	
	
	public BE(char operator,Expression left, Expression right) {
		this.left=left;
		this.right=right;
		this.operator=operator;
	}
	
	@Override
	public Double calculate() {
		return compute();
	}
	@Override
	protected Double compute() {
		double r=0;
		if(right instanceof BE)
			((BE)(right)).testFork();
		else
			r=right.calculate();
		
		double result=left.calculate();
		
		if(right instanceof BE)
			r=((BE)(right)).join();
		
		switch(operator){
		case '+': result+= r; break;
		case '-': result-= r; break;
		case '*': result*= r; break;
		case '/': result/= r; break;
		}
		return result;
	}
	
}
