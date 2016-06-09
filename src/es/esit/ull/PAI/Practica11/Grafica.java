
package es.esit.ull.PAI.Practica11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que dibuja las trazas de los tiros parabolicos
 */
public class Grafica extends JPanel{
	
	private int puntoXEje;
	private int puntoYEje;
	private boolean ejeIniciado;
	private ArrayList<TiroParabolico> vectorTiro;
	private final int FACTOR_RGB = 255;									// valor maximo que se puede alcanzar para obtener un color en rgb
	
	private final int CIEN = 100;												
	private final int CINCO = 5;
	private final int SEIS = 6;
	private final int DOSCIENTOS = 200;
	
	private boolean limpiar;
	private boolean rastro;
	int nivel;
	
	private Timer timer = new Timer(100, new Listener());

	public Grafica(){
		puntoXEje = 0;
		puntoYEje = 0;
		nivel = 0;
		ejeIniciado = false;
		rastro = false;
		limpiar = false;
		vectorTiro = new ArrayList<TiroParabolico>();
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		pintarEje(g);
		
		if(!isLimpiar()){
			pintarTiro(g);
		}
	}
	
	public void pintarTiro(Graphics g){
		/*getTiro().setyInicial(200);
		getTiro().setAngulo(45);
		getTiro().setVelocidadLanzamiento(60);
		getTiro().setxInicial(getPuntoXEje());
		getTiro().calcular();
		getTiro().calcularPuntos();*/
		
		for(int i = 0; i < getVectorTiro().size(); i++){
			if( i == getVectorTiro().size() - 1){
				getTimer().start();
				for(int j = 0; j < getVectorTiro().get(i).getVectorPuntos().size() && j <= getNivel(); j++){
					
					if(!isRastro()){
						obtenerFlecha(g, getVectorTiro().get(i).getAngulo());
						int x = (int) (getVectorTiro().get(i).getVectorPuntos().get(getNivel()).getX()) / 2 + (getPuntoXEje() / 2);     
						int y = (getPuntoYEje() - (int) ((getVectorTiro().get(i).getVectorPuntos().get(getNivel()).getY() - getCINCO()) / 2)) - getSEIS();
						g.setColor(getVectorTiro().get(i).getColorTiro());
						g.fillOval(x, y, getCINCO(), getCINCO());
						if(getVectorTiro().get(i).getVectorPuntos().size() / 2 - 2 < getNivel())
							pausar();
					}
					else{
						obtenerFlecha(g, getVectorTiro().get(i).getAngulo());
						int x = (int) (getVectorTiro().get(i).getVectorPuntos().get(j).getX()) / 2 + (getPuntoXEje() / 2);     
						int y = (getPuntoYEje() - (int) ((getVectorTiro().get(i).getVectorPuntos().get(j).getY() - getCINCO()) / 2)) - getSEIS();
						g.setColor(getVectorTiro().get(i).getColorTiro());
						g.fillOval(x, y, getCINCO(), getCINCO());
						if(getVectorTiro().get(i).getVectorPuntos().size() / 2 - 2 < getNivel())
							pausar();
					}
				}
			}
			else{
				if(!isRastro()){
					int ultimo = getVectorTiro().get(i).getVectorPuntos().size() - 1;
					int x = (int) (getVectorTiro().get(i).getVectorPuntos().get(ultimo).getX()) / 2 + (getPuntoXEje() / 2);     
					int y = (getPuntoYEje() - (int) ((getVectorTiro().get(i).getVectorPuntos().get(ultimo).getY() - getCINCO()) / 2)) - getSEIS();
					g.setColor(getVectorTiro().get(i).getColorTiro());
					g.fillOval(x, y, getCINCO(), getCINCO());
				}
				else{
					for(int j = 0; j < getVectorTiro().get(i).getVectorPuntos().size(); j++){
						int x = (int) (getVectorTiro().get(i).getVectorPuntos().get(j).getX()) / 2 + (getPuntoXEje() / 2);     
						int y = (getPuntoYEje() - (int) ((getVectorTiro().get(i).getVectorPuntos().get(j).getY() - getCINCO()) / 2)) - getSEIS();
						g.setColor(getVectorTiro().get(i).getColorTiro());
						g.fillOval(x, y, getCINCO(), getCINCO());	
					}
				}
			}
		}

		/*for(int i = 0; i < getTiro().getVectorPuntos().size()  && i <= nivel; i++){
			int x = (int) getTiro().getVectorPuntos().get(i).getX();
			int y = getPuntoYEje() - (int) getTiro().getVectorPuntos().get(i).getY();
			g.fillOval(x, y, 5, 5);			
		}*/
	}
	
	public void obtenerFlecha(Graphics g, double angulo){
		double pendiente = Math.tan(Math.toRadians(angulo));
		int x = getPuntoXEje() + 20;
		int y =  getPuntoYEje() - (int)(pendiente * (x -  getPuntoXEje()));
		g.setColor(Color.BLACK);
		g.drawLine(getPuntoXEje(), getPuntoYEje(), x, y);
		g.drawLine(x, y, x - 10 , y);
		g.drawLine(x, y, x, y + 10);
	}
	
	public void pintarEje(Graphics g){
		if(!isEjeIniciado()){
			setPuntoYEje(getHeight() - 30);
			setPuntoXEje(30);
			g.drawLine(getPuntoXEje(), 0, getPuntoXEje(), getPuntoYEje());
			g.drawLine(getPuntoXEje(), getPuntoYEje(), getWidth(), getPuntoYEje());
			//setEjeIniciado(true);
			int x = getPuntoXEje();
			String cadena;
			int cad = 0;
			for(int i = 0; i < getWidth(); i++){
				cadena = cad + "";
				g.drawLine(x, getPuntoYEje(), x, getPuntoYEje() + 10);
				g.drawString(cadena, x, getPuntoYEje() + 20);
				x += getCIEN();
				cad += getDOSCIENTOS();
			}
			
			cad = 0;
			int y = getPuntoYEje();
			for(int i = getHeight(); i > 0; i--){
				cadena = cad + "";
				g.drawLine(getPuntoXEje(),y,getPuntoXEje() - 10,y);
				g.drawString(cadena, getPuntoXEje() - 20, y);
				y -= getDOSCIENTOS();
				cad += getDOSCIENTOS();
				
			}
		}
	}
	
	public void anyadirTiro(double angulo, double velocidad){
		TiroParabolico tiro = new TiroParabolico();
		tiro.setAngulo(angulo);
		tiro.setVelocidadLanzamiento(velocidad);
		tiro.setxInicial(getPuntoXEje());
		tiro.calcular();
		tiro.calcularPuntos();
		tiro.setColorTiro(colorAleatorio());
		getVectorTiro().add(tiro);
	}
	
	public void pausar(){
		getTimer().stop();
	}
	
	public void reanudar(){
		getTimer().restart();
	}
	
public Color colorAleatorio(){
		
		int r = (int) Math.round(Math.random() * getFACTOR_RGB());
		int g = (int) Math.round(Math.random() * getFACTOR_RGB());
		int b = (int) Math.round(Math.random() * getFACTOR_RGB());
		
		return new Color(r, g, b);
	}
	
	class Listener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
    	setNivel(getNivel() + 1);
    	repaint();
    }
  }

	 /* -------------------------------------- Getters y Setters ----------------------------------------------------------
	 */
	
	public int getPuntoXEje() {
		return puntoXEje;
	}

	public void setPuntoXEje(int puntoXEje) {
		this.puntoXEje = puntoXEje;
	}

	public int getPuntoYEje() {
		return puntoYEje;
	}

	public void setPuntoYEje(int puntoYEje) {
		this.puntoYEje = puntoYEje;
	}

	public boolean isEjeIniciado() {
		return ejeIniciado;
	}

	public void setEjeIniciado(boolean ejeIniciado) {
		this.ejeIniciado = ejeIniciado;
	}

	public ArrayList<TiroParabolico> getVectorTiro() {
		return vectorTiro;
	}

	public void setVectorTiro(ArrayList<TiroParabolico> vectorTiro) {
		this.vectorTiro = vectorTiro;
	}

	public boolean isLimpiar() {
		return limpiar;
	}

	public void setLimpiar(boolean limpiar) {
		this.limpiar = limpiar;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public int getFACTOR_RGB() {
		return FACTOR_RGB;
	}

	public boolean isRastro() {
		return rastro;
	}

	public void setRastro(boolean rastro) {
		this.rastro = rastro;
	}

	public int getCIEN() {
		return CIEN;
	}

	public int getCINCO() {
		return CINCO;
	}

	public int getSEIS() {
		return SEIS;
	}

	public int getDOSCIENTOS() {
		return DOSCIENTOS;
	}
	
	
}
