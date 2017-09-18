
public class Czar {
	 protected String nazwa;
	 protected int poziom;
	 protected int minAtkMag;
	 protected int maxAtkMag;
	 
	 protected int szansaNaOgluszenie;
	 protected int szansaNaPodpalenie;
	 protected int szansaNaZatrucie;
	 
	 protected int kosztMany;
	 protected int kosztUlepszenia;
	 protected final int MAXPOZIOM;
	 
	 protected int przyrostMinAtkMag;
	 protected int przyrostMaxAtkMag;
	 protected int przyrostSNaOgluszenie;
	 protected int przyrostSNaZatrucie;
	 protected int przyrostSNaPodpalenie;
	 protected int przyrostKosztuMany;
	 protected int przyrostKosztuUlepszenia;
	 Czar(String naz, int miAM, int maAM, int sO, int sZ,int sP, int kM, int MP, int pMiAM,
			 int pMaAM,int pSO,int pSZ,int pSP,int pKM, int pKU) {
		 nazwa = naz;
		 poziom = 1;
		 minAtkMag = miAM;
		 maxAtkMag = maAM;
		 szansaNaOgluszenie = sO;
		 szansaNaPodpalenie = sP;
		 szansaNaZatrucie = sZ;
		 kosztMany = kM;
		 kosztUlepszenia = pKU;
		 przyrostKosztuMany = pKM;
		 MAXPOZIOM = MP;
		 przyrostMinAtkMag = pMiAM;
		 przyrostMaxAtkMag = pMaAM;
		 przyrostSNaOgluszenie = pSO;
		 przyrostSNaZatrucie = pSZ;
		 przyrostSNaPodpalenie = pSP;
		 przyrostKosztuUlepszenia = pKU;
	 }
	 
	 public void ulepsz() {
		 poziom++;
		 minAtkMag += przyrostMinAtkMag;
		 maxAtkMag += przyrostMaxAtkMag;
		 szansaNaOgluszenie += przyrostSNaOgluszenie;
		 szansaNaPodpalenie += przyrostSNaPodpalenie;
		 szansaNaZatrucie += przyrostSNaZatrucie;
		 kosztMany += przyrostKosztuMany;
		 przyrostKosztuUlepszenia *= 1.2;
		 kosztUlepszenia += przyrostKosztuUlepszenia;
	 }
	 
	 public int zwrocCeneUlepszenia() {
		 return kosztUlepszenia;
	 }
	 
	 public boolean czyMoznaUlepszyc() {
		 if (poziom < MAXPOZIOM) return true;
		 else return false;
	 }
	 
	 public void wyswietlStatystyki() {
		System.out.format("%s poziom: %d, atak magiczny: %d - %d ",nazwa,poziom,minAtkMag,maxAtkMag);
		if(szansaNaOgluszenie > 0) System.out.format("szansa na ogluszenie: %d ", szansaNaOgluszenie);
		if(szansaNaZatrucie > 0) System.out.format("szansa na zatrucie: %d ", szansaNaZatrucie);
		if(szansaNaPodpalenie > 0) System.out.format("szansa na podpalenie: %d ", szansaNaPodpalenie);
		System.out.format("koszt many: %d%n", kosztMany);
	 }
	 
	 public void wyswietlWSklepie() {
		 if(poziom == MAXPOZIOM) {
			 System.out.format("%s Zosta³ ulepszony na maksymalny poziom: %d%n ",nazwa,MAXPOZIOM);
		 }
		 else {
		 System.out.format("%s poziom: %d, atak magiczny: %d - %d ",nazwa,poziom+1,minAtkMag+przyrostMinAtkMag,maxAtkMag+przyrostMaxAtkMag);
			if(szansaNaOgluszenie+przyrostSNaOgluszenie > 0) System.out.format("szansa na ogluszenie: %d ", szansaNaOgluszenie+przyrostSNaOgluszenie);
			if(szansaNaZatrucie+przyrostSNaZatrucie > 0) System.out.format("szansa na zatrucie: %d ", szansaNaZatrucie+przyrostSNaZatrucie);
			if(szansaNaPodpalenie+przyrostSNaPodpalenie > 0) System.out.format("szansa na podpalenie: %d ", szansaNaPodpalenie+przyrostSNaPodpalenie);
			System.out.format("koszt many: %d ", kosztMany+przyrostKosztuMany);
			System.out.format("cena: %d%n", kosztUlepszenia);
		 }
	 }
	 
	 public int zwrocCzarKosztMany() {
		 return kosztMany;
	 }
	 public String zwrocCzarNazwe() {
		 return nazwa;
	 }
	 public int zwrocCzarMinAtkMag() {
		 return minAtkMag;
	 }
	 public int zwrocCzarMaxAtkMag() {
		 return maxAtkMag;
	 }
	 public int zwrocCzarSzanseOgluszenie() {
		 return szansaNaOgluszenie;
	 }
	 public int zwrocCzarSzanseZatrucie() {
		 return szansaNaZatrucie;
	 }
	 public int zwrocCzarSzansePodpalenie() {
		 return szansaNaPodpalenie;
	 }
}
