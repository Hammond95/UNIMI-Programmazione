import java.io.*;
import java.util.*;

public class Dispensa {

	HashMap<Prodotto, Integer> qtaProdotti = null;
	HashMap<Prodotto, Integer> minProdotti = null;

	public Dispensa() {
		qtaProdotti = new HashMap<Prodotto, Integer>();
		minProdotti = new HashMap<Prodotto, Integer>();
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Dispensa: ");
		for(Prodotto p : qtaProdotti.keySet()){
			sb.append(p.nome+"<"+qtaProdotti.get(p)+">, ");
		}
		
		return sb.toString();
	}

	public void scortaMinima(Prodotto p, Integer qta){
		if(qta>=0){
			minProdotti.put(p,qta);
			if(!qtaProdotti.containsKey(p)){
				qtaProdotti.put(p,0);
			}
		}
	}

	public int qta(Prodotto p){
		if(qtaProdotti.containsKey(p)){
			return qtaProdotti.get(p);
		}

		return 0;
	}
	
	public void consuma(Prodotto p, int q) throws NoSuchElementException {
		int qta = this.qta(p);

		if(qta<q || qta==0){
			throw new NoSuchElementException("Nella dispensa ci sono solo "+qta+" unità di "+p.nome+", ma ne vengono richieste "+q);
		} else {
			qtaProdotti.put(p,qta-q);
		}
	}

	public ListaDellaSpesa preparaLista(){
		ListaDellaSpesa l = new ListaDellaSpesa();		

		for(Prodotto pMap : qtaProdotti.keySet()){
			int qta = qtaProdotti.get(pMap);
			int min = minProdotti.get(pMap);

			if(qta<min){
				l.aggiungi(pMap,min-qta);
			}
		}

		return l;
	}

	public void riponi(ListaDellaSpesa s){
		for(Prodotto p : s.prodotti()){
			if(qtaProdotti.containsKey(p)){
				qtaProdotti.put(p,qtaProdotti.get(p)+s.qta(p));
			} else {
				// If we have a new product inside the shop list
				// which couldn't be found in the pantry,
				// we also initialize the minimum quantity
				// to the bought quantity.
				qtaProdotti.put(p,s.qta(p));
				minProdotti.put(p,s.qta(p));
			}
		}
	}

}
