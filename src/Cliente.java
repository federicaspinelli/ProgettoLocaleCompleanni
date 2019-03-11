public class Cliente {
	private String nome; // nome e cognome
	// costruttore
	public Cliente (String nome) {
		this.nome = nome;
	}
	public String getNome() {return nome;}
	public void setNome (String nome) {
		this.nome = nome ;
	}
// visualizza i dati del cliente
	public void visualizza () {
		System . out . println (" Nome : " + nome );
		System . out . println ();
	}
}