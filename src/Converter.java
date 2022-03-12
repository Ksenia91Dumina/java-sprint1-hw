
public class Converter {


    float step = 75f / 100000f;
    float calorieForStep = 50f / 1000f;

    void convertDistance(int stepSum) {
        System.out.println("Количество пройденных шагов в километрах = " + stepSum * step);
    }

    void convertCalories(int stepSum) {
        System.out.println("Количество соженных килокалорий = " + stepSum * calorieForStep);
    }
}