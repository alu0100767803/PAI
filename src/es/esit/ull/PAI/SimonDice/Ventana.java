/**
 * 
 */
package es.esit.ull.PAI.SimonDice;

import javax.swing.JFrame;

import es.esit.ull.PAI.Practica9.Controlador;

/**
 * @author alu4487
 *
 */
public class Ventana extends JFrame{
	
	private Interfaz interfaz = new Interfaz();

	public Ventana(){
		
		interfaz = new Interfaz();
		final int ALTO_VENTANA = 400;
	  final int ANCHO_VENTANA = 700;
		final String TITULO_VENTANA = "Caminos Aleatorios";
		
		setSize(ANCHO_VENTANA, ALTO_VENTANA);
		setTitle(TITULO_VENTANA);
		setLocationRelativeTo(null);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(interfaz);
		
		setVisible(true);
	}
	
}
