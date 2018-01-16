import java.io.*;
import java.util.*;
import java.lang.NumberFormatException;

public class PotenzeDiDue {

	public static void main (String args[]){
		int counter=0;
		for(int i=0; i<args.length; i++){
			try{
				int n = Integer.parseInt(args[i]);
				while(n%2==0 && n>1){
					n=n/2;
				}
				if(n==1)
					counter++;
			} catch (NumberFormatException e){
				continue;
			}
		}

		System.out.println(counter);
	}
}
