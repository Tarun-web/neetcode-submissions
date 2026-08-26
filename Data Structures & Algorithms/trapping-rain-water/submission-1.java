class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int i=0, j=n-1;

        int pref = h[0], suf = h[n-1];

        int water = 0;

        while(i < j){
            if(h[i] <= h[j]){
                water += pref - h[i];
                i++;
                pref = Math.max(pref, h[i]);
                
            }
            else{
                water += suf - h[j];
                j--;
                suf = Math.max(suf, h[j]);
                
            }
        }
        return water;
    }
}
