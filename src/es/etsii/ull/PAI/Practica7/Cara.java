/**
 * 
 */
package es.etsii.ull.PAI.Practica7;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Jorge
 *
 */
public class Cara extends JPanel {
	
	public Cara(){
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Circulo que da forma a la cara
		g.drawOval(getWidth() / 2 - 75, getHeight() / 2 - 75, 150, 150);
		
		// Ciurculos que representan los ojos
		g.setColor(Color.BLUE);
		g.fillOval(getWidth() / 2 - 45, getHeight() / 2 - 30, 30, 30);
		g.fillOval(getWidth() / 2 + 15, getHeight() / 2 - 30, 30, 30);
		
		// Linea que representa la boca
		g.setColor(Color.RED);
		g.drawLine(getWidth() / 2 - 30, getHeight() / 2 + 30 , getWidth() / 2 + 30, getHeight() / 2 + 30);
	}

}
