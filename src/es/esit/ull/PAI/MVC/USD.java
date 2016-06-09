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
 * Comentario: Clase para el Dolar Estadounidense, hereda de la clase Moneda
 */
public class USD extends Moneda {
	
	private float usd;	// Valor en Dolares Estadounidenses
	final private float USD = 1.11f;	// Valor de 1 Euro en Dolares Estadounidenses 
	final private String NOMBRE = "US $";	// Nombre de la moneda
	
	public USD(float euros){
		super(euros);
		usd = eurosAUsd();
	}
	
	/**
	 * Metodo que convierte los Euros en Dolares Estadounidenses
	 * @return
	 */
	public float eurosAUsd(){
		return getEuros() * getFACTOR();
	}

	public float getValor() {
		return usd;
	}

	public void setValor(float usd) {
		this.usd = usd;
	}

	public float getFACTOR() {
		return USD;
	}
	
	public String getNOMBRE(){
		return NOMBRE;
	}

}
