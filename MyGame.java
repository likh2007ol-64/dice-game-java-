import java.util.Scanner;
import java.util.Random;

public class MyGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int targetNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int bestScore = Integer.MAX_VALUE;

        System.out.println("Компьютер загадал число от 1 до 100. Попробуй угадать!");
        System.out.println("Если хочешь узнать текущий результат, введи RESULT.");

        while (true) {
            System.out.print("Твой вариант: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("RESULT")) {
                System.out.println("Текущее количество попыток: " + attempts);
                if (bestScore == Integer.MAX_VALUE) {
                    System.out.println("Лучшая игра ещё не завершена.");
                } else {
                    System.out.println("Лучший результат: " + bestScore);
                }
                continue;
            }

            int guess;
            try {
                guess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введи целое число или команду RESULT.");
                continue;
            }

            attempts++;

            if (guess < targetNumber) {
                System.out.println("***Я сам в шоке, но, загаданное число больше, брат***");
            } else if (guess > targetNumber) {
                System.out.println("***Не ожидал от тебя такого. Загаданное число меньше, брат***");
            } else {
                System.out.println("Поздравляю! Ты угадал число " + targetNumber + " за " + attempts + " попыток.");
                if (attempts < bestScore) {
                    bestScore = attempts;
                    System.out.println("Это новый рекорд!");
                }
                break;
            }
        }

        scanner.close();
    }
}