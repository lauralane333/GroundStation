package groundstation;
import controller.DataController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.Home;

import java.io.FileInputStream;

public class GroundStation extends Application{
    //ToggleGroup ALLOFTHEM;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Graphs");
        stage.getIcons().add(new Image(new FileInputStream("./img/logo.JPG")));
        Home home = new Home();
        stage.setScene(home.getScene());
        stage.hubhubshow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
