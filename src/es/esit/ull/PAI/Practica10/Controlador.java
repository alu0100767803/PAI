/**
 * 
 */
package es.esit.ull.PAI.Practica10;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 23/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea el panel con los botones y el grafico
 */
public class Controlador extends JPanel {
	
	private Vista vista;
	private PanelBotones panelBotones;
	private Quickhull quickhull;
	private final int ALTO;
	private final int ANCHO;
	
	public Controlador(int ancho, int alto){
		
		ANCHO = ancho;
		ALTO = alto;
		panelBotones = new PanelBotones();
		quickhull = new Quickhull(ANCHO, ALTO);
		System.out.println(quickhull.getnPuntos());
		vista = new Vista(quickhull);
		
		setLayout(new BorderLayout());
		
		add(BorderLayout.CENTER, vista);
		add(BorderLayout.SOUTH, getPanelBotones());
		System.out.println(ALTO);
		
		getBotonIniciar().addActionListener(new Oyente());
		getBotonPuntos().addActionListener(new Oyente());
		getBotonLimpiar().addActionListener(new Oyente());
		getNumeroPuntos().addActionListener(new Oyente());
		
		
	}
	

	public Vista getVista() {
		return vista;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

	public PanelBotones getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(PanelBotones panelBotones) {
		this.panelBotones = panelBotones;
	}

	public Quickhull getQuickhull() {
		return quickhull;
	}

	public void setQuickhull(Quickhull quickhull) {
		this.quickhull = quickhull;
	}
	
	public JButton getBotonPuntos(){
		return getPanelBotones().getBotonPuntos();
	}
	
	public JButton getBotonLimpiar(){
		return getPanelBotones().getBotonLimpiar();
	}
	
	public JTextField getNumeroPuntos(){
		return getPanelBotones().getNumeroPuntos();
	}
	
	public JButton getBotonIniciar(){
		return getPanelBotones().getBotonIniciar();
	}
	
	class Oyente implements ActionListener {													
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == getBotonPuntos() ){
				getVista().setPintarPuntos(true);
				repaint();
			}
			else if(e.getSource() == getBotonIniciar()){
				getVista().setPintarLineas(true);
				repaint();
			}
			else if(e.getSource() == getBotonLimpiar()){
				getVista().setPintarPuntos(false);
				getVista().setPintarLineas(false);
				repaint();
			}
			else if(e.getSource() == getNumeroPuntos()){
				if(Integer.parseInt(getNumeroPuntos().getText()) > 0){
					getVista().getQuickhull().setnPuntos(Integer.parseInt(getNumeroPuntos().getText()));
					getVista().setPintarPuntos(true);
					repaint();
				}
			}
		}
	}
	
	
}
