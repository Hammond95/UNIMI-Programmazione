import java.io.*;
import java.util.*;

public class RevRev {

	public static void main (String args[]){
		
		ArrayList <String> lines = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String line = in.nextLine();
			String revline = RevRev.reverse(line);
			lines.add(revline);
		}

		int size = lines.size();
		while(size>0){
			System.out.println(lines.get(size-1));
			size--;
		}
	}

	public static String reverse (String toRev){
		char[] rev = toRev.toCharArray();
		char temp;

		int i=0, f=toRev.length()-1;
		while(f>i){
			temp = rev[i];
			rev[i] = rev[f];
			rev[f] = temp;
			f--;
			i++;
		}

		return new String(rev);
	
	}
}
