class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        int n = strs.length;
        HashMap<String, ArrayList<String>> m = new HashMap<>();

        for(int i=0; i<n; i++){

            // make the freq array
            int[] f = new int[26];
            for(int j=0; j<strs[i].length(); j++){
                char ch = strs[i].charAt(j);
                f[ch - 'a']++;
            }

            // attach the freq array to map
            m.computeIfAbsent(Arrays.toString(f), k -> new ArrayList<>()).add(strs[i]);
            
        }
        return new ArrayList<>(m.values());
    }
}
