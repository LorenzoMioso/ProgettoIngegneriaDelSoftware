package univr.spesaonline.model;

import java.sql.Date;

public class ResponsabileReparto extends Autenticabile {

    private String matricola;
    private String password;
    private String nome;
    private String cognome;
    private Date dataNascita;
    private String via;
    private String nCivico;
    private String comune;
    private String citta;
    private String comuneDiNascita;
    private String ruolo;

    public ResponsabileReparto(String matricola, String password, String nome, String cognome, Date dataNascita, String via, String nCivico, String comune, String citta, String comuneDiNascita, String ruolo) {
        this.matricola = matricola;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.via = via;
        this.nCivico = nCivico;
        this.comune = comune;
        this.citta = citta;
        this.comuneDiNascita = comuneDiNascita;
        this.ruolo = ruolo;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
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



};
