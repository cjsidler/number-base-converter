import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> deltas = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        // Get all input numbers; last num is the given integer 'N'
        while (scanner.hasNextInt()) {
            nums.add(scanner.nextInt());
        }
        int N = nums.remove(nums.size() - 1);

        Collections.sort(nums);

        // Calculate the differences from the given integer 'N'
        int minDelta = Integer.MAX_VALUE;
        for (Integer num : nums) {
            minDelta = Math.min(minDelta, Math.abs(N - num));
        }

        // Print values that have the same delta as minDelta
        for (Integer num : nums) {
            if (Math.abs(N - num) == minDelta) {
                System.out.print(num + " ");
            }
        }
    }
}