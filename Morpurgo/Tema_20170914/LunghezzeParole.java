/********************************************************************************************
 * Scrivere una applicazione (una classe “LunghezzeParole” dotata del metodo main) che,
 * dato un certo numero (non noto a priori) di parole su standard input 
 * (separate da “whitespace”,cioè spazi, tab, enter, ecc.), visualizzi su standard output 
 * il numero massimo, medio (troncato all’intero) e minimo di caratteri presenti nelle parole 
 * in input. 
 * Si assuma che l’input contenga almeno una riga di testo non vuota.  L’input termina con
 * fine file (i.e., in sistemi Linux la pressione simultanea dei tasti “Ctrl” e “d”).
 * Il numero di parole presenti in input non è noto a priori e può essere disposto su più
 * righe anch’esso non noto a priori.
 * 
 * Esempi
 * ---------------------------------------
 * Ad esempio se l’input fosse:
 *      ========================================
 *      abab    cdcd        efefefe
 *          ggg hihih mnomnomno
 *      ========================================
 * l’output dovrebbe essere il seguente:
 *      ========================================
 *      max: 9
 *      med: 5
 *      min: 3
 *      ========================================
 *      
 *  ----------------------------------------
 *  
 *  Se l’input invece fosse:
 *      ========================================
 *      enea ecuba
 *                  penelope
 *                  
 *                  
 *      achille                briseide
 *      =======================================
 *  L'output dovrebbe essere il seguente:
 *      ========================================
 *      max: 8
 *      med: 6
 *      min: 4
 *      ========================================        
 ********************************************************************************************/
import java.io.*;
import java.util.*;

public class LunghezzeParole {

        public static void main (String args[]){
                Scanner in = new Scanner(System.in);
                StringBuilder sb = new StringBuilder();
                /* Reading Input until CTRL-D is pressed */
                while(in.hasNextLine())
                {       String line = in.nextLine();
                        sb.append(line+" ");
                }
                in.close();
                String input=sb.toString();
                /* Converting tabs and newline to space
                 * in order to have a single separator.*/
                input = new String(input.replaceAll("\t"," "));
                input = new String(input.replaceAll("$"," "));
                int counter=0, sum=0, words=0, max=0, min=-1;
                for(int i=0; i<input.length(); i++){
                        if(input.charAt(i)==' ' || i==(input.length()-1)){
                                if(counter!=0){
                                        if(counter > max)            max=counter;
                                        if(counter < min || min==-1) min=counter;
                                        sum+=counter;
                                        words++;
                                }
                                counter=0;
                        }
                        counter = counter + isLetter(input.charAt(i));
                }

                System.out.println("max: "+max);
                if(sum!=0 && words!=0)
                        System.out.println("media: "+(sum/words));
                else
                        System.out.println("media: 0");
                System.out.println("min: "+min);
        }

        public static int isLetter(char x){
                return (Character.isLetter(x)==true) ? 1 : 0;
        }
}
