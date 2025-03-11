import java.util.Arrays;
public class ThreeSumClosest {

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closer = nums[0] + nums[1] + nums[2]; // Initialize with the first three elements' sum

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate elements
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                // Update `closer` if this sum is closer to the target
                if (Math.abs(sum - target) < Math.abs(closer - target)) {
                    closer = sum;
                }

                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    return sum; // Exact match, return immediately
                }
            }
        }
        return closer;
    }
}

}
