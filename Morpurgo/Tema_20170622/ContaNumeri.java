/****************************************************************************
 * Scrivere  un  programma  (una  classe  “ContaNumeri”  dotata  del  metodo
 * main) che legge da standard input numeri (positivi e negativi) interi o 
 * con la virgola, inframmezzati a parole varie, separati  da  caratteri
 * di  spaziatura  (cio`e  newline,  spazi,  tab,  ecc.)   e  manda  in  
 * output  una statistica  di  quanti  numeri  interi  e  quanti  con  la
 * virgola  sono  stati  effettivamente  inseriti,  e null’altro 
 * (si veda l’esempio sotto). Il numero di parole e numeri non è noto a 
 * priori.
 *--------------------------------------------------------------------------*/
import java.io.*;
import java.util.*;

public class ContaNumeri {

	public static void main (String args[]){
		
		Scanner in = new Scanner(System.in);
		int cint=0, cflo=0;
		while(in.hasNext()){
			String line = in.nextLine();
			line = new String(line.replaceAll("\t"," "));
			String list[] = line.split("[ ]+");
			for(String el : list){
				if(isValidInteger(el)){
					cint++;
				} else if (isValidFloat(el)){
					cflo++;
				}
			}
		}
		in.close();
		System.out.println("interi: "+cint);
		System.out.println("floating: "+cflo);

	}

	public static boolean isValidInteger (String value){
		String pattern = "^[+-]?[0-9]+";
		return value.matches(pattern);
	}
	
	public static boolean isValidFloat (String value){
		String pattern = "^[+-]?[0-9]+[.][0-9]+";
		return value.matches(pattern);
	}
}
