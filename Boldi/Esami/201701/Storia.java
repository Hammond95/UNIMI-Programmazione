import java.io.*;
import java.util.*;


public class Storia {
	
	ArrayList<Civilta> lisCiv = null;

	public Storia(ArrayList<Civilta> lista){
		this.lisCiv = lista;
	}

	public void commercia(Civilta c){
		for (Civilta k : lisCiv){
			if(!c.equals(k)){
				if(c.vendiRisorseA(k)){
					break;
				}
			}
		}
	}
	
	/* *******************************************
 	* Siccome le finanze di una civilta possono
 	* essere negatve conviene considerare
 	* inizialmente la più ricca la prima della
 	* lista, e poi procedere ai confronti.
 	* ******************************************/
	public Civilta piuRicca(){
		if(lisCiv.isEmpty()){
			//è una buona idea ritornare null?
			return null;
		}
		
		int piuRicca = 0;
		int max=lisCiv.get(0).getTesoro();

		for(int i=1; i<lisCiv.size(); i++){
			Civilta c = lisCiv.get(i);
			int tesoro = c.getTesoro();
			if(tesoro>max){
				max=tesoro;
				piuRicca=i;
			}
		}
		
		return lisCiv.get(piuRicca);
	}


	/* *******************************************
 	* Siccome le finanze di una civilta possono
 	* essere negatve conviene considerare
 	* inizialmente la più povera la prima della
 	* lista, e poi procedere ai confronti.
 	* ******************************************/
	public Civilta piuPovera(){
		if(lisCiv.isEmpty()){
			//è una buona idea ritornare null?
			return null;
		}
		
		int piuPovera = 0;
		int min=lisCiv.get(0).getTesoro();

		for(int i=1; i<lisCiv.size(); i++){
			Civilta c = lisCiv.get(i);
			int tesoro = c.getTesoro();
			if(tesoro<min){
				min=tesoro;
				piuPovera=i;
			}
		}
		
		return lisCiv.get(piuPovera);
	}



	public Civilta evolvi(int n){
		while(n>0){
			for(Civilta c : lisCiv){
				c.faiProdurre();
				commercia(c);
			}
			n--;
		}
		
		return piuRicca();
	}

	public void conquista(){
		Civilta cr = piuRicca();
		Civilta cp = piuPovera();
		
		if(cr.getTesoro()!=cp.getTesoro()){
			ArrayList<Citta> colonieCP = cp.getColonie();
			if(!colonieCP.isEmpty()){
				int cittaMin = 0;
				int risMin = colonieCP.get(0).getValRis();
				for(int i=1; i<colonieCP.size(); i++){
					Citta c = colonieCP.get(i);
					int valRis = c.getValRis();
					if(valRis<risMin){
						cittaMin=i;
						risMin=valRis;
					}
				}
				System.out.print(cr.getNome()+" ha conquistato la citta ");
				System.out.print(colonieCP.get(cittaMin).getNome()+" da ");
				System.out.println(cp.getNome());
				cr.aggiungiCitta(colonieCP.get(cittaMin));
				cp.rimuoviCitta(colonieCP.get(cittaMin));
			}
		}

	}
}
