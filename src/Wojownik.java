import java.util.Random;

public class Wojownik extends Postac {

	public Wojownik(String naz) {
		super(naz);
		szanse = new Szanse(0,1,0,0);
		podstawoweStatystykiPostaci();
		zalozBron(new Bron("patyk",2,2,0,0,1,0,0,0,0));
		zalozNaGlowe(new Ubranie("czapka",1,0,0,0,0));
		zalozNaNogi(new Ubranie("jeansy",0,0,5,0,0));
		zalozNaKlate(new Ubranie("bluza",1,0,5,0,0));
		zalozNaRece(new Ubranie("rêkawiczki kuchenne",1,1,0,0,0));
		zalozNaStopy(new Ubranie("adidaski",0,0,0,2,0));
		zalozDodatkowe(new Ogluszajace("Kamien",0,10));
	}
	
	@Override
	public void podstawoweStatystykiPostaci() {
		 maxZdrowie = 30;
		 aMinAtkFiz = 1;
		 aMaxAtkFiz = 4;
		 aMinAtkMag = 0;
		 aMaxAtkMag = 0;
		 aRedukcjaObrazenFiz = 2;
		 aRedukcjaObrazenMag = 1;
	}

	@Override
	public void levelUp() {
		 doswiadczenie -= wymaganeDoswiadczenie;
		 maxZdrowie += 10;
		 aMinAtkFiz += 1;
		 aMaxAtkFiz += 2;
		 aMinAtkMag += 0;
		 aMaxAtkMag += 0;
		 aRedukcjaObrazenFiz += 2;
		 aRedukcjaObrazenMag += 2;
		 poziom++;
		 wymaganeDoswiadczenie *= 1.5;
		 System.out.format("%s zdoby³ nowy poziom %d%n",imie,poziom);
	}

	@Override
	public void menuGlowne() {
		Gra.clearScreen();
		System.out.format("Szable i pantofle 2, witaj wojowniku %s%n", imie);
		System.out.format("1. Arena%n");
		System.out.format("2. Misje%n");
		System.out.format("3. KuŸnia%n");
		System.out.format("4. P³atnerz%n");
		System.out.format("5. Sklep z dodatkami%n");
		System.out.format("6. Statystyki%n");
		System.out.format("7. Ekwipuek%n");
		System.out.format("8. Wyjdz z gry%n");
		
		switch(Gra.getInput()) {
		case 1:
		menuAreny();
			break;
		case 2:
		menuMisji();
			break;
		case 3:
		menuBronie();
			break;
		case 4:
		menuArmor();
			break;
		case 5:
		menuSklepuZDodatkami();
			break;
		case 6:
		statystyki();
			break;
		case 7:
		ekwipunek();
			break;
		case 8:
		wyjdzZGry();
			break;
		default:
			menuGlowne();
		}
	}

	@Override
	public void menuBronie() {
		Gra.clearScreen();
		wyswietlZloto();
		wyswietlAktualnaBron();
		sklep.wyswietlBronieWoj();
		System.out.format("0. - wróc%n");
		int in = Gra.getInput();
		if(in == 0) menuGlowne();
		else {
			try {
				Bron b = sklep.kupBronWoj(in);
				if(kupBron(b)) {
					System.out.format("Kupiono!");
					Thread.sleep(2000);
				}
				else {
					System.out.format("Za ma³o z³ota");
					Thread.sleep(2000);
				}
				menuGlowne();
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("Nie ma takej broni");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				menuBronie();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void menuArmor() {
		Gra.clearScreen();
		System.out.format("1. Obrona g³owy%n");
		System.out.format("2. Obrona tu³owia%n");
		System.out.format("3. Obrona r¹k%n");
		System.out.format("4. Obrona Nóg%n");
		System.out.format("5. Obrona Stóp%n");
		System.out.format("0. - wroæ do menu g³ównego%n");
		
		int in = Gra.getInput();
		
		switch(in) {
		case 1:
		armorGlowa();
			break;
		case 2:
		armorKlata();
			break;
		case 3:
		armorRece();
			break;
		case 4:
		armorNogi();
			break;
		case 5:
		armorStopy();
			break;
		case 0:
		menuGlowne();
			break;
		default:
		menuArmor();
		}
	}
	
	@Override
	public void menuSklepuZDodatkami() {
		Gra.clearScreen();
		wyswietlZloto();
		wyswietlAktualneDodatkowe();
		sklep.wyswietlDodatkoweWoj();
		System.out.format("0. - wróc%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuGlowne();
		else {
			try {
				if(kupDodatkowe(sklep.kupDodatkoweWoj(in))) {
					System.out.format("Kupiono! Dodano do ekwipunku.");
					Thread.sleep(2000);
				}
				else {
					System.out.format("Za ma³o z³ota");
					Thread.sleep(2000);
				}
			}
			catch(IndexOutOfBoundsException e) {
				menuSklepuZDodatkami();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				menuGlowne();
			}
		}	
	}

	@Override
	public void statystyki() {
		Gra.clearScreen();
		System.out.format("0. - wroæ%nWojownik%n");
		wyswietlStatystyki();
		int in = Gra.getInput();
		
		if(in == 0) menuGlowne();
		else statystyki();
	}

	@Override
	public void armorGlowa() {
		Gra.clearScreen();
		wyswietlZloto();
		wyswietlAktualnaGlowe();
		sklep.wyswietlGlowaWoj();
		System.out.format("0. - wróc do P³atnerza%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuArmor();
		else {
			try {
				if(kupGlowa(sklep.kupGlowaWoj(in))) {
					System.out.format("Kupiono!");
					Thread.sleep(2000);
				}
				else {
					System.out.format("Za ma³o z³ota");
					Thread.sleep(2000);
				}
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("Nie ma takej broni");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menuArmor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				menuGlowne();
			}
		}
	}

	@Override
	public void armorKlata() {
		Gra.clearScreen();
		wyswietlZloto();
		wyswietlAktualnaKlate();
		sklep.wyswietlKlataWoj();
		System.out.format("0. - wróc do P³atnerza%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuArmor();
		else {
			try {
				if(kupKlata(sklep.kupKlataWoj(in))) {
					System.out.format("Kupiono!");
					Thread.sleep(2000);
				}
				else {
					System.out.format("Za ma³o z³ota");
					Thread.sleep(2000);
				}
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("Nie ma takej broni");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menuArmor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				menuGlowne();
			}
		}
	
	}

	@Override
	public void armorRece() {
		Gra.clearScreen();
		wyswietlZloto();
		wyswietlAktualneRece();
		sklep.wyswietlReceWoj();
		System.out.format("0. - wróc do P³atnerza%n");
		
		int in = Gra.getInput();

		if(in == 0) menuArmor();
		else {
			try {
				if(kupRece(sklep.kupReceWoj(in))) {
					System.out.format("Kupiono!");
					Thread.sleep(2000);
				}
				else {
					System.out.format("Za ma³o z³ota");
					Thread.sleep(2000);
				}
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("Nie ma takej broni");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menuArmor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				menuGlowne();
			}
		}
	
	}
	@Override
	public void armorNogi() {
		Gra.clearScreen();
		wyswietlZloto();
		wyswietlAktualnaNogi();
		sklep.wyswietlNogiWoj();
		System.out.format("0. - wróc do P³atnerza%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuArmor();
		else {
			try {
				if(kupNogi(sklep.kupNogiWoj(in))) {
					System.out.format("Kupiono!");
					Thread.sleep(2000);
				}
				else {
					System.out.format("Za ma³o z³ota");
					Thread.sleep(2000);
				}
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("Nie ma takej broni");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menuArmor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				menuGlowne();
			}
		}
	
	}

	@Override
	public void armorStopy() {
		Gra.clearScreen();
		wyswietlZloto();
		wyswietlAktualneStopy();
		sklep.wyswietlStopyWoj();
		System.out.format("0. - wróc do P³atnerza%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuArmor();
		else {
			try {
				if(kupStopy(sklep.kupStopyWoj(in))) {
					System.out.format("Kupiono!");
					Thread.sleep(2000);
				}
				else {
					System.out.format("Za ma³o z³ota");
					Thread.sleep(2000);
				}
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("Nie ma takej broni");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menuArmor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				menuGlowne();
			}
		}
	}

}