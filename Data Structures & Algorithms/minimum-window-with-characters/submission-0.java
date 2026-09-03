class Solution {
    public String minWindow(String s, String t) {

        if(s.length() < t.length()) return "";
        
        int n = s.length();

        int[] f = new int[128];
        for(int i=0; i<t.length(); i++){
            f[t.charAt(i) - 'A']++;
        }

        

        int minL = Integer.MAX_VALUE;
        int minI = -1, minJ = -1;

        int i = 0, j = 0;
        int count = t.length();

        while(j < n){
            // find a valid window
            while(j < n && count > 0){
                char ch = s.charAt(j);
                // check if f[j] >0
                if(f[ch-'A'] > 0){
                    count--;
                }
                f[ch-'A']--;
                j++;
            }

            // shrink the window
            while(count == 0){
                if(minL > j-i+1){
                    minL = j-i+1;
                    minI = i;
                    minJ = j;
                }

                f[s.charAt(i)-'A']++;

                if(f[s.charAt(i)-'A'] > 0){
                    count++;
                }
                i++;
            }
        }


        return (minI == -1 || minJ == -1) ? "" : s.substring(minI, minJ);
    }
}
