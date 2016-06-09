package es.etsii.ull.PAI.Serpiente;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha:
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: 
 */
public class Serpiente {
	
	private static int numSerpiente;
	private int idSerpiente;
	
	public Serpiente() {
		numSerpiente++;
    idSerpiente = numSerpiente;
	}
	
	public int getIdSerpiente() {
		return idSerpiente;
	}

	public void setIdSerpiente(int idSerpiente) {
		this.idSerpiente = idSerpiente;
	}

	public int getNumSerpiente() {
		return numSerpiente;
	}
	
	public int reptar(){
		return getIdSerpiente();
	}


}
