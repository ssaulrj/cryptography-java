/**/
package simenigma;
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
/* @author Saulp*/
public class SimEnigma { 
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        int estadorotor1=0;
        int estadorotor2=0;
        int estadorotor3=0;   
        int vueltas=0;
        char rotor1 [][]=
        {                    //e0
                        {'A','Z'}, /*0*/ 
                        {'B','A'}, /*1*/ 
                        {'C','M'}, /*2*/
                        {'D','I'}, /*3*/ 
                        {'E','N'}, /*4*/ 
                        {'F','T'}, /*5*/
                        {'G','X'}, /*6*/ 
                        {'H','F'}, /*7*/ 
                        {'I','P'}, /*8*/
                        {'J','V'}, /*9*/ 
                        {'K','B'}, /*10*/
                        {'L','J'}, /*11*/
                        {'M','G'}, /*12*/
                        {'N','R'}, /*13*/
                        {'O','U'}, /*14*/
                        {'P','H'}, /*15*/
                        {'Q','S'}, /*16*/
                        {'R','E'}, /*17*/
                        {'S','L'}, /*18*/
                        {'T','D'}, /*19*/
                        {'U','C'}, /*20*/
                        {'V','Y'}, /*21*/
                        {'W','O'}, /*22*/
                        {'X','W'}, /*23*/
                        {'Y','K'}, /*24*/
                        {'Z','Q'}  /*25*/
        };
        char rotor2 [][]=
        { 
                        {'A','J'}, /*0*/ 
                        {'B','T'}, /*1*/ 
                        {'C','H'}, /*2*/
                        {'D','O'}, /*3*/ 
                        {'E','D'}, /*4*/ 
                        {'F','Y'}, /*5*/
                        {'G','E'}, /*6*/ 
                        {'H','N'}, /*7*/ 
                        {'I','K'}, /*8*/
                        {'J','C'}, /*9*/ 
                        {'K','P'}, /*10*/
                        {'L','X'}, /*11*/
                        {'M','A'}, /*12*/
                        {'N','R'}, /*13*/
                        {'O','I'}, /*14*/
                        {'P','V'}, /*15*/
                        {'Q','G'}, /*16*/
                        {'R','Z'}, /*17*/
                        {'S','L'}, /*18*/
                        {'T','S'}, /*19*/
                        {'U','B'}, /*20*/
                        {'V','F'}, /*21*/
                        {'W','Q'}, /*22*/
                        {'X','M'}, /*23*/
                        {'Y','W'}, /*24*/
                        {'Z','U'}  /*25*/
        };
        char rotor3 [][]=
        { 
                        {'A','U'}, /*0*/ 
                        {'B','V'}, /*1*/ 
                        {'C','L'}, /*2*/
                        {'D','I'}, /*3*/ 
                        {'E','R'}, /*4*/ 
                        {'F','M'}, /*5*/
                        {'G','X'}, /*6*/ 
                        {'H','A'}, /*7*/ 
                        {'I','H'}, /*8*/
                        {'J','D'}, /*9*/ 
                        {'K','Q'}, /*10*/
                        {'L','N'}, /*11*/
                        {'M','Z'}, /*12*/
                        {'N','B'}, /*13*/
                        {'O','S'}, /*14*/
                        {'P','C'}, /*15*/
                        {'Q','K'}, /*16*/
                        {'R','E'}, /*17*/
                        {'S','F'}, /*18*/
                        {'T','O'}, /*19*/
                        {'U','Y'}, /*20*/
                        {'V','T'}, /*21*/
                        {'W','G'}, /*22*/
                        {'X','J'}, /*23*/
                        {'Y','P'}, /*24*/
                        {'Z','W'}, /*25*/
        };
        char reflector [][]=
        { 
                        {'X','L'}, /**/
                        {'T','D'}, /**/
                        {'G','J'}, /**/
                        {'E','Q'}, /**/
                        {'M','R'}, /**/
                        {'H','P'}, /**/
                        {'Y','F'}, /**/
                        {'C','S'}, /**/
                        {'Z','V'}, /**/
                        {'U','K'}, /**/
                        {'B','O'}, /**/
                        {'A','W'}, /**/
                        {'N','I'}, /**/
        };    
        
        // Obtener texto--------------------------------------------------------
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("EnigmaAlan.txt"),  "UTF8"));
        String sCadena,cadena="";
        while ((sCadena = in.readLine())!=null) 
        {
            cadena=cadena+sCadena;
        }
        cadena=cadena.replace(" ",""); cadena=cadena.replace("-",""); cadena=cadena.replace(",","");
        cadena=cadena.replace(".",""); cadena=cadena.replace("(",""); cadena=cadena.replace(")","");
        cadena=cadena.replace(";",""); cadena=cadena.replace(":","");
        cadena=cadena.toUpperCase();
        cadena=cadena.replace("Á","A");cadena=cadena.replace("É","E");cadena=cadena.replace("Í","I");
        cadena=cadena.replace("Ó","O");cadena=cadena.replace("Ú","U");cadena=cadena.replace("Ñ","N");
        char[] charCadena = cadena.toCharArray();
        int tamcharCadena=charCadena.length; // Obtener el tamaño de la cadena de texto
        System.out.println ("Texto a codificar:      \"" + cadena +"\""+", Tamaño Texto a codificar:"+ tamcharCadena);
        
        //------------------------------------------------------inicio,derotores
        //String textcod=""; //no usada
        //Variables de enigma de ida
        char textone=' '; char textone2=' '; //rotor1 ida
        char texttwo=' '; char texttwo2=' '; //rotor2 ida
        char textthr=' '; char textthr2=' '; //rotor3 ida
        
        char textref=' '; char textref2=' '; //reflector ida y vuelta :)
        
        char textoneback=' '; char textone2back=' '; //rotor1 vuelta
        char textonebackx=' ';
        char texttwoback=' '; char texttwo2back=' '; //rotor2 vuelta 
        char texttwobackx=' ';
        char textthrback=' '; char textthr2back=' '; //rotor3 vuelta
        
        int  posletra=0 ; 
        char textfin=' ';
        String textfinal="";
        
        for(int xtext=0; xtext<tamcharCadena; xtext++) //recorrer todo el texto
        {   
            for(int x=0; x<26; x++)//recorrer alfabeto donde entra cada letra
            {
                if(charCadena[xtext]==rotor1[x][0]) //x sera la posicion de la letra en alfabeto
                {   
                    System.out.println(" ------------------ "+charCadena[xtext]);
                    posletra=x; //encuentra la posicion de la palabra en A-Z 
                    //System.out.println(posletra); //Imprimir posicion de letra de entrada
                    int posr1=0; //Encontrar posicion que encajara en rotor1
                    int posr1x=-1; //Encontrar posicion que encajara en rotor2
                    for(int u=estadorotor1; u<26; u++)//recorrer rotor1
                    {   
                        if(posr1==posletra) //encontrar en recorrido la letra
                        {  
                            //System.out.println("\nu"+u); /7variable de for (u)
                            textone =rotor1[u][0]; // valor de izquierda
                            textone2=rotor1[u][1]; // valor de derecha 
                            for(int uu=estadorotor1; uu<26; uu++)//recorrer rotor1, en busca de posicion de salida
                            { 
                                posr1x++;
                                if(textone2==rotor1[uu][0]) //encontrar en recorrido la letra
                                { 
                                    break; // ubicacion encontrada: fin de 
                                }                                 
                                if(uu == 25){ uu=-1; }
                            }
                            break;
                        }
                        if(u == 25){ u=-1; }
                        posr1++;
                    }
                    System.out.println("textone "+textone+" , textone2 "+textone2+"  posicion salida: "+posr1x); //rotor1 izquierda y derecha, posr1x posicion de salida
                    
                    int posr2=0; //Encontrar posicion que encajara en rotor2
                    int posr2x=-1; //Encontrar posicion que encajara en rotor3
                    for(int u=estadorotor2; u<26; u++)//recorrer rotor1
                    {   
                        if(posr2==posr1x) //posr1x palabra que debe encajar con rotor 2 obtenida de rotor 1, por el enlace
                        {  
                            //System.out.println("\nu"+u); /7variable de for (u)
                            texttwo =rotor2[u][0]; // valor de izquierda
                            texttwo2=rotor2[u][1]; // valor de derecha 
                            for(int uu=estadorotor2; uu<26; uu++)//recorrer rotor1, en busca de posicion de salida
                            { 
                                posr2x++;
                                if(texttwo2==rotor2[uu][0]) //encontrar en recorrido la letra
                                { 
                                    break; // ubicacion encontrada: fin de 
                                }                                 
                                if(uu == 25){ uu=-1; }
                            }
                            break;
                        }
                        if(u == 25){ u=-1; }
                        posr2++;
                    }
                    System.out.println("texttwo "+texttwo+" , texttwo2 "+texttwo2+"  posicion salida: "+posr2x); //rotor2 izquierda y derecha, posr2x posicion de salida
                    
                    int posr3=0; //Encontrar posicion que encajara en rotor2
                    int posr3x=-1; //Encontrar posicion que encajara en rotor3
                    for(int u=estadorotor3; u<26; u++)//recorrer rotor1
                    {   
                        if(posr3==posr2x) //posr2x palabra que debe encajar con rotor 3 obtenida de rotor 2, por el enlace
                        {  
                            //System.out.println("\nu"+u); /7variable de for (u)
                            textthr =rotor3[u][0]; // valor de izquierda
                            textthr2=rotor3[u][1]; // valor de derecha 
                            
                            //Codigo de reflector------------------------------v
                            for(int uref=0; uref<13; uref++)//recorrer reflector
                            { 
                                if(textthr2==reflector[uref][0]) //si esta del izquierdo tomo el derecho
                                {
                                    textref=reflector[uref][1];
                                    break;
                                }
                                else if(textthr2==reflector[uref][1]) //Si esta del lado derecho, tomo el izquierdo
                                {
                                    textref=reflector[uref][0];
                                    break;
                                }
                            }
                            //Codigo de reflector------------------------------^
                            for(int uu=estadorotor3; uu<26; uu++)//recorrer rotor3, en busca de posicion de entrada de variable reflector
                            { 
                                posr3x++;
                                if(textref==rotor3[uu][0]) //encontrar en recorrido la letra
                                { 
                                    break; // ubicacion encontrada: fin de 
                                }                                 
                                if(uu == 25){ uu=-1; }
                            }
                            break;
                        }
                        if(u == 25){ u=-1; }
                        posr3++;
                    }
                    //System.out.println("textthr "+textthr+" , textthr2 "+textthr2+" , posicion: "+posr3x); //rotor3 izquierda y derecha, posr3x posicion de salida
                    System.out.println("textthr "+textthr+" , textthr2 "+textthr2); //rotor3 izquierda y derecha
                    System.out.println("Letra Reflector: "+textref +" posicion entrada: "+posr3x);
                    
                    int posr4=0; //Encontrar posicion que encajara en rotor2
                    //int posr4x=-1; //Encontrar posicion que encajara en 
                    for(int u=estadorotor3; u<26; u++)//recorrer rotor1
                    {   
                        if(textref==rotor3[u][1]) //encontrar en recorrido la letra
                        { 
                            textthrback =rotor3[u][0]; // valor de izquierda
                            textthr2back=rotor3[u][1]; // valor de derecha 
                            break; // ubicacion encontrada: fin de 
                        }   
                        if(u == 25){ u=-1; }
                        posr4++;
                    }
                    System.out.println("textthrback "+textthrback+" , textthr2back "+textthr2back+" posicion: "+posr4); //rotor3 izquierda y derecha
                    
                    int posr5=0; //Encontrar posicion que encajara en 
                    int posr5x=0; //Encontrar posicion que encajara en 
                    for(int u=estadorotor2; u<26; u++)//recorrer rotor2
                    {   
                        if(posr5==posr4) //pos 5 es la cuenta de estadorotor2 y posr4 es la salida de rotor3
                        {  
                            //System.out.println("\nu"+u); /7variable de for (u)
                            texttwobackx =rotor2[u][0]; // valor de izquierda , saber posicion de entrada
                            //int posr4x=-1; //Encontrar posicion que encajara en 
                            System.out.println("\ntexttwobackx "+texttwobackx+" posicion:"+posr5);
                            
                            for(int uu=estadorotor2; uu<26; uu++)//recorrer rotor1
                            {   
                                if(texttwobackx==rotor2[uu][1]) //encontrar en recorrido la letra
                                { 
                                    texttwoback =rotor2[uu][0]; // valor de izquierda
                                    texttwo2back=rotor2[uu][1]; // valor de derecha 
                                    break; // ubicacion encontrada: fin de 
                                }   
                                if(uu == 25){ uu=-1; }
                                posr5x++;
                            }
                            break;
                        }
                        if(u == 25){ u=-1; }
                        posr5++;
                    }
                    System.out.println("texttwoback "+texttwoback+" , texttwo2back "+texttwo2back+"  posicion entrada: "+posr5x); 
                    
                    int posr6=0; //Encontrar posicion que encajara en 
                    int posr6x=0; //Encontrar posicion que encajara en 
                    for(int u=estadorotor1; u<26; u++)//recorrer rotor2
                    {   
                        if(posr6==posr5x) //pos 5 es la cuenta de estadorotor2 y posr4 es la salida de rotor3
                        {  
                            //System.out.println("\nu"+u); /7variable de for (u)
                            textonebackx =rotor1[u][0]; // valor de izquierda , saber posicion de entrada
                            //int posr4x=-1; //Encontrar posicion que encajara en 
                            System.out.println("textonebackx "+textonebackx+" posicion:"+posr6);
                            
                            for(int uu=estadorotor1; uu<26; uu++)//recorrer rotor1
                            {   
                                if(textonebackx==rotor1[uu][1]) //encontrar en recorrido la letra
                                { 
                                    textoneback =rotor1[uu][0]; // valor de izquierda
                                    textone2back=rotor1[uu][1]; // valor de derecha 
                                    break; // ubicacion encontrada: fin de 
                                }   
                                if(uu == 25){ uu=-1; }
                                posr6x++;
                            }
                            break;
                        }
                        if(u == 25){ u=-1; }
                        posr6++;
                    }
                    System.out.println("textoneback "+textoneback+" , textone2back "+textone2back+"  posicion entrada: "+posr6x); 
                    
                    /*
                    for(int uu=estadorotor1; uu<26; uu++)//recorrer rotor1, en busca de posicion de salida
                    { 
                        posr1x++;
                        if(textone2==rotor1[uu][0]) //encontrar en recorrido la letra
                        { 
                             break; // ubicacion encontrada: fin de 
                        }                                 
                        if(uu == 25){ uu=-1; }
                    }*/
                    if((posr6x+estadorotor1)>=26)
                    {
                        textfin=rotor1[posr6x][0];
                    }
                    else
                    {
                        textfin=rotor1[posr6x][0];
                    }
                    System.out.println("textfin "+textfin);
                    textfinal=textfinal+textfin;
                    
                    System.out.println("\nEstadorotor1 "+estadorotor1);
                    System.out.println("Estadorotor2 "+estadorotor2);
                    System.out.println("Estadorotor3 "+estadorotor3);
                    System.out.println(" ------------------ ");
                    //Ya esta bien---------------------------------------------v
                    estadorotor1=estadorotor1+1; //Suma una ubicacion debido a palabra!
                    if(estadorotor1==26) //rotor 1 alcanza maximo valor (26)
                    { 
                        estadorotor1=0; 
                        estadorotor2=estadorotor2+1;
                    }
                    if(estadorotor2==26) //rotor 2 alcanza maximo valor (26)
                    {
                        estadorotor2=0;
                        estadorotor3=estadorotor3+1;
                    }
                    if(estadorotor3==26) //rotor 3 alcanza maximo valor (26) 
                    {
                        vueltas=vueltas+1;
                        estadorotor1=0; 
                        estadorotor2=0; 
                        estadorotor3=0;
                    }
                    //Ya esta bien---------------------------------------------^
                    break; //corte cuando termine de procesar la letra
                }
            }
        }
        
        //Ya esta bien----------------------------------------------------------
        System.out.println ("Texto a codificar:  \t " + cadena);
        System.out.println ("Texto codificado: \t "+textfinal+"\n "
        + "Estado rotor 1: "+(estadorotor1-1)+" Estado rotor 2: "+estadorotor2+" Estado rotor 3: "+estadorotor3+" Vueltas: "+vueltas); 
        //rotor1-1 debido a que hace una suma pero termina  
        //-------------------------------------------------fin,regreso de letras
        //Escribir en archivo
        Writer escribe = null;
                try {
                    escribe = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream("SimEnigmaAlan.txt"), "UTF8"));
                    escribe.write(textfinal);
                System.out.println("\nTexto guardado en txt!");       
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    escribe.close();
                }
        //-------------------------------------------------fin,regreso de letras
        //Ya esta bien----------------------------------------------------------
    }
}
