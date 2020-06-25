package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sede database table.
 * 
 */
@Entity
@NamedQuery(name="Sede.findAll", query="SELECT s FROM Sede s")
public class Sede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sede")
	private Integer idSede;

	private String citta;

	private String descrizione;

	private String indirizzo;

	private String nome;

	//bi-directional many-to-one association to Clienti
	@OneToMany(mappedBy="sede")
	private List<Clienti> clientis;

	//bi-directional many-to-one association to Dipendenti
	@OneToMany(mappedBy="sede")
	private List<Dipendenti> dipendentis;

	//bi-directional many-to-one association to Azienda
	@ManyToOne
	@JoinColumn(name="partita_iva")
	private Azienda azienda;

	public Sede() {
	}

	public Integer getIdSede() {
		return this.idSede;
	}

	public void setIdSede(Integer idSede) {
		this.idSede = idSede;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Clienti> getClientis() {
		return this.clientis;
	}

	public void setClientis(List<Clienti> clientis) {
		this.clientis = clientis;
	}

	public Clienti addClienti(Clienti clienti) {
		getClientis().add(clienti);
		clienti.setSede(this);

		return clienti;
	}

	public Clienti removeClienti(Clienti clienti) {
		getClientis().remove(clienti);
		clienti.setSede(null);

		return clienti;
	}

	public List<Dipendenti> getDipendentis() {
		return this.dipendentis;
	}

	public void setDipendentis(List<Dipendenti> dipendentis) {
		this.dipendentis = dipendentis;
	}

	public Dipendenti addDipendenti(Dipendenti dipendenti) {
		getDipendentis().add(dipendenti);
		dipendenti.setSede(this);

		return dipendenti;
	}

	public Dipendenti removeDipendenti(Dipendenti dipendenti) {
		getDipendentis().remove(dipendenti);
		dipendenti.setSede(null);

		return dipendenti;
	}

	public Azienda getAzienda() {
		return this.azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

}