import java.io.*;
import java.util.*;

public class Citta {
	private String nome="";
	private Risorsa risorsa = null;

	public Citta (String nome, Risorsa r){
		this.nome = nome.toUpperCase();
		this.risorsa = r;
	}

	public Risorsa produci(){
		return this.risorsa;
	}

	public int getValRis(){
		return this.risorsa.getPrezzo();
	}

	public String getNome(){
		return this.nome;
	}

	public String toString(){
		return (this.nome+" produce "+this.risorsa.getNome());
	}

}
