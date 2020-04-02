package cifravigenere;
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
/* @author Saulp*/
public class CifraVigenere {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        //------------------------------------------------------------------------------------------------------------------------------------
        //Pedir clave para codificacion, ejemplo: "Nubes"
        char matrizV [][]={{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'}, //1
                           {'B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','A'}, //2
                           {'C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B'}, //3
                           {'D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C'}, //4
                           {'E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D'}, //5
                           {'F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E'}, //6
                           {'G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F'}, //7
                           {'H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G'}, //8
                           {'I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H'}, //9
                           {'J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I'}, //10
                           {'K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J'}, //11
                           {'L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K'}, //12
                           {'M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L'}, //13
                           {'N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M'}, //14
                           {'Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N'}, //15
                           {'O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ'}, //16
                           {'P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O'}, //17
                           {'Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P'}, //18
                           {'R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q'}, //19
                           {'S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R'}, //20
                           {'T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S'}, //21
                           {'U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T'}, //22
                           {'V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U'}, //23
                           {'W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V'}, //24
                           {'X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W'}, //25
                           {'Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X'}, //26
                           {'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y'}, //27
        };
        //------------------------------------------------------------------------------------------------------------------------------------
        //matrizV[2]//fila  [1]//columna //de 0 a 26
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
        int tamcharclaveTeclado=charclaveTeclado.length; // Obtener el tamaño de la clave
        System.out.println ("Clave introducida: \"" + claveTeclado +"\""+", Tamaño Clave:  "+ tamcharclaveTeclado );
        //Obtener texto extension .txt a codificar
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("CRIP3.txt"),  "iso-8859-1"));
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
        System.out.println ("Texto a codificar:      \"" + cadena +"\""+", Tamaño Texto a codificar:"+ tamcharCadena);
        //-------------------------------------------------------------------------------------------------------------------------------------
        //Codificar
        String cadenaFinal="";
        int cuentaClave=0;
        for(int cuenta=0; cuenta<tamcharCadena; cuenta++){
            int ubiX=0,ubiY=0;
            for(int busX=0; busX<26; busX++){
                if(charCadena[cuenta]==matrizV[1][busX]){ //texto
                    ubiX=busX+1; break; //+1 para valor posicion real
                } 
            }
            if(cuentaClave==(tamcharclaveTeclado)){cuentaClave=0;}
            for(int busY=0; busY<26; busY++){ //clave
                if(charclaveTeclado[cuentaClave]==matrizV[busY][1]){ 
                    ubiY=busY+1; break; //+1 para valor posicion real 
                } 
            }
            cuentaClave++;
        //System.out.println ("Ubicacion X: "+ubiX+" Ubicacion Y: "+ubiY+" Letra codificar: "+matrizV[ubiY][ubiX]);
        cadenaFinal=cadenaFinal+matrizV[ubiY][ubiX];
        }
        System.out.println ("Texto final codificado: \"" + cadenaFinal +"\"");
        //------------------------------------------------------------------------------------------------------------------------------------
        //Escribir en archivo
        Writer escribe = null;

                try {
                    escribe = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream("C:\\Users\\Saulp\\Downloads\\Criptografia\\decocifraVigenere\\CRIP3code.txt"), "iso-8859-1"));
                    escribe.write(cadenaFinal);
                System.out.println("\nTexto guardado en txt!");       
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    escribe.close();
                }
        //------------------------------------------------------------------------------------------------------------------------------------
    }
}
