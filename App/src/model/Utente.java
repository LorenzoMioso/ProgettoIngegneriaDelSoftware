package model;

public class Utente extends Autenticabile {

    private String email;
    private String nome;
    private String cognome;
    private String citta;
    private int telefono;
    private String via;
    private String nCivico;
    private int CAP;
    private String pagamentoPreferito;
    private String comune;
    private String password;

    public Utente(String email, String password) {
        this.email = email;
        this.password = password;
    }
    

    public Utente(String nome, String cognome, int CAP, String citta, int telefono, String email, String via, String nCivico, String password, String pagamentoPreferito, String comune) {
        this.nome = nome;
        this.cognome = cognome;
        this.CAP = CAP;
        this.citta = citta;
        this.telefono = telefono;
        this.email = email;
        this.via = via;
        this.nCivico = nCivico;
        this.password = password;
        this.pagamentoPreferito = pagamentoPreferito;
        this.comune = comune;
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

    public int getCAP() {
        return CAP;
    }

    public void setCAP(int CAP) {
        this.CAP = CAP;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPagamentoPreferito() {
        return pagamentoPreferito;
    }

    public void setPagamentoPreferito(String pagamentoPreferito) {
        this.pagamentoPreferito = pagamentoPreferito;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    @Override
    public String toString() {
        return "Utente{" + "nome=" + nome + ", cognome=" + cognome + ", CAP=" + CAP + ", citta=" + citta + ", telefono=" + telefono + ", email=" + email + ", via=" + via + ", nCivico=" + nCivico + ", password=" + password + ", pagamentoPreferito=" + pagamentoPreferito + ", comune=" + comune + '}';
    }

};
