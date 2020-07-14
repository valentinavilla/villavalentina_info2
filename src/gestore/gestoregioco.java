package gestore;

import java.util.Vector;

import giocatore.giocatore;
import personaggi.Commerciante;
import personaggi.Guerriero;
import personaggi.IdnondisponibileException;
import personaggi.Mago;
import personaggi.Saggio;
import personaggi.personaggio;
import prog.io.FileInputManager;

public class gestoregioco {
	public Vector<giocatore> listaGiocatori;
	
	public gestoregioco() {
		listaGiocatori= new Vector<giocatore>();
	}
	
	
	public void caricaDatiDaFile() throws IdnondisponibileException {
		FileInputManager file=new FileInputManager("giocatori");
		while(true) {
			String linea=file.readLine();
			if(linea==null)break;
			
			
			String[] data=linea.split(";");
			listaGiocatori.add(new giocatore(data[0]));
			
			
			for(int i=1; i<data.length;i++) {
			
			switch(data[i]) {
			case "W": listaGiocatori.get(i-1).listap.add(new Guerriero("guerriero"+i));
						continue;
			case "M": listaGiocatori.get(i-1).listap.add(new Mago("mago"+i));
						continue;
			case "S": listaGiocatori.get(i-1).listap.add(new Saggio("saggio"+i));
						continue;
			case "C": listaGiocatori.get(i-1).listap.add(new Commerciante("commerciante"+i));
						continue;
						
			default:break;
			}
			}
	
		}}
	
		public void trasferisci(personaggio o) {
			int i;
			do{ i=((int)(Math.random()*10));}
			while(i<listaGiocatori.size());
			
			listaGiocatori.get(i).listap.add(o);
			}
		
		public void trasferisci(personaggio o, giocatore e) {
			e.listap.add(o);
			}
		
		
		public void tradisci(String nome) {
			for(giocatore e: listaGiocatori)
				{for(personaggio p:e.listap)
					{if(nome.equalsIgnoreCase(p.getNome()){
						e.listap.remove(p);
						trasferisci(p);
							}}}
		}
		
		public void tradisci(String iniziale, int codice) {
			String pi=iniziale+codice;
			for(giocatore e: listaGiocatori)
				{for(personaggio p:e.listap)
					{if(pi.equalsIgnoreCase(p.ID){
						e.listap.remove(p);
						trasferisci(p);
							}}}
		}
		
		
		public void tradisci(giocatore i, personaggio p) {
			for(giocatore e: listaGiocatori)
				if(e.equals(i))i.listap.add(p);
		}
		
		int disparità(giocatore e, giocatore f) {
			int i=0; int ii=0;
			for(personaggio p: e.listap)i+=p.forza();
			for(personaggio p: f.listap)ii+=p.forza();
			return i-ii;
		}
		
		public int disparità() {
			int min=2020;int max=0;int i;
			for(giocatore e: listaGiocatori)
			{	i=0;
			for(personaggio p:e.listap)
				{i+=p.forza();}
			if(i>max)i=max;
			if(i<=min)i=min;
				}
			return max-min;
			
		}
		
		public personaggio lotta(personaggio p1, personaggio p2) {
			if (p1.forza()>p2.forza())return p1;
			else return p2;
		}
		
		public giocatore lotta(giocatore g1, giocatore g2) {
			if(g1.listap.size()!=0 && g2.listap.size()!=0)
				if (g1.listap.get(0).forza()>g2.listap.get(0).forza())return g1;
				else return g2;
			return null;
			
		}
}
