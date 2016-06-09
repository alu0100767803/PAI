
package es.esit.ull.PAI.Practica12;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 23/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea la ventana que sera visible para el usuario
 */
public class Ventana extends JFrame {
	
	private final int ALTO_VENTANA = 600;
  private final int ANCHO_VENTANA = 900;
	private final String TITULO_VENTANA = "Disparos";
	private Controlador controlador;
	
	public Ventana(){
		controlador = new Controlador();
		setSize(getANCHO_VENTANA(), getALTO_VENTANA());
		setTitle(getTITULO_VENTANA());
		setLocationRelativeTo(null);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(controlador);
	}
	
	/*
	 * -------------------------------------- Getters y Setters ----------------------------------------------------------
	 */

	public int getALTO_VENTANA() {
		return ALTO_VENTANA;
	}

	public int getANCHO_VENTANA() {
		return ANCHO_VENTANA;
	}

	public String getTITULO_VENTANA() {
		return TITULO_VENTANA;
	}

}
