
import java.util.Scanner;


/* Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        try {
            System.out.print("Введите текст: ");
            userInput = scanner.nextLine().trim(); // Убираем пробелы в начале и конце

            if (userInput.isEmpty()) {
                throw new Exception("Пустые строки вводить нельзя!");
            }

            System.out.println("Вы ввели: " + userInput);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
