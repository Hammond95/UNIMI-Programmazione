import java.io.*;
import java.util.*;
import java.lang.NumberFormatException;
import java.lang.ArithmeticException;

public class CalcolatriceRPN {

	Double acc = null;

	public static void main (String args[]){
		CalcolatriceRPN crpn = new CalcolatriceRPN();
		crpn.calculate(args);
	}

	public void calculate (String[] formula){
		
		Stack<Double> op = new Stack<Double>();

		for(String a : formula){
			if(a.matches("^[+-]?([0-9]+[.])?[0-9]+$")){
				try{
					if(a.contains(".")){
						op.push(Double.parseDouble(a));
					} else {
						op.push(Double.parseDouble(a+".0"));
					}
				} catch(NumberFormatException e){
					e.printStackTrace();
				}
			}
			if(isOpSymbol(a)){
				switch(a.charAt(0)){
					case '+' : add(op); break;
					case '*' : mul(op); break;
					case '-' : sub(op); break;
					case '/' : div(op); break;
					default: throw new ArithmeticException("Operation "+a+" is not recognized.");
				}
			}
		}

		System.out.println(acc);
	}

	private void add(Stack<Double> op){
		if(acc==null){
			acc = 0.0;
		}
		
		while(!op.empty()){
			acc += op.pop();
		} 
	}

	private void sub(Stack<Double> op){
		if(acc==null){
			acc = 0.0;
		}
		while(!op.empty()){
			acc = acc-op.pop();
		}
	}

	private void mul(Stack<Double> op){
		if(acc==null){
			acc = 1.0;
		}
		while(!op.empty()){
			acc *= op.pop();
		}
	}

	private void div(Stack<Double> op){
		if(acc==null){
			acc = 1.0;
		}
		while(!op.empty()){
			Double pop = op.pop();
			if(pop.equals(0.0)){
				throw new ArithmeticException("Division By 0 is not allowed!");
			} else {
				acc = acc/pop;
			}
		}
	}

	private boolean isOpSymbol(String s){
		return ("+-*/".indexOf(s) >= 0);
	}
}
