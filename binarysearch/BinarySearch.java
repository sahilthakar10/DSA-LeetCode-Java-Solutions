//https://leetcode.com/problems/binary-search/

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int m = l + (r - l) /2 ;

            if (nums[m] < target) {
                l = m + 1;
            }else if (nums[m] > target){
                r = m - 1;
            }else {
                return m;
            }

        }

        return -1;
    }
}
