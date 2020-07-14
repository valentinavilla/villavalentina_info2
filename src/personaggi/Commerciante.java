package personaggi;

import java.util.Date;

public class Commerciante extends Saggio {
	
	double monete;
	
	public Commerciante( String Nome) throws IdnondisponibileException {
		 super(Nome);
		 ID="C"+(int)(Math.random()*100);
		 monete=0;
	}

	public Commerciante(String ID, String Nome) throws IdnondisponibileException {
		this(ID, Nome,0);
	}
	public Commerciante(String ID, String Nome, double  monete) throws IdnondisponibileException {
		super(ID, Nome);
		if(!(ID.startsWith("C")))throw new IdnondisponibileException(" id inizia con lettera sbagliata");
		this.monete=monete;
	}
	
	public Commerciante(String ID, String Nome, int libri, double monete) throws IdnondisponibileException {
		super(ID, Nome, libri);
		if(!(ID.startsWith("C")))throw new IdnondisponibileException(" id inizia con lettera sbagliata");
		this.monete=monete;
	}


	@Override
	int forza() {
		if(this.libri>10 || monete>5000000000L)return 10;
		return 2;
	}

	@Override
	void augment() {
		if(this.libri==new Date().getDay())super.augment();
		else monete+=1000000000;
		
		
	}

}
