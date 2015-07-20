package dta.ihm;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListerEmployesAction implements Action {
	public  Integer getId(){
		return 1;
	}
	public  String getMenu(){
		return "Lister les employés";
	}
	public void execute(){
		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8090/BankonetREST/api/Employes");
		Invocation.Builder builder = target.request();
		
		Response response = builder.get();
		System.out.println("------------------La liste des employés------------------");
		
		if(response.getStatus() ==200){
			JSONArray jsonres = new JSONArray(response.readEntity(String.class));
			for(int i=0;i<jsonres.length();i++){
				JSONObject obj = new JSONObject(jsonres.get(i).toString());
				JSONObject adresse = new JSONObject(obj.get("adresse").toString());
				System.out.println("| ID : " + obj.get("id")+" | "+"Nom : " + obj.get("nom")+" | "+"Prénom : " + obj.get("prenom")+" |"
						+" Adresse : " + adresse.get("numero")+" " + adresse.get("rue")+" "+adresse.get("ville")+" | " );
				System.out.println("---------------------------------------------------------");
			}
		}
		System.out.println("\n");
	}
	 
}
