package personaggi;

public class Guerriero extends personaggio{
	
	boolean spada;
	
	public Guerriero( String Nome) throws IdnondisponibileException {
		 super(Nome);
		 ID="W"+(int)(Math.random()*100);
		 spada=false;
		 listaid.add(ID);
	}
	
	public Guerriero(String ID, String Nome, boolean haSpada) throws IdnondisponibileException {
		super(ID, Nome);
		if(!(ID.startsWith("W")))throw new IdnondisponibileException(" id inizia con lettera sbagliata");
		spada=haSpada;
	}

	@Override
	void augment() {
		spada=true;
	}

	@Override
	int forza() {
		if(spada)return 7;
		else return 0;
	}
	
	
}
