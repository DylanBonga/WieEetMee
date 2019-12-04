
public class Maaltijd {
	String[] deelnemers = new String[15];
	int aantal_deelnemers = 0;
	//max deelnemers = grootte woonkamer
	
	public String[] Maal(String titel, String kooktijd, String eettijd, String chef){
		// dit returned een array voor één maaltijd
		System.out.printf("Wat: %s, hoe lang: %s minuten, hoe laat: %s\n", titel, kooktijd, eettijd);
		String[] myStrings = {titel, kooktijd, eettijd, chef};
		return myStrings;
	}
	
	public void inschr(String i_naam) {
		// voegt deelnemer toe aan lijst met deelnemers
		deelnemers[aantal_deelnemers] = i_naam;
		aantal_deelnemers += 1;
		System.out.println("Inschrijven..");	
	}
	
	public String chef(){
		// returned naam van degene die kookt
		return deelnemers[0];
	}
	
	public int aant_del(){
		// returned aantal deelnemers
		return aantal_deelnemers;
	}
	
	public void dn_lijst() {
		// print een lijst van alle deelnemers 
		int el;
		for(el = 0; el < deelnemers.length; el++) {
			if(deelnemers[el] != null) { // omdat java geen dynamische arrays toelaat, print alleen de gevulde entries
				System.out.println("- "+deelnemers[el]);
			}
		}	
	}
}
