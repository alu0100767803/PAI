
package es.etsii.ull.PAI.Suma;

import javax.swing.JFrame;



/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 08/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Programa principal para utilizar la clase Suma
 */
public class MainSuma {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int ANCHO = 300;
		final int ALTO = 300;
		
		try{
		int sum1 = Integer.parseInt(args[0]);
		int sum2 = Integer.parseInt(args[1]);
		
		Suma frame = new Suma(sum1, sum2);
		frame.setTitle("Suma");
		frame.setSize(ANCHO, ALTO);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
		
		catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println("Hacen falta 2 parametros");
			System.out.println("La forma correcta de usarse es: ");
			System.out.println("Ej: java MainSuma.java 2 4");
		}
		catch(NumberFormatException e2){
			System.out.println("Los parametros han de ser numericos");
		}
		
	}

}
