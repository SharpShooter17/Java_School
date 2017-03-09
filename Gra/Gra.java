/*
Napisz program losuj¹cy liczbê z zakresu 0-N. 
Limit zakresu N przekazywany jest z linii poleceñ. 
Program pyta u¿ytkownika, jaka jest wylosowana liczba. 
Je¿eli u¿ytkownik nie zgad³, 
dowiaduje siê czy wylosowana liczba jest wiêksza czy mniejsza od
podanej. 
Je¿eli zgad³, dowiaduje siê ile wykona³ prób i jest pytany 
czy chce kontynuowaæ grê. 
Wymaganie: uwzglêdnij w programie wszelkie mo¿liwe pomy³ki 
u¿ytkownika w przekazaniu parametru do programu. 
Wymaganie: zastosuj podejœcie obiektowe 
(napisz klasê posiadaj¹c¹ sk³adniki i metody)
*/

class Gra {
	public static void main(String args[]){
		if (args.length != 2){
			System.out.println("B³¹d: B³êdna iloœc parametrów!");
			help();
			return;
		}
		
		int down, up;
		
		try {
			down = Integer.parseInt(args[0]);
			up = Integer.parseInt(args[1]);
		}
		catch(NumberFormatException except){
			System.out.println("B³¹d: Podane parametry s¹ nie poprawne!");
			help();
			return;
		}
				
		Losowanie gra = new Losowanie(down, up);
		gra.run();
	}	
	static void help(){
		String help = "Program przyjmuje dwa parametry dotycz¹ce zakresu losowania w grze.\nPierwszy z nich to zakres dolny a drugi to zakres górny.\nnp.: java Gra 0 10";
		System.out.println(help);
	}	
}