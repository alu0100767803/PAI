/**
 * 
 */
package es.esit.ull.PAI.OchoReinas;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 26/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea la ventana del tablero
 */
public class Frame extends JFrame {
	final private int TAMANYO = 8;
	final private int ANCHO = 400;
	final private int ALTO = 700;
	Clock reloj;
	
	public Frame() throws Exception{
		
		setTitle("Problema de las ocho reinas");
    setSize(getANCHO(), getALTO());
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new GridLayout(2, 1));
    
    reloj = new Clock();
    reloj.start();
    OchoReinas ochoReinas = new OchoReinas(getTAMANYO()); 
    Tablero tablero = new Tablero(getTAMANYO(), ochoReinas);
    add(tablero);
    reloj.stop();
    JLabel tiempo = new JLabel("Tiempo de ejecucion = " + reloj.eslapsedTime());
    add(tiempo);
    setVisible(true);
	}

	public int getTAMANYO() {
		return TAMANYO;
	}

	public int getANCHO() {
		return ANCHO;
	}

	public int getALTO() {
		return ALTO;
	}

}
