public class EH {
    public static void main(String[] args) {
        int[] num = { 1, 2, 3 };
        try {
            System.out.println("I need 5th element" + num[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error");
        } finally {
            System.out.println("Completed");
        }
    }
}
