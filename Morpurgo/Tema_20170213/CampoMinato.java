// Versione 2

import java.io.*;
import java.util.*;
import java.lang.NumberFormatException;

public class CampoMinato {

	private char[][] campo;
	private int size = 0;

	public CampoMinato(int n) {
		this.campo = new char[n][n];
		this.size = n;
	}


	public static void main (String args[]){
		if(args.length==1){
			try{
				int n = Integer.parseInt(args[0]);
				// if n > 2
				CampoMinato cm = new CampoMinato(n);
				Scanner in = new Scanner(System.in);
				int nl = 0;
				while(nl<n){
					String line = in.nextLine();
					// if line is correct
					cm.campo[nl] = line.substring(0,n).toCharArray();
					nl++;
				}

				for(int i=0;i<n;i++){
					for(int j=0; j<n; j++){
						if(cm.campo[i][j]!='*'){
							System.out.print(" ["+cm.contaMine(i,j)+"] ");
						} else {
							System.out.print(" [*] ");
						}
					} 
					System.out.println();
				}

				
			} catch (NumberFormatException e){
				e.printStackTrace();
			}
		}	
	}

	public int contaMine(int r, int c){
		
		int counter=0;

		for(int i=r-1; i<=r+1; i++){
			for(int j=c-1; j<=c+1; j++){
				boolean cond = j>=0 && j<size && i>=0 && i<size;
				if(cond){
					if(campo[i][j]=='*'){
						counter++;
					}
				}
			}
		}

		return counter;
	}
}
