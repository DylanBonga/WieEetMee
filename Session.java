import java.util.Scanner;
import java.util.Arrays;

public class Session {
	
	public void StartSession(){
		// creëert maaltijd objecten en assigned deze aan variabelen
		Maaltijd m1 = new Maaltijd();
		Maaltijd m2 = new Maaltijd();
		Maaltijd m3 = new Maaltijd();
		
		// booleans maken logische tests (rond regel 60) cleaner 
		boolean m1_f = false;
		boolean m2_f = false;
		boolean m3_f = false;
		
		// creëert tweedimensionale array om maaltijden op te slaan
		String[][] maaltijdarr = new String[3][4];
		
		// for-loop vult Strings in array met "" 
		int str = 0;
		for(str = 0; str < maaltijdarr.length; str++){
			Arrays.fill(maaltijdarr[str], ""); 
		}
		
		InputRead read = new InputRead(); 
		
		// Scanner wordt gebruikt voor user-input
		Scanner scan = new Scanner(System.in);

		boolean sess = true; 
		// while loop simuleert hier een lopende sessie 
		while(sess == true){
			System.out.println("@-------------------------@");
			System.out.println("    Eet je mee vandaag? \n");
			System.out.println("---------------------------");
			System.out.println("[1] koken\n[2] maaltijden\n[3] uitleg\n[4] quit");
			/*
			 scan.nextLine() wordt overal gebruikt, omdat verschillende methodes van Scanner door elkaar 
			 gebruiken leidt tot errors die zo makkelijker te omzeilen zijn. Nadeel: hierdoor moet input 
			 soms worden omgevormd. 
			*/
			String inn = scan.nextLine();     
			try{
				int s = read.IntReader(inn); 
				// optie 1 laat een chef een maaltijd aanmaken
				if(s == 1){
					System.out.print("> Wie is de chef? ");
					String che = scan.nextLine();
					String chef = read.StrReader(che);
					
					System.out.print("> Wat wil je maken? ");
					String mm = scan.nextLine();
					String m = read.StrReader(mm);
		
					System.out.print("> Hoeveel minuten duurt dat? ");
					String kk = scan.nextLine(); 
					String k = read.StrReader(kk);
					
					System.out.print("> Hoe laat aan tafel? ");
					String tt = scan.nextLine();
					String t = read.StrReader(tt);
					
					// check for empty input 
					if(chef == "-empty-" || m == "-empty-" || k == "-empty-" || t == "-empty-"){
					System.out.println("ERROR: Please fill in all fields");
					}else{
						// start met check of er plek is, anders moeten eerst alle velden ingevuld worden voor de error. 
						if(m1_f == true && m2_f == true && m3_f == true){
							System.out.println("All slots are full.");
						}
						// maakt de maaltijd aan, stored deze in de 2D-array en schrijft chef in als deelnemer (want die eet ook mee!)
						if(m1_f == false){
							String[] y = new String[1];
							y = (m1.Maal(m, k, t, chef));
							int x = 0;
							for(x = 0; x < y.length; x++){
								maaltijdarr[0][x] = y[x];
							}
							m1.inschr(chef);
							m1_f = true;
							System.out.printf("\nMaaltijd %s staat vast!\n", maaltijdarr[0][0]);
						}else if(m1_f == true && m2_f == false){
							String[] y = new String[1];
							y = (m2.Maal(m, k, t, chef));
							int x = 0;
							for(x = 0; x < y.length; x++){
								maaltijdarr[1][x] = y[x];
							}
							m2.inschr(chef);
							m2_f = true;
							System.out.printf("\nMaaltijd %s staat vast!\n", maaltijdarr[1][0]);
						}else if(m1_f == true && m2_f == true && m3_f == false){
							String[] y = new String[1];
							y = (m3.Maal(m, k, t, chef));
							int x = 0;
							for(x = 0; x < y.length; x++){
								maaltijdarr[2][x] = y[x];
							}
							m3.inschr(chef);
							m3_f = true; 
							System.out.printf("\nMaaltijd %s staat vast!\n", maaltijdarr[2][0]);
						}
					}
				
				// optie 2 laat gebruikers de aangemaakte maaltijden bekijken en zich daarop inschrijven
				}else if(s == 2){
					// checkt of er minimaal 1 maaltijd aangemaakt is 
					// somt dan de bestaande maaltijden op 
					if(m1_f == true){
					System.out.println("Welke maaltijd wil je bekijken?");
					
					System.out.println("[1] "+ maaltijdarr[0][0]);
					if(m2_f == true){
						System.out.println("[2] "+ maaltijdarr[1][0]);
					}
					if(m3_f == true){
						System.out.println("[3] "+maaltijdarr[2][0]);
					}
					
					String bekijken = scan.nextLine();
					int bek = (Integer.parseInt(bekijken)-1);
					
					// geeft informatie over maaltijd en laat gebruiker inschrijven
					System.out.printf("Eettijd: %s\nChef: %s\n", maaltijdarr[(bek)][2], maaltijdarr[(bek)][3]);
					System.out.printf("Aantal eters: "+m1.aant_del()+"\n");
					System.out.println("> Inschrijven? [1] ja [2] nee ");
					String nn = scan.nextLine(); 
								
					int n = read.IntReader(nn);
					// inschrijving, voegt naam toe aan array, print lijst deelnemers 
					if(n == 1){
						System.out.print("Onder welke naam? ");
						String name_i = scan.nextLine();
						if(bek == 0){
							m1.inschr(name_i);
							m1.dn_lijst();
						}else if(bek == 1){
							m2.inschr(name_i);
							m2.dn_lijst();
						}else if(bek == 2){
							m3.inschr(name_i);
							m3.dn_lijst();
						}
					}
					
					}else if(m1_f == false){ // error wanneer er nog geen maaltijden zijn
						System.out.println("Er zijn geen maaltijden om op in te schrijven.");
					}
				// optie 3 zijn de instructies 
				}else if(s == 3){ 
					System.out.println("Om een nieuwe maaltijd aan te maken, kies optie 1.");
					System.out.println("Om de huidige maaltijden te bekijken, kies optie 2.");
					System.out.println("Om af te sluiten, kies optie 4.");
				// optie 4 stopt het programma door de while-loop te sluiten
				}else if(s == 4){
					sess = false;
				}else{
					// wanneer de input niet 1, 2, 3 or 4 is
					System.out.println("ERROR: invalid input. Try again.");
				}
			}catch(Exception e){
				// in geval van crash. Meest voor de hand liggende error is verkeerde input. 
				System.out.println(e);
				System.out.println("ERROR: please fill in an integer");
			}
		}
	}
}	

