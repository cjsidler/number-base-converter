import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal bigdec = new BigDecimal(scanner.next());
        int newScale = scanner.nextInt();
        bigdec = bigdec.setScale(newScale, RoundingMode.HALF_DOWN);
        System.out.println(bigdec);
    }
}