package com.supermarket.fedelity.card.entity;

import java.time.OffsetDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends BaseEntity {

	@Id	
	@Column(name = "id_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cognome")
	private String cognome;

	@Column(name = "indirizzo")
	private String indirizzo;

	@Column(name = "numero_di_telefono")
	private String numeroTelefono;

	@Column(name = "email")
	private String email;

	@Column(name = "data_tesseramento")
	private OffsetDateTime dataTesseramento;

	@Column(name = "numero_tessera")
	private String numeroTessera;

	@Column(name = "storici_acquisti")
	private String storiciAcquisti;
	
    @ManyToOne
    @JoinColumn(name = "carta_fedelta_id")
    private FedelityCard fedelityCard;
    
    @OneToMany
    @JoinColumn(name = "id_acquisti")
    private List<Acquisto> acquisti;
    
    @ManyToOne
    @JoinColumn(name = "tipo_cliente_id")
    private TipoCliente tipoCliente;
    
//    public Cliente() {}
//
//	public Cliente(long id, String nome, String cognome, String indirizzo, String numeroTelefono, String email,
//			String numeroTessera, String storiciAcquisti, FedelityCard fedelityCard) { // only test
//		this.id = id;
//		this.nome = nome;
//		this.cognome = cognome;
//		this.indirizzo = indirizzo;
//		this.numeroTelefono = numeroTelefono;
//		this.email = email;
//		this.numeroTessera = numeroTessera;
//		this.storiciAcquisti = storiciAcquisti;
//		this.fedelityCard = fedelityCard;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public OffsetDateTime getDataTesseramento() {
		return dataTesseramento;
	}

	public void setDataTesseramento(OffsetDateTime dataTesseramento) {
		this.dataTesseramento = dataTesseramento;
	}

	public String getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(String numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	public String getStoriciAcquisti() {
		return storiciAcquisti;
	}

	public void setStoriciAcquisti(String storiciAcquisti) {
		this.storiciAcquisti = storiciAcquisti;
	}
	
	public FedelityCard getFedelityCard() {
		return fedelityCard;
	}

	public void setFedelityCard(FedelityCard fedelityCard) {
		this.fedelityCard = fedelityCard;
	}

	public List<Acquisto> getAcquisti() {
		return acquisti;
	}

	public void setAcquisti(List<Acquisto> acquisti) {
		this.acquisti = acquisti;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

//	public static void main(String[] args) {
//		Gson gson = new Gson();
//
//		System.out.println(gson.toJson(new Cliente(0l, "a", "a", "a", "a", "a", "a", "a", new FedelityCard(0l, "a", 0l, 0l))));
//		;
//	}

}
