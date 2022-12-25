package thirtyDaysOfCode;

import java.util.Scanner;

public class PrintArrayMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Integer[] intArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = scanner.nextInt();
        }

        n = scanner.nextInt();
        String[] stringArray = new String[n];
        for (int i = 0; i < n; i++) {
            stringArray[i] = scanner.next();
        }

        PrintArray<Integer> intPrinter = new PrintArray<>();
        PrintArray<String> stringPrinter = new PrintArray<>();
        intPrinter.printArray(intArray);
        stringPrinter.printArray(stringArray);

        if (PrintArray.class.getDeclaredMethods().length > 1) {
            System.out.println("The Printer class should only have 1 method named printArray.");
        }
    }

}
