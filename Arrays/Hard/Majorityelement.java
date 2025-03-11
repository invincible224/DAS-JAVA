// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

//  Input: nums = [3,2,3]
// Output: [3]



import java.util.ArrayList;
// import java.util.HashMap;
import java.util.List;

class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {

        // Better approach
        /*
         * List<Integer> ans = new ArrayList<>();
         * 
         * HashMap<Integer,Integer> map = new HashMap<>();
         * 
         * for (int i = 0; i < nums.length; i++) {
         * map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
         * }
         * 
         * for (int key : map.keySet()) {
         * if(map.get(key)> (nums.length/3) ){
         * ans.add(key);
         * }
         * }
         * return ans;
         */

        // Optimal solution
        List<Integer> list = new ArrayList<>();

        int count1 = 0;
        int count2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && ele2 != nums[i]) {
                count1++;
                ele1 = nums[i];
            } else if (count2 == 0 && ele1 != nums[i]) {
                count2++;
                ele2 = nums[i];
            } else if (ele1 == nums[i]) {
                count1++;
            } else if (ele2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // to verify the answer
        count1 = 0;
        count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (ele1 == nums[i]) {
                count1++;
            }
            if (ele2 == nums[i]) {
                count2++;
            }
        }
        if (count1 > (nums.length / 3)) {
            list.add(ele1);
        }
        if (count2 > (nums.length / 3)) {
            list.add(ele2);
        }
        return list;
    }
}