package it.polito.tdp.libretto.model;

import java.util.*;

public class Libretto {//classe libretto: è il mio modello
	
	private List<Voto> voti;  //lista di voti
	
	public Libretto() {//costruttore vuoto
		this.voti = new ArrayList<Voto>();
	}
	/**
	 * Aggiungi un voto al libretto(controlla che non sia duplicato o in conflitto)
	 * @param v il voto da aggiungere
	 * @return true se lo aggiunge, false altrimenti
	 */
	public boolean add(Voto v) {//metodo per aggiungere oggetti alla struttura dati del modello
		if(this.esisteVotoConflitto(v) || this.esisteVotoDuplicato(v))
			throw new IllegalArgumentException("Voto errato: "+v);
		return this.voti.add(v);
	}
	
	public void stampaLibretto() {
		for(Voto v : this.voti)
		System.out.println(v);
	}
	
	public String toString() {
		String txt ="";
		for(Voto v : this.voti)
			txt += v.toString()+'\n';
		return txt;
	}
	
	public void stampaPuntiUguali(int punti) {
		for(Voto v : this.voti) {
			if(v.getPunti()==punti)
				System.out.println(v);
		}
	}
	
	public Voto cercaVotoPerNome(String nome) {
		for(Voto v : this.voti) {
			if(v.getCorso().equals(nome))
				return v;
		}
		return null;
	}
	
	public boolean esisteVotoDuplicato(Voto nuovo) {
		for(Voto v : voti) {
			if(v.isDuplicato(nuovo))//ho creato il metodo boolean isDuplicato ecc sulla classe Voto
				return true;
		}
		return false;
	}

	public boolean esisteVotoConflitto(Voto nuovo) {
		for(Voto v : voti) {
			if(v.isConflitto(nuovo))//per usare equals devo essere certo che confronti gli oggetti nel modo che voglio
				return true;
		}
		return false;
	}
	
	public Libretto librettoMigliorato() {
		Libretto migliore = new Libretto();
		migliore.voti = new ArrayList<>();//creo una nuova lista di voti cosicche posso migliorare il nuovo libretto senza modificare il precedente libretto
		for(Voto v : this.voti) {
			migliore.voti.add(v.clone());//ho creato il metodo clone nella classe Voto
		}
		for(Voto v : migliore.voti) {
			if(v.getPunti()>=18 && v.getPunti()<24)
				v.setPunti(v.getPunti()+1);
			if(v.getPunti()>=24 && v.getPunti()<29)
				v.setPunti(v.getPunti()+2);
			if(v.getPunti()==29)
				v.setPunti(v.getPunti()+1);
		}
		return migliore;
	}
	
	public void cancellaVotiInferiori(int punti) {//mai cancellare elementi direttamente sulla lista su cui itero
		List<Voto> lista = new ArrayList<Voto>(this.voti);//sempre crearne una nuova e togliere da quella
		for(Voto v : lista) {
			if(v.getPunti()<punti)
				voti.remove(v);
		}
	}
	
	public Libretto ordinaAlfabeticamenteEPerVoto() {
		Libretto ordinato = new Libretto();
		ordinato.voti = new ArrayList<>(this.voti);
		Collections.sort(ordinato.voti, new ComparatoreVotiPerNomeCorsoEVoto());
		return ordinato;
	}
}
