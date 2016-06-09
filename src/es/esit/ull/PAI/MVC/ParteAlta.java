/**
 * 
 */
package es.esit.ull.PAI.MVC;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 13/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que contine la primera fila de la casilla
 */
public class ParteAlta extends JPanel {
	
	final private String EUROIS = "1 Euro is";
	
	public ParteAlta(Moneda moneda) {
		new JPanel();
		
		setLayout(new FlowLayout());	
    
		Color miColor = new Color(0, 0, 191);
		
    JLabel euro = new JLabel(EUROIS);
    euro.setForeground(miColor);
    JLabel cambio = new JLabel(moneda.getNOMBRE());
    cambio.setForeground(miColor);
    

    add(euro);
    add(new JTextField(String.valueOf(moneda.getFACTOR())));
    add(cambio);
	}

}
