package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Simple Fitness Tracker");
        ActivitySelection activitySelection = new ActivitySelection(primaryStage);
        SortedTracker sortedTracker = new SortedTracker(primaryStage);
        Sorting sorting = new Sorting();
        Calculations calculations = new Calculations();

        activitySelection.prepareScene();
        sortedTracker.prepareScene();

        activitySelection.setSortedTracker(sortedTracker);
        activitySelection.setCalculations(calculations);
        activitySelection.setSorting(sorting);

        sortedTracker.setActivitySelection(activitySelection);
        sortedTracker.setCalculations(calculations);

        sorting.setSortedTracker(sortedTracker);

        calculations.setSorting(sorting);

        primaryStage.setScene(activitySelection.getScene());
        primaryStage.show();
        activitySelection.getDuration().requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
