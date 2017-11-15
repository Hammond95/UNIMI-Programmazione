/**************************************************************************************
 * Definire un metodo "int quanteVolteIn (String a, String b)" che calcola
 * ricorsivamente il numero di occorrenze della stringa a nella stringa
 * b. Tale quantità può essere definita nel modo seguente:
 * 		# se la lunghezza di a supera quella di b, essa è uguale a 0
 * 		# altrimenti essa è uguale al numero di occorrenze di a
 * 		  nella stringa ottenuta da b escludendo il primo carattere, 
 * 		  sommato a 1 oppure 0 a seconda che a sia/non sia ”prefisso” 
 * 		  di b.
 * Suggerimento: utilizzare i metodi startsWith e substring di String.
 * 
 * Scrivere  un  programma  (una  classe QuanteVolteIn dotata  del  metodo main) 
 * che, date due stringhe passate da linea di comando, stampi quante volte la prima
 * è contenuta nella seconda sfruttando il metodo di cui sopra.
 **************************************************************************************/

import java.io.*;
import java.util.*;

public class QuanteVolteIn {

		public static void main (String args[]){
				if(args.length == 2){
						System.out.println(quanteVolteIn(args[0],args[1]));
				} else {
						System.out.println("Please Insert the right number of arguments: [0] - Text To Find, [1] - Searched Text");
				}
		}

		public static int quanteVolteIn (String key, String text){

				if(key.length() > text.length()){
						return 0;
				}
				else {
						if(text.startsWith(key))
								return 1 + (quanteVolteIn(key, text.substring(1)));
						else
								return 0 + (quanteVolteIn(key, text.substring(1)));
				}
		}
}
