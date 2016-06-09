/**
 * 
 */
package es.esit.ull.PAI.OchoReinas;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 26/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que calcula el tiempo
 */
public class Clock {
	private long inicio;	// inicio del tiempo
	private long fin;	// fin del tiempo

	public Clock(){
		
	}
	
	public void stop(){
		setFin(System.currentTimeMillis());
	}
	
	public void start(){
		setInicio(System.currentTimeMillis());
	}
	
	public long eslapsedTime(){
		long time = getFin() - getInicio();
		return time;
	}

	public long getInicio() {
		return inicio;
	}

	public void setInicio(long inicio) {
		this.inicio = inicio;
	}

	public long getFin() {
		return fin;
	}

	public void setFin(long fin) {
		this.fin = fin;
	}

}
