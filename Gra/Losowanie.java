import java.util.Random;
import java.util.Scanner;
import java.util.NoSuchElementException;	
import java.util.InputMismatchException;

class Losowanie{
	int up, down;
	Scanner input;
	
	Losowanie(int down, int up){
		super();
		
		if (up < down) {
			int temp = up;
			up = down;
			down = temp;
		}
		
		this.up = up;
		this.down = down;
		input = new Scanner(System.in);
	}
	
	int random(){
		Random generator = new Random();
		return down + generator.nextInt(up);
	}
	
	public void run(){
		boolean done = false;
		int magic = random();
		int attempt = 1;
		while (!done){
			int user_type = userType();
			if (user_type == magic){
				System.out.println("Brawo! To ta liczba. Ilo�� pr�b to: " + attempt);
				done = !onceMore();
				
				if (!done) {
					magic = random();
					attempt = 1;
				}
			} else {
				attempt++;
				userHelp(magic, user_type);
			}
		}
	}
	
	private boolean onceMore() {		
		while (true){
			System.out.print("Czy chcesz spr�bowa� jeszcze raz? [T/N] : ");
			char select = input.next().charAt(0);
			if ( select == 'N' || select == 'n' ){
				return false;
			} else if (select != 'T' && select != 't') {
				System.out.println("Podaj poprawn� warto��.");
				continue;
			} else {
				return true;
			}
		}
	}
	
	private int userType() {
		int result = 1;
		boolean done = false;
		while (!done) {
			System.out.print("Podaj liczb�: ");
			try {
				result = input.nextInt();
				done = true;
			} catch (InputMismatchException e) {
				System.out.print("B��dny format. ");
				input.nextLine();
				done = false;
			}
		}
		return result;
	}
	
	private void userHelp(int magic, int user_type){
		if ( (user_type > up) || user_type < down ){
			System.out.println("Podana liczba jest spoza zakresu!");
		} else if (user_type < magic){
			System.out.println("Celuj wy�ej");
		} else if (user_type > magic){
			System.out.println("Celuj ni�ej");
		} else{
			System.out.println("Ten kod nigdy nie powinien si� wykona�. Losowanie.java : run()");
		}
	}
	
}