/**
 * 
 */
package es.esit.ull.PAI.Practica10;

import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 23/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea el panel grafico
 */
public class Vista extends JPanel {
	
	private Quickhull quickhull = null;
	private boolean pintarPuntos = false;
	private boolean pintarLineas = false;
	
	public Vista(Quickhull quickhull){
		
		this.quickhull = quickhull;
		
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);	
		getQuickhull().setLimiteX(getWidth());
		getQuickhull().setLimiteY(getHeight());
		getQuickhull().rellenarVectorPuntos();
		
		if(isPintarPuntos() == true){
			dibujarPuntos(g);
		}
		
		if(isPintarLineas() == true){
			getQuickhull().borrarSolucion();
			getQuickhull().calcular();
			for(int i = 0; i < getQuickhull().getPuntosSolucion().size() - 1; i++)
				g.drawLine(getQuickhull().getPuntosSolucion().get(i).getCoordX(), getQuickhull().getPuntosSolucion().get(i).getCoordY(), getQuickhull().getPuntosSolucion().get(i + 1).getCoordX(), getQuickhull().getPuntosSolucion().get(i + 1).getCoordX());
		}
		
	}
	
	private void dibujarPuntos(Graphics g){
		for(int i = 0; i < getQuickhull().getnPuntos(); i++){

			g.fillOval(getQuickhull().getCoordX(i), getQuickhull().getCoordY(i), 4, 4);	
		}
	}

	public Quickhull getQuickhull() {
		return quickhull;
	}

	public void setQuickhull(Quickhull quickhull) {
		this.quickhull = quickhull;
	}

	public boolean isPintarPuntos() {
		return pintarPuntos;
	}

	public void setPintarPuntos(boolean pintarPuntos) {
		this.pintarPuntos = pintarPuntos;
	}

	public boolean isPintarLineas() {
		return pintarLineas;
	}

	public void setPintarLineas(boolean pintarLineas) {
		this.pintarLineas = pintarLineas;
	}

	
	
}
