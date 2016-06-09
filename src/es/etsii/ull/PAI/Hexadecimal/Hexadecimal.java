
package es.etsii.ull.PAI.Hexadecimal;

import java.awt.FlowLayout;
import javax.swing.*;

/**
 * @author Jorge
 *
 */
public class Hexadecimal extends JFrame {
	
	private int decimal;	// valor decimal al que pasaremos el numero hexadecimal

	public Hexadecimal(){
		
		setLayout (new FlowLayout(FlowLayout.LEFT, 10, 20)); 
		add(new JLabel("Numero hexadecimal para transferir: "));
		add(new JTextField(8));
		add(new JButton("Pasar a decimal"));
	
	}
	
	/**
	 * Transforma el numero en hexadecimal en un numero decimal
	 * @param cadena
	 * @throws HexFormatException
	 */
	public void hex2decimal(String cadena) throws HexFormatException{
		int numero = 0;
    //String digit = cadena.toUpperCase();
    for(int i = 0;i < cadena.length();i++)
    {
    	char c = cadena.charAt(cadena.length() - i - 1);
        if (c >= 'G' && c <= 'Z') {
        	throw new HexFormatException("ERROR: Numero hexadecimal erroneo \nRevisar el número Hexadecimal (Ej: A57B).");}
        
        if(c == 'A') {
            numero = 10;
        }
        if(c == 'B') {
        	numero = 11;
        }
        if(c == 'C') {
        	numero = 12;
        }
        if(c == 'D') {
        	numero = 13;
        }
        if(c == 'E') {
        	numero = 14;
        }
        if(c == 'F') {
        	numero = 15;
        } else {
        	numero = Character.getNumericValue(c);
        	
        }
        setDecimal((int) (getDecimal() + numero * Math.pow(16, i)));
    }
    System.out.println("El numero hexadecimal "+ cadena + " en decimal es " + getDecimal());
	}
	
	/**
	 * Devuelve el valor de decimal 
	 * @return
	 */
	public int getDecimal() {
		return decimal;
	}
	
	/**
	 * Introduce el valor de decimal, valor introducido por parametro
	 * @param decimal
	 */
	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}
	
}
