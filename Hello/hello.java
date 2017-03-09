

class Hello {
  public static void main(String args[]){
    System.out.println("Hello, World");
    
    for (String elem : args){
      try{
	int x = Integer.parseInt(elem);
	System.out.println(x);
      }
      catch (NumberFormatException except) {
	System.out.println("Format nie poprawny!");
      }
    }
   
    return;
  }
};
