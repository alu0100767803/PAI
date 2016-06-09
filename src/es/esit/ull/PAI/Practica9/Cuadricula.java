/**
 * @author Jorge Alonso Hern�ndez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 17/04/2016
 * Asignatura: Programaci�n de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que contiene la cuadricula y el camino aleatorio 
 */
package es.esit.ull.PAI.Practica9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.*;



class Cuadricula extends JPanel {
	
	private int densidad;													// numero de celdas que tiene la cuadricula
	private int nLineas;													// numero de lineas, sin contar los bordes, que tiene la cuadricula
	private int nivel;
	private Color color;													// color del camino
	private boolean pintarCamino;								// variable que nos va a indicar si debemos pintar el camino o no
	private boolean cambiarColor;								// variable que nos va a indicar si debemos cambiar el color del camino
	private boolean pintarPasoPaso;
	
	private Line2D linea;
	private BasicStroke stroke;		
	private final int DELAY = 200;
	private Timer timer = new Timer(DELAY, new Listener());
	
	private int distanciaX;
	private int distanciaY;

	//private ArrayList<Integer> coordX;									// vector con todos los puntos x por donde va el camino
	//private ArrayList<Integer> coordY;									// vrector con todos los puntos y por donde va el camino
	
	private ArrayList<Point> vectorPuntos;
	
	private final int FACTOR_RGB = 255;									// valor maximo que se puede alcanzar para obtener un color en rgb
	private final int CINCO = 5;

	public Cuadricula(){
		new JPanel();
		color = Color.RED;
		densidad = 10;
		nLineas = densidad - 1;
		nivel = 0;
		distanciaX = 0;
		distanciaY = 0;
		pintarCamino = false;
		cambiarColor = false;
		pintarPasoPaso = false;
		vectorPuntos = new ArrayList<Point>();
		linea = new Line2D.Double();
		stroke = new BasicStroke(4f);
	}
	
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		pintarCuadricula(g);
		
		g.setColor(getColor());
		if(isCambiarColor()){
			g.setColor(color);
			setCambiarColor(false);
		}
		
		if(isPintarCamino()){
			pintar(g2d);
		}
		
		/*g.setColor(color);
		if(isCambiarColor() == true){
			if(getVectorPuntos().size() > 0){
				setPintarCamino(false);
				pintar(g);
			}
			setCambiarColor(false);
		}
		
		if(isPintarCamino() == true){
			calcularCamino(g);
			pintar(g);
		}*/
		
	}

	/**
	 * Metodo que se encarga de dibujar la cuadricula
	 * @param g
	 */
	private void pintarCuadricula(Graphics g){
		
	  int distanciaX = getWidth() / getDensidad();
		int distanciaY = getHeight() / getDensidad();
		
		if(getWidth() % getDensidad() >= 5)
			distanciaX++;
		if(getHeight() % getDensidad() >= 5)
			distanciaY++;
		
		setDistanciaX(distanciaX);
		setDistanciaY(distanciaY);
		
		int x = distanciaX;
		int y = distanciaY;
		
		/*g.drawLine(0, 0, 0, getHeight());
		g.drawLine(0, getHeight() -1 , getWidth(), getHeight() -1);
		g.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight());
		g.drawLine(0, 0, getWidth(), 0);*/
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		
		for (int i = 0; i < getnLineas(); i++){
			g.drawLine(x, 0, x, getHeight());
			g.drawLine(0, y, getWidth(), y);
			x += getDistanciaX();
			y += getDistanciaY();
		}
		
	}
	
	/**
	 * Metodo que se encarga de calcular todos los puntos que conformaran el camino
	 * @param g
	 */
	public void calcularCamino(){
		
		//int distanciaX = getWidth() / getDensidad();											// numero de pixeles que se va a desplazar en el eje x
		//int distanciaY = getHeight() / getDensidad();											// numero de pixeles que se va a desplazar en el eje y
		borrar();
		int x;																														// coordenada x a introducir en el vector de coordenadas x
		int y;																														// coordenada y a introducir en el vector de coordenadas y
		Point puntoInicial;
		/*if(getWidth() % getDensidad() >= 5)
			distanciaX++;
		if(getHeight() % getDensidad() >= 5)
			distanciaY++;*/

			x = getDistanciaX() * (getDensidad() / 2);
			y = getDistanciaY() * (getDensidad() / 2);
	
		/*if(getWidth() % getDensidad() >= 5)
			x++;
		if(getHeight() % getDensidad() >= 5)
			y++;*/
		
		puntoInicial = new Point(x, y);
		getVectorPuntos().add(puntoInicial);
		
		int xAux = x;																						// variable auxiliar para el punto x, para no perder el valor de x
																														// en caso de que ya exista el punto
		int yAux = y;																						// variable auxiliar para el punto y, para no perder el valor de y
																														// en caso de que ya exista el punto
		int signo;																							// variable que nos va a decir el signo de la operacion a realizar,
																														// si es un 1 ser� un mas y si es un 2 ser� un menos
		int coordenada;																					// variable que nos va a indicar en que eje nos vamos a desplazar
																														// si es un 1 nos desplazaremos por el eje x y si es un 2 nos desplazaremos por el eje y
		
		int iteracion = 0;
		Point punto;
		while(x > 0 && x <= getWidth() && y >  0 && y <= getHeight()){
			xAux = x;
			yAux = y;
			
		signo = (int) (Math.random() * 2 + 1);
		coordenada = (int) (Math.random() * 2 + 1);
		
		if(coordenada == 1){
			if (signo == 1)
				xAux += distanciaX;
			else if ( signo == 2)
				xAux -= distanciaX;
		}
		else if(coordenada == 2){
			if(signo == 1)
				yAux += distanciaY;
			else if(signo == 2)
				yAux -= distanciaY;
		}
		Point puntoAux = new Point(xAux, yAux);
		if(!getVectorPuntos().contains(puntoAux)){
			x = xAux;
			y = yAux;
			punto = new Point(x, y);
			getVectorPuntos().add(punto);
		}
		else
			iteracion++;
		
		if(iteracion > 2 * getDensidad()){
			borrar();
			x = (int) puntoInicial.getX();
			y = (int) puntoInicial.getY();	
			getVectorPuntos().add(puntoInicial);
			iteracion = 0;
		}
		}
		
	}
	
	/**
	 * Metodo que pinta el camino
	 * @param g
	 */
	public void pintar(Graphics2D g2d){
		if(isPintarPasoPaso()){
			int x, y, x1, y1;
			for(int j = 0; j < getVectorPuntos().size() - 1 && j <= getNivel(); j++){
				x = (int) getVectorPuntos().get(j).getX();
				y = (int) getVectorPuntos().get(j).getY();
				x1 = (int) getVectorPuntos().get(j + 1).getX();
				y1 = (int) getVectorPuntos().get(j + 1).getY();
				linea.setLine(x, y, x1, y1);
				g2d.setStroke(stroke);
				g2d.draw(linea);
				
			}
		}
		else{
		int x, y, x1, y1;
			for(int i = 0; i < getVectorPuntos().size() - 1; i++){
				x = (int) getVectorPuntos().get(i).getX();
				y = (int) getVectorPuntos().get(i).getY();
				x1 = (int) getVectorPuntos().get(i + 1).getX();
				y1 = (int) getVectorPuntos().get(i + 1).getY();
				linea.setLine(x, y, x1, y1);
				g2d.setStroke(stroke);
				g2d.draw(linea);
			}
		}
	}
	
	/**
	 * Metodo que borra los vectores de coordenadas, para poder pintar un nuevo camino
	 */
	public void borrar(){
			getVectorPuntos().clear();
	}
	
	/**
	 * Metodo que comprueba si el punto que se le pasa ya existe en los vectores de coordenadas
	 * @param x
	 * @param y
	 * @return
	 */
	/*public boolean existePunto(int x, int y){
		for(int i = 0; i < getCoordX().size(); i++)
			if(getCoordX().get(i) == x && getCoordY().get(i) == y)
				return true;
		return false;
	}*/
	
	/**
	 * Metodo que cambia el color del camino a un color aleatorio
	 */
	public void colorAleatorio(){
		
		int r = (int) Math.round(Math.random() * getFACTOR_RGB());
		int g = (int) Math.round(Math.random() * getFACTOR_RGB());
		int b = (int) Math.round(Math.random() * getFACTOR_RGB());
		
		setColor(new Color(r, g, b));
	}
	
	public void empezar(){
		getTimer().start();
	}
	public void pausar(){
		getTimer().stop();
	}
	public void reanudar(){
		getTimer().restart();
	}
	
	class Listener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
    	setNivel(getNivel() + 1);
    	repaint();
    }
  }

	public boolean isPintarCamino() {
		return pintarCamino;
	}

	public void setPintarCamino(boolean pintarCamino) {
		this.pintarCamino = pintarCamino;
	}
	
	public boolean isCambiarColor() {
		return cambiarColor;
	}

	public void setCambiarColor(boolean cambiarColor) {
		this.cambiarColor = cambiarColor;
	}
	
	public Color getColor() {
	return color;
}

public void setColor(Color color) {
	this.color = color;
}

	public int getDensidad() {
		return densidad;
	}

	public void setDensidad(int densidad) {
		this.densidad = densidad;
		setnLineas(densidad - 1);
	}

	public int getnLineas() {
		return nLineas;
	}

	public void setnLineas(int nLineas) {
		this.nLineas = nLineas;
	}

	public int getFACTOR_RGB() {
		return FACTOR_RGB;
	}

	public int getCINCO() {
		return CINCO;
	}
	
	// 
	public ArrayList<Point> getVectorPuntos() {
		return vectorPuntos;
	}

	public void setVectorPuntos(ArrayList<Point> vectorPuntos) {
		this.vectorPuntos = vectorPuntos;
	}

	public boolean isPintarPasoPaso() {
		return pintarPasoPaso;
	}

	public void setPintarPasoPaso(boolean pintarPasoPaso) {
		this.pintarPasoPaso = pintarPasoPaso;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getDistanciaX() {
		return distanciaX;
	}

	public void setDistanciaX(int distanciaX) {
		this.distanciaX = distanciaX;
	}

	public int getDistanciaY() {
		return distanciaY;
	}

	public void setDistanciaY(int distanciaY) {
		this.distanciaY = distanciaY;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public Line2D getLinea() {
		return linea;
	}

	public void setLinea(Line2D linea) {
		this.linea = linea;
	}

	public BasicStroke getStroke() {
		return stroke;
	}

	public void setStroke(BasicStroke stroke) {
		this.stroke = stroke;
	}

	public int getDELAY() {
		return DELAY;
	}
	

}
