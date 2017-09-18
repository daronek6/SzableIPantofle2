import java.util.Random;

public final class Szanse {
	private int szansaNaUnik;
	private int szansaNaOgluszenie;
	private int szansaNaZatrucie;
	private int szansaNaPodpalenie;
	
	public Szanse() {
		szansaNaOgluszenie = 0;
		szansaNaPodpalenie = 0;
		szansaNaUnik = 0;
		szansaNaZatrucie = 0;
	}
	
	private Random random;
	private int wylosowana;
	public Szanse(int unik, int ogluszenie, int zatrucie, int podpalenie) {
		szansaNaUnik = unik;
		szansaNaOgluszenie = ogluszenie;
		szansaNaZatrucie = zatrucie;
		szansaNaPodpalenie = podpalenie;
		random = new Random();
	}
	
	public boolean unik() {
		wylosowana = random.nextInt(100);
		if(wylosowana <= szansaNaUnik) {
			System.out.format("Unik !");
			return true;
		}
		else return false;
	}
	public boolean ogluszenie() {
		wylosowana = random.nextInt(100);
		if(wylosowana <= szansaNaOgluszenie) {
			System.out.format("Og³uszono !");
			return true;
		}
		else return false;
	}
	public boolean zatrucie() {
		wylosowana = random.nextInt(100);
		if(wylosowana <= szansaNaZatrucie) {
			System.out.format("Zatruto !");
			return true;
		}
		else return false;
	}
	public boolean podpalenie() {
		wylosowana = random.nextInt(100);
		if(wylosowana <= szansaNaPodpalenie) {
			System.out.format("Podpalono !");
			return true;
		}
		else return false;
	}
	
	public boolean ogluszenieMag(int czar) {
		wylosowana = random.nextInt(100) + 1;
		wylosowana += czar;
		if(wylosowana <= szansaNaOgluszenie) {
			System.out.format("Og³uszono !");
			return true;
		}
		else return false;
	}
	public boolean zatrucieMag(int czar) {
		wylosowana = random.nextInt(100) + 1;
		wylosowana += czar;
		if(wylosowana <= szansaNaZatrucie) {
			System.out.format("Zatruto !");
			return true;
		}
		else return false;
	}
	public boolean podpalenieMag(int czar) {
		wylosowana = random.nextInt(100) + 1;
		wylosowana += czar;
		if(wylosowana <= szansaNaPodpalenie) {
			System.out.format("Podpalono !");
			return true;
		}
		else return false;
	}
	
	public void aktualizujUnik(int unik) {
		szansaNaUnik += unik;
	}
	public void aktualizujOgluszenie(int og) {
		szansaNaOgluszenie += og;
	}
	public void aktualizujZatrucie(int zat) {
		szansaNaZatrucie += zat;
	}
	public void aktualizujPodpalenie(int pod) {
		szansaNaPodpalenie += pod;
	}
	
	public void wyswietlsSzanse() {
		if(szansaNaUnik > 0) {
			System.out.format("Szansa na unik: %d%n",szansaNaUnik);
		}
		if(szansaNaOgluszenie > 0) {
			System.out.format("Szansa na og³uszenie: %d%n",szansaNaOgluszenie);
		}
		if(szansaNaZatrucie > 0) {
			System.out.format("Szansa na zatrucie: %d%n",szansaNaZatrucie);
		}
		if(szansaNaPodpalenie > 0) {
			System.out.format("Szansa na podpalenie: %d%n",szansaNaPodpalenie);
		}
	}
	
	public void wyswietlOgluszenie() {
		System.out.print(szansaNaOgluszenie + "%");
	}
	
	public void wyswietlUnik() {
		System.out.print(szansaNaUnik + "%");
	}
	
	public void wyswietlZatrucie() {
		System.out.print(szansaNaZatrucie + "%");
	}
	
	public void wyswietlPodpalenie() {
		System.out.print(szansaNaPodpalenie + "%");
	}
}
