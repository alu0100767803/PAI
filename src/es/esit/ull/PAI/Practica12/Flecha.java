/**
 * 
 */
package es.esit.ull.PAI.Practica12;

import java.awt.Point;

/**
 * @author Jorge
 *
 */
public class Flecha {
	
	private Point puntoInicial;
	private Point puntoFinal;
	private Point puntoFlechaDer;
	private Point puntoFlechaIzq;
	private double pendienteFlechasLaterales;
	private int anguloFlecha;
	private double pendienteFlecha;
	
	public Flecha(){
		puntoInicial = new Point();
		puntoFinal = new Point();
		puntoFlechaDer = new Point();
		puntoFlechaIzq = new Point();
		pendienteFlechasLaterales = 0;
		anguloFlecha = 30;
		pendienteFlecha = 0;
	}
	
	public void calcularPendiente(){
		double x1 = getPuntoInicial().getX();
		double y1 = getPuntoInicial().getY();
		double x2 = getPuntoFinal().getX();
		double y2 = getPuntoFinal().getY();
		double dx = x2 - x1;
		double dy = y2 - y1;
		/*if(Math.abs(dx) > Math.abs(dy))
			setPendienteFlecha(dy / dx);
		else */
			setPendienteFlecha(dy / dx);
	}
	
	public void calcular(){
		double pendiente = Math.tan(Math.toRadians(getAnguloFlecha()));
		setPendienteFlechasLaterales(pendiente);
		int y = (int) getPuntoFinal().getY() + 30;
		int x = (int)(y - getPuntoFinal().getY() + (getPendienteFlechasLaterales() * getPuntoFinal().getX()) / getPendienteFlechasLaterales());
		Point punto = new Point(x, y); 
		setPuntoFlechaDer(punto);
	}
	
	public void calcularPuntoFinal(){
		double x;
		double y;
		double angulo = Math.atan(getPendienteFlecha());
		angulo = Math.toDegrees(angulo);
		if(angulo < 0)
			angulo = 180 + angulo;
		
		x =  80 * Math.cos(Math.toRadians(angulo));
		y = 80 * Math.sin(Math.toRadians(angulo));
		x = getPuntoInicial().getX() - x;
		y = getPuntoInicial().getY() - y;
		Point punto = new Point((int) x, (int) y);
		setPuntoFinal(punto);
		
		angulo = 30;
		x =  40 * Math.cos(Math.toRadians(angulo));
		y = 40 * Math.sin(Math.toRadians(angulo));
		x = getPuntoFinal().getX() + x;
		y = getPuntoFinal().getY() + y;
		punto = new Point((int) x,(int)  y);
		setPuntoFlechaDer(punto);
		
		x =  40 * Math.cos(Math.toRadians(angulo));
		y = 40 * Math.sin(Math.toRadians(angulo));
		x = getPuntoFinal().getX() - x;
		y = getPuntoFinal().getY() + y;
		punto = new Point((int) x,(int)  y);
		setPuntoFlechaIzq(punto);
		/*if(getPuntoFinal().getX() > getPuntoInicial().getX()){
			if(getPuntoFinal().getX() - getPuntoInicial().getX() < 60){
				y = (int) getPuntoInicial().getY() + 60;
				x = (int) ((y - getPuntoInicial().getY() + getPendienteFlecha() * getPuntoInicial().getX()) / getPendienteFlecha());
			}
			else{
				x = (int) (getPuntoInicial().getX() + escala);
				y = (int) (getPendienteFlecha()*(x - getPuntoInicial().getX()) + getPuntoInicial().getY());
			}
		}
		/*else if(getPuntoFinal().getX() < getPuntoInicial().getX()){
			x = (int) (getPuntoInicial().getX() - 60);
		}
		else {
			//x = (int) getPuntoInicial().getX();
			x = 0;
			y = 0;
		}
		
		 //y = (int) (getPendienteFlecha()*(x - getPuntoInicial().getX()) + getPuntoInicial().getY());

		Point punto = new Point(x, y);
		setPuntoFinal(punto);*/
	}

	public Point getPuntoInicial() {
		return puntoInicial;
	}

	public void setPuntoInicial(Point puntoInicial) {
		this.puntoInicial = puntoInicial;
	}

	public Point getPuntoFinal() {
		return puntoFinal;
	}

	public void setPuntoFinal(Point puntoFinal) {
		this.puntoFinal = puntoFinal;
	}


	public double getPendienteFlechasLaterales() {
		return pendienteFlechasLaterales;
	}

	public void setPendienteFlechasLaterales(double pendienteFlechasLaterales) {
		this.pendienteFlechasLaterales = pendienteFlechasLaterales;
	}

	public Point getPuntoFlechaDer() {
		return puntoFlechaDer;
	}

	public void setPuntoFlechaDer(Point puntoFlechaDer) {
		this.puntoFlechaDer = puntoFlechaDer;
	}

	public Point getPuntoFlechaIzq() {
		return puntoFlechaIzq;
	}

	public void setPuntoFlechaIzq(Point puntoFlechaIzq) {
		this.puntoFlechaIzq = puntoFlechaIzq;
	}

	public int getAnguloFlecha() {
		return anguloFlecha;
	}

	public void setAnguloFlecha(int anguloFlecha) {
		this.anguloFlecha = anguloFlecha;
	}

	public double getPendienteFlecha() {
		return pendienteFlecha;
	}

	public void setPendienteFlecha(double pendienteFlecha) {
		this.pendienteFlecha = pendienteFlecha;
	}
	

}
