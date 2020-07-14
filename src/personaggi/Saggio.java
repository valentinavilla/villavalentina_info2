package personaggi;

public class Saggio extends personaggio{
	
	int libri;

	public Saggio(String ID, String Nome, int libri) throws IdnondisponibileException {
		super(ID, Nome);
		if(!(ID.startsWith("S")))throw new IdnondisponibileException(" id inizia con lettera sbagliata");
		this.libri=libri;
	}

	public Saggio(String iD, String nome) throws IdnondisponibileException {
		this(iD, nome, 0);
	}
	
	public Saggio(String Nome) throws IdnondisponibileException {
		 super(Nome);
		 ID="S"+(int)(Math.random()*100);
		 libri=0;
		 listaid.add(ID);
		 }

	@Override
	int forza() {
		if(libri>10)return 10;
		return libri;
	}

	@Override
	void augment() {
		libri++;
	}

}
