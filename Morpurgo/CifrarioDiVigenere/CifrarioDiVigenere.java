import java.io.*;
import java.util.*;

public class CifrarioDiVigenere {

	static final String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String verme = "VERME";

	public CifrarioDiVigenere (String verme){
		this.verme=verme.toUpperCase();
	}

	public String cifra(String parola){
		String dc = parola.toUpperCase();
		int len = dc.length();
		char[] res = new char[len];

		int vLen = verme.length();
		for(int i=0; i<len; i++){
			int vN = alfabeto.indexOf(verme.charAt(i%vLen));
			int pN = alfabeto.indexOf(dc.charAt(i));
			res[i]=alfabeto.charAt((vN+pN)%26);
		}
		return String.valueOf(res);
	}

	public String getAntiverme(){
		char[] antiverme = new char[verme.length()];

		for(int i=0; i<verme.length(); i++){
			int pos = alfabeto.indexOf(verme.charAt(i));
			int newpos = ((26-pos)==26) ? 0 : 26-pos;
			antiverme[i]=alfabeto.charAt(newpos);
		}
		return String.valueOf(antiverme);
	}

	public String decifra(String parola){
		//Calcolo Antiverme
		String av = this.getAntiverme();
		CifrarioDiVigenere cav = new CifrarioDiVigenere(av);
		return cav.cifra(parola);
	}
	
	public static void main(String[] args){
		if(args.length==1){
			CifrarioDiVigenere c = new CifrarioDiVigenere("VERME");
			//CifrarioDiVigenere c = new CifrarioDiVigenere("FWJOW");
			String cifrata = c.cifra(args[0]);
			System.out.println("Parola Cifrata = "+cifrata);
			System.out.println("Parola Decifrata = "+c.decifra(cifrata));
		}
	}
}
