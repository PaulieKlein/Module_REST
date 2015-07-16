package com.bankonet.console;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class EmployeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger.getLogger("").setLevel(Level.SEVERE);
		
		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8090");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*****BANKONET EMPLOYE*****");
		System.out.println("0.Arrêter le programme");
		System.out.println("1.Lister les employer");
		System.out.println("2.Rechercher un employé par id");
		System.out.println("Veuillez choisir une action : ");
		
		int choice;
		choice = sc.nextInt();
		
		switch(choice){
		case 0:
			System.out.println("Arrêt de l'application");
			System.exit(0);
		break;
		case 1:
			Invocation.Builder builder = target.path("api").path("Employes").request();
					
			Response response = builder.get();
			System.out.println(response);
		break;
		case 2:
			
			System.out.println("Indiquer l'id de l'employe que vous voulez :");
			int id;
			id = sc.nextInt();
			Invocation.Builder builder1 = target.path("api").path("Employes").queryParam("id",123).request();
			Response response1 = builder1.get();
			System.out.println(response1);
		break;
		}
	}

}
