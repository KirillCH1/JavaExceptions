import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class UserDataProcessor {
    public static void main(String[] args) {
        boolean validInput = false;
        while (!validInput) {
            try {
                String userData = getUserData();
                processData(userData);
                System.out.println("Данные успешно обработаны и записаны в файл.");
                validInput = true; // Устанавливаем флаг в true, если данные успешно обработаны
            } catch (Exception e) {
                System.err.println("Ошибка: " + e.getMessage());
                System.out.println("Пожалуйста, введите данные заново.");
            }
        }
    }

    public static String getUserData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в произвольном порядке (Фамилия Имя Отчество, дата рождения, номер телефона, пол):");
        return scanner.nextLine();
    }

    public static void processData(String input) throws Exception {
        String[] parts = input.split(" ");

        if (parts.length != 6) {
            throw new Exception("Неверное количество данных");
        }

        String lastName = parts[0];
        String firstName = parts[1];
        String middleName = parts[2];
        String birthDate = parts[3];
        String phoneNumber = parts[4];
        String gender = parts[5];

        // Проверка формата даты
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(birthDate);
        } catch (ParseException e) {
            throw new Exception("Неверный формат даты рождения");
        }

        // Проверка формата номера телефона
        try {
            Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            throw new Exception("Неверный формат номера телефона");
        }

        // Проверка формата пола
        if (!gender.equals("ж") && !gender.equals("м")) {
            throw new Exception("Неверный формат пола нужно использовать (м или ж)");
        }

        // Создание строки для записи в файл
        String userData = lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender;

        // Создание файла с именем фамилии и запись данных в него
        try (FileWriter fileWriter = new FileWriter(lastName + ".txt")) {
            fileWriter.write(userData + "\n");
        } catch (IOException e) {
            throw new Exception("Ошибка при записи данных в файл");
        }
    }
}
