
package es.esit.ull.PAI.Practica11;

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
  private final int ANCHO_VENTANA = 1100;
	private final String TITULO_VENTANA = "Tiro parabolico";
	
	private Interfaz interfaz;
	
	public Ventana(){
		
		interfaz = new Interfaz();
		setSize(getANCHO_VENTANA(), getALTO_VENTANA());
		setTitle(getTITULO_VENTANA());
		setLocationRelativeTo(null);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(interfaz);
		
	}
	
	/*
	 * -------------------------------------- Getters y Setters ----------------------------------------------------------
	 */

	public Interfaz getInterfaz() {
		return interfaz;
	}

	public void setInterfaz(Interfaz interfaz) {
		this.interfaz = interfaz;
	}

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
