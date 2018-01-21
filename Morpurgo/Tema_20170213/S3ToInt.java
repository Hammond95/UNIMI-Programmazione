import java.io.*;
import java.util.*;
import java.lang.Math;

public class S3ToInt {
	
	public static void main (String args[]){
		if(args.length==1){
			if(isValidS3(args[0])){
				System.out.println(toInt(args[0]));
			} else {
				System.out.println("input non valido");
			}
		}
	}

	public static boolean isValidS3(String in){
		String pattern="[duz]+";
		return in.matches(pattern);
	}

	public static int toInt (String s3){
		char[] charS3 = s3.toCharArray();
		int val=0, len=s3.length();
		
		while(len>0){
			int cVal=0;
			double esp = (double) (s3.length()-len);
			int baseEsp = (int) Math.pow(3.0, esp);
			char c = charS3[len-1];
			switch(c){
				case 'u': cVal=1; break;
				case 'd': cVal=2; break;
				default : break;
			}
			val+=cVal*baseEsp;
			len--;
		}
		
		return val;		
	}
}
