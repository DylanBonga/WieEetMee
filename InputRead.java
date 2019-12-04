
public class InputRead {
	/* functie is deels dubbelop doordat de Session-class al een error geeft in geval van verkeerde input.
	 * Desalniettemin is deze functie handig wanneer het programma wordt uitgebreid. 
	 */
	public int IntReader(String input){
		// wist spaties voor en na input, zodat dit niet tot een crash leidt. 
		
		String input_trim = input.trim(); 
		if(input_trim.length() == 1){
			// returned alleen eerste int in command
			char first_c = input_trim.charAt(0);
			int num = Character.getNumericValue(first_c);
			return num;
		}else{
			// als de user op enter drukt, is er geen input. Hierdoor geen problemen met maken van arrays.
			System.out.println("ERROR: invalid input.");
			return 0;
			
		}
	}
	
	public String StrReader(String input){
		// delete leading and tailing spaces, gives cleaner output
		String input_trim = input.trim();
		if(input_trim.length() < 1){
			// checks for input
			System.out.println("ERROR: no input registered.");
			return "-empty-";
		}else{
			return input_trim;
		}
	}	
}
