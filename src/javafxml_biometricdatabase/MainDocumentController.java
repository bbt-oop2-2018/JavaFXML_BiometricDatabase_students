package javafxml_biometricdatabase;

import context.Context;
import helpers.RangedNumberGenerator;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import models.Temperature;
import models.User;

public class MainDocumentController implements Initializable {
    
    @FXML private Label username;
    
    @FXML private LineChart chart;
    private XYChart.Series dataValues;
    private int xValue = 1;

    private User user;
    RangedNumberGenerator generator = new RangedNumberGenerator(-10, 40);
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @FXML
    private void handleLoadFromDatabase(ActionEvent event) {
    }
    
    @FXML
    private void handleGenerate(ActionEvent event) {
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataValues = new XYChart.Series();      
        dataValues = createXYChart("Some Data Values");
        
        chart.getXAxis().setLabel("Measure Number []");
        chart.getYAxis().setLabel("Some Value [?]");
        chart.setTitle("Some Values");
    }
    
    private void addDataValue(double value) {
        dataValues.getData().add(new XYChart.Data(xValue, value));
        xValue++;
    }
    
    private XYChart.Series createXYChart(String name) {
        XYChart.Series series = new XYChart.Series();
        series.setName(name);
        chart.getData().add(series);
        return series;
    }
    
}
