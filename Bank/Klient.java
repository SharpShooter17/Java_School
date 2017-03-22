

public class Klient{
  private String imie;
  private String nazwisko;
  private Address adres;
  private double stanKonta;
  private String pesel;
  
  Klient(String imie, String nazwisko, String pesel, Address adres, double stanKonta){
	this.imie = imie;
	this.nazwisko = nazwisko;
	this.pesel = pesel;
	this.adres = adres;
	this.stanKonta = stanKonta;
  }
}