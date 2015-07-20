package dta.model;


import java.lang.String;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Adresse{

  private int numero;
  private String rue;
  private String ville;

  public Adresse(){}
  
  public Adresse(int numero, String rue,String ville){
	  this.numero = numero;
	  this.rue = rue;
	  this.ville = ville;
  }
  
  @Override
	public String toString() {
		return String.format("Adresse [numero=%i, rue=%s, ville=%s ]", numero,rue,ville);
	}
  
  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getRue() {
    return rue;
  }

  public void setRue(String rue) {
    this.rue = rue;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

}
