public class Withreturn {

    public static int add(int a, int b) { 
		return a + b;
		}
    public static int subtract(int a, int b) {
    	return a - b; 
    	}
    public static int multiply(int a, int b) {
    	return a * b;
    	}
    public static int divison(int a, int b) {
    	return a/b;
    }

	public static void main(String[] args) {
		int a = 10, b = 2;
        System.out.println("Addition: " + add(a, b));
        System.out.println("Subtraction: " + subtract(a, b));
        System.out.println("Multiplication: " + multiply(a, b));
        System.out.println("Division: " + divison(a, b));

	}

    
}
