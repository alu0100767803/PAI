/**
 * @author Jorge Alonso Hernández
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 17/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea un panel con los botones
 */
package es.esit.ull.PAI.Practica9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;


public class Panel extends JPanel {
	
	private final String COLOR = "Color";																				
	private final String ETIQUETA = "densidad: ";
	private final int NUMERO_COLUMNAS = 5;															// numero de comlumanas del JTextField
	
	private PanelBotones panelBotones;
	private JButton color;																							// Botón que va a cambiar el color del camino a uno aleatorio
	private JLabel etiqueta;																						// Etiqueta para saber que se va a modificar con el cuadro de texto
	private JTextField densidad;																				// Cuadro de texto que va a cambiar la densidad de la cuadrícula
	
	public Panel(){
		
		new JPanel();
		setLayout(new GridLayout(1,3));
		
		panelBotones = new PanelBotones();
		color = new JButton(getCOLOR());
		densidad = new JTextField();
		etiqueta = new JLabel(getETIQUETA());
		
		densidad.setColumns(getNUMERO_COLUMNAS());
		
		JPanel izq = new JPanel();
		JPanel centro = new JPanel();
		JPanel der = new JPanel();
		
		
		izq.add(panelBotones);
		centro.add(color);
		der.add(etiqueta);
		der.add(densidad);
		
		add(izq);
		add(BorderLayout.CENTER,centro);
		add(BorderLayout.CENTER,der);
		
	}

	public JButton getColor() {
		return color;
	}

	public void setColor(JButton color) {
		this.color = color;
	}

	public JTextField getDensidad() {
		return densidad;
	}

	public void setDensidad(JTextField densidad) {
		this.densidad = densidad;
	}

	public String getCOLOR() {
		return COLOR;
	}

	public JLabel getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(JLabel etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getETIQUETA() {
		return ETIQUETA;
	}

	public int getNUMERO_COLUMNAS() {
		return NUMERO_COLUMNAS;
	}

	public PanelBotones getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(PanelBotones panelBotones) {
		this.panelBotones = panelBotones;
	}

}
