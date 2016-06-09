/**
 * 
 */
package es.etsii.ull.PAI.Practica7;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Jorge
 *
 */
public class Espiral extends JPanel{

	public Espiral(){
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int factor = 160;
		int terminar = factor / 2;
		int x = 0;
		int y = 10;
		int x_superior = 0;
		int y_superior = 0;
		while (x != terminar){
			x_superior = factor;
			y_superior = factor -10;
			g.drawLine(x, y, x_superior, y);
			g.drawLine(x_superior, y, x_superior, y_superior);
			x += 10;
			if( y != terminar){
				y += 10;
				g.drawLine(x_superior, y_superior, x, y_superior);
				g.drawLine(x, y_superior, x, y);
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
