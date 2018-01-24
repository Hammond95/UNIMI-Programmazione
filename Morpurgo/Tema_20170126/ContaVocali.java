import java.util.*;
import java.io.*;

public class ContaVocali {

	public static void main (String args[]){

		Scanner in = new Scanner(System.in);

		int nParole=0, max=0, sum=0;

		while(in.hasNext()){
			String word = in.next();
			int nVocali = conta(word);
			sum += nVocali;
			if(nVocali>max){
				max=nVocali;
			}
			nParole++;
		}
		in.close();
		
		if(nParole!=0){
			System.out.println("media:"+(sum/nParole));
		} else { 
			System.out.println("media:0");
		}
		System.out.println("max:"+max);
	}

	public static int conta(String word){
		int vocali=0;
		for(int i=0; i<word.length(); i++){
			if("aeiouAEIOU".indexOf(word.charAt(i))>-1){
				vocali++;
			}
		}

		return vocali;
	}
}
