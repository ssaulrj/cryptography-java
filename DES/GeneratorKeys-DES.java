/**/
package des_keys;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/*@author Saulp*/
public class DES_keys {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //----------------------------------------------------------------------
        int table_pc1 [] =
        { 
                         57,49,41,33,25,17, 9, 1,
                         58,50,42,34,26,18,10, 2,
                         59,51,43,35,27,19,11, 3,
                         60,52,44,36,63,55,47,39,
                         31,23,15, 7,62,54,46,38,
                         30,22,14, 6,61,53,45,37,
                         29,21,13, 5,28,20,12, 4
        };
        int table_rot [] =
        { 
                         1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1
        };
        int table_pc2 [] =
        { 
                         14,17,11,24, 1, 5, 3,28,
                         15, 6,21,10,23,19,12, 4,
                         26, 8,16, 7,27,20,13, 2,
                         41,52,31,37,47,55,30,40,
                         51,45,33,48,44,49,39,56,
                         34,53,46,42,50,36,29,32
        };
        //----------------------------------------------------------------------
        // Obtener texto--------------------------------------------------------
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("llave.txt"),  "UTF8"));
        String sCadena,cadena="";
        while ((sCadena = in.readLine())!=null) 
        {
            cadena=cadena+sCadena;
        }
        cadena = cadena.replace(" ","");
        cadena = cadena.toUpperCase();
        char[] charCadena = cadena.toCharArray();
        int tamcharCadena = charCadena.length; // Obtener el tamaño de la cadena de texto
        System.out.println ("llave:     \n" + cadena +", Tamaño Texto a codificar:"+ tamcharCadena);        
        //----------------------------------------------------------------------
        int[] Kmas = new int[56]; //0 a 55
        //int[] C0 = new int[28]; //0 a 27
        //int[] D0 = new int[30]; //0 a 27
        int CyD [][] = new int[34][28]; //0 a 31, 0 a 27
        //Sacar K+ C0 y D0------------------------------------------------------
        for(int x=0; x<56; x++)//generar K+
        {
            Kmas[x] = Integer.parseInt(String.valueOf( charCadena[((table_pc1[x]))-1] )); // -1 ubicacion real de bit
            System.out.print (Kmas[x]);
        }
        int tamKmas = Kmas.length; // Obtener el tamaño de la cadena de texto 
        System.out.print (" , Tamaño K+: "+(tamKmas)+"\n"); 
        //----------------------------------------------------------------------        
        for(int x=0; x<28; x++)//recorrer y asignar c0 y d0, ver c0, []fila[]columna
        {
            CyD[0][x] = Kmas[x];
            CyD[1][x] = Kmas[x+28];
            System.out.print (CyD[0][x]);
        }
        System.out.print (" , C0 \n");       
        for(int x=0; x<28; x++)//ver d0
        {
            System.out.print (CyD[1][x]);
        }
        System.out.print (" , D0 \n");
        //----------------------------------------------------------------------
        //Sacar C1 D1 a C16 D16-------------------------------------------------
        //int cuentax=0;
        int cuentarot=0;
        int ubicax=0;
        for(int x=2; x<34; x++)//recorrer 
        {   
            //if(cuentax==2){cuentarot++; cuentax=0;}
            ubicax=(table_rot[cuentarot]);
            for(int xx=(28-ubicax) ; xx<28; xx++)//
            {
                CyD[x  ][xx-(28-ubicax)] = CyD[x-2][ xx ]; //Para C(28-ubicax) 
                CyD[x+1][xx-(28-ubicax)] = CyD[x-1][ xx ]; //Para D 
                //cuentax++;
                //System.out.print (CyD[x  ][xx-27]);  
            }
            for(int xx=0 ; xx<28; xx++)//
            {
                if((xx+ubicax)<=27)
                {
                    CyD[x  ][xx+ubicax] = CyD[x-2][ xx ]; //Para C
                    CyD[x+1][xx+ubicax] = CyD[x-1][ xx ]; //Para D 
                    //System.out.print (CyD[x  ][xx+ubicax]); 
                }
            }
            System.out.println ("Rotacion: "+cuentarot+" Ubicax: "+ubicax);
            x++;
            cuentarot++; 
            //cuentax++;
            //x++; //aumentar en 2 la posicion
        }
        //----------------------------------------------------------------------
        System.out.println ("\nCxy||Dxy: "); 
        for(int x=0; x<34; x++)//recorrer 
        {
            for(int xx=0; xx<28; xx++)//recorrer 
            {
            System.out.print (CyD[x][xx]); 
            }
            System.out.println ("-"+x); 
        }  
        //----------------------------------------------------------------------        
        int CconD [][] = new int[16][56]; //0 a 15, 0 a 55
        int filas=0;
        for(int x=0; x<16; x++)//recorrer 
        {
            for(int xx=0; xx<28; xx++)//recorrer 
            {
                CconD[x][xx]   =CyD[filas+2][ xx ];
                CconD[x][xx+28]=CyD[filas+3][ xx ];
            }
            filas=filas+2;
            //x++;
        }
        //----------------------------------------------------------------------         
        System.out.println ("\nCx||Dx: "); 
        for(int x=0; x<16; x++)//recorrer 
        {
            for(int xx=0; xx<56; xx++)//recorrer 
            {
                System.out.print (CconD[x][xx]); 
            }
            System.out.println ("--"+x); 
        }
        //----------------------------------------------------------------------
        int Keys [][] = new int[16][48]; //0 a 15, 0 a 55
        System.out.println ("\nLlaves: "); 
        for(int x=0; x<16; x++)//generar K+
        {
            for(int xx=0; xx<48; xx++)//generar K+
            {
                Keys[x][xx] = CconD[x][ (Integer.parseInt(String.valueOf( (((table_pc2[xx]))-1)))) ] ; // -1 ubicacion real de bit
                System.out.print (Keys[x][xx]);
            }
            System.out.println (" ---"+x); 
        }
        //System.out.print ( Integer.parseInt(String.valueOf( (((table_pc2[xx]))-1)  ) ) );
        //----------------------------------------------------------------------
        //------------------------------The end---------------------------------
    }
}
