/**
 * 
 */
package es.esit.ull.PAI.Practica13;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author alu4487
 *
 */
public class Ayuda extends JPanel {
	
	private final String textoAyuda = " Introduzca un valor numérico entre 1 y 100 ";
	private JLabel mensajeAyuda;
	
	public Ayuda(){
		setLayout(new GridLayout(1, 1));
		mensajeAyuda = new JLabel(getTextoAyuda());
		
		add(mensajeAyuda);
	}

	public JLabel getMensajeAyuda() {
		return mensajeAyuda;
	}

	public void setMensajeAyuda(JLabel mensajeAyuda) {
		this.mensajeAyuda = mensajeAyuda;
	}

	public String getTextoAyuda() {
		return textoAyuda;
	}

	
}
