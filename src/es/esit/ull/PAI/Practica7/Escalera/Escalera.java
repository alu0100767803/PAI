/**
 * 
 */
package es.esit.ull.PAI.Practica7.Escalera;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Jorge
 *
 */
public class Escalera extends JPanel {
	
	public Escalera(){}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		pintarEscalera(g);
	}	
		
	private void pintarEscalera(Graphics g){
		final int x = 10; 
		int y = 10;
		final int alto = 20; 
		int ancho = 20;
		while( y + alto < getHeight()){
			g.drawRect(x, y, ancho, alto);
			y += 20;
			ancho += 20;
		}
	}

}
