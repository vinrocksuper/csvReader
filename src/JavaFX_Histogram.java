import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFX_Histogram extends Application {



            int group[] = new int[10];

            @Override
            public void start(Stage primaryStage) {

                prepareData();


                Label labelInfo = new Label();
                labelInfo.setText(
                        "java.version: " + System.getProperty("java.version") + "\n" +
                                "javafx.runtime.version: " + System.getProperty("javafx.runtime.version")
                );

                final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                final BarChart<String,Number> barChart =
                        new BarChart<>(xAxis,yAxis);
                barChart.setCategoryGap(0);
                barChart.setBarGap(0);

                xAxis.setLabel("Composite Score");
                yAxis.setLabel("Number of Schools");

                XYChart.Series series1 = new XYChart.Series();
                series1.setName("Histogram");
                series1.getData().add(new XYChart.Data("0-300", group[0]));
                series1.getData().add(new XYChart.Data("301-600", group[1]));
                series1.getData().add(new XYChart.Data("601-900", group[2]));
                series1.getData().add(new XYChart.Data("901-1200", group[3]));
                series1.getData().add(new XYChart.Data("1201-1500", group[4]));
                series1.getData().add(new XYChart.Data("1501-1800", group[5]));
                series1.getData().add(new XYChart.Data("1801-2100", group[6]));
                series1.getData().add(new XYChart.Data("2101-2400", group[7]));


                barChart.getData().addAll(series1);

                VBox vBox = new VBox();
                vBox.getChildren().addAll(labelInfo, barChart);

                StackPane root = new StackPane();
                root.getChildren().add(vBox);

                Scene scene = new Scene(root, 800, 450);

                primaryStage.setTitle("java-buddy.blogspot.com");
                primaryStage.setScene(scene);
                primaryStage.show();
            }



            private void prepareData(){
                List<SATtakers> x =CSVReaderInJava.fromCSV();
               groupData(x);
            }

            private void groupData(List<SATtakers> x){
                for(int i=0; i<7; i++){
                    group[i]=0;
                }
                for(int i=0; i<x.size(); i++){
                    if(x.get(i).getMath() + x.get(i).getRead() + x.get(i).getWrite() <=300){
                        group[0]++;
                    }else if(x.get(i).getMath() + x.get(i).getRead() + x.get(i).getWrite() <=600){
                        group[1]++;
                    }else if(x.get(i).getMath() + x.get(i).getRead() + x.get(i).getWrite() <=900){
                        group[2]++;
                    }else if(x.get(i).getMath() + x.get(i).getRead() + x.get(i).getWrite() <=1200){
                        group[3]++;
                    }else if(x.get(i).getMath() + x.get(i).getRead() + x.get(i).getWrite() <=1500){
                        group[4]++;
                    }else if(x.get(i).getMath() + x.get(i).getRead() + x.get(i).getWrite() <=1800){
                        group[5]++;
                    }else if(x.get(i).getMath() + x.get(i).getRead() + x.get(i).getWrite() <=2100){
                        group[6]++;
                    }else if(x.get(i).getMath() + x.get(i).getRead() + x.get(i).getWrite() <=2400){
                        group[7]++;
                    }
                }
            }

    public static void main(String[] args) {

        launch(args);
    }

}





