
public final class Efekty {
	private boolean ogluszony;
	private boolean zatruty;
	private boolean podpalony;
	
	private int obrazeniaOdZatrucia;
	private int obrazeniaOdPodpalenia;
	
	private int timerOgluszenie;
	private int timerZatrucie;
	private int timerPodpalenie;
	
	public Efekty() {
		ogluszony = false;
		zatruty = false;
		podpalony = false;
		obrazeniaOdPodpalenia = 0;
		obrazeniaOdZatrucia = 0;
		timerPodpalenie = 0;
		timerZatrucie = 0; 
		timerOgluszenie = 0;
	}
	
	public void aktualizujOgluszenie(boolean og) {
		ogluszony = og;
		timerOgluszenie = 2;
	}
	public void aktualizujZatrucie(boolean zat,int oOZ) {
		zatruty = zat;
		obrazeniaOdZatrucia = oOZ;
		timerZatrucie = 2;
	}
	public void aktualizujPodpalenie(boolean pod, int oOP) {
		podpalony = pod;
		obrazeniaOdPodpalenia = oOP;
		timerPodpalenie = 2;
	}
	
	public void anulujOgluszenie() {
		ogluszony = false;
	}
	public void anulujZatrucie() {
		zatruty = false;
	}
	public void anulujPodpalenie() {
		podpalony = false;
	}
	
	public int zwrocObrazeniaZatrucia() {
		return obrazeniaOdZatrucia;
	}
	public int zwrocObrazeniaPodpalenia() {
		return obrazeniaOdPodpalenia;
	}
	
	public boolean czyOgluszony() {
		if(ogluszony) {
			timerOgluszenie--;
			if(timerOgluszenie == 0) ogluszony = false;
		}
		return ogluszony;
	}
	public boolean czyZatruty() {
		if(zatruty) {
			timerZatrucie--;
			if(timerZatrucie == 0) zatruty = false;
		}
		return zatruty;
	}
	public boolean czyPodpalony() {
		if(podpalony) {
			timerPodpalenie--;
			if(timerPodpalenie == 0) podpalony = false;
		}
		return podpalony;
	}
	
	public void wyswietlCzyOgluszony() {
		if(ogluszony) System.out.format("og³uszony");
		else System.out.format("nie og³uszony");
	}
	
	public void wyswietlCzyZatruty() {
		if(ogluszony) System.out.format("zatruty");
		else System.out.format("nie zatruty");
	}
	
	public void wyswietlCzyPodpalony() {
		if(ogluszony) System.out.format("podpalony");
		else System.out.format("nie podpalony");
	}
}
