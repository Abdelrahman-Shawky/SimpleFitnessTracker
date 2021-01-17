package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.List;
import static java.lang.System.exit;

public class SortedTracker {

    private Scene scene;
    private Calculations calculations;
    private ActivitySelection activitySelection;
    private Stage stage;
    private Label label1;
    private Label label12;
    private Label label13;
    private Label label2;
    private Label label22;
    private Label label23;
    private Label label3;
    private Label label32;
    private Label label33;
    private Label label4;
    private Label label42;
    private Label label43;
    private Label calories;
    private Label heartRate;
    DecimalFormat df = new DecimalFormat("###.###");

    public void prepareScene(){

        Label result = new Label("Results: ");
        result.setFont(new Font("Arial",20));
        calories = new Label();
        calories.setFont(new Font("Arial",16));
        heartRate = new Label();
        heartRate.setFont(new Font("Arial",16));
        Label label = new Label("Activities Rank: ");
        label.setFont(new Font("Arial",20));
        label1 = new Label();
        label1.setFont(new Font("Arial",18));
        label1.setTextFill(Color.RED);
        label12 = new Label();
        label12.setFont(new Font("Arial",16));
        label13 = new Label();
        label13.setFont(new Font("Arial",16));
        label2 = new Label();
        label2.setFont(new Font("Arial",18));
        label2.setTextFill(Color.RED);
        label22 = new Label();
        label22.setFont(new Font("Arial",16));
        label23 = new Label();
        label23.setFont(new Font("Arial",16));
        label3 = new Label();
        label3.setTextFill(Color.RED);
        label3.setFont(new Font("Arial",18));
        label32 = new Label();
        label32.setFont(new Font("Arial",16));
        label33 = new Label();
        label33.setFont(new Font("Arial",16));
        label4 = new Label();
        label4.setTextFill(Color.RED);
        label4.setFont(new Font("Arial",18));
        label42 = new Label();
        label42.setFont(new Font("Arial",16));
        label43 = new Label();
        label43.setFont(new Font("Arial",16));

        Button end = new Button("END");
        Button add = new Button("ADD");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25));
        grid.add(result,0,0);
        grid.addRow(1,new Text(""));
        grid.add(calories,0,2);
        grid.add(heartRate,0,3);
        grid.addRow(4,new Text(""));
        grid.add(label,0,5);
        grid.addRow(6,new Text(""));
        grid.add(label1,0,7);
        grid.add(label12,0,8);
        grid.add(label13,0,9);
        grid.addRow(10,new Text(""));
        grid.add(label2,0,11);
        grid.add(label22,0,12);
        grid.add(label23,0,13);
        grid.addRow(14,new Text(""));
        grid.add(label3,0,15);
        grid.add(label32,0,16);
        grid.add(label33,0,17);
        grid.addRow(18,new Text(""));
        grid.add(label4,0,19);
        grid.add(label42,0,20);
        grid.add(label43,0,21);
        grid.addRow(22,new Text(""));
        grid.add(end,1,23);
        grid.add(add,0,23);

        add.setOnAction(e -> {
            stage.setScene(activitySelection.getScene());
        });

        end.setOnAction(e -> {
           exit(1);
        });

        grid.setHgap(10);
        grid.setVgap(7);
        scene = new Scene(grid ,700 ,700);

    }

    public void setLabels(List<Activity> activity){

        calories.setText("Total Calories Burnt: " + (int)calculations.getTotalCaloriesBurnt() + " calories");
        heartRate.setText("Total Heart Rate: " + df.format(calculations.getTotalHeartRate()) + " beat/minute");
        label1.setText("1. " + activity.get(0).getSport());
        label12.setText("Calories Burnt: " + (int)activity.get(0).getCalories() + " calories");
        label13.setText("Heart Rate Increase: " + df.format(activity.get(0).getHeartRate()) + " beat/minute");
        label2.setText("2. " + activity.get(1).getSport());
        label22.setText("Calories Burnt: " + (int)activity.get(1).getCalories() + " calories");
        label23.setText("Heart Rate Increase: " + df.format(activity.get(1).getHeartRate()) + " beat/minute");
        label3.setText("3. " + activity.get(2).getSport());
        label32.setText("Calories Burnt: " + (int)activity.get(2).getCalories() + " calories");
        label33.setText("Heart Rate Increase: " + df.format(activity.get(2).getHeartRate()) + " beat/minute");
        label4.setText("4. " + activity.get(3).getSport());
        label42.setText("Calories Burnt: " + (int)activity.get(3).getCalories() + " calories");
        label43.setText("Heart Rate Increase: " + df.format(activity.get(3).getHeartRate()) + " beat/minute");
    }

    public Scene getScene(){
        return scene;
    }

    public void setActivitySelection(ActivitySelection activitySelection) {
        this.activitySelection = activitySelection;
    }

    public SortedTracker(Stage stage) {
        this.stage = stage;
    }

    public void setCalculations(Calculations calculations) {
        this.calculations = calculations;
    }
}
