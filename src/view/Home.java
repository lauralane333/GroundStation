package view;

import controller.DataController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Data;

import java.io.FileReader;
import java.util.Scanner;


public class Home {
    private HBox topSubBox, bottomSubBox;
    VBox mainBox;
    RadioButton RD1;
    DataController dataController;

    private Scene scene;

    public Home() {
        dataController = new DataController();
        /*FileReader fileReader = new FileReader("./data/data.txt");
        Scanner scanner = new Scanner(fileReader);
        String[] pos = scanner.nextLine().split(",");
        Data data = new Data(pos[0], Double.parseDouble(pos[1]), Double.parseDouble(pos[2]), Double.parseDouble(pos[3]));*/


        //defining the axes
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time (sec)");
        //creating the chart
        LineChart<Number, Number> pressureChart = new LineChart<Number, Number>(xAxis, yAxis);
        pressureChart.setTitle("Time X Pressure");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        //populating the series with data
        for (int i = 0; i < 10; i++) {
            series.getData().add(new XYChart.Data(i, i * i));
        }
        pressureChart.getData().add(series);

        //defining the axes
        NumberAxis xAxis2 = new NumberAxis();
        NumberAxis yAxis2 = new NumberAxis();
        xAxis2.setLabel("Time (sec)");
        //creating the chart
        LineChart<Number, Number> altitudeChart = new LineChart<Number, Number>(xAxis2, yAxis2);
        altitudeChart.setTitle("Time X Altitude");
        //defining a series
        XYChart.Series series2 = new XYChart.Series();
        //populating the series with data
        for (int i = 0; i < 10; i++) {
            series2.getData().add(new XYChart.Data(i, i));
        }

        altitudeChart.getData().add(series2);

        //defining the axes
        NumberAxis xAxis3 = new NumberAxis();
        NumberAxis yAxis3 = new NumberAxis();
        xAxis3.setLabel("Time (sec)");
        //creating the chart
        LineChart<Number, Number> temperatureChart = new LineChart<Number, Number>(xAxis3, yAxis3);
        temperatureChart.setTitle("Time X Temperature");
        //defining a series
        XYChart.Series series3 = new XYChart.Series();
        //populating the series with data
        for (int i = 0; i < 10; i++) {
            series3.getData().add(new XYChart.Data(i, i));
        }

        temperatureChart.getData().add(series3);

        // Table
        TableView tableView = new TableView();
        tableView.setItems(FXCollections.observableList(dataController.read()));

        TableColumn column0 = new TableColumn<>("Time");
        column0.setPrefWidth(100);
        column0.setCellValueFactory(new PropertyValueFactory<>("Time"));

        TableColumn column1 = new TableColumn<>("Pressure");
        column1.setPrefWidth(100);
        column1.setCellValueFactory(new PropertyValueFactory<>("Pressure"));

        TableColumn column2 = new TableColumn<>("Temperature");
        column2.setPrefWidth(100);
        column2.setCellValueFactory(new PropertyValueFactory<>("Temperature"));

        TableColumn column3 = new TableColumn<>("Altitude");
        column3.setPrefWidth(100);
        column3.setCellValueFactory(new PropertyValueFactory<>("Altitude"));

        tableView.getColumns().setAll(column0,column1,column2,column3);

        // Boxes
        topSubBox = new HBox(10);
        topSubBox.getChildren().addAll(pressureChart, temperatureChart);
        topSubBox.setPadding(new Insets(0,10,10,10));
        topSubBox.setAlignment(Pos.TOP_CENTER);

        bottomSubBox = new HBox(10);
        bottomSubBox.getChildren().addAll(altitudeChart, tableView);
        bottomSubBox.setPadding(new Insets(0,10,20,10));
        bottomSubBox.setAlignment(Pos.BOTTOM_CENTER);

        mainBox = new VBox(10);
        mainBox.getChildren().addAll(topSubBox, bottomSubBox);
        mainBox.setAlignment(Pos.TOP_LEFT);

        scene = new Scene(mainBox, 1000, 800);
    }

    public Scene getScene() {
        return scene;
    }
}