
public abstract class Dodatkowe {
	protected String nazwa;
	protected int cena;

	public Dodatkowe(String naz,int c) {
		nazwa = naz;
		cena = c;
	}
	
	public int zwrocCene() {
		return cena;
	}
	public String zwrocNazwe() {
		return nazwa;
	}
	
	public abstract void wyswietlWSklepie();
	public abstract void wyswietlStatystyki();
	public abstract int uzyj();
}
