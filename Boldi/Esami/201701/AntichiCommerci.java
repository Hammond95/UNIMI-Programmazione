import java.io.*;
import java.util.*;
import java.math.*;

public class AntichiCommerci {

	public static void main (String args[]){
		System.out.println("------Antichi Commerci------");

		ArrayList<Risorsa> listaRisorse = new ArrayList<Risorsa>();

		int i=20;
		while(i>0){
			int prezzo=5+((int)(Math.random()*200));
			listaRisorse.add(new Risorsa("Risorsa "+(21-i),prezzo));
			i--;
		}

		//for(Risorsa r : listaRisorse)
			//System.out.println(r.getNome()+":"+r.getPrezzo());

		ArrayList<Citta> listaCitta = new ArrayList<Citta>();
		
		i=60;
		int sizeLR = listaRisorse.size();
		while(i>0){
			int randRis = (int)(Math.random()*sizeLR);
			listaCitta.add(new Citta("Città "+(60-i),listaRisorse.get(randRis)));
			i--;
		}

		//for(Citta c : listaCitta)
			//System.out.println(c.toString());
		
		ArrayList<Civilta> listaCivil = new ArrayList<Civilta>();

		listaCivil.add(new Civilta("Impero Austro-Ungarico"));
		listaCivil.add(new Civilta("Sacro Romano Impero"));
		listaCivil.add(new Civilta("Impero Ellenico"));
		listaCivil.add(new Civilta("Impero Asiatico"));
		listaCivil.add(new Civilta("Impero Ottomano"));
		listaCivil.add(new Civilta("Impero Russo"));

		int randCit=0;
		while(!listaCitta.isEmpty()){
			for(Civilta c : listaCivil){
				randCit=(int)(Math.random()*listaCitta.size());
				c.aggiungiCitta(listaCitta.get(randCit));
				listaCitta.remove(randCit);
				if(listaCitta.isEmpty())
					break;
			}
		}
		
		for(Civilta c : listaCivil)
			c.printColonie();

		Storia storia = new Storia(listaCivil);
		
		i=10;
		while(i>0){
			Civilta cr = storia.evolvi(1+((int)Math.random()*5));
			System.out.println("La Civiltà più ricca è:"+cr.getNome());
			storia.conquista();
			i--;	
		}
		
	
	}


}
