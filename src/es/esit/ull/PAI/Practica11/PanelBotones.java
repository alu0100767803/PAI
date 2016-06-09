
package es.esit.ull.PAI.Practica11;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea un panel con los botones de la aplicacion
 */
public class PanelBotones extends JPanel {
																														// Nombres de los botones
	private final String LANZAR = "Lanzar";																	
	private final String PAUSAR = "Pausar";
	private final String BORRAR = "Borrar";
	private final String REANUDAR = "Reanudar";
	
	private JButton lanzar;																				// Boton que va a lanzar un nuevo tiro parabolico								
	private JButton pausar;																				// Boton que va a pausar la ejecucion del tiro parabolico
	private JButton borrar;																				// Boton que va a limpiar la pantalla de todos los tiros parabolicos
	private JButton reanudar;																			// Boton que va a reanudar la ejecucion del tiro parabolico si fue pausada
	
	public PanelBotones(){
		
		lanzar = new JButton(getLANZAR());
		pausar = new JButton(getPAUSAR());
		borrar = new JButton(getBORRAR());
		reanudar = new JButton(getREANUDAR());
		
		JPanel arriba = new JPanel();
		JPanel centro = new JPanel();
		JPanel abajo = new JPanel();
		
		setLayout(new GridLayout(3, 1));
		
		arriba.add(lanzar);
		centro.add(pausar);
		centro.add(reanudar);
		abajo.add(borrar);
		
		add(arriba);
		add(centro);
		add(abajo);
		
	}

	
	/*
	 * -------------------------------------- Getters y Setters ----------------------------------------------------------
	 */
	
	public JButton getLanzar() {
		return lanzar;
	}

	public void setLanzar(JButton lanzar) {
		lanzar = lanzar;
	}

	public JButton getPausar() {
		return pausar;
	}

	public void setPausar(JButton pausar) {
		pausar = pausar;
	}

	public JButton getBorrar() {
		return borrar;
	}

	public void setBorrar(JButton borrar) {
		borrar = borrar;
	}

	public String getLANZAR() {
		return LANZAR;
	}

	public String getPAUSAR() {
		return PAUSAR;
	}

	public String getBORRAR() {
		return BORRAR;
	}

	public JButton getReanudar() {
		return reanudar;
	}

	public void setReanudar(JButton reanudar) {
		this.reanudar = reanudar;
	}

	public String getREANUDAR() {
		return REANUDAR;
	}

}
