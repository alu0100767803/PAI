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
 * Comentario: Clase para los Euros de la que heredan el resto de monedas
 */
public class Moneda {
	
	private float euros;	// Valor en Euros

	public Moneda(float euros){
		this.euros = euros;
	}
	
	public float getEuros() {
		return euros;
	}

	public void setEuros(float euros) {
		this.euros = euros;
	}

	public float getValor() {
		return 0.0f;
	}
	
	public void setValor(float valor){
		
	}
	
	public String getNOMBRE() {
		return null;
	}
	
	public float getFACTOR() {
		return 0.0f;
	}

}
