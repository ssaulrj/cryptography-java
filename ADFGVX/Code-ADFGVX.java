package cifraadfgvx;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;
import java.util.Arrays;

/* @author Saulp */
public class CifraADFGVX {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
         char matriz [][]={{' ','A','D','F','G','V','X'},
                           {'A','C','Z','X','M','W','O'},
                           {'D','1','P','Q','T','2','3'},
                           {'F','B','F','D','4','7','N'},
                           {'G','5','L','6','K','8','A'},
                           {'V','E','9','G','0','H','Y'},
                           {'X','S','V','I','J','R','U'}    
         };
         
        // Obtener texto--------------------------------------------------------
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("crip4x.txt"),  "UTF8"));
        String sCadena,cadena="";
        while ((sCadena = in.readLine())!=null) {
            cadena=cadena+sCadena;
        }
        cadena=cadena.replace(" ",""); cadena=cadena.replace("-",""); cadena=cadena.replace(",","");
        cadena=cadena.replace(".",""); cadena=cadena.replace("(",""); cadena=cadena.replace(")","");
        cadena=cadena.replace(";",""); cadena=cadena.replace(":","");
        cadena=cadena.toUpperCase();
        cadena=cadena.replace("Á","A");cadena=cadena.replace("É","E");cadena=cadena.replace("Í","I");
        cadena=cadena.replace("Ó","O");cadena=cadena.replace("Ú","U");
        char[] charCadena = cadena.toCharArray();
        int tamcharCadena=charCadena.length; // Obtener el tamaño de la cadena de texto
        System.out.println ("Texto a decodificar:      \"" + cadena +"\""+", Tamaño Texto a codificar:"+ tamcharCadena);
        
        //Texto llano codificado------------------------------------------------
        String cadenaFinal="";
        int estado=1;
        for(int cuenta=0; cuenta<tamcharCadena; cuenta++){
        estado=1;
            for(int bus=1; bus<7; bus++){    
                for(int busX=1; busX<7; busX++){
                    if(charCadena[cuenta]==matriz[bus][busX]){ //fila, columna
                        cadenaFinal=cadenaFinal+matriz[bus][0]+matriz[0][busX];
                        //System.out.println (matriz[bus][busX]);
                        estado=0;
                        break; //
                    } 
                }
                if(estado==0){break;}
            }
        }
        int tamcadenaFinal=cadenaFinal.length(); // Obtener el tamaño de la cadena de texto
        System.out.println ("Texto llano final codificado: \"" + cadenaFinal +"\""+" tamaño:"+tamcadenaFinal);
        char[] charcadenaFinal = cadenaFinal.toCharArray();
        
        //Parte para clave------------------------------------------------------
        String claveTeclado = "";
        int x=0;
        do{ System.out.println ("Introduzca la clave:");
            Scanner entradaEscaner = new Scanner (System.in);
            claveTeclado = entradaEscaner.nextLine (); 
            if(claveTeclado.length()>=4 && claveTeclado.length()<=6){claveTeclado=claveTeclado; x=1;}
            else{claveTeclado=""; System.out.println ("- PORFAVOR Introduzca clave entre 4 & 6 caracteres -"); x=0;}
        }while(x!=1);
        claveTeclado = claveTeclado.replace(" ","");
        claveTeclado=claveTeclado.toUpperCase();
        char[] charclaveTeclado = claveTeclado.toCharArray(); //char de claves
        char[] cO=charclaveTeclado;
        int tamcharclaveTeclado=charclaveTeclado.length; // Obtener el tamaño de la clave
        System.out.println ("Clave introducida: \"" + claveTeclado +"\""+", Tamaño Clave:  "+ tamcharclaveTeclado );
         
        //Hacer nueva tabla con clave-------------------------------------------
        int tamfila=(tamcadenaFinal/tamcharclaveTeclado)+2;
        int totalmatriz=tamcharclaveTeclado*tamfila;
        int totalpalabras=tamcadenaFinal+tamcharclaveTeclado;
        //System.out.println(tamfila+" "+totalmatriz); //Tamaño de fila y de col
        char matrizClave[][]= new char[tamfila][tamcharclaveTeclado];
        
        //Fila 1, donde esta la clave-------------------------------------------
        for(int cuentac=0; cuentac<tamcharclaveTeclado; cuentac++){
             matrizClave[0][cuentac]=charclaveTeclado[cuentac];
             //System.out.println (charclaveTeclado[cuentac]);
        }
        
        //Formar matriz , X de relleno------------------------------------------
        int fila=0;
        for(int cuentac=0; cuentac<tamcadenaFinal; cuentac++){   
            fila=fila+1;
            for(int col=0; col<tamcharclaveTeclado; col++){
                if(cuentac>=tamcadenaFinal){
                    matrizClave[fila][col]='X';
                    //System.out.print (matrizClave[fila][col]);
                    if(col==tamcharclaveTeclado-1){}
                    else{cuentac++;}
                }
                else{
                    matrizClave[fila][col]=charcadenaFinal[cuentac];
                    //System.out.print (charcadenaFinal[cuentac]);
                    if(col==tamcharclaveTeclado-1){}
                    else{cuentac++;}
                }
            }
            //System.out.print ("|");
        }
        
        //Vermatriz-------------------------------------------------------------
        System.out.print ("Matriz de Clave: ");
        for(int f=0; f<tamfila; f++){ 
            System.out.print ("|");
            for(int c=0; c<tamcharclaveTeclado; c++){
                System.out.print (matrizClave[f][c]);
            }
        }
        System.out.print ("\nClave introducida ordenada: \"");
        Arrays.sort(cO); //Ordenar clave en orden alfabetico
        for (char iO : cO) {
            System.out.print(iO + " ");
        }
        System.out.print ("\"");
        
        //Realizar cifrado final------------------------------------------------
        String Cifradofinal="";
        char matrizCF[][]= new char[tamfila][tamcharclaveTeclado];
        for(int ccY=0; ccY<tamcharclaveTeclado; ccY++){
            for(int ccX=0; ccX<tamcharclaveTeclado; ccX++){
                     System.out.print("\n"+cO[ccY]+""+ matrizClave[0][ccX]);
                    if(cO[ccY] == matrizClave[0][ccX]){
                         System.out.print(" - Here");
                        for(int xx=1; xx<tamfila; xx++){
                            matrizCF[xx][ccY]=matrizClave[xx][ccX];
                        }
                        break;
                    }
            }
        }
        
        //Vermatrizfinal--------------------------------------------------------
        System.out.print ("\nMatriz cifrado final");
        for(int f=1; f<=fila; f++){ 
            System.out.print ("|");
            for(int c=0; c<tamcharclaveTeclado; c++){
                Cifradofinal=Cifradofinal+matrizCF[f][c]; //Concatenar resultado final
                System.out.print (matrizCF[f][c]);
            }
        }
        System.out.print ("\nTexto cifrado final cifra ADFGV: "+Cifradofinal);
        //FIN-------------------------------------------------------------------
        
        Cifradofinal = Cifradofinal.replace(" ","");
        //Escribir en archivo
        Writer escribe = null;
                try {
                    escribe = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream("C:\\Users\\Saulp\\Downloads\\Criptografia\\DecoCifraADFGVX\\crip4cod.txt"), "UTF8"));
                    escribe.write(Cifradofinal);
                System.out.println("\nTexto guardado en txt!");       
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    escribe.close();
                }
        //----------------------------------------------------------------------   
    }
}
