/* PrenotazioneLocale.java :  File che contiene la definizione della classe PrenotazioneLocale
 * PrenotazioneLocale : Classe principale che definisce la forma di prenotazione che prevede semplice affitto del locale 
 * (cibo e animazione a carico dei genitori) 
 * Definisce un oggetto prenotazione con semplice affitto del locale.
 * Superclasse di PrenotazioneCatering
 * Package : 
 * GestioneLocaleCompleanni
 * La classe contiene :
 * Variabili d'istanza
 * Costruttore:
 * Insieme di metodi Get (per ogni dato) : restituiscono i valori delle variabili d'istanza
 * Insieme di metodi Printer : restituiscono in output la prenotazione effettuata 
 * Superclasse Estesa da : 
 * PrenotazioneCatering
 * PrenotazioneAnimazione
 * */ 
package gestioneLocaleCompleanni;
import java.io.Serializable;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;

// Questa classe descrive un oggetto prenotazione che prevede semplice affitto del locale
// implementa Serializable per poter essere salvata su file
public class PrenotazioneLocale implements Serializable {
	//versione UID
	static final long SerialVersionUID = 1;
	
	// proprieta oggetti della classe PrenotazioneLocale
	private Date dataFesta;
	// nomeCliente : definisce nome del cliente che effettua la prenotazione
	private String nomeCliente;
	// formaPrenotazione : definisce le diverse forme di prenotazione previste
	//			- affitto del locale (cibo e animazione a carico dei genitori)
	//			- affitto del locale con servizio di catering
	//			- affitto del locale con servizio di catering e animazione
	
	//vedere se si può lasciare come private impostato
	//getter e setter
	protected String formaPrenotazione;	
	/**** NON SERVE ANCHE QUI, basta in PrenotazioneCatering****/
	//private int bambini;//numero bambini invitati
	// costruttore
	// definisce un oggetto prenotazione che prevede semplice affitto del locale
	public PrenotazioneLocale(Date dataFesta, String cliente) {
		this.dataFesta = dataFesta;
		this.nomeCliente = cliente;
		//this.bambini = numeroBambini; //numero bambini invitati
		this.formaPrenotazione = "Affitto locale";		
	}
	
	// Metodi get per usare le variabili private
	 
	// Restituisce la data della prenotazione 
	public Date getData() {
		return this.dataFesta;
	}
	
	// Restituisce il nome del cliente 
	public String getCliente () {
		return this.nomeCliente;
	}
	
	/**** NON SERVE ANCHE QUI, basta in PrenotazioneCatering****/
	//Metodo get che restituisce il numero dei bambini invitati
	//	public int getnumeroBambini() {
	//	    return this.bambini;
	//	}
	
	// Restituisce forma di prenotazione
	public String getformaPrenotazione () {
		return this.formaPrenotazione;		
	}
	

	// Restituisce la data in formato Stringa 
//	public String getDataStringa(){
//		SimpleDateFormat DataInStringa = new SimpleDateFormat("dd/MM/yyyy");
//		return DataInStringa.format(this.dataFesta.getTime());
//	}
	
	//visualizzo tutto

	public void getDati() {
		//qui bisogna usare i "get" da definire nella superclasse!!!
		System.out.println("Prenotazione effettuata da:"+this.getCliente());
		//System.out.println("per "+ this.getnumeroBambini());
		System.out.println(" invitati, per il giorno "+ this.getData());
		System.out.println("La festa di compleanno include servizi di :"+this.getformaPrenotazione());//solo affitto, catering o catering e animazione
	}

}
