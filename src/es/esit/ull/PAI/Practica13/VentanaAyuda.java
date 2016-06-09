/**
 * 
 */
package es.esit.ull.PAI.Practica13;

import javax.swing.JFrame;

/**
 * @author alu4487
 *
 */
public class VentanaAyuda extends JFrame{

	private final int ALTO_VENTANA = 300;
  private final int ANCHO_VENTANA = 400;
  private final String TITULO_VENTANA = "Ayuda";
  private Ayuda ayuda;
  
  public VentanaAyuda(){
  	ayuda = new Ayuda();
  	
  	setSize(getANCHO_VENTANA(), getALTO_VENTANA());
    setTitle(getTITULO_VENTANA());
    setLocationRelativeTo(null); 
    add(ayuda);
  }

	public int getALTO_VENTANA() {
		return ALTO_VENTANA;
	}

	public int getANCHO_VENTANA() {
		return ANCHO_VENTANA;
	}

	public String getTITULO_VENTANA() {
		return TITULO_VENTANA;
	}
  
}
