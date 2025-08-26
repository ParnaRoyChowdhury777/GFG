class Solution {
    
    public int min(int[][] mat, int col) {
        int n = mat.length, m = mat[0].length;
        int minElement = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(mat[i][col] < minElement) {
                minElement = mat[i][col];
            }
        }
        return minElement;
    }
    
    public int max(int[][] mat, int col) {
        int n = mat.length, m = mat[0].length;
        int maxElement = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(mat[i][col] > maxElement) {
                maxElement = mat[i][col];
            }
        }
        return maxElement;
    }
    
    public int upper_bound(int[] temp, int x) {
        int low = 0, high = temp.length - 1;
        int ans = temp.length;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(temp[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    } 
    
    public int func(int[][] mat, int x) {
        int cnt = 0;
        for(int i=0; i<mat.length; i++) {
            cnt += upper_bound(mat[i], x);
        }
        return cnt;
    }
    
    public int median(int[][] mat) {
        // code here
        int n = mat.length, m = mat[0].length, req = (n * m) / 2;
        int low = min(mat, 0), high = max(mat, m-1);
        while(low <= high) {
            int mid = (low + high) / 2;
            int countSmallerNos = func(mat, mid);
            if(countSmallerNos <= req) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}