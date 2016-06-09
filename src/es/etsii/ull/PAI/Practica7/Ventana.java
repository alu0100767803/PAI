/**
 * 
 */
package es.etsii.ull.PAI.Practica7;

import javax.swing.JFrame;

/**
 * @author Jorge
 *
 */
public class Ventana extends JFrame{
	
	public Cuadratica cuadratica;
	public Cara cara;
	
	public Ventana(){
		setTitle("TestPaintComponent");
  	setSize(400, 300);
  	setLocationRelativeTo(null); // Center the frame   
  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	cuadratica = new Cuadratica();
  	add(cuadratica);
  	//cara = new Cara();
  	//add(cara);
  	//Escalera escalera = new Escalera();
  	//add(escalera);
  	//Espiral espiral = new Espiral();
  	//add(espiral);
  	setVisible(true);
  	
	}
}
