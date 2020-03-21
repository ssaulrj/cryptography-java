package decocifraadfgvx;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;
/* @author Saulp*/
public class DecoCifraADFGVX {
    public static void main(String[] args) throws IOException {
        char matriz [][]={ {' ','A','D','F','G','V','X'},
                           {'A','C','Z','X','M','W','O'},
                           {'D','1','P','Q','T','2','3'},
                           {'F','B','F','D','4','7','N'},
                           {'G','5','L','6','K','8','A'},
                           {'V','E','9','G','0','H','Y'},
                           {'X','S','V','I','J','R','U'}    
         };      
        
        // Obtener texto--------------------------------------------------------
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("x.txt"),  "UTF8"));
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
        claveTeclado= claveTeclado.toUpperCase();
        char[] charclaveTeclado = claveTeclado.toCharArray(); //char de claves -- TACO
        
        int tamcharclaveTeclado=charclaveTeclado.length; // Obtener el tamaño de la clave
        System.out.println ("Clave introducida: \"" + claveTeclado +"\""+", Tamaño Clave:  "+ tamcharclaveTeclado );
        
        char[] cO = new char[tamcharclaveTeclado];
        for(int v=0; v<tamcharclaveTeclado; v++){
            cO[v]=charclaveTeclado[v];
        }
        System.out.print ("\nClave introducida ordenada: \"");
        Arrays.sort(cO); //Ordenar clave en orden alfabetico
        for (char iO : cO) {
            System.out.print(iO + " ");
        }
        System.out.print ("\"");
        
        //Realizar cifrado contra clave ordenada y clave normal-----------------
        int tamcadenaFinal=cadena.length(); // Obtener el tamaño de la cadena de texto
        int tamfila=(tamcadenaFinal/tamcharclaveTeclado)+2;
        char matrizCF[][]= new char[tamfila][tamcharclaveTeclado];
        char matrizOR[][]= new char[tamfila][tamcharclaveTeclado];

        //Fila 0, donde esta la clave-------------------------------------------
        for(int cuentacc=0; cuentacc<tamcharclaveTeclado; cuentacc++){
             matrizCF[0][cuentacc]=cO[cuentacc];
             System.out.print (cO[cuentacc]);
        }
        int fila=0;
        for(int cuentac=0; cuentac<tamcharCadena; cuentac++){   
            fila=fila+1;
            for(int col=0; col<tamcharclaveTeclado; col++){
                    matrizCF[fila][col]=charCadena[cuentac];
                    System.out.print (charCadena[cuentac]);
                    if(col==tamcharclaveTeclado-1){}
                    else{cuentac++;}
            }
            System.out.print ("|");
        }
        
        //Realizar cifrado contra clave ordenada y clave normal-----------------
        for(int cuentacCC=0; cuentacCC<tamcharclaveTeclado; cuentacCC++){
             matrizOR[0][cuentacCC]=charclaveTeclado[cuentacCC];
             //System.out.print (charclaveTeclado[cuentacCC]);
        }
        for(int ccY=0; ccY<tamcharclaveTeclado; ccY++){ //For de clave
            for(int ccX=0; ccX<tamcharclaveTeclado; ccX++){ //for de columna
                    //System.out.print("\n"+charclaveTeclado[ccY]+""+ matrizCF[0][ccX]); //Ver que caracteres compara
                    if(charclaveTeclado[ccY] == matrizCF[0][ccX]){
                        //System.out.print(" - Here"); //Posicion donde la encuentra 
                        for(int xx=1; xx<tamfila; xx++){ //For de 
                            matrizOR[xx][ccY]=matrizCF[xx][ccX];
                        }
                        break;
                    }
            }
        }
        //VermatrizORDENADOconclave---------------------------------------------
        
        int tamm= tamcharclaveTeclado*tamfila;
        char[] llanodeco = new char[tamm];
        System.out.print ("\nMatriz de Clave: ");
        
        int p1=0;
        for(int fff=1; fff<tamfila; fff++){ 
            System.out.print ("|");
            for(int ccc=0; ccc<tamcharclaveTeclado; ccc++){
                System.out.print (matrizOR[fff][ccc]);  
                llanodeco[p1] = matrizOR[fff][ccc];
                p1++;
            }
        }
        
        int tamllanodeco=llanodeco.length; // Obtener el tamaño 
        
        System.out.print ("\nTexto llano deco: ");
        for(int tl1=0; tl1<tamllanodeco; tl1++){ 
            System.out.print (llanodeco[tl1]+" ");
        }
        System.out.println (tamllanodeco);
        
        //Decodificacion final
        String textoEncontrada="";  //Poner clave que se encuentre de matlab
        for(int aa=0; aa<tamllanodeco; aa++){ // aa de cada clave 
                for(int filasss=0; filasss<7; filasss++){ //ver por filas
                    //System.out.print (llanodeco[aa]+" "); //ver fila que va
                    if(llanodeco[aa] == matriz[filasss][0]){
                        for(int ax=0; ax<7; ax++){ 
                            //System.out.print (llanodeco[aa+1]+"|"); //ver la columna en la que va
                            if(llanodeco[aa+1] == matriz[0][ax]){
                                textoEncontrada = textoEncontrada + matriz[filasss][ax];
                                break;
                            }
                        }
                        break;
                    }
                }
            aa=aa+1;
        }
        System.out.print ("\nTexto decodificado final: "+textoEncontrada);
    }
}
