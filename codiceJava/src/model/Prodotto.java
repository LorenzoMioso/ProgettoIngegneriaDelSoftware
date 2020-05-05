package model;

import model.Immagine;

/************************************************************/
/**
 * 
 */
public class Prodotto {
	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private String nome;
	/**
	 * 
	 */
	private String marca;
	/**
	 * 
	 */
	private String reparto;
	/**
	 * 
	 */
	private int quantita;
	/**
	 * 
	 */
	private int prezzo;
	/**
	 * 
	 */
	private Immagine immagine;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	public String getReparto() {
		return reparto;
	}

	public int getQuantita() {
		return quantita;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public Immagine getImmagine() {
		return immagine;
	}

};
