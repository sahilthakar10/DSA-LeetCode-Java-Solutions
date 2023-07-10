//https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {

    public int search(int[] nums, int target) {
        int peakNumber = peakNumber(nums, 0, nums.length - 1);

        if (peakNumber == -1) {
           return binarysearch(nums, target, 0, nums.length -1);
        }

        if (target == nums[peakNumber]){
            return peakNumber;
        }


        if (target >= nums[0]) {
            return binarysearch(nums, target, 0, peakNumber-1);
        }else {
            return binarysearch(nums, target, peakNumber + 1, nums.length - 1);
        }
    }


    static int peakNumber(int[] ar, int start, int end) {

        while (start <= end) {
            
            int mid = start + (end - start) / 2 ;


            if (mid < end && ar[mid] > ar[mid+1]) {
                return mid;
            }
            if (mid > start && ar[mid-1] > ar[mid]) {
                return mid-1;
            }

            if (ar[start] > ar[mid]) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }

        }


        return -1;

    }

    static int binarysearch(int[] arr, int target, int start, int last) {

        int l = start;
        int r = last;

        while (l <= r) {
            int m = l + (r - l) /2;           
            if (target > arr[m]) {
                l = m + 1;
            }else if (target < arr[m]) {
                r = m -1 ;
            }else {
                return m;
            }
        }


        return -1;
    }


}
