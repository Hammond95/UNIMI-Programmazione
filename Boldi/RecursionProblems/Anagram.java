/* *****************************************************************************
 * Given a string print all the possible permutations of the string (anagram)
 ******************************************************************************/
 import java.io.*;

public class Anagram {

	public static void main (String args[]){
		if(args.length==1)
			Anagram.anagram(args[0],0);
	}

	public static void anagram (String s, int b){
		int e = s.length();
		if(e==1 || b==e)
			System.out.println(s);
		else {
			for(int i=b; i<e; i++){
				String ts = swap(s,b,i);
				anagram(ts,b+1);
				
			}
		}
	}

	
	public static void anagram2 (String s, int b){
		int e = s.length();
		if(e==1 || b==e)
			System.out.println(s);
		else {
			for(int i=b; i<e; i++){
				//This condition avoids some repeats
				boolean norip = (s.charAt(b)==s.charAt(i)) && (b!=i);
				if(norip) 
					continue;
				String ts = swap(s,b,i);
				anagram2(ts,b+1);
			}
		}
	}

	public static String swap (String s, int i, int j){
		char temp;
		char charArray[] = s.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		
		return String.valueOf(charArray);
	}

}
