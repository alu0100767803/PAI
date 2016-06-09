/**
 * 
 */
package es.esit.ull.PAI.Practica12;

import java.applet.AudioClip;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.text.ElementIterator;

/**
 * @author Jorge
 *
 */
public class Disparos extends JPanel{
	
	private ArrayList<ArrayList<Bola>> vectorBolas;
	private Flecha flecha;
	private int nBolas;
	private Bola bolaADisparar;
	private boolean choque;
	
	private boolean iniciado;
	private boolean bolasPintadas;
	private boolean bolaLanzada;
	private Line2D linea;
	private Ellipse2D elipse;
	private BasicStroke stroke;
	private AudioClip sonidoError;
	private AudioClip sonidoAcierto;
	
	Timer timer = new Timer(100, new Listener());

	public Disparos(){

		iniciado = false;
		bolasPintadas = false;
		bolaLanzada = false;
		vectorBolas = new ArrayList<ArrayList<Bola>>();
		flecha = new Flecha();
		//setBackground(Color.WHITE);
		sonidoError = java.applet.Applet.newAudioClip(getClass().getResource("/error.wav"));
		sonidoAcierto = java.applet.Applet.newAudioClip(getClass().getResource("/acierto.wav"));

		
		addMouseMotionListener(new CustomMouseMotionListener());
		addMouseListener(new Oyente());
		linea = new Line2D.Double();
		stroke = new BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
		
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		iniciarComponentes(g2d);
		pintarBolasIniciales(g2d);
		pintarFlecha(g2d);
		if(!bolaLanzada){
			Point punto = new Point(getWidth() / 2 - 20, getHeight() - 40);
			bolaADisparar = new Bola(punto, 40);
			bolaLanzada = true;
		}
		elipse = new Ellipse2D.Double(bolaADisparar.getPuntoBola().getX(), bolaADisparar.getPuntoBola().getY(), 40, 40);
		Color color = bolaADisparar.getColorBola();
		g2d.setColor(color);
		
		g2d.fill(elipse);
		
	}
	
	public void iniciarComponentes(Graphics2D g2d){
		Point punto = new Point(getWidth() / 2, getHeight());
		getFlecha().setPuntoInicial(punto);
		if(!isIniciado()){
			int x = (int) getFlecha().getPuntoInicial().getX();
			int y = (int) getFlecha().getPuntoInicial().getY()  - 30;
			punto = new Point(x, y);
			getFlecha().setPuntoFinal(punto);
			getFlecha().calcular();
			
			setnBolas(getWidth() / 40);
			int xBola = 0;
			int yBola = 0;
			ArrayList<Bola> bolasIniciales = new ArrayList<Bola>();
			for(int i = 0; i < getnBolas(); i++){
				Point puntoBola = new Point(xBola, yBola);
				Bola bola = new Bola(puntoBola, 40);
				bolasIniciales.add(bola);
				xBola += 40;
			}
			getVectorBolas().add(bolasIniciales);
			setIniciado(true);
		}
	}
	
	public void pintarBolasIniciales(Graphics2D g2d){
		
		for(int i = 0; i < getVectorBolas().size(); i++){
			for(int j = 0; j < getVectorBolas().get(i).size(); j++){
				int x = (int) vectorBolas.get(i).get(j).getPuntoBola().getX();
				int y = (int) vectorBolas.get(i).get(j).getPuntoBola().getY();
				int tamanyo = vectorBolas.get(i).get(j).getTamanyoBola();
				Color color = vectorBolas.get(i).get(j).getColorBola();
				elipse = new Ellipse2D.Double(x, y, tamanyo, tamanyo);
				g2d.setColor(color);
				g2d.fill(elipse);
			}
		}
		/*for(int i = 0; i < vectorBolas.size(); i++){
			int x = (int) vectorBolas.get(i).getPuntoBola().getX();
			int y = (int) vectorBolas.get(i).getPuntoBola().getY();
			int tamanyo = vectorBolas.get(i).getTamanyoBola();
			Color color = vectorBolas.get(i).getColorBola();
			elipse = new Ellipse2D.Double(x, y, tamanyo, tamanyo);
			g2d.setColor(color);
			g2d.fill(elipse);
		}*/
	}
	
	public void pintarFlecha(Graphics2D g2d){
		int x = (int) flecha.getPuntoInicial().getX();
		int y = (int) flecha.getPuntoInicial().getY();
		int x1 = (int) flecha.getPuntoFinal().getX();
		int y1 = (int) flecha.getPuntoFinal().getY();
		linea.setLine(x, y, x1, y1);
		g2d.setStroke(stroke);
		g2d.setColor(Color.BLACK);
		g2d.draw(linea);
		
		x = (int) flecha.getPuntoFinal().getX();
		y = (int) flecha.getPuntoFinal().getY();
		x1 = (int) flecha.getPuntoFlechaDer().getX();
		y1 = (int) flecha.getPuntoFlechaDer().getY();
		linea.setLine(x, y, x1, y1);
		g2d.draw(linea);
		
		x = (int) flecha.getPuntoFinal().getX();
		y = (int) flecha.getPuntoFinal().getY();
		x1 = (int) flecha.getPuntoFlechaIzq().getX();
		y1 = (int) flecha.getPuntoFlechaIzq().getY();
		linea.setLine(x, y, x1, y1);
		g2d.draw(linea);
		/*x = (int) flecha.getPuntoFinal().getX();
		y = (int) flecha.getPuntoFinal().getY();
		x1 = (int) getFlecha().getPuntoFlechaDer().getX();
		y1 = (int) getFlecha().getPuntoFlechaDer().getY();
		linea.setLine(x, y, x1, y1);
		g2d.draw(linea);*/
	}
	
	class CustomMouseMotionListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			Point punto = new Point(e.getX(), e.getY());
			flecha.setPuntoFinal(punto);
			//getFlecha().calcular();
			getFlecha().calcularPendiente();
			getFlecha().calcularPuntoFinal();
			//getFlecha().calcularPuntoFinal();
			repaint();
		}    
 } 
	
	class Oyente implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			getBolaADisparar().setPendienteBola(getFlecha().getPendienteFlecha());
			getTimer().start();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean ocupada = false;
			int actual;
			int nivelBorrar;
			int nivel = 0;
			for(int i = getVectorBolas().size() - 1; i >= 0; i--){
				for(int j = getVectorBolas().get(i).size() - 1; j >= 0; j--){
					int tamanyo = getBolaADisparar().getTamanyoBola();
					double xInicial = getBolaADisparar().getPuntoBola().getX();
					double xFinal = getBolaADisparar().getPuntoBola().getX() + tamanyo;
					if(xInicial >= getVectorBolas().get(i).get(j).getPuntoBola().getX() 
								&& xInicial <= getVectorBolas().get(i).get(j).getPuntoBola().getX() + tamanyo){ 
									if(i > nivel)
										nivel = i;
					}
					if (xFinal >=  getVectorBolas().get(i).get(j).getPuntoBola().getX() 
								&& xFinal <= getVectorBolas().get(i).get(j).getPuntoBola().getX() + tamanyo){
													if(i > nivel)
														nivel = i;
					}
				}
			}
			
			if(getBolaADisparar().getPuntoBola().getY() >= getVectorBolas().get(nivel).get(0).getPuntoBola().getY() + getBolaADisparar().getTamanyoBola()){
				getBolaADisparar().calcular();
				repaint();
			}
			
			else{
				if(getVectorBolas().size() <= getBolaADisparar().getPuntoBola().getY() / getBolaADisparar().getTamanyoBola()){
					getVectorBolas().get((int) (getBolaADisparar().getPuntoBola().getY() / getBolaADisparar().getTamanyoBola())).add(getBolaADisparar());
					nivelBorrar = (int) (getBolaADisparar().getPuntoBola().getY() / getBolaADisparar().getTamanyoBola());
					actual = getVectorBolas().get((int) (getBolaADisparar().getPuntoBola().getY() / getBolaADisparar().getTamanyoBola())).size() - 1;
				}
				else{
					ArrayList<Bola> nivelNuevo = new ArrayList<Bola>();
					nivelNuevo.add(getBolaADisparar());
					getVectorBolas().add(nivelNuevo);
					actual = 0;
				  nivelBorrar = getVectorBolas().size() - 1;
				}
					int elim = choque((int) (getBolaADisparar().getPuntoBola().getY() / getBolaADisparar().getTamanyoBola()));
					if(choque == true){
						sonidoAcierto.play();
						getVectorBolas().get(nivel).remove(elim);
						getVectorBolas().get(nivelBorrar).remove(actual);
					}
					else
						sonidoError.play();
					Point punto = new Point((int) getFlecha().getPuntoInicial().getX() - 20, (int) getFlecha().getPuntoInicial().getY() - 40);
					Bola bola = new Bola(punto, 40);
					//setBolaADisparar(null);
					setBolaADisparar(bola);
					//setBolaLanzada(false);
					repaint();
					getTimer().stop();
			}
			
			if(getBolaADisparar().getPuntoBola().getX() - getBolaADisparar().getTamanyoBola() < 0){
				Point punto = new Point(0, (int) getBolaADisparar().getPuntoBola().getY());
				getBolaADisparar().setPuntoBola(punto);
				punto = new Point (getBolaADisparar().getRadio(), (int) getBolaADisparar().getPuntoBola().getY() + getBolaADisparar().getRadio());
				getBolaADisparar().setCentroBola(punto);
				getBolaADisparar().setPendienteBola(- getBolaADisparar().getPendienteBola());
			}
			
			if(getBolaADisparar().getCentroBola().getX() + getBolaADisparar().getRadio() > getWidth()){
				Point punto = new Point(getWidth() - getBolaADisparar().getTamanyoBola() , (int) getBolaADisparar().getPuntoBola().getY());
				getBolaADisparar().setPuntoBola(punto);
				punto = new Point(getWidth() - getBolaADisparar().getRadio(), (int) getBolaADisparar().getPuntoBola().getY() + getBolaADisparar().getRadio());
				getBolaADisparar().setCentroBola(punto);
				getBolaADisparar().setPendienteBola( - getBolaADisparar().getPendienteBola());
			}
			repaint();
		}
	}
	
	public int choque(int nivel){
		for(int i = 0; i < getVectorBolas().get(nivel).size() - 1; i++){
			if(getVectorBolas().get(nivel).get(i).getPuntoBola().getX() < getBolaADisparar().getCentroBola().getX() 
										&& getVectorBolas().get(nivel).get(i + 1).getPuntoBola().getX() > getBolaADisparar().getCentroBola().getX())
				if(getVectorBolas().get(nivel).get(i).getColorBola().equals(getBolaADisparar().getColorBola())){
					choque = true;
					return i;
				}
						
		}
		choque = false;
		return 0;
	}

	public Line2D getLinea() {
		return linea;
	}

	public void setLinea(Line2D linea) {
		this.linea = linea;
	}

	public ArrayList<ArrayList<Bola>> getVectorBolas() {
		return vectorBolas;
	}

	public void setVectorBolas(ArrayList<ArrayList<Bola>> vectorBolas) {
		this.vectorBolas = vectorBolas;
	}

	public Flecha getFlecha() {
		return flecha;
	}

	public void setFlecha(Flecha flecha) {
		this.flecha = flecha;
	}

	public boolean isIniciado() {
		return iniciado;
	}

	public void setIniciado(boolean iniciado) {
		this.iniciado = iniciado;
	}

	public boolean isBolasPintadas() {
		return bolasPintadas;
	}

	public void setBolasPintadas(boolean bolasPintadas) {
		this.bolasPintadas = bolasPintadas;
	}

	public Ellipse2D getElipse() {
		return elipse;
	}

	public void setElipse(Ellipse2D elipse) {
		this.elipse = elipse;
	}

	public BasicStroke getStroke() {
		return stroke;
	}

	public void setStroke(BasicStroke stroke) {
		this.stroke = stroke;
	}

	public int getnBolas() {
		return nBolas;
	}

	public void setnBolas(int nBolas) {
		this.nBolas = nBolas;
	}

	public Bola getBolaADisparar() {
		return bolaADisparar;
	}

	public void setBolaADisparar(Bola bolaADisparar) {
		this.bolaADisparar = bolaADisparar;
	}

	public boolean isBolaLanzada() {
		return bolaLanzada;
	}

	public void setBolaLanzada(boolean bolaLanzada) {
		this.bolaLanzada = bolaLanzada;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	

}
