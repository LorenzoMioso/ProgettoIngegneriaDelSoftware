
package model;

import java.sql.Date;


public class ResponsabileReparto {

	private String matricola;
	private Date dataNascita;
	private String via;
	private String nome;
	private String citta;
	private String username;
	private String cognome;
	private String nCivico;
	private String comune;
	private String comuneDiNascita;
	private String ruolo;
	private String password;

    public ResponsabileReparto(String matricola, Date dataNascita, String via, String nome, String citta, String username, String cognome, String nCivico, String comune, String comuneDiNascita, String ruolo, String password) {
        this.matricola = matricola;
        this.dataNascita = dataNascita;
        this.via = via;
        this.nome = nome;
        this.citta = citta;
        this.username = username;
        this.cognome = cognome;
        this.nCivico = nCivico;
        this.comune = comune;
        this.comuneDiNascita = comuneDiNascita;
        this.ruolo = ruolo;
        this.password = password;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getnCivico() {
        return nCivico;
    }

    public void setnCivico(String nCivico) {
        this.nCivico = nCivico;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getComuneDiNascita() {
        return comuneDiNascita;
    }

    public void setComuneDiNascita(String comuneDiNascita) {
        this.comuneDiNascita = comuneDiNascita;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
};
