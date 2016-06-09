/**
 * 
 */
package es.etsii.ull.PAI.Contador;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Jorge
 *
 */
public class MainContador {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Contador contador = new Contador(args[0]);
		contador.mostrar();

	}

}
