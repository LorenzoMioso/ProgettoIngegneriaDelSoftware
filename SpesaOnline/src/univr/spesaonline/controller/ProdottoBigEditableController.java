package univr.spesaonline.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import univr.spesaonline.Main;
import univr.spesaonline.model.Caratteristica;
import univr.spesaonline.model.CaratteristicaDaoImpl;
import univr.spesaonline.model.Prodotto;
import univr.spesaonline.model.ProdottoDaoImpl;
import univr.spesaonline.model.SessionStorage;
import univr.spesaonline.model.Tipo;
import univr.spesaonline.model.TipoDaoImpl;

public class ProdottoBigEditableController implements Initializable {

    private SessionStorage sessionStorage;
    private ProdottoDaoImpl prodottoDaoImpl;
    private TipoDaoImpl tipoDaoImpl;
    private CaratteristicaDaoImpl caratteristicaDaoImpl;
    private Prodotto prodotto;
    List<CheckBox> checkBoxList;

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = Integer.MAX_VALUE;
    private static final int STEP = 1;
    private static final int INITIAL_VALUE = 1;

    @FXML
    TextField nomeProdotto;
    @FXML
    TextField marcaProdotto;
    @FXML
    TextField prezzoProdotto;
    @FXML
    TextField pesoProdotto;
    @FXML
    TextField nPezziProdotto;
    @FXML
    ComboBox tipoProdotto;
    @FXML
    CheckBox inVenditaProdotto;
    @FXML
    ImageView immagineProdotto;
    @FXML
    VBox boxCaratteristiche;
    @FXML
    Spinner disponibilitaProdotto;
    @FXML
    Label result;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sessionStorage = Main.getSessionStorage();
        prodottoDaoImpl = new ProdottoDaoImpl();
        tipoDaoImpl = new TipoDaoImpl();
        caratteristicaDaoImpl = new CaratteristicaDaoImpl();
        checkBoxList = new ArrayList();
    }

    public void setProdotto(Prodotto p) {
        this.prodotto = p;
    }

    public void showProdotto() throws SQLException, IOException {
        nomeProdotto.setText("" + prodotto.getNome());
        marcaProdotto.setText(prodotto.getMarca());
        prezzoProdotto.setText("" + prodotto.getPrezzo());
        pesoProdotto.setText("" + prodotto.getPeso());
        nPezziProdotto.setText("" + prodotto.getnPezzi());
        inVenditaProdotto.setSelected(prodotto.isInVendita());

        SpinnerValueFactory<Integer> factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(MIN_VALUE, MAX_VALUE, prodottoDaoImpl.getDisponibilitàProdotto(prodotto.getId()), STEP);
        disponibilitaProdotto.setValueFactory(factory);
        disponibilitaProdotto.setEditable(true);

        if (prodotto.getImmagine() != null) {
            Blob aBlob = prodotto.getImmagine();
            InputStream is = null;
            BufferedImage imag = null;
            is = aBlob.getBinaryStream(1, aBlob.length());
            imag = ImageIO.read(is);
            Image image1 = SwingFXUtils.toFXImage(imag, null);
            immagineProdotto.setImage(image1);
        }

        prodotto.setCarattristiche(prodottoDaoImpl.getCaratteristicaByProdotto(prodotto.getId()));

        for (Tipo t : tipoDaoImpl.getAllTipo()) {
            tipoProdotto.getItems().add(t.getNome());
        }
        tipoProdotto.getSelectionModel().select(prodotto.getTipo());

        for (Caratteristica c : caratteristicaDaoImpl.getAllCaratteristica()) {
            CheckBox checkBox = new CheckBox();
            checkBox.setText(c.getNome());

            for (Caratteristica cp : prodotto.getCarattristiche()) {
                if (cp.getNome().equals(c.getNome())) {
                    checkBox.setSelected(true);
                }
            }

            checkBoxList.add(checkBox);
            boxCaratteristiche.getChildren().add(checkBox);
        }

    }

    @FXML
    private void handleMouseClickSave(MouseEvent event) throws SQLException {
        List<Caratteristica> newCaratteristiche = new ArrayList<>();

        for (CheckBox c : checkBoxList) {
            if (c.isSelected()) {
                newCaratteristiche.add(new Caratteristica(c.getText()));
            }
        }
        if (nomeProdotto.getText() != null) {
            if (marcaProdotto.getText() != null) {
                if (tipoProdotto.getSelectionModel().isEmpty() != true) {
                    if ((isInteger(nPezziProdotto.getText()) == true)) {
                        if (isDouble(pesoProdotto.getText()) == true) {
                            if (isDouble(prezzoProdotto.getText()) == true) {
                                prodotto.setNome(nomeProdotto.getText());
                                prodotto.setMarca(marcaProdotto.getText());
                                prodotto.setTipo(tipoProdotto.getSelectionModel().getSelectedItem().toString());
                                prodotto.setInVendita(inVenditaProdotto.isSelected());
                                prodotto.setPeso(Double.parseDouble(pesoProdotto.getText()));
                                prodotto.setnPezzi(Integer.parseInt(nPezziProdotto.getText()));
                                prodotto.setPrezzo(Double.parseDouble(prezzoProdotto.getText()));
                                prodotto.setCarattristiche(newCaratteristiche);

                                prodottoDaoImpl.updateProdotto(prodotto);
                                prodottoDaoImpl.updateDisponibilitàProdotto(prodotto.getId(), (int) disponibilitaProdotto.getValue());

                                nomeProdotto.setText("");
                                marcaProdotto.setText("");
                                tipoProdotto.valueProperty().set(null);
                                pesoProdotto.setText("");
                                nPezziProdotto.setText("");

                                final Node source = (Node) event.getSource();
                                Stage thisStage = (Stage) source.getScene().getWindow();
                                thisStage.close();
                            } else {
                                result.setText("Errore prezzo del prodotto non inserito o contiene dei caratteri!");
                                result.setTextFill(Color.web("red"));
                            }
                        } else {
                            result.setText("Errore peso del prodotto non inserito o contiene dei caratteri!");
                            result.setTextFill(Color.web("red"));
                        }
                    } else {
                        result.setText("Errore numero pezzi del prodotto non inserito o contiene dei caratteri!");
                        result.setTextFill(Color.web("red"));
                    }
                } else {
                    result.setText("Errore tipo prodotto non inserito!");
                    result.setTextFill(Color.web("red"));
                }
            } else {

                result.setText("Errore marca prodotto non inserita!");
                result.setTextFill(Color.web("red"));

            }
        } else {
            result.setText("Errore nome prodotto non inserito!");
            result.setTextFill(Color.web("red"));
        }

    }

    @FXML
    private void handleMouseClickSelectFile(MouseEvent event) throws SQLException, IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Scegli un immagine");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        Stage chooserWindow = new Stage();
        File selectedFile = fileChooser.showOpenDialog(chooserWindow);

        //file to blob
        byte[] fileContent = new byte[(int) selectedFile.length()];
        FileInputStream inputStream = null;
        // create an input stream pointing to the file
        inputStream = new FileInputStream(selectedFile);
        // read the contents of file into byte array
        inputStream.read(fileContent);
        // close input stream
        if (inputStream != null) {
            inputStream.close();
        }
        Blob blob = new SerialBlob(fileContent);

        prodotto.setImmagine(blob);

        showProdotto();
    }

    public static boolean isInteger(String s) {
        int i;
        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return i > 0;
    }

    public static boolean isDouble(String s) {
        double i;
        try {
            i = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return i > 0;
    }
}
