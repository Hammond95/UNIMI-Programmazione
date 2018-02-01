import java.io.*;
import java.util.*;

public class Statistiche {

	public static int[] frequenze(int data[]){
		
		int len = data.length;
		
		int[] freq = new int[len];

		for(int	i=0; i<len; i++){
			int val = data[i];
			if(val<0){
				freq[i]=0;
				continue;
			} else {
				int j=0, c=0;
				while(j<len){
					if(data[j++]==val){
						c++;
					}
				}
				j=len-1;
				while(j>=0){
					if(data[j]==val){
						freq[j]=c;
					}
					j--;
				}
			}
		}

		return freq;
	}

	public static double mediana(int data[]){
		Arrays.sort(data);
		
		int len=data.length;

		if(len%2==0){
			return ((double) data[len/2] + 
				    (double) data[(len/2)-1]) /2.0;
		} else {
			return (double) data[(len/2)+1];
		}
	}
}
