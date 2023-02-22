import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        if (n == 0) {
            return BigInteger.ONE;
        }
        BigInteger result = BigInteger.valueOf(n);
        n -= 2;
        while (n > 0) {
            result = result.multiply(BigInteger.valueOf(n));
            n -= 2;
        }
        return result;
    }
}