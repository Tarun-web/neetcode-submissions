class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        Stack<Integer> nextSmaller = new Stack<>(); 
        nextSmaller.push(-1);
        Stack<Integer> prevSmaller = new Stack<>(); 
        prevSmaller.push(-1);

        int[] nextS = new int[n];
        nextS[n-1] = -1;
        nextSmaller.push(n-1);
        int[] prevS = new int[n];
        prevS[0] = -1;
        prevSmaller.push(0);

        // find prevSmaller
        for(int i=1; i<n; i++){
            while(prevSmaller.peek() != -1 && heights[i] <= heights[prevSmaller.peek()] ){
                prevSmaller.pop();
            }
            prevS[i] = prevSmaller.peek();
            prevSmaller.push(i);
        }

        // find nextSmaller
        for(int i=n-2; i>=0; i--){
            while(nextSmaller.peek() != -1 && heights[i] <= heights[nextSmaller.peek()] ){
                nextSmaller.pop();
            }
            nextS[i] = nextSmaller.peek();
            nextSmaller.push(i);
        }

        // main logic
        int maxArea = 0;

        for(int i=0; i<n; i++){
            int start = prevS[i] == -1 ? 0   : prevS[i]+1;
            int end   = nextS[i] == -1 ? n-1 : nextS[i]-1;

            maxArea = Math.max(maxArea, heights[i] * (end - start + 1)); 
        }

        return maxArea;
    }
}
