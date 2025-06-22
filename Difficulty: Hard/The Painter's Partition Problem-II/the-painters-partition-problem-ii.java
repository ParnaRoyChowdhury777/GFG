// User function Template for Java

class Solution {
    public int fun(int[] arr, int k) {
        int s=1, count=0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] + count <= k) {
                count += arr[i];
            }
            else {
                s++;
                count = arr[i];
            }
        }
        return s;
    }
    public int minTime(int[] arr, int k) {
        // code here
        int low = Integer.MIN_VALUE, high = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > low) {
                low = arr[i];
            }
            high += arr[i];
        }
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int cnt = fun(arr, mid);
            if(cnt > k) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
