
package es.esit.ull.PAI.Practica11;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea un panel con todos los elementos que interactuaran con el usuario
 */
public class Panel extends JPanel{
	
	private PanelBotones panelBotones;
	private PanelCheckBox panelCheckBox;
	private PanelVelocidad panelVelocidades;
	private PanelAngulo panelAngulo;

	public Panel(){
		setLayout(new GridLayout(1, 4));
		
		panelAngulo = new PanelAngulo();
		panelVelocidades = new PanelVelocidad();
		panelBotones = new PanelBotones();
		panelCheckBox = new PanelCheckBox();
		
		add(panelBotones);
		add(panelVelocidades);
		add(panelAngulo);
		add(panelCheckBox);
	}
	
	/*
	 * -------------------------------------- Getters y Setters ----------------------------------------------------------
	 */

	public PanelBotones getPanelBotones() {
		return panelBotones;
	}

	public PanelVelocidad getPanelVelocidades() {
		return panelVelocidades;
	}

	public void setPanelVelocidades(PanelVelocidad panelVelocidades) {
		this.panelVelocidades = panelVelocidades;
	}

	public PanelAngulo getPanelAngulo() {
		return panelAngulo;
	}

	public void setPanelAngulo(PanelAngulo panelAngulo) {
		this.panelAngulo = panelAngulo;
	}

	public void setPanelBotones(PanelBotones panelBotones) {
		this.panelBotones = panelBotones;
	}

	public PanelCheckBox getPanelCheckBox() {
		return panelCheckBox;
	}

	public void setPanelCheckBox(PanelCheckBox panelCheckBox) {
		this.panelCheckBox = panelCheckBox;
	}
		
}
