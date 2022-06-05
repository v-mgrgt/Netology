import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("ИГРА \"ПОЛЕ ЧУДЕС\""
                + System.lineSeparator());

        Word word = new Word("Java");

        System.out.println("Слово: " + word.getHiddenWord()
                + System.lineSeparator());

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.print("Введите букву: ");
                char letter = scanner.nextLine().charAt(0);
                if (word.isLetter(letter)) {
                    System.out.println("Есть такая буква!");
                } else {
                    System.out.println("Такой буквы нет!");
                }

                System.out.println(System.lineSeparator()
                        + "Слово: " + word.getHiddenWord()
                        + System.lineSeparator());
            } while (word.isHiddenWord());

            System.out.println("Ура! Вы победили!");
        }
    }
}
