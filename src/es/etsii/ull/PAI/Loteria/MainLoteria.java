package es.etsii.ull.PAI.Loteria;

import javax.swing.JFrame;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 08/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Programa principal para utilizar la clase Loteria
 */
public class MainLoteria {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			final int ANCHO = 300; // Valor del ancho de la ventana
			final int ALTO = 300;	// Valor del alto de la ventana
			
			try{
				int n1 = Integer.parseInt(args[0]);
				int n2 = Integer.parseInt(args[1]);
				int n3 = Integer.parseInt(args[2]);
			
				Loteria frame = new Loteria(n1, n2, n3);	//Creamos la ventana
				frame.setTitle("Loteria");	// Nombre de la ventana
				frame.setSize(ANCHO,ALTO);	// Tamaño de la ventana
				frame.setLocationRelativeTo(null);	// Posicion de la ventana, al ser null se colocara en el centro
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Hace que se cierre la ventana al pulsar la x
				frame.setVisible(true);	//Hace visible la ventana
			}

			catch(ArrayIndexOutOfBoundsException e1) {
				System.out.println("Hacen falta 3 parametros");
				System.out.println("La forma correcta de usarse es: ");
				System.out.println("Ej: java MainSuma.java 2 4 8");
			}
			
			catch(NumberFormatException e2){
				System.out.println("Los 3 parametros han de ser numericos");
			}
	}

}
