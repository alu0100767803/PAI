package es.etsii.ull.PAI.Ejercicio1;
import static java.lang.System.exit;
import static java.lang.Math.abs;


/**
 * @author Jorge Alonso Hernández
 * Clase que alberga un numero racional y capaz de ralizar operaciones basicas sobre esots :
 * suma, resta, mulriplicación y división
 */


public class Racional {
	
	private int numerador; 
	private int denominador; 
	private int mcd;  //contendra el valor del máxmo común divisor entre el numerador y el denominador

/**
 * Contructor del número racional con parámetros
 * @param num Valor del numerador del numero racional
 * @param den Valor del denominador del numero racional
 */
	public Racional(int num, int den){
	  if(den > 0){
	  	mcd = mcd(abs(num), abs(den));
	  	numerador = num / mcd;
	  	denominador = den / mcd;
	  }
	  else{
	    System.out.println("ERROR : Denominador menor o igual a cero");
	    exit(0);
	  }
	}

	/**
	 * Método que imprime el número Racional como un String
	 */
	public String toString(){
        return get_num() + "/" + get_den();
	}
	
	/**
	 * Método que suma dos números racionales
	 * @param rac Objeto Racional con el que se sumará el racional actual
	 * @return Racional, un objeto tipo Racional que albergará la suma de dos racionales
	 */
	public Racional suma(Racional rac){
		set_num(get_num() * rac.get_num() + get_den() * rac.get_den());
		set_den(get_den() * rac.get_den());
		
		set_mcd(mcd(abs(this.numerador), abs(this.denominador)));
		set_num(get_num() / get_mcd());
		set_den(get_den() / get_mcd());
		
		return this;
	}

	/**
	 * Método que resta dos números racionales
	 * @param rac Objeto Racional con el que se restará el racional actual
	 * @return Racional, un objeto tipo Racional que albergará la resta de dos racionales
	 */
	public Racional resta(Racional rac){
		set_num(-get_num());
	  this.suma(rac);
	  
	  return this;	
	}
	
	/**
	 * Método que multiplica dos números racionales
	 * @param rac Objeto Racional con el que se multiplicará el racional actual
	 * @return Racional, un objeto tipo Racional que albergará la multiplicación de dos racionales
	 */
	public Racional producto(Racional rac){
		set_num(get_num() * rac.get_num());
		set_den(get_den() * rac.get_den());
	  
		set_mcd(mcd(abs(this.numerador), abs(this.denominador)));
		set_num(get_num() / get_mcd());
		set_den(get_den() / get_mcd());
      
	  return this;
	}
	
	/**
	 * Método que divide dos números racionales 
	 * @param rac Objeto Racionsl con el que se dividirá el racional actual
	 * @return Racional, un objeto tipo Racional que albergará la división de dos racionales
	 */
	public Racional division(Racional rac){
	  int swap = 0;
	  swap = rac.get_num();
	  rac.set_num(rac.get_den());
	  rac.set_den(swap);
	  this.producto(rac);
	  
	  return this;
	}
	
	/**
	 * Método que devuelve el valor del numerador
	 * @return int, valor del numerador
	 */
	public int get_num(){
	  return numerador;
	}
	
	public void set_num(int num){
		numerador = num;
	}
	/**
	 * Método que devuelve el valor del denominador
	 * @return int, valor del denominador
	 */
	public int get_den(){
	  return denominador;  
	}
	
	public void set_den(int den){
		denominador = den;
	}
	
	/**
	 * Método que devuelve el valor del máximo común divisor
	 * @param val1 Primer elemento para aplicar el máximo común divisor
	 * @param val2 Segundo elemento para aplicar el máximo común divisor
	 * @return int, valor del maximo comun divisor
	 */
    public int mcd(int val1, int val2) {
      if(val2 == 0)
        return val1;
      else
        return mcd(val2, val1 % val2);
    } 
    
  	private int get_mcd() {
  		return mcd;
  }
  	
  	private void set_mcd(int mcd) {
  		this.mcd = mcd; 
  		
  	}

}
