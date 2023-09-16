public static void main(String[] args) {
    try {
        int a = 90;
        int b = 3;
        System.out.println(a / b);
        printSum(23, 234);
        int[] abc = { 1, 2 };
        abc[2] = 9;
    } catch (ArithmeticException ex) {
        System.out.println("Деление на ноль!");
    } catch (NullPointerException ex) {
        System.out.println("Указатель не может указывать на null!");
    } catch (ArrayIndexOutOfBoundsException ex) {
        System.out.println("Массив выходит за пределы своего размера!");
    } catch (Exception ex) {
        System.out.println("Что-то пошло не так...");
    }
}

public static void printSum(Integer a, Integer b) {
    System.out.println(a + b);
}
