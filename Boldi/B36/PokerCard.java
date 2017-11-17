/* Prof. Boldi Es B36 
 * 
 * Estrazione di una carta da un mazzo di carte da poker
 */

import java.io.*;
import java.util.*;

public class PokerCard {

	public static void main (String args[]){
		int value = (int) (Math.random() * 12) + 1;
		int suit = (int) (Math.random() * 3) + 1;

		String suits = new String(" ♠♥♦♣");

		//System.out.println(suits);

		switch (value) {
			case 1 : System.out.println("A"+suits.charAt(suit)); break;
			case 11: System.out.println("J"+suits.charAt(suit)); break;
			case 12: System.out.println("Q"+suits.charAt(suit)); break;
			case 13: System.out.println("K"+suits.charAt(suit)); break;
			default: System.out.println(""+value+suits.charAt(suit));
		}
	}
}
