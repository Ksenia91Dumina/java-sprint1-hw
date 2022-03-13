import java.util.ArrayList;
import java.util.Collections;

public class MonthData {

    final  int CONDITION_FOR_RIGHT_PUNCTUATION = 29;
    public int day;
    public int steps;
    ArrayList<Integer> monthDates = new ArrayList<>();

    public MonthData() {
        for (int i = 0; i < 30; i++) {
            this.day = i;
            this.steps = 0;
            monthDates.add(day, steps);
        }
    }

    void addStepsPerDay(int day, int steps) {
        for (int i = 0; i < monthDates.size(); i++) {
            if (i == day) {
                monthDates.set(day, steps);
                System.out.println("Значение успешно добавлено!");
            }
        }
    }

    void printSteps() {
        System.out.println("Количество пройденных шагов по дням: ");
        for (int i = 0; i < monthDates.size(); i++) {
            if (i < CONDITION_FOR_RIGHT_PUNCTUATION)
                System.out.print((i + 1) + " день: " + monthDates.get(i) + ", ");
            else
                System.out.print((i + 1) + " день: " + monthDates.get(i) + ".\n");
        }
    }

    int stepSum() {
        int sum = 0;
        for (int i = 0; i < monthDates.size(); i++)
            sum += monthDates.get(i);
        return sum;
    }

    double averageStepSum() {
        double averageStepSum = stepSum() / monthDates.size();
        return averageStepSum;
    }

    int maxStepsCount() {
        int max = Collections.max(monthDates);
        return max;
    }

    int bestSeries(int goalOfSteps) {
        int amountOfDays = 0;
        ArrayList<Integer> targetDays = new ArrayList<>();
        for (int i = 0; i < monthDates.size(); i++) {
            if (monthDates.get(i) >= goalOfSteps) amountOfDays += 1;
            else {
                targetDays.add(amountOfDays);
                amountOfDays = 0;
            }
        }
        return Collections.max(targetDays);
    }
}

