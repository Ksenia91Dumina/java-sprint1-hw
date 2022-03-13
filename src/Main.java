import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        Commands commands = new Commands();
        while (true) {
            if (userInput == 1) {
                commands.command1();
            } else if (userInput == 2) {
                commands.command2();
            } else if (userInput == 3) {
                commands.command3();
            } else if (userInput == 4) {
                commands.command4();
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