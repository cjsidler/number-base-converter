import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal bigdec1 = scanner.nextBigDecimal();
        BigDecimal bigdec2 = scanner.nextBigDecimal();
        System.out.println(bigdec1.multiply(bigdec2));
    }
}