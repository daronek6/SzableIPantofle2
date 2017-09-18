import java.util.Random;


public class Mag extends Postac {
	private int mana;
	private int aMana;
	private int regenMany;
	private Czar piorun;
	private Czar zatrucie;
	private Czar podpalenie;
	public Mag(String naz) {
		super(naz);
		szanse = new Szanse(0,0,1,1);
		podstawoweStatystykiPostaci();
		zalozBron(new Bron("ro¿dzka",0,0,2,3,2,0,0,0,0));
		zalozNaGlowe(new Ubranie("kapelusz",0,0,0,1,0));
		zalozNaNogi(new Ubranie("szorty",0,0,2,1,0));
		zalozNaKlate(new Ubranie("bezrêkawnik",1,1,0,0,0));
		zalozNaRece(new Ubranie("menelski rêkawiczki",1,0,0,1,0));
		zalozNaStopy(new Ubranie("sanda³y",0,0,0,2,0));
		zalozDodatkowe(new Ogluszajace("Kamien",0,10));
		//Czar(nzw,minAtk,maxAtk,szansaOg³,szansaZat,szansaPod,kosztMany,MAXPoz,przyrMinAtk,
		//przyrMaxAtk,przyrSNaOg³,przySNaZat,przyrSNaPodp,przyrkKosztMany,przyrKUlepszenia)
		piorun = new Czar("Piorun", 3, 6, 2, 0, 0, 9, 6, 1, 3, 2, 0, 0, 2, 50);
		zatrucie = new Czar("Truj¹ca chmura", 3, 6, 0, 3, 0, 10, 9, 1, 2, 0, 2, 0, 3, 40);
		podpalenie = new Czar("Ziew smoka", 1, 8, 0, 0, 1, 10, 8, 2, 3, 0, 0, 2, 2, 55);
	}
	
	@Override
	public void podstawoweStatystykiPostaci() {
		 mana = 40;
		 regenMany = 2;
		 maxZdrowie = 20;
		 aMinAtkFiz = 0;
		 aMaxAtkFiz = 0;
		 aMinAtkMag = 3;
		 aMaxAtkMag = 4;
		 aRedukcjaObrazenFiz = 0;
		 aRedukcjaObrazenMag = 1;
	}
	public void regenerujMane() {
		aMana += regenMany;
		if(aMana > mana) aMana = mana;
	}

	@Override
	public void levelUp() {
		 doswiadczenie -= wymaganeDoswiadczenie;
		 mana += 4;
		 regenMany += 1;
		 maxZdrowie += 5;
		 aMinAtkFiz += 0;
		 aMaxAtkFiz += 0;
		 aMinAtkMag += 2;
		 aMaxAtkMag += 3;
		 aRedukcjaObrazenFiz += 0;
		 aRedukcjaObrazenMag += 1;
		 poziom++;
		 wymaganeDoswiadczenie *= 1.5;
		 System.out.format("%s zdoby³ nowy poziom %d%n",imie,poziom);
	}

	@Override
	public void wyswietlStatystyki() {
		 System.out.format("%s poziom: %d%n pokonani przeciwnicy: %d%n atak fizyczny: %d - %d,  atak magiczny %d - %d, zdrowie: %d%n pancerz: %d, "
		 		+ "odpornosc na magie: %d%n mana: %d, regeneracja many: %d%n zloto: %d%n",imie,poziom,wygraneWalki,aMinAtkFiz,aMaxAtkFiz,aMinAtkMag,aMaxAtkMag,maxZdrowie,
		 		aRedukcjaObrazenFiz,aRedukcjaObrazenMag,mana,regenMany,zloto);
		 System.out.format("Doœwiadczenie: %d/%d%n",doswiadczenie,wymaganeDoswiadczenie);
		 szanse.wyswietlsSzanse();
		 bron.wyswietlStatystykiBroni();
		 glowa.wyswietlStatystykiUbrania();
		 klata.wyswietlStatystykiUbrania();
		 rece.wyswietlStatystykiUbrania();
		 nogi.wyswietlStatystykiUbrania();
		 stopy.wyswietlStatystykiUbrania();
		 if(dodatkowe != null) dodatkowe.wyswietlStatystyki();
	 }

	@Override
	public void menuGlowne() {
		Gra.clearScreen();
		System.out.format("Szable i pantofle 2, witaj magu %s%n",imie);
		System.out.format("1. Arena%n");
		System.out.format("2. Misje%n");
		System.out.format("3. Ró¿dzkarnia%n");
		System.out.format("4. Ulepszacz Gandalfa%n");
		System.out.format("5. Stylowe szaty magów%n");
		System.out.format("6. Sklep z dodatkami%n");
		System.out.format("7. Statystyki%n");
		System.out.format("8. Ekwipuek%n");
		System.out.format("9. Wyjdz z gry%n");
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
		ulepszCzary();
			break;
		case 5:
		menuArmor();
			break;
		case 6:
		menuSklepuZDodatkami();
			break;
		case 7:
		statystyki();
			break;
		case 8:
		ekwipunek();
			break;
		case 9:
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
		sklep.wyswietlBronieMag();
		System.out.format("0. - wróc%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuGlowne();
		else {
			try {
				if(kupBron(sklep.kupBronMag(in))) {
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
	public void menuSklepuZDodatkami() {
		Gra.clearScreen();
		wyswietlZloto();
		wyswietlAktualneDodatkowe();
		sklep.wyswietlDodatkoweMag();
		System.out.format("0. - wróc%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuGlowne();
		else {
			try {
				if(kupDodatkowe(sklep.kupDodatkoweMag(in))) {
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
		wyswietlStatystyki();
		System.out.format("Czary%n");
		piorun.wyswietlStatystyki();
		zatrucie.wyswietlStatystyki();
		podpalenie.wyswietlStatystyki();
		System.out.format("0. - wroæ%nMag%n");
		int in = Gra.getInput();
		
		if(in == 0) menuGlowne();
		else statystyki();
		
	}

	@Override
	public void armorGlowa() {
		Gra.clearScreen();
		wyswietlZloto();
		wyswietlAktualnaGlowe();
		sklep.wyswietlGlowaMag();
		System.out.format("0. - wróc do szatni%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuArmor();
		else {
			try {
				if(kupGlowa(sklep.kupGlowaMag(in))) {
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
		sklep.wyswietlKlataMag();
		System.out.format("0. - wróc do szatni%n");
		
		int in = Gra.getInput();
	
		if(in == 0) menuArmor();
		else {
			try {
				if(kupKlata(sklep.kupKlataMag(in))) {
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
		sklep.wyswietlReceMag();
		System.out.format("0. - wróc do szatni%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuArmor();
		else {
			try {
				if(kupRece(sklep.kupReceMag(in))) {
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
		sklep.wyswietlNogiMag();
		System.out.format("0. - wróc do szatni%n");
		
		int in = Gra.getInput();

		if(in == 0) menuArmor();
		else {
			try {
				if(kupNogi(sklep.kupNogiMag(in))) {
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
		sklep.wyswietlGlowaMag();
		System.out.format("0. - wróc do szatni%n");
		
		int in = Gra.getInput();
		
		if(in == 0) menuArmor();
		else {
			try {
				if(kupStopy(sklep.kupStopyMag(in))) {
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
	
	public void ulepszCzary() {
		Gra.clearScreen();
		wyswietlZloto();
		System.out.format("1. "); piorun.wyswietlWSklepie();
		System.out.format("2. "); zatrucie.wyswietlWSklepie();
		System.out.format("3. "); podpalenie.wyswietlWSklepie();
		System.out.format("0. - wróæ %n");
		
		switch(Gra.getInput()) {
		case 1:
			if(piorun.zwrocCeneUlepszenia() > zloto) {
				System.out.format("Za ma³o z³ota na ulepszenie");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally{
					ulepszCzary();
				}
			}
			else {
				if(piorun.czyMoznaUlepszyc()) {
					odejmijZloto(piorun.zwrocCeneUlepszenia());
					piorun.ulepsz();
					System.out.format("Ulepszono czar piorun");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					finally {
						ulepszCzary();
					}
				}
				else {
					ulepszCzary();
				}
			}
			break;
		case 2:
			if(zatrucie.zwrocCeneUlepszenia() > zloto) {
				System.out.format("Za ma³o z³ota na ulepszenie");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally{
					ulepszCzary();
				}
			}
			else {
				if(zatrucie.czyMoznaUlepszyc()) {
					odejmijZloto(zatrucie.zwrocCeneUlepszenia());
					zatrucie.ulepsz();
					System.out.format("Ulepszono czar Truj¹ca chmura");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					finally {
						ulepszCzary();
					}
				}
				else {
					ulepszCzary();
				}
			}
			break;
		case 3:
			if(podpalenie.zwrocCeneUlepszenia() > zloto) {
				System.out.format("Za ma³o z³ota na ulepszenie");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally{
					ulepszCzary();
				}
			}
			else {
				if(podpalenie.czyMoznaUlepszyc()) {
					odejmijZloto(podpalenie.zwrocCeneUlepszenia());
					podpalenie.ulepsz();
					System.out.format("Ulepszono czar Ziew smoka");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					finally {
						ulepszCzary();
					}
				}
				else {
					ulepszCzary();
				}
			}
			break;
		case 0:
			menuGlowne();
			
			break;
		default:
			ulepszCzary();
		}
		
	}
	
	public int atakPiorun() {
		Random random = new Random();
		int miA = piorun.zwrocCzarMinAtkMag() + aMinAtkMag;
		int maA = piorun.zwrocCzarMaxAtkMag() + aMaxAtkMag;
		
		return maA - random.nextInt(maA - miA + 1);
	}
	public int atakZatrucie() {
		Random random = new Random();
		int miA = zatrucie.zwrocCzarMinAtkMag() + aMinAtkMag;
		int maA = zatrucie.zwrocCzarMaxAtkMag() + aMaxAtkMag;
		
		return maA - random.nextInt(maA - miA + 1);
	}
	public int atakPodpalenie() {
		Random random = new Random();
		int miA = podpalenie.zwrocCzarMinAtkMag() + aMinAtkMag;
		int maA = podpalenie.zwrocCzarMaxAtkMag() + aMaxAtkMag;
		
		return maA - random.nextInt(maA - miA + 1);
	}
	
	@Override
	public Atak atak() {
		//Gra.clearScreen();
		Atak atak = new Atak(0, 0, false, false, false);
		boolean uzytoCzaru;
		do {
			uzytoCzaru = false;
			if(aMana >= piorun.zwrocCzarKosztMany()) {
				System.out.format("1. ");
				piorun.wyswietlStatystyki();
			}
			else{
				System.out.format("1. Za ma³o manu na u¿ycie %s%n",piorun.zwrocCzarNazwe());
			}
			if(aMana >= zatrucie.zwrocCzarKosztMany()) {
				System.out.format("2. ");
				zatrucie.wyswietlStatystyki();
			}
			else {
				System.out.format("2. Za ma³o manu na u¿ycie %s%n",zatrucie.zwrocCzarNazwe());
			}
			if(aMana >= podpalenie.zwrocCzarKosztMany()) {
				System.out.format("3. ");
				podpalenie.wyswietlStatystyki();
			}
			else {
				System.out.format("3. Za ma³o manu na u¿ycie %s%n",podpalenie.zwrocCzarNazwe());
			}
			
			System.out.format("0. - wróæ%n");
			switch(Gra.getInput()) {
			case 1:
				if(aMana >= piorun.zwrocCzarKosztMany()) {
					atak = new Atak(0,atakPiorun(),szanse.ogluszenieMag(piorun.zwrocCzarSzanseOgluszenie()),
							szanse.zatrucieMag(piorun.szansaNaZatrucie),
							szanse.podpalenieMag(piorun.zwrocCzarSzansePodpalenie()));
					uzytoCzaru = true;
					aMana -= piorun.zwrocCzarKosztMany();
				}
				break;
			case 2:
				if(aMana >= zatrucie.zwrocCzarKosztMany()) { 
					atak = new Atak(0,atakPiorun(),szanse.ogluszenieMag(zatrucie.zwrocCzarSzanseOgluszenie()),
							szanse.zatrucieMag(zatrucie.szansaNaZatrucie),
							szanse.podpalenieMag(zatrucie.zwrocCzarSzansePodpalenie()));
					uzytoCzaru = true;
					aMana -= zatrucie.zwrocCzarKosztMany();
				}
				
				break;	
			case 3:
				if(aMana >= podpalenie.zwrocCzarKosztMany()) {
					atak = new Atak(0,atakPiorun(),szanse.ogluszenieMag(podpalenie.zwrocCzarSzanseOgluszenie()),
							szanse.zatrucieMag(podpalenie.szansaNaZatrucie),
							szanse.podpalenieMag(podpalenie.zwrocCzarSzansePodpalenie()));
					uzytoCzaru = true;
					aMana -= podpalenie.zwrocCzarKosztMany();
				}
				break;
			case 0:
				uzytoCzaru = true;
				break;
				
			default:
				uzytoCzaru = false;
			}
			
		}while(!uzytoCzaru);
		return atak;
	}
	@Override
	public void przywrocMane() {
		int mn = dodatkowe.uzyj();
		aMana += mn;
		if(aMana > mana) aMana = mana;
		dodatkowe = null;
	}
	
	public void przygotujDoWalki() {
		 aktualneZdrowie = maxZdrowie;
		 aMana = mana;
	 }
	
	public int zwrocAktualnaMane() {
		return aMana;
	}
	public int zwrocMane() {
		return mana;
	}
	
}