package dta.ihm;

public class ArreterProgrammeAction implements Action {
	
	public  Integer getId(){
		return 0;
	}
	public  String getMenu(){
		return "Arr�ter le programme";
	}
	public void execute(){
		System.out.println("Le programme a �t� arr�t�");
		System.exit(0);
		
	}
}
