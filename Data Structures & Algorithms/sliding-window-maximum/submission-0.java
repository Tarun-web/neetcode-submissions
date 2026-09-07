class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] ans = new int[n-k+1];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        // addd the first window to pq
        int i = 0, j = k-1;
        for(int id=0; id<k; id++){
            pq.offer(new int[]{nums[id], id});
        }
        ans[0] = pq.peek()[0];

        i++; j++;

        int index = 1;
        while(j < n){
            //remove out of window maxes from pq
            while(!pq.isEmpty() && pq.peek()[1] < j-k+1){
                pq.poll();
            }

            pq.offer(new int[]{nums[j], j});
            ans[index++] = pq.peek()[0];

            i++; j++;
        }
        return ans;
    }
}
