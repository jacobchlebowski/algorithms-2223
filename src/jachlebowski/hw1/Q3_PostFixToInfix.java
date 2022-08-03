package jachlebowski.hw1;

import algs.days.day04.FixedCapacityStack;
import edu.princeton.cs.algs4.*;

/**
 * Complete this implementation that takes a postfix expression and converts it into
 * an Infix Expression using a fixed Capacity stack. Also perform the necessary 
 * computation to produce its value
 * 
 * Using the postfix expression as input
 * 
 *     3 6 + 5 * 8 2 - /
 *  
 * should produce the following as output:
 * 
 *     (((3 + 6) * 5) / (8 - 2)) = 7.5
 *
 * Note that postfix expressions do not need parentheses, which is one of their
 * major selling points.
 */
public class Q3_PostFixToInfix {
	
	
	
	public static void main(String[] args) {
		
		FixedCapacityStack<String> exprs = new FixedCapacityStack<String>(100);
		FixedCapacityStack<Double> vals = new FixedCapacityStack<Double>(100);
		
		double second=0;
		double first=0;
		double eval=0;
		String secondE="";
		String firstE="";
		while (!StdIn.isEmpty()) {
		String s = StdIn.readString();	
//		if(!(exprs.isEmpty())) {
//			String pop = exprs.pop();
//		}
		
		//if operand, push into stack
		if((s.equals("1"))||(s.equals("2"))||(s.equals("3"))||(s.equals("4"))||(s.equals("5"))||(s.equals("6"))||(s.equals("7"))||(s.equals("8"))|(s.equals("9"))) { vals.push(Double.parseDouble(s));
																																									exprs.push(s);}
		
		//if operator, pop top 2 values from stack
		else if (s.equals ("+")) {
			second = vals.pop();
			first = vals.pop();
			secondE=exprs.pop();
			firstE=exprs.pop();
			eval = first+second;
			exprs.push("(" + firstE + " + " + secondE + ")");
			vals.push(eval);
		}
		else if (s.equals ("-")) {
			second = vals.pop();
			first = vals.pop();
			secondE=exprs.pop();
			firstE=exprs.pop();
			eval = first-second;
			exprs.push("(" + firstE + " - " + secondE + ")");
			vals.push(eval);
		}
		else if (s.equals ("*")) {
			second = vals.pop();
			first = vals.pop();
			secondE=exprs.pop();
			firstE=exprs.pop();
			eval = first*second;
			exprs.push("(" + firstE + " * " + secondE + ")");
			vals.push(eval);
		}
		else if (s.equals ("/")) {
			second = vals.pop();
			first = vals.pop();
			secondE=exprs.pop();
			firstE=exprs.pop();
			eval = first/second;
			exprs.push("(" + firstE + " / " + secondE + ")");
			vals.push(eval);
		}
		
		
		}

		
		StdOut.print(exprs.pop() + " = " + vals.pop());
		
	}
		
	

}
