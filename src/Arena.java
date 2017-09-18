import java.util.Random;

public class Arena {
	private String nazwa;
	private int rozmiar;
	private int pozPostaci;
	private int pozPrzeciwnika;
	private int nagrodaZloto;
	private int nagrodaDoswiadczenie;
	
	private int aktualnaEnergiaPostaci;
	private int aktualnaEnergiaPrzeciwnika;
	
	boolean turaPostaci;
	
	private Przeciwnik przeciwnik;
	private Postac postac;

	public Arena(Postac po,Przeciwnik p,int zl,int dos) {
		Random random = new Random();
		String [] nazwy = {"Lodowa jaskinia", "Mokrad³a", "Zamek króla", "Rynek", "Wulkan", "Kolorowa kraina"};
		nazwa = nazwy[random.nextInt(nazwy.length)];
		rozmiar = 14 - random.nextInt(8);
		aktualnaEnergiaPostaci = 10;
		aktualnaEnergiaPrzeciwnika = 10;
		pozPostaci = (rozmiar/2) - 2;
		pozPrzeciwnika = (rozmiar/2) + 2;
		postac = po;
		przeciwnik = p;
		nagrodaDoswiadczenie = dos;
		nagrodaZloto = zl;
		turaPostaci = random.nextBoolean();
		aktualnaEnergiaPostaci = 10;
		aktualnaEnergiaPrzeciwnika = 10;
	}
	
	public int zwrocNagrodaZloto() {
		return nagrodaZloto;
	}
	
	public int zwrocNagrodaDoswiadczenie() {
		return nagrodaDoswiadczenie;
	}
	
	public void wyswietlInformacjePrzedWalka() {
		Gra.clearScreen();
		System.out.format("Arena: %s%n",nazwa);
		System.out.format("Rozmiar areny: %d, nagroda doœwiadczenia: %d, z³oto: %d%n",rozmiar,nagrodaDoswiadczenie,nagrodaZloto);
		przeciwnik.wyswietlInformacjePrzeciwnika();
	}
	
	public void wyswietlInformacjeOWalce() {
		System.out.format("Arena: %s%n",nazwa);
		System.out.print("Imie: "); postac.wyswietlInformacjeArenaImie(); System.out.print("    "); przeciwnik.wyswietlInformacjeArenaImie(); System.out.println();
		System.out.print("Atk. fiz.:"); postac.wyswietlInformacjeArenaAtakFizyczny(); System.out.print("    "); przeciwnik.wyswietlInformacjeArenaAtakFizyczny(); System.out.println();
		System.out.print("Atk. mag.:"); postac.wyswietlInformacjeArenaAtakMagiczny(); System.out.print("    "); przeciwnik.wyswietlInformacjeArenaAtakMagiczny(); System.out.println();
		System.out.print("Zdrowie:"); postac.wyswietlInformacjeArenaZdrowie(); System.out.print("    "); przeciwnik.wyswietlInformacjeArenaZdrowie(); System.out.println();
		System.out.print("Obr. fiz.:"); postac.wyswietlInformacjeArenaRedukcjaFizyczna(); System.out.print("      "); przeciwnik.wyswietlInformacjeArenaRedukcjaFizyczna(); System.out.println();
		System.out.print("Obr. mag.:"); postac.wyswietlInformacjeArenaRedukcjaMagiczna(); System.out.print("      "); przeciwnik.wyswietlInformacjeArenaRedukcjaMagiczna(); System.out.println();
		System.out.print("Szans. unik:"); postac.wyswietlInformacjeArenaUnik(); System.out.print("     "); przeciwnik.wyswietlInformacjeArenaUnik(); System.out.println();
		System.out.print("Szans. og³uszenie:"); postac.wyswietlInformacjeArenaOgluszenie(); System.out.print("     "); przeciwnik.wyswietlInformacjeArenaOgluszenie(); System.out.println();
		System.out.print("Szans. zatrucie:"); postac.wyswietlInformacjeArenaZatrucie(); System.out.print("     "); przeciwnik.wyswietlInformacjeArenaZatrucie(); System.out.println();
		System.out.print("Szans. podpalenie:"); postac.wyswietlInformacjeArenaPodpalenie(); System.out.print("     "); przeciwnik.wyswietlInformacjeArenaPodpalenie(); System.out.println();
		System.out.print("Og³uszony?:"); postac.wyswietlInformacjeArenaCzyOgluszony(); System.out.print(" "); przeciwnik.wyswietlInformacjeArenaCzyOgluszony(); System.out.println();
		System.out.print("Zatruty?:"); postac.wyswietlInformacjeArenaCzyZatruty(); System.out.print(" "); przeciwnik.wyswietlInformacjeArenaCzyZatruty(); System.out.println();
		System.out.print("Podpalony?:"); postac.wyswietlInformacjeArenaCzyPodpalony(); System.out.print(" "); przeciwnik.wyswietlInformacjeArenaCzyPodpalony(); System.out.println();
		if(postac instanceof Mag) System.out.format("%s mana: %d / %d",postac.zwrocImie(),((Mag) postac).zwrocAktualnaMane(),((Mag) postac).zwrocMane());
		wyswietlPozycjePostaci();
		if(turaPostaci) wyswietlOpcjePostaci();
		else wyswietlOpcjePrzeciwnika();
	}
	
	public void wyswietlPozycjePostaci() {
		StringBuilder poleB = new StringBuilder();
		poleB.append('|');
		for(int i=0;i<rozmiar;i++) {
			poleB.append('-');
		}
		poleB.append('|');
		poleB.replace(pozPostaci+1, pozPostaci+2, "#");
		poleB.replace(pozPrzeciwnika+1, pozPrzeciwnika+2, "@");
		System.out.format("Postaæ - '#', Przeciwnik - '@'%n");
		System.out.println(poleB.toString());
	}
	
	public void wyswietlOpcjePostaci() {
		System.out.format("Tura %s, ",postac.zwrocImie());
		System.out.format("energia: %d%n",aktualnaEnergiaPostaci);
		int index = 1;
		if(postac instanceof Wojownik) {
			if(pozPostaci == 0 && pozPrzeciwnika == 1) {
				if(aktualnaEnergiaPostaci > 5) System.out.format("%d. atakuj - 6 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4 && postac.czyMaDodatkowe()) System.out.format("%d. u¿yj %s - 5 energii%n",index++,postac.dodatkowe.zwrocNazwe());
				System.out.format("%d. zakoñcz turê%n",index++);
				index = 1;
			}
			else if(pozPostaci == pozPrzeciwnika - 1 && pozPostaci > 0) {
				if(aktualnaEnergiaPostaci > 4) System.out.format("%d. krok do ty³u - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 5) System.out.format("%d. atakuj - 6 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4 && postac.czyMaDodatkowe()) System.out.format("%d. u¿yj %s - 5 energii%n",index++,postac.dodatkowe.zwrocNazwe());
				System.out.format("%d. zakoñcz turê%n",index++);
				index = 1;
			}
			else if(pozPostaci == 0 && pozPrzeciwnika > 1) {
				if(aktualnaEnergiaPostaci > 4) System.out.format("%d. krok do przodu - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 5 && (pozPostaci + postac.zwrocZasieg()) >= pozPrzeciwnika) System.out.format("%d. atakuj - 6 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4 && postac.czyMaDodatkowe()) System.out.format("%d. u¿yj %s - 5 energii%n",index++,postac.dodatkowe.zwrocNazwe());
				System.out.format("%d. zakoñcz turê%n",index++);
				index = 1;
			}
			else {
				if(aktualnaEnergiaPostaci > 4) System.out.format("%d. krok do ty³u - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4) System.out.format("%d. krok do przodu - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 5 && (pozPostaci + postac.zwrocZasieg()) >= pozPrzeciwnika) System.out.format("%d. atakuj - 6 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4 && postac.czyMaDodatkowe()) System.out.format("%d. u¿yj %s - 5 energii%n",index++,postac.dodatkowe.zwrocNazwe());
				System.out.format("%d. zakoñcz turê%n",index++);
				index = 1;
			}
				
		}
		else if(postac instanceof Strzelec) {
			if(pozPostaci == 0 && pozPrzeciwnika == 1) {
				if(aktualnaEnergiaPostaci > 4) System.out.format("%d. atakuj - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4 && postac.czyMaDodatkowe()) System.out.format("%d. u¿yj %s - 5 energii%n",index++,postac.dodatkowe.zwrocNazwe());
				System.out.format("%d. zakoñcz turê%n",index++);
				index = 1;
			}
			else if(pozPostaci == pozPrzeciwnika - 1 && pozPostaci > 0) {
				if(aktualnaEnergiaPostaci > 4) System.out.format("%d. krok do ty³u - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4) System.out.format("%d. atakuj - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4 && postac.czyMaDodatkowe()) System.out.format("%d. u¿yj %s - 5 energii%n",index++,postac.dodatkowe.zwrocNazwe());
				System.out.format("%d. zakoñcz turê%n",index++);
				index = 1;
			}
			else if(pozPostaci == 0 && pozPrzeciwnika > 1) {
				if(aktualnaEnergiaPostaci > 4) System.out.format("%d. krok do przodu - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4 && (pozPostaci + postac.zwrocZasieg()) >= pozPrzeciwnika) System.out.format("%d. atakuj - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4 && postac.czyMaDodatkowe()) System.out.format("%d. u¿yj %s - 5 energii%n",index++,postac.dodatkowe.zwrocNazwe());
				System.out.format("%d. zakoñcz turê%n",index++);
				index = 1;
			}
			else {
				if(aktualnaEnergiaPostaci > 4) System.out.format("%d. krok do ty³u - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4) System.out.format("%d. krok do przodu - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4 && (pozPostaci + postac.zwrocZasieg()) >= pozPrzeciwnika) System.out.format("%d. atakuj - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4 && postac.czyMaDodatkowe()) System.out.format("%d. u¿yj %s - 5 energii%n",index++,postac.dodatkowe.zwrocNazwe());
				System.out.format("%d. zakoñcz turê%n",index++);
				index = 1;
			}
		}
		else {
			if(pozPostaci == 0 && pozPrzeciwnika == 1) {
				if(aktualnaEnergiaPostaci > 5) System.out.format("%d. czaruj - 6 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4 && postac.czyMaDodatkowe()) System.out.format("%d. u¿yj %s - 5 energii%n",index++,postac.dodatkowe.zwrocNazwe());
				System.out.format("%d. zakoñcz turê%n",index++);
				index = 1;
			}
			else if(pozPostaci == pozPrzeciwnika - 1 && pozPostaci > 0) {
				if(aktualnaEnergiaPostaci > 4) System.out.format("%d. krok do ty³u - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 5) System.out.format("%d. czaruj - 6 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4 && postac.czyMaDodatkowe()) System.out.format("%d. u¿yj %s - 5 energii%n",index++,postac.dodatkowe.zwrocNazwe());
				System.out.format("%d. zakoñcz turê%n",index++);
				index = 1;
			}
			else if(pozPostaci == 0 && pozPrzeciwnika > 1) {
				if(aktualnaEnergiaPostaci > 4) System.out.format("%d. krok do przodu - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 5 && (pozPostaci + postac.zwrocZasieg()) >= pozPrzeciwnika) System.out.format("%d. czaruj - 6 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4 && postac.czyMaDodatkowe()) System.out.format("%d. u¿yj %s - 5 energii%n",index++,postac.dodatkowe.zwrocNazwe());
				System.out.format("%d. zakoñcz turê%n",index++);
				index = 1;
			}
			else {
				if(aktualnaEnergiaPostaci > 4) System.out.format("%d. krok do ty³u - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4) System.out.format("%d. krok do przodu - 5 energii%n",index++);
				if(aktualnaEnergiaPostaci > 5 && (pozPostaci + postac.zwrocZasieg()) >= pozPrzeciwnika) System.out.format("%d. czaruj - 6 energii%n",index++);
				if(aktualnaEnergiaPostaci > 4 && postac.czyMaDodatkowe()) System.out.format("%d. u¿yj %s - 5 energii%n",index++,postac.dodatkowe.zwrocNazwe());
				System.out.format("%d. zakoñcz turê%n",index++);
				index = 1;
			}
		}
	}
	
	public void wyswietlOpcjePrzeciwnika() {
		System.out.format("Tura %s, ",przeciwnik.zwrocImie());
		System.out.format("energia: %d%n",aktualnaEnergiaPrzeciwnika);
		System.out.format("Przeciwnik coœ kombinuje!%n");
	}
	
	public boolean turaPostaci() {
		aktualnaEnergiaPrzeciwnika = 10;
		int wybor;
		
		if(postac.efekty.czyOgluszony()) {
			System.out.format("%s jest og³uszony!%n",postac.zwrocImie());
			Gra.sleep(2000);
			return true;
		}
		else {
		wybor = Gra.getInput();
		if(postac instanceof Wojownik || postac instanceof Mag) {
			if(pozPostaci == 0 && pozPrzeciwnika == 1) {
				if(aktualnaEnergiaPostaci > 5 ) {
					if(wybor == 1) {
						przeciwnik.otrzymajObrazenia(postac.atak());
						aktualnaEnergiaPostaci -= 6;
					}
					else if(postac.czyMaDodatkowe()) {
						if(wybor == 2) {
							if(postac.dodatkowe instanceof Ogluszajace) {
								boolean czyStun = false;
								if(postac.uzyjBomby() == 1) czyStun = true;
								przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
							}
							else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
							else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
							aktualnaEnergiaPostaci -= 5;
						}
						if(wybor == 3) return true;
						else return false;
					}
					else if(!postac.czyMaDodatkowe()) {
						if(wybor == 2) return true;
						else return false;
					}
				}
				else if(aktualnaEnergiaPostaci == 5) {
					if(postac.czyMaDodatkowe()) {
						if(wybor == 1) {
							if(postac.dodatkowe instanceof Ogluszajace) {
								boolean czyStun = false;
								if(postac.uzyjBomby() == 1) czyStun = true;
								przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
							}
							else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
							else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
							aktualnaEnergiaPostaci -= 5;
						}
						else if(wybor == 2) return true;
						else return false;
					}
					else if((!postac.czyMaDodatkowe())) {
						if(wybor == 1) return true;
						else return false;
					}
				}
				else {
					if(wybor == 1) return true;
					else return false;
				}
				
			}
			else if(pozPostaci == pozPrzeciwnika - 1 && pozPostaci > 0) {
				if(aktualnaEnergiaPostaci > 5) {
					if(wybor == 1) {
						pozPostaci--;
						aktualnaEnergiaPostaci -= 5;
					}
					else if(wybor == 2) {
							przeciwnik.otrzymajObrazenia(postac.atak());
							aktualnaEnergiaPostaci -= 6;
						}
					else if(postac.czyMaDodatkowe()) {
						if(wybor == 3) {
							if(postac.dodatkowe instanceof Ogluszajace) {
								boolean czyStun = false;
								if(postac.uzyjBomby() == 1) czyStun = true;
								przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
							}
							else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
							else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
							aktualnaEnergiaPostaci -= 5;
						}
						else if(wybor == 4) return true;
						else return false;
						}
					else if(!postac.czyMaDodatkowe()) {
						if(wybor == 3) return true;
						else return false;
					}
				}
				else if(aktualnaEnergiaPostaci == 5) {
					if(wybor == 1) {
						pozPostaci--;
						aktualnaEnergiaPostaci -= 5;
					}
					else if(postac.czyMaDodatkowe()) {
						if(wybor == 2) {
							if(postac.dodatkowe instanceof Ogluszajace) {
								boolean czyStun = false;
								if(postac.uzyjBomby() == 1) czyStun = true;
								przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
							}
							else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
							else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
							aktualnaEnergiaPostaci -= 5;
						}
						else if(wybor == 3) return true;
						else return false;
					}
					else {
						if(wybor == 2) return true;
						else return false;
					}
				}
				else {
					if(wybor == 1) return true;
					else return false;
				}
			}
			else if(pozPostaci == 0 && pozPrzeciwnika > 1) {
				if(aktualnaEnergiaPostaci > 5) {
					if(wybor == 1) {
						pozPostaci++;
						aktualnaEnergiaPostaci -= 5;
					}
					else if((pozPostaci + postac.zwrocZasieg()) >= pozPrzeciwnika) {
						if(wybor == 2) {
							przeciwnik.otrzymajObrazenia(postac.atak());
							aktualnaEnergiaPostaci -= 6;
						}
						else if(postac.czyMaDodatkowe()) {
							if(wybor == 3) {
								if(postac.dodatkowe instanceof Ogluszajace) {
									boolean czyStun = false;
									if(postac.uzyjBomby() == 1) czyStun = true;
									przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
								}
								else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
								else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
								aktualnaEnergiaPostaci -= 5;
							}
							else if(wybor == 4) return true;
							else return false;
						}
					}
					else if(postac.czyMaDodatkowe()) {
						if(wybor == 2) {
							if(postac.dodatkowe instanceof Ogluszajace) {
								boolean czyStun = false;
								if(postac.uzyjBomby() == 1) czyStun = true;
								przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
							}
							else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
							else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
							aktualnaEnergiaPostaci -= 5;
						}
						else if(wybor == 3) return true;
						else return false;
					}
					else {
						if(wybor == 2) return true;
						else return false;
					}
				}

				else if(aktualnaEnergiaPostaci == 5) {

					if(wybor == 1) {
						pozPostaci++;
						aktualnaEnergiaPostaci -= 5;
					}
					else if(postac.czyMaDodatkowe()) {
						if(wybor == 2) {
							if(postac.dodatkowe instanceof Ogluszajace) {
								boolean czyStun = false;
								if(postac.uzyjBomby() == 1) czyStun = true;
								przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
							}
							else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
							else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
							aktualnaEnergiaPostaci -= 5;
						}
						else if(wybor == 3) return true;
						else return false;
					}
					else {
						if(wybor == 2) return true;
						else return false;
					}
				}
				else {
					if(wybor == 1) return true;
					else return false;
				}

			}
			else {
				if(aktualnaEnergiaPostaci >= 5) {
					if(wybor == 1) {
						pozPostaci--;
						aktualnaEnergiaPostaci -= 5;
					}
					else if(wybor == 2) {
						pozPostaci++;
						aktualnaEnergiaPostaci -= 5;
					}
					else if(aktualnaEnergiaPostaci > 5 && (pozPostaci + postac.zwrocZasieg()) >= pozPrzeciwnika) {
						if(wybor == 3) {
							przeciwnik.otrzymajObrazenia(postac.atak());
							aktualnaEnergiaPostaci -= 6;
						}
						else if(postac.czyMaDodatkowe()) {
							if(wybor == 4) {
								if(postac.dodatkowe instanceof Ogluszajace) {
									boolean czyStun = false;
									if(postac.uzyjBomby() == 1) czyStun = true;
									przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
								}
								else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
								else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
								aktualnaEnergiaPostaci -= 5;
							}
							else if(wybor == 5) return true;
							else return false;
						}
						else {
							if(wybor == 4) return true;
							else return false;
						}
					}
					else if(postac.czyMaDodatkowe()) {
						if(wybor == 3) {
							if(postac.dodatkowe instanceof Ogluszajace) {
								boolean czyStun = false;
								if(postac.uzyjBomby() == 1) czyStun = true;
								przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
							}
							else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
							else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
							aktualnaEnergiaPostaci -= 5;
						}
						else if(wybor == 4) return true;
						else return false;
					}
					else {
						if(wybor == 3) return true;
						else return false;
					}
				}
				else {
					if(wybor == 1) return true;
					else return false;
				}
			}	
		}
		else if(postac instanceof Strzelec) {
			if(pozPostaci == 0 && pozPrzeciwnika == 1) {
				if(aktualnaEnergiaPostaci > 4) {

					if(wybor == 1) {
						przeciwnik.otrzymajObrazenia(postac.atak());
						aktualnaEnergiaPostaci -= 5;
					}
					else if(postac.czyMaDodatkowe()) {
						if(wybor == 2) {
							if(postac.dodatkowe instanceof Ogluszajace) {
								boolean czyStun = false;
								if(postac.uzyjBomby() == 1) czyStun = true;
								przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
							}
							else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
							else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
							aktualnaEnergiaPostaci -= 5;
						}
						if(wybor == 3) return true;
						else return false;
					}
					else if(!postac.czyMaDodatkowe()) {
						if(wybor == 2) return true;
						else return false;
					}
				
				}
				else {
					if(wybor == 1) return true;
					else return false;
				}
			}
			else if(pozPostaci == pozPrzeciwnika - 1 && pozPostaci > 0) {
				if(aktualnaEnergiaPostaci > 4) {

					if(wybor == 1) {
						pozPostaci--;
						aktualnaEnergiaPostaci -= 5;
					}
					else if(wybor == 2) {
						przeciwnik.otrzymajObrazenia(postac.atak());
						aktualnaEnergiaPostaci -= 5;
					}
					else if(postac.czyMaDodatkowe()) {
						if(wybor == 3) {
							if(postac.dodatkowe instanceof Ogluszajace) {
								boolean czyStun = false;
								if(postac.uzyjBomby() == 1) czyStun = true;
								przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
							}
							else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
							else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
							aktualnaEnergiaPostaci -= 5;
						}
						else if(wybor == 4) return true;
						else return false;
					}
				else if(!postac.czyMaDodatkowe()) {
					if(wybor == 3) return true;
					else return false;
				}
			}
			else {
				if(wybor == 1) return true;
				else return false;
			}
			}
			else if(pozPostaci == 0 && pozPrzeciwnika > 1) {
				if(aktualnaEnergiaPostaci > 4) {

					if(wybor == 1) {
						pozPostaci++;
						aktualnaEnergiaPostaci -= 5;
					}
					else if(aktualnaEnergiaPostaci > 4 && (pozPostaci + postac.zwrocZasieg()) >= pozPrzeciwnika) {
						if(wybor == 2) {
							przeciwnik.otrzymajObrazenia(postac.atak());
							aktualnaEnergiaPostaci -= 5;
						}
						else if(postac.czyMaDodatkowe()) {
							if(wybor == 3) {
								if(postac.dodatkowe instanceof Ogluszajace) {
									boolean czyStun = false;
									if(postac.uzyjBomby() == 1) czyStun = true;
									przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
								}
								else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
								else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
								aktualnaEnergiaPostaci -= 5;
							}
							else if(wybor == 4) return true;
							else return false;
						}
					}
					else if(postac.czyMaDodatkowe()) {
						if(wybor == 2) {
							if(postac.dodatkowe instanceof Ogluszajace) {
								boolean czyStun = false;
								if(postac.uzyjBomby() == 1) czyStun = true;
								przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
							}
							else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
							else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
							aktualnaEnergiaPostaci -= 5;
						}
						else if(wybor == 3) return true;
						else return false;
					}
					else {
						if(wybor == 2) return true;
						else return false;
					}
				
				}
				else {
					if(wybor == 1) return true;
					else return false;
				}
			}
			else {
				if(aktualnaEnergiaPostaci > 4) {

					if(wybor == 1) {
						pozPostaci--;
						aktualnaEnergiaPostaci -= 5;
					}
					else if(wybor == 2) {
						pozPostaci++;
						aktualnaEnergiaPostaci -= 5;
					}
					else if(aktualnaEnergiaPostaci > 4 && (pozPostaci + postac.zwrocZasieg()) >= pozPrzeciwnika) {
						if(wybor == 3) {
							przeciwnik.otrzymajObrazenia(postac.atak());
							aktualnaEnergiaPostaci -= 5;
						}
						else if(postac.czyMaDodatkowe()) {
							if(wybor == 4) {
								if(postac.dodatkowe instanceof Ogluszajace) {
									boolean czyStun = false;
									if(postac.uzyjBomby() == 1) czyStun = true;
									przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
								}
								else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
								else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
								aktualnaEnergiaPostaci -= 5;
							}
							else if(wybor == 5) return true;
							else return false;
						}
						else {
							if(wybor == 4) return true;
							else return false;
						}
					}
					else if(postac.czyMaDodatkowe()) {
						if(wybor == 3) {
							if(postac.dodatkowe instanceof Ogluszajace) {
								boolean czyStun = false;
								if(postac.uzyjBomby() == 1) czyStun = true;
								przeciwnik.otrzymajObrazenia(new Atak(0,0,czyStun,false,false));
							}
							else if(postac.dodatkowe instanceof EliksirZdrowia) postac.ulecz();
							else if(postac.dodatkowe instanceof EliksirMany) postac.przywrocMane();
							aktualnaEnergiaPostaci -= 5;
						}
						else if(wybor == 4) return true;
						else return false;
					}
					else {
						if(wybor == 3) return true;
						else return false;
					}
				
				}
				else {
					if(wybor == 1) return true;
					else return false;
				}
			}
		}
		Gra.sleep(2000);
		return false;
		}
	}
	
	public boolean turaPrzeciwnika() {
		aktualnaEnergiaPostaci = 10;
		if(przeciwnik.efekty.czyOgluszony()) {
			System.out.format("%s jest og³uszony!%n",przeciwnik.zwrocImie());
			Gra.sleep(2500);
			return true;
		}
		else {
			if(przeciwnik.zwrocImie() == "Mag Czaruœ" || przeciwnik.zwrocImie() == "Wojownik Stefix") {
				if(aktualnaEnergiaPrzeciwnika > 5) {
					if((pozPrzeciwnika - pozPostaci < przeciwnik.zwrocZasieg()) && (pozPrzeciwnika != rozmiar-1)) {
						pozPrzeciwnika++;
						aktualnaEnergiaPrzeciwnika -= 5;
						System.out.format("%s krok do ty³u", przeciwnik.zwrocImie());
					}
					else if(pozPrzeciwnika - pozPostaci > przeciwnik.zwrocZasieg()) {
						pozPrzeciwnika--;
						aktualnaEnergiaPrzeciwnika -= 5;
						System.out.format("%s krok do przodu", przeciwnik.zwrocImie());
					}
					else {
						postac.otrzymajObrazenia(przeciwnik.atak());
						aktualnaEnergiaPrzeciwnika -= 6;
					}
				}
				else if(aktualnaEnergiaPrzeciwnika == 5) {
					if((pozPrzeciwnika - pozPostaci < przeciwnik.zwrocZasieg()) && (pozPrzeciwnika != rozmiar-1)) {
						pozPrzeciwnika++;
						aktualnaEnergiaPrzeciwnika -= 5;
						System.out.format("%s krok do ty³u", przeciwnik.zwrocImie());
					}
					else if(pozPrzeciwnika - pozPostaci > przeciwnik.zwrocZasieg()) {
						pozPrzeciwnika--;
						aktualnaEnergiaPrzeciwnika -= 5;
						System.out.format("%s krok do przodu", przeciwnik.zwrocImie());
					}
					else return true;
				}
				else return true;
			}
			else {
				if(aktualnaEnergiaPrzeciwnika > 4) {
					if((pozPrzeciwnika - pozPostaci < przeciwnik.zwrocZasieg()) && (pozPrzeciwnika != rozmiar-1)) {
						pozPrzeciwnika++;
						aktualnaEnergiaPrzeciwnika -= 5;
						System.out.format("%s krok do ty³u", przeciwnik.zwrocImie());
					}
					else if(pozPrzeciwnika - pozPostaci > przeciwnik.zwrocZasieg()) {
						pozPrzeciwnika--;
						aktualnaEnergiaPrzeciwnika -= 5;
						System.out.format("%s krok do przodu", przeciwnik.zwrocImie());
					}
					else {
						postac.otrzymajObrazenia(przeciwnik.atak());
						aktualnaEnergiaPrzeciwnika -= 5;
					}
				}
				else return true;
			}
		Gra.sleep(3000);
		return false;
		}
	}
	
	public boolean walka() {
		
		boolean koniec = false;
		boolean wygrana = false;
		
		do {
			Gra.clearScreen();
			wyswietlInformacjeOWalce();
			
			if(turaPostaci) {
				
				if(postac.efekty.czyPodpalony()) {
					postac.odejmijZdrowie(postac.efekty.zwrocObrazeniaPodpalenia());
					System.out.format("%s podpalony -%d zdrowia%n",postac.zwrocImie(),postac.efekty.zwrocObrazeniaPodpalenia());
				}
				if(postac.efekty.czyZatruty()) {
					postac.odejmijZdrowie(postac.efekty.zwrocObrazeniaZatrucia());
					System.out.format("%s zatruty -%d zdrowia%n",postac.zwrocImie(),postac.efekty.zwrocObrazeniaZatrucia());
				}
				
				if(postac.zwrocAktualneZdrowie() <= 0) {
					koniec = true;
					wygrana = false;
				}
				else if(przeciwnik.zwrocAktualneZdrowie() <= 0) {
					koniec = true;
					wygrana = true;
				}
				
				while(!turaPostaci()) {
					Gra.clearScreen();
					wyswietlInformacjeOWalce();
				}
				if(postac instanceof Mag) ((Mag) postac).regenerujMane();
				turaPostaci = false;
				if(postac.zwrocAktualneZdrowie() <= 0) {
					koniec = true;
					wygrana = false;
				}
				else if(przeciwnik.zwrocAktualneZdrowie() <= 0) {
					koniec = true;
					wygrana = true;
				}
			}
			else {
				
				if(przeciwnik.efekty.czyPodpalony()) {
					przeciwnik.odejmijZdrowie(przeciwnik.efekty.zwrocObrazeniaPodpalenia());
					System.out.format("%s podpalony -%d zdrowia%n",przeciwnik.zwrocImie(),przeciwnik.efekty.zwrocObrazeniaPodpalenia());
				}
				if(przeciwnik.efekty.czyZatruty()) {
					przeciwnik.odejmijZdrowie(przeciwnik.efekty.zwrocObrazeniaZatrucia());
					System.out.format("%s zatruty -%d zdrowia%n",przeciwnik.zwrocImie(),przeciwnik.efekty.zwrocObrazeniaZatrucia());
				}
				
				if(postac.zwrocAktualneZdrowie() <= 0) {
					koniec = true;
					wygrana = false;
				}
				else if(przeciwnik.zwrocAktualneZdrowie() <= 0) {
					koniec = true;
					wygrana = true;
				}
				
				while(!turaPrzeciwnika()) {
					Gra.clearScreen();
					wyswietlInformacjeOWalce();
				}
				turaPostaci = true;
				if(postac.zwrocAktualneZdrowie() <= 0) {
					koniec = true;
					wygrana = false;
				}
				else if(przeciwnik.zwrocAktualneZdrowie() <= 0) {
					koniec = true;
					wygrana = true;
				}
			
			}
			
		}while(!koniec);
		return wygrana;
		
	}

}