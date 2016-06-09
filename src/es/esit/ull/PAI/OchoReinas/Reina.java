/**
 * 
 */
package es.esit.ull.PAI.OchoReinas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 26/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que pinta una reina
 */
public class Reina extends JPanel {
	
	private Image fondo;
	final private int ANCHO;
	final private int ALTO;
	
	public Reina(){
		new JPanel();
		ImageIcon imagen  = new ImageIcon("Corona.png");
		fondo = imagen.getImage();
		
		//setForeground(fondo);
		ANCHO = fondo.getWidth(this);
		ALTO = fondo.getHeight(this);
		setPreferredSize(new Dimension(ANCHO, ALTO));
	}
	
	@Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(fondo, 0, 0, null);
    
  }
	
	public Image getFondo() {
		return fondo;
	}

	public void setFondo(Image fondo) {
		this.fondo = fondo;
	}

	public int getANCHO() {
		return ANCHO;
	}

	public int getALTO() {
		return ALTO;
	}

	
	
}
