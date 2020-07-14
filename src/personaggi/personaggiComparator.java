package personaggi;

import java.util.Comparator;

public class personaggiComparator implements Comparator<personaggio> {

	@Override
	public int compare(personaggio a, personaggio b) {
		return a.Nome.compareTo(b.Nome);
	}
	
}
