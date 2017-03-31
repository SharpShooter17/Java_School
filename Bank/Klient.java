

public class Klient{
  private String imie;
  private String nazwisko;
  private Address adres;
  private double stanKonta;
  private long pesel;
  private Long numerKonta;
  
  Klient(String imie, String nazwisko, long pesel, Address adres, double stanKonta, long numerKonta){
	this.setImie(imie);
	this.setNazwisko(nazwisko);
	this.setPesel(pesel);
	this.setAdres(adres);
	this.setStanKonta(stanKonta);
	this.setNumerKonta(numerKonta);
  }

	public long getPesel() {
		return pesel;
	}
	
	public void setPesel(long pesel) {
		this.pesel = pesel;
	}
	
	public double getStanKonta() {
		return stanKonta;
	}
	
	public void setStanKonta(double stanKonta) {
		this.stanKonta = stanKonta;
	}
	
	public Address getAdres() {
		return adres;
	}
	
	public void setAdres(Address adres) {
		this.adres = adres;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}
	
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public String getImie() {
		return imie;
	}
	
	public void setImie(String imie) {
		this.imie = imie;
	}
	public void wyswietlDane(){
		System.out.print( "Imie: " + imie + 
							"\nNazwisko: " + nazwisko + 
							"\nPESEL" + pesel +
							"\nStan konta: " + stanKonta + 
							"\nAdres: ");
		adres.showAddress();
		System.out.println("Numer konta: " + numerKonta);
	}

	public Long getNumerKonta() {
		return numerKonta;
	}

	private void setNumerKonta(Long numerKonta) {
		this.numerKonta = numerKonta;
	}
}