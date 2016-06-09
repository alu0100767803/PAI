/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 09/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea un panel con los botones
 */
package es.esit.ull.PAI.Practica8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Botones extends JPanel {

	private JButton botonIzq;
	private JButton botonDer;
	private JButton botonArr;
	private JButton botonAba;
	
	public Botones(){
		
		setLayout(new GridLayout(3,1));
		botonIzq = new JButton("Izquierda");
		botonDer = new JButton("Derecha");
		botonArr = new JButton("Arriba");
		botonAba = new JButton("Abajo");
		
		JPanel arriba = new JPanel();

    JPanel abajo = new JPanel();

    JPanel centro = new JPanel();
		
		botonIzq.setName("botonIzq");
		botonDer.setName("botonDer");
		botonArr.setName("botonArr");
		botonAba.setName("botonAba");
		
		centro.add(botonIzq);
    centro.add(botonDer);
    arriba.add(botonArr);
    abajo.add(botonAba);
    
    add(arriba);
    add(centro);
    add(abajo);
		
	}

	public JButton getBotonIzq() {
		return botonIzq;
	}

	public void setBotonIzq(JButton botonIzq) {
		this.botonIzq = botonIzq;
	}

	public JButton getBotonDer() {
		return botonDer;
	}

	public void setBotonDer(JButton botonDer) {
		this.botonDer = botonDer;
	}

	public JButton getBotonArr() {
		return botonArr;
	}

	public void setBotonArr(JButton botonArr) {
		this.botonArr = botonArr;
	}

	public JButton getBotonAba() {
		return botonAba;
	}

	public void setBotonAba(JButton botonAba) {
		this.botonAba = botonAba;
	}

	
}
