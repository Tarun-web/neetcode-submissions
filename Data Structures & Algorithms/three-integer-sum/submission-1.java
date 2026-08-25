class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        HashSet<List<Integer>> s = new HashSet<>();

        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-2; i++){
            int a = nums[i];

            int j = i+1;
            int k = n-1;

            while(j < k){
                int b = nums[j];
                int c = nums[k];
                int sum = a+b+c;

                if(sum == 0){
                    s.add(Arrays.asList(a, b, c));
                    while(j+1 < k && nums[j] == nums[j+1]){
                        j++;
                    }
                    while(k-1 > j && nums[k] == nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        ArrayList<List<Integer>> ans = new ArrayList<>(s);
        return ans;
    }
}
