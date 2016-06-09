
package es.esit.ull.PAI.Practica11;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que controlara tanto el panel con los botones como la grafica
 */
public class Interfaz extends JPanel{
	
	private Panel panel;
	private Grafica grafica;
	private PanelResultados resultados;
	private boolean datos;
	
	public Interfaz(){
		panel = new Panel();
		grafica = new Grafica();
		resultados = new PanelResultados();
		datos = false;
		
		setLayout(new BorderLayout());
		
		add(BorderLayout.SOUTH, panel);
		add(BorderLayout.CENTER, grafica);
		add(BorderLayout.EAST, resultados);
		
		getBotonBorrar().addActionListener(new Oyente());
		getBotonPausar().addActionListener(new Oyente());
		getBotonReanudar().addActionListener(new Oyente());
		getBotonLanzar().addActionListener(new Oyente());
		getCheckBoxRastro().addActionListener(new Oyente());
		getCheckBoxDatos().addActionListener(new Oyente());
		
	}
	
	
	class Oyente implements ActionListener {													
		public void actionPerformed(ActionEvent e) {
		
			if(e.getSource() == getCheckBoxDatos()){
				if(getCheckBoxDatos().isSelected()){
					setDatos(true);
					if(getGrafica().getVectorTiro().size() != 0){
						ponerDatos();
					}
					repaint();
				}
				
				else if(!getCheckBoxDatos().isSelected()){
					setDatos(false);
					getResultados().borrar();
					repaint();
				}
			}
			
			else if(e.getSource() == getCheckBoxRastro()){
				if(getCheckBoxRastro().isSelected()){
					getGrafica().setRastro(true);
					repaint();
				}
			
				else if(!getCheckBoxRastro().isSelected()){
					getGrafica().setRastro(false);
					getGrafica().setNivel(getGrafica().getNivel());
					repaint();
				}
			}
			
			else if(e.getSource() == getBotonBorrar()) {
				getGrafica().setLimpiar(true);
				getGrafica().getVectorTiro().clear();
				getResultados().borrar();
				repaint();
			}
			
			else if(e.getSource() == getBotonPausar()) {
				getGrafica().pausar();
			}
			
			else if(e.getSource() == getBotonReanudar()) {
				getGrafica().reanudar();
			}
			
			else if(e.getSource() == getBotonLanzar()){
				double angulo = Double.parseDouble(getTextFieldAngulo().getText());
				double velocidad = Double.parseDouble(getTextFieldVelocidad().getText());
				if(angulo < 0 || angulo > 90)
					angulo = 45;
				getGrafica().anyadirTiro(angulo, velocidad);
				getGrafica().setNivel(0);
				getGrafica().setLimpiar(false);
				
				if(isDatos() == true){
					ponerDatos();
				}
				repaint();
			}
			
			
		}
	}
	
	private void ponerDatos(){
		getResultados().setTiempo(getGrafica().getVectorTiro().get(getGrafica().getVectorTiro().size() - 1).getTiempo());
		getResultados().setXFinal(getGrafica().getVectorTiro().get(getGrafica().getVectorTiro().size() - 1).getxFinal() - getGrafica().getPuntoXEje());
		getResultados().setYFinal(getGrafica().getVectorTiro().get(getGrafica().getVectorTiro().size() - 1).getyFinal());
		getResultados().setAceleracionX(getGrafica().getVectorTiro().get(getGrafica().getVectorTiro().size() - 1).getAceleracionX());
		getResultados().setAceleracionY(getGrafica().getVectorTiro().get(getGrafica().getVectorTiro().size() - 1).getAceleracionY());
		getResultados().setXInicial(getGrafica().getVectorTiro().get(getGrafica().getVectorTiro().size() - 1).getxInicial() - getGrafica().getPuntoXEje());
		getResultados().setYInicial(getGrafica().getVectorTiro().get(getGrafica().getVectorTiro().size() - 1).getyInicial());
		getResultados().setAlturaMax(getGrafica().getVectorTiro().get(getGrafica().getVectorTiro().size() - 1).getAlturaMaxima());
		getResultados().setAngulo(getGrafica().getVectorTiro().get(getGrafica().getVectorTiro().size() - 1).getAngulo());
		getResultados().setVelocidad(getGrafica().getVectorTiro().get(getGrafica().getVectorTiro().size() - 1).getVelocidadLanzamiento());
		getResultados().setVelocidadInicialX(getGrafica().getVectorTiro().get(getGrafica().getVectorTiro().size() - 1).getVelocidadInicialX());
		getResultados().setVelocidadInicialY(getGrafica().getVectorTiro().get(getGrafica().getVectorTiro().size() - 1).getVelocidadInicialY());
		getResultados().setVelocidadFinalX(getGrafica().getVectorTiro().get(getGrafica().getVectorTiro().size() - 1).getVelocidadFinalX());
		getResultados().setVelocidadFinalY(getGrafica().getVectorTiro().get(getGrafica().getVectorTiro().size() - 1).getVelocidadFinalY());
	}
	
	/*
	 * -------------------------------------- Getters y Setters ----------------------------------------------------------
	 */
	
	private JCheckBox getCheckBoxDatos(){
		return getPanel().getPanelCheckBox().getDatos();
	}
	
	private JCheckBox getCheckBoxRastro(){
		return getPanel().getPanelCheckBox().getRastro();
	}
	
	private JTextField getTextFieldVelocidad(){
		return getPanel().getPanelVelocidades().getCuadroVelocidad();
	}
	
	private JTextField getTextFieldAngulo(){
		return getPanel().getPanelAngulo().getCuadroAngulo();
	}
	
	
	private JButton getBotonLanzar(){
		return getPanel().getPanelBotones().getLanzar();
	}
	
	private JButton getBotonPausar(){
		return getPanel().getPanelBotones().getPausar();
	}
	
	private JButton getBotonReanudar(){
		return getPanel().getPanelBotones().getReanudar();
	}
	
	private JButton getBotonBorrar(){
		return getPanel().getPanelBotones().getBorrar();
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}
	public Grafica getGrafica() {
		return grafica;
	}
	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}

	public PanelResultados getResultados() {
		return resultados;
	}

	public void setResultados(PanelResultados resultados) {
		this.resultados = resultados;
	}

	public boolean isDatos() {
		return datos;
	}

	public void setDatos(boolean datos) {
		this.datos = datos;
	}

}
