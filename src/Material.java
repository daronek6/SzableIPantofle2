
public class Material {
	private String nazwa;
	private int wartosc;
	
	public Material(String n, int w) {
		nazwa = n;
		wartosc = w;
	}
	
	public void wyswietlMaterial() {
		System.out.format("%s, warto��: %d%n",nazwa,wartosc);
	}
	
	public int zwrocWartosc() {
		return wartosc;
	}
}
