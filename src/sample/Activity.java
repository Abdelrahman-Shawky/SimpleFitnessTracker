package sample;

public class Activity implements Comparable<Activity> {


    private String sport;
    private double calories;
    private double heartRate;

    public Activity(String sport) {
        this.sport = sport;
        this.calories = 0;
        this.heartRate = 0;
    }

    @Override
    public int compareTo(Activity o) {
        if(this.getCalories() != o.getCalories())
            return new Double(o.getCalories()).compareTo(this.getCalories());
        return new Double(o.getHeartRate()).compareTo(this.getHeartRate());


//            return (int) (o.getCalories() - this.getCalories());
//                return (int) (o.getHeartRate() - this.getHeartRate());

    }

    public String getSport() {
        return sport;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }
}
