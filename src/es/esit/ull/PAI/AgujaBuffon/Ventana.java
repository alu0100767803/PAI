/**
 * @author Jorge Alonso Hern�ndez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 17/04/2016
 * Asignatura: Programaci�n de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea una ventana
 */
package es.esit.ull.PAI.AgujaBuffon;

import javax.swing.JFrame;

import es.esit.ull.PAI.Practica8.BolaMovil;

public class Ventana extends JFrame {
	
	private final int ALTO_VENTANA = 500;
  private final int ANCHO_VENTANA = 800;
	private final String TITULO_VENTANA = "Caminos Aleatorios";
	
	private Controlador controlador;

	public Ventana(){
		
		controlador = new Controlador();
		setSize(getANCHO_VENTANA(), getALTO_VENTANA());
		setTitle(getTITULO_VENTANA());
		setLocationRelativeTo(null);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(controlador);
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
	
