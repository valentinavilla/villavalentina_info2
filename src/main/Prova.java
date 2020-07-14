package main;

import gestore.gestoregioco;
import personaggi.IdnondisponibileException;

public class Prova {

	public static void main(String[] args) {
		gestoregioco g=new gestoregioco();
		try {
			g.caricaDatiDaFile();
		} catch (IdnondisponibileException e) {
			e.printStackTrace();
		}

}}
