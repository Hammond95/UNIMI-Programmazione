import java.io.*;
import java.util.*;

public class ContaParoleConNumeri {

	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		
		int sum=0, digwords=0, words=0;
		while(in.hasNext()){
			String word = in.next();

			int digC = countDig(word);

			if(digC>0){
				sum+=digC;
				digwords++;
			} else {
				words++;
			}
		}

		System.out.println("parole con cifre: "+digwords);
		System.out.println("parole senza cifre "+words);
		System.out.println("numero totale di cifre "+sum);
	}		

	public static int countDig(String w){
		int digcnt=0;

		for(int i=0; i<w.length(); i++){
			if(Character.isDigit(w.charAt(i))){
				digcnt++;
			}
		}

		return digcnt;
	}
}
