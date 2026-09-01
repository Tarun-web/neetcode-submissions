class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length(), n2 = s2.length();

        if(n1 > n2) return false;
        
        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for(int i=0; i<n1; i++){
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }

        int i=0, j=n1-1;
        boolean isValid = true;


        while(j < n2){
            // check arrays
            for(int k=0; k<26; k++){
                if(f1[k] != f2[k]){
                    isValid = false;
                    break;
                }
            }
            f2[s2.charAt(i) - 'a']--;
            i++; j++;
            if(j < n2) f2[s2.charAt(j) - 'a']++;

            if(isValid) return true;
            isValid = true;
        }
        return false;
    }
}
