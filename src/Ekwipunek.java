import java.util.ArrayList;
import java.util.List;

public class Ekwipunek {
	private List<Bron> bronie;
	private List<Ubranie> glowa;
	private List<Ubranie> klata;
	private List<Ubranie> rece;
	private List<Ubranie> nogi;
	private List<Ubranie> stopy;
	private List<Dodatkowe> dodatkowe;
	private List<Material> materialy;
	
	Ekwipunek() {
		bronie = new ArrayList<>();
		glowa = new ArrayList<>();
		klata = new ArrayList<>();
		rece = new ArrayList<>();
		nogi = new ArrayList<>();
		stopy = new ArrayList<>();
		dodatkowe = new ArrayList<>();
		materialy = new ArrayList<>();
	}
	
	public void dodajBronDoEkwipunku(Bron bron) {
		bronie.add(bron);
	}
	public void dodajGloweDoEkwipunku(Ubranie armor) {
		glowa.add(armor);
	}
	public void dodajKlateDoEkwipunku(Ubranie armor) {
		klata.add(armor);
	}
	public void dodajReceDoEkwipunku(Ubranie armor) {
		rece.add(armor);
	}
	public void dodajNogiDoEkwipunku(Ubranie armor) {
		nogi.add(armor);
	}
	public void dodajStopyDoEkwipunku(Ubranie armor) {
		stopy.add(armor);
	}
	public void dodajDodatkoweDoEkwipunku(Dodatkowe dod) {
		dodatkowe.add(dod);
	}
	public void dodajMaterialDoEkwipunku(Material mat) {
		materialy.add(mat);
	}
	
	public Bron zwrocIUsunBron(int index) throws IndexOutOfBoundsException{
		Bron pom = bronie.get(index - 1);
		bronie.remove(index - 1);
		return pom;
	}
	public Ubranie zwrocIUsunGlowe(int index) throws IndexOutOfBoundsException{
		Ubranie pom = glowa.get(index - 1);
		glowa.remove(index - 1);
		return pom;
	}
	public Ubranie zwrocIUsunKlate(int index) throws IndexOutOfBoundsException{
		Ubranie pom = klata.get(index - 1);
		klata.remove(index - 1);
		return pom;
	}
	public Ubranie zwrocIUsunRece(int index) throws IndexOutOfBoundsException{
		Ubranie pom = rece.get(index - 1);
		rece.remove(index - 1);
		return pom;
	}
	public Ubranie zwrocIUsunNogi(int index) throws IndexOutOfBoundsException{
		Ubranie pom = nogi.get(index - 1);
		nogi.remove(index - 1);
		return pom;
	}
	public Ubranie zwrocIUsunStopy(int index) throws IndexOutOfBoundsException{
		Ubranie pom = stopy.get(index - 1);
		stopy.remove(index - 1);
		return pom;
	}
	public Dodatkowe zwrocIUsunDodatkowe(int index) throws IndexOutOfBoundsException{
		Dodatkowe pom = dodatkowe.get(index - 1);
		dodatkowe.remove(index - 1);
		return pom;
	}
	
	public int sprzedajBronZEkwipunku(int index) throws IndexOutOfBoundsException {
		int kasa = bronie.get(index - 1).zwrocCene();
		kasa *= 0.5;
		bronie.remove(index - 1);
		return kasa;
	}
	public int sprzedajGlowaZEkwipunku(int index) throws IndexOutOfBoundsException {
		int kasa = glowa.get(index - 1).zwrocCene();
		kasa *= 0.5;
		glowa.remove(index - 1);
		return kasa;
	}
	public int sprzedajKlataZEkwipunku(int index) throws IndexOutOfBoundsException {
		int kasa = klata.get(index - 1).zwrocCene();
		kasa *= 0.5;
		klata.remove(index - 1);
		return kasa;
	}
	public int sprzedajReceZEkwipunku(int index) throws IndexOutOfBoundsException {
		int kasa = rece.get(index - 1).zwrocCene();
		kasa *= 0.5;
		rece.remove(index - 1);
		return kasa;
	}
	public int sprzedajNogiZEkwipunku(int index) throws IndexOutOfBoundsException {
		int kasa = nogi.get(index - 1).zwrocCene();
		kasa *= 0.5;
		nogi.remove(index - 1);
		return kasa;
	}
	public int sprzedajStopyZEkwipunku(int index) throws IndexOutOfBoundsException {
		int kasa = stopy.get(index - 1).zwrocCene();
		kasa *= 0.5;
		stopy.remove(index - 1);
		return kasa;
	}
	public int sprzedajDodatkoweZEkwipunku(int index) throws IndexOutOfBoundsException {
		int kasa = dodatkowe.get(index - 1).zwrocCene();
		kasa *= 0.5;
		dodatkowe.remove(index - 1);
		return kasa;
	}
	public int sprzedajMaterialZEkwipunku(int index) throws IndexOutOfBoundsException {
		int kasa = materialy.get(index - 1).zwrocWartosc();
		materialy.remove(index - 1);
		return kasa;
	}
	
	public void wyswietlBronie() {
		int index = 1;
		for(Bron bron: bronie) {
			System.out.format("%d. ", index);
			bron.wyswietlStatystykiBroni();
			index++;
		}
	}
	public void wyswietlGlowe() {
		int index = 1;
		for(Ubranie armor: glowa) {
			System.out.format("%d. ", index);
			armor.wyswietlStatystykiUbrania();
			index++;
		}
	}
	public void wyswietlKlate() {
		int index = 1;
		for(Ubranie armor: klata) {
			System.out.format("%d. ", index);
			armor.wyswietlStatystykiUbrania();
			index++;
		}
	}
	public void wyswietlRece() {
		int index = 1;
		for(Ubranie armor: rece) {
			System.out.format("%d. ", index);
			armor.wyswietlStatystykiUbrania();
			index++;
		}
	}
	public void wyswietlNogi() {
		int index = 1;
		for(Ubranie armor: nogi) {
			System.out.format("%d. ", index);
			armor.wyswietlStatystykiUbrania();
			index++;
		}
	}
	public void wyswietlStopy() {
		int index = 1;
		for(Ubranie armor: stopy) {
			System.out.format("%d. ", index);
			armor.wyswietlStatystykiUbrania();
			index++;
		}
	}
	public void wyswietlDodatkowe() {
		int index = 1;
		for(Dodatkowe dod: dodatkowe) {
			System.out.format("%d. ", index);
			dod.wyswietlStatystyki();
			index++;
		}
	}
	public void wyswietlMaterialy() {
		int index = 1;
		for(Material mat: materialy) {
			System.out.format("%d. ", index);
			mat.wyswietlMaterial();
			index++;
		}
	}
}
