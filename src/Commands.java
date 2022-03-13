import java.util.Scanner;

public class Commands {
    Scanner scanner = new Scanner(System.in);
    StepTracker stepTracker = new StepTracker();

    void command1() {
        System.out.println("За какой месяц хотите ввести данные (введите от 1 до 12)?");
        System.out.println("1 - Январь");
        System.out.println("2 - Февраль");
        System.out.println("3 - Март");
        System.out.println("4 - Апрель");
        System.out.println("5 - Май");
        System.out.println("6 - Июнь");
        System.out.println("7 - Июль");
        System.out.println("8 - Август");
        System.out.println("9 - Сентябрь");
        System.out.println("10 - Октябрь");
        System.out.println("11 - Ноябрь");
        System.out.println("12 - Декабрь");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) System.out.println("Введено некорректное значение!");
        else {
            System.out.println("За какой день (введите от 1 до 30)?");
            int day = scanner.nextInt();
            if (day < 1 || day > 30) System.out.println("Введено некорректное значение!");
            else {
                System.out.println("Введите количество шагов");
                int steps = scanner.nextInt();
                if (steps < 0) System.out.println("Введено некорректное значение! Не может быть отрицательным.");
                else {
                    if (stepTracker.monthToData.containsKey(month - 1))
                        stepTracker.saveStepsPerDay((month - 1), (day - 1), steps);
                    else {
                        stepTracker = new StepTracker();
                        stepTracker.saveStepsPerDay((month - 1), (day - 1), steps);
                    }
                }
            }
        }
    }

    void command2() {
        System.out.println("За какой месяц хотите посмотреть данные (введите от 1 до 12)?");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) System.out.println("Введено некорректное значение!");
        else {
            int monthForSearch = month - 1;
            stepTracker.printAllStepsPerMonth(monthForSearch);
            stepTracker.StepSumPerMonth(monthForSearch);
            stepTracker.findMaxStepsNumber(monthForSearch);
            stepTracker.averageStepsAmount(monthForSearch);
            stepTracker.StepSumInKm(monthForSearch);
            stepTracker.CaloriesBurnAmount(monthForSearch);
            stepTracker.findBestSeries(monthForSearch, stepTracker.goalOfSteps);
        }
    }

    void command3() {
        System.out.println("Какое количество шагов записать в целевое значение?");
        int steps = scanner.nextInt();
        if (steps < 0) System.out.println("Введено некорректное значение! Не может быть отрицательным.");
        else {
            stepTracker.goalOfSteps = steps;
            System.out.println("Значение обновлено на " + stepTracker.goalOfSteps);
        }
    }

    void command4() {
        System.out.println("Программа завершена");
    }
}
