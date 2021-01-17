package sample;

import java.util.*;

public class Sorting {

    private List<Activity> activity = new ArrayList<Activity>();
    private SortedTracker sortedTracker;

    private Activity swimming = new Activity("Swimming");
    private Activity running = new Activity("Running");
    private Activity kickBoxing = new Activity("Kick Boxing");
    private Activity strengthTraining = new Activity("Strength Training");



    public void addToList(int sport, double calories, double heartRate) {

        switch (sport) {
            case 1:
                swimming.setCalories(calories + swimming.getCalories());
                swimming.setHeartRate(heartRate + swimming.getHeartRate());
                break;
            case 2:
                running.setCalories(calories + running.getCalories());
                running.setHeartRate(heartRate + running.getHeartRate());
                break;
            case 3:
                kickBoxing.setCalories(calories + kickBoxing.getCalories());
                kickBoxing.setHeartRate(heartRate + kickBoxing.getHeartRate());
                break;
            case 4:
                strengthTraining.setCalories(calories + strengthTraining.getCalories());
                strengthTraining.setHeartRate(heartRate + strengthTraining.getHeartRate());
                break;
        }
    }

    public void sort() {

        activity.clear();
        activity.add(swimming);
        activity.add(running);
        activity.add(kickBoxing);
        activity.add(strengthTraining);
        Collections.sort(activity);
//        Collections.sort(activity, new Comparator<Activity>() {
//            @Override
//            public int compare(Activity o1, Activity o2) {
//                if (o1.getCalories() != o2.getCalories())
//                    return new Double(o2.getCalories()).compareTo(o1.getCalories());
//        return new Double(o2.getHeartRate()).compareTo(o1.getHeartRate());

//                    return (int) (o2.getCalories() - o1.getCalories());
//                return (int) (o1.getHeartRate() - o2.getHeartRate());
//            }
//        });

        sortedTracker.setLabels(activity);
            }

    public void setSortedTracker(SortedTracker sortedTracker) {
        this.sortedTracker = sortedTracker;
    }

}
