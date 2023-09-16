import java.util.Scanner;



/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */

public class Main {
    public static void main(String[] args) {
        float userInput = getInput();
        System.out.println("Вы ввели: " + userInput);
    }

    public static float getInput() {
        float result = 0;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);

        while (!validInput) {
            System.out.print("Введите дробное число (типа float): ");

            try {
                result = Float.parseFloat(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введено некорректное число. Пожалуйста, повторите ввод.");
            }
        }

        return result;
    }
}
