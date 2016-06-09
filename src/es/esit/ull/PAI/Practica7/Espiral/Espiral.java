/**
 * 
 */
package es.esit.ull.PAI.Practica7.Espiral;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Jorge
 *
 */
public class Espiral extends JPanel{

	public Espiral(){}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		pintarEspiral(g);
	}
	
	private void pintarEspiral(Graphics g){
		int factor = 160;
		final int terminar = factor / 2;
		int x_izda = 0;
		int y_inferior = 10;
		int x_dcha = 0;
		int y_superior = 0;
		while (x_izda != terminar){
			x_dcha = factor;
			y_superior = factor -10;
			g.drawLine(x_izda, y_inferior, x_dcha, y_inferior);
			g.drawLine(x_dcha, y_inferior, x_dcha, y_superior);
			x_izda += 10;
			System.out.println("Entro");
			if( y_inferior != terminar){
				y_inferior += 10;
				g.drawLine(x_dcha, y_superior, x_izda, y_superior);
				g.drawLine(x_izda, y_superior, x_izda, y_inferior);
			}
			factor -= 10;
		}
		//g.drawLine(0, 10, 160, 10);
		//g.drawLine(160, 10, 160, 150);
		//g.drawLine(160, 150, 10, 150);
		//g.drawLine(10, 150, 10, 20);
		//g.drawLine(10, 20, 150, 20);
	}		
}
