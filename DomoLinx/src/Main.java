//Para crear la ventana

import Controller.DomoticController;
import Model.DomoticModel;
import View.DomoticView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DomoticGUI.fxml"));
        DomoticModel domoticModel = DomoticModel.getInstance();
        DomoticController domoticController = new DomoticController(domoticModel);
        DomoticView domoticView = new DomoticView(domoticController , domoticModel);
        loader.setController(domoticView);
        TabPane flowPane = loader.load();
        Scene scene = new Scene(flowPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}