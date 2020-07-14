package main;

import gestore.gestoregioco;
import giocatore.giocatore;
import jdk.nashorn.internal.runtime.ListAdapter;
import personaggi.IdnondisponibileException;

public class Prova {

	public static void main(String[] args) {
		gestoregioco g=new gestoregioco();
		try {
			g.caricaDatiDaFile();
		} catch (IdnondisponibileException e) {
			e.printStackTrace();
		}
		
		do{//stampo disparità
			System.out.println("la disparità è:"+ g.disparità());
			
			//scelgo 2 giocatori a caso
			int index1=(int)(Math.random()*10);
			int index2=(int)(Math.random()*10);
			while(index1>g.listaGiocatori.size()&& index1>g.listaGiocatori.size) {
				index1--;index2--;
			}
			//li faccio lottare(i loro primi personaggi) e stampo un messaggio
			giocatore vincitore=g.lotta(g.listaGiocatori.get(index1), g.listaGiocatori.get(index2));
			System.out.println("il vincitore è: "+vincitore.toString());
			
			//trasferisco il personaggio al vincitore
			giocatore perdente;
			if(vincitore.equals(g.listaGiocatori.get(index1)))perdente=g.listaGiocatori.get(index2);
			else perdente=g.listaGiocatori.get(index1);
			g.trasferisci(perdente.listap.get(0), vincitore);
			
			if(perdente.listap.size()==0)g.listaGiocatori.remove(perdente);
			
			//aumento dotazione personaggio random
			g.listaGiocatori.get(index1).listap.get(index2).augment();
			
			g.tradisci("S", (int)(Math.random()*10));
		}while(g.listaGiocatori.size()==1);

}}
