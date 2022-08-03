package jachlebowski.hw4;

import algs.days.day04.FixedCapacityStack;
import edu.princeton.cs.algs4.StdIn;

public class Q1 {
	/**
	 * Complete this implementation that takes a postfix expression string and converts it into
	 * an Expression node using a fixed Capacity stack. When done, an Expression node will
	 * be returned.
	 * 
	 * Using the postfix expression as input
	 * 
	 *     3 1 + 4 / 1 5 + 9 * 2 6 * - *
	 *  
	 * should produce the expression from the homework, namely
	 * 
	 *     (((3+1)/4 * (((1+5)*9)-(2*6)))
	 *
	 * Note that postfix expressions do not need parentheses, which is one of their
	 * major selling points.
	 */
	public static void main(String[] args) {

		// since everything IS an expression (even Values) you only need a single stack.
		FixedCapacityStack<Expression> exprs = new FixedCapacityStack<Expression>(100);
		
		//USE FORMAT() and EVAL()? 
		
		while (!StdIn.isEmpty()) {
			// Read token. push if operator.
			String s = StdIn.readString();
			if((s.equals("0"))||(s.equals("1"))||(s.equals("2"))||(s.equals("3"))||(s.equals("4"))||(s.equals("5"))||(s.equals("6"))||(s.equals("7"))||(s.equals("8"))||(s.equals("9"))) {
				int v = Integer.parseInt(s);
				Value val = new Value(v);
				exprs.push(val);
			}
			else if(s.equals("+")) {
				Expression right = exprs.pop();
				Expression left = exprs.pop();
				exprs.push(new Add(left,right));
			}
			else if(s.equals("-")) {
				Expression right = exprs.pop();
				Expression left = exprs.pop();
				exprs.push(new Subtract(left,right));
			}
			else if(s.equals("*")) {
				Expression right = exprs.pop();
				Expression left = exprs.pop();
				exprs.push(new Multiply(left,right));
			}
			else if(s.equals("/")) {
				Expression right = exprs.pop();
				Expression left = exprs.pop();
				exprs.push(new Divide(left,right));
			}
		}
		// fill in here...
		Expression pop = exprs.pop();
		System.out.println(pop.format() + " = " + pop.eval());	
		System.out.println("Height: " + pop.height());
	}
}
