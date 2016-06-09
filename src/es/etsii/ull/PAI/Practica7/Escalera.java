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
public class Escalera extends JPanel {
	
	public Escalera(){
		System.out.println(getWidth());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int x = 10;
		int y = 10;
		int height = 20;
		int weidth = 20;
		while( y + 20 < getHeight()){
			g.drawRect(x, y, weidth, 20);
			y += 20;
			weidth += 20;
		}


	}

}
