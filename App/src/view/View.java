package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
        Parent login = FXMLLoader.load(getClass().getResource("login.fxml"));
        Parent register = FXMLLoader.load(getClass().getResource("register.fxml"));
        Parent fullRegister = FXMLLoader.load(getClass().getResource("fullRegister.fxml"));

        Scene rootScene = new Scene(root);
        Scene loginScene = new Scene(login);
        Scene registerScene = new Scene(register);
        Scene fullRegisterScene = new Scene(fullRegister);

        stage.setScene(rootScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
