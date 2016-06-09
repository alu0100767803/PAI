package es.etsii.ull.PAI.Ejercicio2;

/**
 * @author Jorge
 * Clase que pedirá una cadena por teclado y devolverá el número de aes, tanto mayúsculas o minúsculas, que posee
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
	 * Método que devuelve el número de aes que tiene la cadena
	 * @return int, número de aes de la cadena
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
