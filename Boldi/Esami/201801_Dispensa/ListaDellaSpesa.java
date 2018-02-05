import java.io.*;
import java.util.*;

public class ListaDellaSpesa {

	HashMap<Prodotto,Integer> prodotti = null;

	public ListaDellaSpesa(){
		prodotti = new HashMap<Prodotto, Integer>();
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("ListaDellaSpesa: ");
		for(Prodotto p : prodotti.keySet()){
			sb.append(p.nome+"<"+prodotti.get(p)+">, ");
		}

		return sb.toString();
	}

	public void aggiungi(Prodotto p, Integer qta){
		if(prodotti.containsKey(p)){
			prodotti.put(p, prodotti.get(p)+qta);
			return;
		}
		
		prodotti.put(p,qta);
	}

	public void aggiorna(Prodotto p, Integer qta){
		prodotti.put(p,qta);
	}

	public int qta(Prodotto p){
		if(prodotti.containsKey(p)){
			return prodotti.get(p);
		}

		return 0;
	}

	public Prodotto[] prodotti(){
		return prodotti.keySet().toArray(new Prodotto[] {});
	}
}
