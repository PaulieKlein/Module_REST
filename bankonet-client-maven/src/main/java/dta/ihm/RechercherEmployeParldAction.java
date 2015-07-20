package dta.ihm;

import java.util.Scanner;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

public class RechercherEmployeParldAction implements Action {
	
	public  Integer getId(){
		return 2;
	}
	public  String getMenu(){
		return "Rechercher un employé par Id";
	}
	public void execute(){
		System.out.println("Veuillez saisir l'id de l'employé");
		Scanner sc = new Scanner(System.in);
		Integer id = sc.nextInt();
		
		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8090/BankonetREST/api/Employes/{id}");
		Invocation.Builder builder = target.resolveTemplate("id", id).request();
		Response response = builder.get();
		
		JSONObject jsonres = new JSONObject(response.readEntity(String.class));
		JSONObject adresse = new JSONObject(jsonres.get("adresse").toString());
		
		System.out.println("------------------------------Employé n° " + jsonres.get("id")+"------------------------------");
		System.out.println("| "+"Nom : " + jsonres.get("nom")+" | "+"Prénom : " + jsonres.get("prenom")+" |"
				+" Adresse : " + adresse.get("numero")+" " + adresse.get("rue")+" "+adresse.get("ville")+" |\n " );
	}
}
