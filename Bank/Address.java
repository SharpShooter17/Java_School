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
  
  public boolean compareNotEvryFields(Address address) {
	if ( !((address.street.equals("0") || address.street.equals(this.street))) ){
	  return false;
	} else if ( !((address.city.equals("0") || address.city.equals(this.city)))){
	  return false;
	} else if ( !((address.postalCode == 0 || address.postalCode == this.postalCode))){
	  return false;
	} else if ( !((address.houseNumber == 0 || address.houseNumber == this.houseNumber))){
	  return false;
	}	
	return true;	
  }
  
  public boolean equals(Object obj){
	  if (this == obj){
		  return true;
	  }
	  
	  if ( !(obj instanceof Address)){
		  return false;
	  }
	  
	  Address tmp = (Address)obj;
	  
	  if (street == tmp.street && city == tmp.city & postalCode == tmp.postalCode && houseNumber == tmp.houseNumber){
		  return true;
	  } else {
		  return false;
	  }
  }
  
}