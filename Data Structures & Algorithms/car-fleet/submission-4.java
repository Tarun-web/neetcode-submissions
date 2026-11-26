class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        int[][] cars = new int[n][2];

        for(int i=0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        double maxTime = 0.00;

        int fleetCount = 0;

        for(int i=0; i<n; i++){
            Double currTime = (double)(target - cars[i][0])/cars[i][1];
            if(currTime > maxTime){
                maxTime = currTime;
                fleetCount++;
            }
        }
        return fleetCount;
    }
}
