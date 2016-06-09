/**
 * 
 */
package es.esit.ull.PAI.Practica13;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 12/05/2016
 * Asignatura: Programaci�n de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que se encarga de crear la ventana e incluir el panel de botones y el panel de celulas
 */

public class Controlador extends JPanel{
	
	private final String BLINKER = "Blinker";
	private final String GLIDER = "Glider";
	private final String DIEHARD = "Diehard";
	
	private PanelBotones panelBotones;
	private PanelCelulas panelCelulas;
	private VentanaDatos ventanaDatos;
	private VentanaAyuda ventanaAyuda;

	public Controlador(){
		setLayout(new BorderLayout());

		panelBotones = new PanelBotones();
		panelCelulas = new PanelCelulas();
		ventanaDatos = new VentanaDatos();
		ventanaAyuda = new VentanaAyuda();
		
		add(BorderLayout.CENTER, panelCelulas);
		add(BorderLayout.SOUTH, panelBotones);
		
		anyadirListeners();
	}
	
	public void anyadirListeners(){
		getBotonPausa().addActionListener(new Listener());
		getBotonReanudar().addActionListener(new Listener());
		getBotonInicio().addActionListener(new Listener());
		getBotonFin().addActionListener(new Listener());
		getBotonPaso().addActionListener(new Listener());
		getBotonInformacion().addActionListener(new Listener());
		getSliderVelocidad().addChangeListener(new ListenerVelocidad());
		getRepeticiones().addActionListener(new Listener());
		getPatronCelular().addItemListener(new ListenerComboBox());
	}
	
	class ListenerVelocidad implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			int velocidad = getSliderVelocidad().getValue();
			getPanelCelulas().getTimer().setDelay(200 - velocidad );
			repaint();
			/*JSlider vel = (JSlider)e.getSource();
			setDelayNuevo(getDelay() / vel.getValue());
			getTimer().setDelay(getDelayNuevo());
			System.out.println(getDelayNuevo());
			getTimer().start();*/
		}
		
	}
	
	class ListenerComboBox implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getItem() == getPatronCelular().getSelectedItem()){
				if(getPatronCelular().getSelectedItem().equals(getBLINKER())){
					getPanelCelulas().getCelulas().colocarBlinker();
				}
				else if(getPatronCelular().getSelectedItem().equals(getGLIDER())){
					getPanelCelulas().getCelulas().colocarGlider();
				}
				else if(getPatronCelular().getSelectedItem().equals(getDIEHARD())){
					getPanelCelulas().getCelulas().colocarDiehard();
				}
			}
			
		}
		
	}

	class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == getBotonPausa()){
				getPanelCelulas().pausar();
			}
			
			else if(e.getSource() == getBotonReanudar()){
				getPanelCelulas().reanudar();
			}
			
			else if(e.getSource() == getBotonInicio()){
				getPanelCelulas().empezar();
			}
			
			else if(e.getSource() == getBotonFin()){
				getPanelCelulas().getCelulas().matarCelulas();
				getPanelCelulas().getTimer().stop();
				repaint();
			}
			
			else if(e.getSource() == getBotonPaso()){
				getPanelCelulas().getCelulas().calcularSiguiente();
				repaint();
			}
			
			else if(e.getSource() == getBotonInformacion()){
				getVentanaDatos().setVisible(true);
			}
			
			else if(e.getSource() == getRepeticiones()){
				int valor = Integer.parseInt(getRepeticiones().getText());
				if(valor >= 1 && valor <= 100){}
				else
					getVentanaAyuda().setVisible(true);
				}
			}
			
		}
		
		
	



	/*
	 * -------------------------------------- Getters y Setters ----------------------------------------------------------
	 */
	
	public JComboBox getPatronCelular(){
		return getPanelBotones().getPatronCelular();
	}
	
	
	public JTextField getRepeticiones(){
		return getPanelBotones().getRepeticiones();
	}
	
	public JSlider getSliderVelocidad(){
		return getPanelBotones().getVelocidad();
	}
	
	public JButton getBotonInformacion(){
		return getPanelBotones().getInformacion();
	}
	
	public JButton getBotonFin(){
		return getPanelBotones().getFin();
	}
	
	public JButton getBotonInicio(){
		return getPanelBotones().getInicio();
	}
	
	public JButton getBotonPaso(){
		return getPanelBotones().getPaso();
	}
	
	public JButton getBotonPausa(){
		return getPanelBotones().getPausa();
	}
	
	public JButton getBotonReanudar(){
		return getPanelBotones().getReanudar();
	}
	
	public PanelBotones getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(PanelBotones panelBotones) {
		this.panelBotones = panelBotones;
	}

	public PanelCelulas getPanelCelulas() {
		return panelCelulas;
	}

	public void setPanelCelulas(PanelCelulas panelCelulas) {
		this.panelCelulas = panelCelulas;
	}

	public VentanaDatos getVentanaDatos() {
		return ventanaDatos;
	}

	public void setVentanaDatos(VentanaDatos ventanaDatos) {
		this.ventanaDatos = ventanaDatos;
	}

	public VentanaAyuda getVentanaAyuda() {
		return ventanaAyuda;
	}

	public void setVentanaAyuda(VentanaAyuda ventanaAyuda) {
		this.ventanaAyuda = ventanaAyuda;
	}

	public String getBLINKER() {
		return BLINKER;
	}

	public String getGLIDER() {
		return GLIDER;
	}

	public String getDIEHARD() {
		return DIEHARD;
	}

	

}
