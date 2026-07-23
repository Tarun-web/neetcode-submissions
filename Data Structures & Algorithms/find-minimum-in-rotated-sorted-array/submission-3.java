class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        int mid = s + (e-s)/2;

        int ans = Integer.MAX_VALUE;

        while(s <= e){
            if(nums[mid] <= nums[e]){
                ans = Math.min(ans, nums[mid]);
                e = mid-1;
            }
            else{
                s = mid+1;
            }
            mid = s + (e-s)/2;
        }
        return ans;
    }
}
