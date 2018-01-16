import java.io.*;
import java.util.*;
import java.lang.NumberFormatException;

public class Calcolatrice {

	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		
		double acc = 0.0;

		while(in.hasNextLine()){
			String line = in.nextLine();
			
			String op = line.split(" ")[0];
			if(op.equals("E")) break;
			
			String val = line.split(" ")[1];

			try{
				double dval = Double.parseDouble(val);
				switch (op.charAt(0)){
					case '+': 	acc+=dval;
								break;
					case '-':	acc-=dval;
								break;
					case '*':	acc*=dval;
								break;
					case '/':	if(dval==0.0){
									System.out.println("divisione per zero");
								} else {
									acc=acc/dval;
								}
								break;
					case 'S':	acc=dval;
								break;
					default:	System.out.println("operatore sconosciuto");
				}
				System.out.println("= "+acc);
			}
			catch(NumberFormatException e){
				continue;
			}
		}
	}
}
