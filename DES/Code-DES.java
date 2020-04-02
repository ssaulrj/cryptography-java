/**/
package estructurafeistel;

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

/*@author Saulp*/
public class EstructuraFeistel {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        //----------------------------------------------------------------------
        int table_keys [][] =
        { 
                        {1,0,1,0,0,1,1,0,0,0,0,1,0,1,0,0,1,1,1,0,1,1,1,0,1,1,0,0,0,1,1,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,0,0}, //0
                        {1,1,1,0,0,0,0,1,1,1,1,1,0,1,1,1,1,0,0,0,1,1,0,0,0,1,1,1,0,1,0,1,1,1,0,0,0,1,0,1,1,1,1,1,1,1,0,0}, //1
                        {1,1,1,0,1,0,0,1,0,1,1,0,1,1,1,0,0,1,1,0,0,0,1,1,0,1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,0,1,0,1,1,0}, //2
                        {1,0,0,1,0,0,1,0,1,0,1,1,1,1,0,1,0,1,1,0,0,0,1,1,1,0,1,0,1,1,1,1,0,0,0,0,1,1,1,1,0,1,1,0,1,0,1,1}, //3
                        {0,1,0,0,0,1,0,0,1,1,1,1,1,0,1,1,1,0,1,0,1,1,0,0,1,1,1,1,0,1,1,1,1,0,1,1,0,1,0,1,1,0,1,1,0,0,1,1}, //4
                        {1,1,0,0,1,0,0,1,0,1,0,0,1,1,1,0,0,1,0,1,1,1,0,0,0,0,1,0,0,0,1,0,1,1,1,1,1,0,1,0,1,1,0,1,1,1,1,1}, //5
                        {1,0,0,1,1,0,1,0,0,0,1,1,0,1,0,0,0,1,1,0,1,1,0,1,1,1,1,1,1,1,0,0,0,1,1,0,1,0,0,1,1,1,1,0,1,1,0,1}, //6
                        {0,0,1,1,1,1,1,0,0,0,1,1,1,0,1,1,1,0,1,0,1,0,0,0,0,1,0,1,1,1,1,1,0,0,1,1,0,1,1,0,1,0,1,0,0,1,1,0}, //7
                        {0,1,1,1,0,1,0,1,0,1,0,0,1,1,1,1,0,0,0,0,1,0,1,1,1,0,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,0,1,1,0,0}, //8
                        {1,0,0,1,1,0,0,0,1,1,1,0,0,1,0,1,1,1,0,1,1,0,1,1,1,1,0,1,0,1,1,1,1,0,1,0,0,1,1,0,0,0,1,1,1,1,1,1}, //9
                        {0,1,0,0,1,0,1,1,1,1,1,1,1,0,0,1,1,1,1,0,1,0,0,0,1,1,1,0,0,0,0,1,1,1,0,1,1,0,1,0,1,1,0,1,0,0,1,1}, //10
                        {0,1,1,0,1,1,1,1,0,1,0,1,1,1,1,0,0,1,0,0,0,0,0,1,1,0,1,1,1,1,0,1,0,1,1,0,1,0,0,1,1,1,1,1,1,1,0,0}, //11
                        {1,0,0,0,0,1,1,0,0,0,1,1,0,1,1,1,0,1,0,1,1,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,1,1,1,1,0,0,1,1,0,1,1,0}, //12
                        {1,0,0,0,1,1,0,0,1,1,1,1,1,0,1,1,0,0,1,1,1,0,0,0,1,0,1,1,1,0,1,1,1,1,0,1,1,1,0,0,0,0,1,0,1,0,1,1}, //13
                        {1,1,1,1,1,0,1,0,0,1,0,0,1,0,1,0,0,1,1,1,0,0,0,0,0,1,1,1,1,0,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,0,1}, //14
                        {0,1,0,1,0,0,0,0,1,0,0,1,0,1,1,1,1,1,0,1,0,0,1,1,1,1,0,0,1,0,0,1,1,0,1,1,1,1,0,0,1,1,0,0,1,0,1,1}, //15
        };
        int table_PI [] =
        { 
                         58,50,42,34,26,18,10, 2,
                         60,52,44,36,28,20,12, 4,
                         62,54,46,38,30,22,14, 6,
                         64,56,48,40,32,24,16, 8,
                         57,49,41,33,25,17, 9, 1,
                         59,51,43,35,27,19,11, 3,
                         61,53,45,37,29,21,13, 5,
                         63,55,47,39,31,23,15, 7
        };
        int table_E [] =
        {  
                         32, 1, 2, 3, 4, 5,
                          4, 5, 6, 7, 8, 9,
                          8, 9,10,11,12,13,
                         12,13,14,15,16,17,
                         16,17,18,19,20,21,
                         20,21,22,23,24,25,
                         24,25,26,27,28,29,
                         28,29,30,31,32, 1
        };
        int table_S1 [][] = 
        {
                        {14, 4,13, 1, 2,15,11, 8, 3,10, 6,12, 5, 9, 0, 7},
                        { 0,15, 7, 4,14, 2,13, 1,10, 6,12,11, 9, 5, 3, 8},
                        { 4, 1,14, 8,13, 6, 2,11,15,12, 9, 7, 3,10, 5, 0},
                        {15,12, 8, 2, 4, 9, 1, 7, 5,11, 3,14,10, 0, 6,13},
        }; 
        int table_S2 [][] = 
        {
                        {15, 1, 8,14, 6,11, 3, 4, 9, 7, 2,13,12, 0, 5,10},
                        { 3,13, 4, 7,15, 2, 8,14,12, 0, 1,10, 6, 9,11, 5},
                        { 0,14, 7,11,10, 4,13, 1, 5, 8,12, 6, 9, 3, 2,15},
                        {13, 8,10, 1, 3,15, 4, 2,11, 6, 7,12, 0, 5,14, 9},
        }; 
        int table_S3 [][] = 
        {
                        {10, 0, 9,14, 6, 3,15, 5, 1,13,12, 7,11, 4, 2, 8},
                        {13, 7, 0, 9, 3, 4, 6,10, 2, 8, 5,14,12,11,15, 1},
                        {13, 6, 4, 9, 8,15, 3, 0,11, 1, 2,12, 5,10,14, 7},
                        { 1,10,13, 0, 6, 9, 8, 7, 4,15,14, 3,11, 5, 2,12},
        }; 
        int table_S4 [][] = 
        {
                        { 7,13,14, 3, 0, 6, 9,10, 1, 2, 8, 5,11,12, 4,15},
                        {13, 8,11, 5, 6,15, 0, 3, 4, 7, 2,12, 1,10,14, 9},
                        {10, 6, 9, 0,12,11, 7,13,15, 1, 3,14, 5, 2, 8, 4},
                        { 3,15, 0, 6,10, 1,13, 8, 9, 4, 5,11,12, 7, 2,14},
        }; 
        int table_S5 [][] = 
        {
                        { 2,12, 4, 1, 7,10,11, 6, 8, 5, 3,15,13, 0,14, 9},
                        {14,11, 2,12, 4, 7,13, 1, 5, 0,15,10, 3, 9, 8, 6},
                        { 4, 2, 1,11,10,13, 7, 8,15, 9,12, 5, 6, 3, 0,14},
                        {11, 8,12, 7, 1,14, 2,13, 6,15, 0, 9,10, 4, 5, 3},
        }; 
        int table_S6 [][] = 
        {
                        {12, 1,10,15, 9, 2, 6, 8, 0,13, 3, 4,14, 7, 5,11},
                        {10,15, 4, 2, 7,12, 9, 5, 6, 1,13,14, 0, 11,3, 8},
                        { 9,14,15, 5, 2, 8,12, 3, 7, 0, 4,10, 1,13,11, 6},
                        { 4, 3, 2,12, 9, 5,15,10,11,14, 1, 7, 6, 0, 8,13},
        }; 
        int table_S7 [][] = 
        {
                        { 4,11, 2,14,15, 0, 8,13, 3,12, 9, 7, 5,10, 6, 1},
                        {13, 0,11, 7, 4, 9, 1,10,14, 3, 5,12, 2,15, 8, 6},
                        { 1, 4,11,13,12, 3, 7,14,10,15, 6, 8, 0, 5, 9, 2},
                        { 6,11,13, 8, 1, 4,10, 7, 9, 5, 0,15,14, 2, 3,12},
        }; 
        int table_S8 [][] = 
        {
                        {13, 2, 8, 4, 6,15,11, 1,10, 9, 3,14, 5, 0,12, 7},
                        { 1,15,13, 8,10, 3, 7, 4,12, 5, 6,11, 0,14, 9, 2},
                        { 7,11, 4, 1, 9,12,14, 2, 0, 6,10,13,15, 3, 5, 8},
                        { 2, 1,14, 7, 4,10, 8,13,15,12, 9, 0, 3, 5, 6,11},
        }; 
        int table_P [] =
        { 
                         16, 7,20,21,
                         29,12,28,17,
                          1,15,23,26,
                          5,18,31,10,
                          2, 8,24,14,
                         32,27, 3, 9,
                         19,13,30, 6,
                         22,11, 4,25
        };
        int table_PF [] =
        { 
                         40, 8,48,16,56,24,64,32,
                         39, 7,47,15,55,23,63,31,
                         38, 6,46,14,54,22,62,30,
                         37, 5,45,13,53,21,61,29,
                         36, 4,44,12,52,20,60,28,
                         35, 3,43,11,51,19,59,27,
                         34, 2,42,10,50,18,58,26,
                         33, 1,41, 9,49,17,57,25
        };
        //----------------------------------------------------------------------
        String opcione="";
        String archi="";
        Scanner teclado = new Scanner(System.in);
        System.out.print("Codificar(1) o decodificar(2)?: ");
        opcione = teclado.nextLine();
        System.out.println("¡Elegiste (" + opcione + ")!\n");
        String sCadena="",cadena="",cadenaBits="",cadenaBitsaux="";
        // Obtener texto--------------------------------------------------------
        if(opcione.equals("1")){ archi="2.txt";  } //aumentar valor de llave
        else if(opcione.equals("2")){ archi="ML.txt"; } //disminuir valor de llave
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(archi),  "UTF8"));    
        //String letras ="oso", n;
        while ((sCadena = in.readLine())!=null) 
        {
            cadena=cadena+sCadena;
        }
        cadena = cadena.toUpperCase();
        //cadena = cadena.replace(" ","");
        System.out.print ("Texto: "+cadena+"\n");
        System.out.print ("Tamaño de texto: "+cadena.length()+"\n");
        if(opcione.equals("2")){
            cadenaBits = cadena; 
            cadenaBits = cadenaBits.replace(" ","");
        }
        /*
        else if(opcione.equals("1")){ //Para decodificador
            int xc=0;
            for (int i=0; i<cadena.length(); i++){
                xc=cadena.charAt(i);
                cadenaBitsaux=Integer.toBinaryString(xc);
                while(cadenaBitsaux.length()!=8){cadenaBitsaux="0"+cadenaBitsaux;} //Agregar 0s a la izquierda si no son de 8 bits
                cadenaBits=cadenaBits+" "+cadenaBitsaux;
            }
            System.out.print("Texto binario: "+cadenaBits+"\n");
            cadenaBits = cadenaBits.replace(" ","");

            int val=0;
            int cuantosval=0;
            while(val!=1){
                int resto;
                int numero1 = cadenaBits.length();
                int numero2 = 64;
                resto = numero1%numero2;
                if (resto==0){
                    System.out.println(numero1 + " es múltiplo de " + numero2);
                    val=1;
                } 
                else{
                    cadenaBits=cadenaBits+"0"; //Hacer que sea multiplo de 64
                    //System.out.println(numero1 + " NO es múltiplo de " + numero2); //Hacer que sea multiplo de 64
                    val=0;
                    cuantosval++;
                } 
            }
            System.out.print ("Ceros agregados: "+cuantosval+"\n");
        }*/
        int veces = (cadenaBits.length()/64);
        System.out.print ("Veces de proceso: "+veces+"\n");
        //System.out.print("Texto binario: "+cadenaBits+"\n");
        System.out.print ("Tamaño de texto en bits: "+cadenaBits.length()+"\n");
        //Escribir en archivo---------------------------------------------------
        Writer escribe = null;
                try {
                    escribe = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream("1.txt"), "UTF8"));
                    escribe.write(cadenaBits);
                System.out.println("-Texto bits en 1.txt!-");       
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    escribe.close();
                }
        //----------------------------------------------------------------------
        
        //----------------------------------------------------------------------
        char[] charcadenaBits = cadenaBits.toCharArray();
        char[][] arreglosTexto = new char[veces][64]; //Filas veces, Columnas 0 a 63
        int var=0;
        for(int x=0; x<veces; x++)//filas
        {
            for(int y=0; y<64; y++)//columnas
            {
                arreglosTexto[x][y] = charcadenaBits[var];
                var++;
            }
        }
        //----------------------------------------------------------------------
        for(int x=0; x<veces; x++)//filas
        {
            for(int y=0; y<64; y++)//columnas
            {
                //System.out.print (arreglosTexto[x][y]);
            }
            //System.out.print ("\n");
        }
        //----------------------------------------------------------------------
            int[] IPdeM = new int[64]; //0 a 63
            int[] L = new int[32]; //0 a 31
            int[] R = new int[32]; //0 a 31
            int[] Laux = new int[32]; //0 a 31
            int[] Raux = new int[32]; //0 a 31
            int[] Xaux = new int[32]; //0 a 31
            int[] Lnext = new int[32]; //0 a 31
            int[] Rnext = new int[32]; //0 a 31
            int[] E = new int[48]; //0 a 47
            int[] ExorK = new int[48]; //0 a 47
            int[] SB = new int[8]; //0 a 7
            int[][] SBdivide = new int[8][6]; //0 a 7,0 a 5
            int[][] SBcomplete = new int[8][4]; //0 a 7,0 a 5
            int[] SBcompleted = new int[32]; //0 a 31
            int[] PSB = new int[32]; //0 a 31
            int[] RconL = new int[64]; //0 a 63
            int[] PermutacionFinal = new int[64]; //0 a 63
        int cuentaveces=0;
        String permutacionfinalTODOS="";
        
        
        while(cuentaveces<veces){
            //char[] charCadena = cadena.toCharArray();
            //int tamcharCadena = charCadena.length; // Obtener el tamaño de la cadena de texto
            //System.out.print ("Hi "+cuentaveces+"\n");
                       
            //IP(M)-------------------------------------------------------------
            for(int x=0; x<64; x++)//generar ip(m)
            {
                IPdeM[x] = Integer.parseInt(String.valueOf( arreglosTexto[cuentaveces][ ((table_PI[x]))-1 ] )); // -1 ubicacion real de bit
                //System.out.print (IPdeM[x]);
            }
            //LyR---------------------------------------------------------------
            //System.out.print (" - IP(m)\n");
            for(int x=0; x<32; x++)//
            {
                L[x] = IPdeM[x];
                R[x] = IPdeM[x+32];
                //System.out.print (L[x]);
            }
            //System.out.print (" - L \n");
            for(int x=0; x<32; x++)//
            {
                //System.out.print (R[x]);
            }
            //System.out.print (" - R \n");
            //Laux=L, Raux=R, Lnext=Raux----------------------------------------
            for(int x=0; x<32; x++)//
            {
                Laux[x]=L[x];
                Raux[x]=R[x];
                Lnext[x]=Raux[x];
            }
            //Etapas inicio-----------------------------------------------------
            int valueKey=15;
            if(opcione.equals("2")){ valueKey=15;  } //aumentar valor de llave
            //if(opcione.equals("2")){ valueKey=15; } //disminuir valor de llave
            //------------------------------------------------------------------
            for(int LyR=0;LyR<16;LyR++){
                if(LyR==16){ System.out.print ("- WTF \n"); }
                if(valueKey==16){ System.out.print ("- WTFkeys \n"); }
                //System.out.print (LyR+" Inicio \n");
                //L1=R0---------------------------------------------------------    
                for(int x=0; x<32; x++)//
                {
                    Xaux[x]=Lnext[x];
                    //Raux[x]=Rnext[x];
                   //System.out.print (Lnext[x]);
                }
                //System.out.print (" - E(R) \n");
                //System.out.print (" - Lnext \n");
                //E(R0)---------------------------------------------------------
                for(int x=0; x<48; x++)//generar ip(m)
                {
                    E[x] = Integer.parseInt(String.valueOf( Lnext[ ((table_E[x]))-1 ] )); // -1 ubicacion real de bit
                    //System.out.print (E[x]);
                }
                //System.out.print (" - E(R) \n");
                //E xor K-------------------------------------------------------
                for(int x=0; x<48; x++)//generar ip(m)
                {
                    if(E[x] == table_keys[valueKey][x]){
                        ExorK[x] = 0;
                    }
                    else{
                        ExorK[x] = 1;
                    }
                    //System.out.print (ExorK[x]);  
                }
                if(opcione.equals("2")){valueKey=valueKey-1; } //aumentar valor de llave
                //if(opcione.equals("2")){valueKey=valueKey-1; } //disminuir valor de llave
                
                //System.out.print (" - E xor K \n");
                //Dividir ExorK-------------------------------------------------
                for(int dato=0; dato<48; dato++)//dato
                {
                    for(int x=0; x<8; x++)//fila
                    {
                        for(int y=0; y<6; y++)//columna
                        {
                            SBdivide[x][y] = ExorK[dato];
                            dato++; //aumentar valor de dato tras cada asignacion
                        }
                    }
                }
                //Ver SBdivide---------------------------------------------bien                
                for(int x=0; x<8; x++)//fila
                {
                    for(int y=0; y<6; y++)//columna
                    {
                        //System.out.print ( SBdivide[x][y] );
                    }
                    //System.out.print ("\n");
                }
                //B1 - B8-------------------------------------------------------       
                for(int cuenta=0;cuenta<8;cuenta++){ 
                        String bfila   ="";
                        String bcolumna="";
                        bfila   =Integer.toString(SBdivide[cuenta][0])+Integer.toString(SBdivide[cuenta][5]);
                        bcolumna=Integer.toString(SBdivide[cuenta][1])+Integer.toString(SBdivide[cuenta][2])+Integer.toString(SBdivide[cuenta][3])+Integer.toString(SBdivide[cuenta][4]);
                        int decimalFila    = Integer.parseInt(bfila, 2);
                        int decimalColumna = Integer.parseInt(bcolumna, 2);
                        //System.out.print (decimalFila +" "+ decimalColumna+"\n");
                        switch(cuenta){
                            case 0: SB[cuenta] = table_S1[decimalFila][decimalColumna]; break;
                            case 1: SB[cuenta] = table_S2[decimalFila][decimalColumna]; break;
                            case 2: SB[cuenta] = table_S3[decimalFila][decimalColumna]; break;
                            case 3: SB[cuenta] = table_S4[decimalFila][decimalColumna]; break;
                            case 4: SB[cuenta] = table_S5[decimalFila][decimalColumna]; break;
                            case 5: SB[cuenta] = table_S6[decimalFila][decimalColumna]; break;
                            case 6: SB[cuenta] = table_S7[decimalFila][decimalColumna]; break;
                            case 7: SB[cuenta] = table_S8[decimalFila][decimalColumna]; break;
                            default: break;
                        }
                        //System.out.print ( SB[cuenta] +"\n");
                        String SBbinary="";
                        SBbinary = Integer.toBinaryString(SB[cuenta]);
                        while(SBbinary.length()!=4){
                            SBbinary="0"+SBbinary;
                        }
                        //System.out.print ( SBbinary );
                        char[] charSBbinary = SBbinary.toCharArray();
                        for (int y=0;y<4;y++){
                            SBcomplete[cuenta][y]=Character.getNumericValue(charSBbinary[y]);
                            //System.out.print ( SBcomplete[cuenta][y] );
                        }
                        //System.out.print ( "\n" );           
                } 
                //Ver SBcomplete------------------------------------------------               
                int juntarSB=0;
                for(int x=0; x<8; x++)//fila
                {
                    for(int y=0; y<4; y++)//columna
                    {
                        //System.out.print (  SBcomplete[x][y] );
                        SBcompleted[juntarSB] = SBcomplete[x][y]; //para juntar en un solo arreglo
                        juntarSB++; //sumar cuenta de arreglo
                    }
                    //System.out.print ("-arreglo \n");
                }
                //P(SB)---------------------------------------------------------
                for(int x=0; x<32; x++)//generar P(SB)
                {
                    PSB[x] = Integer.parseInt(String.valueOf( SBcompleted[ ((table_P[x]))-1 ] )); // -1 ubicacion real de bit
                    //System.out.print (PSB[x]);
                }
                //System.out.print ("- P(SB) \n");
                //Rnext---------------------------------------------------------
                for(int x=0; x<32; x++)//generar ip(m)
                {
                    if(Laux[x] == PSB[x]){
                        Rnext[x] = 0;
                    }
                    else{
                        Rnext[x] = 1;
                    }
                    //System.out.print (Rnext[x]);  
                }
                //System.out.print ("- Rnext \n");
                if(LyR==15){ 
                    //System.out.print ("- FIN \n"); 
                }
                //Laux=L, Raux=R, Lnext=Raux------------------------------------
                for(int x=0; x<32; x++)//
                {
                    Laux[x]=Lnext[x];
                    Lnext[x]=Rnext[x];
                }
            } 
            //RconL-------------------------------------------------------------
            for(int x=0; x<32; x++)// 
            {
                RconL[x] = Rnext[x];
                RconL[x+32] = Xaux[x];
            }
            //System.out.print ("\n");
            //VerRconL----------------------------------------------------------
            for(int x=0; x<64; x++)// 
            {
                //System.out.print (RconL[x]);
            }
            //System.out.print ("- R||L \n");
            //------------------------------------------------------------------
            int esp=0;
            for(int x=0; x<64; x++)//generar P(SB)
            {
                PermutacionFinal[x] = Integer.parseInt(String.valueOf( RconL[ ((table_PF[x]))-1 ] )); // -1 ubicacion real de bi
                if(esp==8){permutacionfinalTODOS=permutacionfinalTODOS+" "; esp=0;}
                permutacionfinalTODOS=permutacionfinalTODOS+Integer.toString(PermutacionFinal[x]); 
                esp++;
                //System.out.print (PermutacionFinal[x]);
            }
            //System.out.print ("- Permutacion final \n");
            //Fin de R16, L16, tomar Rnext Y Lnext------------------------------
            //------------------------------------------------------------------              
            //------------------------------------------------------------------*
            cuentaveces++;
        }     
           
        System.out.print ("Bits finales: "+permutacionfinalTODOS+"\n");
        //Escribir en archivo---------------------------------------------------
        Writer escribe2 = null;
                try {
                    escribe2 = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream("2.txt"), "UTF8"));
                    escribe2.write(permutacionfinalTODOS);
                System.out.println("-Texto bits en 2.txt!-");       
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    escribe2.close();
                }
        //----------------------------------------------------------------------
        if(opcione.equals("2")){
            String input = permutacionfinalTODOS;
            input = input.replace(" ","");
            String output = "";
            for(int i = 0; i <= input.length() - 8; i+=8)
            {
                int k = Integer.parseInt(input.substring(i, i+8), 2);
                output += (char) k;
            } 
            System.out.println(output);
        }
    } 
}
