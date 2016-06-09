/**
 * 
 */
package es.esit.ull.PAI.Practica10;

import javax.swing.JApplet;

/**
 * @author alu4487
 *
 */
public class Navegador extends JApplet{
	
	public Navegador(){
		//Ventana ventana = new Ventana();
		//ventana.setVisible(true);
		Controlador controlador = controlador = new Controlador(this.getWidth(), this.getHeight());
		add(controlador);
	}

}
