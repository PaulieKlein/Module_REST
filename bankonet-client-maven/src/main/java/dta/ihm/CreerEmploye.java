package dta.ihm;

import java.util.Scanner;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;

import dta.model.Adresse;
import dta.model.Employe;

public class CreerEmploye implements Action {
	
	public Integer getId(){
		return 3;
	}
	public String getMenu(){
		return "Créer un employé";
	}
	public void execute(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir les informations de l'employé : ");
		
		System.out.println("Nom : ");	
		String nom = sc.next();
		System.out.println("Prénom : ");	
		String prenom = sc.next();
		System.out.println("numero : ");	
		int numero = sc.nextInt();
		System.out.println("rue : ");	
		String rue = sc.next();
		System.out.println("ville : ");	
		String ville = sc.next();
		
		Adresse adresse = new Adresse(numero,rue,ville);
		Employe employe = new Employe(nom,prenom,adresse);
		
		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8090/BankonetREST/api/Employes");
		Invocation.Builder builder = target.request();
		Employe emp = builder.post(Entity.entity(employe, MediaType.APPLICATION_JSON),
				Employe.class);
	}

}
