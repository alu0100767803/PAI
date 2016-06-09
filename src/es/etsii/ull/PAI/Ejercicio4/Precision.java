package es.etsii.ull.PAI.Ejercicio4;

/**
 * @author Jorge
 *
 */
public class Precision {
	
	private double numero1;
	private double numero2;
	
	/**
	 * Constructor de la clase Precision
	 * @param num1 primer número a comparar
	 * @param num2 segundo número a comparar
	 */
	public Precision(double num1, double num2){
	  
		numero1 = num1;
		numero2 = num2;
	}
	
	/**
	 * Imprime si los dos números son iguales o no 
	 * @param eps umbral para hacer la precisión
	 */
	public void comparar(double eps){
	  double abs = Math.abs(numero1 - numero2);
	    if(abs <= Math.max(numero1, numero2) * eps)
	      System.out.println(numero1 + " y " + numero2 + " son iguales: true");
	    else
	      System.out.println(numero1 + " y " + numero2 + " son iguales: true");
	}
}
