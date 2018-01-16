/**------------------------------------------------------------------------------------
 * Realizzare un programma (una classe “PoorMansHash” dotata del metodo main)
 * che riceve una stringa di caratteri passata per parametro sulla linea di 
 * comando e manda in standard output una stringa di esattamente 15 caratteri, 
 * calcolata dal seguente algoritmo:
 *    - si inizializzi la stringa di ouput con tutti spazi
 *    - per ogni posizione i della stringa di ingresso
 *         –si divida per 3 (troncando all’intero) il valore ASCII del carattere 
 *          in quella posizione.
 *         –si sommi il valore così ottenuto al k-esimo carattere della stringa
 *          di output, dove k è calcolato come “i modulo 15”;
 *         –si assegni come (nuovo) valore del carattere di output il modulo 95 
 *          del valore calcolato al punto precedente, sommato a 33;
 * si  visualizzi  infine  la  stringa  formata  dai  caratteri  corrispondenti  
 * ai  codici  ASCII  così calcolati, e null’altro.
 -----------------------------------------------------------------------------------*/
public class PoorMansHash {

	public static void main (String args[]){
		if(args.length == 1){
			getPoorHash(args[0]);
		}
	}

	public static void getPoorHash(String in){
		char[] output = new char[15];

		for(int i=0; i<15; i++){
			output[i]=' ';
		}

		for(int i=0; i<in.length(); i++){
			int asciiVal = in.codePointAt(i);
			int asciiValThird = asciiVal/3;
			int k=i%15;
			int kout = (int) output[k];
			output[k] = (char) (kout + asciiValThird);
			kout = (int) output[k];
			output[k] = (char) ((kout%95)+33);
		}
		
		System.out.println(String.valueOf(output));
	}
}
