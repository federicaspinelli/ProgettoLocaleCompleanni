package gestioneLocaleCompleanni;
import java.util.Date;//classe per la data
import java.io.Serializable;

//creo la sottoclasse PrenotazioneCatering, che estende la superclasse PrenotazioneLocale
public class PrenotazioneCatering extends PrenotazioneLocale implements Serializable {
	//versione UID
	static final long serialVersionUID=1;//cost. per distinguiere le v delle classi
	
	//proprietà degli obj PrenotazioneCatering
	/**** Cambiato nome variabile d'istanza****/
	/****Varibili d'istanza data e cliente non necessarie perchè estratte da superclasse PrenotazioneLocale****/
	//protected Date data; //cambiato da dataFesta --> a data
	//protected String cliente;
	private int bambini;//numero bambini invitati
	
	//costruttore degli obj PrenotazioneCatering
	public PrenotazioneCatering (Date dataFesta, String nomeCliente, int numeroBambini ) {
		super(dataFesta, nomeCliente); //eredito dalla superclasse
		
		//proprietà della sottoclasse PrenotazioneCatering
		this.bambini=numeroBambini; //numero bambini invitati
		this.formaPrenotazione="Affitto locale con catering";		

}
	// Metodi get per usare le variabili private
	
	/////controllare se servono tutti questi get!
	
	//Metodo get che restituisce il nome del cliente
    public String getCliente() {
    	return this.cliente;
    }
	
	//Metodo get che restituisce il numero dei bambini invitati
	public int getNumeroBambini() {
	    return this.bambini;
	}
	
	//Metodo get che restituisce la data
	//dà errore perchè bisogna cambiare nella superclasse
	public Date getData() {
	  return this.data;
	}

	//Metodo get che restituisce la forma di prenotazione
	 public String getformaPrenotazione() {
	    return this.formaPrenotazione;
	 }
	
	//metodo per ottenere i dettagli sulla prenotazione fatta
	public void getDati() {
		//qui bisogna usare i "get" da definire nella superclasse!!!
		System.out.println("Prenotazione effettuata da:"+this.getCliente());
		System.out.println("per "+ this.getNumeroBambini()+ "bambini");
		System.out.println("per il giorno "+ this.getData());
		System.out.println("La festa di compleanno include servizi di :"+this.getformaPrenotazione());//solo affitto, catering o catering e animazione
	}
}
