import java.io.*;

public class Libro {

	private static int contLibro;

	private String titolo = "";
	private String autori[];
	private int identificativo;
	private boolean prestabile;

	public Libro(String titolo, String autori[], boolean prestabile){
		this.titolo = titolo.toUpperCase();
		this.autori = new String[autori.length];
		for(int i=0; i<autori.length; i++){
			this.autori[i] = autori[i].toUpperCase();
		}
		this.prestabile = prestabile;
		contLibro++;
		this.identificativo=contLibro;
	}

	public Libro(String titolo, String autore, boolean prestabile){
		this(titolo,new String[]{autore},prestabile);
	}

	public Libro(String titolo, String autori[]){
		this(titolo,autori,true);
	}

	public Libro(String titolo, String autore){
		this(titolo,new String[]{autore},true);
	}

	@Override
	public String toString(){
		return "["+titolo+"|"+printAutori()+"]";
	}

	@Override
	public int hashCode(){
		return identificativo;
	}

	@Override
	public boolean equals(Object o){
		if(!(o instanceof Libro)){
			return false;
		} else {
			Libro l = (Libro) o;
			return (this.identificativo == l.identificativo);
		}
	}
	
	public String printAutori(){
		StringBuilder sb = new StringBuilder();
		for(String a : autori){
			sb.append(a+", ");
		}
		return sb.toString();
	}
	
	public String getTitolo(){
		return this.titolo;
	}

	public void setTitolo(String t){
		this.titolo=t.toUpperCase();
	}

	public boolean isPrestabile(){
		return this.prestabile;
	}

	public void setPrestabile(boolean b){
		this.prestabile = b;
	}

	public int getId(){
		return this.identificativo;
	}
}
