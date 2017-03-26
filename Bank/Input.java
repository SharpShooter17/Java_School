import java.util.Scanner;

public class Input {
	enum VAR { INT(0), DOUBLE(1), STRING(2); 
		int enumValue; 
		VAR(int val){ 
			enumValue = val;
		} 
		int getDenom(){
			return enumValue;
		}
		};
	
	static private Scanner sc = new Scanner(System.in);
		
	static public Object get(VAR var, String information){
		
		boolean done = true;
		Object result = null;
		do {
			done = true;
			System.out.println(information);
			try {
				if (var == VAR.INT){
					result = sc.nextInt();
				} else if (var == VAR.DOUBLE){
					result = sc.nextDouble();
				} else if (var == VAR.STRING) {
					result = sc.nextLine();
				}
			} catch(Exception e){
				done = false;
				sc.nextLine();
			}
		
		} while (!done);
		
		return result;	
	}
}
