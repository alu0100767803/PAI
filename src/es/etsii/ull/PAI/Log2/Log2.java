/**
 * 
 */
package es.etsii.ull.PAI.Log2;

/**
 * @author Jorge
 *
 */
public class Log2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws WrongParameterException {
		try{
			if (Double.parseDouble(args[0]) <= 0)
				throw new WrongParameterException("Parámetro menor o igual a 0");		
			double aDouble = Double.parseDouble(args[0]);
			System.out.println(Math.log(aDouble));
		}
		catch (WrongParameterException e1) {
      System.out.println(e1);
    }
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("El programa necesita recibir un parametro");
		}
	}

}

