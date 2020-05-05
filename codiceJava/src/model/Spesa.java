package model;

import model.Date;
import model.Ora;
import model.Prodotto;

/************************************************************/
/**
 * 
 */
public class Spesa {
	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private Date dataConsegna;
	/**
	 * 
	 */
	private Ora oraInizio;
	/**
	 * 
	 */
	private Ora oraFine;
	/**
	 * 
	 */
	private int costoTot;
	/**
	 * 
	 */
	private int saldoPunti;
	/**
	 * 
	 */
	private String pagamento;
	/**
	 * 
	 */
	public Prodotto[] prodotto;
	/**
	 * 
	 */
	private String stato;

	public int getId() {
		return id;
	}

	public Date getDataConsegna() {
		return dataConsegna;
	}

	public Ora getOraInizio() {
		return oraInizio;
	}

	public Ora getOraFine() {
		return oraFine;
	}

	public int getCostoTot() {
		return costoTot;
	}

	public int getSaldoPunti() {
		return saldoPunti;
	}

	public String getPagamento() {
		return pagamento;
	}

	public Prodotto[] getProdotto() {
		return prodotto;
	}

	public String getStato() {
		return stato;
	}

};
