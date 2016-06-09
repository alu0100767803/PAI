/**
 * 
 */
package es.esit.ull.PAI.Practica13;

import javax.swing.JApplet;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 12/05/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea el applet del juego de la vida
 */

public class VentanaApplet extends JApplet {
	
	public VentanaApplet(){
		Controlador controlador = new Controlador();
		add(controlador);
	}

}
