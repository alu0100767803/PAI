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
public class PanelAngulo extends JPanel {
	
	private final String TEXTO_ANGULO = "El angulo inicial es 45º";
	private JLabel angulo;
	private JLabel nuevoAngulo;
	private JTextField cuadroAngulo;
	
	public PanelAngulo(){
		setLayout(new GridLayout(3, 1));
		
		angulo = new JLabel(getTEXTO_ANGULO());
		
		nuevoAngulo = new JLabel("Nuevo angulo(0º - 90º): ");
		cuadroAngulo = new JTextField("45");
		
		cuadroAngulo.setColumns(4);
		
		JPanel arriba = new JPanel();
		JPanel centro = new JPanel();
		JPanel abajo = new JPanel();
		
		arriba.add(angulo);
		centro.add(nuevoAngulo);
		abajo.add(cuadroAngulo);
		
		add(arriba);
		add(centro);
		add(abajo);
	}

	/*
	 * -------------------------------------- Getters y Setters ----------------------------------------------------------
	 */
	
	public JLabel getAngulo() {
		return angulo;
	}

	public void setAngulo(JLabel angulo) {
		this.angulo = angulo;
	}

	public JLabel getNuevoAngulo() {
		return nuevoAngulo;
	}

	public void setNuevoAngulo(JLabel nuevoAngulo) {
		this.nuevoAngulo = nuevoAngulo;
	}

	public JTextField getCuadroAngulo() {
		return cuadroAngulo;
	}

	public void setCuadroAngulo(JTextField cuadroAngulo) {
		this.cuadroAngulo = cuadroAngulo;
	}

	public String getTEXTO_ANGULO() {
		return TEXTO_ANGULO;
	}
	
}
