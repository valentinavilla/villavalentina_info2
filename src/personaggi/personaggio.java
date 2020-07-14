package personaggi;

import java.util.Vector;

public abstract class personaggio implements Comparable<personaggio> {
	String ID;
	String Nome;
	static int k;
	static Vector<String> listaid=new Vector<String>();
	
	public personaggio( String Nome) throws IdnondisponibileException {
		 this.Nome=Nome;
	}
	
	//costruttore utile da richiamare nelle sottoclassi
	public personaggio(String ID, String Nome) throws IdnondisponibileException {
		this(Nome);
		for(String l:listaid)
			{if(ID.equals(l))throw new IdnondisponibileException("id non disponibile") ;}
		this.ID=ID;
		listaid.add(ID);
		
	}
	
	@Override
	public int compareTo(personaggio o) {
		return this.forza()-o.forza();
	}
	
	@Override
	public String toString() {
		String s=" personaggio: "+Nome+" "+ID+" ha forza: "+this.forza();
		return s;
	}
	public String getNome() {return Nome;}

	
	 abstract int forza();
	 abstract void augment();
	 

}
