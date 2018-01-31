import java.io.*;
import java.util.*;

/**
 *
 * La classe Addestratore, memorizza diverse lingue,
 * ognuna associata al suo Modello Linguistico; e si
 * occupa di addestrare ogni modello linguistico
 * sulla base di testi forniti.
 *
 * @author Martin De Luca
 */
public class Addestratore {

	int nLingue = 0;
	ArrayList<String> lingue = null;
	ArrayList<ModelloLinguistico> modL = null;

	public Addestratore(){
		lingue = new ArrayList<String>();
		modL = new ArrayList<ModelloLinguistico>();
	}

	@Override
	public String toString(){
		return "Addestratore - Numero Lingue:"+nLingue;
	}

	public void addestra(String nomeLingua, String testo){
		for(int i=0; i<nLingue; i++){
			String l = lingue.get(i);
			if(l.equals(nomeLingua)){
				ModelloLinguistico m = modL.get(i);
				m.addestra(testo);
				return;
			}
		}

		lingue.add(nomeLingua);
		modL.add(new ModelloLinguistico(testo));
		nLingue++;
	}

	public String classifica (String testo){
		double diffMin = -1.0;
		double diff = -1.0;
		String match="Lingua Non Riconosciuta";
	
		ModelloLinguistico mls = new ModelloLinguistico(testo);
		
		for(int i=0; i<nLingue; i++){
			diff = modL.get(i).differenza(mls);
			if(diffMin<0.0 || diff<diffMin){
				diffMin=diff;
				match = lingue.get(i);
			}
		}

		return match;
	}
	
	public void stampa(int larg){
		for(int i=0; i<nLingue; i++){
				String l = lingue.get(i);
				ModelloLinguistico m = modL.get(i);
				System.out.println(l);
				System.out.println("=======================================================");
				Istogramma ist = new Istogramma(larg);
				System.out.println(ist.toString(m));
		}
	}
}
