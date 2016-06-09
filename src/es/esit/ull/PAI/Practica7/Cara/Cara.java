/**
 * 
 */
package es.esit.ull.PAI.Practica7.Cara;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 03/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que dibuja un grafico con forma de cara
 */
public class Cara extends JPanel {
	
	private final int TAMANYO_OJOS = 30;										// Diametro de los ojos
	private final int TAMANYO_CARA = 150;										// Diametro de la cara
	private final int DISTANCIA_XY = 75;										// Distancia a la que se encuentra el punto (x, y) de la cara 
																													// del punto central
	private final int DISTANCIA_OJO_DER = 15;								// Distancia a la que se encuentra el punto (x, y) del ojo derecho
																													// del punto central
	private final int DISTANCIA_OJO_IZQ = 45;								// Distancia a la que se encuentra el punto (x, y) del ojo izquierdo
																													// del punto central
	
	public Cara(){}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Circulo que da forma a la cara
		g.setColor(Color.BLACK);
		g.drawOval(getWidth() / 2 - getDISTANCIA_XY(), getHeight() / 2 - getDISTANCIA_XY(), getTAMANYO_CARA(), getTAMANYO_CARA());
		
		// Ciurculos que representan los ojos
		pintarOjo(g, getWidth() / 2 - getDISTANCIA_OJO_IZQ(), getHeight() / 2 - getTAMANYO_OJOS());
		pintarOjo(g, getWidth() / 2 + getDISTANCIA_OJO_DER(), getHeight() / 2 - getTAMANYO_OJOS());
		
		
		// Linea que representa la boca
		g.setColor(Color.RED);
		g.drawLine(getWidth() / 2 - 30, getHeight() / 2 + 30 , getWidth() / 2 + 30, getHeight() / 2 + 30);
	}
	
	/**
	 * Funcion que dibuja un ojo en las coordenadas especificdas
	 * @param g
	 * @param x
	 * @param y
	 */
	private void pintarOjo(Graphics g, int x, int y){
		g.setColor(Color.BLUE);
		g.fillOval(x, y, getTAMANYO_OJOS(), getTAMANYO_OJOS());
	}
	
	private int getDISTANCIA_XY() {
		return DISTANCIA_XY;
	}
	
	private int getTAMANYO_OJOS() {
		return TAMANYO_OJOS;
	}
	
	private int getTAMANYO_CARA() {
		return TAMANYO_CARA;
	}
	
	private int getDISTANCIA_OJO_DER() {
		return DISTANCIA_OJO_DER;
	}

	private int getDISTANCIA_OJO_IZQ() {
		return DISTANCIA_OJO_IZQ;
	}



}
