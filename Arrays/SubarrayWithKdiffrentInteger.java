class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    public int helper(int[] nums, int k) {
        int l = 0, r = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < nums.length) {
            // Add nums[r] to the map
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            // Shrink the window if we exceed k distinct elements
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }

            // Count subarrays ending at r with at most k distinct elements
            count += (r - l + 1);
            r++;
        }

        return count;
    }
}
