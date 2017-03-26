import java.util.ArrayList;
import java.util.List;

public class SystemBankowy{
	
	List<Klient> klienci;
	
	SystemBankowy(){
		klienci = new ArrayList<Klient>();
	}
	
	void loop(){
		menu();
		int opcja = (int)Input.get(Input.VAR.INT, "Wybierz opcje: ");
		switch (opcja){
		case 1: 
			nowyKlient();
			break;
		case 2:
			dodajWplate();
			break;
		case 3:
			usunKlienta();
			break;
		case 4: 
			wyswietlWszystkichKlientow();
			break;
		default:
			System.out.println("Nie ma takiej opcji.");				
		}
	}
	
	private void menu(){
		System.out.println("Menu: ");
		System.out.println("[1] Dodaj klienta");
		System.out.println("[2] Dodaj wplate");
		System.out.println("[3] Usun klienta");
		System.out.println("[4] Wyswietl wsystkich klientow");
	}
	
	private void wyswietlWszystkichKlientow(){
		for (Klient klient : klienci){
			klient.wyswietlDane();
			System.out.println("------------------------------------------------");
		}
	}
	
	private void usunKlienta(){
		Klient klient = null;
		try {
			klient = wyszukajKlientaPESEL();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			return;
		}
		klienci.remove(klient);
	}	
	
	private void dodajWplate(){
		Klient klient = null;
		try {
			klient = wyszukajKlientaPESEL();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			return;
		}
		int wplata = (int)Input.get(Input.VAR.INT, "Podaj kwote wplaty");
		klient.setStanKonta(klient.getStanKonta() + wplata);
		System.out.println("Aktuany stan konta to: " + klient.getStanKonta());
	}
	
	private Klient wyszukajKlientaPESEL() throws Exception{
		System.out.println("Podaj numer PESEL klienta:");
		String pesel = (String) Input.get(Input.VAR.STRING, "Podaj numer PESEL: ");
		
		for (int i = 0; i < klienci.size(); i++){
			if ( klienci.get(i).getPesel().equals(pesel) ){
				return klienci.get(i);
			}
		}
		throw new Exception("Brak takiego klienta");
	}
	
	private void nowyKlient(){
		System.out.println("Dodaj nowego klienta:" );
		
		String [] dataName = {"Imie", "Nazwisko", "PESEL", "Miejscowosc", "Ulica"};
		String [] data = new String[dataName.length]; 
		
		double stanKonta;
		int numerDomu, kodPocztowy;
		
		for (int i = 0; i < data.length; i++){
			data[i] = (String) Input.get(Input.VAR.STRING, "Proszê podaæ " + dataName[i] + " klienta: ");
		}
		
		stanKonta = (double) Input.get(Input.VAR.DOUBLE, "Prosze podac stan konta klienta: ");
		numerDomu = (int) Input.get(Input.VAR.INT, "Prosze podac numer domu klienta: ");
		kodPocztowy = (int) Input.get(Input.VAR.INT, "Prosze podac kod pocztowy klienta: ");
		int i = 0;
		klienci.add( 	new Klient(data[i++], data[i++], data[i++], 
						new Address(data[i++], data[i++], kodPocztowy, numerDomu),
									stanKonta));
	}
	
}