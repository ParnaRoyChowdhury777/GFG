// User function Template for Java

class Solution {
    
    public int f(int mid, int n, int m) {
        long ans = 1;
        for(int i=1; i<=n; i++) {
            ans = ans*mid;
            if(ans > m) return 2;
        }
        if(ans == m) return 1;
        return 0;
    }
    
    public int nthRoot(int n, int m) {
        // code here
        int low = 1, high = m;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(f(mid, n, m) == 1) return mid;
            else if(f(mid, n, m) == 0) low = mid+1;
            else high = mid - 1;
        }
        return -1;
    }
}