import java.util.Scanner;
public class Prenotazione {
	Scanner input= new Scanner(System.in);
	//Prenotazione p=new Prenotazione("Chiara Zamberti","23/04/2019","Catering+Animazione", "20", "spettacolo di magia");
	private String cliente ; // nome cognome cliente
	private String dataOra ; // data e ora prenotazione
	private String forma ; // forma di prenotazione (semplice affitto locale, affitto locale + catering, affitto locale + caterning + animazione)
	private int numeroBambini=input.nextInt("Inserisci numero bambini"); //numero in input
	private String tipoAnimazione; //tipo di animazione: spettacolo di magia, giochi, spettacolo di burattini
	
	// array che contiene i clienti ( classe Cliente )
	private Cliente [] clienti ;
	// contatore delle prenotazioni effettuate da ogni utente (inizializzato a 0)
	private int contatorePrenotazioni = 0;
	//giorno da prenotare
	private int giorno=input.nextInt();
	// costante condivisa che indica la disponibilità per il giorno sul calendario 
	private static final boolean DISPONIBILITA =true;
	// costruttore
	
// elementi per Prenotazione: "Nome Cognome","Data prenotazione","forma prenotazione", "numero bambini, "tipo animazione");
		public Prenotazione ( String cliente , String dataOra ,
		String forma, int numeroBambini, String tipoAnimazione) {
			this.cliente = cliente;
			this.dataOra = dataOra;
			this.forma = forma;
			this.numeroBambini= numeroBambini;
			this.tipoAnimazione= tipoAnimazione;
			// inizializza l’array ( inizialmente pieno di null )
			//this.clienti = new Cliente [CAPIENZA];
		}
		// restituisce il numero di giorni ancora disponibili
		public int giorniDisponibili () {
			return DISPONIBILITA ;
		}
		// consente di prenotare un nuovo posto (lavorarci: dobbiamo cercare come fare il controllo su un calendario)
//		// restituisce false se c'è già una prenotazione per quel giorno
//		public boolean verificaDisponibilita (Calendario ) {
//			if ( giorno >0) {
//				spettatori [ postiPrenotati ] = spettatore ;
//				postiPrenotati ++;
//				return true ;
//			}
//			else return false ;
//		}
//		// stampa l’elenco delle prenotazioni
//		public void stampaPrenotazioni () {
//			System . out . println (" Spettacolo " + titolo );
//			System . out . println (" Del " + dataora );
//			System . out . println (); // riga vuota
//			for (int i =0; i < postiPrenotati ; i ++) {
//				spettatori [i ]. visualizza ();
//			}
//		}
}