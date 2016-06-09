/**
 * 
 */
package es.esit.ull.PAI.Practica12;

import javax.swing.JFrame;

/**
 * @author Jorge
 *
 */
public class VentanaDatos extends JFrame {

  private final int ALTO_VENTANA = 300;
  private final int ANCHO_VENTANA = 400;
  private final String TITULO_VENTANA = "Datos";

  private Datos datos;

   public VentanaDatos() {
  	 datos = new Datos();
     setSize(getANCHO_VENTANA(), getALTO_VENTANA());
     setTitle(getTITULO_VENTANA());
     setLocationRelativeTo(null);  
     add(datos);
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