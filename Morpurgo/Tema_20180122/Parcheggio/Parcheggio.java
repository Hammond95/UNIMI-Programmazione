import java.io.*;
import java.util.*;

public class Parcheggio {

	public static void main (String args[]){

		Scanner in = new Scanner(System.in);

		String lineP[] = in.nextLine().split(" ");
		String lineV[] = in.nextLine().split(" ");
		in.close();

		boolean o[] = new boolean[lineP.length];

		for(String v : lineV){
			for(int j=0; j<lineP.length; j++){
				if(lineP[j].equals(v) && o[j]==false){
					o[j]=true;
					break;
				}
			}
		}

		for(int j=0; j<lineP.length; j++){
			if(o[j]==false){
				System.out.print(lineP[j]+" ");
			}
		} System.out.println();

	}

}
