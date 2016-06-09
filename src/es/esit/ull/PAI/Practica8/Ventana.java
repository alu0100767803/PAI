/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 09/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea una ventana
 */
package es.esit.ull.PAI.Practica8;

import javax.swing.JFrame;

public class Ventana extends JFrame{

	private BolaMovil frame;

	public Ventana(int intervalo){
		final int ALTO_VENTANA = 400;
	  final int ANCHO_VENTANA = 700;
		final String TITULO_VENTANA = "Move a ball";
		
		frame = new BolaMovil(intervalo);
		
		setSize(ANCHO_VENTANA, ALTO_VENTANA);
		setTitle(TITULO_VENTANA);
		setLocationRelativeTo(null);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(frame);
		setVisible(true);
	}
	
	public BolaMovil getFrame() {
		return frame;
	}

	public void setFrame(BolaMovil frame) {
		this.frame = frame;
	}
	
}
