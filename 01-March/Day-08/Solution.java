import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int maxFrequency = 1;
        int currentFrequency = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                currentFrequency++;
            } else {
                currentFrequency = 1;
            }
            maxFrequency = Math.max(maxFrequency, currentFrequency);
        }
        if (maxFrequency == 1)
            return nums.length;

        int count = 0;
        currentFrequency = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                currentFrequency++;
            } else {
                currentFrequency = 1;
            }
            if (currentFrequency == maxFrequency) {
                count += currentFrequency;
            }
        }

        return count;
    }
}