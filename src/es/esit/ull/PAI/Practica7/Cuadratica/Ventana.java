/**
 * 
 */
package es.esit.ull.PAI.Practica7.Cuadratica;

import javax.swing.JFrame;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 03/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Ventana para mostrar la clase Cuadratica
 */
public class Ventana extends JFrame{

	private Cuadratica cuadratica;															// Objeto con la grafica de una funcion cuadratica
	private final int ANCHO = 400;															// Ancho de la ventana
	private final int ALTO = 300;																// Alto de la ventana
	private final String TITULO = "Funcion Cuadratica";					// String con el nombre de la ventana
	
	public Ventana(){
		cuadratica = new Cuadratica();
		
		setTitle(TITULO);
  	setSize(ANCHO, ALTO);
  	setLocationRelativeTo(null);  
  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	add(cuadratica);

  	setVisible(true);
  	
	}
}
