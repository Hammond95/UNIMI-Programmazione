import java.io.*;
import java.util.*;

public class LunghezzeParole {

	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		
		int words=0, sum=0, max=0, min=-1;
		while(in.hasNext())
		{	String line = in.next();
			int len = line.length();
			sum += len;
			if(len > max)
				max=len;
			if(len < min || min==-1)
				min=len;
			words++;
		}
		in.close();

		System.out.println("max: "+max);
		if(words!=0)
			System.out.println("media: "+(sum/words));
		else
			System.out.println("media: 0");
		System.out.println("min: "+min);
	}
}
