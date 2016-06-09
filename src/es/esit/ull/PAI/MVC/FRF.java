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
 * Comentario: Clase para el Franco Francés, hereda de la clase Moneda
 */
public class FRF extends Moneda {
	
	private float frf;	// Valor en Francos Franceses
	final private float FRF = 6.56f;	// Valor de 1 Euro en Francos Franceses
	final private String NOMBRE = "Franz. Franc";	// Nombre de la moneda
	
	public FRF(float euros){
		super(euros);
		frf = eurosAFrf();
	}
	
	/**
	 * Metodo que convierte los Euros en Francos Franceses
	 * @return
	 */
	public float eurosAFrf(){
		return getEuros() * getFACTOR();
	}

	public float getValor() {
		return frf;
	}

	public void setValor(float frf) {
		this.frf = frf;
	}
	
	public float getFACTOR() {
		return FRF;
	}
	
	public String getNOMBRE(){
		return NOMBRE;
	}


}
