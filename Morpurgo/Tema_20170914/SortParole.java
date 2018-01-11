/***************************************************************************************************
 * Scrivere  un  programma  (una  classe  “SortParole”  dotata  del  metodo main)  che  legga  da  un
 * file, il cui nome è passato per parametro sulla linea di comando,  le parole in esso contenute
 * e le visualizzi in ordine alfabetico, una per riga (se ci sono più occorrenze della stessa parola,
 * verranno visualizzate tutte ).  Il numero di parole non è noto a priori e le parole sono separate
 * da caratteri di spaziatura (newline, spazi, tab, ecc.).
 *
 * NON implementate un vostro algoritmo di ordinamento.
 **************************************************************************************************/
 
import java.io.*;
import java.util.*;

public class SortParole {

		public static void main (String args[]){
				if(args.length == 1){
						String f_input = fileReaderUtility(args[0]);
						/* Split words separated by one or more spaces */
						String words[] = f_input.trim().split("[ ]+");
						Arrays.sort(words);
						for (String s : words)
								System.out.println(s);
				} else {
						System.out.println("Please insert just one argument (filename)");
				}
		}

		public static String fileReaderUtility (String filename){
				try {
						File filein = new File(filename);
						Scanner in = new Scanner(filein);
						StringBuilder sb = new StringBuilder();
						/* Reading Input until CTRL-D is pressed */
						while(in.hasNext())
						{		String line = in.nextLine();
								sb.append(line+" ");
						}
						in.close();
						String input=sb.toString();
						/* Converting tabs and newline to space
						* in order to have a single separator.*/
						input = new String(input.replaceAll("\t"," "));
						input = new String(input.replaceAll("$"," "));

						return input;

				} catch (FileNotFoundException e) {
						System.out.println(e);
						return "";
				}
		}
}
