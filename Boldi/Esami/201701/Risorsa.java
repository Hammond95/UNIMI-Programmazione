import java.io.*;
import java.util.*;

public class Risorsa {
	private String nome="";
	private int prezzo;

	public Risorsa(String nome, int prezzo){
		this.nome=nome.toUpperCase();
		this.prezzo=prezzo;
	}

	public Risorsa(Risorsa r){
		this(r.getNome(),r.getPrezzo());
	}
	
	@Override
	public boolean equals(Object r){
		if(r instanceof Risorsa){
			Risorsa ris = (Risorsa) r;
			return (this.nome.equals(ris.nome));
		} else {
			return false;
		}
	}

	@Override
    	public int hashCode(){
        	return this.nome.length();
    	}

	public String getNome(){
		return this.nome;
	}

	public int getPrezzo(){
		return this.prezzo;
	}
}
