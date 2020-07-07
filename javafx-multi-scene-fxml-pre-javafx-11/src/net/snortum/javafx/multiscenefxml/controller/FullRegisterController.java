package net.snortum.javafx.multiscenefxml.controller;


import java.net.URL;
import javafx.scene.paint.Color;
import java.sql.SQLException;
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
import net.snortum.javafx.multiscenefxml.Main;
import net.snortum.javafx.multiscenefxml.model.SceneName;
import net.snortum.javafx.multiscenefxml.model.SessionStorage;

import net.snortum.javafx.multiscenefxml.model.Stageable;
import net.snortum.javafx.multiscenefxml.model.Utente;
import net.snortum.javafx.multiscenefxml.model.UtenteDaoImpl;

public class FullRegisterController implements Stageable, Initializable {

    private Stage stage;
    private SessionStorage sessionStorage;
    UtenteDaoImpl utenteDaoImpl;
    Utente utente = null;
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
        Pattern telefonoP = Pattern.compile("(0{1}[1-9]{1,3})[\\s|.|-]?(\\d{4,})");
        Matcher matcherNome = nomeP.matcher(nome.getText());
        Matcher matcherCognome = nomeP.matcher(cognome.getText());
        Matcher matcherVia = nomeP.matcher(via.getText());
        Matcher matcherComune = nomeP.matcher(comune.getText());
        Matcher matcherCittà = nomeP.matcher(città.getText());
        Matcher matcherNCivico;
        Matcher matcherCap = capP.matcher(cap.getText());
        Matcher matcherTelefono = telefonoP.matcher(telefono.getText());
        if (matcherNome.matches()) {
            if (matcherCognome.matches()) {
                if (matcherVia.matches()) {
                    if (matcherComune.matches()) {
                        if (matcherCittà.matches()) {
                            if (matcherCap.matches()) {
                                if (matcherTelefono.matches()) {
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
                                        fullresult.setText("La registrazione completa è stata effettuata!");
                                        fullresult.setTextFill(Color.web("green"));
                                        System.out.println("update utente fatto");
                                        
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

    /**
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pagamento.getItems().setAll("Carta di Credito", "PayPal", "Alla consegna");
        sessionStorage = Main.getSessionStorage();
        utenteDaoImpl = new UtenteDaoImpl();
        utente = (Utente) sessionStorage.getUtente();
    }
}
