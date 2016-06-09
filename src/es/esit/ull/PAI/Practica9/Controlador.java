/**
 * @author Jorge Alonso Hernández
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 17/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que controla la cuadricula y los botones
 */
package es.esit.ull.PAI.Practica9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Controlador extends JPanel{
	
	private Cuadricula cuadricula;							// panel con la cuadricula y el camino
	private Panel panel;								// panel con los botones
	
	public Controlador(){
		cuadricula = new Cuadricula();
		panel = new Panel();
		
		new JPanel();
		
		setLayout(new BorderLayout());
		
		add(cuadricula, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		getDensidad().addActionListener(new Oyente());
		getBotonColor().addActionListener(new Oyente());
		getBotonEmpezar().addActionListener(new Oyente());
		getBotonFinalizar().addActionListener(new Oyente());
		getBotonTodo().addActionListener(new Oyente());
		getBotonPausar().addActionListener(new Oyente());
		getBotonReanudar().addActionListener(new Oyente());
		getBotonPausar().addActionListener(new Oyente());
		getBotonPaso().addActionListener(new Oyente());
	}
	
	class Oyente implements ActionListener {													
		public void actionPerformed(ActionEvent e) {
			//
			if(e.getSource() == getBotonColor()){
				getCuadricula().colorAleatorio();
				getCuadricula().setCambiarColor(true);
				repaint();
			}			
			//
			else if(e.getSource() == getBotonTodo()){
				getCuadricula().setPintarPasoPaso(false);
				repaint();
			}
			//
			else if(e.getSource() == getDensidad()){
				if(Integer.parseInt(getDensidad().getText()) > 1){
					getCuadricula().setDensidad(Integer.parseInt(getDensidad().getText()));
					getCuadricula().borrar();
					getCuadricula().setPintarCamino(false);
					repaint();
				}
			}
			//
			else if(e.getSource() == getBotonEmpezar()){
				getCuadricula().calcularCamino();
				getCuadricula().setNivel(0);
				getCuadricula().setPintarPasoPaso(true);
				getCuadricula().setPintarCamino(true);
				getCuadricula().empezar();
				repaint();
			}
			//
			else if(e.getSource() == getBotonFinalizar()){
				getCuadricula().setPintarCamino(false);
				getCuadricula().borrar();
				repaint();
			}
			
			//
			else if(e.getSource() == getBotonPausar()){
				getCuadricula().pausar();
				repaint();
			}
			
			//
			else if(e.getSource() == getBotonReanudar()){
				getCuadricula().reanudar();
				repaint();
			}
			
			//
			else if(e.getSource() == getBotonPaso()){
				getCuadricula().pausar();
				getCuadricula().setNivel(getCuadricula().getNivel() + 1);
				repaint();
			}
			
		}
			
	}
	
	public JButton getBotonPaso(){
		return getPanel().getPanelBotones().getPaso();
	}
	
	public JButton getBotonPausar(){
		return getPanel().getPanelBotones().getPausar();
	}
	
	public JButton getBotonReanudar(){
		return getPanel().getPanelBotones().getReanudar();
	}
	
	public JButton getBotonTodo(){
		return getPanel().getPanelBotones().getTodo();
	}
	
	public Cuadricula getCuadricula() {
		return cuadricula;
	}

	public void setCuadricula(Cuadricula cuadricula) {
		this.cuadricula = cuadricula;
	}
	
	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	
	
	private JButton getBotonEmpezar(){
		return getPanel().getPanelBotones().getEmpezar();
	}
	
	private JButton getBotonFinalizar(){
		return getPanel().getPanelBotones().getFinalizar();
	}
	
	private JButton getBotonColor(){
		return getPanel().getColor();
	}
	
	private JTextField getDensidad(){
		return getPanel().getDensidad();
	}

}
