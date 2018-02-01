import java.io.*;
import java.util.*;

public class CoefficienteBinomiale {

	public static void main(String args[]){
		if(args.length==2){
			int n = Integer.parseInt(args[0]);
			int k = Integer.parseInt(args[1]);
			System.out.println(cb(n,k));
		}
	}

	public static int cb (int n, int k){
		if(k==0){
			return 1;
		}
		if(n==0){
			return 0;
		}

		return cb(n-1,k-1) + cb(n-1,k);
	}

}
