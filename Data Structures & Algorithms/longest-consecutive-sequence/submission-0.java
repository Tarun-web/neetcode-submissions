class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> m = new HashMap<>();

        int n = nums.length;

        for(int i=0; i<n; i++){
            m.putIfAbsent(nums[i], false);
        }

        int mxLen = 0;
        for(int i=0; i<n; i++){
            if(m.get(nums[i]) == false){
                int start = nums[i];
                int end = nums[i];
                while(m.containsKey(start)){
                    m.put(start, true);
                    start--;
                }
                while(m.containsKey(end)){
                    m.put(end, true);
                    end++;
                }
                mxLen = Math.max(mxLen, ((end-start)-1));
            }
            
        }
        return mxLen;
    }
}
