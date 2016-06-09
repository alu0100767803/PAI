/**
 * 
 */
package es.esit.ull.PAI.AgujaBuffon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author alu4487
 *
 */
public class Cuadricula extends JPanel{
	
	private int unidad;
	private final int nUnidades = 3;
	private ArrayList<Recta> rectas;
	private boolean rectasCalculadas; 
	private int ancho;
	private int alto;
	private ArrayList<Point> puntosAleatorios;
	private ArrayList<Point> puntosFinales;
	private ArrayList<Point> puntosMedios;
	private final int FACTOR_RGB = 255;
	private final int TAMANYO_PUNTO = 3;
	
	public Cuadricula(){
		rectas = new ArrayList<Recta>();
		rectasCalculadas = false;
		puntosAleatorios = new ArrayList<Point>();
		puntosFinales = new ArrayList<Point>();
		puntosMedios = new ArrayList<Point>();
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		setUnidad(getHeight() / getnUnidades());
		setAncho(getWidth());
		setAlto(getHeight());
		if(!isRectasCalculadas())
			calcularRectas(g);
		pintarLineas(g);
		
		if(!getPuntosAleatorios().isEmpty()){
			for(int i = 0; i < getPuntosAleatorios().size(); i++){
				int x = (int) getPuntosAleatorios().get(i).getX();
				int y = (int) getPuntosAleatorios().get(i).getY();
				int x1 = (int) getPuntosFinales().get(i).getX();
				int y1 = (int) getPuntosFinales().get(i).getY();
				g.setColor(colorAleatorio());
				g.drawLine(x, y, x1, y1);
			}
		}
	}
	
	private void calcularRectas(Graphics g){
		int x = 0;
		int y = getUnidad();
		int x1 = getWidth();
		int y1  = getUnidad();
		Point inicio = new Point(x, y);
		Point fin = new Point(x1, y1);
		Recta recta = new Recta(inicio, fin);
		getRectas().add(recta);
		
		y += getUnidad();
		y1 += getUnidad();
		inicio = new Point(x, y);
		fin = new Point(x1, y1);
		recta = new Recta(inicio, fin);
		getRectas().add(recta);
		setRectasCalculadas(true);
		
	}
	
	public void pintarLineas(Graphics g){
		for(int i = 0; i < getRectas().size(); i++){
			int x = (int) getRectas().get(i).getPuntoInicial().getX();
			int y = (int) getRectas().get(i).getPuntoInicial().getY();
			int x1 = (int) getRectas().get(i).getPuntoFinal().getX();
			int y1 = (int) getRectas().get(i).getPuntoFinal().getY();
			g.drawLine(x, y, x1, y1);
		}
	}
	
	public void calcularPuntosAleatorios(int nPuntos){
		getPuntosAleatorios().clear();
		for(int i = 0; i < nPuntos; i++){
			int x = (int) Math.round(Math.random() * getAncho());
			int y = (int) Math.round(Math.random() * getAlto());
			Point punto = new Point(x, y);
			getPuntosAleatorios().add(punto);
		}
		calcularPuntosFinales();
		
	}
	
	
	public void calcularPuntosFinales(){
		getPuntosFinales().clear();
		for(int i = 0; i < getPuntosAleatorios().size(); i++){
			int angulo = (int) Math.round(Math.random() * 180);
			int x = (int) (Math.cos(Math.toRadians(angulo)) * getUnidad());
			int y = (int) (Math.sin(Math.toRadians(angulo)) * getUnidad());
			
			x += getPuntosAleatorios().get(i).getX();
			y += getPuntosAleatorios().get(i).getY();
			Point punto = new Point(x, y);
			getPuntosFinales().add(punto);
			
		}
	}
	
	public Color colorAleatorio(){
		
		int r = (int) Math.round(Math.random() * getFACTOR_RGB());
		int g = (int) Math.round(Math.random() * getFACTOR_RGB());
		int b = (int) Math.round(Math.random() * getFACTOR_RGB());
		
		return new Color(r, g, b);
	}

	public int getUnidad() {
		return unidad;
	}

	public void setUnidad(int unidad) {
		this.unidad = unidad;
	}

	public int getnUnidades() {
		return nUnidades;
	}

	public ArrayList<Recta> getRectas() {
		return rectas;
	}

	public void setRectas(ArrayList<Recta> rectas) {
		this.rectas = rectas;
	}

	public boolean isRectasCalculadas() {
		return rectasCalculadas;
	}

	public void setRectasCalculadas(boolean rectasCalculadas) {
		this.rectasCalculadas = rectasCalculadas;
	}


	public ArrayList<Point> getPuntosAleatorios() {
		return puntosAleatorios;
	}

	public void setPuntosAleatorios(ArrayList<Point> puntosAleatorios) {
		this.puntosAleatorios = puntosAleatorios;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getFACTOR_RGB() {
		return FACTOR_RGB;
	}

	public int getTAMANYO_PUNTO() {
		return TAMANYO_PUNTO;
	}

	public ArrayList<Point> getPuntosFinales() {
		return puntosFinales;
	}

	public void setPuntosFinales(ArrayList<Point> puntosFinales) {
		this.puntosFinales = puntosFinales;
	}

	public ArrayList<Point> getPuntosMedios() {
		return puntosMedios;
	}

	public void setPuntosMedios(ArrayList<Point> puntosMedios) {
		this.puntosMedios = puntosMedios;
	}

	
}
