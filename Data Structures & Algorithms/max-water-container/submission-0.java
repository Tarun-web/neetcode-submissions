class Solution {
    public int maxArea(int[] h) {
        int n = h.length;
        int i = 0, j = n-1;

        int mxArea = 0;

        while(i < j){
            mxArea = Math.max(mxArea, Math.min(h[i], h[j]) * (j-i));
            if(h[i] <= h[j]) i++;
            else j--;
        }
        return mxArea;
    }
}
