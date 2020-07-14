package personaggi;

import java.util.Vector;

public class Mago extends personaggio{
	
	Vector<ingredienti> pozioni;

	public Mago(String ID, String Nome) throws IdnondisponibileException {
		super(ID, Nome);
		if(!(ID.startsWith("M")))throw new IdnondisponibileException(" id inizia con lettera sbagliata");
		pozioni=new Vector<ingredienti>();
	}
	
	public Mago(String Nome) throws IdnondisponibileException {
	 super(Nome);
	 ID="M"+(int)(Math.random()*100);
	 listaid.add(ID);}

	@Override
	int forza() {
	int p;
	for(ingredienti i:pozioni))
	{if(i.equals(ingredienti.basilico)if(i.quantità>5)return 10;}
	return 6;}

	
	@Override
	void augment() {
		for(ingredienti i:pozioni) {
			if(i.equals(ingredienti.basilico)) {
				if(i.quantità<10) {
					i.quantità++;
					return;
				}
			}
				}
		pozioni.add(ingredienti.basilico);
		return ;
	}
	
}
