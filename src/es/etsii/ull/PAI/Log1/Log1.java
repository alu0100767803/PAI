/**
 * 
 */
package es.etsii.ull.PAI.Log1;

/**
 * @author Jorge
 *
 */
public class Log1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			double aDouble = Double.parseDouble(args[0]);
			System.out.println( Math.log(aDouble));
		}
		catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println("Hace falta 1 parametro");
		}
		catch(NumberFormatException e2){
			System.out.println("El parametro ha de ser numerico");
		}
	}
}
