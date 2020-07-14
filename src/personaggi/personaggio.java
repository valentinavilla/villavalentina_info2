package personaggi;

import java.util.Vector;

public abstract class personaggio implements Comparable<personaggio> {
	public String ID;
	String Nome;
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

	
	 public abstract int forza();
	 abstract void augment();
	 
	 personaggio sfida(personaggio o) {
		 if(this.forza()>o.forza())return this;
		 else return o;
	 }
	 

}
