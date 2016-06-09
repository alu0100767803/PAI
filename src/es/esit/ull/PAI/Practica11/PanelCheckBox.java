/**
 * 
 */
package es.esit.ull.PAI.Practica11;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea un panel con los checkbox de la aplicacion
 */
public class PanelCheckBox extends JPanel {
	
	private final String TEXTO_DATOS = "mostrar datos";
	private final String TEXTO_RASTRO = "mostrar rastro";
	//private final String TEXTO_POSICIONES = "mostrar vector de posiciones";
	
	private JCheckBox datos;
	private JCheckBox rastro;
	//private JCheckBox posiciones;
	
	public PanelCheckBox(){
		
		datos = new JCheckBox(getTEXTO_DATOS());
		rastro = new JCheckBox(getTEXTO_RASTRO());
		//posiciones = new JCheckBox(getTEXTO_POSICIONES());
		
		JPanel arriba = new JPanel();
		JPanel centro = new JPanel();
		//JPanel abajo = new JPanel();
		
		setLayout(new GridLayout(3, 1));
		
		arriba.add(datos);
		centro.add(rastro);
		//abajo.add();
		
		add(arriba);
		add(centro);
		//add(abajo);
		
	}
	
	/*
	 * -------------------------------------- Getters y Setters ----------------------------------------------------------
	 */

	public JCheckBox getDatos() {
		return datos;
	}

	public void setDatos(JCheckBox datos) {
		this.datos = datos;
	}

	public JCheckBox getRastro() {
		return rastro;
	}

	public void setRastro(JCheckBox rastro) {
		this.rastro = rastro;
	}

	/*public JCheckBox getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(JCheckBox posiciones) {
		this.posiciones = posiciones;
	}*/

	public String getTEXTO_DATOS() {
		return TEXTO_DATOS;
	}

	public String getTEXTO_RASTRO() {
		return TEXTO_RASTRO;
	}

	/*public String getTEXTO_POSICIONES() {
		return TEXTO_POSICIONES;
	}*/
	
}
