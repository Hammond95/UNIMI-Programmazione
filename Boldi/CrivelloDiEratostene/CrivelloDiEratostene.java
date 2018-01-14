import java.io.*;
import java.util.*;

public class CrivelloDiEratostene {

    public static void crivello(int da, int a){
        //L'array è inizializzato a false
        boolean[] criv = new boolean[a+1];

        for(int x=da; x<=a; x++){
            if(criv[x]==false){
                int mult=2*x;
                while(mult<=a){
                    criv[mult]=true;
                    mult+=x;
                }
            }
        }

        for(int x=da; x<=a; x++){
            if(criv[x]==false){
                System.out.println(x);
            }
        }
    }
}
