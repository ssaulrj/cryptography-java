package rsafin;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RSAfin {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Abecedario------------------------------------------------------------
        char caracteres[][]={{'a','0','1'},
                             {'b','0','2'},
                             {'c','0','3'},
                             {'d','0','4'},
                             {'e','0','5'},
                             {'f','0','6'},
                             {'g','0','7'},
                             {'h','0','8'},
                             {'i','0','9'},
                             {'j','1','0'},
                             {'k','1','1'},
                             {'l','1','2'},
                             {'m','1','3'},
                             {'n','1','4'},
                             {'ñ','1','5'},
                             {'o','1','6'},
                             {'p','1','7'},
                             {'q','1','8'},
                             {'r','1','9'},
                             {'s','2','0'},
                             {'t','2','1'},
                             {'u','2','2'},
                             {'v','2','3'},
                             {'w','2','4'},
                             {'x','2','5'},
                             {'y','2','6'},
                             {'z','2','7'},
                             {'0','2','8'},
                             {'1','2','9'},
                             {'2','3','0'},
                             {'3','3','1'},
                             {'4','3','2'},
                             {'5','3','3'},
                             {'6','3','4'},
                             {'7','3','5'},
                             {'8','3','6'},
                             {'9','3','7'},
                             {'á','3','8'},
                             {'é','3','9'},
                             {'í','4','0'},
                             {'ó','4','1'},
                             {'ú','4','2'},
                             {' ','4','3'},
                             {'.','4','4'},
                             {',','4','5'},
                             {'¿','4','6'},
                             {'?','4','7'},
                             {'¡','4','8'},
                             {'!','4','9'},
                             {'"','5','0'},
                             {'"','5','1'},
                             {';','5','2'},
                             {'.','5','3'},
                             {'ü','5','4'},
        };
        
        Scanner sc=new Scanner(System.in);
        //Leer archivo de texto-------------------------------------------------
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("texto1.txt")));
        String sCadena,mens1="";
        while ((sCadena = in.readLine())!=null){
            mens1=mens1+sCadena;
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Mensaje:");
        System.out.println(mens1);
        System.out.println("-------------------------------------------------");
        System.out.println("Mensaje en digitos:");
        mens1=mens1.toLowerCase();       
        int tam=mens1.length();
        char texto1[]=mens1.toCharArray();
        String txtdigitos="";
        
        //Convertir caracter a numero-------------------------------------------
        int a=0;
        while(a<tam){
            int aa=0;
            while(aa<54){
                if(texto1[a]==caracteres[aa][0]){
                    txtdigitos=txtdigitos+caracteres[aa][1];
                    txtdigitos=txtdigitos+caracteres[aa][2];
                }
                aa++;
            }
            a++;
        }
        System.out.println(txtdigitos);
        System.out.println("-------------------------------------------------");
        
        
    }
}
