import java.util.*;
import java.io.*;

public class TrovaParole {

	public static void main (String args[]){

		Scanner in = new Scanner(System.in);
		
		ArrayList<String> words = new ArrayList<String>();

		while(in.hasNext()){
			words.add(in.next());
		}
		in.close();

		for(String s : args){
			boolean match=false;
			for(String word : words){
				if(s.length()==word.length()){
					System.out.println(s+":+");
					match=true;
					break;
				}
			}
			if(match==false){
				System.out.println(s+":0");
			}
		}
	}
}
