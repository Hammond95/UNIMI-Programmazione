import java.io.*;
import java.util.*;

public class ContaNumeri {
	
	public static void main (String args[]){
		
		Scanner in = new Scanner(System.in);
		int cint=0, cflo=0;
		while(in.hasNext()){
			String line = in.next();
			if(isValidInteger(line)){
				cint++;
			} else if (isValidFloat(line)){
				cflo++;
			}
		}
		in.close();
		System.out.println("interi: "+cint);
		System.out.println("floating: "+cflo);
	}

	public static boolean isValidInteger(String value){
		String pattern = "^[+-]?[0-9]+";
		return value.matches(pattern);
	}
	
	public static boolean isValidFloat(String value){
		String pattern = "^[+-]?[0-9]+[.][0-9]+";
		return value.matches(pattern);
	}
}
