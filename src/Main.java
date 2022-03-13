//Доброго дня! Вчера сразу не поняла как смотреть замечания.
//Прошу понять и простить)

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int ADD_STEPS = 1;
        final int SHOW_STATISTICS = 2;
        final int CHANGE_GOAL = 3;
        final int BREAK = 4;

        printMenu();
        int userInput = scanner.nextInt();
        Commands commands = new Commands(scanner);

        while (true) {
            if (userInput == ADD_STEPS) {
                commands.command1(scanner);
            } else if (userInput == SHOW_STATISTICS) {
                commands.command2(scanner);
            } else if (userInput == CHANGE_GOAL) {
                commands.command3(scanner);
            } else if (userInput == BREAK) {
                System.out.println("Программа завершена");
                scanner.close();
                break;
            } else {
                System.out.println("Извините, такой команды нет. Выберите из списка. ");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за день");
        System.out.println("2 - Просмотреть статистику за месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
} 