//package Kwadrat;

class Kwadrat {
  public static void main(String args[]){
    double a, b, c;
    
    if (args.length != 3){
      System.out.println("Program przyjmuje trzy parametry.");
      System.out.println("Program rozwi�zuje r�wnanie ax^2 + bx + x.\n kolejno�� przyjmowanych parametr�w to: a b c.");
      return;
    }
    int i = 0;
    try {
      a = Double.parseDouble(args[i++]);
      b = Double.parseDouble(args[i++]);
      c = Double.parseDouble(args[i++]);
    }
    catch (NumberFormatException except) {
      System.out.println("Parametr numer " + i + " jest b�dny.\n Parametry musz�� by� liczbami rzeczywistymi.");
      return;
    }
    
    System.out.println("y(x) = " + a + "x^2 + " + b + "x + " + c);
    RownanieKwadratowe row = new RownanieKwadratowe(a, b, c);    
    row.showResults();
  }
};