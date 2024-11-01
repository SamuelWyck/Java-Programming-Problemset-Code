package application;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.util.HashMap;

public class PartiesApplication extends Application {

    public static void main(String[] args) throws Exception {
        //System.out.println("Hello world!");
        launch(PartiesApplication.class);
    }
    
    public void start(Stage window) throws Exception {
        HashMap<String, HashMap<Integer, Double>> data = readFile();
        
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        xAxis.setLabel("Year");
        yAxis.setLabel("Relative Support");
        
        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Relative support of the parties");
        
        
        for (String party : data.keySet()) {
            XYChart.Series pData = new XYChart.Series();
            pData.setName(party);
            for (Integer year : data.get(party).keySet()) {
                pData.getData().add(new XYChart.Data(year, data.get(party).get(year)));
            }
            chart.getData().add(pData);
        }
        
        Scene scene = new Scene(chart, 700, 500);
        window.setScene(scene);
        window.show();
    }
    
    public HashMap<String, HashMap<Integer, Double>> readFile() throws Exception {
        HashMap<String, HashMap<Integer, Double>> data = new HashMap<>();
        
        ArrayList<String> rows = new ArrayList<>();
        Files.lines(Paths.get("partiesdata.tsv"))
                .forEach(row -> rows.add(row));
        
        String[] dates = rows.get(0).split("\t");
        for (int i = 1; i < rows.size(); i += 1) {
            String[] parts = rows.get(i).split("\t");
            
            HashMap<Integer, Double> partyData = new HashMap<>();
            for (int j = 1; j < parts.length; j += 1) {
                if (parts[j].equals("-")) {
                    continue;
                }
                partyData.put(Integer.valueOf(dates[j]), Double.valueOf(parts[j]));
            }
            data.put(parts[0], partyData);
        }
        
        return data;
    }

}
