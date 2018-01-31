import java.io.*;
import java.util.*;

/**
 * La classe ModelloLinguistico memorizza le frequenze
 * dei caratteri per una determinata lingua, basandosi
 * su diversi testi di allenamento ricevuti in input.
 *
 * @author Martin De Luca
 */
public class ModelloLinguistico {

	int testi = 0;
	int caratteri = 0;

	protected HashMap<Character, Integer> alfabeto = null;

	public ModelloLinguistico(){
		this.alfabeto = new HashMap<Character, Integer>();
	}

	public ModelloLinguistico(String testo){
		this();
		addestra(testo);
	}

	@Override
	public String toString(){
		return "ModelloLinguistico - Testi:"+testi+", Caratteri:"+caratteri+", Lunghezza Alfabeto:"+alfabeto.size();
	}

	public void addestra (String testo){
		int len = testo.length();

		testo = testo.toLowerCase();

		for(int i=0; i<len; i++){
			Character key = testo.charAt(i);
			if(Character.isLetter(key)){
				caratteri++;
				if(alfabeto.containsKey(key)){
					alfabeto.put(key, alfabeto.get(key)+1);
				} else {
					alfabeto.put(key, 1);
				}
			}
		}
		testi++;
	}

	public int quantiTesti(){
		return testi;
	}

	public int quantiCaratteri(){
		return caratteri;
	}

	public int frequenzaAssoluta(char c){
		if(alfabeto.containsKey(c)){
			return alfabeto.get(c);
		} else {
			return -1;
		}
	}

	public double frequenzaRelativa(char c){
		if(quantiCaratteri()>0){
			return (double) frequenzaAssoluta(c)/quantiCaratteri();
		} else {
			return 1.0/alfabeto.size();
		}
	}

	public double differenza(ModelloLinguistico m){
		double diffMod = 0.0;
		HashMap <Character,Integer> mMap = m.alfabeto;

		for(Map.Entry map : mMap.entrySet()){
			Character key = (Character) map.getKey();
			if(alfabeto.containsKey(key)){
				double frThis = frequenzaRelativa(key);
				double frMod  = m.frequenzaRelativa(key);
				double diffFR = (frThis-frMod)*(frThis-frMod);
				diffMod += diffFR;
			}
		}
		
		return Math.sqrt(diffMod);
	}
}
