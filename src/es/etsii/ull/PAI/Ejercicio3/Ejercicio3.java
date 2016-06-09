/**
 * 
 */
package es.etsii.ull.PAI.Ejercicio3;

import java.io.IOException;

/**
 * @author Jorge
 *
 */
public class Ejercicio3 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
      Vector numeros = new Vector(args[0]);
      System.out.println(" El rango entre el maximo y el minimo: " + numeros.rango());

	}

}
