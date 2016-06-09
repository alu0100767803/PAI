/**
 * 
 */
package es.etsii.ull.PAI.Suma;

import java.awt.GridLayout;

import javax.swing.*;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 08/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase suma que recibe dos numero y obtiene la suma de los mismos
 */
public class Suma extends JFrame {
	
	private int sumando1;	// Sumando 1
	private int sumando2;	// Sumando 2
	private int suma;	// Resultado de la suma
	
	public Suma(int sum1, int sum2) {
		setSumando1(sum1);
		setSumando2(sum2);
		setSuma(0);
		
		setLayout (new GridLayout(3 , 2 , 5 , 5)); 
		add(new JLabel("Sumando1: "));
		add(new JTextField(8));
		add(new JLabel("Sumando2: "));
		add(new JTextField(8));
		add(new JButton("Suma"));
	}
	
	public void suma(){
		setSuma(getSumando1() + getSumando2());
	}

	public int getSumando1() {
		return sumando1;
	}

	public void setSumando1(int sumando1) {
		this.sumando1 = sumando1;
	}

	public int getSumando2() {
		return sumando2;
	}

	public void setSumando2(int sumando2) {
		this.sumando2 = sumando2;
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}

}
