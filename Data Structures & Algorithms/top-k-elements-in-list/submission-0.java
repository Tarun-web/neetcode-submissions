class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<n; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }

        ArrayList<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : m.entrySet()){
            arr.add(new int[]{e.getKey(), e.getValue()});
        }
        // [(3, 3), (2, 2), (1, 1)]
        Collections.sort(arr, (a, b)-> b[1] - a[1]);

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = arr.get(i)[0];
        }
        return ans;

    }
}
