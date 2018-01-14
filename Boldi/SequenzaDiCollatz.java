import java.io.*;

public class SequenzaDiCollatz {

	public static void main (String args[]){
		if(args.length==1){
			System.out.println("Steps: "+SequenzaDiCollatz.collatz(Long.parseLong(args[0])));
		} else {
			SequenzaDiCollatz.getMax(Long.parseLong(args[0]),Long.parseLong(args[1]));
		}
	}

	public static int collatz(long x){
		int steps=1;
		while(x>1){
			System.out.println(x);
			x = (x%2==0) ? x/2 : x*3+1;
			steps++;
		}
		System.out.println(x);
		return steps;
	}

	public static void getMax(long from, long to){
		long maxN=0;
		int maxSteps=0;
		while(to>from){
			int steps = collatz(from);
			if(steps>maxSteps){
				maxN=from;
				maxSteps=steps;
			}
			from--;
		}
		System.out.println("Il massimo è: "+maxN+", con "+maxSteps+" passi.");
	}
	

}
