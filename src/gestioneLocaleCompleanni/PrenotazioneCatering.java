package gestioneLocaleCompleanni;
import java.util.Date;//classe per la data
import java.io.Serializable;

//creo la sottoclasse PrenotazioneCatering, che estende la superclasse PrenotazioneLocale
public class PrenotazioneCatering extends PrenotazioneLocale {
	//versione UID
	static final long serialVersionUID=1;//cost. per distinguiere le v delle classi
	
	//Variabili d'istanza - proprietà degli obj PrenotazioneCatering
	//private Date dataFesta; //cambiato da data --> dataFesta
	/************************************************************************************/
	/**********************CI SERVE DATA ANCHE QUI? *************************************/
	/************************************************************************************/
	//private String cliente;
	/************************************************************************************/
	/**********************CI SERVE CLIENTE ANCHE QUI? **********************************/
	/************************************************************************************/
	private int bambini;//numero bambini invitati di tipo integer, proprietà aggiunta a PrenotazioneCatering rispetto a PrenotazioneLocale
	 
	//costruttore degli obj PrenotazioneCatering
	/************************************************************************************/
	/****Ereditare proprietà data e cliente dalla superclasse PrenotazioneLocale****/
	/************************************************************************************/
	public PrenotazioneCatering (Date dataFesta, String cliente, int numeroBambini) {
		super (dataFesta, cliente); //eredito dalla superclasse
	/**** Aggiunto numero Bambini per eliminare errore, ma non dovrebbe essere ereditato dalla superclasse***/
		//proprietà della sottoclasse PrenotazioneCatering
		this.bambini=numeroBambini; //numero bambini invitati
		this.formaPrenotazione="Affitto locale con catering";
}
	// Metodi get per usare le variabili private
	
	/////controllare se servono tutti questi get!
	
	//Metodo get che restituisce il nome del cliente
	/************************************************************************************/
	/****Ereditare proprietà data e cliente dalla superclasse PrenotazioneLocale****/
	/************************************************************************************/
    //public String getCliente() {
    //	return this.cliente;
    //}
	
	//Metodo get che restituisce il numero dei bambini invitati
	public int getnumeroBambini() {
	    return this.bambini;
	}
	
	//Metodo get che restituisce la data
	//dà errore perchè bisogna cambiare nella superclasse
	/************************************************************************************/
	/****Ereditare proprietà data e cliente dalla superclasse PrenotazioneLocale****/
	/************************************************************************************/
	//public Date getData() {
	//    return this.dataFesta;
	//}

	//Metodo get che restituisce la forma di prenotazione

	 public String getformaPrenotazione() {
	    return this.formaPrenotazione;
	 }
	
	//Metodo per ottenere i dettagli sulla prenotazione fatta
	public void getDati() {
		//qui bisogna usare i "get" da definire nella superclasse!!!
		System.out.println("Prenotazione effettuata da:"+this.getCliente());
		System.out.println("per "+ this.getnumeroBambini()+ "bambini");
		System.out.println("per il giorno "+ this.getData());
		System.out.println("La festa di compleanno include servizi di :"+this.getformaPrenotazione());//solo affitto, catering o catering e animazione
	}
}
