package net.snortum.javafx.multiscenefxml;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.stage.Stage;

import net.snortum.javafx.multiscenefxml.model.SceneName;
import net.snortum.javafx.multiscenefxml.model.SessionStorage;
import net.snortum.javafx.multiscenefxml.util.FxmlInfo;

/**
 * Sets all scene info into a Map and displays the main scene
 *
 * @author Knute Snortum
 * @version 2018-05-24
 */
public class Main extends Application {

    private static final String LOGIN_FXML = "/view/login.fxml";
    private static final String REGISTER_FXML = "/view/register.fxml";
    private static final String FULLREGISTER_FXML = "/view/fullRegister.fxml";
    private static final String CATALOG_FXML = "/view/catalog.fxml";
    private static final String CART_FXML = "/view/cart.fxml";
    private static final String OVERVIEWUTENTE_FXML = "/view/overviewUtente.fxml";
    private static final String PRODUCTLIST_FXML = "/view/productList.fxml";
    
    private static Map<SceneName, FxmlInfo> scenes = new HashMap<>();

    private static SessionStorage sessioStorage = new SessionStorage();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        scenes.put(SceneName.LOGIN, new FxmlInfo(LOGIN_FXML, SceneName.LOGIN, stage));
        scenes.put(SceneName.REGISTER, new FxmlInfo(REGISTER_FXML, SceneName.REGISTER, stage));
        scenes.put(SceneName.FULLREGISTER, new FxmlInfo(FULLREGISTER_FXML, SceneName.FULLREGISTER, stage));
        scenes.put(SceneName.CATALOG, new FxmlInfo(CATALOG_FXML, SceneName.CATALOG, stage));
        scenes.put(SceneName.CART, new FxmlInfo(CART_FXML, SceneName.CART, stage));
        scenes.put(SceneName.OVERVIEWUTENTE, new FxmlInfo(OVERVIEWUTENTE_FXML, SceneName.OVERVIEWUTENTE, stage));
        scenes.put(SceneName.PRODUCTLIST, new FxmlInfo(PRODUCTLIST_FXML, SceneName.PRODUCTLIST, stage));
        
        // getScene() will load the FXML file the first time
        //stage.setScene(scenes.get(SceneName.CATALOG).getScene());
        stage.setScene(scenes.get(SceneName.CATALOG).getScene());
        stage.setTitle("Multi-Scene Demo");
        stage.show();
    }

    /**
     * @return a Map of the {@link FxmlInfo} by {@link SceneName}
     */
    public static Map<SceneName, FxmlInfo> getScenes() {
        return scenes;
    }

    public static SessionStorage getSessionStorage() {
        return sessioStorage;
    }

    /**
     * Update the scene Map with new FxmlInfo
     *
     * @param name the {@link SceneName} that is the key to update
     * @param info the {@link FxmlInfo} that is the data to update
     */
    public static void updateScenes(SceneName name, FxmlInfo info) {
        scenes.put(name, info);
    }

}
