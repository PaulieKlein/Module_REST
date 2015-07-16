package com.bankonet.model;


import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

	@Entity 
	public class Employe  implements Serializable {

	@Id @GeneratedValue
	private int id;
	private String nom;
	private String prenom;

	

	@Embedded
	  private Adresse adresse;

	  public Employe(){}
	  
	  public Employe(String nom,String prenom, Adresse adresse){
		  this.nom = nom;
		  this.prenom = nom;
		  this.adresse = adresse;
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

