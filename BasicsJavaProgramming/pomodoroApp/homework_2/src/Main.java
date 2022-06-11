import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String W = "-w";
    private static final String B = "-b";
    private static final String COUNT = "-count";
    private static final String HELP = "--help";

    private static void printHelpMsg() {
        System.out.println("Сведения о командах:");
        System.out.println("\t" + W + " <time>: время работы (мин.), сколько хочешь работать");
        System.out.println("\t" + B + " <time>: время отдыха (мин.), сколько хочешь отдыхать");
        System.out.println("\t" + COUNT + " <count>: количество итераций");
        System.out.println("\t" + HELP + ": меню помощи");
        System.out.print(System.lineSeparator());
    }

    public static void main(String[] args) {
        System.out.println("POMODORO - СДЕЛАЙ СВОЕ ВРЕМЯ БОЛЕЕ ЭФФЕКТИВНЫМ");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Введите команду: ");
                String[] userInput = scanner.nextLine()
                        .strip()
                        .toLowerCase()
                        .split("\\s+");
                if (userInput.length == 1 && HELP.equals(userInput[0])) {
                    printHelpMsg();
                } else if (userInput.length == 6) {
                    Map<String, Integer> parse = new HashMap<>();

                    try {
                        for (int i = 0; i < userInput.length; i += 2) {
                            parse.put(userInput[i], Integer.parseInt(userInput[i + 1]));
                        }

                        int w = parse.get(W);
                        int b = parse.get(B);
                        int count = parse.get(COUNT);

                        if (w < 1 || b < 1 || count < 1)
                            throw new IllegalArgumentException();

                        System.out.print(System.lineSeparator());
                        for (int i = 0; i < count; i++) {
                            new Pomodoro(w, b).start();
                            System.out.print(System.lineSeparator());
                        }

                        System.out.println("ТАЙМЕР ИСТЕК!");

                        break;
                    } catch (RuntimeException e) {
                        System.err.println("Указаны некорректные данные. Повторите ввод.");
                        printHelpMsg();
                    } catch (InterruptedException e) {
                        System.err.println("Что-то пошло не так... :(");
                        break;
                    }
                } else {
                    System.err.println("Указаны некорректные данные. Повторите ввод.");
                    printHelpMsg();
                }
            }
        }
    }
}
