package algorithms;

public class BoyerMooreMajority {

    public static Integer findMajorityElement(int[] nums) {
        int candidate = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }

        return count > nums.length / 2 ? candidate : null;
    }
}