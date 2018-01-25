import java.io.*;
import java.util.*;

public class ParoleCrescenti {

	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		int c=0;
		while(in.hasNext()){
			if(isCrescente(in.next()))
				c++;
		}
		in.close();

		System.out.println(c);
	}

	public static boolean isCrescente (String word){
		int len = word.length();

		if(len<2){
			return true;
		} else {
			for(int i=0; i<len-1; i++){
				if(word.charAt(i+1)<=word.charAt(i))
					return false;
			}
			return true;
		}
	}
}
