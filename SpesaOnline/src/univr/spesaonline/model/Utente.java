package univr.spesaonline.model;

import java.sql.Date;

public class Utente extends Autenticabile {

    private String email;
    private String password;
    private String nome;
    private String cognome;
    private Date dataNascita;
    private String via;
    private String nCivico;
    private String citta;
    private String comune;
    private int CAP;
    private String telefono;
    private String pagamentoPreferito;

    public Utente() {
        this.email = null;
        this.password = null;
        this.nome = null;
        this.cognome = null;
        this.dataNascita = null;
        this.via = null;
        this.nCivico = null;
        this.citta = null;
        this.comune = null;
        this.CAP = 0;
        this.telefono = null;
        this.pagamentoPreferito = null;
        this.setIsLogged(false);
        notifyAllObservers();
    }

    public Utente(String email, String password) {
        this.email = email;
        this.password = password;
        notifyAllObservers();
    }

    public Utente(String email, String password, String nome, String cognome, Date dataNascita, String via, String nCivico, String citta, String comune, int CAP, String telefono, String pagamentoPreferito) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.via = via;
        this.nCivico = nCivico;
        this.citta = citta;
        this.comune = comune;
        this.CAP = CAP;
        this.telefono = telefono;
        this.pagamentoPreferito = pagamentoPreferito;
        notifyAllObservers();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
       
        this.email = email;
        notifyAllObservers();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        
        this.password = password;
        notifyAllObservers();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
       
        this.nome = nome;
        notifyAllObservers();
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
      
        this.cognome = cognome;
        notifyAllObservers();
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        
        this.dataNascita = dataNascita;
        notifyAllObservers();
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
      
        this.via = via;
        notifyAllObservers();
    }

    public String getnCivico() {
        return nCivico;
    }

    public void setnCivico(String nCivico) {
        this.nCivico = nCivico;
        notifyAllObservers();
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
        notifyAllObservers();
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
        notifyAllObservers();
    }

    public int getCAP() {
        return CAP;
    }

    public void setCAP(int CAP) {
        this.CAP = CAP;
        notifyAllObservers();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
        notifyAllObservers();
    }

    public String getPagamentoPreferito() {
        return pagamentoPreferito;
    }

    public void setPagamentoPreferito(String pagamentoPreferito) {
        this.pagamentoPreferito = pagamentoPreferito;
        notifyAllObservers();
    }
    @Override
    public boolean equals(Object o){
        return o instanceof Utente && this.email.equals(((Utente)o).getEmail())
                && this.nome.equals(((Utente)o).getNome()) 
                && this.cognome.equals(((Utente)o).getCognome())
                && this.password.equals(((Utente)o).getPassword())
                && this.dataNascita.equals(((Utente)o).getDataNascita())
                && this.via.equals(((Utente)o).getVia())
                && this.nCivico.equals(((Utente)o).getnCivico())
                && this.comune.equals(((Utente)o).getComune())
                && this.citta.equals(((Utente)o).getCitta())
                && this.CAP == ((Utente)o).getCAP()
                && this.telefono.equals(((Utente)o).getTelefono())
                && this.pagamentoPreferito.equals(((Utente)o).getPagamentoPreferito());
    }
    @Override
    public String toString() {
        return "Utente{" + "email=" + email + ", password=" + password + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", via=" + via + ", nCivico=" + nCivico + ", citta=" + citta + ", comune=" + comune + ", CAP=" + CAP + ", telefono=" + telefono + ", pagamentoPreferito=" + pagamentoPreferito + '}';
    }

};
