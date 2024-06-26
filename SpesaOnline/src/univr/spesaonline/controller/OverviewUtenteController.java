package univr.spesaonline.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import univr.spesaonline.Main;
import univr.spesaonline.model.Observer;
import univr.spesaonline.model.SceneName;
import univr.spesaonline.model.SessionStorage;
import univr.spesaonline.model.Spesa;
import univr.spesaonline.model.SpesaDaoImpl;
import univr.spesaonline.model.Stageable;
import univr.spesaonline.model.TesseraFedelta;
import univr.spesaonline.model.TesseraFedeltaDaoImpl;
import univr.spesaonline.model.Utente;
import univr.spesaonline.model.UtenteDaoImpl;

public class OverviewUtenteController extends Observer implements Stageable, Initializable {

    private Stage stage;
    private SessionStorage sessionStorage;
    private UtenteDaoImpl utenteDaoImpl;
    private Utente utente = null;
    private TesseraFedeltaDaoImpl fedeltaDaoImpl = null;
    private TesseraFedelta tf = null;
    private SpesaDaoImpl spesaDaoImpl = null;
    private List<Spesa> speseList;
    @FXML
    Label nomeCognome;
    @FXML
    ToggleButton btnProfilo;
    @FXML
    ToggleButton btnSaldoPunti;
    @FXML
    ToggleButton btnSpese;
    @FXML
    ToggleButton btnModificaProfilo;
    @FXML
    ToggleButton btnLogOut;
    @FXML
    ToggleButton btnBack;
    // pane
    @FXML
    Pane profilo;
    @FXML
    Pane saldoPunti;
    @FXML
    Pane spese;
    @FXML
    Pane modificaProfilo;
    // Elementi del pane profilo
    @FXML
    Label labelNome;
    @FXML
    Label labelCognome;
    @FXML
    Label labelData;
    @FXML
    Label labelVia;
    @FXML
    Label labelNCivico;
    @FXML
    Label labelComune;
    @FXML
    Label labelCittà;
    @FXML
    Label labelCap;
    @FXML
    Label labelTelefono;
    @FXML
    Label labelPagamentoPreferito;
    // elementi del pane saldoPunti
    @FXML
    Label labelSaldoPunti;
    // elementi di pane modificaProfilo
    @FXML
    TextField textNome;
    @FXML
    TextField textCognome;
    @FXML
    DatePicker datePickerNascita;
    @FXML
    TextField textVia;
    @FXML
    TextField textNCivico;
    @FXML
    TextField textComune;
    @FXML
    TextField textCitta;
    @FXML
    TextField textCap;
    @FXML
    TextField textTelefono;
    @FXML
    ComboBox comboPagamento;
    @FXML
    Label result;
    // elementi di del pane di spese
    @FXML
    ScrollPane speseScrollPane;
    @FXML
    VBox speseVBox;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sessionStorage = Main.getSessionStorage();
        utente = (Utente) sessionStorage.getUtente();
        sessionStorage.getUtente().attach(this);
        sessionStorage.attach(this);
        setNomeCognome();
        // all' inizio rendo visibile profilo
        setProfiloView();
        // aggiungo gli item alla comboBox
        comboPagamento.getItems().setAll("Carta di Credito", "PayPal", "Alla consegna");
        fedeltaDaoImpl = new TesseraFedeltaDaoImpl();
        spesaDaoImpl = new SpesaDaoImpl();

        try {
            tf = fedeltaDaoImpl.getTesseraFromUser(utente);
        } catch (SQLException ex) {
            Logger.getLogger(OverviewUtenteController.class.getName()).log(Level.SEVERE, null, ex);
        }

        sessionStorage.setTesseraFedelta(tf);
    }

    public void setNomeCognome() {
        nomeCognome.setText(utente.getNome() + " " + utente.getCognome());
    }

    public void setProfiloView() {
        managePane("profilo");
        System.out.println("" + utente);
        if (utente.isLogged() == true) {
            labelNome.setText(utente.getNome());
            labelCognome.setText(utente.getCognome());
            labelData.setText(utente.getDataNascita().toString());
            labelVia.setText(utente.getVia());
            labelNCivico.setText(utente.getnCivico());
            labelComune.setText(utente.getComune());
            labelCittà.setText(utente.getCitta());
            labelCap.setText("" + utente.getCAP());
            labelTelefono.setText(utente.getTelefono());
            labelPagamentoPreferito.setText(utente.getPagamentoPreferito());
        }

    }

    @FXML
    public void handleMouseClickProfilo(MouseEvent event) {
        managePane("profilo");
        System.out.println("" + utente);
        labelNome.setText(utente.getNome());
        labelCognome.setText(utente.getCognome());
        labelData.setText(utente.getDataNascita().toString());
        labelVia.setText(utente.getVia());
        labelNCivico.setText(utente.getnCivico());
        labelComune.setText(utente.getComune());
        labelCittà.setText(utente.getCitta());
        labelCap.setText("" + utente.getCAP());
        labelTelefono.setText(utente.getTelefono());
        labelPagamentoPreferito.setText(utente.getPagamentoPreferito());
    }

    @FXML
    public void handleMouseClickSaldoPunti(MouseEvent event) throws SQLException {
        managePane("saldoPunti");
        showSaldoPunti();
    }

    public void showSaldoPunti() throws SQLException {
        if (utente.isLogged()) {
            tf = fedeltaDaoImpl.getTesseraFromUser(utente);
            labelSaldoPunti.setText("" + tf.getPunti());
        }

    }

    @FXML
    public void handleMouseClickSpese(MouseEvent event) throws SQLException, IOException {
        managePane("spese");
        speseVBox.getChildren().clear();
        speseList = spesaDaoImpl.getAllSpesaByUtente(utente);
        for (Spesa s : speseList) {
            URL urlFile = getClass().getResource("/view/spesaItem.fxml");
            FXMLLoader loader = new FXMLLoader(urlFile);
            Node prodottoSmall = loader.load();
            SpesaItemController ctrl = loader.getController();
            speseVBox.getChildren().add(prodottoSmall);
            ctrl.setSpesa(s);
        }
    }

    @FXML
    public void handleMouseClickModificaProfilo(MouseEvent event) {
        managePane("modificaProfilo");
        textNome.setText(utente.getNome());
        textCognome.setText(utente.getCognome());
        LocalDate localDate = Instant.ofEpochMilli(utente.getDataNascita().getTime()).atZone(ZoneId.systemDefault())
                .toLocalDate();
        datePickerNascita.setValue(localDate);
        textVia.setText(utente.getVia());
        textNCivico.setText(utente.getnCivico());
        textComune.setText(utente.getComune());
        textCitta.setText(utente.getCitta());
        textCap.setText("" + utente.getCAP());
        textTelefono.setText(utente.getTelefono());
        comboPagamento.setValue(utente.getPagamentoPreferito());
        setNomeCognome();
    }

    @FXML
    public void handleMouseClickModifica(MouseEvent event) {
        Pattern nomeP = Pattern.compile("^([a-zA-Z\\xE0\\xE8\\xE9\\xF9\\xF2\\xEC\\x27]\\s?)+$");
        Pattern capP = Pattern.compile("^\\d{5}$");
        Pattern telefonoP = Pattern.compile("(0{1}[1-9]{1,3})[\\s|.|-]?(\\d{4,})");
        Matcher matcherNome = nomeP.matcher(textNome.getText());
        Matcher matcherCognome = nomeP.matcher(textCognome.getText());
        Matcher matcherVia = nomeP.matcher(textVia.getText());
        Matcher matcherComune = nomeP.matcher(textComune.getText());
        Matcher matcherCittà = nomeP.matcher(textCitta.getText());
        Matcher matcherNCivico;
        Matcher matcherCap = capP.matcher(textCap.getText());
        Matcher matcherTelefono = telefonoP.matcher(textTelefono.getText());
        if (matcherNome.matches()) {
            if (matcherCognome.matches()) {
                if (matcherVia.matches()) {
                    if (matcherComune.matches()) {
                        if (matcherCittà.matches()) {
                            if (matcherCap.matches()) {
                                if (matcherTelefono.matches()) {
                                    if (comboPagamento.getSelectionModel().isEmpty() != true) {
                                        result.setText("Modifiche effettuate !");
                                        result.setTextFill(Color.web("green"));
                                        utente.setNome(textNome.getText());
                                        utente.setCognome(textCognome.getText());
                                        utente.setDataNascita(java.sql.Date.valueOf(datePickerNascita.getValue()));
                                        utente.setVia(textVia.getText());
                                        utente.setnCivico(textNCivico.getText());
                                        utente.setComune(textComune.getText());
                                        utente.setCitta(textCitta.getText());
                                        utente.setCAP(Integer.parseInt(textCap.getText()));
                                        utente.setTelefono(textTelefono.getText());
                                        utente.setPagamentoPreferito((String) comboPagamento.getValue());
                                        setNomeCognome();
                                        sessionStorage.setUtente(utente);
                                    } else {
                                        result.setText("Pagamento non selezionato!");
                                        result.setTextFill(Color.web("red"));

                                    }

                                } else {
                                    result.setText("Numero di telefono non valido!");
                                    result.setTextFill(Color.web("red"));
                                }
                            } else {
                                result.setText("CAP non valido!");
                                result.setTextFill(Color.web("red"));
                            }
                        } else {
                            result.setText("Città non valida!");
                            result.setTextFill(Color.web("red"));
                        }

                    } else {
                        result.setText("Comune non valido!");
                        result.setTextFill(Color.web("red"));
                    }

                } else {
                    result.setText("Via non valida!");
                    result.setTextFill(Color.web("red"));
                }

            } else {
                result.setText("Cognome non valido!");
                result.setTextFill(Color.web("red"));
            }
        } else {
            result.setText("Nome non valido!");
            result.setTextFill(Color.web("red"));
        }
        result.setVisible(true);

    }

    private void managePane(String pane) {
        switch (pane) {
            case "profilo":
                profilo.setVisible(true);
                saldoPunti.setVisible(false);
                spese.setVisible(false);
                modificaProfilo.setVisible(false);
                break;
            case "saldoPunti":
                profilo.setVisible(false);
                saldoPunti.setVisible(true);
                spese.setVisible(false);
                modificaProfilo.setVisible(false);
                break;
            case "spese":
                profilo.setVisible(false);
                saldoPunti.setVisible(false);
                spese.setVisible(true);
                modificaProfilo.setVisible(false);
                break;
            case "modificaProfilo":
                profilo.setVisible(false);
                saldoPunti.setVisible(false);
                spese.setVisible(false);
                modificaProfilo.setVisible(true);
                break;

        }
    }

    public void handleMouseClickLogOut(MouseEvent evt) {
        sessionStorage.logOut();
        stage.setScene(Main.getScenes().get(SceneName.CATALOG).getScene());
    }

    public void handleMouseClickBack(MouseEvent evt) {
        // btnProfilo.setSelected(true);
        // btnBack.setSelected(false);
        stage.setScene(Main.getScenes().get(SceneName.CATALOG).getScene());
    }

    @Override
    public void update() {
        System.out.println("Called update overview");
        sessionStorage = Main.getSessionStorage();
        utente = (Utente) sessionStorage.getUtente();
        setNomeCognome();
        setProfiloView();
        try {

            showSaldoPunti();
        } catch (SQLException ex) {
            Logger.getLogger(OverviewUtenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // sessionStorage.setTesseraFedelta(tf);
    }

}
