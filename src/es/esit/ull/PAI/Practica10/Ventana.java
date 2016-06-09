/**
 * 
 */
package es.esit.ull.PAI.Practica10;

import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 23/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea la ventana
 */
public class Ventana extends JFrame {
	
	private Controlador controlador;
	private Dimension dimension;
	final String TITULO_VENTANA = "Quickhall";

	public Ventana(){
		
		dimension = super.getToolkit().getScreenSize();
		
		super.setSize(dimension);
		super.setUndecorated(true);
		
		setTitle(getTITULO_VENTANA());
		//setLocationRelativeTo(null);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controlador = new Controlador(this.getWidth(), this.getHeight());
		add(controlador);
	}

	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public String getTITULO_VENTANA() {
		return TITULO_VENTANA;
	}

	

}
