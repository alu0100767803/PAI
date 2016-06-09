/**
 * 
 */
package es.etsii.ull.PAI.Hexadecimal;

import javax.swing.JFrame;

/**
 * @author Jorge
 *
 */
public class MainHexadecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws HexFormatException {
		final int ANCHO = 300;
		final int ALTO = 200;
		
		Hexadecimal frame = new Hexadecimal();
		
		frame.setTitle("Hexadecimal");
		frame.setSize(ANCHO, ALTO);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.hex2decimal(args[0]);
		
		

	}

}
