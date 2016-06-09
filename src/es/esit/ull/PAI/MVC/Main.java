/**
 * 
 */
package es.esit.ull.PAI.MVC;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 13/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*final int ANCHO = 300;
		final int ALTO = 600;
		
		conversor.setLayout (new GridLayout(6 , 1 , 2 , 2)); 
		conversor.setTitle("Currency Changer");
		conversor.setSize(ANCHO, ALTO);
		conversor.setLocationRelativeTo(null);
		conversor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		conversor.setVisible(true);*/
		
		//Operaciones con los datos
		float euros = Float.parseFloat(args[0]);
		Controlador controlador = new Controlador(euros);
		//System.out.println(euro);
		

		
		
		
	
		

	}

}
