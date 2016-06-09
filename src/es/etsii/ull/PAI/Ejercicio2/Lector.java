package es.etsii.ull.PAI.Ejercicio2;

/**
 * @author Jorge
 * Clase que pedir� una cadena por teclado y devolver� el n�mero de aes, tanto may�sculas o min�sculas, que posee
 */

import java.io.*;
import java.util.*;

public class Lector {
	
	String cadena; //Cadena a analizar
	
	/**
	 * Constructor de la cadena a analizar
	 */
	public Lector(){
	  System.out.println("Introduce una cadena de caracteras: ");
	  Scanner entradaEscaner = new Scanner (System.in);
	  cadena = entradaEscaner.nextLine();
	}
	
	/**
	 * M�todo que devuelve el n�mero de aes que tiene la cadena
	 * @return int, n�mero de aes de la cadena
	 */
	public int contador(){
	  int contador = 0;
      char[] cadena_v = cadena.toCharArray();
      for(int i=0; i < cadena_v.length; i++){
        if( (cadena_v[i] == 'a') || (cadena_v[i] == 'A'))
	      contador++;
      }
      return contador;
	}
	
	

}
