
public class Ubranie {
	private String nazwa;
	
	private int redukcjaFiz;
	private int redukcjaMag;
	
	private int dodatkoweZdrowie;
	private int szansaNaUnik;
	
	private int cena;
	
	public Ubranie() {
		nazwa = "brak";
		redukcjaFiz = 0;
		redukcjaMag = 0;
		dodatkoweZdrowie = 0;
		szansaNaUnik = 0;
		cena = 0;
	}
	public Ubranie(String naz, int rF, int rM, int dZ, int sU, int c) {
		nazwa = naz;
		redukcjaFiz = rF;
		redukcjaMag = rM;
		dodatkoweZdrowie = dZ;
		szansaNaUnik = sU;
		cena = c;
	}
	public int zwrocCene() {
		return cena;
	}
	public int zwrocRedukcjeFiz() {
		return redukcjaFiz;
	}
	public int zwrocRedukcjeMag() {
		return redukcjaMag;
	}
	public int zwrocDodatkoweZdrowie() {
		return dodatkoweZdrowie;
	}
	public int zwrocSzanseNaUnik() {
		return szansaNaUnik;
	}
	
	public void wyswietlUbranieWSklepie() {
		System.out.format("%s - redukowanie obra¿eñ: fizycznych - %d, magicznych - %d ",
				nazwa,redukcjaFiz,redukcjaMag);
		if(dodatkoweZdrowie > 0) System.out.format("dodatkowe zdrowie: %d ",dodatkoweZdrowie);
		if(szansaNaUnik > 0) System.out.format("szansa na unik: %d ",szansaNaUnik);
		System.out.format("cena: %d%n",cena);
	}
	
	public void wyswietlStatystykiUbrania() {
		System.out.format("%s - redukowanie obra¿eñ: fizycznych - %d, magicznych - %d ",
				nazwa,redukcjaFiz,redukcjaMag);
		if(dodatkoweZdrowie > 0) System.out.format("dodatkowe zdrowie: %d ",dodatkoweZdrowie);
		if(szansaNaUnik > 0) System.out.format("szansa na unik: %d ",szansaNaUnik);
		System.out.format("wartoœæ: %d%n",(int)(cena*0.5));
	}
}
