/**
 * 
 */
package es.esit.ull.PAI.Practica12;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class Datos extends JPanel{

  private final String AUTOR = "Autor: Jorge Alonso Hernandez";
  private final String CORREO = "Correo: alu0100767803@ull.edu.es";
  private final String ASIGNATURA = "Programación de Aplicaciones Interactivas";
  private final String PRACTICA = "Practica 12: Un juego de disparo de bolas";
  private final String UNIVERSIDAD = "Universidad de La Laguna";
  private final String FACULTAD = "Escuela Superior de Ingeniería y Tecnología";
  private final String CURSO = "3º - Itinerario de computación 2015/16";

  private JLabel autor;
  private JLabel correo;
  private JLabel asignatura;
  private JLabel practica;
  private JLabel curso;
  private JLabel universidad;
  private JLabel facultad;

  public Datos(){

  	setLayout(new GridLayout(10, 1));

  	autor = new JLabel(getAUTOR());
    correo = new JLabel(getCORREO());
    asignatura = new JLabel(getASIGNATURA());
    practica = new JLabel(getPRACTICA());
    curso = new JLabel(getCURSO());
    facultad = new JLabel(getFACULTAD());
    universidad = new JLabel(getUNIVERSIDAD());
    
    

    add(autor);
    add(correo);
    add(practica);
    add(asignatura);
    add(curso);
    add(facultad);
    add(universidad);

  }

  public JLabel getAutor() {
  	return autor;
  }

  public void setAutor(JLabel autor) {
  	this.autor = autor;
  }

  public JLabel getCorreo() {
  	return correo;
  }

  public void setCorreo(JLabel correo) {
  	this.correo = correo;
  }

  public JLabel getAsignatura() {
  	return asignatura;
  }

  public void setAsignatura(JLabel asignatura) {
  	this.asignatura = asignatura;
  }

  public JLabel getPractica() {
  	return practica;
  }

  public void setPractica(JLabel practica) {
  		this.practica = practica;
  }

  public String getAUTOR() {
  	return AUTOR;
  }

  public String getCORREO() {
  	return CORREO;
  }

  public String getASIGNATURA() {
  	return ASIGNATURA;
  }

  public String getPRACTICA() {
  	return PRACTICA;
  }

	public JLabel getUniversidad() {
		return universidad;
	}

	public void setUniversidad(JLabel universidad) {
		this.universidad = universidad;
	}

	public JLabel getFacultad() {
		return facultad;
	}

	public void setFacultad(JLabel facultad) {
		this.facultad = facultad;
	}

	public String getUNIVERSIDAD() {
		return UNIVERSIDAD;
	}

	public String getFACULTAD() {
		return FACULTAD;
	}

	public JLabel getCurso() {
		return curso;
	}

	public void setCurso(JLabel curso) {
		this.curso = curso;
	}

	public String getCURSO() {
		return CURSO;
	}



}