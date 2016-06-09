/**
 * 
 */
package es.esit.ull.PAI.Practica7.Funciones;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Jorge
 *
 */
public class Funciones extends JPanel{
	
																						
	private final int elementoA;									// Elemento A de la formula Ax^2 + Bx + C
	private final int elementoB;									// Elemento B de la formula	Ax^2 + Bx + C
	private final int elementoC;									// Elemento B de la formula	Ax^2 + Bx + C
	private final int IZQUIERDA = -20;						// Primer elemento por el que se sustituira la funcion
	private final int DERECHA = 20;								// Ultimo elemento por el que se sustituira la funcion
																								// la funcion cuadratica abarcara todos los valores entre IZQUIERDA y DERECHA
	
	public Funciones(int elementoA, int elementoB, int elementoC){
		this.elementoA = elementoA;
		this.elementoB = elementoB;
		this.elementoC = elementoC;
	}
	
	public void paintComponent(Graphics g){
		dibujarEjeCoord(g);
		dibujarFuncion(g, getElementoA(), getElementoB(), getElementoC(), getIZQUIERDA(), getDERECHA() );
	}
	

	private void dibujarEjeCoord(Graphics g){
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
	
	private void dibujarFuncion(Graphics g, int elementoA, int elementoB, int elementoC, 
				int izquierda, int derecha){
		double x, y, xDestino, yDestino;
		for(double i = izquierda; i < derecha; i++){
			x = i;
			y = Math.pow(i, 2) * elementoA + i * elementoB + elementoC;
			xDestino = i + 1;
			yDestino = Math.pow(xDestino, 2) * elementoA + i * elementoB + elementoC;
			
			g.drawLine(coordenadaX(x), coordenadaY(y), coordenadaX(xDestino), coordenadaY(yDestino));
		}
	}
	
	private int coordenadaX(double x){
		return (int) x + getWidth() / 2;
	}
	
	private int coordenadaY(double y){
		return (int) - y + getHeight() / 2;
	}
	
	public int getIZQUIERDA() {
		return IZQUIERDA;
	}

	public int getDERECHA() {
		return DERECHA;
	}

	public int getElementoA() {
		return elementoA;
	}


	public int getElementoB() {
		return elementoB;
	}

	public int getElementoC() {
		return elementoC;
	}

}
