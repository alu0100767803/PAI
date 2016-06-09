/**
 * 
 */
package es.esit.ull.PAI.Practica13;

import javax.swing.JFrame;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 12/05/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea la ventana donde se van a alojar los datos de usuario
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
   
   /*
 	 * -------------------------------------- Getters y Setters ----------------------------------------------------------
 	 */

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