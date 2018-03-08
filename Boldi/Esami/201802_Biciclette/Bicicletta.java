import java.io.*;
import java.util.*;

public class Bicicletta {

	String id = "";
	boolean elettrica = false;

	Utente u = null;


	public Bicicletta(String id, boolean elettrica){
		this.id=id;
		this.elettrica=elettrica;
	}

	@Override
	public String toString(){
		return "Bicicletta n°"+id;
	}

	@Override
	public int hashCode(){
		int el = elettrica ? 1 : 0;
		return id.hashCode() + el;
	}

	@Override
	public boolean equals(Object o){
		if(!(o instanceof Bicicletta)){
			return false;
		} else {
			Bicicletta b = (Bicicletta) o;
			return id.equals(b.id);
		}
	}

	public boolean elettrica(){
		return this.elettrica;
	}

	/**
	 * @param Utente x
	 *
	 * dà la bicicletta all'utente indicato, solleva un'eccezione
	 * se la bicicletta è in uso ad un altro utente.
	 *
	 * @throws IllegalStateException
	 */

	public void daiInUso(Utente x) throws IllegalStateException {
		if(this.u!=null){
			throw new IllegalStateException("La biciletta non è disponibile");
		} else {
			this.u=x;
		}
	}


	/**
	 * L'utente restituisce la bicicletta,
	 * solleva un'eccezione se la bicicletta 
	 * non è in prestito a nessuno. 
	 *
	 * @throws IllegalStateException
	 */
	public void restituisci() throws IllegalStateException {
		u.restituisci();
		
	}


	/**
	 *
	 * Restituisce l'utente che ha attualmente la bici
	 * altrimenti restituisce null.
	 *
	 * @return Utente u
	 */
	public Utente utente() {
		return this.u;
	}
}
