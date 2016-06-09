/**
 * 
 */
package es.etsii.ull.PAI.Practica7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JPanel;

/**
 * @author Jorge
 *
 */
public class Cuadratica extends JPanel{
	
	private Polygon pol;
	private int[] ejex;
	private int[] ejey;
	
	protected Cuadratica(){
		pol = new Polygon();
		System.out.println(this.getWidth() - 60);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		// dibuja el eje de coordeadas
		g.drawLine(30, getHeight() / 2,getWidth() - 30, getHeight() / 2);	// eje x
		g.drawLine(getWidth() / 2, 30, getWidth() / 2, getHeight() - 30);	// eje y
		
		//dibuja la flecha del eje de coordenadas  x
		g.drawLine(getWidth() - 30, getHeight() / 2, getWidth() - 50, getHeight() / 2 - 10);
		g.drawLine(getWidth() - 30, getHeight() / 2, getWidth() - 50, getHeight() / 2 + 10);
		
		//dibuja la flecha del eje de coordenadas y
		g.drawLine(getWidth() / 2, 30, getWidth() / 2 - 10, 50);
		g.drawLine(getWidth() / 2, 30, getWidth() / 2 + 10, 50);
		
		//dibuja las letras del eje de coprdenadas x e y
		g.drawString("y", getWidth() / 2 + 30, 50);
		g.drawString("x", getWidth() - 50, getHeight() / 2 - 30);
		dibujarFuncion(g, -10, 10);
	}
	
	// public abstract double f(double x);
	
	public void dibujarFuncion(Graphics g, double x1, double x2){
		for (double i = x1; i < x2; i++){
			System.out.println("Entro");
			double y = ((double)Math.pow(i,2));
			double x_destino = (double) (i + 1);
			double y_destino = ((double)Math.pow(x_destino, 2));
			System.out.println((int)coord_x(i) + " , " + (int)coord_y(y));
			System.out.println((int)coord_x(x_destino) + " , " + (int)coord_y(y_destino));
			g.drawLine((int)coord_x(i), (int)coord_y(y), (int)coord_x(x_destino), (int)coord_y(y_destino));
		}
		/*double factorDeEscala = 0.1;
		double y;
		/*int i = 0;
		ejex = new int[this.getWidth() - 60];
		ejey = new int[this.getWidth() - 60];
		System.out.println(getWidth() - 30);
		/*for(int x = 30; x <= getWidth() - 30; x++){
			System.out.println(i);
			ejex[i] = x;
			ejey[i] = x + (int) (factorDeEscala * x * x);
			// pol.addPoint(x + A_EJE_Y, A_EJE_X + (int)f(x));
			//pol.addPoint(x + , (int)(factorDeEscala * x * x));
			i++;
		}
		g.drawPolyline(ejex, ejey, this.getWidth() - 60);
		int r = -40;
		int d = 40;
		for (int x = r; x < 20 ; x++){
			//System.out.println(factorDeEscala * x * x);
			 y = (Math.pow(x, 2));
			 pol.addPoint(x, (int) y);
			//pol.addPoint(x + getHeight() / 2, 254 - (int) (factorDeEscala * x * x));
		}
		g.drawPolygon(pol);*/
	}
	
	private double coord_x(double x){
		return x + getWidth() / 2;
	}
	
	private double coord_y(double y){
		return - y + getHeight() / 2;
	}
	

}
