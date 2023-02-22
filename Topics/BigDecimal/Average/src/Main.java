import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal bigdec1 = scanner.nextBigDecimal();
        BigDecimal bigdec2 = scanner.nextBigDecimal();
        BigDecimal bigdec3 = scanner.nextBigDecimal();

        BigDecimal sum = bigdec1.add(bigdec2).add(bigdec3);
        BigDecimal avg = sum.divide(BigDecimal.valueOf(3), 0, RoundingMode.DOWN);

        System.out.println(avg);
    }
}