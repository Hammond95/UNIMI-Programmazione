import java.io.*;
import java.util.*;

/**********************************************************************************************************
 * Scrivere  un  programma  (una  classe  “ContaParoleConNumeri”  
 * dotata  del  metodo main) che legge da standard input alcune 
 * stringhe contenenti o meno cifre.  Le stringhe sono separate da
 * caratteri di spaziatura (cioè newline, spazi, tab, ecc.).  Il programma 
 * deve generare in output una statistica di quante stringhe sono state 
 * incontrate contenenti almeno una cifra e quante non contenevano alcuna cifra 
 * e del numero totale di cifre contenute nelle stringhe incontrate (si
 * vedano esempi sotto).  Il numero di stringhe e il numero delle righe non 
 * è noto a priori.
 *
 * Non ci sono vincoli sul numero di stringhe e numeri su una riga, ́e sul numero di 
 * righe, ́e sul numero di caratteri di spaziatura (cioè newline, spazi, tab, ecc.) che li separano.
 * Il file sorgente consegnato DEVE chiamarsi ContaParoleConNumeri.java e contenere la classe pubblica
 * ContaParoleConNumeri.
 *********************************************************************************************************/

public class ContaParoleConNumeri {

	public static void main (String args[]){
		try {
			String input = readerUtility();
			int digcnt=0, sum=0, digwords=0, words=0;
			boolean flagw=false;
			for(int i=0; i<input.length(); i++){
				if(input.charAt(i)!=' '){
					flagw=false;
					if(Character.isDigit(input.charAt(i))==true)
						digcnt++;
				} else {
					if(digcnt!=0){
						sum+=digcnt;
						digwords++;
					} else if(flagw==false) words++;
					digcnt=0;
					flagw=true;
				}
			}

			System.out.println("parole con cifre: "+digwords);
			System.out.println("parole senza cifre "+words);
			System.out.println("numero totale di cifre "+sum);

		} catch (Exception e){
			System.out.println("Something went wrong!");
		}

	}

	public static String readerUtility() throws Exception {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		/* Reading Input until CTRL-D is pressed */
		while(in.hasNextLine())
		{	String line = in.nextLine();
			sb.append(line+" ");
		}
		in.close();
		String input=sb.toString();
		/* Converting tabs and newline to space
		 * in order to have a single separator.*/
		input = new String(input.replaceAll("\t"," "));
		input = new String(input.replaceAll("$"," "));

		return input;
	}
}
