import java.util.Random;

public class Ogluszajace extends Dodatkowe {
	int szansaNaOgluszenie;
	Ogluszajace(String naz,int c,int sO) {
		super(naz,c);
		szansaNaOgluszenie = sO;
	}

	@Override
	public void wyswietlWSklepie() {
	System.out.format("%s szansa na ogluszenie: %d, cena: %d%n",nazwa,szansaNaOgluszenie,cena);
	}

	@Override
	public void wyswietlStatystyki() {
		System.out.format("%s szansa na ogluszenie: %d ",nazwa,szansaNaOgluszenie);
		System.out.format("wartoœæ: %d%n",(int)(cena*0.5));
	}

	@Override
	public int uzyj() {
		Random random = new Random();
		if(random.nextInt(100) < szansaNaOgluszenie) return 1;
		else return 0;
	}
}
