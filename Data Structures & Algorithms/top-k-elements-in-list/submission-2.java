class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> m = new HashMap<>();

        for(int i : nums){
            m.put(i, m.getOrDefault(i, 0) + 1);

        }

        // create the bucket array
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(Map.Entry<Integer, Integer> e : m.entrySet()){
            int key = e.getKey();
            int val = e.getValue();

            if(bucket[e.getValue()] == null){
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
        }

        int[] ans = new int[k];
        int inc = 0;
        for(int i=bucket.length-1; i>=0; i--){
            if(bucket[i] != null){
                System.out.println(bucket[i]);
                for(int j=0; j<bucket[i].size(); j++){
                    ans[inc++] = bucket[i].get(j);
                    if(inc == k) return ans;
                }
            }
        }
        return ans;
    }
}
