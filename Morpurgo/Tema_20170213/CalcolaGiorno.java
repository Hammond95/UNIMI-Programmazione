import java.io.*;
import java.util.*;
import java.lang.NumberFormatException;

public class CalcolaGiorno {

	public static void main (String args[]){
		if(args.length==3){
			try{
				int g = Integer.parseInt(args[0]);
				int m = Integer.parseInt(args[1]);
				int a = Integer.parseInt(args[2]);
				if(CalcolaGiorno.isValidData(g,m,a)){
					System.out.println(g+CalcolaGiorno.mesiInGiorni(m,a));
				} else {
					System.out.println("errore");
				}
			} catch (NumberFormatException e){
				System.out.println("errore");
			}
		}
	}
	

	public static boolean checkMonth(int m){
		return (m>0 && m<13);
	}

	public static boolean checkDay(int d, int m, int a){
		if(d<1 || d>31)
			return false;
		switch(m)
		{
			case 4:
			case 6:
			case 9:
			case 11: 
				return (d<31);
			case 2:
				int b = (isBisestile(a)) ? 1 : 0;
				return (d<(28+b));
			default:
				return checkMonth(m);
		}	
	}
	
	/* Calendario Gregoriano */
	public static boolean isBisestile(int a){
		if(a%100==0)
			return (a%400==0);
		else
			return (a%4==0);
	}


	public static boolean isValidData (int g, int m, int a){
		return (checkMonth(m) && checkDay(g,m,a));
	}

	public static int mesiInGiorni(int m, int a) {
		int giorniMesi=0;
		if(checkMonth(m)) {
			int b = (isBisestile(a)) ? 1 : 0;
			while(m>0){
				switch(m){
					case 4:
					case 6:
					case 9:
					case 11: 	giorniMesi+=30;
								break;
					case 2:  	giorniMesi+=(28+b);
								break;
					default: 	giorniMesi+=31;
				}
				m--;
			}
		}
		return giorniMesi;
	}
}
