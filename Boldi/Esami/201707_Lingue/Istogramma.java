import java.io.*;
import java.util.*;

/**
 * La classe Istogramma, data una larghezza (di default a 60 caratteri),
 * stampa a video un basilare grafico a barre della frequenza dei 
 * caratteri in un ModelloLinguistico @see ModelloLinguistico
 * 
 * @author  Martin De Luca
 */
public class Istogramma {

	int larg=60;

	public Istogramma(int larg){
		this.larg=larg;
	}

	@Override
	public String toString(){
		return "Istogramma - Larg: "+this.larg;
	}	

	public String toString(ModelloLinguistico m){
		
		StringBuilder istogramma = new StringBuilder();
		HashMap <Character,Integer> mMap = m.alfabeto;

		for(Map.Entry map : mMap.entrySet()){
			Character key = (Character) map.getKey();
			double fr = m.frequenzaRelativa(key);
			Double percIstoD = (double)100*fr;
			int percIstoInt = percIstoD.intValue();
			int percIsto = (percIstoInt*larg-2)/100;
			
			//if(percIstoInt>0){	//test
				istogramma.append(key+"\t");
				while(percIsto>0){
					istogramma.append("*");
					percIsto--;
				}
				istogramma.append("|\t"+percIstoInt+"%\n");
			//}
		}

		return istogramma.toString();
	}
}
