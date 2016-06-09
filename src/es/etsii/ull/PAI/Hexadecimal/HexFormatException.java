/**
 * 
 */
package es.etsii.ull.PAI.Hexadecimal;

/**
 * @author Jorge
 *
 */
public class HexFormatException extends Exception{
	
	/**
	 * Imprime por pantalla un mensaje de error si el formato no es el adecuado
	 * @param mensaje
	 */
	public HexFormatException(String mensaje) {
		System.out.println(mensaje);
	}

}
