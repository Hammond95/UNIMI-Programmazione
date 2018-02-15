import java.io.*;
import java.util.*;

public class Biblioteca {

	private String nome="";
	private ArrayList<Libro> libri = null;
	private ArrayList<Utente> utenti = null;
	private ArrayList<Prestito> prestiti = null;

	public Biblioteca (String nome){
		this.nome = nome;
		libri = new ArrayList<Libro>();	
		utenti = new ArrayList<Utente>();
		prestiti = new ArrayList<Prestito>();
	}
	
	public void nuovoUtente(Utente x){
		
		for(Utente u : utenti){
			if(u.equals(x)){
				return;
			}
		}
		
		utenti.add(x);
	}

	public void nuovoLibro(Libro x){
		for(Libro l : libri){
			if(l.equals(x)){
				return;
			}
		}
		
		libri.add(x);
	}

	public int numeroUtenti(){
		return utenti.size();
	}

	public int numeroLibri(){
		return libri.size();
	}

	public Libro[] cercaLibro(String x){
		ArrayList<Libro> trovati = new ArrayList<Libro>();

		for(Libro l : libri){
			String tit = l.getTitolo();
			if(tit.contains(x.toUpperCase())){
				trovati.add(l);
			}
		}

		return trovati.toArray(new Libro[trovati.size()]);
	}

	public boolean disponibile(Libro x){
		if(x.isPrestabile()){
			boolean t=false;
			for(Libro l : libri){
				if(l.equals(x)){
					for(Prestito p : prestiti){
						if(p.riguardaLibro(x)){
							if(p.riguardaData(new Data())){
								return true;
							}
						}
					}
				}
			}
		}

		return false;
	}

	public int quantiPrestiti(Utente x){
		int pcount=0;
		Data oggi = new Data();
		for (Prestito p : prestiti){
			if(p.getUtente().equals(x)){
				if(oggi.vienePrimaDi(p.getDataA())){
					pcount++;
				}
			}
		}
		
		System.out.println("L'utente "+x.getNC()+" ha in prestito "+pcount+" libri.");
		return pcount;
	}

	public boolean daiInPrestito(Libro x, Utente u, Data finoA){
		if(x.isPrestabile() && (quantiPrestiti(u)<4)){
			Data oggi = new Data();
			Prestito p = new Prestito(x,u,oggi,finoA);
			prestiti.add(p);
			x.setPrestabile(false);
			System.out.println("Prestato il Libro "+x.getTitolo()+" a "+u.getNC());
			return true;
		} else {
			System.out.println("Il Libro "+x.getTitolo()+" non è prestabile.");
			return false;
		}
	}

	public boolean daiInPrestito(Libro x, Utente u){
		Data oggi = new Data();
		Data succ = oggi.successiva();
		return daiInPrestito(x,u,succ);
	}

	
/* Questo metodo non assicura di trovare un utente che ha in possesso
 * un libro anche se lo status effettivo del libro è "non prestabile"
 * Può darsi che un utente prenda in prestito un libro e non lo
 * restituisca passata la data di consegna.
 * Bisognerebbe valutare piuttosto l'ultimo prestito conosciuto 
 * del libro.*/	
	public Utente chiHaInPrestito(Libro x){
		Data oggi = new Data();
		for(Prestito p : prestiti){
			if(p.getLibro().equals(x)){
				if(oggi.vienePrimaDi(p.getDataA())){
					System.out.println("Il Libro "+x.getTitolo()+" è in prestito a "+p.getUtente().getNC());
					return p.getUtente();
				}
			}
		}
		
		System.out.println("Nessuno ha in prestito il libro "+x.getTitolo());
		return null;
	}

	public ArrayList<Libro> getLibri(){
		return this.libri;
	}

	public ArrayList<Utente> getUtenti(){
		return this.utenti;
	}

}
