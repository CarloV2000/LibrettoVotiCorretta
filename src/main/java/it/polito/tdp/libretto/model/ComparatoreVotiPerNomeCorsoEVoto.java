package it.polito.tdp.libretto.model;

import java.util.Comparator;

public class ComparatoreVotiPerNomeCorsoEVoto implements Comparator<Voto>{

	@Override
	public int compare(Voto o1, Voto o2) {
		if(o1.getCorso().compareTo(o2.getCorso())==0)
			return o1.getPunti()-o2.getPunti();
		return o1.getCorso().compareTo(o2.getCorso());
	}

}
