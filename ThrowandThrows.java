public class ThrowandThrows {
        public static void main(String[] args) {
            try {
                divide(10, 0);
            } catch (ArithmeticException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
        }
    
        public static int divide(int a, int b) throws ArithmeticException {
            if (b == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            return a / b;
        }
    }
    