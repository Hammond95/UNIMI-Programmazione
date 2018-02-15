import java.io.*;

public class Prestito {

	Libro x = null;
	Utente u = null;
	Data da = null;
	Data a = null;

	public Prestito (Libro x, Utente u, Data da, Data a){
		this.x = x;
		this.u = u;
		this.da = da;
		this.a = a;
	}

	public Prestito (Libro x, Utente u, Data da){
		this.x = x;
		this.u = u;
		this.da = da;
		this.a = da.successiva();
	}

	@Override
	public String toString(){
		return "["+u.getNC()+"|"+x.getTitolo()+"|"+da.toString()+" - "+a.toString()+"]";
	}

	public Utente getUtente(){
		return this.u;
	}

	public Data getDataA(){
		return this.a;
	}

	public Libro getLibro(){
		return this.x;
	}

	public boolean riguardaLibro(Libro t){
		return (this.x.equals(t));
	}

	public boolean riguardaData(Data d){
		return 
		(  (d.vienePrimaDi(this.da)==false) && 
		   (d.vienePrimaDi(this.a)==true)
		);
	}

}
