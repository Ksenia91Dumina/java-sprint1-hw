import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class StepTracker {

    public MonthData monthData = new MonthData();
    Converter converter = new Converter();
    HashMap<Integer, MonthData> monthToData = new HashMap<>();
    public int goalOfSteps = 10000;

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

     void saveStepsPerDay(int month, int day, int steps) {
        for (Integer monthNumber : monthToData.keySet()) {
            if (month == monthNumber) {
                monthData.addStepsPerDay(day, steps);
                monthToData.put(month, monthData);
            }
        }
    }

     void printAllStepsPerMonth(int month) {
        for (Integer monthNumber : monthToData.keySet()) {
            if (month == monthNumber)  {
                MonthData days = monthToData.get(month);
                days.printSteps();
            }
        }
    }

    void StepSumPerMonth(int month) {
        for (Integer monthNumber : monthToData.keySet()) {
            if (month == monthNumber) {
                MonthData days = monthToData.get(month);
                System.out.println("Общее количество шагов за месяц = " + days.stepSum());
            }
        }
    }

    void StepSumInKm(int month) {
        for (Integer monthNumber : monthToData.keySet()) {
            if (month == monthNumber) {
                MonthData days = monthToData.get(month);
                converter.convertDistance(days.stepSum());
            }
        }
    }

    void CaloriesBurnAmount(int month) {
        for (Integer monthNumber : monthToData.keySet()) {
            if (month == monthNumber) {
                MonthData days = monthToData.get(month);
                converter.convertCalories(days.stepSum());
            }
        }
    }

    void findMaxStepsNumber(int month) {
        for (Integer monthNumber : monthToData.keySet()) {
            if (month == monthNumber) {
                MonthData days = monthToData.get(month);
                System.out.println("Максимальное пройденное количество шагов в день = " + days.maxStepsCount());
            }
        }
    }

    void averageStepsAmount(int month) {
        for (Integer monthNumber : monthToData.keySet()) {
            if (month == monthNumber) {
                MonthData days = monthToData.get(month);
                System.out.println("Среднее количество шагов в день = " + days.averageStepSum());
            }
        }
    }

    void findBestSeries(int month, int goalOfSteps) {
        int bestSeries = 0;
        for (Integer monthNumber : monthToData.keySet()) {
            if (month == monthNumber) {
                MonthData days = monthToData.get(month);
                bestSeries = days.bestSeries(goalOfSteps);
            }
        }
                if (bestSeries<=1)
                    System.out.println("В этом месяце не было серии");
                else if(bestSeries<5 || bestSeries>2)
                    System.out.println("Лучшая серия - "+ bestSeries +" дня подряд");
                else
                    System.out.println("Лучшая серия - "+ bestSeries +" дней подряд");

    }

}