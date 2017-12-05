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

	public boolean equals(Risorsa r){
		return (this.nome == r.nome);
	}

	public String getNome(){
		return this.nome;
	}

	public int getPrezzo(){
		return this.prezzo;
	}
}
