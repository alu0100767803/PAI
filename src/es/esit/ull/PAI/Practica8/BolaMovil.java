/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 09/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea un panel con la bola y los botones
 */
package es.esit.ull.PAI.Practica8;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BolaMovil extends JPanel {
	
	private Bola panelBola;														
	private Botones panelBotones;	
	
	public BolaMovil(int intervalo) {
		
		setLayout(new BorderLayout());
		
		panelBola = new Bola(intervalo);
		panelBotones = new Botones();
		panelBola.setBackground(Color.CYAN);
		
    add(panelBola, BorderLayout.CENTER);
    add(panelBotones, BorderLayout.SOUTH);
    
    getDer().addActionListener(new Oyente());
    getIzq().addActionListener(new Oyente());
    getArr().addActionListener(new Oyente());
    getAba().addActionListener(new Oyente());
   
	}
	
	
	
	public Bola getPanelBola() {
		return panelBola;
	}

	public void setPanelBola(Bola panelBola) {
		this.panelBola = panelBola;
	}

	public Botones getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(Botones panelBotones) {
		this.panelBotones = panelBotones;
	}
	
	private JButton getDer(){
		return getPanelBotones().getBotonDer();
	}
	
	private JButton getIzq(){
		return getPanelBotones().getBotonIzq();
	}
	
	private JButton getArr(){
		return getPanelBotones().getBotonArr();
	}
	
	private JButton getAba(){
		return getPanelBotones().getBotonAba();
	}
	
	class Oyente implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == getDer())
				getPanelBola().moverDer();
			else if(e.getSource() == getIzq())
				getPanelBola().moverIzq();
			else if(e.getSource() == getArr())
				getPanelBola().moverArr();
			else if(e.getSource() == getAba()){
				getPanelBola().moverAba();
			}
			
		}
		
	}

}
