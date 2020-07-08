package univr.spesaonline.controller;

import java.net.URL;
import javafx.scene.paint.Color;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import univr.spesaonline.Main;
import univr.spesaonline.model.SceneName;
import univr.spesaonline.model.SessionStorage;
import univr.spesaonline.model.Stageable;
import univr.spesaonline.model.TesseraFedelta;
import univr.spesaonline.model.TesseraFedeltaDao;
import univr.spesaonline.model.TesseraFedeltaDaoImpl;
import univr.spesaonline.model.Utente;
import univr.spesaonline.model.UtenteDaoImpl;

public class FullRegisterController implements Stageable, Initializable {

    private Stage stage;
    private SessionStorage sessionStorage;
    UtenteDaoImpl utenteDaoImpl;
    TesseraFedeltaDaoImpl tesseraFedeltaDaoImpl;
    Utente utente = null;
    private static final int ADULT_AGE = 18;
    //campi di fullRegister.fxml
    @FXML
    TextField nome;
    @FXML
    TextField cognome;
    @FXML
    TextField via;
    @FXML
    TextField ncivico;
    @FXML
    TextField comune;
    @FXML
    TextField città;
    @FXML
    TextField cap;
    @FXML
    TextField telefono;
    @FXML
    Label fullresult;
    @FXML
    Button fullregister;
    @FXML
    ComboBox pagamento;
    @FXML
    DatePicker data;

    public void fullRegisterMouseClick(MouseEvent evt) throws SQLException {
        Pattern nomeP = Pattern.compile("^([a-zA-Z\\xE0\\xE8\\xE9\\xF9\\xF2\\xEC\\x27]\\s?)+$");
        Pattern capP = Pattern.compile("^\\d{5}$");
        Pattern telefonoFisso = Pattern.compile("(0{1}[1-9]{1,3})[\\s|.|-]?(\\d{4,})");
        //Pattern telefonoP = Pattern.compile("^(2){1}(\\d{2}){1}[|\\s\\.|\\-]?(\\d{7,8}){1}");
        Pattern telefonoP = Pattern.compile("^(([+]|00)39)?((3[1-6][0-9]))(\\d{7})$");
        Matcher matcherNome = nomeP.matcher(nome.getText());
        Matcher matcherCognome = nomeP.matcher(cognome.getText());
        Matcher matcherVia = nomeP.matcher(via.getText());
        Matcher matcherComune = nomeP.matcher(comune.getText());
        Matcher matcherCittà = nomeP.matcher(città.getText());
        Matcher matcherNCivico;
        Matcher matcherCap = capP.matcher(cap.getText());
        Matcher matcherTelefono = telefonoP.matcher(telefono.getText());
        Matcher matcherTelefonoFisso = telefonoFisso.matcher(telefono.getText());
        if (matcherNome.matches()) {
            if (matcherCognome.matches()) {
                if (calculateAge(data.getValue(), java.time.LocalDate.now()) >= ADULT_AGE) {
                    if (matcherVia.matches()) {
                        if (matcherComune.matches()) {
                            if (matcherCittà.matches()) {
                                if (matcherCap.matches()) {
                                    if (matcherTelefono.matches() || matcherTelefonoFisso.matches()) {
                                        if (pagamento.getSelectionModel().isEmpty() != true) {
                                            utente.setNome(nome.getText());
                                            utente.setCognome(cognome.getText());
                                            utente.setVia(via.getText());
                                            utente.setnCivico(ncivico.getText());
                                            utente.setComune(comune.getText());
                                            utente.setCitta(città.getText());
                                            utente.setCAP(Integer.parseInt(cap.getText()));
                                            utente.setTelefono(telefono.getText());
                                            utente.setPagamentoPreferito(pagamento.getSelectionModel().getSelectedItem().toString());
                                            utente.setDataNascita(java.sql.Date.valueOf(data.getValue()));
                                            System.out.println(utente.toString());
                                            utenteDaoImpl.updateUtente(utente);
                                            sessionStorage.setUtente(utente);
                                            //nuova tessera
                                            TesseraFedelta tesseraFedelta = new TesseraFedelta(utente);
                                            tesseraFedeltaDaoImpl.insertTesseraFedelta(tesseraFedelta);
                                            fullresult.setText("La registrazione completa è stata effettuata!");
                                            fullresult.setTextFill(Color.web("green"));
                                            System.out.println("update utente fatto");
                                            //resetto i valori dei campi per inserimento successivo
                                            nome.setText("");
                                            cognome.setText("");
                                            data.setValue(null);
                                            via.setText("");
                                            ncivico.setText("");
                                            comune.setText("");
                                            città.setText("");
                                            cap.setText("");
                                            telefono.setText("");
                                            pagamento.setValue(null);
                                            fullresult.setText("");
                                            
                                            stage.setScene(Main.getScenes().get(SceneName.CATALOG).getScene());
                                        } else {
                                            fullresult.setText("Pagamento non selezionato!");
                                            fullresult.setTextFill(Color.web("red"));
                                        }
                                    } else {
                                        fullresult.setText("Numero di telefono non valido!");
                                        fullresult.setTextFill(Color.web("red"));
                                    }
                                } else {
                                    fullresult.setText("CAP non valido!");
                                    fullresult.setTextFill(Color.web("red"));
                                }
                            } else {
                                fullresult.setText("Città non valida!");
                                fullresult.setTextFill(Color.web("red"));
                            }

                        } else {
                            fullresult.setText("Comune non valido!");
                            fullresult.setTextFill(Color.web("red"));
                        }

                    } else {
                        fullresult.setText("Via non valida!");
                        fullresult.setTextFill(Color.web("red"));
                    }
                } else {
                    fullresult.setText("Devi essere maggiorenne!");
                    fullresult.setTextFill(Color.web("red"));
                }
            } else {
                fullresult.setText("Cognome non valido!");
                fullresult.setTextFill(Color.web("red"));
            }
        } else {
            fullresult.setText("Nome non valido!");
            fullresult.setTextFill(Color.web("red"));
        }
        fullresult.setVisible(true);
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pagamento.getItems().setAll("Carta di Credito", "PayPal", "Alla consegna");
        sessionStorage = Main.getSessionStorage();
       
        utenteDaoImpl = new UtenteDaoImpl();
        tesseraFedeltaDaoImpl = new TesseraFedeltaDaoImpl();
        utente = (Utente) sessionStorage.getUtente();
    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }

    }
}
