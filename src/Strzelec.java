
public class Strzelec extends Postac {
	public Strzelec(String naz) {
		super(naz);
		szanse = new Szanse(1,0,0,0);
		podstawoweStatystykiPostaci();
		zalozBron(new Bron("drewniany ³uk",1,3,0,0,2,0,0,0,0));
		zalozNaGlowe(new Ubranie("kapelusz",0,0,0,1,0));
		zalozNaNogi(new Ubranie("szorty",0,0,2,1,0));
		zalozNaKlate(new Ubranie("bezrêkawnik",1,1,0,0,0));
		zalozNaRece(new Ubranie("menelski rêkawiczki",1,0,0,1,0));
		zalozNaStopy(new Ubranie("sanda³y",0,0,0,2,0));
		zalozDodatkowe(new Ogluszajace("Kamien",0,10));
	}
	
	@Override
	public void podstawoweStatystykiPostaci() {
		 maxZdrowie = 25;
		 aMinAtkFiz = 2;
		 aMaxAtkFiz = 4;
		 aMinAtkMag = 0;
		 aMaxAtkMag = 0;
		 aRedukcjaObrazenFiz = 1;
		 aRedukcjaObrazenMag = 0;
	}
	
	@Override
	public void levelUp() {
		 doswiadczenie -= wymaganeDoswiadczenie;
		 maxZdrowie += 7;
		 aMinAtkFiz += 2;
		 aMaxAtkFiz += 2;
		 aMinAtkMag += 0;
		 aMaxAtkMag += 0;
		 aRedukcjaObrazenFiz += 1;
		 aRedukcjaObrazenMag += 0;
		 poziom++;
		 wymaganeDoswiadczenie *= 1.5;
		 System.out.format("%s zdoby³ nowy poziom %d%n",imie,poziom);
	}

	@Override
	public void menuGlowne() {
		Gra.clearScreen();
		System.out.format("Szable i pantofle 2,  witaj strzelcu %s%n",imie);
		System.out.format("1. Arena%n");
		System.out.format("2. Misje%n");
		System.out.format("3. Sklep - Robin Hood%n");
		System.out.format("4. Sklep - Wszystko na czerep i nie tylko%n");
		System.out.format("5. Sklep z dodatkami%n");
		System.out.format("6. Statystyki%n");
		System.out.format("7. Ekwipuek%n");
		System.out.format("8. Wyjdz z gry%n");
		int in = Gra.getInput();
		
		switch(in) {
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
		sklep.wyswietlBronieStrz();
		System.out.format("0. - wróc%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuGlowne();
		else {
			try {
				if(kupBron(sklep.kupBronStrz(in))) {
					System.out.format("Kupiono!");
					Thread.sleep(2000);
				}
				else {
					System.out.format("Za ma³o z³ota");
					Thread.sleep(2000);
				}
			}
			catch(IndexOutOfBoundsException e) {
				menuBronie();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				menuGlowne();
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
	public void armorGlowa() {
		Gra.clearScreen();
		wyswietlZloto();
		wyswietlAktualnaGlowe();
		sklep.wyswietlGlowaStrz();
		System.out.format("0. - wróc do straganów%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuArmor();
		else {
			try {
				if(kupGlowa(sklep.kupGlowaStrz(in))) {
					System.out.format("Kupiono!");
					Thread.sleep(2000);
				}
				else {
					System.out.format("Za ma³o z³ota");
					Thread.sleep(2000);
				}
			}
			catch(IndexOutOfBoundsException e) {
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
		sklep.wyswietlKlataStrz();
		System.out.format("0. - wróc do straganów%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuArmor();
		else {
			try {
				if(kupKlata(sklep.kupKlataStrz(in))) {
					System.out.format("Kupiono!");
					Thread.sleep(2000);
				}
				else {
					System.out.format("Za ma³o z³ota");
					Thread.sleep(2000);
				}
			}
			catch(IndexOutOfBoundsException e) {
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
		sklep.wyswietlReceStrz();
		System.out.format("0. - wróc do straganów%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuArmor();
		else {
			try {
				if(kupRece(sklep.kupReceStrz(in))) {
					System.out.format("Kupiono!");
					Thread.sleep(2000);
				}
				else {
					System.out.format("Za ma³o z³ota");
					Thread.sleep(2000);
				}
			}
			catch(IndexOutOfBoundsException e) {
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
		sklep.wyswietlNogiStrz();
		System.out.format("0. - wróc do straganów%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuArmor();
		else {
			try {
				if(kupNogi(sklep.kupNogiStrz(in))) {
					System.out.format("Kupiono!");
					Thread.sleep(2000);
				}
				else {
					System.out.format("Za ma³o z³ota");
					Thread.sleep(2000);
				}
			}
			catch(IndexOutOfBoundsException e) {
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
		sklep.wyswietlGlowaStrz();
		System.out.format("0. - wróc do straganów%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuArmor();
		else {
			try {
				if(kupStopy(sklep.kupStopyStrz(in))) {
					System.out.format("Kupiono!");
					Thread.sleep(2000);
				}
				else {
					System.out.format("Za ma³o z³ota");
					Thread.sleep(2000);
				}
			}
			catch(IndexOutOfBoundsException e) {
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
	public void menuSklepuZDodatkami() {
		Gra.clearScreen();
		wyswietlZloto();
		wyswietlAktualneDodatkowe();
		sklep.wyswietlDodatkoweStrz();
		System.out.format("0. - wróc%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuGlowne();
		else {
			try {
				if(kupDodatkowe(sklep.kupDodatkoweStrz(in))) {
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
		System.out.format("0. - wroæ%nStrzelec%n");
		wyswietlStatystyki();
		int in = Gra.getInput();
		
		if(in == 0) menuGlowne();
		else statystyki();
	}

}
