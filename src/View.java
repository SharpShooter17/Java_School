import java.util.List;
import java.util.Scanner;

public class View {
	Scanner sc = new Scanner(System.in);
	
	View(){
		
	}
	
	public MAINMENU showMainMenu(){
		System.out.println("Menu: ");
		System.out.println("[1] Add new client");
		System.out.println("[2] Payment");
		System.out.println("[3] Pay off");
		System.out.println("[4] Remove client");
		System.out.println("[5] Show all clients");
		System.out.println("[6] Transfer");
		System.out.println("[7] Find client");
		System.out.println("[0] Exit\n");
		
		System.out.print("Select: ");
		
		return MAINMENU.values()[getInt()];
	}
	
	public MENUFINDCLIENT showMenuFindClient(){
		System.out.println("Select search category");
		System.out.println("[1] Name");
		System.out.println("[2] Surname");
		System.out.println("[3] Address");
		System.out.println("[4] Client number");
		System.out.println("[5] PESEL");
		System.out.println("[0] Cancel");
		return MENUFINDCLIENT.values()[getInt()];
	}
	
	public String remove(){
		System.out.print("Enter client PESEL to remove: " );
		return getString();
	}
	
	public String enter(String what){
		System.out.print("Please enter " + what + ": ");
		return getString();
	}
	
	public String [] payment(){
		String [] result = new String[2];
		System.out.print("Payment.");
		
		result[0] = enter("PESEL");
		System.out.print("How many: ");
		result[1] = getDouble().toString();
		
		return result;
	}
	
	public String [] payOff(){
		String [] result = new String[2];
		System.out.print("Pay off.");
		
		result[0] = enter("PESEL");
		System.out.print("How many: ");
		result[1] = getDouble().toString();
		
		return result;
	}
	
	public String [] transfer(){
		String [] result = new String[3];
		
		result[0] = enter("the sender's PESEL");
		result[1] = enter("the receiver's PESEL");
		System.out.print("How many: ");
		result[2] = getDouble().toString();
		
		return result;
	}
	
	public String [] addNewClient(){
		String [] result = new String[8];
		System.out.println("Add new client.");
		int i = 0;
		System.out.print("Name: ");
		result[i++] = getString();
		System.out.print("Surname: ");
		result[i++] = getString();
		System.out.print("PESEL: ");
		result[i++] = getString();
		System.out.print("AccountBalance: ");
		result[i++] = getDouble().toString();
		System.out.print("City:");
		result[i++] = getString();
		System.out.print("Street:");
		result[i++] = getString();
		System.out.print("Post code:");
		result[i++] = getInt().toString();
		System.out.print("Number of house:");
		result[i++] = getInt().toString();
		
		return result;
	}
	
	public String[] searchByAddress(){
		String [] result = new String[4];
		
		System.out.println("Searching by Address. If you want skip parameters you should write '0'.");
		System.out.print("City: ");
		result[0] = getString();
		System.out.print("Street: ");
		result[1] = getString();
		System.out.print("PostCode: ");
		result[2] = getString();
		System.out.print("Number of house: ");
		result[3] = getString();
		
		return result;
	}
	
	public void showClients(List<Client> clients){
		for (Client client : clients){
			System.out.println(client.getData());
			System.out.println("-------------------------------\n");
		}
	}
	
	private Integer getInt(){
		boolean done = true;
		Integer result = 0;
		do {
			done = true;
			try {
				result = sc.nextInt();
			} catch(Exception e){
				done = false;
				sc.nextLine();
			}
		
		} while (!done);
		
		return result;
	}
	
	private Double getDouble(){
		boolean done = true;
		Double result = 0.0;
		do {
			done = true;
			try {
				result = sc.nextDouble();
			} catch(Exception e){
				done = false;
				sc.nextLine();
			}
		
		} while (!done);
		
		return result;
	}
	
	private String getString(){
		String result = new String();
		while((result = sc.nextLine()).isEmpty());
		return result;
	}
	
	public void showError(String error){
		System.err.println("[ERROR]: "+ error);
	}
	
	public boolean bSure(){
		System.out.println("Are you sure you want to perform this operation?\nType Y to confirm or something different to cancel: ");
		String result = getString();
		if (result.charAt(0) == 'Y' || result.charAt(0) == 'y' ){
			return true;
		}
		
		return false;
	}
}
