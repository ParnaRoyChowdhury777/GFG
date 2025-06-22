// User function Template for Java
class Solution {
    public static boolean canWePlace(int[] stalls, int dist, int cows) {
        int cntCows = 1, last = stalls[0];
        for(int i=1; i<stalls.length; i++) {
            if(stalls[i] - last >= dist) {
                cntCows++;
                last = stalls[i];
            }
        }
        if(cntCows >= cows) return true;
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int low = 1, high = stalls[stalls.length - 1] - stalls[0];
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(canWePlace(stalls, mid, k) == true) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}