package univr.spesaonline.util;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import org.apache.log4j.Logger;

import univr.spesaonline.model.SceneName;

public class FxmlInfo {

    private static Logger LOG = Logger.getLogger(FxmlInfo.class);

    private String resourceName;
    private SceneName sceneName;
    private Stage stage;
    private Scene scene;

    public FxmlInfo(String resourceName, SceneName sceneName, Stage stage) {
        this.resourceName = resourceName;
        this.sceneName = sceneName;
        this.stage = stage;
    }

    public String getResourceName() {
        return resourceName;
    }

    public SceneName getSceneName() {
        return sceneName;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        if (scene == null) {
            scene = new FxmlLoad().load(this);
            if (LOG.isInfoEnabled()) {
                LOG.info(sceneName + " has been built");
            }
        }
        return scene;
    }

    public boolean hasScene() {
        return scene != null;
    }

    public Stage getStage() {
        return stage;
    }

}
