/**
 * 
 */
package es.esit.ull.PAI.MVC;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 13/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que contiene las dos últimas filas de la casilla
 */
public class ParteBaja extends JPanel{
	
	final private String EUROS = "Euros";
	
	public ParteBaja(Moneda moneda) {
		
		setLayout(new GridLayout(2, 2, 1, 1));	
		
		Color miColor = new Color(0, 0, 191);
		
		JLabel labelEuros = new JLabel(EUROS);
    labelEuros.setForeground(miColor);
    JLabel labelCambio = new JLabel(moneda.getNOMBRE());
    labelCambio.setForeground(miColor);


    add(labelEuros);
    add(labelCambio);
    add(new JTextField(String.valueOf(moneda.getEuros())));
    add(new JTextField(String.valueOf(new DecimalFormat("#.##").format(moneda.getValor()))));

    
	}

}
