
public class EliksirMany extends Dodatkowe {
	private int mana;
	EliksirMany(String naz,int c, int ma) {
		super(naz,c);
		mana = ma;
	}
	@Override
	public void wyswietlWSklepie() {
		System.out.format("%s przywraca %d pkt. many, cena: %d%n",nazwa,mana,cena);
		
	}
	@Override
	public void wyswietlStatystyki() {
		System.out.format("%s przywraca %d pkt. many ",nazwa,mana);
		System.out.format("wartoœæ: %d%n",(int)(cena*0.5));
		
	}
	@Override
	public int uzyj() {
		
		return mana;
	}
}
