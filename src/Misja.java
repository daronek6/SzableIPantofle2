
public class Misja {
	private String nazwa;
	private String opis;
	private int doswiadczenie;
	private int zloto;
	
	public Misja(String n, String o, int d, int z) {
		nazwa = n;
		opis = o;
		doswiadczenie = d;
		zloto = z;
	}
	
	public int zwrocDoswiadczenie() {
		return doswiadczenie;
	}
	
	public int zwrocZloto() {
		return zloto;
	}
	
	public void opisMisji() {
		System.out.format("%s: %n %s %n Doœwiadczenie: %d, Z³oto: %d%n",nazwa,opis,doswiadczenie,zloto);
	}
}
