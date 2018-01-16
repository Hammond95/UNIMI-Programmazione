import java.io.*;
import java.util.*;
import java.lang.NumberFormatException;

public class TrovaRigheColonneTutteZero {

	public static void main (String args[]){
		if(args.length==1){
			String filename = args[0];
			try{
				File f = new File(filename);
				Scanner sf = new Scanner(f);
				ArrayList<String> rows = new ArrayList<String>();

				System.out.println("righe tutte zero:");
				int cr=0, len=0;
				while(sf.hasNextLine()){
					String line = sf.nextLine();
					if(line.matches("[0]+")){
						System.out.println(cr+1);
					}
					rows.add(line);
					cr++;
				}
				
				System.out.println("colonne tutte zero:");
				if(rows.size()>0){
					for(int i=0; i<rows.get(0).length(); i++){
						boolean sawOne=false;
						for(int j=0; j<rows.size(); j++){
							if(rows.get(j).charAt(i)=='1'){
								sawOne=true;
								break;
							}
						}
						if(!sawOne){
							System.out.println(i+1);
						}
					}
				}

				sf.close();	

			} catch (FileNotFoundException e){
				System.out.println("file non esistente");
			}
		}
	}

}
