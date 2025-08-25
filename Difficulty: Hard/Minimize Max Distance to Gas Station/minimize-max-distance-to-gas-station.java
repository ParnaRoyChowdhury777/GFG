class Solution {
    
    public static class Pair {
        double first;
        int second;
        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    
    public double minMaxDist(int[] stations, int K) {
        // code here
        int n = stations.length;
        
        if(n == 1) {
            return 0.0;
        }
        
        int[] howMany = new int[n-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.first, a.first));
        for(int i=0; i<n-1; i++) {
            pq.add(new Pair(stations[i+1] - stations[i], i));
        }
        for(int gasStations=1; gasStations<=K; gasStations++) {
            Pair temp = pq.poll();
            int secInd = temp.second;
            howMany[secInd]++;
            double inidiff = stations[secInd+1] - stations[secInd];
            double newSecLen = (double)inidiff / (howMany[secInd]+1);
            pq.add(new Pair(newSecLen, secInd));
        }
        return pq.peek().first;
    }
}
