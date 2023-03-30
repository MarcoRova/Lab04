package it.polito.tdp.lab04.model;

import java.util.Objects;

public class Corso {
	
	private String codins;
	private int crediti;
	private String nome;
	private int pd;

	public Corso(String codins, int crediti, String nome, int pd) {
		super();
		this.codins = codins;
		this.crediti = crediti;
		this.nome = nome;
		this.pd = pd;
	}

	/**
	 * @return the codins
	 */
	public String getCodins() {
		return codins;
	}

	/**
	 * @param codins the codins to set
	 */
	public void setCodins(String codins) {
		this.codins = codins;
	}

	/**
	 * @return the crediti
	 */
	public int getCrediti() {
		return crediti;
	}

	/**
	 * @param crediti the crediti to set
	 */
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the pd
	 */
	public int getPd() {
		return pd;
	}

	/**
	 * @param pd the pd to set
	 */
	public void setPd(int pd) {
		this.pd = pd;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codins);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		return Objects.equals(codins, other.codins);
	}

	@Override
	public String toString() {
		return "Corso " + codins + ", crediti=" + crediti + ", nome=" + nome + ", pd=" + pd;
	}
}

