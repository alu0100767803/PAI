/**
 * 
 */
package es.etsii.ull.PAI.HTML;

import java.io.IOException;

import javax.swing.JFrame;



/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 08/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Programa principal para la clase HTML
 */
public class MainHTML {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		final int ANCHO = 300;
		final int ALTO = 300;
		
		HTML frame = new HTML(args[0], args[1]);
		
		frame.setTitle("Transferir a HTML");
		frame.setSize(ANCHO,ALTO);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
