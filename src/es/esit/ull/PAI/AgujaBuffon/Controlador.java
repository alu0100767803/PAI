/**
 * 
 */
package es.esit.ull.PAI.AgujaBuffon;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author alu4487
 *
 */
public class Controlador extends JPanel{
	
	private final int NUMERO_DIEZ = 10;
	private final int NUMERO_CIEN = 100;
	private final int NUMERO_MIL = 1000;
	
	private Cuadricula cuadricula;
	private PanelBotones panelBotones;
	
	public Controlador(){
		setLayout(new BorderLayout());
		
		cuadricula = new Cuadricula();
		panelBotones = new PanelBotones();
		
		add(BorderLayout.CENTER, cuadricula);
		add(BorderLayout.SOUTH, panelBotones);
		
		anyadirListeners();
	}
	
	public void anyadirListeners(){
		getBotonDrop().addActionListener(new Oyente());
		getBotonDrop1().addActionListener(new Oyente());
		getBotonDrop10().addActionListener(new Oyente());
		getBotonDrop100().addActionListener(new Oyente());
		getBotonDrop1000().addActionListener(new Oyente());
	}
	
	class Oyente implements ActionListener {													
		public void actionPerformed(ActionEvent e) {
				if(e.getSource() == getBotonDrop()){
					if(Integer.parseInt(getTextFieldAgujas().getText()) >= 1)
						System.out.println(Integer.parseInt(getTextFieldAgujas().getText()));
					getCuadricula().calcularPuntosAleatorios(Integer.parseInt(getTextFieldAgujas().getText()));
					repaint();
				}
						
				else if(e.getSource() == getBotonDrop1()){
						getCuadricula().calcularPuntosAleatorios(1);
						repaint();
					}
					
					else if(e.getSource() == getBotonDrop10()){
						getCuadricula().calcularPuntosAleatorios(getNUMERO_DIEZ());
						repaint();
					}
					
					else if(e.getSource() == getBotonDrop100()){
						getCuadricula().calcularPuntosAleatorios(getNUMERO_CIEN());
						repaint();
					}
					
					else if(e.getSource() == getBotonDrop1000()){
						getCuadricula().calcularPuntosAleatorios(getNUMERO_MIL());
						repaint();
					}
				}
			
		}
	
	
	public JButton getBotonDrop1(){
		return getPanelBotones().getDrop1();
	}
	
	public JButton getBotonDrop10(){
		return getPanelBotones().getDrop10();
	}
	
	public JButton getBotonDrop100(){
		return getPanelBotones().getDrop100();
	}
	
	public JButton getBotonDrop1000(){
		return getPanelBotones().getDrop1000();
	}
	
	public JButton getBotonDrop(){
		return getPanelBotones().getDrop();
	}
	
	public JTextField getTextFieldAgujas(){
		return getPanelBotones().getnAgujas();
	}

	public Cuadricula getCuadricula() {
		return cuadricula;
	}

	public void setCuadricula(Cuadricula cuadricula) {
		this.cuadricula = cuadricula;
	}

	public PanelBotones getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(PanelBotones panelBotones) {
		this.panelBotones = panelBotones;
	}

	public int getNUMERO_DIEZ() {
		return NUMERO_DIEZ;
	}

	public int getNUMERO_CIEN() {
		return NUMERO_CIEN;
	}

	public int getNUMERO_MIL() {
		return NUMERO_MIL;
	}

	
}
