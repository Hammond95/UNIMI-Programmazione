/* Prof. Boldi Es N°27 */

import java.io.*;
import java.util.*;

public class DotStarShaper {
	
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		try {
			int n = in.nextInt();
			for(int i=1; i<=n; i++) {
				String stars = new String(String.format("%0" + i + "d", 0).replace("0","*"));
				String dots = new String(String.format("%0" + i + "d", 0).replace("0","."));
				System.out.println(dots+stars+"."+stars);
			}
		} catch (Exception e){
			System.out.println(e);
		}
	}
}
