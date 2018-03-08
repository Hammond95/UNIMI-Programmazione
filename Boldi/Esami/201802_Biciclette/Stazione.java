import java.io.*;
import java.util.*;

public class Stazione {

	String nome="";
	double x = 0.0;
	double y = 0.0;
	Bicicletta[] posizioni = null;
	//Si considera che inizialmente la stazione bici sia completamente vuota
	int nBici = 0; 
	boolean elettriche = false;


	public Stazione (String nome, double x, double y, int posizioni, boolean elettriche){
		this.nome=nome;
		this.x=x;
		this.y=y;
		this.posizioni= new Bicicletta[posizioni];
		this.elettriche=elettriche;
	}

	@Override
	public String toString(){
		return "La stazione bici "+nome;
	}

	public int nPosizioni(){
		return posizioni.length;
	}

	public int nBiciclette(){
		return nBici;
	}

	public boolean piena(){
		return (nBici == posizioni.length) ? true : false;
	}

	public boolean vuota(){
		return (nBici == 0) ? true : false;
	}

	public boolean ammetteElettriche(){
		return this.elettriche;
	}

	public boolean ciSonoElettriche(){
		for(Bicicletta b : posizioni){
			if(b==null){
				continue;
			}
			if(b.elettrica()==true){
				return true;
			}
		}

		return false;
	}

	public Bicicletta posizione(int i){
		if(i>-1 && i<nPosizioni()-1){
			return posizioni[i];
		}

		return null;
	}

	/**
	 * @param Utente u 
	 * @param int i 
	 *
	 * Se la posizione esiste nella stazione bici e la bicicletta 
	 * è presente in quella poszione, assegna la bicicletta all'utente.
	 * Altrimenti solleva un'eccezione.
	 *
	 * @throws IllegalStateException
	 */
	public void prendi(Utente u, int i) throws IllegalStateException {
		if(posizione(i)==null){
			throw new IllegalStateException("La bicicletta non è disponibile!");
		} 
		if(u.bicicletta()!=null){
			throw new IllegalStateException("L'utente può avere al massimo una bicicletta");
		} else {
			posizioni[i].daiInUso(u);
			u.prendiInUso(posizioni[i]);
			nBici--;
		}
	}

	
	/**
	 * @param Utente u 
	 * @param int i 
	 *
	 * Se la posizione esiste nella stazione bici e non è
	 * presente giù un'altra bicicletta, l'utente può depositare
	 * la bicicletta.
	 * Altrimenti solleva un'eccezione.
	 *
	 * @throws IllegalStateException
	 */
	public void aggancia(Utente u, int i) throws IllegalStateException {
		if(posizione(i)!=null){
			throw new IllegalStateException("La posizione "+i+" è già occupata da una bicicletta.");
		} 
		if(u.bicicletta()==null){
			throw new IllegalStateException("L'utente non ha biciclette da agganciare.");
		} else {
			posizioni[i]=u.bicicletta();	
			u.restituisci();
			nBici++;
		}
	}


	/**
	 * @param boolean elettrica 
	 *
	 * Ritorna la prima bici disponibile, elettrica se eventualmente richiesto.
	 *
	 * Ritorna -1 se non è disponibile nessuna bici.
	 */
	public int disponibile(boolean elettrica){
		for(int i=0; i<posizioni.length; i++){
			if(posizioni[i]==null){
				continue;
			}
			if(elettrica){
				if(posizioni[i].elettrica()==true){
					return i;
				}
			} else {
				return i;
			}
		}

		return -1;
	}

	public double distanzaDa(double x, double y){
		double xDiff = (this.x-x)*(this.x-x);
		double yDiff = (this.y-y)*(this.y-x);

		return Math.sqrt(xDiff + yDiff);	
	}

	/**
	 * @param Stazione[] s
	 * @param boolean elettrica
	 * @param double x
	 * @param double y
	 *
	 *
	 * Data unalista di Stazioni, cerca la stazione più vicina al
	 * punto dato che abbia la disponibilità di almeno una bicicletta,
	 * eventualmente elettrica se richeisto. Ritorna la stazione 
	 * oppure null se non ne trova nessuna.
	 *
	 * @return Stazione
	 */
	public static Stazione cerca(Stazione[] s, boolean elettrica, double x, double y){
		
		double distMin = -1.0;
		Stazione piuVicina = null;

		for(int i=0; i<s.length; i++){
			double dist = s[i].distanzaDa(x,y);
			boolean disp = (s[i].disponibile(elettrica) != -1) ? true : false;
			if(disp==true && dist<=distMin){
				distMin=dist;
				piuVicina=s[i];
			}
		}

		return piuVicina;
	}
}
