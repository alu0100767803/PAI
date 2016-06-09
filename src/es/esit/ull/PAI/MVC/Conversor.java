/**
 * 
 */
package es.esit.ull.PAI.MVC;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 13/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que contiene la ventana que se va a mostrar
 */
public class Conversor extends JFrame{
	
	final private int ANCHO = 300;	// Ancho de la venana
	final private int ALTO = 600;	// Alto de la casilla
	final private String TITULO = "Currency Changer";	//Titulo de la ventana
	private Casilla casilla;	// Casilla a introducir en la ventana
	
	public Conversor(){
		
		setLayout (new GridLayout(6 , 1 , 2 , 2)); 
		setTitle(TITULO);
		setSize(ANCHO, ALTO);	// setSize(getANCHO(), getALTO());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		/*casilla = new Casilla("DM", euros);	
		add(casilla);
		
		casilla = new Casilla("Belg. Franc.", euros);
		add(casilla);
		
		casilla = new Casilla("Franz. Franc.", euros);
		add(casilla);
		
		casilla = new Casilla("Ir. Pfound", euros);
		add(casilla);
		
		casilla = new Casilla("Ital. Lira", euros);
		add(casilla);
		
		casilla = new Casilla("US$", euros);
		add(casilla);*/
		
	}
	
	public void addCasilla(Moneda moneda) {
		casilla = new Casilla(moneda);
		add(casilla);
	}
	

	public Casilla getCasilla() {
		return casilla;
	}


	public void setCasilla(Casilla casilla) {
		this.casilla = casilla;
	}


	public String getTITULO() {
		return TITULO;
	}


	public int getANCHO() {
		return ANCHO;
	}

	public int getALTO() {
		return ALTO;
	}
}
