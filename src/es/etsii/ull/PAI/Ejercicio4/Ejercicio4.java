/**
 * 
 */
package es.etsii.ull.PAI.Ejercicio4;

/**
 * @author Jorge
 *
 */
public class Ejercicio4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double num1 = new Double(args[0]);
		double num2 = new Double(args[1]);
		double eps = new Double(args[3]);
		
		Precision precision = new Precision(num1, num2);
		precision.comparar(eps);

	}

}
