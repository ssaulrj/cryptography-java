/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;
import java.io.IOException;
import java.math.BigInteger;

/**
 *
 * @author
 */
public class RSA {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        char [] caracteres = { 'a', 'b', 'c', 'd', 'e', 'f','g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'á', 'é', 'í', 'ó', 'ú', ' ', '.', ',', '¿', '?', '¡', '!', '"', '"', ';', '-', 'ü' };
       
        String [] valores = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54" };
        String [] numbers;
        String ruta = "C:\\Users\\Luu Luu\\Desktop\\mensajeRSA.txt";
        
        BigInteger [] ces;
        BigInteger [] dec;
        BigInteger e, d, q, p, phiN, n, m;
        
        int pp, qq, mm, dd;
        int z = 10;
        
        long ee;
        long [] numeros;
        
        Archivo archivo = new Archivo(ruta);
        
        StringBuilder builder = new StringBuilder("");
         
        //String mensaje = "a 7 hola, soy lulú 7 aa menor que 3";
        String mensaje = archivo.leer();
        int longitud = mensaje.length();
        
        //System.out.println(longitud);
        
        //Para codificar el mensaje
        for (int i = 0; i < longitud; i++){
            for (int j = 0; j<=53; j++){
                if (mensaje.charAt(i) == caracteres[j]){
                    builder.append(valores[j]);
                    break;
                }
            }       
        }
        
        System.out.println("Mensaje original: " + mensaje); //Mensaje obtenido del txt
        System.out.println("Mensaje codificado: " + builder); //Mensaje convertido a números
        
   
        ee = 77527;
        pp = 101207;
        qq = 101117;
        //n 10233748219
        
        p = BigInteger.valueOf(pp);
        q = BigInteger.valueOf(qq);
        e = BigInteger.valueOf(ee);
       
        n = p.multiply(q);
        
        System.out.println("n: " + n + "\n\n");
        phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
       
        d = e.modInverse(phiN);
        System.out.println("Llave pública: " + e);
        System.out.println("Llave privada: " + d + "\n\n");
        
        int totalNumbers = builder.length()/10;
        int sobrante = builder.length()%10;
        
        //System.out.println(totalNumbers);
        numbers = new String [totalNumbers];
        numeros = new long [totalNumbers];
        ces = new BigInteger[totalNumbers];
        dec = new BigInteger[totalNumbers];
        
        
        for ( int i = 0; i < totalNumbers; i++ ){
            numbers[i] = builder.substring( z*(i), z*(i) + z)  ;
            
            if (numbers[i].charAt(0)=='0')
                numeros[i] = Integer.parseInt(numbers[i].substring(1,10));
                else 
                    numeros[i] = Long.parseLong(numbers[i]);
        
            ces[i] = BigInteger.valueOf(numeros[i]).modPow(e, n);
            dec[i] = ces[i].modPow(d, n);
        
       
            //System.out.println("M " + (i+1) + ": " + numbers[i] );
            //System.out.println("N " + (i+1) + ": " + numeros[i] );
            //System.out.println("C " + (i+1) + ": " + ces[i] ); //Cifrado
            System.out.println( ces[i] );
            //System.out.println("D " + (i+1) + ": " + dec[i] + "\n" );
        }
        
    }
    
}
