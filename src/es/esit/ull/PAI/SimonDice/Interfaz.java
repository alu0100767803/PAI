/**
 * 
 */
package es.esit.ull.PAI.SimonDice;

import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import es.esit.ull.PAI.SimonDice.Paneles.Listener;

/**
 * @author alu4487
 *
 */
public class Interfaz extends JPanel {

	private Botones panelBotones;
	private Paneles	paneles;
	
	public Interfaz(){
		
		panelBotones = new Botones();
		paneles = new Paneles();
		
		setLayout(new BorderLayout());
		
		add(BorderLayout.SOUTH, getPanelBotones());
		add(BorderLayout.CENTER, getPaneles());
		
		MouseListener l = new MouseListener() {
			
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(e.getSource() == getPaneles().getAzul()){
					getPaneles().cambiarColorAzul();
					System.out.println("Azul");
					repaint();
				}
				
				if(e.getSource() == getPaneles().getRojo()){
					getPaneles().cambiarColorRojo();
					System.out.println("Rojo");
					repaint();
				}
				
				if(e.getSource() == getPaneles().getVerde()){
					getPaneles().cambiarColorVerde();
					System.out.println("Verde");
					repaint();
				}
				
				if(e.getSource() == getPaneles().getAmarillo()){
					getPaneles().cambiarColorAmarillo();
					System.out.println("Amarillo");
					repaint();
				}
				
			}
		};
		
		getPaneles().setFocusable(true);
		getPaneles().getAzul().addMouseListener(l);
		getPaneles().getRojo().addMouseListener(l);
		getPaneles().getAmarillo().addMouseListener(l);
		getPaneles().getVerde().addMouseListener(l);
		
	}

	public Botones getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(Botones panelBotones) {
		this.panelBotones = panelBotones;
	}

	public Paneles getPaneles() {
		return paneles;
	}

	public void setPaneles(Paneles paneles) {
		this.paneles = paneles;
	}



	
	

}
