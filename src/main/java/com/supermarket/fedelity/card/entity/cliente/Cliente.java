package com.supermarket.fedelity.card.entity.cliente;

import java.time.OffsetDateTime;
import java.util.List;

import com.supermarket.fedelity.card.entity.azienda.puntovendita.FedelityCard;

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
public class Cliente {

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
    private FedelityCard cartaFedelta;
    
    @OneToMany
    @JoinColumn(name = "acquisti_id")
    private List<Acquisto> acquisti;
    
    @ManyToOne
    @JoinColumn(name = "tipo_cliente_id")
    private TipologiaCliente tipoCliente;

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

	public FedelityCard getCartaFedelta() {
		return cartaFedelta;
	}

	public void setCartaFedelta(FedelityCard cartaFedelta) {
		this.cartaFedelta = cartaFedelta;
	}

	public List<Acquisto> getAcquisti() {
		return acquisti;
	}

	public void setAcquisti(List<Acquisto> acquisti) {
		this.acquisti = acquisti;
	}	

	public TipologiaCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipologiaCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo
				+ ", numeroTelefono=" + numeroTelefono + ", email=" + email + ", dataTesseramento=" + dataTesseramento
				+ ", numeroTessera=" + numeroTessera + ", storiciAcquisti=" + storiciAcquisti + ", cartaFedelta="
				+ cartaFedelta + ", acquisti=" + acquisti + "]";
	}

}
