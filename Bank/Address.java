public class Address{
  private String street;
  private String city;
  private int postalCode;
  private int houseNumber;
  
  Address(String street, String city, int postalCode, int houseNumber){
	this.street = street;
	this.city = city;
	this.postalCode = postalCode;
	this.houseNumber = houseNumber;
  }
  
  public String getStreet(){
	return street;
  }
  
  public String getCity(){
	return city;
  }
  
  public int getPostalCode(){
	return postalCode;
  }
  
  public int getHouseNomber(){
	return houseNumber;
  }
  
  public void showAddress(){
	System.out.println( city + ", " + postalCode + ", " + street + " " + houseNumber );
  }
}