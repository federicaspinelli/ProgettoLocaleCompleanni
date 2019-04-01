package gestioneLocaleCompleanni;
import java.util.Date;//classe per la data
import java.io.Serializable;

public class PrenotazioneCateringAnimazione extends PrenotazioneCatering implements Serializable{
	//versione UID
	static final long serialVersionUID=1;
	//inizializzo la stringa tipo animazione
	private String animazione;
	//creo il costruttore
	//cambiato da data --> dataFesta
	public PrenotazioneCateringAnimazione(Date dataFesta, String cliente, int bambini, String tipoAnimazione){
		super(dataFesta, cliente, bambini);
		this.formaPrenotazione="Affitto del locale con catering e animazione"; //tipo di evento, con catering
		this.animazione = tipoAnimazione;
	}
	
	
// Metodi get per usare le variabili private
	
	//get per il tipo di animazione
	public String getTipoAnimazione() {
		return animazione;
	}
	//visualizzo tutto
	public void getDati() {
		//qui bisogna usare i "get" da definire nella superclasse!!!
		System.out.println("Prenotazione effettuata da:"+this.getCliente());
		System.out.println("per "+ this.getNumeroBambini());
		System.out.println(" invitati, per il giorno "+ this.getData());
		System.out.println("La festa di compleanno include servizi di :"+this.getformaPrenotazione());//solo affitto, catering o catering e animazione
		System.out.println("Con animazione: " + this.getTipoAnimazione());//solo affitto, catering o catering e animazione

	}
}
