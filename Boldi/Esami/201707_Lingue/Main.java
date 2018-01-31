import java.io.*;
import java.util.*;

public class Main {

	public static void main (String args[]) throws FileNotFoundException {
		
		Addestratore a = new Addestratore();

		if(args.length==2){
			File f = new File(args[0]);
			Scanner fin = new Scanner(f);

			while(fin.hasNextLine()){
				String line = fin.nextLine();
				String lingua = line.split("\t")[0];
				String file = line.split("\t")[1];
				File fl = new File(file);
				Scanner flin = new Scanner(fl);
				StringBuilder sb = new StringBuilder();
				while(flin.hasNext()){
					sb.append(flin.next());
				}
				flin.close();
				a.addestra(lingua,sb.toString());
			}
			fin.close();
			
			//Read test string from stdin
			StringBuilder test = new StringBuilder();
			Scanner stdin = new Scanner(System.in);
			while(stdin.hasNext()){
				test.append(stdin.next());
			}
			stdin.close();
			System.out.println("The provided text may be: "+a.classifica(test.toString()));

			a.stampa(Integer.parseInt(args[1]));
			
		}
	}

}
