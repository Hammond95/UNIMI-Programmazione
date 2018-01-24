import java.io.*;
import java.util.*;
import java.lang.NumberFormatException;

public class DivideParoleMinMaiu {

	public static void main (String args[]){
		if(args.length==1){		
			File f = new File(args[0]);
			try{
				Scanner sf = new Scanner(f);
				ArrayList<String> min = new ArrayList<String>();
				ArrayList<String> maiu = new ArrayList<String>();
				
				while(sf.hasNext()){
					String word = sf.next();
					if(word.matches("^[A-Z][a-zA-Z]+")){
						maiu.add(word);
					} else if(word.matches("^[a-z][a-zA-Z]+")){
						min.add(word);
					}
				}
				
				System.out.println("iniziano con minuscole:");
				for(String minW : min){
					System.out.println(minW);
				}
				System.out.println();
				System.out.println("iniziano con maiuscole:");
				for(String maiuW : maiu){
					System.out.println(maiuW);
				}

			} catch (FileNotFoundException e){
				System.out.println("file non esistente");
			}
		}
	}
}
