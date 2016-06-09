/**
 * 
 */
package es.esit.ull.PAI.Practica12;

import java.awt.Color;
import java.awt.Point;

/**
 * @author Jorge
 *
 */
public class Bola {

	private Point puntoBola;
	private Point centroBola;
	private final int tamanyoBola;
	private int radio;
	private Color colorBola;
	private double pendienteBola;
	
	public Bola(Point punto, int tamanyo){
		puntoBola = punto;
		tamanyoBola = tamanyo;
		radio = tamanyo / 2;
		int x = (int) (punto.getX() + radio);
		int y = (int) (punto.getY() + radio);
		centroBola = new Point(x, y);
		colorAleatorio();
	}
	
	public void colorAleatorio(){
		int colorAleatorio = (int) Math.round(Math.random() * 8 + 1);
		if(colorAleatorio == 1){
			setColorBola(Color.BLUE);
		}
		else if(colorAleatorio == 2){
			setColorBola(Color.CYAN);
		}
		else if(colorAleatorio == 3){
			setColorBola(Color.GREEN);
		}
		else if(colorAleatorio == 4){
			setColorBola(Color.MAGENTA);
		}
		else if(colorAleatorio == 5){
			setColorBola(Color.ORANGE);
		}
		else if(colorAleatorio == 6){
			setColorBola(Color.PINK);
		}
		else if(colorAleatorio == 7){
			setColorBola(Color.RED);
		}
		else if(colorAleatorio == 8){
			setColorBola(Color.YELLOW);
		}
	}
	
	private void calcularCentro(){
		int x = (int) (getPuntoBola().getX() + getRadio());
		int y = (int) (getPuntoBola().getY() + getRadio());
		Point punto = new Point(x, y);
		setCentroBola(punto);
	}
	
	public void calcular(){
		int y = (int) getCentroBola().getY() - 20;
		int x = (int) ((y - getCentroBola().getY() + getPendienteBola() * getCentroBola().getX()) / getPendienteBola());
		Point punto = new Point(x, y);
		setCentroBola(punto);
		x -= getRadio();
		y -= getRadio();
		
		punto = new Point(x, y);
		setPuntoBola(punto);

	}
	
	public void calcularIzquierda(){
		int y = (int) getCentroBola().getY() - 20;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public Color getColorBola() {
		return colorBola;
	}

	public void setColorBola(Color colorBola) {
		this.colorBola = colorBola;
	}

	public Point getPuntoBola() {
		return puntoBola;
	}

	public void setPuntoBola(Point puntoBola) {
		this.puntoBola = puntoBola;
	}

	public int getTamanyoBola() {
		return tamanyoBola;
	}

	public Point getCentroBola() {
		return centroBola;
	}

	public void setCentroBola(Point centroBola) {
		this.centroBola = centroBola;
	}

	public double getPendienteBola() {
		return pendienteBola;
	}

	public void setPendienteBola(double pendienteBola) {
		this.pendienteBola = pendienteBola;
	}
	
	
	
}
