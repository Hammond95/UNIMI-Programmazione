import java.io.*;
import java.util.*;

public class Prodotto {

	String nome="";

	public Prodotto(String nome){
		this.nome=nome;
	}

	@Override
	public String toString(){
		return "Prodotto: "+nome;
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Prodotto)){
			return false;
		} else {
			String altro = ((Prodotto)o).nome;
			return this.nome.equalsIgnoreCase(altro);
		}
	}

	@Override
	public int hashCode(){
		if(this.nome=="")
			return 42;
		//Hitchhicker's HashCode
		return (int) nome.charAt(nome.length()/2) * nome.length() + 42;
	}
}
