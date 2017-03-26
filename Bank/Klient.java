

public class Klient{
  private String imie;
  private String nazwisko;
  private Address adres;
  private double stanKonta;
  private String pesel;
  
  Klient(String imie, String nazwisko, String pesel, Address adres, double stanKonta){
	this.setImie(imie);
	this.setNazwisko(nazwisko);
	this.setPesel(pesel);
	this.setAdres(adres);
	this.setStanKonta(stanKonta);
  }

	public String getPesel() {
		return pesel;
	}
	
	public void setPesel(String pesel) {
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
							"\nStan konta: " + stanKonta + 
							"\nAdres: ");
		adres.showAddress();
	}
}