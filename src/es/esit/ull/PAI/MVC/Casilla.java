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
 * Comentario: Clase que implementa una casilla de la ventana
 */
public class Casilla extends JPanel {
	
	public Casilla(Moneda moneda) {
		
		new JPanel();
		setLayout(new GridLayout(2,1));
		
		Color miColor = new Color(0, 0, 191);	// Color Azul con rgb
		
		Border bordejpanel = new TitledBorder(new EtchedBorder(), moneda.getNOMBRE());
    setBorder(bordejpanel); 
    ((TitledBorder) bordejpanel).setTitleColor(miColor);
		
		ParteAlta alto = new ParteAlta(moneda);	
		add(alto);
		ParteBaja bajo = new ParteBaja(moneda);
		add(bajo);
    

		
	}

}
