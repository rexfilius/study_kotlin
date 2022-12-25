package thirtyDaysOfCode;

public class PrintArray<T> {
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
