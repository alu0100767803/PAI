
/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 09/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que dibuja la bola 
 */
package es.esit.ull.PAI.Practica8;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Bola extends JPanel {
	
	private final int TAMANYO_BOLA = 60;										// Diametro en pixeles de la bola 
	private int coordX = 10;																// Posicion x en la que se dibuja la bola
	private int coordY = 10;																// Posicion y en la que se dibuja la bola
	private int intervalo;																		// numero de pixeles que e desplaza la bola
	private final String mensaje = "No se puede avanzar, se ha llegao al limite ";	// mensaje a mostrar cuando se llega al limite del panel
	
	public Bola(int intervalo) {
		new JPanel();
		this.intervalo = intervalo;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.fillOval(getCoordX(), getCoordY(), getTAMANYO_BOLA(), getTAMANYO_BOLA());
	
	}
	
	public void moverIzq(){
		if(getCoordX() - getIntervalo() >= 0){
			setCoordX(getCoordX() - getIntervalo());
			repaint();
		}
		else if(getCoordX() > 0){
			setCoordX(0);
			repaint();
		}
		else
			System.out.println(getMensaje() + "izquierdo");
	}
	
	public void moverDer(){
		if((getCoordX()+ getTAMANYO_BOLA()) + getIntervalo() <= getWidth()){
			setCoordX(getCoordX() + getIntervalo());
			repaint();
		}
		else if(getWidth() - (getCoordX() + getTAMANYO_BOLA()) > 0){
			setCoordX(getCoordX() + (getWidth() - (getCoordX() + getTAMANYO_BOLA())));
			repaint();
		}
		else
			System.out.println(getMensaje() + "derecho");
	}
	
	public void moverArr(){
		if(getCoordY() - getIntervalo() >= 0){
			setCoordY(getCoordY() - getIntervalo());
			repaint();
		}
		else if(getCoordY() > 0){
			setCoordY(0);
			repaint();
		}
		else
			System.out.println(getMensaje() + "superior");
	}
	
	public void moverAba(){
		if((getCoordY() + getTAMANYO_BOLA()) + getIntervalo() <= getHeight()){
			setCoordY(getCoordY() + getIntervalo());
			repaint();
		}
		else if(getHeight() - (getCoordY() + getTAMANYO_BOLA()) > 0){
			setCoordY(getCoordY() + (getHeight() - (getCoordY() + getTAMANYO_BOLA())));
			repaint();
		}
		else
			System.out.println(getMensaje() + "inferior");
	}

	private String getMensaje() {
		return mensaje;
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
		repaint();
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
		repaint();
	}

	public int getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}

	public int getTAMANYO_BOLA() {
		return TAMANYO_BOLA;
	}

}
