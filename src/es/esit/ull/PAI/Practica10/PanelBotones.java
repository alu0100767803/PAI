/**
 * 
 */
package es.esit.ull.PAI.Practica10;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 23/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Panel con los botones del programa
 */
public class PanelBotones extends JPanel{
	
	private final String PUNTOS = "Puntos";
	private final String INICIAR = "Iniciar";
	private final String LIMPIAR = "Limpiar";
	private final String ETIQUETA = "Numero de puntos: ";
	private final int NUMERO_COLUMNAS = 5;
	
	private JButton botonPuntos;
	private JButton botonIniciar;
	private JButton botonLimpiar;
	private JTextField numeroPuntos;
	private JLabel etiqueta;
	
	public PanelBotones(){
		botonPuntos = new JButton(getPUNTOS());
		botonIniciar = new JButton(getINICIAR());
		botonLimpiar = new JButton(getLIMPIAR());
		etiqueta = new JLabel(getETIQUETA());
		numeroPuntos = new JTextField();
		numeroPuntos.setColumns(getNUMERO_COLUMNAS());
		
		new JPanel();
		add(botonPuntos);
		add(botonIniciar);
		add(botonLimpiar);
		add(etiqueta);
		add(numeroPuntos);
	}

	public JButton getBotonPuntos() {
		return botonPuntos;
	}

	public void setBotonPuntos(JButton botonPuntos) {
		this.botonPuntos = botonPuntos;
	}

	public JButton getBotonIniciar() {
		return botonIniciar;
	}

	public void setBotonPausar(JButton botonPausar) {
		this.botonIniciar = botonPausar;
	}

	public JButton getBotonLimpiar() {
		return botonLimpiar;
	}

	public void setBotonLimpiar(JButton botonLimpiar) {
		this.botonLimpiar = botonLimpiar;
	}

	public String getPUNTOS() {
		return PUNTOS;
	}

	public String getINICIAR() {
		return INICIAR;
	}

	public String getLIMPIAR() {
		return LIMPIAR;
	}

	public JTextField getNumeroPuntos() {
		return numeroPuntos;
	}

	public void setNumeroPuntos(JTextField numeroPuntos) {
		this.numeroPuntos = numeroPuntos;
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
	
}
