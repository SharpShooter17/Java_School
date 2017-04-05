import java.util.Scanner;

public class Input {
	
	static private Scanner sc;
	static private Input in;
	
    private	Input(){
 		sc = new Scanner(System.in);
	}
	
    public static Input instance(){
    	if (!(in instanceof Input)){
    		in = new Input();
    	}
    	
    	return in;
    }
		
	public int Int(String information){
		boolean done = true;
		int result = 0;
		do {
			done = true;
			System.out.println(information);
			try {
				result = sc.nextInt();
			} catch(Exception e){
				done = false;
				sc.nextLine();
			}
		
		} while (!done);
		
		return result;	
	}
	
	public long Long(String information){
		boolean done = true;
		long result = 0;
		do {
			done = true;
			System.out.println(information);
			try {
				result = sc.nextLong();
			} catch(Exception e){
				done = false;
				sc.nextLine();
			}
		
		} while (!done);
		
		return result;	
	}
	
	public double Double(String information){
		boolean done = true;
		double result = 0.0;
		do {
			done = true;
			System.out.println(information);
			try {
				result = sc.nextDouble();
			} catch(Exception e){
				done = false;
				sc.nextLine();
			}
		} while (!done);
		
		return result;	
	}
	
	public String Str(String information){
		boolean done = true;
		String result = null;
		do {
			done = true;
			System.out.println(information);
			try {
				while((result = sc.nextLine()).isEmpty());
			} catch(Exception e){
				done = false;
				sc.nextLine();
			}
		} while (!done);
		
		return result;	
	}
	
	public void Stop(String information){
		System.out.println(information);
		sc.nextLine();
	}
	
}
