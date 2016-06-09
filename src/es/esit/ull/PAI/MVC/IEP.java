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
 * Comentario: Clase para la Libra Irlandesa, hereda de la clase Moneda
 */
public class IEP extends Moneda{
	
	private float iep;	// Valor en Libras Irlandesas
	final private float IEP = 0.79f;	// Valor de 1 Euro en Libras Irlandesas
	final private String NOMBRE = "Ir. Pfund";	// Nombre de la moneda
	
	public IEP(float euros) {
		super(euros);
		iep = eurosAIep();
	}
	
	/**
	 * Metodo que convierte los Euros en Libras Irlandesas
	 * @return
	 */
	public float eurosAIep() {
		return getEuros() * getFACTOR();
	}
	
	public float getValor() {
		return iep;
	}
	public void setValor(float iep) {
		this.iep = iep;
	}
	public float getFACTOR() {
		return IEP;
	}
	
	public String getNOMBRE() {
		return NOMBRE;
	}
	
	

}
