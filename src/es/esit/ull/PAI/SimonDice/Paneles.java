/**
 * 
 */
package es.esit.ull.PAI.SimonDice;

import java.applet.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.DocFlavor.URL;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author alu4487
 *
 */
public class Paneles extends JPanel {
	
	private JPanel azul;
	private JPanel rojo;
	private JPanel verde ;
	private JPanel amarillo;
	
	private Color colorAzul;
	private Color colorRojo;
	private Color colorVerde;
	private Color colorAmarillo;
	
	private final int DELAY = 10;
	
	Timer timer = new Timer(100, new Listener());
	private final Color COLOR_PULSAR = Color.BLACK;
	private AudioClip audioClip;
	
	public Paneles(){
		azul = new JPanel();
		rojo = new JPanel();
		verde = new JPanel();
		amarillo = new JPanel();
		
		colorAzul = Color.BLUE;
		colorRojo = Color.RED;
		colorVerde = Color.GREEN;
		colorAmarillo = Color.YELLOW;
		
		setLayout(new GridLayout(2,2));
		
		azul.setBackground(colorAzul);
		rojo.setBackground(colorRojo);
		verde.setBackground(colorVerde);
		amarillo.setBackground(colorAmarillo);
		
		// URL sonidoAzul = getClass().getResource("sonidos/Do.wav");
		// audioClip = Applet.newAudioClip(sonidoAzul);
		
		add(rojo);
		add(verde);
		add(azul);
		add(amarillo);
		
	}
	
	class Listener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
    	getAzul().setBackground(getColorAzul());
    	repaint();
    	getRojo().setBackground(getColorRojo());
    	repaint();
    	getVerde().setBackground(getColorVerde());
    	repaint();
    	getAmarillo().setBackground(getColorAmarillo());
      repaint();
      timer.stop();
    }
  }
	
	public void cambiarColorAzul(){
		timer.start();
		getAzul().setBackground(getCOLOR_PULSAR());
		repaint();
		
		
	}
	
	public void parar(){
		timer.stop();
	}
	
	public void cambiarColorRojo(){
		timer.start();
		getRojo().setBackground(getCOLOR_PULSAR());
	}
	
	public void cambiarColorVerde(){
		timer.start();
		getVerde().setBackground(getCOLOR_PULSAR());
	}
	
	public void cambiarColorAmarillo(){
		timer.start();
		getAmarillo().setBackground(getCOLOR_PULSAR());
	}

	public JPanel getAzul() {
		return azul;
	}

	public void setAzul(JPanel azul) {
		this.azul = azul;
	}

	public JPanel getRojo() {
		return rojo;
	}

	public void setRojo(JPanel rojo) {
		this.rojo = rojo;
	}

	public JPanel getVerde() {
		return verde;
	}

	public void setVerde(JPanel verde) {
		this.verde = verde;
	}

	public JPanel getAmarillo() {
		return amarillo;
	}

	public void setAmarillo(JPanel amarillo) {
		this.amarillo = amarillo;
	}

	public Color getColorAzul() {
		return colorAzul;
	}

	public void setColorAzul(Color colorAzul) {
		this.colorAzul = colorAzul;
	}

	public Color getColorRojo() {
		return colorRojo;
	}

	public void setColorRojo(Color colorRojo) {
		this.colorRojo = colorRojo;
	}

	public Color getColorVerde() {
		return colorVerde;
	}

	public void setColorVerde(Color colorVerde) {
		this.colorVerde = colorVerde;
	}

	public Color getColorAmarillo() {
		return colorAmarillo;
	}

	public void setColorAmarillo(Color colorAmarillo) {
		this.colorAmarillo = colorAmarillo;
	}

	public Color getCOLOR_PULSAR() {
		return COLOR_PULSAR;
	}

	
	
	
	
}
