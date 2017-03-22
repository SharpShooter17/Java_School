
class Gra {
	public static void main(String args[]){
		if (args.length != 2){
			System.out.println("Blad: Bledna ilosc parametrow!");
			help();
			return;
		}
		
		int down, up;
		
		try {
			down = Integer.parseInt(args[0]);
			up = Integer.parseInt(args[1]);
		}
		catch(NumberFormatException except){
			System.out.println("Blad: Podane parametry sa nie poprawne!");
			help();
			return;
		}
				
		Play game = new Play(down, up);
		game.run();
	}	
	
	static void help(){
		String help = "Program przyjmuje dwa parametry dotyczace zakresu losowania w grze.\nPierwszy z nich to zakres dolny a drugi to zakres gorny.\nnp.: java Gra 0 10";
		System.out.println(help);
	}	
}