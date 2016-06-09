/**
 * 
 */
package es.esit.ull.PAI.Practica13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 12/05/2016
 * Asignatura: Programaci�n de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase quedibuja la matriz de celulas
 */
public class PanelCelulas extends JPanel{

	private Celulas celulas;
	private int tamanyoCelulaX;
	private int tamanyoCelulaY;
	private int delay = 150;
	private Timer timer = new Timer(delay, new ListenerTimer());
	
	public PanelCelulas(){
		celulas = new Celulas();
		addMouseListener(new Listener());
		this.setFocusable(true);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		calcularTamanyoCelulas(g);
		//pintarCelulasMuertas(g);
		dibujarCelulas(g);
		
	}
	
	private void dibujarCelulas(Graphics g){
		int x = 0;
		int y = 0;
		for(int i = 0; i < getCelulas().getNUMERO_CELULAS(); i++){
			for(int j = 0; j < getCelulas().getNUMERO_CELULAS(); j++){
				if(getCelulas().getCelulasActuales(i, j)){
					g.setColor(Color.BLUE);
					g.fillRect(x, y, getTamanyoCelulaX(), getTamanyoCelulaY());
					g.setColor(Color.BLACK);
					g.drawLine(x, 0, x, getHeight());
				}
				else {
					g.setColor(Color.GRAY);
					g.fillRect(x, y, getTamanyoCelulaX(), getTamanyoCelulaY());
					g.setColor(Color.BLACK);
					g.drawLine(x, 0, x, getHeight());
				}
				x += getTamanyoCelulaX();
			}
			x = 0;
			g.drawLine(0, y, getWidth(), y);
			y += getTamanyoCelulaY();
		}
	}

	private void calcularTamanyoCelulas(Graphics g) {
		int tamanyoX = getWidth() / getCelulas().getNUMERO_CELULAS();
		int tamanyoY = getHeight() / getCelulas().getNUMERO_CELULAS();
		
		if(getWidth() % getCelulas().getNUMERO_CELULAS() >= 5)
			tamanyoX++;
		if(getHeight() % getCelulas().getNUMERO_CELULAS() >= 5)
			tamanyoY++;
		
		setTamanyoCelulaX(tamanyoX);
		setTamanyoCelulaY(tamanyoY);
		
	}
	
	public void pintarCelulasMuertas(Graphics g){
		int x = 0;
		int y = 0;
		for(int i = 0; i < getCelulas().getNUMERO_CELULAS(); i++){
				for(int j = 0; j < getCelulas().getNUMERO_CELULAS(); j++){
				g.setColor(Color.BLACK);
				g.fillRect(x, y, getTamanyoCelulaX(), getTamanyoCelulaY());
				y += getTamanyoCelulaY();
			}
				x += getTamanyoCelulaX();
				y = 0;
		}
	}
	
	class Listener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int  x = e.getX() / getTamanyoCelulaX();
			int y = e.getY() / getTamanyoCelulaY();
			if(getCelulas().getCelulasActuales(y, x) == false)
				getCelulas().setCelulasActuales(y, x, true);
			else
				getCelulas().setCelulasActuales(y, x, false);
			repaint();	
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
				
			
		}
	
	class ListenerTimer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			getCelulas().calcularSiguiente();
			repaint();		
		}	
	}
	
	/*
	 * -------------------------------------- Getters y Setters ----------------------------------------------------------
	 */
	
	public void pausar(){
		getTimer().stop();
	}
	
	public void reanudar(){
		getTimer().restart();
	}
	public void empezar(){
		getTimer().start();
	}
	
	public Celulas getCelulas() {
		return celulas;
	}

	public void setCelulas(Celulas celulas) {
		this.celulas = celulas;
	}

	public int getTamanyoCelulaX() {
		return tamanyoCelulaX;
	}

	public void setTamanyoCelulaX(int tamanyoCelulaX) {
		this.tamanyoCelulaX = tamanyoCelulaX;
	}

	public int getTamanyoCelulaY() {
		return tamanyoCelulaY;
	}

	public void setTamanyoCelulaY(int tamanyoCelulaY) {
		this.tamanyoCelulaY = tamanyoCelulaY;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	
}
