package dta.model;


import java.io.Serializable;
import java.lang.String;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
	public class Employe{


	private int id;
	private String nom;
	private String prenom;
	private Adresse adresse;

	public Employe(){}
	  
	  public Employe(String nom,String prenom,Adresse adresse){
		  this.nom = nom;
		  this.prenom = prenom;
		  this.adresse = adresse;
	  }
	  
	  @Override
		public String toString() {
			return String.format("Employe [id=%d, nom=%s, prenom=%s,Adresse=%o ]", id, nom,
					prenom,adresse);
		}

	  public Adresse getAdresse() {
			return adresse;
		}

		public void setAdresse(Adresse adresse) {
			this.adresse = adresse;
		}
	public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public int getId() {
			return id;
		}
		
		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
	}

