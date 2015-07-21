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
			System.out.println("Cet employé n'exite pas");
		}
		
		return emp;
	}


	public Employe createEmploye(Employe employe) {
		
			em.persist(employe);

		return employe;
	}
	

	public Employe modifEmploye(Employe employe) {
		System.out.println("employe id : "+employe.getId());
		Employe emp = 	em.find(Employe.class, employe.getId());
		if(emp!=null){
			
			em.merge(employe);

		}else {System.out.println("Cet employé n'exite pas");}
		
		return emp;	
	}
	

	public void deleteEmploye(int id) {
		System.out.println("identifiant delete "+ id);
		Employe employe = 	em.find(Employe.class, id); 
		em.remove(employe);
		}
	}
	

