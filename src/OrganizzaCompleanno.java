public class OrganizzaCompleanno {

	public static void main(String[] args) {
		//crea un nuovo cliente
		Cliente c1=new Cliente("Nome", "Cognome");
		Cliente c2=new Cliente("Nome", "Cognome");
		//crea prenotazioni
		//Prenotazione p=new Prenotazione("Nome Cognome","Data prenotazione","forma prenotazione", "numero bambini, "tipo animazione");
		Prenotazione p=new Prenotazione("Chiara Zamberti","23/04/2019","Catering+Animazione", "20", "spettacolo di magia");
		//prenota compleanno per il cliente
		boolean ok1=p.prenota(c1);
		boolean ok2=p.prenota(c2);
		//controlla che la prenotazione sia andata a buon fine (esito prenotazione)
		if (!ok1||!ok2) System.out.println("Si sono verificati dei problemi...");
		//stampa l'elenco delle prenotazioni --> con serializzazione, bisogna ordinarli per data
		p.stampaPrenotazioni();
		//stampa giorni disponibili (bisogna controllare che ci sia solo una prenotazione per giorno)
		System.out.println("giorni disponibili:"+p.giorniDisponibili());
		
		
	}

}
