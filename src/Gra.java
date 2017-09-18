import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Gra {

	public static void clearScreen() {  
	    System.out.format("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n"
	    		+ "%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
	   } 
	
	public static int getInput() {
		Scanner input = null;
		int wybor = 0;
			try {
				input = new Scanner(System.in);
				Pattern koniecLinni = Pattern.compile("\\r\\n");
				input.useDelimiter(koniecLinni);
				System.out.format("Wybór: ");
				wybor = input.nextInt();
			}
			catch(NumberFormatException e) {
				
			}
			catch(InputMismatchException e) {
				
			}
		return wybor;
	}
	
	public static void sleep(int mil) {
		try {
			Thread.sleep(mil);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static Postac start() {
		Scanner input = new Scanner(System.in);
		String imie;
		int wybor;
		boolean wybrano = false;
		do {
			
			System.out.format("Wybierz profesje: %n 1. Wojownik%n 2. Strzelec%n 3. Mag%n");
			wybor = Integer.parseInt(input.nextLine());
			if(wybor == 1 || wybor == 2 || wybor == 3) wybrano = true;
			
		}while(!wybrano);
		Gra.clearScreen();
		System.out.format("Podaj imie bohatera: ");
		imie = input.nextLine();
		if(wybor == 1) {
			return new Wojownik(imie);
		}
		else if(wybor == 2) {
			return new Strzelec(imie);
		}
		else {
			return new Mag(imie);
		}
		
	}
	
	public static void main(String[] args) {
		Postac postac = start();
		postac.menuGlowne();
	}

}
