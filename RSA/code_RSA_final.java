/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsafinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigInteger;

/**
 *
 * @author PATY
 */
public class RSAfinal {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // generar abecedario
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
                             {'_','5','3'},
                             {'ü','5','4'},
                            };
        String txtdigitos="";
        long e1;
        int p1,q1,n1,m1,d1;
        BigInteger datoE,datoD,varP,varQ,phin,varN,varM,mi,varC;
        
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("Texto1.txt")));
        //BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("RSAcod.txt")));
        String sCadena,mens1="";
        while ((sCadena = in.readLine())!=null){
            mens1=mens1+sCadena;
        }
        System.out.println("Mensaje: "+mens1);
        mens1=mens1.toLowerCase();
        int tam=mens1.length();
        char texto1[]=mens1.toCharArray();
        //convertir caracter a numero
        for(int a=0;a<tam;a++){
            for(int aa=0;aa<54;aa++){
                if(texto1[a]==caracteres[aa][0]){
                    txtdigitos=txtdigitos+caracteres[aa][1];
                    txtdigitos=txtdigitos+caracteres[aa][2];
                }
            }
        }
        System.out.println("Mensaje cifrado: "+txtdigitos);
        char txtdig[]=txtdigitos.toCharArray();
        int tamc=txtdig.length;
        
        e1=13133;  //131312     77527
        p1=151717;  //151717
        q1=171517;  //171517
        varP=BigInteger.valueOf(p1);
        varQ=BigInteger.valueOf(q1);
        datoE=BigInteger.valueOf(e1);
        varN=varP.multiply(varQ);
                     
        phin=varP.subtract(BigInteger.ONE).multiply(varQ.subtract(BigInteger.ONE));
        datoD=datoE.modInverse(phin);
        
        System.out.println("\np= "+varP+" q= "+varQ+" n= "+varN+" phin= "+phin);
        System.out.println("Llave publica(n,e)= ("+varN+","+datoE+")"+"\tLlave privada(n,d)=("+varN+","+datoD+")\n");
        System.out.println("tamanio="+tamc);
        int var=0;
        int resta=tamc%10, filas=(tamc/10);
        char txtcifrado[][]=new char [filas][10];
        char txtcifrado2[]=new char[resta];
        String mtxt="",txtfin="",nzeros;
        BigInteger txtaux[];
        int txttam=0;
        //BigInteger bigIntegerStr;
        
        //dividir en bloques de 10 digitos
        for(int b=0;b<filas;b++){
            for(int c=0;c<10;c++){
                txtcifrado[b][c]=txtdig[var];
                //System.out.print(txtcifrado[b][c]);
                var++;
            }
            //System.out.println("");
        }
        
        if(resta!=0){
            int var2=(tamc-resta);
            for(int bb=0;bb<resta;bb++){
                txtcifrado2[bb]=txtdig[var2];
                //System.out.print(txtcifrado2[bb]);
                var2++;
            }
            //System.out.println("");
        }
        //cifra-descifra
        for(int b=0;b<filas;b++){
            mtxt="";
            for(int c=0;c<10;c++){
                mtxt=mtxt+txtcifrado[b][c];
            }
            mi=new BigInteger(mtxt);
            System.out.println(mi);
            varC=mi.modPow(datoE,varN);
            txtfin=txtfin+varC.toString()+"&";
            System.out.println("c= "+txtfin);
        }
        mtxt="";
        if(resta!=0){
            
            for(int bb=0;bb<resta;bb++){
                mtxt=mtxt+txtcifrado2[bb];
            }
            mi=new BigInteger(mtxt);
            System.out.println(mi);
            varC=mi.modPow(datoE,varN);
            txtfin=txtfin+varC.toString();
            System.out.println("c= "+txtfin);
        }
        
        System.out.println("txtfin  "+txtfin);
         try(Writer escribe = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("RSAcod.txt")))) {
            escribe.write(txtfin);
            System.out.println("Texto copiado en txt");
        }
        catch (Exception e){
        } 
        
        /*char mensdeco[]=txtfin.toCharArray();
        String txtdeco="",varaux="";
        for(int u=0;u<(txtfin.length());u+=2){
            txtdeco=txtdeco+mensdeco[u];
            txtdeco=txtdeco+mensdeco[u+1];
            //System.out.println(txtdeco+"_"+u);
            for(int uu=0;uu<54;uu++){
                varaux=varaux+caracteres[uu][1];
                varaux=varaux+caracteres[uu][2];
                //System.out.println(varaux+"-"+uu);
                if(varaux.equals(txtdeco)){
                    System.out.print(caracteres[uu][0]);
                    //System.out.println("");
                }
                varaux="";
            }
            txtdeco=""; 
        }*/
        
    }
    
}
