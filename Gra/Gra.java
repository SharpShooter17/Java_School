/*
Napisz program losuj�cy liczb� z zakresu 0-N. 
Limit zakresu N przekazywany jest z linii polece�. 
Program pyta u�ytkownika, jaka jest wylosowana liczba. 
Je�eli u�ytkownik nie zgad�, 
dowiaduje si� czy wylosowana liczba jest wi�ksza czy mniejsza od
podanej. 
Je�eli zgad�, dowiaduje si� ile wykona� pr�b i jest pytany 
czy chce kontynuowa� gr�. 
Wymaganie: uwzgl�dnij w programie wszelkie mo�liwe pomy�ki 
u�ytkownika w przekazaniu parametru do programu. 
Wymaganie: zastosuj podej�cie obiektowe 
(napisz klas� posiadaj�c� sk�adniki i metody)
*/

class Gra {
	public static void main(String args[]){
		if (args.length != 2){
			System.out.println("B��d: B��dna ilo�c parametr�w!");
			help();
			return;
		}
		
		int down, up;
		
		try {
			down = Integer.parseInt(args[0]);
			up = Integer.parseInt(args[1]);
		}
		catch(NumberFormatException except){
			System.out.println("B��d: Podane parametry s� nie poprawne!");
			help();
			return;
		}
				
		Losowanie gra = new Losowanie(down, up);
		gra.run();
	}	
	static void help(){
		String help = "Program przyjmuje dwa parametry dotycz�ce zakresu losowania w grze.\nPierwszy z nich to zakres dolny a drugi to zakres g�rny.\nnp.: java Gra 0 10";
		System.out.println(help);
	}	
}