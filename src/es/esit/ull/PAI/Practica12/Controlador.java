/**
 * 
 */
package es.esit.ull.PAI.Practica12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * @author Jorge
 *
 */
public class Controlador extends JPanel{

	private PanelBotones panelBotones;
	private VentanaDatos ventanaDatos;
	private Disparos disparos;
	
	public Controlador(){
		setLayout(new BorderLayout());
		panelBotones = new PanelBotones();
		ventanaDatos = new VentanaDatos();
		disparos = new Disparos();
		
		add(BorderLayout.CENTER, disparos);
		add(BorderLayout.SOUTH, panelBotones);
		
		getBotonInformacion().addActionListener(new Oyente());
		
	}
	
	public JButton getBotonInformacion(){
		return getPanelBotones().getInformacion();
	}

	public PanelBotones getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(PanelBotones panelBotones) {
		this.panelBotones = panelBotones;
	}
	
	class Oyente implements ActionListener {													
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == getBotonInformacion()){
				ventanaDatos.setVisible(true);
			}
		}
	}
	
}
