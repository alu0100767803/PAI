/**
 * 
 */
package es.etsii.ull.PAI.HTML;

import java.awt.GridLayout;
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 08/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que transfiere un fichero .java en otro .html
 */
public class HTML extends JFrame {
	
  private final String ENCABEZADO = "<!DOCTYPE html>";
  private final String HEAD = "<head>";
  private final String FIN_HEAD = "</head>";
  private final String HTML = "<html>";
  private final String FIN_HTML = "</html>";
  private final String FORMATO = "<meta charset=\"utf-8\">";
  private final String BODY = "<body>";
  private final String FIN_BODY = "</body>";
  private final String TITTLE = "<title>";
  private final String FIN_TITTLE= "</title>";
  private final String COMENTARIO_LARGO = "/*";
  private final String FIN_COMENTARIO_LARGO = "*/";
  private final String COMENTARIO_Linea = "//";
  private final String CADENA_LITERAL = "\"";
  private final String COLOR_RESERVADAS = "<font color=\"BLACK\">";
  private final String COLOR_COMENTARIO = "<font color=\"GREEN\">";
  private final String COLOR_LITERALES = "<font color=\"BLUE\">";
  private final String FIN_COLOR_RESERVADAS = "</font>";
  private final String FIN_COLOR_COMENTARIO = "</font>";
  private final String FIN_COLOR_LITERALES = "</font>";
  private final String CODIGO = "<code>";
  private final String FIN_CODIGO = "</code>";
  private final String PARRAFO = "<p>";
  private final String FIN_PARRAFO = "</p>";
  private final String H1 = "<h1>";
  private final String FIN_H1 = "</h1>";
  private final String BR = "<br>";
  private final String FIN_BR = "</br>";
  private final String PRE = "<pre>";
  private final String FIN_PRE = "</pre>";
  private final String TAB = "&nbsp;&nbsp;&nbsp;";
  private final String[] RESERVADAS = {"abstract", "double", "int", "strictfp", 
      "boolean", "else", "interface", "super", "break", "extends", "long", 
      "switch", "byte", "final", "native", "synchronized", "case", "finally", 
      "new", "this", "catch", "float", "package", "throw", "char", "for", 
      "private", "throws", "class", "goto", "protected", "transient", "const", 
      "if", "public", "try", "continue", "implements", "return", "void", 
      "default", "import", "short", "volatile", "do", "instanceof", "static", 
  "while"};
  
  public HTML(String lectura, String html) throws IOException{
  	
  	setLayout (new GridLayout(3 , 2 , 5 , 5));
  	add(new JLabel("Fichero .java a transferir"));
  	add(new JTextField(".java"));
  	add(new JLabel("Fichero .html donde transferir"));
  	add(new JTextField(".html"));
  	add(new JButton("Transferir"));
  	
  	File fichero = new File(lectura);
    Scanner s = null;
    
    FileWriter fSalida = new FileWriter(html);
    
    fSalida.write(getENCABEZADO());
    fSalida.write(getHTML());
    fSalida.write(getHEAD());
    fSalida.write(getFORMATO());
    fSalida.write(getTITTLE());
    fSalida.write(getFIN_TITTLE());
    fSalida.write(getFIN_HEAD());
    fSalida.write(getBODY());
    fSalida.write(getH1());
    fSalida.write(getFIN_H1());
    fSalida.write(getPARRAFO());
    fSalida.write(getPRE());
    
    //Iterator<String>  iterador = getRESERVADAS().iterator();
    s = new Scanner(fichero);
    while (s.hasNextLine()) {
      String linea = s.nextLine();
      System.out.println(linea);
      fSalida.write(getBR());
      
      
      
      fSalida.write(linea);
      fSalida.write(getFIN_BR());
    }
    
    fSalida.write(getFIN_PRE());
    fSalida.write(getFIN_PARRAFO());
    fSalida.write(getFIN_BODY());
    fSalida.write(getFIN_HTML());
    fSalida.close();
  	
  }



	public String getENCABEZADO() {
		return ENCABEZADO;
	}
	public String getHEAD() {
		return HEAD;
	}
	public String getFIN_HEAD() {
		return FIN_HEAD;
	}
	public String getHTML() {
		return HTML;
	}
	public String getFIN_HTML() {
		return FIN_HTML;
	}
	public String getFORMATO() {
		return FORMATO;
	}
	public String getBODY() {
		return BODY;
	}
	public String getFIN_BODY() {
		return FIN_BODY;
	}
	public String getTITTLE() {
		return TITTLE;
	}
	public String getFIN_TITTLE() {
		return FIN_TITTLE;
	}
	public String getCOMENTARIO_LARGO() {
		return COMENTARIO_LARGO;
	}
	public String getFIN_COMENTARIO_LARGO() {
		return FIN_COMENTARIO_LARGO;
	}
	public String getCOMENTARIO_Linea() {
		return COMENTARIO_Linea;
	}
	public String getCADENA_LITERAL() {
		return CADENA_LITERAL;
	}
	public String getCOLOR_RESERVADAS() {
		return COLOR_RESERVADAS;
	}
	public String getCOLOR_COMENTARIO() {
		return COLOR_COMENTARIO;
	}
	public String getCOLOR_LITERALES() {
		return COLOR_LITERALES;
	}
	public String getFIN_COLOR_RESERVADAS() {
		return FIN_COLOR_RESERVADAS;
	}
	public String getFIN_COLOR_COMENTARIO() {
		return FIN_COLOR_COMENTARIO;
	}
	public String getFIN_COLOR_LITERALES() {
		return FIN_COLOR_LITERALES;
	}
	public String getCODIGO() {
		return CODIGO;
	}
	public String getFIN_CODIGO() {
		return FIN_CODIGO;
	}
	public String getPARRAFO() {
		return PARRAFO;
	}
	public String getFIN_PARRAFO() {
		return FIN_PARRAFO;
	}
	public String getH1() {
		return H1;
	}
	public String getFIN_H1() {
		return FIN_H1;
	}
	public String getBR() {
		return BR;
	}
	public String getFIN_BR() {
		return FIN_BR;
	}
	public String getPRE() {
		return PRE;
	}
	public String getFIN_PRE() {
		return FIN_PRE;
	}
	public String getTAB() {
		return TAB;
	}
	public String[] getRESERVADAS() {
		return RESERVADAS;
	}
  
  

}
