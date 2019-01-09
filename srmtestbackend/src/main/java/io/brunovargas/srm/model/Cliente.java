package io.brunovargas.srm.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.brunovargas.srm.enumeration.Risco;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message="É obrigatório informar um nome")
	private String nome;

	private Date creation_date;

	@NotNull(message="É obrigatório informar o limite de crédito")
	@PositiveOrZero(message="O valor de limite deve ser maior ou igual a zero")
	private Double limite_credito;

	private Double taxa_juros;

	private Risco risco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	@PrePersist
	private void defineCreationDate() {
		this.creation_date = new Date();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLimite_credito() {
		return limite_credito;
	}

	public void setLimite_credito(Double limite_credito) {
		this.limite_credito = limite_credito;
	}

	public Double getTaxa_juros() {
		return taxa_juros;
	}

	public void setTaxa_juros(Double taxa_juros) {
		this.taxa_juros = taxa_juros;
	}

	public Risco getRisco() {
		return risco;
	}

	public void setRisco(Risco risco) {
		this.risco = risco;
	}

}
