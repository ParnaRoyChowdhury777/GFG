// User function Template for Java

class Solution {
    public int lower_bound(int temp[], int x) {
        int n = temp.length, ans = n;
        int low = 0, high = n - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(temp[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int rowWithMax1s(int arr[][]) {
        // code here
        int cntMax = 0, ind = -1;
        for(int i=0; i<arr.length; i++) {
            int cnt = arr[i].length - lower_bound(arr[i], 1);
            if(cnt > cntMax) {
                cntMax = cnt;
                ind = i;
            }
        }
        return ind;
    }
}