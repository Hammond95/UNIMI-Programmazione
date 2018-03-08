import java.io.*;
import java.util.*;

public class Utente {

	String nome="";
	String cognome="";

	// Dovrei aggiungere un id utente per evitare i casi di omonimia?

	Bicicletta b = null;

	public Utente (String nome, String cognome){
		this.nome=nome;
		this.cognome=cognome;
	}

	public Bicicletta bicicletta(){
		return this.b;
	}

	@Override
	public String toString(){
		String bic = (b==null) ? "senza" : "con";
		return "L'utente "+nome+" "+cognome+", "+bic+" bicicletta";
	}

	@Override
	public int hashCode(){
		return nome.hashCode()+cognome.hashCode();
	}

	@Override
	public boolean equals(Object o){
		if(!(o instanceof Utente)){
			return false;
		} else {
			Utente u = (Utente) o;
			return (nome.equals(u.nome) && cognome.equals(u.cognome));
		}
	}

	/**
	 * @param Biciletta x
	 *
	 * Se possibile prende una biciletta, altrimenti solleva
	 * IllegalStateException.
	 *
	 * @throws IllegalStateException
	 */
	public void prendiInUso(Bicicletta x) throws IllegalStateException {
		if(b==null)
			this.b=x;
		else
			throw new IllegalStateException("L'utente ha già in prestito una bicicletta!");
	}



	/**
	 * Se possibile restituisce la biciletta, altrimenti solleva
	 * IllegalStateException.
	 *
	 * @throws IllegalStateException
	 */
	public void restituisci() throws IllegalStateException {
		if(b==null)
			throw new IllegalStateException("L'utente non ha in prestito nessuna bicicletta da restituire");
		else{
			b.u=null;
			b=null;
		}
	}
}
