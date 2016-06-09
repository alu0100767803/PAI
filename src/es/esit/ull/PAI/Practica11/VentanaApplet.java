
package es.esit.ull.PAI.Practica11;

import javax.swing.JApplet;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 23/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que creara el applet para la aplicacion
 */
public class VentanaApplet extends JApplet {
	
	public VentanaApplet(){
		Interfaz interfaz = new Interfaz();
		add(interfaz);
		
	}

}
