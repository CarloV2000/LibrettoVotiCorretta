package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto lib = new Libretto();
		lib.add(new Voto ("Analisi 1",29, LocalDate.of(2021, 2, 15)));
		lib.add(new Voto ("Fisica 2",27, LocalDate.of(2022, 6, 10)));
		lib.add(new Voto ("Informatica",25, LocalDate.of(2021, 6, 10)));
		lib.add(new Voto ("Chimica",23, LocalDate.of(2021, 6, 15)));


		System.out.println("----------------------------------punto 1");
		
		lib.stampaLibretto();
		
		System.out.println("----------------------------------punto 2");
		
		lib.stampaPuntiUguali(25);
		
		System.out.println("----------------------------------punto 3");
		
		Voto v = lib.cercaVotoPerNome("Analisi 1");
		System.out.println("il voto cercato è : "+v);
		
		System.out.println("----------------------------------punto 4");
		
		Voto a1bis = new Voto("Analisi 1",29, LocalDate.of(2021, 2, 15));
		System.out.println(a1bis+" è duplicato: "+lib.esisteVotoDuplicato(a1bis));

		System.out.println("----------------------------------punto 5");
		
		Voto a1ter = new Voto("Analisi 1",25, LocalDate.of(2021, 2, 15));
		System.out.println(a1ter+" è in conflitto: "+lib.esisteVotoConflitto(a1ter));

		System.out.println("----------------------------------punto 6");
		
		try {//scrivendo cosi il verificarsi dell'eccezione non interrompe il programma
			lib.add(new Voto ("Informatica",25, LocalDate.of(2023, 7, 10)));
		}catch(IllegalArgumentException e) {
			System.out.println("Errore nell'inserimento voto.");
			System.out.println(e.getMessage());//stampa il messaggio che ho scritto nell'eccezone nella classe Libretto
		}

		System.out.println("----------------------------------punto 7");

		Libretto migliore = lib.librettoMigliorato();
		System.out.println("LIBRETTO ORIGINARIO");
		lib.stampaLibretto();
		System.out.println("LIBRETTO MIGLIORATO");
		migliore.stampaLibretto();
		System.out.println("LIBRETTO ORIGINARIO DI NUOVO");
		lib.stampaLibretto();

		
		System.out.println("----------------------------------punto 8");
		System.out.println("LIBRETTO ORIGINARIO ORDINATO");
		lib.ordinaAlfabeticamenteEPerVoto().stampaLibretto();

		
		System.out.println("----------------------------------punto 9");
		
		lib.cancellaVotiInferiori(24);
		System.out.println("LIBRETTO ORIGINARIO >24");
		lib.stampaLibretto();
		
	}

}
