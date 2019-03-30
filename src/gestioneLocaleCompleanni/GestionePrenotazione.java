package gestioneLocaleCompleanni;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;//scanner
import java.util.Vector;//vector

import concessionaria_auto.Auto_nuove;

//per date
import java.text.*;


// buffered Input e Output
import java.io.BufferedInputStream; 
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//per lo stream
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//per le eccezioni
import java.io.IOException;

//importo le eccezioni
import gestioneLocaleCompleanni.EccezioneData1;
import gestioneLocaleCompleanni.EccezioneData2;
import gestioneLocaleCompleanni.EccezioneData3;
import gestioneLocaleCompleanni.EccezioneCliente;


public class GestionePrenotazione {
	//vettore che conterrà l'elenco delle prenotazioni
	private Vector <PrenotazioneLocale> elenco= new Vector <PrenotazioneLocale>();
	//leggo ciò che viene immesso in input
	Scanner input= new Scanner (System.in);
	//costruttore della classe
	public GestionePrenotazione() {
		//per ora è vuoto perchè viene inizializzato nel metodo letturaPrenotazione
	} 
public void letturaPrenotazione() {
	//metodo per la lettura degli oggetti PrenotazioneLocale creati
	try {
		//nuovo stream (come da slides), salvataggio di vettore (2), p30
		ObjectInputStream input= new ObjectInputStream(new BufferedInputStream(
				new FileInputStream("serializza.dat")));
		//inizializzo il vettore elenco con gli oggetti di PrenotazioneLocale e li salvo nel file serializza.dat
		elenco = (Vector<PrenotazioneLocale>) input.readObject();
		input.close();	
		

		//eccezioni
	} catch (ClassNotFoundException e) {
		// se il file non contiene un oggetto ....
    	System.out.println(" PROBLEMA ( manca oggetto nel file )");
		System.out.println(e); 
		
	} catch ( IOException e) {
		System.out.println (" ERRORE di I/O");
		System.out.println (e);
	}
	
	// stampa quanto letto dal file
	//System . out . println ( elenco );
	
}/////

//metodo per la creazione del menù per permettere all'utente di effettuare le scelte 
public void MenuElencoPrenotazioni(){
	// crea un registro usando il file indicato dall'utente
	//RegistroEtaCompleto registro = new RegistroEtaCompleto(nomefile);
	char scelta;
	System.out.println("Gestione locale per compleanni di bambini");
	System.out.println("Inserisci la lettera corrispondente all'operazione da effettuare per iniziare");
	do {
		System.out.println("");
		//elenco delle scelte 
		System.out.println("");
		
		//scelta per visualizzare le prenotazioni effettuate
		//se non ci sono prenotazioni, verrà mostrato un messaggio a video
		///TODO VISUALIZZARE IN ORDINE DI DATA
		System.out.println("   [V] Visualizza prenotazioni ");
		System.out.println("");
		
		///TODO LAVORARE SU VISUALIZZAZIONE SOLO CATERING ED EVENTUALMENTE ANIMAZIONE
//		System.out.println("   [C] Visualizza solo le prenotazioni con catering (in ordine di data)");
//		System.out.println("");
		
		///TODO LAVORARE SU VISUALIZZAZIONE SOLO ANIMAZIONE
//		System.out.println("   [A] Visualizza tutte le prenotazioni con animazione (in ordine di data) ");
//		System.out.println("");	
//		
		///TODO LAVORARE SUL CONTROLLO DELLA DATA DISPONIBILE
		System.out.println("  [D] Controlla se la data è disponibile");
		System.out.println("");	
		
		//scelta per aggiungere una prenotazione all'elenco
		System.out.println("   [+] Aggiungi una prenotazione");
		System.out.println("");
		
		//scelta per cancellare una prenotazione dall'elenco
		System.out.println("   [-] Cancella una prenotazione");
		System.out.println("");
		
		//scelta per ricercare una prenotazione
		//TODO RICERCARE PER UTENTE? RICERCARE PER DATA?
		System.out.println("   [R] Ricerca una prenotazione");
		System.out.println("");
		
		//scelta per salvare i dati
		System.out.println("[S] Salva dati: "); 
		
		//scelta per uscire dal terminale
		System.out.println("[*] Uscire dal terminale");
		System.out.println("");
		System.out.println("Scegliere un'opzione");
		//input utente, considero il primo carattere immesso
		scelta = input.next().charAt(0);
		System.out.println("");
		switch (scelta) {  // in base alla lettera inserita dovra' attivarsi una precisa funzione (un preciso metodo verra' richiamato), come indicato nelle istruzioni sopra

		
		// visualizzare tutte le prenotazioni in ordine di data
		
		/////metodi al plurale per distinguerli!
		case 'V': 
		///TODO CREARE METODO DI VISUALIZZAZIONE IN ORDINE DI DATA
		///TODO VEDERE SE IMPLEMENTARE TRY/CATCH E CREARE ECCEZIONE
		visualizzaPrenotazioni();
		break;
		
//		// visualizzare le prenotazioni solo con catering ed eventualmente animazione in ordine di data
//		case 'C': 
//		///TODO CREARE METODO DI VISUALIZZAZIONE PRENOTAZIONI SOLO CATERING E EV. ANIMAZIONE (IN ORDINE DI DATA?)
//		///TODO VEDERE SE IMPLEMENTARE TRY/CATCH E CREARE ECCEZIONE
//		visualizzaPrenotazioniCatering();
//		break;
//		
//		// visualizzare solo le prenotazioni con animazione
//		case 'A': 
//		///TODO CREARE METODO DI VISUALIZZAZIONE PRENOTAZIONI SOLO ANIMAZIONE (IN ORDINE DI DATA?)
//		///TODO VEDERE SE IMPLEMENTARE TRY/CATCH E CREARE ECCEZIONE
//		visualizzaPrenotazioniAnimazione();
//		break;
		

		// controllare se la data è disponibile per una prenotazione
		///TODO CREARE METODO PER IL CONTROLLO DELLA DATA
		case 'D':
			try {
			   ////originariamente: aggiungiAuto();
				checkDisponibilitaData();
			}
			///TODO MODIFICARE GESTIONE ECCEZIONE DATA IN FORMATO ERRATO
			///SCHELETRO ECCEZIONE DATA GIA CREATO!
			catch (EccezioneData1 e) {  // in caso la data sia in un formato errato
			   System.out.println("");
			   System.out.println("DATA IN FORMATO ERRATO. RIPROVARE!");
			}
			catch (EccezioneData2 e) {  // in caso la data inserita sia già presente nell'elenco prenotazioni
				System.out.println("");
				System.out.println("DATA NON DISPONIBILE, RIPROVARE!");			
			///TODO GESTIRE IL DOVER PROPORRE UNA NUOVA DATA SUCCESSIVA A QUELLA CHE
			///NON E' DISPONIBILE
			}
			
		
		//aggiungere una prenotazione all'elenco

		case '+':
			try {
				///TODO CREARE METODO AGGIUNGIPRENOTAZIONE
			   aggiungiPrenotazione();
			}
			///TODO UTILIZZARE LE STESSE ECCEZIONI
			///USATE PER IL CONTROLLO DATA?
			
			///TODO MODIFICARE GESTIONE ECCEZIONE DATA IN FORMATO ERRATO
			///SCHELETRO ECCEZIONE DATA GIA CREATO!
			catch (EccezioneData1 e) {  // in caso la data sia in un formato errato
			   System.out.println("");
			   System.out.println("DATA IN FORMATO ERRATO. RIPROVARE!");			}
			catch (EccezioneData2 e) {  // in caso la data inserita sia già presente nell'elenco prenotazioni
				System.out.println("");
				System.out.println("DATA NON DISPONIBILE, RIPROVARE!");			
			///TODO GESTIRE IL DOVER PROPORRE UNA NUOVA DATA SUCCESSIVA A QUELLA CHE
			///NON E' DISPONIBILE
			}
			break;

		//cancellare una prenotazione dall'elenco
			///TODO INTRODURRE CANCELLAZIONE PER:
			//PER CLIENTE 
			//PER DATA (?)
		case '-': 
			
			try {
		       cancellaPrenotazione();
			}
			///TODO QUI GESTIRE CANCELLAZIONE PER CLIENTE
		    catch (EccezioneCliente e) {  // se non ci sono prenotazioni per il cliente inserito
		    ///inserisci nome cliente....
		    	input.nextLine();
		       System.out.println("");
			   System.out.println("Non ci sono prenotazioni per questo cliente!");
			///riprovare....
			   input.nextLine();
		    }
			
			
			///TODO QUI GESTIRE CANCELLAZIONE PER DATA
			 catch (EccezioneData1 e) {  // se ci sono errori nel formato data
				    ///inserisci data....
			    	input.nextLine();
			    	System.out.println("");
			    	System.out.println("Data errata. Riprovare!");
			    	///riprovare....
			    	input.nextLine();
			 }			
					
		    catch (EccezioneData3 e) {  // se per quella non ci sono prenotazioni (in ricerca)
		    ///inserisci data....
		    	input.nextLine();
		       System.out.println("");
			   System.out.println("Data non presente nell'archivio!");
			///riprovare....
			   input.nextLine();
		    }
			break;
		
		case 'M':
			try {
			       modificaPrenotazioni();
				}
				///TODO QUI GESTIRE MODIFICA PER CLIENTE
			    catch (EccezioneCliente e) {  // se non ci sono prenotazioni per il cliente inserito
			    ///inserisci nome cliente....
			    	input.nextLine();
			       System.out.println("");
				   System.out.println("Non ci sono prenotazioni per questo cliente!");
				///riprovare....
				   input.nextLine();
			    }
			
			///TODO QUI GESTIRE MODIFICA PER DATA
			 catch (EccezioneData1 e) {  // se ci sono errori nel formato data
				    ///inserisci data....
			    	input.nextLine();
			    	System.out.println("");
			    	System.out.println("Data errata. Riprovare!");
			    	///riprovare....
			    	input.nextLine();
			 }			
					
		    catch (EccezioneData3 e) {  // se per quella non ci sono 
		    ///inserisci data....
		    	input.nextLine();
		       System.out.println("");
			   System.out.println("Data non presente nell'archivio!");
			///riprovare....
			   input.nextLine();
		    }
			break;
		
		//cercare una prenotazione
		///TODO INTRODURRE RICERCA PER:
		//PER CLIENTE 
		//PER DATA
		case 'R':
			try {
			   ricercaPrenotazione();
		    }
			///TODO QUI GESTIRE RICERCARE PER CLIENTE
			 catch (EccezioneCliente e) {  // se non ci sono prenotazioni per il cliente inserito
			 ///inserisci nome cliente....
			 input.nextLine();
			 System.out.println("");
			 System.out.println("Non ci sono prenotazioni per questo cliente!");
			 ///riprovare....
			 input.nextLine();
			 }
			
			
			///TODO QUI RICERCARE PER DATA
			 catch (EccezioneData1 e) {  // se ci sono errori nel formato data
				    ///inserisci data....
			    	input.nextLine();
			    	System.out.println("");
			    	System.out.println("Data errata. Riprovare!");
			    	///riprovare....
			    	input.nextLine();
			 }			
					
		    catch (EccezioneData3 e) {  // se per quella data ci sono già prenotazioni
		    ///inserisci data....
		    	input.nextLine();
		       System.out.println("");
			   System.out.println("Data non presente nell'archivio!");
			///riprovare....
			   input.nextLine();
		    }
			break;
			
			//////TODO INSERIRE ANCHE "MODIFICARE PRENOTAZIONE?"


        System.out.println("");//per separare le righe
 
} while (scelta!='U');  //compi queste operazioni/richiama il menu finchè l'utente non sceglie di uscire, selezionando "U"

System.out.println("ARRIVEDERCI, ALLA PROSSIMA FESTA!");
}
	

	///TODO CREARE METODI DETTI SU...
	
	//metodo per visualizzare tutte le prenotazioni in elenco
	//in ordine di data
	private void visualizzaPrenotazioni() {
		///TODO
		//opzioni sottomenu del terminale
		
		 System.out.println("   [V] Visualizza tutte le prenotazioni (in ordine di data)");
		 System.out.println("   [C] Visualizza solo le prenotazioni catering (ed eventualmente animazione)");
		 System.out.println("   [A] Visualizza solo le prenotazioni con animazione");
		 System.out.println("   [*] Menu principale");
		//chiedo di scegliere un opzione
		 System.out.println("");
		 System.out.println("Scegliere un'opzione");
		//input utente, considero il primo carattere immesso
		 char opzione=input.next().charAt(0);
		 System.out.println(" ");
		//casistica per ogni selezione
		 switch(opzione) {
		 case 'T':
			 //controllo se nell'elenco c'è almeno una prenotazione
			 if (elenco.size()>0) {
				 int i, j, minimo;
				 ////ORDINO LE PRENOTAZIONI PER DATA
				 for(i=0; i<elenco.size()-1;i++) {
					 //data meno recente in posizione i
					 minimo=i;
					 for (j=i; j<elenco.size(); j++) {
						 //getter della data definito in PrenotazioneLocale
						 
						 ///TODO CONTROLLARE SE COSI FUNZIONA!
						 ///SE NON FUNZIONA, PROVARE A CONVERTIRE LA DATA IN STRINGA
						 ///(CON METODO TOSTRING)
						 if (elenco.get(j).getData().compareTo(elenco.get(minimo).getData()) <0) {
							 minimo=j;
						 }	 
					 }
					 //scambio di posizione la prenotazione
					 //con data più recente con la prima selezionata
					 //creo una variabile temporanea
					 PrenotazioneLocale temp=elenco.get(i);
					 //utilizzo il metodo setElementAt per inserire la prenotazione in minima posizione
					 elenco.setElementAt(elenco.get(minimo), i);
					 elenco.setElementAt(temp, minimo);					 
				 }
				 //visualizzo le prenotazioni
				 for (i=0; i<elenco.size();i++) {
					 System.out.println("Tutte le prenotazioni: ");
					 System.out.println ("");
					 //invocazione del metodo getDati definito in PrenotazioneLocale
					 elenco.get(i).getDati();
					 //stampo
				    System.out.println("Prenotazione " + (i+1) + ":"); 
				 }
			 	 
			//se l'elenco non ha prenotazioni all'interno
			 }else System.out.println("Non sono presenti prenotazioni!");
			break;
		
		//Visualizza solo le prenotazioni con catering (ed eventualmente animazione)
		case  'C':
			//indici
			int i, j;
			//controllo se nell'elenco sono presenti prenotazioni con caztering
			boolean cateringOK=false; //inizializzo la variabile booleana come false
			//se trovo almeno una prenotazione con catering:
			
			//TODO in caso non andasse, fare una sola iterazione:
			//for (int i=0, j=0; i<elenco.size(); i++) {

			for (i=0; i<elenco.size()-1; i++) {
				for (j=0; j<elenco.size();j++) {
					//se esiste almeno un'istanza di PrenotazioneCatering
					//cambio il valore del booleano cateringOK in true
					if (elenco.get(i) instanceof PrenotazioneCatering) {
						cateringOK=true;
						 //invocazione del metodo getDati definito in PrenotazioneCatering
						 elenco.get(i).getDati();
						 //stampo
				    	System.out.println("Prenotazione " + (j+1) + ":"); 

					}
					//controllo il valore del booleano cateringOK
					//se falso:
					if (cateringOK==false) {
						System.out.println("Non sono presenti prenotazioni con catering!");
					}
				}//
			}///
				break;
			
			//Visualizza solo le prenotazioni con animazione
			case 'A':
				//TODO in caso non andasse, fare una sola iterazione:
				//for (int i=0, j=0; i<elenco.size(); i++) {
				boolean animazioneOK = false;
				for (i=0; i<elenco.size()-1; i++) {
					for (j=0; j<elenco.size();j++) {
						//se esiste almeno un'istanza di PrenotazioneCateringAnimazione
						//cambio il valore del booleano animazioneOK in true
						if (elenco.get(i) instanceof PrenotazioneCateringAnimazione) {
							animazioneOK=true;
							 //invocazione del metodo getDati definito in PrenotazioneCatering
							 elenco.get(i).getDati();
							 //stampo
					    	System.out.println("Prenotazione " + (j+1) + ":"); 

						}
						//controllo il valore del booleano cateringOK
						//se falso:
						if (animazioneOK==false) {
							System.out.println("Non sono presenti prenotazioni con animazione!");
						}
					}//
				}///
						break;	
					//scelta di default in caso il carattere immesso non fosse presente in lista
					default:  
						System.out.println("Scelta sbagliata!");
						
				}
			
				
				 
			 }
	}
	
	//TODO RICERCA PER CLIENTE, ANCHE CON PARTE DI NOME
	//VEDERE PARTE "ABBREVIAZIONE" PROJ SIMONE

	//TODO AGGIUNGI
	//TODO CANCELLA
	//TODO MODIFICA
	
///////POTREBBE NON ESSERE PIU NECESSARIO can
	private void checkDisponibilitaData(Date data) throws EccezioneData2 {
		//creo una variabile per la data
		//Date data;
		//invoco il metodo getData definito in PrenotazioneLocale
		 
		try {
			
		}
		catch(e) {
		
		}
		
		for (int i=0; i<elenco.size(); i++) {  // scansiono tutte le auto presenti e controllo se e' gia' presente una con targa uguale a quella inserita...
			 //se la data è già presente in archivio
			 if (elenco.get(i).getData().equals(data)) 
				 throw new EccezioneData2();			 
		 }
	}
	
	private void aggiungiPrenotazione() throws EccezioneData1, EccezioneData2, EccezioneData3, EccezioneCliente {
		///TODO
		//scelte effettuabili per l'aggiunta della prenotazione
		 System.out.println("[1] Aggiungi una prenotazione con solo affitto");
		 System.out.println("[2] Aggiungi una prenotazione con servizio di catering");
		 System.out.println("[3] Aggiungi una prenotazione con servizio di catering e animazione");
		 System.out.println("[*] Menu principale");
		 System.out.println("");
		 System.out.println("Scegliere un'opzione");
		 
		 //input utente
		 char opzione=input.next().charAt(0);
		 ///dichiarazione variabili per il metodo
		 Date data;
		 String cliente, catering, animazione;
		 int numeroBambini;
		 switch (opzione){
		 case '1': case '2': case '3'://vale per tutti i casi
			 //chiedo di inserire il nome del cliente da mostrare
			 //nella prenotazione
			 System.out.println("Nome cliente: ");
			 cliente = input.next();
			 System.out.println("");
			 //chiedo di inserire la data per la prenotazione
			 System.out.println("Inserisci la data: ");
			 ///inizializzcontrollo che ciò che inserisce l'utente è corretto
			 boolean tuttoOK;
			 do{
				 //assegno il valore true alla variabile booleana tuttoOK
				 tuttoOK=true;
				 try{
					 String d = input.next();//chiedo all'utente di inserire la data in input
					 //creo uno schema di formattazione per la data nel formato gg/mm/aaaa
		   		     SimpleDateFormat schema = new SimpleDateFormat ("dd/MM/yyyy");
					 //il formato data è corretto? se non lo è
		   		     //viene gestita l'eccezione tramite ParseException
		   		     
		   		     //TODO controllare
		   		     Date dataInput=schema.parse(d);
		   		     
		   		     //che lancia la relativa eccezione in caso di data esistente

		   		     //scansione l'elenco e controllo che non siano presenti già prenotazioni per quel giorno
			   		  for (int i=0; i<elenco.size(); i++) {  
			 			 //se la data è già presente in archivio
			   		     if (elenco.get(i).getData().equals(d)) 
			   		    	throw new EccezioneData2();
			   		     	System.out.print("Non è possibile effettuare una prenotazione per questo giorno, inserire una nuova data...");
			   		     	input.nextInt();
			   		     	///TODO IN CASO NON FUNZIONASSE, LAVORARE CON INSTANCE OF PRENOTAZIONELOCALE
			   		  }

			   		  
				 } //gestiamo il caso in cui la data sia errata
				 catch (ParseException e) { 
	   		          System.out.println("Formato data non valido. Inserirla nel formato mm/gg/aaaa.");
	   		          System.out.println("");
	   		          tuttoOK = false;//lo stato del booleano cambia
	   		          System.out.print("Riprova. Inserisci una data valida: ");
	   		          input.nextLine(); 
	   		       }
			 }while (!tuttoOK);
			 
		 }





		
	}
	
	private void cancellaPrenotazione() {
		///TODO
	}
	
	private void ricercaPrenotazione() {
		///opzioni per la ricerca
		 System.out.println("[C]Ricerca prenotazione per cliente");
		 System.out.println("");
		 //TODO RICERCA PER DATA--> FEDERICA
		 System.out.println("[D] Ricerca prenotazione per data");
		 System.out.println("[*] Menu principale");
		 System.out.println("");
		 //chiedo all'utente di scegliere un'opzione tra le disponibili
		 System.out.println("Scegliere un'opzione");
		//input utente, considero il primo carattere immesso
		 char opzione=input.next().charAt(0);
		 System.out.println("");
		 //switch ricerca
		 switch (opzione){
		 		//ricerca prenotazione per cliente
		 		case 'C':
		 			String nome, parteNome;
		 			//vettore vuoto, serve a contenere le prenotazioni per ogni cliente
		 			PrenotazioneLocale prenotazione;//TODO chiarire a cosa serve
		 			Vector <PrenotazioneLocale> prenotazionePerCliente= new Vector <PrenotazioneLocale>();
		 			System.out.println("Inserisci il nome del cliente (o parte di esso) per cercare la prenotazione: ");
		 
		 			nome=input.next();//stringa dell'intero nome cliente
		 			parteNome= "BLA";// TODO parte di nome, lavorarci. NON USARE SUBSTRING
		 					//MA MAGARI: CONTAINS O INDEXOF
		 					//parte del nome del cliente
		 			
		 			///PER RICERCA TRAMITE NOME INTERO
		 			//se la stringa in input non equivale a un nome "intero"
			    	  if (nome.equals(parteNome)==false) {
			    		  //scansione su elenco
				    		 for (int i=0; i<elenco.size(); i++) {
				    		     if (elenco.get(i) instanceof PrenotazioneLocale) {
				    		    	// TODO CONTROLLARE SE IL TYPE CAST SERVE NEL NOSTRO CASO! (stiamo lavorando su una superclasse!)
				    			     prenotazione = (PrenotazioneLocale)elenco.get(i);  
				    			     //controllo se la stringa inserita in input corrisponde al nome del cliente
				    			     if (prenotazione.getCliente().equals(nome)) {  
				    			    	 //se uguale, aggiungo la prenotazione al vettore creato 
				    			    	 prenotazionePerCliente.add(prenotazione);
				    			     }
				    		     }
				    	     }
				       }else{ 
				    	   ///PER RICERCA TRAMITE PARTE DEL NOME
				    	   //se in input è stata inserita un'abbreviazione e non il nome intero
				    	   //scansione su elenco
				    	   for (int i=0; i<elenco.size(); i++) { 
				    		   if (elenco.get(i) instanceof PrenotazioneLocale) {
				    		    	// TODO CONTROLLARE SE IL TYPE CAST SERVE NEL NOSTRO CASO! (stiamo lavorando su una superclasse!)
					    	       prenotazione = (PrenotazioneLocale)elenco.get(i);
				    			     //controllo se la stringa inserita in input è una sottostringa di nome
					    		   if (prenotazione.getCliente().substring(0, 3).equals(parteNome)) {  // la guardia cambia: devo controllare che le prime tre lettere del cliente dell'auto siano uguali alle tre inserite in input
					    		      prenotazionePerCliente.add(prenotazione);
					    		   }
					    		}
					    	 }
				         }
			    	  
				    	 System.out.println("");
				    	 //se trovo almeno una prenotazione per quel cliente
				    	 if (prenotazionePerCliente.size()>0) { 
				    	    for (int i=0; i<prenotazionePerCliente.size(); i++) {
				    		   System.out.println("Prenotazione: " + (i+1));
				    		   //mostro i risultati
				    		   prenotazionePerCliente.get(i).getDati();
				    		   System.out.println("");
				    	    }
				    	 }
				    	 else System.out.println("Nessuna prenotazione per questo cliente!");  // altrimenti il sistema da' un feedback dicendo che non ci sono attualmente clienti con quel nome
				    	 break;
				    	 
				    	 
				    	 ////TODO AGGIUNGERE CASO DATA
				    	 ////TODO AGGIUNGERE DEFAULT
				    	 
				    	 
				    	 
		 }
		 
	}
	
	
	
	
	
	
	
	
//	//FACOLTATIVO
//	private void modificaPrenotazioni() {
//		
//	}
}

