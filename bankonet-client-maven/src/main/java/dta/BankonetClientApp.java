package dta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.reflections.Reflections;

import dta.ihm.Action;

public class BankonetClientApp {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Reflections reflections = new Reflections("dta.ihm");
		Set<Class<? extends Action>> actions =  reflections.getSubTypesOf(Action.class);
		
		List<Action> list = new ArrayList<Action>();
		
		Scanner sc = new Scanner(System.in);

		
		for (Class<? extends Action> classe : actions) {
			list.add(classe.newInstance());
		}
		
		Collections.sort(list,(a1,a2)->a1.getId().compareTo(a2.getId()));
		
		while(true) {
			System.out.println("*****BANKONET! CLIENT*****");
			for(Action action:list) {
				System.out.println(action.getId()+"."+action.getMenu());
			}
			System.out.println("\nChoisir une option");
			Integer saisie = sc.nextInt();
			
			Iterator it = list.iterator();
			
			while(it.hasNext()){
				Action action = (Action) it.next();
				if (action.getId() == saisie ){
					action.execute();
				}
			}
		}
		
		
	}

}
