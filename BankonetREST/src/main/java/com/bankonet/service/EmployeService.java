package com.bankonet.service;
import com.bankonet.model.*;
import com.bankonet.jaxrs.*;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;


@Stateless
public class EmployeService {

	@PersistenceContext(unitName="Employes")private EntityManager em;
	

	public List<Employe> findAll() {
		List<Employe> employes = new ArrayList<Employe>();
		try{
		      String texteQuery1 = "Select e From Employe as e";
		      Query query1 = em.createQuery(texteQuery1);
		      employes = (List<Employe>) query1.getResultList();
		     
	  	} catch(Exception e){
	  		e.printStackTrace();
	  		
	  		
	  	} 
		return employes;

	}

	public Employe employeId(int id) {
		Employe emp = new Employe();
		
		Employe e = em.find(Employe.class, id);
		if(e!=null){
			
			return e;
		}
		else {
			System.out.println("Cet employe n'exite pas");
		}
		
		return emp;
	}


	public Employe createEmploye(Employe employe) {
		
			em.persist(employe);

		return employe;
	}
	

	public Employe modifEmploye(int id,String nom, String prenom,int num,String rue,String ville) {
		
		Adresse adresse = new Adresse();
		
		Employe employe = 	em.find(Employe.class, id);
		if(employe!=null){
			
			adresse.setNumero(num);
			adresse.setRue(rue);
			adresse.setVille(ville);
			employe.setNom(nom);
			employe.setNom(nom);
			employe.setPrenom(prenom);
			employe.setAdresse(adresse);
			em.persist(employe);
		

		}else {System.out.println("Cet employe n'exite pas");}
		
		return employe;	
	}
	

	public void deleteEmploye(int id) {
	      String texteQuery1 = "Delete e From Employe as e where e.id =:id ";
	      Query query1 = em.createQuery(texteQuery1);
	      query1.setParameter("id", id);
		}
	}
	

