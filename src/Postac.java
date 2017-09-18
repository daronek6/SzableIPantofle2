import java.io.IOException;
import java.util.Random;

public abstract class Postac {
	protected String imie;
	
	protected int maxZdrowie;
	protected int aktualneZdrowie;
	
	protected int aMinAtkFiz;
	protected int aMaxAtkFiz;
	protected int aMinAtkMag;
	protected int aMaxAtkMag;
	
	protected int aRedukcjaObrazenFiz;
	protected int aRedukcjaObrazenMag;
	
	private int zasieg;
	
	protected int zloto;
	protected int poziom;
	protected int doswiadczenie;
	protected int wymaganeDoswiadczenie;
	
	protected int wygraneWalki;
	protected boolean dostepnaMisja;
	
	protected Szanse szanse;
	protected Efekty efekty;
	
	protected Bron bron;
	protected Ubranie glowa;
	protected Ubranie klata;
	protected Ubranie rece;
	protected Ubranie nogi;
	protected Ubranie stopy;
	protected Dodatkowe dodatkowe;
	protected Sklep sklep;
	protected Misja misja;
	protected Arena arena;
	protected Ekwipunek ekwipunek;
	public Postac(String naz) {
		imie = naz;
		zloto = 20;
		poziom = 1;
		doswiadczenie = 0;
		wymaganeDoswiadczenie = 50;
		wygraneWalki = 0;
		dostepnaMisja = false;
		sklep = new Sklep();
		ekwipunek = new Ekwipunek();
		efekty = new Efekty();
		stworzNowaArene();
	}
	
	public String zwrocImie() {
		return imie;
	}
	//Zak³adanie broni
	public void zalozBron(Bron b) {
		bron = b;
		aMinAtkFiz += b.zwrocMinAtkFiz();
		aMaxAtkFiz += b.zwrocMaxAtkFiz();
		aMinAtkMag += b.zwrocMinAtkMag();
		aMaxAtkMag += b.zwrocMaxAtkMag();
		zasieg = b.zwrocZasieg();
		
		szanse.aktualizujOgluszenie(b.zwrocSzanseNaOgluszenie());
		szanse.aktualizujPodpalenie(b.zwrocSzanseNaPodpalenie());
		szanse.aktualizujZatrucie(b.zwrocSzanseNaZatrucie());
	}
	//Zdejmowanie broni
	public void zdejmijBron() {
		aMinAtkFiz -= bron.zwrocMinAtkFiz();
		aMaxAtkFiz -= bron.zwrocMaxAtkFiz();
		aMinAtkMag -= bron.zwrocMinAtkMag();
		aMaxAtkMag -= bron.zwrocMaxAtkMag();
		
		szanse.aktualizujOgluszenie(-bron.zwrocSzanseNaOgluszenie());
		szanse.aktualizujPodpalenie(-bron.zwrocSzanseNaPodpalenie());
		szanse.aktualizujZatrucie(-bron.zwrocSzanseNaZatrucie());
		zasieg = 1;
		//ekwipunek.dodajBronDoEkwipunku(bron);
		
		bron = new Bron();
	}
	//Zak³adanie i zdejmowanie ró¿nych elementów ubrania ---------------------------------------
	public void zalozNaGlowe(Ubranie armor) {
		glowa = armor;
		maxZdrowie += armor.zwrocDodatkoweZdrowie();
		aRedukcjaObrazenFiz +=  armor.zwrocRedukcjeFiz();
		aRedukcjaObrazenMag +=  armor.zwrocRedukcjeMag();
		szanse.aktualizujUnik(armor.zwrocSzanseNaUnik());
	}
	
	public void zdejmijZGlowy() {
		maxZdrowie -= glowa.zwrocDodatkoweZdrowie();
		aRedukcjaObrazenFiz -=  glowa.zwrocRedukcjeFiz();
		aRedukcjaObrazenMag -=  glowa.zwrocRedukcjeMag();
		szanse.aktualizujUnik(-glowa.zwrocSzanseNaUnik());
		//ekwipunek.dodajGloweDoEkwipunku(glowa);
		
		glowa = new Ubranie();
	}
	
	public void zalozNaKlate(Ubranie armor) {
		klata = armor;
		maxZdrowie += armor.zwrocDodatkoweZdrowie();
		aRedukcjaObrazenFiz +=  armor.zwrocRedukcjeFiz();
		aRedukcjaObrazenMag +=  armor.zwrocRedukcjeMag();
		szanse.aktualizujUnik(armor.zwrocSzanseNaUnik());
	}
	
	public void zdejmijZKlaty() {
		maxZdrowie -= klata.zwrocDodatkoweZdrowie();
		aRedukcjaObrazenFiz -=  klata.zwrocRedukcjeFiz();
		aRedukcjaObrazenMag -=  klata.zwrocRedukcjeMag();
		szanse.aktualizujUnik(-klata.zwrocSzanseNaUnik());
		//ekwipunek.dodajKlateDoEkwipunku(klata);
		
		klata = new Ubranie();
	}
	
	public void zalozNaRece(Ubranie armor) {
		rece = armor;
		maxZdrowie += armor.zwrocDodatkoweZdrowie();
		aRedukcjaObrazenFiz +=  armor.zwrocRedukcjeFiz();
		aRedukcjaObrazenMag +=  armor.zwrocRedukcjeMag();
		szanse.aktualizujUnik(armor.zwrocSzanseNaUnik());
	}
	
	public void zdejmijZRak() {
		maxZdrowie -= rece.zwrocDodatkoweZdrowie();
		aRedukcjaObrazenFiz -=  rece.zwrocRedukcjeFiz();
		aRedukcjaObrazenMag -=  rece.zwrocRedukcjeMag();
		szanse.aktualizujUnik(-rece.zwrocSzanseNaUnik());
		//ekwipunek.dodajReceDoEkwipunku(rece);
		
		rece = new Ubranie();
	}
	
	public void zalozNaNogi(Ubranie armor) {
		nogi = armor;
		maxZdrowie += armor.zwrocDodatkoweZdrowie();
		aRedukcjaObrazenFiz +=  armor.zwrocRedukcjeFiz();
		aRedukcjaObrazenMag +=  armor.zwrocRedukcjeMag();
		szanse.aktualizujUnik(armor.zwrocSzanseNaUnik());
	}
	
	public void zdejmijZNog() {
		maxZdrowie -= nogi.zwrocDodatkoweZdrowie();
		aRedukcjaObrazenFiz -=  nogi.zwrocRedukcjeFiz();
		aRedukcjaObrazenMag -=  nogi.zwrocRedukcjeMag();
		szanse.aktualizujUnik(-nogi.zwrocSzanseNaUnik());
		//ekwipunek.dodajNogiDoEkwipunku(nogi);
		
		nogi = new Ubranie();
	}
	
	public void zalozNaStopy(Ubranie armor) {
		stopy = armor;
		maxZdrowie += armor.zwrocDodatkoweZdrowie();
		aRedukcjaObrazenFiz +=  armor.zwrocRedukcjeFiz();
		aRedukcjaObrazenMag +=  armor.zwrocRedukcjeMag();
		szanse.aktualizujUnik(armor.zwrocSzanseNaUnik());
	}
	
	public void zdejmijZeStop() {
		maxZdrowie -= stopy.zwrocDodatkoweZdrowie();
		aRedukcjaObrazenFiz -=  stopy.zwrocRedukcjeFiz();
		aRedukcjaObrazenMag -=  stopy.zwrocRedukcjeMag();
		szanse.aktualizujUnik(-stopy.zwrocSzanseNaUnik());
		//ekwipunek.dodajStopyDoEkwipunku(stopy);
		
		stopy = new Ubranie();
	}
	
	public void zalozDodatkowe(Dodatkowe dod) {
		dodatkowe = dod;
	}
	public void zdejmijDodatkowe() {
		//ekwipunek.dodajDodatkoweDoEkwipunku(dodatkowe);
		dodatkowe = null;
	}
	public boolean czyMaDodatkowe() {
		if(dodatkowe == null) return false;
		else return true;
	}
	
	public void ulecz() {
		aktualneZdrowie += dodatkowe.uzyj();
		if(aktualneZdrowie > maxZdrowie) aktualneZdrowie = maxZdrowie;
		dodatkowe = null;
	}
	
	public void przywrocMane() {
		//To dla maga
	}
	
	public int zwrocAktualneZdrowie() {
		return aktualneZdrowie;
	}
	
	public int uzyjBomby() {
		int czyStun = dodatkowe.uzyj();
		dodatkowe = null;
		return czyStun;
	}
	
	//Koniec zak³adania i zdejmowania ró¿nych elementów ubrania ---------------------------------------
	//Zamiana uzbrojenia z ekwipunku -------------------------------------------
	public void zamienBron(Bron bron) {
		ekwipunek.dodajBronDoEkwipunku(this.bron);
		zdejmijBron();
		zalozBron(bron);
	}
	public void zamienGlowe(Ubranie armor) {
		ekwipunek.dodajGloweDoEkwipunku(glowa);
		zdejmijZGlowy();
		zalozNaGlowe(armor);
	}
	public void zamienKlate(Ubranie armor) {
		ekwipunek.dodajKlateDoEkwipunku(klata);
		zdejmijZKlaty();
		zalozNaKlate(armor);
	}
	public void zamienRece(Ubranie armor) {
		ekwipunek.dodajReceDoEkwipunku(rece);
		zdejmijZRak();
		zalozNaRece(armor);
	}
	public void zamienNogi(Ubranie armor) {
		ekwipunek.dodajNogiDoEkwipunku(nogi);
		zdejmijZNog();
		zalozNaNogi(armor);
	}
	public void zamienStopy(Ubranie armor) {
		ekwipunek.dodajStopyDoEkwipunku(stopy);
		zdejmijZeStop();
		zalozNaStopy(armor);
	}
	
	public void zmienDodatkowe(Dodatkowe dod) {
		ekwipunek.dodajDodatkoweDoEkwipunku(dodatkowe);
		zdejmijDodatkowe();
		zalozDodatkowe(dod);
	}
	//Koniec zamiany uzbrojenia z ekwipunku ------------------------------------
	
	//Funkcja, która wywo³uje siê wraz ze stworzeniem postaci. Dla ka¿dej profesjii bêdzie ustawia³a inne wartoœci
	 void podstawoweStatystykiPostaci() {
		 maxZdrowie = 20;
		 aMinAtkFiz = 1;
		 aMaxAtkFiz = 5;
		 aMinAtkMag = 0;
		 aMaxAtkMag = 0;
		 aRedukcjaObrazenFiz = 1;
		 aRedukcjaObrazenMag = 1;
	 }
	 //Wyswietl statystyki -------------------------------------------
	 public void wyswietlStatystyki() {
		 System.out.format("%s poziom: %d%n pokonani przeciwnicy: %d%n atak fizyczny: %d - %d,  atak magiczny %d - %d, zdrowie: %d%n pancerz: %d, "
		 		+ "odpornosc na magie: %d%n zloto: %d%n ",imie,poziom,wygraneWalki,aMinAtkFiz,aMaxAtkFiz,aMinAtkMag,aMaxAtkMag,maxZdrowie,
		 		aRedukcjaObrazenFiz,aRedukcjaObrazenMag,zloto);
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
	 
	 public void wyswietlAktualnaBron() {
		 bron.wyswietlStatystykiBroni();
	 }
	 public void wyswietlAktualnaGlowe() {
		 glowa.wyswietlStatystykiUbrania();
	 }
	 public void wyswietlAktualnaKlate() {
		 klata.wyswietlStatystykiUbrania();
	 }
	 public void wyswietlAktualneRece() {
		 rece.wyswietlStatystykiUbrania();
	 }
	 public void wyswietlAktualnaNogi() {
		 nogi.wyswietlStatystykiUbrania();
	 }
	 public void wyswietlAktualneStopy() {
		 stopy.wyswietlStatystykiUbrania();
	 }
	 public void wyswietlAktualneDodatkowe() {
		 if(dodatkowe != null) {
			 dodatkowe.wyswietlStatystyki();
		 }
	 }
	 
	 //Zwroc poziom postaci------------------------------------------------
	 public int zwrocPoziom() {
		 return poziom;
	 }
	 //Wyœwietl z³oto --------------------------------
	 public void wyswietlZloto() {
		 System.out.format("Z³oto: %d%n", zloto);
	 }
	 //Zdobycie doswiadczenia, zlota i poziomów---------------------------------------------------
	 public abstract void levelUp();
	 
	 public void dodajDoswiadczenie(int dos) {
		 doswiadczenie += dos;
	 }
	 public void dodajZloto(int zl) {
		 zloto += zl;
	 }
	 public void odejmijZloto(int zl) {
		 zloto -= zl;
	 }
	 public void czyZdobytoPoziom(int dos){
		 dodajDoswiadczenie(dos);
		 if(doswiadczenie >= wymaganeDoswiadczenie) {
			 levelUp();
		 }
	 }
	 // Atak i otrzymywanie obrazen
	 public int zwrocZasieg() {
		 return zasieg;
	 }
	 
	 public void odejmijZdrowie(int atk) {
		 aktualneZdrowie -= atk;
	 }
	 
	 public Atak atak() {
		 Random random = new Random();
		 int fiz = aMaxAtkFiz - random.nextInt(aMaxAtkFiz-aMinAtkFiz+1);
		 int mag = aMaxAtkMag - random.nextInt(aMinAtkMag-aMinAtkMag+1);
		 return new Atak(fiz,mag,szanse.ogluszenie(),szanse.zatrucie(),szanse.podpalenie());
	 }
	 public void otrzymajObrazenia(Atak atk) {
		 int atkF = 0; 
		 int atkM = 0;
		 if(atk.zwrocAtakFizyczny() > aRedukcjaObrazenFiz) atkF = atk.zwrocAtakFizyczny() - aRedukcjaObrazenFiz;
		 if(atk.zwrocAtakMagiczny() > aRedukcjaObrazenMag) atkM = atk.zwrocAtakMagiczny() - aRedukcjaObrazenMag;
		 
		 if((atkF + atkM) == 0) System.out.format("%s nie otrzyma³ obra¿eñ%n",imie);
		 else {
			 aktualneZdrowie -= (atkF + atkM);
			 System.out.format("%s otrzyma³ %d obra¿eñ%n",imie,(atkF+atkM));
		 }
		 if(atk.zwrocSzanseNaOgluszenie()) {
			 efekty.aktualizujOgluszenie(true);
			 System.out.format("%s zosta³ og³uszony%n",imie);
		 }
		 if(atk.zwrocSzanseNaZatrucie()) {
			 if((atkF + atkM) > aRedukcjaObrazenFiz) {
				 efekty.aktualizujZatrucie(true,(atkF + atkM) - aRedukcjaObrazenFiz);
				 System.out.format("%s zosta³ zatruty, obra¿enia od zatrucia %d%n",imie,(atkF + atkM) - aRedukcjaObrazenFiz);
			 }
			 else {
				 efekty.aktualizujZatrucie(true,1);
				 System.out.format("%s zosta³ zatruty, obra¿enia od zatrucia 1%n",imie);
			 }
		 }
		 if(atk.zwrocSzanseNaPodpalenie()) {
			 if((atkF + atkM) > aRedukcjaObrazenMag) {
				 efekty.aktualizujZatrucie(true,(atkF + atkM) - aRedukcjaObrazenMag);
				 System.out.format("%s zosta³ podpalony, obra¿enia od podpalenia %d%n",imie,(atkF + atkM) - aRedukcjaObrazenMag);
			 }
			 else {
				 efekty.aktualizujZatrucie(true,1);
				 System.out.format("%s zosta³ podpalony, obra¿enia od podpalenia 1%n",imie);
			 }
		 }
	 }
	 //Menu i sklepy
	 
	 public abstract void menuGlowne();
	 public abstract void menuBronie();
	 public abstract void menuArmor();
	 public abstract void armorGlowa();
	 public abstract void armorKlata();
	 public abstract void armorRece();
	 public abstract void armorNogi();
	 public abstract void armorStopy();
	 public abstract void menuSklepuZDodatkami();
	 public abstract void statystyki();
	 
	//Kupowanie przedmiotów (sprawdzanie z³ota)
	 public boolean kupBron(Bron b) {
		 if(b.zwrocCene() > zloto) {
			 return false;
		 }
		 else {
			 if(bron.zwrocCene() == 0) {
				 zdejmijBron();
				 zalozBron(b);
				 odejmijZloto(b.zwrocCene());
			 }
			 else {
				 ekwipunek.dodajBronDoEkwipunku(bron);
				 zdejmijBron();
				 zalozBron(b);
				 odejmijZloto(b.zwrocCene());
			 }
			 return true;
		 }
	 }
	 
	 public boolean kupGlowa(Ubranie u) {
		 if(u.zwrocCene() > zloto) {
			 return false;
		 }
		 else {
			 if(glowa.zwrocCene() == 0) {
				 zdejmijZGlowy();
				 zalozNaGlowe(u);
			 }
			 else {
				 ekwipunek.dodajGloweDoEkwipunku(glowa);
				 zdejmijZGlowy();
				 zalozNaGlowe(u);
			 }
			 odejmijZloto(u.zwrocCene());
			 return true;
		 }
	 }
	 
	 public boolean kupKlata(Ubranie u) {
		 if(u.zwrocCene() > zloto) {
			 return false;
		 }
		 else {
			 if(klata.zwrocCene() == 0) {
				 zdejmijZKlaty();
				 zalozNaKlate(u);
			 }
			 else {
				 ekwipunek.dodajKlateDoEkwipunku(glowa);
				 zdejmijZKlaty();
				 zalozNaKlate(u);
			 }
			 odejmijZloto(u.zwrocCene());
			 return true;
		 }
	 }
	 
	 public boolean kupRece(Ubranie u) {
		 if(u.zwrocCene() > zloto) {
			 return false;
		 }
		 else {
			 if(rece.zwrocCene() == 0) {
				 zdejmijZRak();
				 zalozNaRece(u);
			 }
			 else {
				 ekwipunek.dodajReceDoEkwipunku(rece);
				 zdejmijZRak();
				 zalozNaRece(u);
			 }
			 odejmijZloto(u.zwrocCene());
			 return true;
		 }
	 }
	 
	 public boolean kupNogi(Ubranie u) {
		 if(u.zwrocCene() > zloto) {
			 return false;
		 }
		 else {
			 if(nogi.zwrocCene() == 0) {
				 zdejmijZNog();
				 zalozNaNogi(u);
			 }
			 else {
				 ekwipunek.dodajNogiDoEkwipunku(nogi);
				 zdejmijZNog();
				 zalozNaNogi(u);
			 }
			 odejmijZloto(u.zwrocCene());
			 return true;
		 }
	 }
	 
	 public boolean kupStopy(Ubranie u) {
		 if(u.zwrocCene() > zloto) {
			 return false;
		 }
		 else {
			 if(stopy.zwrocCene() == 0) {
				 zdejmijZeStop();
				 zalozNaStopy(u);
			 }
			 else {
				 ekwipunek.dodajStopyDoEkwipunku(stopy);
				 zdejmijZeStop();
				 zalozNaStopy(u);
			 }
			 odejmijZloto(u.zwrocCene());
			 return true;
		 }
	 }
	 
	 public boolean kupDodatkowe(Dodatkowe d) {
		 if(d.zwrocCene() > zloto) {
			 return false;
		 }
		 else {
			 ekwipunek.dodajDodatkoweDoEkwipunku(d);
			 odejmijZloto(d.zwrocCene());
			 return true;
		 }
	 }

		public void ekwipunek() {
			Gra.clearScreen();
			System.out.format("1. Zamieñ%n");
			System.out.format("2. Sprzedaj%n");
			System.out.format("0. - wróæ%n");
			
			switch(Gra.getInput()) {
			case 1:
			ekwipunekZamien();
				break;
			case 2:
				ekwipunekSprzedaj();
				break;
			case 0:
				menuGlowne();
				break;
			default:
				ekwipunek();	
			}
		}

		
		public void ekwipunekZamien() {
			Gra.clearScreen();
			System.out.format("Zamiana%n1. Bronie%n2. Obrona na g³owe%n3. Obrona na tu³ów%n4. Obrona na rêce%n"
					+ "5. Obrona na nogi%n6. Obrona na stopy%n7. Dodatkowe%n0. wróæ%n");
			switch(Gra.getInput()) {
			case 1:
				ekwipunekZamienBron();
				break;
			case 2:
				ekwipunekZamienGlowa();
				break;
			case 3:
				ekwipunekZamienKlata();
				break;
			case 4:
				ekwipunekZamienRece();
				break;
			case 5:
				ekwipunekZamienNogi();
				break;
			case 6:
				ekwipunekZamienStopy();
				break;
			case 7:
				ekwipunekZamienDodatkowe();
				break;
			case 0:
				ekwipunek();
				break;
			default:
				ekwipunekZamien();
			}
			
		}

		
		public void ekwipunekSprzedaj() {
			Gra.clearScreen();
			System.out.format("Sprzedarz%n1. Bronie%n2. Obrona na g³owe%n3. Obrona na tu³ów%n4. Obrona na rêce%n"
					+ "5. Obrona na nogi%n6. Obrona na stopy%n7. Dodatkowe%n8. Materialy%n0. wróæ%n");
			switch(Gra.getInput()) {
			case 1:
				ekwipunekSprzedajBron();
				break;
			case 2:
				ekwipunekSprzedajGlowa();
				break;
			case 3:
				ekwipunekSprzedajKlata();
				break;
			case 4:
				ekwipunekSprzedajRece();
				break;
			case 5:
				ekwipunekSprzedajNogi();
				break;
			case 6:
				ekwipunekSprzedajStopy();
				break;
			case 7:
				ekwipunekSprzedajDodatkowe();
				break;
			case 8:
				ekwipunekSprzedajMaterialy();
				break;
			case 0:
				ekwipunek();
				break;
			default:
				ekwipunekSprzedaj();
			}
		}

		
		public void ekwipunekZamienBron() {
			Gra.clearScreen();
			System.out.format("Zamieñ z za³o¿onym przedmiotem%n");
			ekwipunek.wyswietlBronie();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedaj();
			else {
				try {
					zamienBron(ekwipunek.zwrocIUsunBron(in));
					System.out.format("Zamieniono broñ!");
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekZamien();
				}
			}
		}

		
		public void ekwipunekZamienGlowa() {
			Gra.clearScreen();
			System.out.format("Zamieñ z za³o¿onym przedmiotem%n");
			ekwipunek.wyswietlGlowe();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedaj();
			else {
				try {
					zamienGlowe(ekwipunek.zwrocIUsunGlowe(in));
					System.out.format("Zamieniono ochrone g³owy!");
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekZamien();
				}
			}	
		}

		
		public void ekwipunekZamienKlata() {

			Gra.clearScreen();
			System.out.format("Zamieñ z za³o¿onym przedmiotem%n");
			ekwipunek.wyswietlKlate();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedaj();
			else {
				try {
					zamienKlate(ekwipunek.zwrocIUsunKlate(in));
					System.out.format("Zamieniono ochrone tu³owia!");
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekZamien();
				}
			}
		}

		
		public void ekwipunekZamienNogi() {

			Gra.clearScreen();
			System.out.format("Zamieñ z za³o¿onym przedmiotem%n");
			ekwipunek.wyswietlNogi();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedaj();
			else {
				try {
					zamienNogi(ekwipunek.zwrocIUsunNogi(in));
					System.out.format("Zamieniono ochrone nóg!");
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekZamien();
				}
			}
		}

		
		public void ekwipunekZamienRece() {

			Gra.clearScreen();
			System.out.format("Zamieñ z za³o¿onym przedmiotem%n");
			ekwipunek.wyswietlRece();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedaj();
			else {
				try {
					zamienRece(ekwipunek.zwrocIUsunRece(in));
					System.out.format("Zamieniono ochrone r¹k!");
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekZamien();
				}
			}
		}

		
		public void ekwipunekZamienStopy() {

			Gra.clearScreen();
			System.out.format("Zamieñ z za³o¿onym przedmiotem%n");
			ekwipunek.wyswietlStopy();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedaj();
			else {
				try {
					zamienStopy(ekwipunek.zwrocIUsunStopy(in));
					System.out.format("Zamieniono ochrone stóp!");
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekZamien();
				}
			}
		}

		
		public void ekwipunekZamienDodatkowe() {

			Gra.clearScreen();
			System.out.format("Zamieñ z za³o¿onym przedmiotem%n");
			ekwipunek.wyswietlDodatkowe();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedaj();
			else {
				try {
					zmienDodatkowe(ekwipunek.zwrocIUsunDodatkowe(in));
					System.out.format("Zamieniono dodatkowy przedmiot!");
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekZamien();
				}
			}
		}
		
		public void ekwipunekSprzedajBron() {

			Gra.clearScreen();
			System.out.format("Sprzedaj przedmioty z ekwipunku.%n");
			ekwipunek.wyswietlBronie();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedaj();
			else {
				try {
					int zl = ekwipunek.sprzedajBronZEkwipunku(in);
					dodajZloto(zl);
					System.out.format("Sprzedano broñ! Otrzymano %d z³ota",zl);
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekZamien();
				}
			}	
		}

		
		public void ekwipunekSprzedajGlowa() {
			
			Gra.clearScreen();
			System.out.format("Sprzedaj przedmioty z ekwipunku.%n");
			ekwipunek.wyswietlGlowe();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedaj();
			else {
				try {
					int zl = ekwipunek.sprzedajGlowaZEkwipunku(in);
					dodajZloto(zl);
					System.out.format("Sprzedano ubrojenie na g³owe! Otrzymano %d z³ota",zl);
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekSprzedaj();
				}
			}	
		}

		
		public void ekwipunekSprzedajKlata() {
	
			Gra.clearScreen();
			System.out.format("Sprzedaj przedmioty z ekwipunku.%n");
			ekwipunek.wyswietlKlate();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedaj();
			else {
				try {
					int zl = ekwipunek.sprzedajKlataZEkwipunku(in);
					dodajZloto(zl);
					System.out.format("Sprzedano ubrojenie na tu³ów! Otrzymano %d z³ota",zl);
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekSprzedaj();
				}
			}		
		}

		
		public void ekwipunekSprzedajNogi() {
	
			Gra.clearScreen();
			System.out.format("Sprzedaj przedmioty z ekwipunku.%n");
			ekwipunek.wyswietlNogi();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedaj();
			else {
				try {
					int zl = ekwipunek.sprzedajNogiZEkwipunku(in);
					dodajZloto(zl);
					System.out.format("Sprzedano ubrojenie na nogi! Otrzymano %d z³ota",zl);
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekSprzedaj();
				}
			}			
		}

		
		public void ekwipunekSprzedajRece() {

			Gra.clearScreen();
			System.out.format("Sprzedaj przedmioty z ekwipunku.%n");
			ekwipunek.wyswietlRece();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedaj();
			else {
				try {
					int zl = ekwipunek.sprzedajReceZEkwipunku(in);
					dodajZloto(zl);
					System.out.format("Sprzedano ubrojenie na rêce! Otrzymano %d z³ota",zl);
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekSprzedaj();
				}
			}			
		}

		
		public void ekwipunekSprzedajStopy() {

			Gra.clearScreen();
			System.out.format("Sprzedaj przedmioty z ekwipunku.%n");
			ekwipunek.wyswietlStopy();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedaj();
			else {
				try {
					int zl = ekwipunek.sprzedajStopyZEkwipunku(in);
					dodajZloto(zl);
					System.out.format("Sprzedano ubrojenie na stopy! Otrzymano %d z³ota",zl);
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekSprzedaj();
				}
			}			
		}
		
		public void ekwipunekSprzedajDodatkowe() {
	
			Gra.clearScreen();
			System.out.format("Sprzedaj przedmioty z ekwipunku.%n");
			ekwipunek.wyswietlDodatkowe();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedaj();
			else {
				try {
					int zl = ekwipunek.sprzedajDodatkoweZEkwipunku(in);
					dodajZloto(zl);
					System.out.format("Sprzedano dodatkowy przedmiot! Otrzymano %d z³ota",zl);
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekSprzedaj();
				}
			}		
		}
	 
		public void ekwipunekSprzedajMaterialy() {
	
			Gra.clearScreen();
			System.out.format("Sprzedaj materia³y z ekwipunku.%n");
			ekwipunek.wyswietlMaterialy();
			System.out.format("0. - wróæ%n");
			
			int in = Gra.getInput();
			if(in == 0) ekwipunekSprzedajMaterialy();
			else {
				try {
					int zl = ekwipunek.sprzedajMaterialZEkwipunku(in);
					dodajZloto(zl);
					System.out.format("Sprzedano materia³! Otrzymano %d z³ota",zl);
					Thread.sleep(2000);
				}
				catch(IndexOutOfBoundsException e) {
					
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					ekwipunekSprzedaj();
				}
			}		
		}
		
		public int wyjdzZGry() {
			try {
				System.in.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return 0;
		}
		
		public void menuMisji() {
			Gra.clearScreen();
			if(dostepnaMisja) {
				misja.opisMisji();
				System.out.format("1. wykonaj misjê%n");
				System.out.format("0. - wróæ%n");
				
				switch(Gra.getInput()) {
				case 1:
					wykonajMisje();
					break;
				case 0:
					menuGlowne();
					break;
				default:
					menuMisji();
				}
			}
			else {
				System.out.format("Aktualnie nie masz ¿adnej misji do wykonania%n"
						+ "Zaraz zostaniesz przeniesiony do menu g³ównego%n");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					menuGlowne();
				}
			}
		}
		
		public void menuAreny() {
			Gra.clearScreen();
			arena.wyswietlInformacjePrzedWalka();
			System.out.format("1. Akceptuj wyzwanie%n0. - wróæ%n");
			switch(Gra.getInput()) {
			case 1:
				przygotujDoWalki();
				if(arena.walka()) wygrana();
				else przegrana();
				break;
			case 0:
			menuGlowne();
				break;
			default:
			menuAreny();
			}
		}
		
		//Stworz misje
		public void stworzMisje() {
			if(wygraneWalki % 3 == 0) {
				System.out.format("Nowa misja!%n");
				dostepnaMisja = true;
				misja = new Misja("Misja","Brak",(int)((10 * poziom) * 0.8),(int)((15 * poziom) * 0.8 ));
			}
		}
		
		public void wykonajMisje() {
			Gra.clearScreen();
			Random random = new Random();
			dostepnaMisja = false;
			boolean wylosowanoMaterial = false;
			int wylosowana;
			do {
				wylosowana = random.nextInt(500);
				if(wylosowana == 222) {
					System.out.format("Zdobyto diament%n");
					ekwipunek.dodajMaterialDoEkwipunku(new Material("Diament",400));
					wylosowanoMaterial = true;
				}
				if(!wylosowanoMaterial) {
					wylosowana = random.nextInt(300);
					if(wylosowana == 0) {
						System.out.format("Zdobyto bursztyn%n");
						ekwipunek.dodajMaterialDoEkwipunku(new Material("Bursztyn",100));
						wylosowanoMaterial = true;
					}
					else if(wylosowana == 55) {
						System.out.format("Zdobyto wêgiel%n");
						ekwipunek.dodajMaterialDoEkwipunku(new Material("Wêgiel",50));
						wylosowanoMaterial = true;
					}
					else if(wylosowana == 122) {
						System.out.format("Zdobyto szmaragd%n");
						ekwipunek.dodajMaterialDoEkwipunku(new Material("Szmaragd",150));
						wylosowanoMaterial = true;
					}
					else if(wylosowana == 210) {
						System.out.format("Zdobyto rubin%n");
						ekwipunek.dodajMaterialDoEkwipunku(new Material("Rubin",200));
						wylosowanoMaterial = true;
					}
				}
				if(!wylosowanoMaterial) {
					wylosowana = random.nextInt(50);
					if(wylosowana == 7) {
						System.out.format("Zdobyto zardzewia³y metal%n");
						ekwipunek.dodajMaterialDoEkwipunku(new Material("Zardzewia³y metal",10));
					}
					else if(wylosowana == 32) {
						System.out.format("Zdobyto drewno%n");
						ekwipunek.dodajMaterialDoEkwipunku(new Material("Drewno",15));
					}
					wylosowanoMaterial = true;
				}
			} while(!wylosowanoMaterial);
			System.out.format("Zdobyto %d doœwiadczenia i %d z³ota%n",misja.zwrocDoswiadczenie(),misja.zwrocZloto());
			czyZdobytoPoziom(misja.zwrocDoswiadczenie());
			dodajZloto(misja.zwrocZloto());
			System.out.format("Wpisz cokolwiek, aby wróciæ do menu g³ównego%n");
			switch(Gra.getInput()) {
			default:
				menuGlowne();
			}
		}
		
		//Wyswietlanie specjalnie przygotowane do wali na arenie
		public void wyswietlInformacjeArenaImie() {
			 System.out.format("%s",imie);
		 }
		 
		 public void wyswietlInformacjeArenaZdrowie() {
			 System.out.format("%d/%d",aktualneZdrowie,maxZdrowie);
		 }
		 
		 public void wyswietlInformacjeArenaAtakFizyczny() {
			 System.out.format("%d - %d",aMinAtkFiz,aMaxAtkFiz);
		 }
		 
		 public void wyswietlInformacjeArenaAtakMagiczny() {
			 System.out.format("%d - %d",aMinAtkMag,aMaxAtkMag);
		 }
		 
		 public void wyswietlInformacjeArenaRedukcjaFizyczna() {
			 System.out.format("%d",aRedukcjaObrazenFiz);
		 }
		 
		 public void wyswietlInformacjeArenaRedukcjaMagiczna() {
			 System.out.format("%d",aRedukcjaObrazenMag);
		 }
		 
		 public void wyswietlInformacjeArenaOgluszenie() {
			 szanse.wyswietlOgluszenie();
		 }
		 
		 public void wyswietlInformacjeArenaUnik() {
			 szanse.wyswietlUnik();
		 }
		 
		 public void wyswietlInformacjeArenaZatrucie() {
			 szanse.wyswietlZatrucie();
		 }
		 
		 public void wyswietlInformacjeArenaPodpalenie() {
			 szanse.wyswietlPodpalenie();
		 }
		 
		 public void wyswietlInformacjeArenaCzyOgluszony() {
			 efekty.wyswietlCzyOgluszony();
		 }
		 
		 public void wyswietlInformacjeArenaCzyZatruty() {
			 efekty.wyswietlCzyZatruty();
		 }
		 
		 public void wyswietlInformacjeArenaCzyPodpalony() {
			 efekty.wyswietlCzyPodpalony();
		 }
		
		 //Tworzenie przeciwnikow na arene i areny
		 public Przeciwnik stworzPrzeciwnika() {
			 Random random = new Random();
			 int wyb = random.nextInt(3);
			 if(wyb == 0) {
				 return new Przeciwnik("Mag Czaruœ",0,1*poziom,0,(int)((3*poziom)*0.8),
						 2,20+(poziom*3),1*poziom,2*poziom,0,(int)(1+(poziom*0.9)),
						 1*poziom+2,1*poziom);
			 }
			 else if(wyb == 1) {
				 return new Przeciwnik("Strzelec Robin",(int)(1+(poziom*1.5)),0,(int)(1+(poziom*2)),0,
						 3,(int)(25+(poziom*3.5)),1*poziom,1*poziom,(int)(2+(poziom*1.2)),0,
						 (int)(3+(poziom*1.4)),0);
			 }
			 else {
				 return new Przeciwnik("Wojownik Stefix",poziom,0,(2 + (poziom*2)),0,
						 1,(int)(30+(poziom*4)),(int)(2+(poziom*1.5)),2+poziom,0,1+(poziom*2),
						 0,poziom);
			 }
		 }
		 
		 public void stworzNowaArene() {
			 Random random = new Random();
			 int zl = 10;
			 int dos = 20;
			 arena = new Arena(this,stworzPrzeciwnika(),
					 (zl*poziom) - random.nextInt((zl*poziom)-((zl*poziom)/2)+1),
					 dos - random.nextInt(11));
		 }
		 
		 public void wygrana() {
			 Gra.clearScreen();
			 wygraneWalki++;
			 czyZdobytoPoziom(arena.zwrocNagrodaDoswiadczenie());
			 stworzMisje();
			 dodajZloto(arena.zwrocNagrodaZloto());
			 System.out.format("%s otrzyma³ %d z³ota i %d doœwiadczenia%n",
					 imie,arena.zwrocNagrodaZloto(),arena.zwrocNagrodaDoswiadczenie());
			 stworzNowaArene();
			 System.out.format("Wpisz cokolwiek, aby wróciæ do menu g³ównego%n");
			 switch(Gra.getInput()) {
			 default:
				 menuGlowne();
			 }
		 }
		 
		 public void przegrana() {
			 Gra.clearScreen();
			 System.out.format("Przegrales. Twoje statystyki:%n");
			 wyswietlStatystyki();
			 wyjdzZGry();
		 }
		 
		 public void przygotujDoWalki() {
			 aktualneZdrowie = maxZdrowie;
		 }
}
