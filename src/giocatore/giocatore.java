package giocatore;

import java.util.Collections;
import java.util.Vector;

import personaggi.personaggiComparator;
import personaggi.personaggio;

public class giocatore {
	String name;
	public Vector<personaggio> listap;
	
	public giocatore(String alias) {
		this(alias, new Vector<personaggio>());
	}
	
	public giocatore (String alias,Vector<personaggio> p ) {
		name=alias; listap=p;
	}
	
	public void stampa() {
		Collections.sort(listap);
		for(personaggio i: listap)System.out.println(i.toString());
	}
	
	public void stampaOrdineNome() {
		Collections.sort(listap, new personaggiComparator());
		for(personaggio i: listap)System.out.println(i.toString());
	}
	
	public String toString() {
		return name;
	}
}
