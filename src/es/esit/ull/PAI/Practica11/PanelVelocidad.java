/**
 * 
 */
package es.esit.ull.PAI.Practica11;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea un panel que permite cambiar el angulo del tiro parabolico
 */
public class PanelVelocidad extends JPanel {
	
	private final String TEXTO_VELOCIDAD = "La velocidad inicial es 60 m/s ";
	private final String TEXTO_NUEVA_VELOCIDAD = "Nueva velocidad";
	private final String TEXTO_SESENTA = "60";
	
	private JLabel velocidad;
	private JLabel nuevaVelocidad;
	private JTextField cuadroVelocidad;
	
	public PanelVelocidad(){
		setLayout(new GridLayout(3, 1));
		
		velocidad = new JLabel(getTEXTO_VELOCIDAD());
		nuevaVelocidad = new JLabel(getTEXTO_NUEVA_VELOCIDAD());
		cuadroVelocidad = new JTextField(getTEXTO_SESENTA());
		
		cuadroVelocidad.setColumns(4);
		
		JPanel arriba = new JPanel();
		JPanel centro = new JPanel();
		JPanel abajo = new JPanel();
		
		arriba.add(velocidad);
		centro.add(nuevaVelocidad);
		abajo.add(cuadroVelocidad);
		
		add(arriba);
		add(centro);
		add(abajo);
	}
	
	/*
	 * -------------------------------------- Getters y Setters ----------------------------------------------------------
	 */

	public JLabel getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(JLabel velocidad) {
		this.velocidad = velocidad;
	}

	public JLabel getNuevaVelocidad() {
		return nuevaVelocidad;
	}

	public void setNuevaVelocidad(JLabel nuevaVelocidad) {
		this.nuevaVelocidad = nuevaVelocidad;
	}

	public JTextField getCuadroVelocidad() {
		return cuadroVelocidad;
	}

	public void setCuadroVelocidad(JTextField cuadroVelocidad) {
		this.cuadroVelocidad = cuadroVelocidad;
	}

	public String getTEXTO_VELOCIDAD() {
		return TEXTO_VELOCIDAD;
	}

	public String getTEXTO_NUEVA_VELOCIDAD() {
		return TEXTO_NUEVA_VELOCIDAD;
	}

	public String getTEXTO_SESENTA() {
		return TEXTO_SESENTA;
	}

}
