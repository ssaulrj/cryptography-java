/**/
package llavespublicas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/* @author Saulp*/
public class LlavesPublicas {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        char caracteres [][]=
        {               //0-53
                        {'a','0','1'}, /*0*/ 
                        {'b','0','2'}, /*0*/
                        {'c','0','3'}, /*0*/ 
                        {'d','0','4'}, /*0*/
                        {'e','0','5'}, /*0*/ 
                        {'f','0','6'}, /*0*/
                        {'g','0','7'}, /*0*/ 
                        {'h','0','8'}, /*0*/
                        {'i','0','9'}, /*0*/ 
                        {'j','1','0'}, /*0*/
                        {'k','1','1'}, /*0*/ 
                        {'l','1','2'}, /*0*/
                        {'m','1','3'}, /*0*/ 
                        {'n','1','4'}, /*0*/
                        {'ñ','1','5'}, /*0*/ 
                        {'o','1','6'}, /*0*/
                        {'p','1','7'}, /*0*/ 
                        {'q','1','8'}, /*0*/
                        {'r','1','9'}, /*0*/ 
                        {'s','2','0'}, /*0*/
                        {'t','2','1'}, /*0*/ 
                        {'u','2','2'}, /*0*/
                        {'v','2','3'}, /*0*/ 
                        {'w','2','4'}, /*0*/
                        {'x','2','5'}, /*0*/ 
                        {'y','2','6'}, /*0*/
                        {'z','2','7'}, /*0*/ 
                        {'0','2','8'}, /*0*/
                        {'1','2','9'}, /*0*/ 
                        {'2','3','0'}, /*0*/
                        {'3','3','1'}, /*0*/ 
                        {'4','3','2'}, /*0*/
                        {'5','3','3'}, /*0*/ 
                        {'6','3','4'}, /*0*/
                        {'7','3','5'}, /*0*/ 
                        {'8','3','6'}, /*0*/
                        {'9','3','7'}, /*0*/ 
                        {'á','3','8'}, /*0*/
                        {'é','3','9'}, /*0*/ 
                        {'í','4','0'}, /*0*/
                        {'ó','4','1'}, /*0*/ 
                        {'ú','4','2'}, /*0*/
                        {' ','4','3'}, /*0*/ 
                        {'.','4','4'}, /*0*/
                        {'/','4','5'}, /*0*/ 
                        {'¿','4','6'}, /*0*/
                        {'?','4','7'}, /*0*/ 
                        {'¡','4','8'}, /*0*/
                        {'!','4','9'}, /*0*/ 
                        {'"','5','0'}, /*0*/
                        {'"','5','1'}, /*0*/
                        {';','5','2'}, /*0*/
                        {'.','5','3'}, /*0*/
                        {'ü','5','4'}, /*0*/
        };
        
        long numeroP = 571717;
        long numeroQ = 577757;
        long numeroPQ = numeroP * numeroQ;
        System.out.println("n : p*q : "+numeroPQ);
        
        long YP = numeroP - 1;
        long YQ = numeroQ - 1;
        long YN = YP * YQ;
               
        System.out.println("Y(p): "+YP+"\nY(q): "+YQ+"\nY(n): Y(p)*Y(q): "+YN);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("m.txt"),  "UTF8"));    
        String sCadena="", cadena="";
        while ((sCadena = in.readLine())!=null) 
        {
            cadena=cadena+sCadena;
        }
        cadena = cadena.toLowerCase();
        //cadena = cadena.replace(" ","");
        System.out.print ("Cadena texto: "+cadena+"\n");
        System.out.print ("Tamaño de texto: "+cadena.length()+"\n");
        
        char[] charcadenaBits = cadena.toCharArray();
        String cadenaNums="",aux="";
        String[] cadenaNumsArray = new String[cadena.length()*2]; //0 a 63
        
        int x=0;
        int y=0;
        for(int t_int=0; t_int<cadena.length(); t_int++){
            for(int enc=0; enc<54; enc++){
                aux="";
                if(charcadenaBits[t_int]==caracteres[enc][0]){
                    cadenaNums=cadenaNums+caracteres[enc][1]+caracteres[enc][2];
                    if(x==9){ x=0; y++; }
                    else{ cadenaNumsArray[y]=cadenaNums; x++; }
                    break;
                }
            }
        }
        
        System.out.print ("Cadena texto a numeros: "+cadenaNums+"\n");
        System.out.print ("Tamaño Cadena texto a numeros: "+cadenaNums.length()+"\n");
        System.out.print ("cadenaNumsArray[0]: "+cadenaNumsArray[0]+"\n");
    } 
}
