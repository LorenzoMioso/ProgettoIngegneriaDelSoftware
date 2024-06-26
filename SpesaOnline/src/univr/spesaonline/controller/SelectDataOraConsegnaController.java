package univr.spesaonline.controller;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import univr.spesaonline.Main;
import univr.spesaonline.model.SceneName;
import univr.spesaonline.model.SessionStorage;
import univr.spesaonline.model.Spesa;
import univr.spesaonline.model.SpesaDaoImpl;
import univr.spesaonline.model.Stageable;
import univr.spesaonline.model.TesseraFedeltaDaoImpl;
import univr.spesaonline.model.Utente;

public class SelectDataOraConsegnaController implements Initializable, Stageable {

    private final static int FIRST_ELEMENT = 0;
    private final static int LAST_ELEMENT = 0;
    private final static int BEGIN = 8;
    private final static int END = 20;
    private List<String> timeTable;
    private List<String> deliveryDate;
    private Stage stage;
    private SessionStorage sessionStorage;

    @FXML
    ComboBox comboData;
    @FXML
    ComboBox comboOraInizio;
    @FXML
    ComboBox comboOraFine;
    @FXML
    Label result;
    @FXML
    Button conferma;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        sessionStorage = Main.getSessionStorage();
        timeTable = new ArrayList<>();
        deliveryDate = new ArrayList<>();
        int i;
        for (i = BEGIN; i < END - 1; i++) {
            timeTable.add("" + i + ":00");
        }
        comboOraInizio.getItems().setAll(timeTable);
        timeTable.remove(FIRST_ELEMENT);
        i = END - 1;
        timeTable.add("" + i + ":00");
        comboOraFine.getItems().setAll(timeTable);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        for (int day = 1; day <= 7; day++) {
            deliveryDate.add(formatter.format(addDays(java.util.Calendar.getInstance().getTime(), day)));

        }
        comboData.getItems().setAll(deliveryDate);
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return (Date) cal.getTime();
    }

    public void handleMouseClickConferma(MouseEvent evt) throws ParseException, SQLException {
        if (comboData.getSelectionModel().isEmpty() == true) {
            result.setText("Errore non hai selezionato la data di consegna !");
            result.setTextFill(Color.web("red"));
        } else if (comboOraInizio.getSelectionModel().isEmpty() == true) {
            result.setText("Errore non hai selezionato l'ora di inizio della consegna !");
            result.setTextFill(Color.web("red"));
        } else if (comboOraFine.getSelectionModel().isEmpty() == true) {

            result.setText("Errore non hai selezionato l'ora di fine della consegna !");
            result.setTextFill(Color.web("red"));
        } else {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Date date = df.parse((String) comboData.getValue());

            String timeBegin = (String) comboOraInizio.getValue();
            String timeEnd = (String) comboOraFine.getValue();

            timeBegin += ":00";
            timeEnd += ":00";
            Time b = Time.valueOf(timeBegin);
            Time e = Time.valueOf(timeEnd);
            switch (b.compareTo(e)) {
                case 1:
                    result.setText("Errore la data di fine viene prima di quella di inizio");
                    result.setTextFill(Color.web("red"));
                    break;
                case 0:
                    result.setText("Errore le date di inizio e fine sono uguali");
                    result.setTextFill(Color.web("red"));
                    break;
                default:
                    //date di inizio e fine sono corrette
                    result.setText("La spesa è stata evasa");
                    result.setTextFill(Color.web("green"));

                    java.sql.Date sDate = new java.sql.Date(date.getTime());
                    Spesa s = new Spesa(sDate, b, e, sessionStorage.getCarrello().getPrezzoTot(), (int) sessionStorage.getCarrello().getPrezzoTot(), (Utente) sessionStorage.getUtente(), sessionStorage.getCarrello().getProdotti(), "Confermata");
                    SpesaDaoImpl sdi = new SpesaDaoImpl();
                    TesseraFedeltaDaoImpl fedeltaDaoImpl = new TesseraFedeltaDaoImpl();
                    sessionStorage.setTesseraFedelta(fedeltaDaoImpl.getTesseraFromUser((Utente) sessionStorage.getUtente()));
                    sdi.insertSpesa(s);
                    result.setText("");
                    comboData.valueProperty().set(null);
                    comboOraInizio.valueProperty().set(null);
                    comboOraFine.valueProperty().set(null);
                    final Node source = (Node) evt.getSource();
                    Stage thisStage = (Stage) source.getScene().getWindow();
                    thisStage.close();
                    stage.setScene(Main.getScenes().get(SceneName.CATALOG).getScene());
                    sessionStorage.getCarrello().emptyCarrello();
                    break;
            }

        }
    }
}
