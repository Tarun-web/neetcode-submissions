class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;

        Stack<Integer> s = new Stack<>();
        s.push(-1);
        s.push(n-1);

        int[] res = new int[n];
        res[n-1] = 0;

        for(int i=n-2; i>=0; i--){

            while(s.peek() != -1 && t[s.peek()] <= t[i]){
                s.pop();
            }
            res[i] = s.peek() == -1 ? 0 : s.peek() - i;
            
            s.push(i);
        }
        return res;
    }
}
