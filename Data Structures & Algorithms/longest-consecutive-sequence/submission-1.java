class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> m = new HashSet<>();

        int n = nums.length;

        for(int i=0; i<n; i++){
            m.add(nums[i]);
        }

        int mxLen = 0;
        for(int i=0; i<n; i++){
            if(!m.contains(nums[i]-1)){
                int l = 0;
                int start = nums[i];
                while(m.contains(start)){
                    start++;
                    l++;
                }
                mxLen = Math.max(mxLen, l);
            }
            
        }
        return mxLen;
    }
}
