import java.io.*;
import java.util.*;

public class SortParole {

	public static void main (String args[]){
		if(args.length==1){
			try {
				File f = new File(args[0]);
				Scanner fin = new Scanner(f);
				ArrayList<String> words = new ArrayList<String>();
				while(fin.hasNext()){
					words.add(fin.next());
				}
				fin.close();
				Collections.sort(words);

				for(String word : words){
					System.out.println(word);
				}

			} catch(FileNotFoundException e){
				e.printStackTrace();
			}
		}
	}
}
