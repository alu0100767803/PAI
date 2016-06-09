/**
 * 
 */
package es.esit.ull.PAI.AgujaBuffon;

import java.awt.Point;

/**
 * @author alu4487
 *
 */
public class Recta {
	
	private Point puntoInicial;
	private Point puntoFinal;
	private int pendiente;
	
	public Recta(Point inicial, Point fin){
		puntoInicial = inicial;
		puntoFinal = fin;
		calcularPendiente();
	}
	
	public void calcularPendiente(){
		/*int x = (int) getPuntoInicial()
		int y
		int x1
		int y1
		setPendiente(() / ());*/
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

	public int getPendiente() {
		return pendiente;
	}

	public void setPendiente(int pendiente) {
		this.pendiente = pendiente;
	}
	
	

}
