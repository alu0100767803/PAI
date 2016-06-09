/**
 * 
 */
package es.esit.ull.PAI.Practica10;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 23/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que guarda un punto 
 */
public class Punto {
	
	private final int coordX;
	private final int coordY;
	
	public Punto(int coordX, int coordY){
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public int getCoordX() {
		return coordX;
	}

	public int getCoordY() {
		return coordY;
	}
	
	
}
