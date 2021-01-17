package sample;


public class Calculations {

    private double caloriesBurntInc = 0;
    private double heartRateInc = 0;
    private double totalCaloriesBurnt  = 0;
    private double totalHeartRate = 80;
    private int duration;
    private Sorting sorting;


    public double[] calculate(int sport,String time){
        double[] a;
        a = new double[2];
        duration = Integer.parseInt(time);

    switch (sport){
            case 1:
                caloriesBurntInc=4*duration;
                totalCaloriesBurnt+=caloriesBurntInc;
                heartRateInc=(totalHeartRate*duration*0.002);
                totalHeartRate+=heartRateInc;
                a[0]=totalCaloriesBurnt;
                a[1]=totalHeartRate;
                sorting.addToList(sport,caloriesBurntInc,heartRateInc);
                return a;
            case 2:
                caloriesBurntInc=5*duration;
                totalCaloriesBurnt+=caloriesBurntInc;
                heartRateInc=(totalHeartRate*duration*0.003);
                totalHeartRate+=heartRateInc;
                a[0]=totalCaloriesBurnt;
                a[1]=totalHeartRate;
                sorting.addToList(sport,caloriesBurntInc,heartRateInc);
                return a;
            case 3:
                caloriesBurntInc=3*duration;
                totalCaloriesBurnt+=caloriesBurntInc;
                heartRateInc=(totalHeartRate*duration*0.005);
                totalHeartRate+=heartRateInc;
                a[0]=totalCaloriesBurnt;
                a[1]=totalHeartRate;
                sorting.addToList(sport,caloriesBurntInc,heartRateInc);
                return a;
            case 4:
                caloriesBurntInc=5*duration;
                totalCaloriesBurnt+=caloriesBurntInc;
                heartRateInc=(totalHeartRate*duration*0.006);
                totalHeartRate+=heartRateInc;
                a[0]=totalCaloriesBurnt;
                a[1]=totalHeartRate;
                sorting.addToList(sport,caloriesBurntInc,heartRateInc);
                return a;
            default:
                a[0]=totalCaloriesBurnt;
                a[1]=totalHeartRate;
                return a;
        }
}

    public double getTotalCaloriesBurnt() {
        return totalCaloriesBurnt;
    }

    public double getTotalHeartRate() {
        return totalHeartRate;
    }

    public void setSorting(Sorting sorting) {
        this.sorting = sorting;
    }
}
