import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SystemBankowy{
	
	List<Klient> klienci;
	
	SystemBankowy(){
		klienci = new ArrayList<Klient>();
		klienci.add(new Klient("Bartosz", "Ujazdowski", 1234567890, new Address("Lipowa", "Lodz", 99550, 25), 0, 1000000 ));
	}
	
	boolean loop(){
		menu();
		int opcja = Input.instance().Int("Wybierz opcje: ");
		wyczyscEkran();
		switch (opcja){
		case 0:
			return false;
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
			wyswietlKlientow((ArrayList<Klient>)klienci);
			break;
		case 5:
			try {
				przelew();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 6:
			wyszukaj();
			break;
		default:
			System.out.println("Nie ma takiej opcji.");				
		}
		
		//Input.instance().Stop("Wcisnij enter aby kontynuowac.");
		
		return true;
	}
	
	private void menu(){
		System.out.println("Menu: ");
		System.out.println("[1] Dodaj klienta");
		System.out.println("[2] Dodaj wplate");
		System.out.println("[3] Usun klienta");
		System.out.println("[4] Wyswietl wsystkich klientow");
		System.out.println("[5] Wykonaj przelew");
		System.out.println("[6] Wyszukaj klienta po krtyterium");
		System.out.println("[0] Wyjdz");
	}
	
	private void przelew() throws Exception{
		Input in = Input.instance();
		Long zleceniodawca = in.Long("Podaj numer konta zleceniodawcy: ");
		Long odbiorca = in.Long("Podaj numer konta odbiorcy: ");
		double kwota = in.Double("Podaj kwote przelewu: ");
		Klient kZleceniodawca = null, kOdbiorca = null;
		try {
			kZleceniodawca = wyszukajKlientaNumerKonta(zleceniodawca);
			kOdbiorca = wyszukajKlientaNumerKonta(odbiorca);			
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		if (kZleceniodawca.getStanKonta() < kwota){
			throw new Exception("Brak wystarczajacych srodkow na koncie!");
		}
		
		kZleceniodawca.setStanKonta(kZleceniodawca.getStanKonta() - kwota);
		kOdbiorca.setStanKonta(kOdbiorca.getStanKonta() + kwota);
		System.out.println("Przelew przebiegl pomyslnie.");
		kZleceniodawca.wyswietlDane();
		kOdbiorca.wyswietlDane();
	}
	
	private int opcjaWyszukaj(){
		wyczyscEkran();
		System.out.println("Wybierz kryterum wyszukiwania: ");
		System.out.println("[1] Imie");
		System.out.println("[2] Nazwisko");
		System.out.println("[3] Adres");
		System.out.println("[4] Numer klienta");
		System.out.println("[5] PESEL");
		System.out.println("[6] Anuluj operacje");
		
		int opcja = 0;
		Input in = Input.instance();
		do{
			opcja = in.Int("Podaj poprawne kryterium: ");
		} while ( opcja > 6 && opcja < 1 );
		return opcja;
	}
	
	private void wyszukaj(){
		wyczyscEkran();
		Input in = Input.instance();
		ArrayList<Klient> result = new ArrayList<Klient>();
		
		switch (opcjaWyszukaj()){
		case 1:
			result = wyszukajKlientowImie( in.Str("Wpisz imie szukanego klienta: ") );
			break;
		case 2:
			result = wyszukajKlientowNazwisko( in.Str("Wpisz nazwisko szukanego klienta: ") );
			break;
		case 3:
			String street, city;
			int postalCode, houseNumber;
			System.out.println("Aby ominac pole wpisz '0'");
			city = in.Str("Podaj miasto: ");
			street = in.Str("Podaj ulice: ");
			postalCode = in.Int("Podaj kod pocztowy: ");
			houseNumber = in.Int("Podaj numer domu: ");
			result = wyszukajKlientowAdres( new Address(street, city, postalCode, houseNumber) );
			break;
		case 4:
			try{
			  result.add( wyszukajKlientaNumerKonta( in.Long("Wpisz numer konta szukanego klienta: ") ) );
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return;
			}
			break;
		case 5:
			try{
				result.add( wyszukajKlientaPESEL( in.Long("Wpisz PESEL szukanego klienta: ") ) );
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return;
				}
			break;
		case 6:
			return;
		}
		
		wyswietlKlientow(result);		
	}
	
	private void wyswietlKlientow(ArrayList<Klient> aKlienci){
		for (Klient klient : aKlienci){
			klient.wyswietlDane();
			System.out.println("------------------------------------------------");
		}
	}
	
	private void usunKlienta(){
		wyczyscEkran();
		Klient klient = null;
		try {
			klient = wyszukajKlientaPESEL(Input.instance().Long("Podaj numer PESEL klienta: "));
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			return;
		}
		klienci.remove(klient);
	}	
	
	private void dodajWplate(){
		wyczyscEkran();
		Klient klient = null;
		try {
			klient = wyszukajKlientaPESEL(Input.instance().Long("Podaj numer PESEL klienta: "));
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			return;
		}
		int wplata = Input.instance().Int("Podaj kwote wplaty");
		klient.setStanKonta(klient.getStanKonta() + wplata);
		System.out.println("Aktuany stan konta to: " + klient.getStanKonta());
	}
	
	private ArrayList<Klient> wyszukajKlientowAdres(Address adres){
		ArrayList<Klient> results = new ArrayList<Klient>();
		
		for (Iterator<Klient> iterator = klienci.iterator(); iterator.hasNext();) {
			Klient klient = iterator.next();
			if (klient.getAdres().equals(adres)){
				results.add(klient);
			}
		}
		
		return results;		
	}
	
	private ArrayList<Klient> wyszukajKlientowNazwisko(String nazwisko){
		ArrayList<Klient> results = new ArrayList<Klient>();
		
		for (Iterator<Klient> iterator = klienci.iterator(); iterator.hasNext();) {
			Klient klient = iterator.next();
			if (klient.getNazwisko().equals(nazwisko)){
				results.add(klient);
			}
		}
		
		return results;		
	}
	
	private ArrayList<Klient> wyszukajKlientowImie(String imie){
		ArrayList<Klient> results = new ArrayList<Klient>();
		
		for (Iterator<Klient> iterator = klienci.iterator(); iterator.hasNext();) {
			Klient klient = iterator.next();
			if (klient.getImie().equals(imie)){
				results.add(klient);
			}
		}
		
		return results;		
	}
	
	private Klient wyszukajKlientaPESEL(long pesel) throws Exception{	
		for (int i = 0; i < klienci.size(); i++){
			if ( klienci.get(i).getPesel() == pesel ){
				return klienci.get(i);
			}
		}
		throw new Exception("Brak takiego klienta w bazie");
	}
	
	private Klient wyszukajKlientaNumerKonta( long numerKonta ) throws Exception{
		
		for (Iterator<Klient> iterator = klienci.iterator(); iterator.hasNext();) {
			Klient klient = iterator.next();
			if (klient.getNumerKonta() == numerKonta ){
				return klient;
			}
		}
		throw new Exception("Brak takiego numeru klienta w bazie");
	}
	
	
	private void nowyKlient(){
		wyczyscEkran();
		System.out.println("Dodaj nowego klientas" );
		
		String [] dataName = {"Imie", "Nazwisko", "Miejscowosc", "Ulica"};
		String [] data = new String[dataName.length]; 
		
		double stanKonta;
		int numerDomu, kodPocztowy;
		long pesel;
		Input in = Input.instance();
		
		for (int i = 0; i < data.length; i++){
			data[i] = in.Str("Prosze podac+ " + dataName[i] + " klienta: ");
		}
		
		numerDomu = in.Int("Prosze podac numer domu klienta: ");
		kodPocztowy = in.Int("Prosze podac kod pocztowy klienta: ");
		stanKonta = in.Double("Prosze podac stan konta klienta: ");
		pesel = in.Long("Prosze podac numer pesel klienta");
		
		int i = 0;
		klienci.add( 	new Klient(data[i++], data[i++], pesel, 
						new Address(data[i++], data[i++], kodPocztowy, numerDomu),
									stanKonta, generujNumerKonta(pesel, data[0], data[1])));
	}
	
	private Long generujNumerKonta(long pesel, String Imie, String Nazwisko){
		Long numerKonta = new Long(0);
		
		for (int i = 0; i < Imie.length(); i++){
			numerKonta += Imie.charAt(i);
		}
		
		for (int i = 0; i < Nazwisko.length(); i++){
			numerKonta += Nazwisko.charAt(i);
		}
		
		return Long.parseUnsignedLong(numerKonta.toString() + pesel);
	}
	
	private void wyczyscEkran(){
	  System.out.print("\033[H\033[2J");
	  System.out.flush();
	}
}