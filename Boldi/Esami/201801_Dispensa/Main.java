import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]){
		
		ListaDellaSpesa l = new ListaDellaSpesa();
		Dispensa d = new Dispensa();

		l.aggiungi(new Prodotto("Formaggio Biraghi"),3);
		l.aggiungi(new Prodotto("Salsa Mutti"),3);
		l.aggiungi(new Prodotto("Melanzane Sott'Olio"),3);
		l.aggiungi(new Prodotto("Merluzzo Gratinato"),1);
		l.aggiungi(new Prodotto("Merluzzo Gratinato"),1);
		l.aggiungi(new Prodotto("Bresaola"),3);
		l.aggiungi(new Prodotto("Prosciutto Cotto"),3);
		l.aggiungi(new Prodotto("Prezzemolo"),3);
		l.aggiungi(new Prodotto("Cornetto Algida"),3);
		l.aggiungi(new Prodotto("Bistecca di Bovino Adulto"),3);
		l.aggiungi(new Prodotto("Rigatoni Barilla"),3);
		l.aggiungi(new Prodotto("Olio Extravergine D'Oliva"),3);
		l.aggiungi(new Prodotto("Bucatini Barilla"),5);
		l.aggiungi(new Prodotto("Sushi Set"),1);
		l.aggiungi(new Prodotto("Crackers Salati"),3);
		l.aggiungi(new Prodotto("Zucchero"),3);
		l.aggiungi(new Prodotto("Funghi Chiodini"),3);
		l.aggiungi(new Prodotto("Pappardelle al Sugo"),3);
		
		System.out.println(l.toString()+"\n\n\n");

		d.riponi(l);
		
		System.out.println(d.toString()+"\n\n\n");

		d.consuma(new Prodotto("Pappardelle al Sugo"), 2);
		d.consuma(new Prodotto("Sushi Set"), 1);
		d.consuma(new Prodotto("Olio Extravergine D'Oliva"), 1);
		d.consuma(new Prodotto("Formaggio Biraghi"), 2);
			
		System.out.println(d.toString()+"\n\n\n");

		d.scortaMinima(new Prodotto("Bresaola"),10);

		l = d.preparaLista();

		System.out.println(l.toString()+"\n\n\n");
	}
}
