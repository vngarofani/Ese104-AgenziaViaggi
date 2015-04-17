package agenziaviaggi;

import java.util.*;

public class Pacchetto {
	
	private String codice;
	private String descrizione;
	private int postiTotali;
	private Vector<Prenotazione> prenotazioni;
	
	public Pacchetto(String codice,String descrizione, int postiTotali){
		
		this.codice = codice;
		
		this.descrizione = descrizione;
		
		this.postiTotali = postiTotali;

		prenotazioni = new Vector<Prenotazione>();
	}
	
	public String getCodice(){
		return this.codice;
	}
	
	public String getDescrizione(){
		return this.descrizione;
	}
	
	public int getPostiTotali(){
		return this.postiTotali;
	}
	
	public int getPostiDisponibili(){
		Prenotazione p;
		int posti = this.postiTotali;
		for (int i = 0; i < prenotazioni.size(); i++) {
			p = prenotazioni.elementAt(i);
			posti -= p.getPostiRichiesti();
		}
		return posti;
	}
	
	public Vector<Prenotazione> getPrenotazioni() {
		return this.prenotazioni;
	}
	
	public void addPrenotazione(Prenotazione p) throws Exception{
		if (this.getPostiDisponibili() < p.getPostiRichiesti())
			throw new Exception(
					"posti richiesti maggiori di quelli disponibili");
		
		prenotazioni.addElement(p);
		p.setPacchetto(this);
		
	}

	@Override
	public String toString() {
		return "Pacchetto [codice=" + codice + ", destinazione=" + descrizione
				+ ", postiTotali=" + postiTotali +", posti disponibili:"+this.getPostiDisponibili()+""
				+ ", numero prenotazioni: "+prenotazioni.size()+"]";
	}

}