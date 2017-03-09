//package Kwadrat;

public class RownanieKwadratowe {
  private double a, b, c;
  private double delta; 
  private Double[] x;
  
  public RownanieKwadratowe(){
    a = 0; b = 0; c = 0;
    delta = 0;
  }
  
  public RownanieKwadratowe(double a, double b, double c){
    this.a = a;
    this.b = b;
    this.c = c;
    if (a != 0.0) {
    	delta();
    	System.out.println("Delta: " + delta);
    	pierwiastki();
    }
    else if (b != 0.0){
    	RownanieProstej();
    }
  }
  
  private void RownanieProstej(){
	  x = new Double[1];
	  //bx + c = 0 => bx = -c => x = -c/b
	  x[0] = (-c)/b;
  }
  
  private void delta(){
    //b^2 - 4ac
    delta = (b*b);
    delta = delta - (4 * a * c);
  }
  
  private void pierwiastki(){
    if (delta < 0.0) {
      return;
    }
    else if (delta > 0.0){
      x = new Double[2];
      pierwiastekX2();      
    }
    else{
      x = new Double[1];
    }
    pierwiastekX1();
  }
  
  private void pierwiastekX1(){
    //x1 = (-b - sqrt(delta)) / 2a
    x[0] = ((-b) - Math.sqrt(delta))/(2*a);
  }
  
  private void pierwiastekX2(){
    //x2 = (-b + sqrt(delta)) / 2a
     x[1] = ((-b) + Math.sqrt(delta))/(2*a);
  }  
  
  public void showResults(){
    if (!(x instanceof Double[])){
      System.out.println("Brak pierwiastków");
    }
    else if (x.length == 2){
      System.out.println("Dwa pierwiastki: x1 = " + x[0] + ", x2 = " + x[1]);
    }
    else if (x.length == 1){
      System.out.println("Jednen pierwiastek: x1 = " + x[0]);
    }
  }
  
}