
public class Bron  {
	private String nazwa;
	
	private int minAtkFiz;
	private int maxAtkFiz;
	private int minAtkMag;
	private int maxAtkMag;
	
	private int zasieg;
	
	private int szansaNaOgluszenie;
	private int szansaNaZatrucie;
	private int szansaNaPodpalenie;
	
	private int cena;
	
	public Bron() {
		nazwa = "Piêœci";
		minAtkFiz = 1;
		maxAtkFiz = 5;
		minAtkMag = 0;
		maxAtkMag = 0;
		zasieg = 1;
		szansaNaOgluszenie = 0;
		szansaNaZatrucie = 0;
		szansaNaPodpalenie = 0;
		cena = 0;
	}
	public Bron(String n, int miAF, int maAF, int miAM, int maAM, int zas, int sO, int sZ, int sP, int c) {
		nazwa = n;
		minAtkFiz = miAF;
		maxAtkFiz = maAF;
		minAtkMag = miAM;
		maxAtkMag = maAM;
		zasieg = zas;
		szansaNaOgluszenie = sO;
		szansaNaZatrucie = sZ;
		szansaNaPodpalenie = sP;
		cena = c;
	}
	
	public int zwrocMinAtkFiz() {
		return minAtkFiz;
	}
	public int zwrocMaxAtkFiz() {
		return maxAtkFiz;
	}
	public int zwrocMinAtkMag() {
		return minAtkMag;
	}
	public int zwrocMaxAtkMag() {
		return maxAtkMag;
	}
	
	public int zwrocZasieg() {
		return zasieg;
	}
	
	public int zwrocSzanseNaOgluszenie() {
		return szansaNaOgluszenie;
	}
	public int zwrocSzanseNaZatrucie() {
		return szansaNaZatrucie;
	}
	public int zwrocSzanseNaPodpalenie() {
		return szansaNaPodpalenie;
	}
	
	public int zwrocCene() {
		return cena;
	}
	
	public void wyswietlWSklepie() {
		System.out.format("%s - obra¿enia fizyczne: %d-%d, obra¿enia magiczne: %d-%d, ", 
				nazwa,minAtkFiz,maxAtkFiz,minAtkMag,maxAtkMag);
		if(szansaNaOgluszenie > 0) System.out.format("szansa na ogluszenie: %d ", szansaNaOgluszenie);
		if(szansaNaZatrucie > 0) System.out.format("szansa na zatrucie: %d ", szansaNaZatrucie);
		if(szansaNaPodpalenie > 0) System.out.format("szansa na podpalenie %d ", szansaNaPodpalenie);
		System.out.format("cena: %d%n",cena);
	}
	
	public void wyswietlStatystykiBroni() {
		System.out.format("%s - obra¿enia fizyczne: %d-%d, obra¿enia magiczne: %d-%d, ", 
				nazwa,minAtkFiz,maxAtkFiz,minAtkMag,maxAtkMag);
		if(szansaNaOgluszenie > 0) System.out.format("szansa na ogluszenie: %d ", szansaNaOgluszenie);
		if(szansaNaZatrucie > 0) System.out.format("szansa na zatrucie: %d ", szansaNaZatrucie);
		if(szansaNaPodpalenie > 0) System.out.format("szansa na podpalenie %d ", szansaNaPodpalenie);
		System.out.format("wartoœæ: %d%n",(int)(cena*0.5));
	}
}
