/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        while(start < end) {
            int mid = start + (end - start) /2;
            if(mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }

        int peak = start;

        if(target >= mountainArr.get(0) && target <= mountainArr.get(peak)) {
            int left = 0;
            int right = peak;
            while(left<=right) {
                int middle = left + (right - left)/2;
                int val = mountainArr.get(middle);
                if(val == target) return middle;
                else if(val > target) right = middle - 1;
                else left = middle + 1;
            }
        }
        if(target <= mountainArr.get((peak + 1)) 
        && target >= mountainArr.get((mountainArr.length() - 1))) {
            int left = peak + 1;
            int right = mountainArr.length() - 1;
            while(left<=right) {
                int middle = left + (right - left)/2;
                int val = mountainArr.get(middle);
                if(val == target) return middle;
                else if(val < target) right = middle - 1;
                else left = middle + 1;
            }
            return -1;
        }
        return -1;
    }
}