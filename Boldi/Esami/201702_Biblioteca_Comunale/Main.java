import java.io.*;
import java.util.*;

public class Main {

	public static void main (String args[]){

		Biblioteca bib = new Biblioteca("Biblioteca Z");
		/* Aggiunta libri in biblioteca */
		bib.nuovoLibro(new Libro("Tom Sawyer", "Mark Twain"));
		bib.nuovoLibro(new Libro("Assassinio Sull'OE", "Agata Christie"));
		bib.nuovoLibro(new Libro("I Mastini di Baskerville", "Conan Doyle"));
		bib.nuovoLibro(new Libro("Il Piccolo Principe", "Antoine de Saint-Exupéry"));
		bib.nuovoLibro(new Libro("Tom Sawyer", "Mark Twain"));
		bib.nuovoLibro(new Libro("La vita è bella", "Roberto Benigni"));
		bib.nuovoLibro(new Libro("1984", "George Orwell"));
		bib.nuovoLibro(new Libro("La Fattoria degli Animali", "George Orwell"));
		bib.nuovoLibro(new Libro("Le Notti Bianche", "Fedor Dostojevsky"));
		bib.nuovoLibro(new Libro("Thinking In Java", "Bruce Eckell"));
		bib.nuovoLibro(new Libro("Un'eterna ghirlanda brillante", "Douglas Hofstadter"));
		bib.nuovoLibro(new Libro("Dai Fondamenti agli Oggetti", new String[]{"Pizzighini","Ferrari"}));

		/* Aggiunta Utenti */
		bib.nuovoUtente(new Utente("Mario","Rossi", new Data(10,7,1976)));	
		bib.nuovoUtente(new Utente("Luigi","D'Acunto", new Data(23,2,1989)));	
		bib.nuovoUtente(new Utente("Paolo","Boldi", new Data(10,3,1973)));	
		bib.nuovoUtente(new Utente("Alberto","Borghese", new Data(3,7,1966)));	
		bib.nuovoUtente(new Utente("Massimo Emilio","Tarallo", new Data(26,8,1961)));	
		bib.nuovoUtente(new Utente("Valeria","De Pascale", new Data(23,1,1988)));	
		bib.nuovoUtente(new Utente("Luca","De Vito", new Data(29,9,1934)));	
		bib.nuovoUtente(new Utente("Mario","Rossi", new Data(12,2,1992)));	
		bib.nuovoUtente(new Utente("Piero","Rossi", new Data(15,5,1981)));

		System.out.println("La Biblioteca ha "+bib.numeroUtenti()+" utenti, e ha a disposizione "+bib.numeroLibri()+" libri.");

		/* Aggiunta Prestiti */

		ArrayList<Libro> lib = bib.getLibri();
		ArrayList<Utente> uti = bib.getUtenti();

		//Check Dai In Prestito
		bib.daiInPrestito(lib.get(1),uti.get(3));
		//Check Libro Non Prestabile
		bib.daiInPrestito(lib.get(1),uti.get(4));
		//Check chi ha in Prestito
		bib.chiHaInPrestito(lib.get(1));

		Libro[] lt = bib.cercaLibro("tt");
		System.out.println("\n\nLibri trovati che contengono 'tt' nel titolo:");
		for(Libro l : lt){
			System.out.println("    - "+l.getTitolo());
		}
		
				
		bib.daiInPrestito(lib.get(8),uti.get(3));
		bib.daiInPrestito(lib.get(2),uti.get(3));
		bib.daiInPrestito(lib.get(3),uti.get(3));
		bib.daiInPrestito(lib.get(4),uti.get(6));
		
		bib.quantiPrestiti(uti.get(3));

	}
}
