/**
 * 
 */
package es.esit.ull.PAI.Practica7.Cuadratica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JPanel;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 03/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que obtiene la grafica de una funcion cuadratica
 */
public class Cuadratica extends JPanel{
	private final int IZQUIERDA = -20;						// Primer elemento por el que se sustituira la funcion
	private final int DERECHA = 20;								// Ultimo elemento por el que se sustituira la funcion
																								// la funcion cuadratica abarcara todos los valores entre IZQUIERDA y DERECHA
	public Cuadratica(){}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		dibujarEjeCoord(g);
		dibujarCuadratica(g, getIZQUIERDA() , getDERECHA());
	}
	
	/**
	 * Metodo que dibuja un eje de coordenadas 
	 * @param g
	 */
	public void dibujarEjeCoord(Graphics g){
		final int LONGITUD_FLECHA = 30;						// Tamaño de las lineas de la flecha
		final int ALTURA_FLECHA = 5;							// distancia de las lineas de la flecha con respecto al eje
		final int SEPARACION_CADENA = 20;					// Separacion de las cadenas de caracteres con respecto del eje
		final String X = "x"; 										// Nombre del eje de coordenadas x
		final String Y = "y";											// Nombre del eje de coordenads y
		
		
				// dibuja el eje de coordeadas
		g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);	// eje x
		g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());	// eje y
			
				//dibuja la flecha del eje de coordenadas  x
		g.drawLine(getWidth(), getHeight() / 2, getWidth() - LONGITUD_FLECHA, getHeight() / 2 - ALTURA_FLECHA);
		g.drawLine(getWidth(), getHeight() / 2, getWidth() - LONGITUD_FLECHA, getHeight() / 2 + ALTURA_FLECHA);
			
				//dibuja la flecha del eje de coordenadas y
		g.drawLine(getWidth() / 2, 0, getWidth() / 2 - ALTURA_FLECHA, LONGITUD_FLECHA);
		g.drawLine(getWidth() / 2, 0, getWidth() / 2 + ALTURA_FLECHA, LONGITUD_FLECHA);
			
				//dibuja las letras del eje de coordenadas x e y
		g.drawString("y", getWidth() / 2 + SEPARACION_CADENA, SEPARACION_CADENA);
		g.drawString("x", getWidth() - SEPARACION_CADENA, getHeight() / 2 - SEPARACION_CADENA);
	}
	
	/**
	 * Metodo que dibuja la funcion cuadratica
	 * @param g
	 * @param izquierda
	 * @param derecha
	 */
	public void dibujarCuadratica(Graphics g, int izquierda, int derecha){
		double x, y, xDestino, yDestino;
		
		for (double i = izquierda; i < derecha; i++){
			x = i;
			y = (Math.pow(i,2));
			xDestino = i + 1;
			yDestino = (Math.pow(xDestino, 2));
			
			g.drawLine(coordenadaX(x), coordenadaY(y), coordenadaX(xDestino), coordenadaY(yDestino));
		}
	}
	
	/**
	 * Devuelve la coordenada del elemento x
	 * @param x
	 * @return
	 */
	private int coordenadaX(double x){
		return (int) x + getWidth() / 2;
	}
	
	/**
	 * Devuelve la coordenada del elemento y
	 * @param y
	 * @return
	 */
	private int coordenadaY(double y){
		return (int) - y + getHeight() / 2;
	}
	
	private int getIZQUIERDA() {
		return IZQUIERDA;
	}

	private int getDERECHA() {
		return DERECHA;
	}
	

}
