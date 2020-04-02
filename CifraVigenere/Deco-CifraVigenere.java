package decocifravigenere;
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
public class DecocifraVigenere {
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
        //Obtener texto extension .txt a decodificar   , CRIP3codesC0
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("cifrado.txt"),  "UTF8"));
        String sCadena,cadena="";
        while ((sCadena = in.readLine())!=null) {
            cadena=cadena+sCadena;
        }
        cadena=cadena.toUpperCase();
        char[] charCadena = cadena.toCharArray();
        int tamcharCadena=charCadena.length; // Obtener el tamaño de la cadena de texto
        System.out.println ("Texto a decodificar:      \"" + cadena +"\""+", Tamaño Texto a codificar:"+ tamcharCadena);
        
        
        String  revisar3="", revisar4="", revisar5="", revisar6="";
        String revisar3x="",revisar4x="",revisar5x="",revisar6x="";
        revisar3=Character.toString(charCadena[0])+Character.toString(charCadena[1])+Character.toString(charCadena[2]);
        revisar4=Character.toString(charCadena[0])+Character.toString(charCadena[1])+Character.toString(charCadena[2])+Character.toString(charCadena[3]);
        revisar5=Character.toString(charCadena[0])+Character.toString(charCadena[1])+Character.toString(charCadena[2])+Character.toString(charCadena[3])+Character.toString(charCadena[4]);
        revisar6=Character.toString(charCadena[0])+Character.toString(charCadena[1])+Character.toString(charCadena[2])+Character.toString(charCadena[3])+Character.toString(charCadena[4])+Character.toString(charCadena[5]);
        
        int cuenta3=1,cuenta4=1,cuenta5=1,cuenta6=1;
        int  lugares3[] = new int[100]; lugares3[1]=1; int pos3=2;
        int  lugares4[] = new int[100]; lugares4[1]=1; int pos4=2;
        int  lugares5[] = new int[100]; lugares5[1]=1; int pos5=2;
        int  lugares6[] = new int[100]; lugares6[1]=1; int pos6=2;
        
        for(int x=3; x<tamcharCadena-1; x++){
        revisar3x=Character.toString(charCadena[x])+Character.toString(charCadena[x+1])+Character.toString(charCadena[x+2]);
        if(revisar3.equals(revisar3x)){cuenta3=cuenta3+1; lugares3[pos3]=x; pos3++;}
        x=x+2;
        }
        for(int x=4; x<tamcharCadena-2; x++){
        revisar4x=Character.toString(charCadena[x])+Character.toString(charCadena[x+1])+Character.toString(charCadena[x+2])+Character.toString(charCadena[x+3]);
        if(revisar4.equals(revisar4x)){cuenta4=cuenta4+1; lugares4[pos4]=x; pos4++;}
        x=x+3;
        }
        for(int x=5; x<tamcharCadena-4; x++){
        revisar5x=Character.toString(charCadena[x])+Character.toString(charCadena[x+1])+Character.toString(charCadena[x+2])+Character.toString(charCadena[x+3])+Character.toString(charCadena[x+4]);
        if(revisar5.equals(revisar5x)){cuenta5=cuenta5+1; lugares5[pos5]=x; pos5++;}
        x=x+4;
        }
        for(int x=6; x<tamcharCadena-5; x++){
        revisar6x=Character.toString(charCadena[x])+Character.toString(charCadena[x+1])+Character.toString(charCadena[x+2])+Character.toString(charCadena[x+3])+Character.toString(charCadena[x+4])+Character.toString(charCadena[x+5]);
        if(revisar6.equals(revisar6x)){cuenta6=cuenta6+1; lugares6[pos6]=x; pos6++;}
        x=x+5;
        }
        System.out.println ("\n" + revisar3 + " veces: "+(cuenta3));
        System.out.println ("\n" + revisar4 + " veces: "+(cuenta4));
        System.out.println ("\n" + revisar5 + " veces: "+(cuenta5));
        System.out.println ("\n" + revisar6 + " veces: "+(cuenta6));
        System.out.println ("\n");
        for(int c=1; c<lugares3.length; c++){
        if(lugares3[c]!=0){ System.out.println ("Repetida de 3: " + lugares3[c]); }
        }
        System.out.println ("\n");
        for(int c=1; c<lugares4.length; c++){
        if(lugares4[c]!=0){ System.out.println ("Repetida de 4: " + lugares4[c]); }
        }
        System.out.println ("\n");
        for(int c=1; c<lugares5.length; c++){
        if(lugares5[c]!=0){ System.out.println ("Repetida de 5: " + lugares5[c]); }
        }
        System.out.println ("\n");
        for(int c=1; c<lugares6.length; c++){
        if(lugares6[c]!=0){ System.out.println ("Repetida de 6: " + lugares6[c]); }
        } //Revisar posiciones de cada repetido
        
/*       
        char l1,l2,l3,l4,l5;
        char m1,m2,m3,m4,m5;
        
        for(int a=0;a<=(tamcharCadena-5);a+=5){                //veces1=1;
               l1=charCadena[a]; l2=charCadena[a+1]; l3=charCadena[a+2]; l4=charCadena[a+3]; l5=charCadena[a+4];
               pUnion=String.valueOf(l1)+String.valueOf(l2)+String.valueOf(l3)+String.valueOf(l4)+String.valueOf(l5);  
               for(int b=a+5;b<=(tamVig-5);b+=5){
                    m1=charCadena[b]; m2=charCadena[b+1]; m3=vigOracion[b+2]; m4=vigOracion[b+3]; m5=vigOracion[b+4];
                    pComp=String.valueOf(m1)+String.valueOf(m2)+String.valueOf(m3)+String.valueOf(m4)+String.valueOf(m5); //System.out.println(pUnion+"\t"+pComp);
                    if(pUnion.equalsIgnoreCase(pComp)){
                        contp=b-a;
                       // espacioPalabras[cont]=contp;
                        //cont++;
                        //veces1=veces1+1; 
                        //System.out.println(pUnion+"\t"+pComp+"\t"+contp); //Repetidos=pComp.toCharArray(); 
                    }
               }
            }
 */       
        
        //-------------------------------------------------------------------------------------------------------------------------------------        
        int tamClave=5;
        System.out.println ("\nNumero de clave seria: "+tamClave+"\n");
        //-------------------------------------------------------------------------------------------------------------------------------------
        
        String sC0="",sC1="",sC2="",sC3="",sC4="",sC5="";
        /*
        //sC significa subCabena , para 4
        
        for(int r=0; r<tamcharCadena-3; r++){
            sC0=sC0+Character.toString(charCadena[r]); //0
            sC1=sC1+Character.toString(charCadena[r+1]); //1
            sC2=sC2+Character.toString(charCadena[r+2]); //2
            sC3=sC3+Character.toString(charCadena[r+3]); //3
            r=r+3; // llegue a 5 en la primera vuelta
        }
        */
        //sC significa subCabena , para 5
        
        for(int r=0; r<tamcharCadena-4; r++){
            sC0=sC0+Character.toString(charCadena[r]); //0
            sC1=sC1+Character.toString(charCadena[r+1]); //1
            sC2=sC2+Character.toString(charCadena[r+2]); //2
            sC3=sC3+Character.toString(charCadena[r+3]); //3
            sC4=sC4+Character.toString(charCadena[r+4]); //4
            r=r+4; // llegue a 5 en la primera vuelta
        }
        
        //sC significa subCabena , para 6
        /*
        for(int r=0; r<tamcharCadena-3; r++){
            sC0=sC0+Character.toString(charCadena[r]); //0
            sC1=sC1+Character.toString(charCadena[r+1]); //1
            sC2=sC2+Character.toString(charCadena[r+2]); //2
            sC3=sC3+Character.toString(charCadena[r+3]); //3
            sC4=sC4+Character.toString(charCadena[r+4]); //4
            sC5=sC5+Character.toString(charCadena[r+4]); //5
            r=r+5; // llegue a 5 en la primera vuelta
        }
        */
        //System.out.println (sC0+", \n"+sC1+", \n"+sC2+", \n"+sC3+", \n"+sC4);
        //System.out.println (sC[2]);
        
        //System.out.println ("Texto final decodificado: \"" + cadenaFinal +"\"");
        //------------------------------------------------------------------------------------------------------------------------------------
        //Escribir en archivo
        Writer escribe0 = null;
                try {
                    escribe0 = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream("CRIP3decosC0.txt"), "iso-8859-1"));
                    escribe0.write(sC0);
                System.out.println("Texto sC0 guardado en txt!");       
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    escribe0.close();
                }
        //------------------------------------------------------------------------------------------------------------------------------------
        //Escribir en archivo
        Writer escribe1 = null;
                try {
                    escribe1 = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream("CRIP3decosC1.txt"), "iso-8859-1"));
                    escribe1.write(sC1);
                System.out.println("Texto sC1 guardado en txt!");       
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    escribe1.close();
                }
        //------------------------------------------------------------------------------------------------------------------------------------
        //Escribir en archivo
        Writer escribe2 = null;
                try {
                    escribe2 = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream("CRIP3decosC2.txt"), "iso-8859-1"));
                    escribe2.write(sC2);
                System.out.println("Texto sC2 guardado en txt!");       
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    escribe2.close();
                }
        //------------------------------------------------------------------------------------------------------------------------------------
        //Escribir en archivo
        Writer escribe3 = null;
                try {
                    escribe3 = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream("CRIP3decosC3.txt"), "iso-8859-1"));
                    escribe3.write(sC3);
                System.out.println("Texto sC3 guardado en txt!");       
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    escribe3.close();
                }
        //------------------------------------------------------------------------------------------------------------------------------------
        //Escribir en archivo
        Writer escribe4 = null;
                try {
                    escribe4 = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream("CRIP3decosC4.txt"), "iso-8859-1"));
                    escribe4.write(sC4);
                System.out.println("Texto sC4 guardado en txt!");       
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    escribe4.close();
                }
        //------------------------------------------------------------------------------------------------------------------------------------
        //Escribir en archivo
        Writer escribe5 = null;
                try {
                    escribe5 = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream("CRIP3decosC5.txt"), "iso-8859-1"));
                    escribe5.write(sC5);
                System.out.println("Texto sC5 guardado en txt!");       
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    escribe5.close();
                }
        //------------------------------------------------------------------------------------------------------------------------------------
        
        //Decodificar
        String claveEncontrada="SALON";  //Poner clave que se encuentre de matlab
        char[] charclaveTeclado = claveEncontrada.toCharArray();
        int tamcharclaveTeclado;
        tamcharclaveTeclado=charclaveTeclado.length;
        String cadenaFinal="";
        
        int cuentaClave=0;
        int ubiX=0,ubiY=0;
        
        for(int cuenta=0; cuenta<tamcharCadena; cuenta++){
            for(int busY=0; busY<27; busY++){ //clave  
                if(cuentaClave==(tamcharclaveTeclado)){ //Reinicie la clave
                    cuentaClave=0;
                }
                if(charclaveTeclado[cuentaClave]==matrizV[busY][0]){ 
                    ubiY=busY; 
                    //System.out.println (ubiY);
                                for(int busX=0; busX<27; busX++){
                                    if(charCadena[cuenta]==matrizV[ubiY][busX]){ //texto
                                        ubiX=busX; 
                                        //System.out.println (ubiX);
                                        //System.out.println (ubiY+" "+ubiX);
                                        //System.out.println (matrizV[0][ubiX]);
                                        cadenaFinal=cadenaFinal+matrizV[0][ubiX];
                                        //break;
                                    } 
                                }
                    break; //Termine la accion de palabra cuando la encontro
                } 
            } cuentaClave++; //Sume el indice de la clave
        }
        System.out.println ("Texto final decodificado: \"" + cadenaFinal +"\"");
        //------------------------------------------------------------------------------------------------------------------------------------
        //Escribir en archivo
        Writer escribefin = null;
                try {
                    escribefin = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream("cifradofi.txt"), "iso-8859-1"));
                    escribefin.write(cadenaFinal);
                System.out.println("Texto FINAL guardado en txt!");       
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    escribefin.close();
                }
        //------------------------------------------------------------------------------------------------------------------------------------
    }
}
