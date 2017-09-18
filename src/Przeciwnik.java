import java.util.Random;

public class Przeciwnik {
	private String imie;
	private int miAF;
	private int miAM;
	private int maAF;
	private int maAM;
	
	private int zasieg;
	
	private int zdrowie;
	private int aktualneZdrowie;
	
	private int redukcjaFizyczna;
	private int redukcjaMagiczna;
	
	private Szanse szanse;
	protected Efekty efekty;
	
	public Przeciwnik(String im, int miAF, int miAM, int maAF, int maAM, int za, int zd, int rF, int rM,
			int sU, int sO, int sZ, int sP) {
		imie = im;
		this.miAF = miAF;
		this.miAM = miAM;
		this.maAF = maAF;
		this.maAM = maAM;
		zasieg = za;
		zdrowie = zd;
		aktualneZdrowie = zd;
		redukcjaFizyczna = rF;
		redukcjaMagiczna = rM;
		szanse = new Szanse(sU,sO,sZ,sP);
		efekty = new Efekty();
	}
	
	public int zwrocZasieg() {
		return zasieg;
	}
	
	public String zwrocImie() {
		return imie;
	}
	
	public int zwrocAktualneZdrowie() {
		return aktualneZdrowie;
	}
	
	public Atak atak() {
		 Random random = new Random();
		 int fiz = maAF - random.nextInt(maAF-miAF+1);
		 int mag = maAM - random.nextInt(maAM-miAM+1);
		 return new Atak(fiz,mag,szanse.ogluszenie(),szanse.zatrucie(),szanse.podpalenie());
	 }
	
	public void odejmijZdrowie(int atk) {
		 aktualneZdrowie -= atk;
	 }
	
	public void otrzymajObrazenia(Atak atk) {
		 int atkF = 0; 
		 int atkM = 0;
		 if(atk.zwrocAtakFizyczny() > redukcjaFizyczna) atkF = atk.zwrocAtakFizyczny() - redukcjaFizyczna;
		 if(atk.zwrocAtakMagiczny() > redukcjaMagiczna) atkM = atk.zwrocAtakMagiczny() - redukcjaMagiczna;
		 
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
			 if((atkF + atkM) > redukcjaFizyczna) {
				 efekty.aktualizujZatrucie(true,(atkF + atkM) - redukcjaFizyczna);
				 System.out.format("%s zosta³ zatruty, obra¿enia od zatrucia %d%n",imie,(atkF + atkM) - redukcjaFizyczna);
			 }
			 else {
				 efekty.aktualizujZatrucie(true,1);
				 System.out.format("%s zosta³ zatruty, obra¿enia od zatrucia 1%n",imie);
			 }
		 }
		 if(atk.zwrocSzanseNaPodpalenie()) {
			 if((atkF + atkM) > redukcjaMagiczna) {
				 efekty.aktualizujZatrucie(true,(atkF + atkM) - redukcjaMagiczna);
				 System.out.format("%s zosta³ podpalony, obra¿enia od podpalenia %d%n",imie,(atkF + atkM) - redukcjaMagiczna);
			 }
			 else {
				 efekty.aktualizujZatrucie(true,1);
				 System.out.format("%s zosta³ podpalony, obra¿enia od podpalenia 1%n",imie);
			 }
		 }
	 }
	 
	 public void wyswietlInformacjePrzeciwnika() {
		 System.out.format("Przeciwnik %s%n",imie);
		 System.out.format("Atak fizyczny: %d - %d, atak magiczny: %d - %d%n",miAF,maAF,miAM,maAM);
		 System.out.format("Zdrowie: %d, Pancerz: %d, Obrona magiczna: %d%n",zdrowie,redukcjaFizyczna,redukcjaMagiczna);
		 szanse.wyswietlsSzanse();
	 }
	 
	 public void wyswietlInformacjeArenaImie() {
		 System.out.format("%s",imie);
	 }
	 
	 public void wyswietlInformacjeArenaZdrowie() {
		 System.out.format("%d/%d",aktualneZdrowie,zdrowie);
	 }
	 
	 public void wyswietlInformacjeArenaAtakFizyczny() {
		 System.out.format("%d - %d",miAF,maAF);
	 }
	 
	 public void wyswietlInformacjeArenaAtakMagiczny() {
		 System.out.format("%d - %d",miAM,maAM);
	 }
	 
	 public void wyswietlInformacjeArenaRedukcjaFizyczna() {
		 System.out.format("%d",redukcjaFizyczna);
	 }
	 
	 public void wyswietlInformacjeArenaRedukcjaMagiczna() {
		 System.out.format("%d",redukcjaMagiczna);
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
}
