class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int mxL = 0;
        int l = 0;

        HashMap<Character, Integer> m = new HashMap<>();

        int i=0, j=0;
        while(i < n && j < n){
            char ch = s.charAt(j);

            if(!m.containsKey(ch)){
                m.put(ch, 1);
                j++;    
            }
            else{
                
                while(m.containsKey(ch)){
                    m.remove(s.charAt(i++));
                }
            }
            mxL = Math.max(mxL, j-i);
        }
        return mxL;
    }
}
