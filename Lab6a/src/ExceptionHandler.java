public class ExceptionHandler {
    public static void main(String[] args) {
        for(int x = 0; x < 9; x++) {
            try {
                System.out.println(x / (x % 2));
            } catch (Exception e) {}
        }
    }
}
