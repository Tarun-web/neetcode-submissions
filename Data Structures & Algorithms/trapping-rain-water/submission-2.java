class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int i=0, j=n-1;

        int pref = h[0], suf = h[n-1];

        int water = 0;

        while(i < j){
            if (h[i] <= h[j]) {
                pref = Math.max(pref, h[i]);
                water += pref - h[i];
                i++;
            } 
            else {
                suf = Math.max(suf, h[j]);
                water += suf - h[j];
                j--;
            }
        }
        return water;
    }
}
