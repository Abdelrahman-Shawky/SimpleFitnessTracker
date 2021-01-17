package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DecimalFormat;

import static java.lang.System.exit;

public class ActivitySelection {

    private Scene scene;
    private Stage stage;
    private Calculations calculations;
    private SortedTracker sortedTracker;
    private Sorting sorting;
    private TextField duration;
    DecimalFormat df = new DecimalFormat("###.###");

    public ActivitySelection(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene(){

        ToggleGroup group = new ToggleGroup();
        RadioButton swimming = new RadioButton("SWIMMING");
        swimming.setToggleGroup(group);
        swimming.setSelected(true);
        swimming.setFont(new Font("Arial",13));
        RadioButton running = new RadioButton("RUNNING");
        running.setToggleGroup(group);
        running.setFont(new Font("Arial",13));
        RadioButton kickBoxing = new RadioButton("KICK BOXING");
        kickBoxing.setToggleGroup(group);
        kickBoxing.setFont(new Font("Arial",13));
        RadioButton strengthTraining = new RadioButton("STRENGTH TRAINING                         ");
        strengthTraining.setToggleGroup(group);
        strengthTraining.setFont(new Font("Arial",13));
        duration = new TextField("0");
        Button submit = new Button("Submit");
        Label label = new Label("Enter Duration in Minutes: ");
        label.setFont(new Font("Arial",20));
        Label choose = new Label("Choose Sport: ");
        choose.setFont(new Font("Arial",20));

        GridPane grid = new GridPane();

        submit.setMinSize(grid.getMaxWidth(),grid.getMaxHeight());

        grid.setPadding(new Insets(25));
        grid.add(choose,0,0);
        grid.addRow(1,new Text(""));
        grid.add(swimming,0,2);
        grid.add(running,0,3);
        grid.add(kickBoxing,0,4);
        grid.add(strengthTraining,0,5);
        grid.add(duration,1,4);
        grid.add(label,1,3);
        grid.addRow(6,new Text(""));
        grid.add(submit,0,7);
        grid.addRow(8,new Text(""));

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                submit.setDisable(true);
                double[] i = {0,0};
                if(swimming.isSelected())
                    i = calculations.calculate(1, duration.getText());
                else if (running.isSelected())
                    i = calculations.calculate(2, duration.getText());
                else if (kickBoxing.isSelected())
                    i = calculations.calculate(3, duration.getText());
                else if(strengthTraining.isSelected())
                    i = calculations.calculate(4, duration.getText());

                Label totalCalories = new Label("Total Calories Burnt");
                totalCalories.setFont(new Font("Arial",16));
                Label totalHeartRate = new Label("Total Heart Rate");
                totalHeartRate.setFont(new Font("Arial",16));
                Label totalCaloriesValue = new Label();
                Label totalHeartRateValue = new Label();
                Button add = new Button("ADD");
//                add.setMinSize(grid.getMaxWidth(),grid.getMaxHeight());
                Button sort = new Button("SORT");
//                sort.setMinSize(grid.getMaxWidth(),grid.getMaxHeight());
                Button end = new Button("END");
//                end.setMinSize(grid.getMaxWidth(),grid.getMaxHeight());
                Label success = new Label("Activity Recorded Successfully");
                success.setFont(new Font("Arial",18));
                success.setTextFill(Color.RED);


                totalCaloriesValue.setText(String.valueOf((int)i[0]));
                totalCaloriesValue.setFont(new Font("Arial",16));
                totalHeartRateValue.setText(String.valueOf(df.format(i[1])));
                totalHeartRateValue.setFont(new Font("Arial",16));

                grid.add(success,0,9);
                grid.addRow(10,new Text(""));
                grid.add(totalCalories,0,11);
                grid.add(totalCaloriesValue,1,11);
                grid.add(totalHeartRate,0,12);
                grid.add(totalHeartRateValue,1,12);
                grid.addRow(13,new Text(""));
                grid.add(add,0,14);
                grid.add(sort,1,14);
                grid.add(end,2,14);

                add.setOnAction(e -> {

                    double[] x = {0,0};
                    if(swimming.isSelected())
                        x = calculations.calculate(1, duration.getText());
                    else if (running.isSelected())
                        x = calculations.calculate(2, duration.getText());
                    else if (kickBoxing.isSelected())
                        x = calculations.calculate(3, duration.getText());
                    else if(strengthTraining.isSelected())
                        x = calculations.calculate(4, duration.getText());

                    totalCaloriesValue.setText(String.valueOf((int)x[0]));
                    totalHeartRateValue.setText(String.valueOf(df.format(x[1])));

                });
                end.setOnAction(e ->{
                    exit(1);
                });
                sort.setOnAction(e -> {
                    sorting.sort();
                    stage.setScene(sortedTracker.getScene());
                });
            }
        });

        grid.setHgap(10);
        grid.setVgap(7);
        scene = new Scene(grid,700,700);
    }

    public Scene getScene(){
        return scene;
    }

    public void setSortedTracker(SortedTracker sortedTracker) {
        this.sortedTracker = sortedTracker;
    }

    public void setCalculations(Calculations calculations) {
        this.calculations = calculations;
    }

    public void setSorting(Sorting sorting) {
        this.sorting = sorting;
    }

    public TextField getDuration() {
        return duration;
    }
}
