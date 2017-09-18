
public class EliksirZdrowia extends Dodatkowe{
	private int uzdrowienie;
	EliksirZdrowia(String naz,int c,int uzdr) {
		super(naz,c);
		uzdrowienie = uzdr;
	}

	@Override
	public void wyswietlWSklepie() {
		System.out.format("%s Przywraca %d pkt. zdrowia, cena: %d%n",nazwa,uzdrowienie,cena);
	}

	@Override
	public void wyswietlStatystyki() {
		System.out.format("%s Przywraca %d pkt. zdrowia ",nazwa,uzdrowienie);
		System.out.format("wartoœæ: %d%n",(int)(cena*0.5));
	}

	@Override
	public int uzyj() {
		 
		return uzdrowienie;
	}
}
