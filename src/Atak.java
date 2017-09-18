
public class Atak {
	private int fiz;
	private int mag;
	private boolean sO;
	private boolean sZ;
	private boolean sP;
	
	public Atak(int f, int m, boolean o, boolean z, boolean p) {
		fiz = f;
		mag = m;
		sO = o;
		sZ = z;
		sP = p;
	}
	
	public int zwrocAtakFizyczny() {
		return fiz;
	}
	public int zwrocAtakMagiczny() {
		return mag;
	}
	public boolean zwrocSzanseNaOgluszenie() {
		return sO;
	}
	public boolean zwrocSzanseNaZatrucie() {
		return sZ;
	}
	public boolean zwrocSzanseNaPodpalenie() {
		return sP;
	}
}
