/**
 * 
 */
package es.esit.ull.PAI.MVC;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 13/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase para el Marco Alemán, hereda de la clase Moneda
 */
public class DM extends Moneda{
	
	private float dm;	// Valor en Marcos Alemanes
	final private float DM = 1.96f;	// Valor de 1 Euro en Marcos Alemanes
	final private String NOMBRE = "DM";	// Nombre de la moneda
	
	public DM(float euros){
		super(euros);
		dm = eurosADm();	
	}

	/**
	 * Metodo que convierte los Euros en Marcos Alemanes
	 * @return
	 */
	public float eurosADm(){
		return getEuros() * getFACTOR();
	}

	public float getValor() {
		return dm;
	}

	public void setValor(float dm) {
		this.dm = dm;
	}
	
	public float getFACTOR() {
		return DM;
	}
	
	public String getNOMBRE(){
		return NOMBRE;
	}

}
