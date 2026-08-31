class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> m = new HashMap<>();

        int n = s.length();

        int maxFreq = 0;
        int maxL = 0;

        int i=0, j=0;
        while(i < n && j < n){
            char ch = s.charAt(j);
            m.put(ch, m.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(m.get(ch), maxFreq);
            int change = (j-i+1) - maxFreq;
            
            while((j-i+1) - maxFreq > k){
                m.put(s.charAt(i), m.get(s.charAt(i))-1);
                i++;
            }
            maxL = Math.max(maxL, j-i+1);
            j++;
        }
        return maxL;
    }
}
