import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Sklep {
	Path sciezka;

	List<Bron> bronieWoj = new ArrayList<>();
	List<Bron> bronieStrz = new ArrayList<>();
	List<Bron> bronieMag = new ArrayList<>();
	
	List<Ubranie> glowaWoj = new ArrayList<>();
	List<Ubranie> glowaStrz = new ArrayList<>();
	List<Ubranie> glowaMag = new ArrayList<>();
	
	List<Ubranie> klataWoj = new ArrayList<>();
	List<Ubranie> klataStrz = new ArrayList<>();
	List<Ubranie> klataMag = new ArrayList<>();
	
	List<Ubranie> receWoj = new ArrayList<>();
	List<Ubranie> receStrz = new ArrayList<>();
	List<Ubranie> receMag = new ArrayList<>();
	
	List<Ubranie> nogiWoj = new ArrayList<>();
	List<Ubranie> nogiStrz = new ArrayList<>();
	List<Ubranie> nogiMag = new ArrayList<>();
	
	List<Ubranie> stopyWoj = new ArrayList<>();
	List<Ubranie> stopyStrz = new ArrayList<>();
	List<Ubranie> stopyMag = new ArrayList<>();
	
	List<Dodatkowe> dodatkoweWoj = new ArrayList<>();
	List<Dodatkowe> dodatkoweStrz = new ArrayList<>();
	List<Dodatkowe> dodatkoweMag = new ArrayList<>();
	
	
	public Sklep() {
		zaladujDaneDoSklepu();
	}
	
	public void zaladujDaneDoSklepu() {
		List<Bron> bron = null;
		List<Ubranie> ubranie = null;
		File source;
		for(int i=0;i<18;i++) {
			switch(i) {
			case 0:
				sciezka = Paths.get("bronieMag.txt");
				sciezka = sciezka.toAbsolutePath();
				bron = bronieMag;
				break;
			case 1:
				sciezka = Paths.get("bronieStrz.txt");
				sciezka = sciezka.toAbsolutePath();
				bron = bronieStrz;
				break;
			case 2:
				sciezka = Paths.get("bronieWoj.txt");
				sciezka = sciezka.toAbsolutePath();
				bron = bronieWoj;
				break;
			case 3:
				sciezka = Paths.get("glowaMag.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = glowaMag;
				break;
			case 4:
				sciezka = Paths.get("glowaStrz.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = glowaStrz;
				break;
			case 5:
				sciezka = Paths.get("glowaWoj.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = glowaWoj;
				break;
			case 6:
				sciezka = Paths.get("klataMag.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = klataMag;
				break;
			case 7:
				sciezka = Paths.get("klataStrz.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = klataStrz;
				break;
			case 8:
				sciezka = Paths.get("klataWoj.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = klataWoj;
				break;
			case 9:
				sciezka = Paths.get("nogiMag.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = nogiMag;
				break;
			case 10:
				sciezka = Paths.get("nogiStrz.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = nogiStrz;
				break;
			case 11:
				sciezka = Paths.get("nogiWoj.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = nogiWoj;
				break;
			case 12:
				sciezka = Paths.get("receMag.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = receMag;
				break;
			case 13:
				sciezka = Paths.get("receStrz.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = receStrz;
				break;
			case 14:
				sciezka = Paths.get("receWoj.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = receWoj;
				break;
			case 15:
				sciezka = Paths.get("stopyMag.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = stopyMag;
				break;
			case 16:
				sciezka = Paths.get("stopyStrz.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = stopyStrz;
				break;
			case 17:
				sciezka = Paths.get("stopyWoj.txt");
				sciezka = sciezka.toAbsolutePath();
				ubranie = stopyWoj;
				break;
			}
			source = sciezka.toFile();
			try(Scanner skaner = new Scanner(source)) {			
				int miAF;
				int maAF;
				int miAM;
				int maAM;
				int zasieg;
				int sO;
				int sZ;
				int sP;
				
				int rF;
				int rM;
				int dZ;
				int sU;
				
				String nazwa;
				int cena;
				if(i == 0 || i == 1 || i == 2) {
					do {
						nazwa = skaner.nextLine();
						miAF = skaner.nextInt();
						maAF = skaner.nextInt();
						miAM = skaner.nextInt();
						maAM = skaner.nextInt();
						zasieg = skaner.nextInt();
						sO = skaner.nextInt();
						sZ = skaner.nextInt();
						sP = skaner.nextInt();
						cena = skaner.nextInt();
						
						//System.out.format("%s %d %d %d %d %d %d %d %d %d",nazwa, miAF, maAF,
						//		miAM, maAM, zasieg, sO, sZ, sP, cena);
						bron.add(new Bron(nazwa, miAF, maAF, miAM, maAM, zasieg, sO, sZ, sP, cena));
					}while(skaner.hasNextLine());
				}
				else {
					do {
						nazwa = skaner.nextLine();
						rF = skaner.nextInt();
						rM = skaner.nextInt();
						dZ = skaner.nextInt();
						sU = skaner.nextInt();
						
						cena = skaner.nextInt();
						//System.out.format("%s %d %d %d %d %d",nazwa,rF,rM,dZ,sU,cena);
						Ubranie armor = new Ubranie(nazwa, rF, rM, dZ, sU, cena);
						ubranie.add(armor);
					}while(skaner.hasNext());
				}
			}
			catch(FileNotFoundException e) {
				System.out.format("Nie znaleziono pliku: %s",sciezka.toString());
			}
			catch(NoSuchElementException e) { };
		}
		
		dodatkoweWoj.add(new Ogluszajace("Kamieñ", 30, 10));
		dodatkoweWoj.add(new Ogluszajace("Bomba og³uszaj¹ca", 110, 50));
		dodatkoweWoj.add(new EliksirZdrowia("Ma³y eliksir zdrowia", 35, 10));
		dodatkoweWoj.add(new EliksirZdrowia("Du¿y eliksir zdrowia", 80, 25));
		
		dodatkoweStrz.add(new Ogluszajace("Kamieñ", 30, 10));
		dodatkoweStrz.add(new Ogluszajace("Bomba og³uszaj¹ca", 110, 50));
		dodatkoweStrz.add(new Ogluszajace("G³oœna tr¹ba", 160, 90));
		dodatkoweStrz.add(new EliksirZdrowia("Ma³y eliksir zdrowia", 45, 10));
		dodatkoweStrz.add(new EliksirZdrowia("Jab³ko zdrowia", 80, 20));
		
		dodatkoweMag.add(new EliksirZdrowia("Ma³y eliksir zdrowia", 35, 10));
		dodatkoweMag.add(new EliksirZdrowia("Ma³y eliksir many", 30, 10));
		dodatkoweMag.add(new EliksirZdrowia("Œredni eliksir many", 60, 22));
		dodatkoweMag.add(new EliksirZdrowia("Du¿y eliksir many", 100, 40));
	}
	// Wyœwietlanie informacji w sklepie -----------------------------------------------------
	public void wyswietlBronieWoj() {
		int index = 0;
		for(Bron bron: bronieWoj) {
			System.out.format("%d. - ",index + 1);
			bron.wyswietlWSklepie();
			index++;
		}
	}
	
	public void wyswietlBronieStrz() {
		int index = 0;
		for(Bron bron: bronieStrz) {
			System.out.format("%d. - ",index + 1);
			bron.wyswietlWSklepie();
			index++;
		}
	}
	
	public void wyswietlBronieMag() {
		int index = 0;
		for(Bron bron: bronieMag) {
			System.out.format("%d. - ",index + 1);
			bron.wyswietlWSklepie();
			index++;
		}
	}
	
	public void wyswietlGlowaMag() {
		int index = 0;
		for(Ubranie armor: glowaMag) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlGlowaStrz() {
		int index = 0;
		for(Ubranie armor: glowaStrz) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlGlowaWoj() {
		int index = 0;
		for(Ubranie armor: glowaWoj) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlKlataMag() {
		int index = 0;
		for(Ubranie armor: klataMag) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlKlataStrz() {
		int index = 0;
		for(Ubranie armor: klataStrz) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlKlataWoj() {
		int index = 0;
		for(Ubranie armor: klataWoj) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlReceMag() {
		int index = 0;
		for(Ubranie armor: receMag) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlReceStrz() {
		int index = 0;
		for(Ubranie armor: receStrz) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlReceWoj() {
		int index = 0;
		for(Ubranie armor: receWoj) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlNogiMag() {
		int index = 0;
		for(Ubranie armor: nogiMag) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlNogiStrz() {
		int index = 0;
		for(Ubranie armor: nogiStrz) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlNogiWoj() {
		int index = 0;
		for(Ubranie armor: nogiWoj) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlStopyMag() {
		int index = 0;
		for(Ubranie armor: stopyMag) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlStopyStrz() {
		int index = 0;
		for(Ubranie armor: stopyMag) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlStopyWoj() {
		int index = 0;
		for(Ubranie armor: stopyMag) {
			System.out.format("%d. - ",index + 1);
			armor.wyswietlUbranieWSklepie();
			index++;
		}
	}
	
	public void wyswietlDodatkoweMag() {
		int index = 0;
		for(Dodatkowe dod: dodatkoweMag) {
			System.out.format("%d. - ",index + 1);
			dod.wyswietlWSklepie();
			index++;
		}
	}
	
	public void wyswietlDodatkoweStrz() {
		int index = 0;
		for(Dodatkowe dod: dodatkoweStrz) {
			System.out.format("%d. - ",index + 1);
			dod.wyswietlWSklepie();
			index++;
		}
	}
	
	public void wyswietlDodatkoweWoj() {
		int index = 0;
		for(Dodatkowe dod: dodatkoweWoj) {
			System.out.format("%d. - ",index + 1);
			dod.wyswietlWSklepie();
			index++;
		}
	}
	// Koniec wyœwietlania informacji w sklepie -----------------------------------------------------
	
	public Bron kupBronWoj(int index) throws IndexOutOfBoundsException { 
		return bronieWoj.get(index - 1);
	}
	
	public Bron kupBronStrz(int index) throws IndexOutOfBoundsException {
		return bronieStrz.get(index - 1);
	}
	
	public Bron kupBronMag(int index) throws IndexOutOfBoundsException {
		return bronieMag.get(index - 1);
	}
	
	public Ubranie kupGlowaMag(int index) throws IndexOutOfBoundsException {
		return glowaMag.get(index - 1);
	}
	
	public Ubranie kupGlowaStrz(int index) throws IndexOutOfBoundsException {
		return glowaStrz.get(index - 1);
	}
	
	public Ubranie kupGlowaWoj(int index) throws IndexOutOfBoundsException {
		return glowaWoj.get(index - 1);
	}
	
	public Ubranie kupKlataMag(int index) throws IndexOutOfBoundsException {
		return klataMag.get(index - 1);
	}
	
	public Ubranie kupKlataStrz(int index) throws IndexOutOfBoundsException {
		return klataStrz.get(index - 1);
	}
	
	public Ubranie kupKlataWoj(int index) throws IndexOutOfBoundsException {
		return klataWoj.get(index - 1);
	}
	
	public Ubranie kupReceMag(int index) throws IndexOutOfBoundsException {
		return receMag.get(index - 1);
	}
	
	public Ubranie kupReceStrz(int index) throws IndexOutOfBoundsException {
		return receStrz.get(index - 1);
	}
	
	public Ubranie kupReceWoj(int index) throws IndexOutOfBoundsException {
		return receWoj.get(index - 1);
	}
	
	public Ubranie kupNogiMag(int index) throws IndexOutOfBoundsException {
		return nogiMag.get(index - 1);
	}
	
	public Ubranie kupNogiStrz(int index) throws IndexOutOfBoundsException {
		return nogiStrz.get(index - 1);
	}
	
	public Ubranie kupNogiWoj(int index) throws IndexOutOfBoundsException {
		return nogiWoj.get(index - 1);
	}
	
	public Ubranie kupStopyMag(int index) throws IndexOutOfBoundsException {
		return stopyMag.get(index - 1);
	}
	
	public Ubranie kupStopyStrz(int index) throws IndexOutOfBoundsException {
		return stopyStrz.get(index - 1);
	}
	
	public Ubranie kupStopyWoj(int index) throws IndexOutOfBoundsException {
		return stopyWoj.get(index - 1);
	}
	
	public Dodatkowe kupDodatkoweWoj(int index) throws IndexOutOfBoundsException {
		return dodatkoweWoj.get(index - 1);
	}
	
	public Dodatkowe kupDodatkoweStrz(int index) throws IndexOutOfBoundsException {
		return dodatkoweStrz.get(index - 1);
	}
	
	public Dodatkowe kupDodatkoweMag(int index) throws IndexOutOfBoundsException {
		return dodatkoweMag.get(index - 1);
	}
}
