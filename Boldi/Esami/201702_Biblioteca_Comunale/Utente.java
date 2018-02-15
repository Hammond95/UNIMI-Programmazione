import java.io.*;

public class Utente {

	public static int contUtente;
	
	private String nome = "";
	private String cognome = "";
	private Data dataDiNascita = null;
	private int identificativo = 0;

	public Utente (String nome, String cognome, Data nato){
		this.nome=nome.toUpperCase();
		this.cognome=cognome.toUpperCase();
		this.dataDiNascita = nato;
		contUtente++;
		this.identificativo=contUtente;
	}

	@Override
	public String toString(){
		return "["+getNC()+"|"+dataDiNascita.toString()+"]";
	}

	@Override
	public int hashCode(){
		return identificativo;
	}

	@Override
	public boolean equals(Object o){
		if(!(o instanceof Utente)){
			return false;
		} else {
			Utente u = (Utente) o;
			return (this.identificativo == u.identificativo);
		}
	}

	public String getNome(){
		return this.nome;
	}

	public String getCognome(){
		return this.cognome;
	}

	public String getNC(){
		return this.nome+" "+this.cognome;
	}
	
	public Data getDataNascita(){
		return this.dataDiNascita;
	}

	public int getId(){
		return this.identificativo;
	}

	public void setNome(String nome){
		this.nome=nome.toUpperCase();
	}

	public void setCognome(String cognome){
		this.cognome=cognome.toUpperCase();
	}

	public void setDataNascita(Data d){
		this.dataDiNascita=d;
	}
	
	public void setExUtente(){
		this.identificativo=-(this.identificativo);
	}
}
